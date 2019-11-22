/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import model.TbColaborador;
import model.TbDisciplina;
import model.TbEmpresa;
import model.TbFuncao;
import model.TbPessoa;
import model.TbQuestao;
import model.TbUsuario;
import model.TbUsuarioPerfil;
import model.VwColaboradorCorrecaoAtual;
import model.VwColaboradorPendente;
import model.VwColaboradorPendenteDiscrepancia;
import model.VwPessoaUsuario;
import model.VwUsuarioFuncionalidade;
import model.VwUsuarioPessoa;
import service.ColaboradorService;
import service.PessoaService;
import service.UsuarioPerfilService;
import service.UsuarioService;
import service.UsuarioXFuncionalidadeService;
import service.VwPessoaUsuarioService;
import service.VwUsuarioPessoaService;
import service.impl.BancaServiceImpl;
import service.impl.ColaboradorServiceImpl;
import service.impl.DisciplinaServiceImpl;
import service.impl.PessoaServiceImpl;
import service.impl.ProcessoServiceImpl;
import service.impl.TipoCorrecaoServiceImpl;
import service.impl.UsuarioPerfilServiceImpl;
import service.impl.UsuarioServiceImpl;
import service.impl.UsuarioXFuncionalidadeServiceImpl;
import service.impl.VwColaboradorCorrecaoAtualServiceImpl;
import service.impl.VwColaboradorPendenteDiscrepanciaServiceImpl;
import service.impl.VwColaboradorPendenteServiceImpl;
import service.impl.VwPessoaUsuarioServiceImpl;
import service.impl.VwUsuarioPessoaServiceImpl;
import util.MD5Hexa;
import util.Uteis;

/**
 *
 * @author Janio
 */
@ManagedBean(name = "Usuario")
@SessionScoped
public class UsuarioController extends BasicController {

    private boolean logado = false;
    private TbUsuario usuario = new TbUsuario();
    private TbPessoa inserirPessoa = new TbPessoa();
    private TbUsuario inserirUsuario = new TbUsuario();
    private int idEmpresa;
    private DataModel gridUsuarios;
    private String senha = null;
    private List<TbUsuario> listaUsuarios = new ArrayList<TbUsuario>();
    //public static final int ID_PROCESSO_ATUAL = 9;//Constante temporária a ser colocada ou no Login ou após o Login para o usuário escolher.
    //private TbProcesso processoAtual = new TbProcesso(ID_PROCESSO_ATUAL);
    TbColaborador colaboradorLogado = null;
    private TbDisciplina usuarioDisciplina = new TbDisciplina();
    private DataModel gridUsuarioPessoa;
    private Integer idUsuarioDisciplina;
    private boolean possuiPerfilAdministrador;
    
    public UsuarioController() {
        this.consultaGridUsuarioPessoa();
    }

    public String doLogin() {
        this.setLogado(false);
        TbUsuario consultar = new TbUsuario();
        consultar.setNmSenha(MD5Hexa.getMD5(this.getUsuario().getNmSenha()));
        consultar.setNmUsuario(this.getUsuario().getNmUsuario());
        consultar.setFlAtivo(true);
        UsuarioService us = new UsuarioServiceImpl();
        TbUsuario login = us.login(consultar);
        if (login != null) {
            this.setLogado(true);
            this.setUsuario(login);
            this.setMensagem("");
            this.setFuncionalidades(this.getFuncionalidadesUsuarioLogado());
            //Processo Seletivo
            //Verifica se usuário é colaborador Corretor:
            //ColaboradorService cs = new ColaboradorServiceImpl();
            //TbColaborador colaborador = cs.pesquisarPorCPFAtivo(this.getUsuario().getNrCpf());
            TbColaborador colaborador =null;
            TbUsuarioPerfil consultaPerfil = (new UsuarioPerfilServiceImpl() ).pesquisarPorIDUsuario(login.getIdUsuario());
            this.setPossuiPerfilAdministrador(false);
            if(consultaPerfil!=null){
                if(consultaPerfil.getTbPerfil().getIdPerfil().intValue()!=Uteis.PERFIL_ADMINISTRADOR){
                    this.setPossuiPerfilAdministrador(true);
                }
                
                if(consultaPerfil.getTbPerfil().getIdPerfil().intValue()!=Uteis.PERFIL_ADMINISTRADOR && 
                        consultaPerfil.getTbPerfil().getIdPerfil().intValue()!=Uteis.PERFIL_COORDENADOR_CORRECAO && 
                        consultaPerfil.getTbPerfil().getIdPerfil().intValue()!=Uteis.PERFIL_RELATORIO_CORRECAO_DETALHADA && 
                        consultaPerfil.getTbPerfil().getIdPerfil().intValue()!=Uteis.PERFIL_COORDENADOR_BANCA){
                    colaborador= buscaColaboradorAtual();
                }
            }else{
                colaborador= buscaColaboradorAtual();
            }
            
            if (colaborador == null) {
                colaborador = buscaProximoColaboradorPendente();
                if(colaborador==null){
                    //View muito pesada. Refatorar. Alterado em 26/06/2014
                    //colaborador= buscaProximoColaboradorPendenteDiscrepancia();
                    colaborador=buscaColaboradorAtivo();
                }
            }
            System.out.println("Colaborador atual: " + colaborador);
            this.setColaboradorLogado(colaborador);
            if (this.getUsuario().isFlPrimeiroAcesso()) {
                System.out.println("Primeiro acesso do usuário: " + this.getUsuario().getNmUsuario());
                return "/view/geral/alterarSenha.xhtml";
            }

            if (colaborador == null) {
                this.setMensagem("Não há correções pendentes.");
                return "/view/geral/principal.xhtml";
            } else {

                try {
                    TbUsuarioPerfil up = consultaPerfil;
                    if (up != null) {
                        if (up.getTbPerfil() != null) {
                            switch (up.getTbPerfil().getIdPerfil().intValue()) {
                                case Uteis.PERFIL_ADMINISTRADOR:
                                    return "/view/geral/principal.xhtml";
                                case Uteis.PERFIL_COORDENADOR_CORRECAO:
                                    return "/view/geral/principal.xhtml";
                                case Uteis.PERFIL_COORDENADOR_BANCA:
                                    return "/view/geral/principal.xhtml";
                                case Uteis.PERFIL_RELATORIO_CORRECAO_DETALHADA:
                                    return "/view/geral/principal.xhtml";
                                case Uteis.PERFIL_TESTAR_CORRECAO:
                                    return "/view/corretor/certificacao/seleciona_inscricao.xhtml";
                            }
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

                return this.paginaCorrecaoUsuarioAtual(colaborador);
            }
        }
        this.setMensagem("Usuário ou senha inválidos.");
        return "/view/geral/login.xhtml";
    }

    public String doExit() {
        this.setLogado(false);
        this.setUsuario(null);
        this.setFuncionalidades(null);
        Uteis.getSession().invalidate();
        return "/view/geral/login.xhtml";
    }

    public TbPessoa getInserirPessoa() {
        return inserirPessoa;
    }

    public void setInserirPessoa(TbPessoa inserirPessoa) {
        this.inserirPessoa = inserirPessoa;
    }

    public TbUsuario getInserirUsuario() {
        return inserirUsuario;
    }

    public void setInserirUsuario(TbUsuario inserirUsuario) {
        this.inserirUsuario = inserirUsuario;
    }

    public DataModel getGridUsuarios() {
        this.getListaTodosUsuarios();
        return gridUsuarios;
    }

    public void setGridUsuarios(DataModel gridUsuarios) {
        this.gridUsuarios = gridUsuarios;
    }
    private List<VwUsuarioFuncionalidade> funcionalidades;

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public TbUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(TbUsuario usuario) {
        this.usuario = usuario;
    }

    public List<VwUsuarioFuncionalidade> getFuncionalidades() {
        return funcionalidades;
    }

    public void setFuncionalidades(List<VwUsuarioFuncionalidade> funcionalidades) {
        this.funcionalidades = funcionalidades;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<TbUsuario> getListaUsuarios() {
        UsuarioService us = new UsuarioServiceImpl();
        this.listaUsuarios = us.pesquisarAtivos();
        return listaUsuarios;
    }

    public void setListaUsuarios(List<TbUsuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    private List<VwUsuarioFuncionalidade> getFuncionalidadesUsuarioLogado() {
        List retorno = null;
        UsuarioXFuncionalidadeService uf = new UsuarioXFuncionalidadeServiceImpl();
        retorno = null;
        retorno = uf.getFuncionalidadesPorUsuarioById(this.getUsuario().getIdUsuario());
        //System.out.println("tamanho da lista: " + retorno.size());
        return retorno;
    }

    public boolean confereSenha() {
        boolean ok = false;
        this.setMensagem("");
        if (this.inserirUsuario.getNmSenha().equals(this.senha)) {
            ok = true;
        } else {
            this.setMensagem("Erro ao cadastrar senha");
        }
        return ok;
    }

    public String insereUsuario() {
        UsuarioService us = new UsuarioServiceImpl();
        PessoaService ps = new PessoaServiceImpl();
        this.getInserirPessoa().setIdEmpresa(new TbEmpresa(this.getIdEmpresa()));

        TbDisciplina discSelecionada = null;

        if (this.getUsuarioDisciplina() != null && this.getUsuarioDisciplina().getIdDisciplina() != null && this.getUsuarioDisciplina().getIdDisciplina().intValue() > 0) {
            discSelecionada = (new DisciplinaServiceImpl()).pesquisarPorID(this.getUsuarioDisciplina().getIdDisciplina().intValue());
        }

        this.getInserirUsuario().setIdDisciplina(discSelecionada);

        if (us.pesquisarPorUsuario(this.getInserirUsuario()) != null) {
            this.setMensagem("Este usuário já existe.");
            return "/view/admin/cadastro/usuario.xhtml";
        }
        if (ps.pesquisarPorCpf(this.getInserirPessoa()) != null) {
            this.setMensagem("CPF já cadastrado.");
            return "/view/admin/cadastro/usuario.xhtml";
        }
        if (!(confereSenha())) {
            this.setMensagem("As senhas não conferem!");
            return "/view/admin/cadastro/usuario.xhtml";
        }

        TbPessoa pessoa = ps.inserir(this.getInserirPessoa());
        inserirUsuario.setNrCpf(this.getInserirPessoa().getNrCpf());

        this.getInserirUsuario().setNmSenha(MD5Hexa.getMD5(this.getInserirUsuario().getNmSenha()));
        TbUsuario user = us.inserir(this.getInserirUsuario());
        this.setMensagem("Erro ao inserir usuário.");

        if (user != null && pessoa != null) {
            this.setMensagem("Usuário inserido com sucesso.");
        }
        this.inserirPessoa = new TbPessoa();
        this.inserirUsuario = new TbUsuario();
        this.usuarioDisciplina = new TbDisciplina();
        return "/view/admin/cadastro/usuario.xhtml";

    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public void getListaTodosUsuarios() {
        //UsuarioService us = new UsuarioServiceImpl();
        VwPessoaUsuarioService vpu = new VwPessoaUsuarioServiceImpl();
        //this.gridUsuarios = new ListDataModel(vpu.pesquisarAtivos());
        this.gridUsuarios = new ListDataModel(vpu.pesquisarTodos());
    }

    public String apaga() {

        UsuarioService us = new UsuarioServiceImpl();
        PessoaService ps = new PessoaServiceImpl();
        UsuarioPerfilService ups = new UsuarioPerfilServiceImpl();
        ColaboradorService cs = new ColaboradorServiceImpl();


        VwPessoaUsuario selecionada = (VwPessoaUsuario) gridUsuarios.getRowData();

        TbPessoa pessoa = ps.pesquisarPorCpf(new TbPessoa(selecionada.getNrCpf()));
        TbUsuario user = us.pesquisarPorIDLong(selecionada.getIdUsuario().longValue());

        TbUsuarioPerfil usuarioPerfil = ups.pesquisarPorIDUsuario(selecionada.getIdUsuario().longValue());
        TbColaborador colaborador = cs.pesquisarPorCPF(selecionada.getNrCpf());

        if (usuarioPerfil != null || colaborador != null) {
            JOptionPane.showMessageDialog(null, "Esse usuário não pode ser excluido! ");
            return "/view/admin/cadastro/usuario.xhtml";
        }

        us.apagar(user);
        ps.apagar(pessoa);

        this.getListaTodosUsuarios();
        return "/view/admin/cadastro/usuario.xhtml";
    }

    public String prepararAlterar() {
        this.setMensagem("");
        PessoaService ps = new PessoaServiceImpl();
        UsuarioService us = new UsuarioServiceImpl();
        VwPessoaUsuario selecionada = (VwPessoaUsuario) this.gridUsuarios.getRowData();
        TbPessoa pessoa = ps.pesquisarPorCpf(new TbPessoa(selecionada.getNrCpf()));
        TbUsuario user = us.pesquisarPorIDLong(selecionada.getIdUsuario().longValue());
        this.idEmpresa = selecionada.getIdEmpresa();
        this.inserirPessoa = pessoa;
        this.inserirUsuario = user;
        if (this.inserirUsuario.getIdDisciplina() == null) {
            this.inserirUsuario.setIdDisciplina(new TbDisciplina());
        }
        return "/view/admin/altera/usuario.xhtml";

    }

    public String gravaAlteracao() {
        UsuarioService us = new UsuarioServiceImpl();
        PessoaService ps = new PessoaServiceImpl();
        if (!(confereSenha())) {
            this.setMensagem("As senhas não conferem!");
            return "/view/admin/altera/usuario.xhtml";
        }
        this.getInserirPessoa().setIdEmpresa(new TbEmpresa(this.getIdEmpresa()));

        this.inserirUsuario.setNmSenha(MD5Hexa.getMD5(this.inserirUsuario.getNmSenha()));

        ps.atualizar(this.inserirPessoa);
        us.atualizar(this.inserirUsuario);

        this.getListaTodosUsuarios();
        this.setMensagem("Usuário alterado com sucesso.");
        this.inserirUsuario = new TbUsuario();
        this.inserirPessoa = new TbPessoa();
        return "/view/admin/cadastro/usuario.xhtml";
    }

    public static UsuarioController getInstance() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Object temp = session.getAttribute("Usuario");
        if (temp instanceof UsuarioController) {
            UsuarioController pc = (UsuarioController) temp;
            return pc;
        }
        return null;
    }

    public TbColaborador getColaboradorLogado() {
        return colaboradorLogado;
    }

    public void setColaboradorLogado(TbColaborador colaboradorLogado) {
        this.colaboradorLogado = colaboradorLogado;
    }

    public String getSessionRemainingTime() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession sessao = (HttpSession) fc.getExternalContext().getSession(true);
        return String.valueOf(sessao.getMaxInactiveInterval());
    }

    public String alterarSenhaUsuarioAtual() {
        UsuarioService us = new UsuarioServiceImpl();
        if (confereSenhaAlterarSenha()) {
            this.getUsuario().setNmSenha(MD5Hexa.getMD5(this.getUsuario().getNmSenha()));
            this.getUsuario().setFlPrimeiroAcesso(false);
            us.atualizar(this.getUsuario());
            this.doExit();
            this.setSenha("");
            this.setMensagem("Senha alterada com sucesso. Entre novamente no sistema. ");
            return "/view/geral/login.xhtml";

        }
        this.setSenha("");
        //return "/view/geral/principal.xhtml";
        return "/view/geral/alterarSenha.xhtml";
    }

    public boolean confereSenhaAlterarSenha() {
        boolean ok = false;
        this.setMensagem("");
        if (this.getUsuario().getNmSenha().equals(this.getUsuario().getNrCpf())) {
            this.setMensagem("Esta senha já foi usada. Favor criar uma senha diferente.");        
            return false;
        }
        if (this.getUsuario().getNmSenha().equals(this.senha)) {
            ok = true;
        } else {
            this.setMensagem("Senha não confere. Favor recadastrá-la");
        }
        return ok;
    }

    public TbDisciplina getUsuarioDisciplina() {
        return usuarioDisciplina;
    }

    public void setUsuarioDisciplina(TbDisciplina usuarioDisciplina) {
        this.usuarioDisciplina = usuarioDisciplina;
    }

    public DataModel getGridUsuarioPessoa() {
        return gridUsuarioPessoa;
    }

    public final void consultaGridUsuarioPessoa() {
        VwUsuarioPessoaService wups = new VwUsuarioPessoaServiceImpl();
        this.gridUsuarioPessoa = new ListDataModel(wups.pesquisarTodosOrdenado());
    }

    public void setGridUsuarioPessoa(DataModel gridUsuarioPessoa) {
        this.gridUsuarioPessoa = gridUsuarioPessoa;
    }

    public Integer getIdUsuarioDisciplina() {
        return idUsuarioDisciplina;
    }

    public void setIdUsuarioDisciplina(Integer idUsuarioDisciplina) {
        this.idUsuarioDisciplina = idUsuarioDisciplina;
    }

    public void selecionaDisciplina() {
        if (this.gridUsuarioPessoa.isRowAvailable()) {
            VwUsuarioPessoa selecionada = (VwUsuarioPessoa) this.gridUsuarioPessoa.getRowData();
            UsuarioService us = new UsuarioServiceImpl();
            TbUsuario usuarioAtual = us.pesquisarPorIDLong(selecionada.getIdUsuario().longValue());
            if (selecionada.getIdDisciplina() == null || selecionada.getIdDisciplina() == 0) {
                usuarioAtual.setIdDisciplina(null);
            } else {
                usuarioAtual.setIdDisciplina(new TbDisciplina(selecionada.getIdDisciplina()));
            }
            us.atualizar(usuarioAtual);


        }
    }

    private TbColaborador converteVwColaboradorTbColaborador(VwColaboradorPendente converter) {
        TbColaborador retorno = new TbColaborador();
        if (converter != null) {

            retorno.setFlAtivo(retorno.getFlAtivo());
            retorno.setIdBanca((new BancaServiceImpl()).pesquisarPorID(converter.getIdBanca()));
            retorno.setIdColaborador(converter.getIdColaborador().longValue());
            retorno.setIdFuncao(new TbFuncao(converter.getIdFuncao()));
            retorno.setIdProcesso((new ProcessoServiceImpl()).pesquisarPorID(converter.getIdProcesso()));
            retorno.setIdQuestao(new TbQuestao(converter.getIdQuestao()));
            retorno.setIdTipoCorrecao((new TipoCorrecaoServiceImpl()).pesquisarPorID(converter.getIdTipoCorrecao()));
            retorno.setNrCpf((new PessoaServiceImpl()).pesquisarPorCpf(new TbPessoa(converter.getNrCpf())));
            return retorno;
        }
        return null;
    }

    private TbColaborador converteVwColaboradorTbColaborador(VwColaboradorPendenteDiscrepancia converter) {
        TbColaborador retorno = new TbColaborador();
        if (converter != null) {
            retorno.setFlAtivo(retorno.getFlAtivo());
            retorno.setIdBanca((new BancaServiceImpl()).pesquisarPorID(converter.getIdBanca()));
            retorno.setIdColaborador(converter.getIdColaborador().longValue());
            retorno.setIdFuncao(new TbFuncao(converter.getIdFuncao()));
            retorno.setIdProcesso((new ProcessoServiceImpl()).pesquisarPorID(converter.getIdProcesso()));
            retorno.setIdQuestao(new TbQuestao(converter.getIdQuestao()));
            retorno.setIdTipoCorrecao((new TipoCorrecaoServiceImpl()).pesquisarPorID(converter.getIdTipoCorrecao()));
            retorno.setNrCpf((new PessoaServiceImpl()).pesquisarPorCpf(new TbPessoa(converter.getNrCpf())));
            return retorno;
        }
        return null;
    }

    private TbColaborador buscaColaboradorAtual() {
        String nrCpf = this.getUsuario().getNrCpf();
        VwColaboradorCorrecaoAtual colaboradorPendente = (new VwColaboradorCorrecaoAtualServiceImpl()).pesquisarPorCPFAtivo(nrCpf);
        TbColaborador colaborador = this.converteVwColaboradorTbColaborador(colaboradorPendente);
        return colaborador;
    }

    private TbColaborador buscaColaboradorAtivo() {
        String nrCpf = this.getUsuario().getNrCpf();
        TbColaborador colaborador = new ColaboradorServiceImpl().pesquisarPorCPFAtivo(nrCpf);;
        return colaborador;
    }

    private TbColaborador buscaProximoColaboradorPendente() {
        String nrCpf = this.getUsuario().getNrCpf();
        
        VwColaboradorPendente colaboradorPendente = (new VwColaboradorPendenteServiceImpl()).pesquisarPorCPFAtivo(nrCpf);
        TbColaborador colaborador = this.converteVwColaboradorTbColaborador(colaboradorPendente);
        
        //TbColaborador colaborador = new ColaboradorServiceImpl().pesquisarPorCPFAtivo(nrCpf);
        return colaborador;
    }

    private TbColaborador buscaProximoColaboradorPendenteDiscrepancia() {
        String nrCpf = this.getUsuario().getNrCpf();
        VwColaboradorPendenteDiscrepancia colaboradorPendente = (new VwColaboradorPendenteDiscrepanciaServiceImpl()).pesquisarPorCPFAtivo(nrCpf);
        TbColaborador colaborador = this.converteVwColaboradorTbColaborador(colaboradorPendente);
        return colaborador;
    }

    public TbColaborador carregaProximoColaboradorPendente() {
        TbColaborador col = buscaProximoColaboradorPendente();
        this.setColaboradorLogado(col);
        return col;
    }

    public TbColaborador carregaProximoColaboradorPendenteDiscrepancia() {
        TbColaborador col = buscaProximoColaboradorPendenteDiscrepancia();
        this.setColaboradorLogado(col);
        return col;
    }

    private TbColaborador converteVwColaboradorTbColaborador(VwColaboradorCorrecaoAtual converter) {
        TbColaborador retorno = new TbColaborador();
        if (converter != null) {

            retorno.setFlAtivo(retorno.getFlAtivo());
            retorno.setIdBanca((new BancaServiceImpl()).pesquisarPorID(converter.getIdBanca()));
            retorno.setIdColaborador(converter.getIdColaborador().longValue());
            retorno.setIdFuncao(new TbFuncao(converter.getIdFuncao()));
            retorno.setIdProcesso((new ProcessoServiceImpl()).pesquisarPorID(converter.getIdProcesso()));
            retorno.setIdQuestao(new TbQuestao(converter.getIdQuestao()));
            retorno.setIdTipoCorrecao((new TipoCorrecaoServiceImpl()).pesquisarPorID(converter.getIdTipoCorrecao()));
            retorno.setNrCpf((new PessoaServiceImpl()).pesquisarPorCpf(new TbPessoa(converter.getNrCpf())));
            return retorno;
        }
        return null;
    }

    public String paginaCorrecaoUsuarioAtual(TbColaborador colaborador) {
        try {
            if (colaborador.getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DISCURSIVA) {
                System.out.println("USUÁRIO DISCURSIVA");
                return "/view/corretor/discursiva/correcao.xhtml";
            } else if (colaborador.getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO) {
                System.out.println("USUÁRIO REDAÇÃO");
                return "/view/corretor/redacao/corretor.xhtml";
            } else if (colaborador.getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA_TRADUCAO_ESTILO_REDACAO) {
                System.out.println("USUÁRIO REDAÇÃO");
                return "/view/corretor/redacao/corretor.xhtml";
            } else if (colaborador.getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA) {
                if ( (colaborador.getIdBanca().getIdDisciplina().getIdDisciplina().intValue() == Uteis.ID_DISCIPLINA_ARQUITETURA_URBANISMO) 
                        || (colaborador.getIdBanca().getIdDisciplina().getIdDisciplina().intValue() == Uteis.ID_DISCIPLINA_ARQUITETURA_URBANISMO_TRANSFERENCIA)
                        || (colaborador.getIdBanca().getIdDisciplina().getIdDisciplina().intValue() == Uteis.ID_DISCIPLINA_DESIGN_INTERIORES)) {
                    //System.out.println("Usuário Arquitetura e Urbanismo");
                    return "/view/corretor/arquitetura/correcao.xhtml";
                } else {
                    System.out.println("Usuário HE normal");
                    //return "/view/corretor/certificacao/correcao.xhtml";
                    return "/view/corretor/certificacao/todas_provas.xhtml";
                }
            } else if (colaborador.getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE) {
                System.out.println("USUÁRIO CORRETOR DE PROVA DE DOCENTE - "+colaborador.getIdColaborador());
                return "/view/corretor/docentes/correcao.xhtml";
            } else if (colaborador.getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA) {
                System.out.println("Usuário corretor de prova de TEATRO_DANCA_MUSICA");
                return "/view/corretor/teatrodancamusica/correcao.xhtml";
                //return "/view/corretor/teatrodancamusica/correcao.xhtml";
            } else {
                this.setMensagem("Usuário sem acesso. Acesso não identificado. Favor verificar com o Administrador.");
                return "/view/geral/login.xhtml";
            }
        } catch (Exception ex) {
            return "";
        }
    }

    public boolean isPossuiPerfilAdministrador() {
        return possuiPerfilAdministrador;
    }

    public void setPossuiPerfilAdministrador(boolean possuiPerfilAdministrador) {
        this.possuiPerfilAdministrador = possuiPerfilAdministrador;
    }
    
}
