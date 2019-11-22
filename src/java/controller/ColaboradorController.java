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
import model.TbBanca;
import model.TbColaborador;
import model.TbCurso;
import model.TbEmpresa;
import model.TbFuncao;
import model.TbPessoa;
import model.TbProcesso;
import model.TbQuestao;
import model.TbTipoCorrecao;
import model.VwPessoaColaborador;
import service.BancaService;
import service.ColaboradorService;
import service.PessoaService;
import service.VwPessoaColaboradorService;
import service.impl.BancaServiceImpl;
import service.impl.ColaboradorServiceImpl;
import service.impl.PessoaServiceImpl;
import service.impl.ProcessoServiceImpl;
import service.impl.VwPessoaColaboradorServiceImpl;

/**
 *
 * @author KAMYLLA
 */
@ManagedBean(name = "Colaborador")
@SessionScoped
public final class ColaboradorController extends BasicController {

    private TbColaborador inserirColaborador = new TbColaborador();
    private TbPessoa inserirPessoa = new TbPessoa();
    private DataModel gridColaboradores;
    private int idProcesso;
    private int idBanca;
    private int idFuncao;
    private int idTipoCorrecao;
    private int idEmpresa;
    private int idQuestao;
    private TbPessoa pessoaSelecionada = new TbPessoa();
    private List<TbProcesso> listaProcessos = null;
    private List<TbColaborador> listaColaboradores = new ArrayList<TbColaborador>();
    private List<VwPessoaColaborador> listaPessoaColaborador = new ArrayList<VwPessoaColaborador>();
    private TbProcesso processoSelecionado = new TbProcesso();
    private TbCurso cursoSelecionado = new TbCurso();
    private TbColaborador colaboradorSelecionado = new TbColaborador();
    private boolean bolExistemColaboradoresCadastrados = false;
    private String nrCpfFiltro;
    private int idCursoFiltro=-1;
    private int idProcessoFiltro;
    private int idDisciplinaFiltro;
    
    private DataModel gridColaboradorBanca;
    public ColaboradorController() {
        this.getListaProcessos();
        this.getListaTodos();
        this.getListaTodosColaboradores();
        this.consultaColaboradorBanca();
    }

    public TbColaborador getInserirColaborador() {
        return inserirColaborador;
    }

    public void setInserirColaborador(TbColaborador inserirColaborador) {
        this.inserirColaborador = inserirColaborador;
    }

    public TbPessoa getInserirPessoa() {
        return inserirPessoa;
    }

    public void setInserirPessoa(TbPessoa inserirPessoa) {
        this.inserirPessoa = inserirPessoa;
    }

    public int getIdBanca() {
        return idBanca;
    }

    public void setIdBanca(int idBanca) {
        this.idBanca = idBanca;
    }

    public TbCurso getCursoSelecionado() {
        return cursoSelecionado;
    }

    public void setCursoSelecionado(TbCurso cursoSelecionado) {
        this.cursoSelecionado = cursoSelecionado;
    }
    
    

    public int getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(int idQuestao) {
        this.idQuestao = idQuestao;
    }

    public int getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(int idFuncao) {
        this.idFuncao = idFuncao;
    }

    public int getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(int idProcesso) {
        this.idProcesso = idProcesso;
    }

    public int getIdTipoCorrecao() {
        return idTipoCorrecao;
    }

    public void setIdTipoCorrecao(int idTipoCorrecao) {
        this.idTipoCorrecao = idTipoCorrecao;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public List<VwPessoaColaborador> getListaPessoaColaborador() {
        VwPessoaColaboradorService wpc = new VwPessoaColaboradorServiceImpl();
        listaPessoaColaborador = wpc.pesquisarTodosOrdenado();
        return listaPessoaColaborador;
    }

    public void setListaPessoaColaborador(List<VwPessoaColaborador> listaPessoaColaborador) {
        this.listaPessoaColaborador = listaPessoaColaborador;
    }
    
    

    public TbColaborador getColaboradorSelecionado() {
        return colaboradorSelecionado;
    }

    public void setColaboradorSelecionado(TbColaborador colaboradorSelecionado) {
        this.colaboradorSelecionado = colaboradorSelecionado;
    }
    

    public DataModel getGridColaboradores() {
        return gridColaboradores;
    }

    public void setGridColaboradores(DataModel gridColaboradores) {
        this.gridColaboradores = gridColaboradores;
    }

    public List<TbColaborador> getListaColaboradores() {
        return listaColaboradores;
    }

    public void setListaColaboradores(List<TbColaborador> listaColaboradores) {
        this.listaColaboradores = listaColaboradores;
    }

  
    
    

    public String insereColaborador() {
        ColaboradorService cs = new ColaboradorServiceImpl();
        PessoaService ps = new PessoaServiceImpl();

        this.getInserirColaborador().setIdBanca(new TbBanca(this.getIdBanca()));
        this.getInserirColaborador().setIdFuncao(new TbFuncao(this.getIdFuncao()));
        this.getInserirColaborador().setIdProcesso(new TbProcesso(this.getIdProcesso()));
        this.getInserirColaborador().setIdTipoCorrecao(new TbTipoCorrecao(this.getIdTipoCorrecao()));
        this.getInserirColaborador().setIdQuestao(new TbQuestao(this.getIdQuestao()));
        this.getInserirColaborador().setFlAtivo(true);

        TbPessoa consulta = (new PessoaServiceImpl()).pesquisarPorCpf(this.getPessoaSelecionada());

        this.getInserirColaborador().setNrCpf(consulta);

        TbColaborador colaborador = cs.inserir(this.getInserirColaborador());
        this.setMensagem("Erro ao inserir Colaborador.");
        if (colaborador != null) {
            this.setMensagem("Colaborador inserido com sucesso.");
        }
        this.getListaTodosColaboradores();
        this.inserirPessoa = new TbPessoa();
        this.inserirColaborador = new TbColaborador();
        return "/view/admin/cadastro/colaborador.xhtml";
    }

    public String insereColaboradorOLD() {
        ColaboradorService cs = new ColaboradorServiceImpl();
        PessoaService ps = new PessoaServiceImpl();

        this.getInserirPessoa().setIdEmpresa(new TbEmpresa(this.getIdEmpresa()));
        if (ps.pesquisarPorCpf(this.getInserirPessoa()) != null) {
            this.setMensagem("CPF já cadastrado!");
            return "/view/admin/cadastro/colaborador.xhtml";
        }
        TbPessoa pessoa = ps.inserir(inserirPessoa);

        this.getInserirColaborador().setIdBanca(new TbBanca(this.getIdBanca()));
        this.getInserirColaborador().setIdFuncao(new TbFuncao(this.getIdFuncao()));
        this.getInserirColaborador().setIdProcesso(new TbProcesso(this.getIdProcesso()));
        this.getInserirColaborador().setIdTipoCorrecao(new TbTipoCorrecao(this.getIdTipoCorrecao()));
        this.getInserirColaborador().setNrCpf(pessoa);

        TbColaborador colaborador = cs.inserir(this.getInserirColaborador());
        this.setMensagem("Erro ao inserir Colaborador.");
        if (colaborador != null) {
            this.setMensagem("Colaborador inserido com sucesso.");
        }
        this.inserirPessoa = new TbPessoa();
        this.inserirColaborador = new TbColaborador();
        return "/view/admin/cadastro/colaborador.xhtml";
    }

    public String gravaAlteracao() {
        ColaboradorService cs = new ColaboradorServiceImpl();
        PessoaService ps = new PessoaServiceImpl();

        this.getInserirColaborador().setNrCpf(this.getInserirPessoa());
        this.getInserirPessoa().setIdEmpresa(new TbEmpresa(this.getIdEmpresa()));
        this.getInserirColaborador().setIdBanca(new TbBanca(this.getIdBanca()));
        this.getInserirColaborador().setIdFuncao(new TbFuncao(this.getIdFuncao()));
        this.getInserirColaborador().setIdProcesso(new TbProcesso(this.getIdProcesso()));
        this.getInserirColaborador().setIdTipoCorrecao(new TbTipoCorrecao(this.getIdTipoCorrecao()));
        this.getInserirColaborador().setIdQuestao(new TbQuestao(this.getIdQuestao()));

        ps.atualizar(this.inserirPessoa);
        cs.atualizar(this.inserirColaborador);

        this.getListaTodosColaboradores();
        this.setMensagem("Colaborador alterado com sucesso.");
        this.inserirPessoa = new TbPessoa();
        this.inserirColaborador = new TbColaborador();
        return "/view/admin/cadastro/colaborador.xhtml";
    }

    public String prepararAlterar() {
        this.setMensagem("");
        if (this.gridColaboradores.isRowAvailable()) {
            VwPessoaColaborador selecionada = (VwPessoaColaborador) this.gridColaboradores.getRowData();

            PessoaService ps = new PessoaServiceImpl();
            ColaboradorService cs = new ColaboradorServiceImpl();

            this.idTipoCorrecao = selecionada.getIdTipoCorrecao();
            this.idBanca = selecionada.getIdBanca();
            this.idProcesso = selecionada.getIdProcesso();
            this.idFuncao = selecionada.getIdFuncao();
            this.idEmpresa = selecionada.getIdEmpresa();
            if (selecionada != null && selecionada.getIdQuestao() != null) {
                this.idQuestao = selecionada.getIdQuestao();
            }
            this.pessoaSelecionada.setNrCpf(selecionada.getNrCpf());


            this.inserirPessoa = ps.pesquisarPorCpf(new TbPessoa(selecionada.getNrCpf()));
            //this.inserirColaborador = cs.pesquisarPorCPFeProcesso(selecionada.getNrCpf(), selecionada.getIdProcesso());
            //TbProcesso procurarProcesso = (new ProcessoServiceImpl()).pesquisarPorID(selecionada.getIdProcesso());
            this.inserirColaborador = cs.pesquisarPorIDLong(selecionada.getIdColaborador().longValue());
            if (this.inserirColaborador != null) {
                //System.out.println("Colaborador: " + this.inserirColaborador);
            }
        }
        return "/view/admin/altera/colaborador.xhtml";
    }

    public void getListaTodos() {
        VwPessoaColaboradorService vpc = new VwPessoaColaboradorServiceImpl();
        this.listaPessoaColaborador = vpc.pesquisarTodosOrdenado();
        this.gridColaboradores = new ListDataModel(listaPessoaColaborador);

    }

    public void getListaTodosColaboradores() {
        VwPessoaColaboradorService vpc = new VwPessoaColaboradorServiceImpl();
        List<VwPessoaColaborador> vwpc = null;
        if (this.getProcessoSelecionado() != null && this.getProcessoSelecionado().getIdProcesso() != null && this.getProcessoSelecionado().getIdProcesso().intValue() != 0) {
            vwpc = vpc.pesquisarAtivosPorProcesso(this.getProcessoSelecionado().getIdProcesso().intValue());
        } else {
            vwpc = vpc.pesquisarTodosOrdenado();
        }
        this.setBolExistemColaboradoresCadastrados(vwpc != null && vwpc.size() > 0);
        this.gridColaboradores = new ListDataModel(vwpc);
    }

    public String excluirColaborador() {
        TbColaborador selecionada = (TbColaborador) this.gridColaboradores.getRowData();
        TbColaborador nova = new TbColaborador();
        TbPessoa novaPessoa = new TbPessoa();
        nova.setIdColaborador(selecionada.getIdColaborador());
        nova.setNrCpf(selecionada.getNrCpf());
        novaPessoa.setNrCpf(selecionada.getNrCpf().getNrCpf());
        //novaPessoa.setNmColaborador(selecionada.getNrCpf());
        (new ColaboradorServiceImpl()).apagar(nova);
        (new PessoaServiceImpl()).apagar(novaPessoa);
        return "/view/admin/cadastro/disciplinas.xhtml";
    }

    public TbPessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(TbPessoa pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }

    public List<TbPessoa> getListaPessoasCadastradas() {
        return (new PessoaServiceImpl()).pesquisarTodosOrdenado();
    }

    public List<TbProcesso> getListaProcessos() {
        //if(this.listaProcessos==null){
        this.listaProcessos = (new ProcessoServiceImpl()).pesquisarTodosOrdenado();
        //if(this.listaProcessos!=null && this.listaProcessos.size()>0)this.processoSelecionado=this.listaProcessos.get(0);
        //}
        return listaProcessos;
    }

    public void setListaProcessos(List<TbProcesso> listaProcessos) {
        this.listaProcessos = listaProcessos;
    }

    public TbProcesso getProcessoSelecionado() {
        return processoSelecionado;
    }

    public void setProcessoSelecionado(TbProcesso processoSelecionado) {
        this.processoSelecionado = processoSelecionado;
    }

    public void selecionouProcesso() {

        this.getListaTodosPorFiltro();
    }
    
    public void selecionouCurso(){
        this.getListaTodosPorFiltro();
    }
    
    public void selecionouColaborador(){
        this.getListaTodosPorFiltro();
    }

    public void selecionouDisciplina(){
        this.getListaTodosPorFiltro();
    }
    
    public void getListaTodosPorFiltro() {
        VwPessoaColaboradorService vpc = new VwPessoaColaboradorServiceImpl();
        List<VwPessoaColaborador> vwpc = null;
        vwpc = vpc.pesquisarPorPessoaCursoProcesso(this.nrCpfFiltro, this.idCursoFiltro, this.idProcessoFiltro,this.idDisciplinaFiltro);
        this.gridColaboradores = new ListDataModel(vwpc);
    }
    
    public boolean isBolExistemColaboradoresCadastrados() {
        return bolExistemColaboradoresCadastrados;
    }

    public void setBolExistemColaboradoresCadastrados(boolean bolExistemColaboradoresCadastrados) {
        this.bolExistemColaboradoresCadastrados = bolExistemColaboradoresCadastrados;
    }

    public int getIdCursoFiltro() {
        return idCursoFiltro;
    }

    public void setIdCursoFiltro(int idCursoFiltro) {
        this.idCursoFiltro = idCursoFiltro;
    }

    public int getIdProcessoFiltro() {
        return idProcessoFiltro;
    }

    public void setIdProcessoFiltro(int idProcessoFiltro) {
        this.idProcessoFiltro = idProcessoFiltro;
    }

    public String getNrCpfFiltro() {
        return nrCpfFiltro;
    }

    public void setNrCpfFiltro(String nrCpfFiltro) {
        this.nrCpfFiltro = nrCpfFiltro;
    }
    
 
    public void ativaDesativaColaborador() {
        this.setMensagem("");
        if (this.gridColaboradores.isRowAvailable()) {
            VwPessoaColaborador selecionada = (VwPessoaColaborador) this.gridColaboradores.getRowData();

            ColaboradorService cs = new ColaboradorServiceImpl();

            TbColaborador colAtual = cs.pesquisarPorIDLong(selecionada.getIdColaborador().longValue());
            
            colAtual.setFlAtivo(selecionada.getFlAtivo());
            
            cs.atualizar(colAtual);
            
            this.setMensagem("Colaborador "+(selecionada.getFlAtivo() ? "ativado" : "desativado" )+" com sucesso.");
        }
    }

    public DataModel getGridColaboradorBanca() {
        return gridColaboradorBanca;
    }

    public void setGridColaboradorBanca(DataModel gridColaboradorBanca) {
        this.gridColaboradorBanca = gridColaboradorBanca;
    }
    
    public void consultaColaboradorBanca(){
        VwPessoaColaboradorService vpc = new VwPessoaColaboradorServiceImpl();
        this.gridColaboradorBanca = new ListDataModel(vpc.pesquisarTodosOrdenado());
    }
    
    
    public void selecionaBanca(){
           if(this.gridColaboradorBanca.isRowAvailable()){
            VwPessoaColaborador selecionada = (VwPessoaColaborador) this.gridColaboradorBanca.getRowData();
            int teste = selecionada.getIdBanca();
            ColaboradorService cs = new ColaboradorServiceImpl();
            BancaService bs = new BancaServiceImpl();
            TbColaborador colaboradorAtual = cs.pesquisarPorIDLong(selecionada.getIdColaborador().longValue());
            
            if(selecionada.getIdBanca()==null || selecionada.getIdDisciplina()==0){
                colaboradorAtual.setIdBanca(null);
            }else{
                TbBanca bancaAtual = bs.pesquisarPorID(selecionada.getIdBanca());
                colaboradorAtual.setIdBanca(bancaAtual);
              
            }
            cs.atualizar(colaboradorAtual);
           }
            
        
    }
    
    public static ColaboradorController getInstance() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Object temp = session.getAttribute("Colaborador");
        if (temp instanceof ColaboradorController) {
            ColaboradorController cc = (ColaboradorController) temp;
            return cc;
        }
        return null;
    }

    public int getIdDisciplinaFiltro() {
        return idDisciplinaFiltro;
    }

    public void setIdDisciplinaFiltro(int idDisciplinaFiltro) {
        this.idDisciplinaFiltro = idDisciplinaFiltro;
    }
    
    
}