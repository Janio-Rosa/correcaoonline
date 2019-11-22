/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.rel;

import controller.BasicController;
import controller.ProcessoController;
import controller.UsuarioController;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.TbCategoriaCriterioComPerda;
import model.TbColaborador;
import model.TbCorrecao;
import model.TbCorrecaoCriterio;
import model.TbDisciplina;
import model.TbPessoa;
import model.TbProcesso;
import model.TbResposta;
import model.TbUsuarioPerfil;
import model.VwConsolidadoGeralCorrecao;
import model.VwConsolidadoGeralCorrecaoDisciplina;
import model.VwCorretorDisciplinaProcesso;
import model.VwCriterioComCorrecaoCriterio;
import model.VwProcessoCurso;
import model.VwProcessoDisciplina;
import model.VwProcessoDisciplinaCorretor;
import model.VwRelatorioNotas;
import model.VwRespostaCorrecao;
import model.VwRespostaImagem;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import service.CorrecaoService;
import service.RespostaService;
import service.VwConfereDiscrepanciaService;
import service.VwConsolidadoGeralCorrecaoDisciplinaQuestaoService;
import service.VwConsolidadoGeralCorrecaoDisciplinaService;
import service.VwConsolidadoGeralCorrecaoService;
import service.VwCorretorDisciplinaProcessoService;
import service.VwProcessoCursoService;
import service.VwProcessoDisciplinaCorretorService;
import service.VwProcessoDisciplinaService;
import service.VwRelatorioNotasService;
import service.VwRespostaCorrecaoService;
import service.impl.ColaboradorServiceImpl;
import service.impl.CorrecaoCriterioServiceImpl;
import service.impl.CorrecaoServiceImpl;
import service.impl.DisciplinaServiceImpl;
import service.impl.PessoaServiceImpl;
import service.impl.RespostaServiceImpl;
import service.impl.UsuarioPerfilServiceImpl;
import service.impl.VwConfereDiscrepanciaServiceImpl;
import service.impl.VwConsolidadoGeralCorrecaoDisciplinaQuestaoServiceImpl;
import service.impl.VwConsolidadoGeralCorrecaoDisciplinaServiceImpl;
import service.impl.VwConsolidadoGeralCorrecaoServiceImpl;
import service.impl.VwCorretorDisciplinaProcessoServiceImpl;
import service.impl.VwCriterioComCorrecaoCriterioServiceImpl;
import service.impl.VwProcessoCursoServiceImpl;
import service.impl.VwProcessoDisciplinaCorretorServiceImpl;
import service.impl.VwProcessoDisciplinaServiceImpl;
import service.impl.VwRelatorioDiscrepanciaCorretorServiceImpl;
import service.impl.VwRelatorioDiscrepanciaSinteticoServiceImpl;
import service.impl.VwRelatorioNotasServiceImpl;
import service.impl.VwRespostaCorrecaoServiceImpl;
import service.impl.VwRespostaImagemServiceImpl;
import util.Uteis;

/**
 *
 * @author Janio
 */
@ManagedBean(name = "RelatorioDetalhado")
@SessionScoped
public class RelatorioDetalhadoController extends BasicController {

    private TbProcesso processoSelecionado = null;
    private TbDisciplina disciplinaSelecionada = null;
    private TbColaborador colaboradorSelecionado = null;
    private TbPessoa pessoaSelecionada=null;
    //private VwRespostaCorrecao correcaoSelecionada = null;
    private TbCorrecao correcaoSelecionada = null;
    private DataModel gridDisciplinas;
    private DataModel gridCorretores;
    private DataModel gridCorrecoes;
    private DataModel gridCorrecaoConsolidada;
    private DataModel gridCorrecaoConsolidadaQuestao;
    private DataModel gridConfereDiscrepancia;
    private DataModel gridCursos;
    private DataModel gridConsolidadoGeral;
    //private List<TbCorrecaoCriterio> criteriosJacorrigidos = null;
    private List<VwCriterioComCorrecaoCriterio> criteriosJacorrigidos = null;
    private List<TbCategoriaCriterioComPerda> categoriasCorrecao = null;
    private List<VwProcessoCurso> listaCursos = null;
    private List<VwProcessoDisciplina> listaDisciplinas = null;
    private List<VwConsolidadoGeralCorrecaoDisciplina> listaVwConsGeral = null;
    private int idCurso, idDisciplina;
    private int idDisciplinaRelConsGeral, idProcessoRelConsGeral;
    private DataModel gridDiscrepanciaCorretor;
    private DataModel gridDiscrepanciaDetalhado;
    private List<TbCorrecaoCriterio> listaCorrecaoCriterio;

    private List<TbCorrecao> listaCorrecao;
    //private TbResposta respostaSelecionada;
    private List<VwRespostaImagem> listaImagens = null;
    private TbColaborador colaboradorCorrecaoSelecionada=null;
    TbResposta candidatoAtual = null;
    
    private List<VwRelatorioNotas> listaNotas = null;
    
    List<TbCorrecaoCriterio> listaCriteriosCorrecaoAtual=new ArrayList<TbCorrecaoCriterio>();

    public String encaminhaRelDetalhadoDisciplina() {

        ProcessoController pc = ProcessoController.getInstance();
        if (pc != null) {
            if (pc.getGridProcessos().isRowAvailable()) {
                TbProcesso selecionado = (TbProcesso) pc.getGridProcessos().getRowData();
                this.setProcessoSelecionado(selecionado);
            }
        }

        //List<VwProcessoDisciplina> lista = this.consultaListaDisciplinas(); //pesquisar lista de disciplinas

        //if (lista != null && lista.size() == 1) {
            //this.disciplinaSelecionada = new TbDisciplina(lista.get(0).getIdDisciplina().intValue());
            this.disciplinaSelecionada = new TbDisciplina(Uteis.ID_DISCIPLINA_REDACAO);
            //PENDENTE: fazer mostrar o corretor apenas UMA vez
            this.consultaListaCorretores(); //pesquisar lista de corretores
            
            return "/view/coordenador/rel/detalhado/corretor.xhtml";

        //} else {
        //    return "/view/coordenador/rel/detalhado/disciplina.xhtml";
        //}
        
    }
    public String encaminhaRelNotasDisciplina() {

        ProcessoController pc = ProcessoController.getInstance();
        if (pc != null) {
            if (pc.getGridProcessos().isRowAvailable()) {
                TbProcesso selecionado = (TbProcesso) pc.getGridProcessos().getRowData();
                this.setProcessoSelecionado(selecionado);
            }
        }

        UsuarioController uc = UsuarioController.getInstance();
        int idDisciplinaSelecionada = 0;
        if (uc != null && uc.getUsuario() != null && uc.getUsuario().getIdDisciplina() != null && uc.getUsuario().getIdDisciplina().getIdDisciplina() != null && uc.getUsuario().getIdDisciplina().getIdDisciplina().intValue() > 0) {
            idDisciplinaSelecionada = uc.getUsuario().getIdDisciplina().getIdDisciplina().intValue();
        }

        boolean bolAdministrador = false;
        if (uc != null && uc.getUsuario() != null) {
            TbUsuarioPerfil up = (new UsuarioPerfilServiceImpl()).pesquisarPorIDUsuario(uc.getUsuario().getIdUsuario());
            bolAdministrador = (up.getTbPerfil() != null && up.getTbPerfil().getIdPerfil() != null && up.getTbPerfil().getIdPerfil().intValue() == Uteis.PERFIL_ADMINISTRADOR);
        }

        if (idDisciplinaSelecionada <= 0 || bolAdministrador) {
            List<VwProcessoDisciplina> lista = this.consultaListaDisciplinas(); //pesquisar lista de disciplinas
            this.setListaDisciplinas(lista);
            return "/view/coordenador/rel/notas/disciplina.xhtml";
        } else {
            this.disciplinaSelecionada = new TbDisciplina(idDisciplinaSelecionada);
            this.consultaListaCorretores();
            return "/view/coordenador/rel/notas/todasNotas.xhtml";
            
        }
    }

    public String encaminhaRelDetalhadoDisciplinaDiscursiva() {
        ProcessoController pc = ProcessoController.getInstance();
        if (pc != null) {
            if (pc.getGridProcessos().isRowAvailable()) {
                TbProcesso selecionado = (TbProcesso) pc.getGridProcessos().getRowData();
                this.setProcessoSelecionado(selecionado);
            }
        }

        UsuarioController uc = UsuarioController.getInstance();
        int idDisciplinaSelecionada = 0;
        if (uc != null && uc.getUsuario() != null && uc.getUsuario().getIdDisciplina() != null && uc.getUsuario().getIdDisciplina().getIdDisciplina() != null && uc.getUsuario().getIdDisciplina().getIdDisciplina().intValue() > 0) {
            idDisciplinaSelecionada = uc.getUsuario().getIdDisciplina().getIdDisciplina().intValue();
        }

        boolean bolAdministrador = false;
        if (uc != null && uc.getUsuario() != null) {
            TbUsuarioPerfil up = (new UsuarioPerfilServiceImpl()).pesquisarPorIDUsuario(uc.getUsuario().getIdUsuario());
            bolAdministrador = (up.getTbPerfil() != null && up.getTbPerfil().getIdPerfil() != null && up.getTbPerfil().getIdPerfil().intValue() == Uteis.PERFIL_ADMINISTRADOR);
        }

        if (idDisciplinaSelecionada <= 0 || bolAdministrador) {
            List<VwProcessoDisciplina> lista = this.consultaListaDisciplinas(); //pesquisar lista de disciplinas
            return "/view/coordenador/rel/detalhado/disciplina_discursiva.xhtml";
        } else {
            this.disciplinaSelecionada = new TbDisciplina(idDisciplinaSelecionada);
            this.consultaListaCorretores();
            return "/view/coordenador/rel/detalhado/corretor_discursiva.xhtml";
        }
    }

    //Síntese de correção - Relatório consolidado geral
    public String encaminhaRelCorrecaoConsolidadaDisciplina() {

        ProcessoController pc = ProcessoController.getInstance();
        if (pc != null) {
            if (pc.getGridProcessos().isRowAvailable()) {
                TbProcesso selecionado = (TbProcesso) pc.getGridProcessos().getRowData();
                this.setProcessoSelecionado(selecionado);
            }
        }
        boolean bolAdministrador = false;
        UsuarioController uc = UsuarioController.getInstance();
        if (uc != null && uc.getUsuario() != null) {
            TbUsuarioPerfil up = (new UsuarioPerfilServiceImpl()).pesquisarPorIDUsuario(uc.getUsuario().getIdUsuario());
            bolAdministrador = (up.getTbPerfil() != null && up.getTbPerfil().getIdPerfil() != null && up.getTbPerfil().getIdPerfil().intValue() == Uteis.PERFIL_ADMINISTRADOR);
        }

        int idDisciplinaSelecionada = 0;
        if (!bolAdministrador) {
            if (uc != null && uc.getUsuario() != null && uc.getUsuario().getIdDisciplina() != null && uc.getUsuario().getIdDisciplina().getIdDisciplina() != null && uc.getUsuario().getIdDisciplina().getIdDisciplina().intValue() > 0) {
                idDisciplinaSelecionada = uc.getUsuario().getIdDisciplina().getIdDisciplina().intValue();
            }
        }

        this.consultaListaCorrecaoConsolidada(idDisciplinaSelecionada);

        return "/view/coordenador/rel/detalhado/correcaoConsolidada.xhtml";
    }

    public String encaminhaRelDetalhadoConsolidadoDisciplina() {

        return "/view/coordenador/rel/detalhado/correcaoDisciplina.xhtml";
    }

    public String encaminhaRelDiscrepanciaListaDisciplinasCursos() {
        ProcessoController pc = ProcessoController.getInstance();
        if (pc != null) {
            if (pc.getGridProcessos().isRowAvailable()) {
                TbProcesso selecionado = (TbProcesso) pc.getGridProcessos().getRowData();
                this.setProcessoSelecionado(selecionado);
            }

            this.consultaListaDisciplinas();
            this.consultaListaCursos();

            return "/view/coordenador/rel/cursoDisciplinaDiscrepancia.xhtml";
        }
        return "/view/coordenador/rel/processoDiscrepancia.xhtml";

    }

    public String encaminhaRelDiscrepanciaCorretorDisciplina() {
        ProcessoController pc = ProcessoController.getInstance();
        if (pc != null) {
            if (pc.getGridProcessos().isRowAvailable()) {
                TbProcesso selecionado = (TbProcesso) pc.getGridProcessos().getRowData();
                this.setProcessoSelecionado(selecionado);
            }

            boolean bolAdministrador = false;

            UsuarioController uc = UsuarioController.getInstance();
            if (uc != null && uc.getUsuario() != null) {
                TbUsuarioPerfil up = (new UsuarioPerfilServiceImpl()).pesquisarPorIDUsuario(uc.getUsuario().getIdUsuario());
                bolAdministrador = (up.getTbPerfil() != null && up.getTbPerfil().getIdPerfil() != null && up.getTbPerfil().getIdPerfil().intValue() == Uteis.PERFIL_ADMINISTRADOR);
            }

            int idDisciplinaSelecionada = 0;
            if (!bolAdministrador) {
                if (uc != null && uc.getUsuario() != null && uc.getUsuario().getIdDisciplina() != null && uc.getUsuario().getIdDisciplina().getIdDisciplina() != null && uc.getUsuario().getIdDisciplina().getIdDisciplina().intValue() > 0) {
                    idDisciplinaSelecionada = uc.getUsuario().getIdDisciplina().getIdDisciplina().intValue();
                }
            }
            if (idDisciplinaSelecionada == 0) {
                this.consultaListaDisciplinas();
                this.consultaRelatorioDiscrepanciaCorretor(true);
                return "/view/banca/rel/discrepanciaCorretor.xhtml";
            } else {
                this.setDisciplinaSelecionada(new TbDisciplina(idDisciplinaSelecionada));
                this.consultaRelatorioDiscrepanciaCorretor();
                return "/view/banca/rel/discrepanciaCorretor.xhtml";
            }
        }
        return "/view/banca/rel/discrepanciaDisciplinas.xhtml";
    }

    public String encaminhaRelConfereDiscrepancia() {
        VwConfereDiscrepanciaService vcds = new VwConfereDiscrepanciaServiceImpl();
        if ((this.idCurso == 0) && (this.idDisciplina == 0)) {
            return "/view/coordenador/rel/cursoDisciplinaDiscrepancia.xhtml";
        }

        this.gridConfereDiscrepancia = new ListDataModel(vcds.pesquisarPorDisciplinaCursoProcesso(this.getIdDisciplina(), this.getIdCurso(), this.getProcessoSelecionado().getIdProcesso().intValue()));
        return "/view/coordenador/rel/discrepancia";

    }

    public String encaminhaRelCorrecaoConsolidada() {
        if (this.gridDisciplinas != null && this.gridDisciplinas.isRowAvailable()) {
            VwProcessoDisciplina selecionada = (VwProcessoDisciplina) this.gridDisciplinas.getRowData();
            this.disciplinaSelecionada = new TbDisciplina(selecionada.getIdDisciplina().intValue());
        }
        //pesquisar lista de corretores
        this.consultaListaCorrecaoConsolidada();
        return "/view/coordenador/rel/detalhado/correcaoConsolidada.xhtml";
    }

    public String encaminhaRelDetalhadoCorretores() {
        if (this.gridDisciplinas != null && this.gridDisciplinas.isRowAvailable()) {
            VwProcessoDisciplina selecionada = (VwProcessoDisciplina) this.gridDisciplinas.getRowData();
            this.disciplinaSelecionada = new TbDisciplina(selecionada.getIdDisciplina().intValue());
        }
        //pesquisar lista de corretores
        this.consultaListaCorretores();
        return "/view/coordenador/rel/detalhado/corretor.xhtml";
    }

    
    public String encaminhaRelDetalhadoCorretoresDiscursiva() {
        if (this.gridDisciplinas != null && this.gridDisciplinas.isRowAvailable()) {
            VwProcessoDisciplina selecionada = (VwProcessoDisciplina) this.gridDisciplinas.getRowData();
            this.disciplinaSelecionada = new TbDisciplina(selecionada.getIdDisciplina().intValue());
        }
        //pesquisar lista de corretores
        this.consultaListaCorretores();
        return "/view/coordenador/rel/detalhado/corretor_discursiva.xhtml";
    }
    public String encaminhaRelNotas() {
        if (this.gridDisciplinas != null && this.gridDisciplinas.isRowAvailable()) {
            VwProcessoDisciplina selecionada = (VwProcessoDisciplina) this.gridDisciplinas.getRowData();
            this.disciplinaSelecionada = new TbDisciplina(selecionada.getIdDisciplina().intValue());
        }
        //pesquisar lista de corretores
        this.consultaListaNotas();
        return "/view/coordenador/rel/notas/notasDetalhado.xhtml";
    }

    public String encaminhaRelDetalhadoListaProvas() {
        /*
        if (this.gridCorretores != null && this.gridCorretores.isRowAvailable()) {
            VwProcessoDisciplinaCorretor selecionado = (VwProcessoDisciplinaCorretor) this.gridCorretores.getRowData();
            this.colaboradorSelecionado = new TbColaborador(selecionado.getIdColaborador().longValue());
        }

        this.consultaListaCorrecoes();
        */
        if (this.gridCorretores != null && this.gridCorretores.isRowAvailable()) {
            VwCorretorDisciplinaProcesso selecionado = (VwCorretorDisciplinaProcesso) this.gridCorretores.getRowData();
            TbPessoa filtro = new TbPessoa();
            filtro.setNrCpf(selecionado.getNrCpf());
            this.pessoaSelecionada = new PessoaServiceImpl().pesquisarPorCpf(filtro);
        }

        this.consultaListaCorrecoesPorPessoa();
        
        //pesquisar lista de provas
        return "/view/coordenador/rel/detalhado/lista_provas.xhtml";
    }

    public String encaminhaRelDetalhadoListaProvasDiscursiva() {
        /*
        if (this.gridCorretores != null && this.gridCorretores.isRowAvailable()) {
            VwProcessoDisciplinaCorretor selecionado = (VwProcessoDisciplinaCorretor) this.gridCorretores.getRowData();
            this.colaboradorSelecionado = new TbColaborador(selecionado.getIdColaborador().longValue());
        }*/

        if (this.gridCorretores != null && this.gridCorretores.isRowAvailable()) {
            VwCorretorDisciplinaProcesso selecionado = (VwCorretorDisciplinaProcesso)this.gridCorretores.getRowData();
            //VwProcessoDisciplinaCorretor selecionado = (VwProcessoDisciplinaCorretor) this.gridCorretores.getRowData();
            //this.colaboradorSelecionado = new TbColaborador(selecionado.getIdColaborador().longValue());
            TbPessoa filtro = new TbPessoa();
            filtro.setNrCpf(selecionado.getNrCpf());
            this.pessoaSelecionada = new PessoaServiceImpl().pesquisarPorCpf(filtro);
            
        }

        //this.consultaListaCorrecoes();
        this.consultaListaCorrecoesPorPessoa();
        //pesquisar lista de provas
        return "/view/coordenador/rel/detalhado/lista_provas_discursiva.xhtml";
    }

    public String encaminhaRelDetalhadoProvas() {
        //RELATORIO DE CORREÇÃO DETALHADA - REDAÇÃO
        /*
        if (this.gridCorrecoes != null && this.gridCorrecoes.isRowAvailable()) {
            VwRespostaCorrecao selecionada = (VwRespostaCorrecao) this.gridCorrecoes.getRowData();
            this.correcaoSelecionada = selecionada;
            this.setCandidatoAtual(new RespostaServiceImpl().pesquisarPorIDLong(this.correcaoSelecionada.getIdResposta()));
        }
        this.consultaCorrecao(this.correcaoSelecionada);
        List<TbCorrecao> retListaCorrecoes = (new CorrecaoServiceImpl()).pesquisarPorResposta(this.correcaoSelecionada.getIdResposta());
        this.setListaCorrecao(retListaCorrecoes);*/

        VwRespostaCorrecao selecionada=null;
        if (this.gridCorrecoes != null && this.gridCorrecoes.isRowAvailable()) {
            selecionada = (VwRespostaCorrecao) this.gridCorrecoes.getRowData();
            this.correcaoSelecionada = new CorrecaoServiceImpl().pesquisarPorIDLong(selecionada.getIdCorrecao());
            this.setCandidatoAtual(new RespostaServiceImpl().pesquisarPorIDLong(this.correcaoSelecionada.getIdResposta().getIdResposta()));
        }
        this.consultaCorrecao(selecionada);
        List<TbCorrecao> retListaCorrecoes = (new CorrecaoServiceImpl()).pesquisarPorResposta(this.correcaoSelecionada.getIdResposta().getIdResposta());
        this.setListaCorrecao(retListaCorrecoes);

        
        //this.setRespostaSelecionada(this.correcaoSelecionada.getIdResposta());
        
        //pesquisar detalhe da prova
        return "/view/coordenador/rel/detalhado/detalhamento_prova.xhtml";
    }

    public String encaminhaRelDetalhadoProvasDiscursiva() {
        //RELATORIO DE CORREÇÃO DETALHADA - QUESTÃO DISCURSIVA
        /*
        if (this.gridCorrecoes != null && this.gridCorrecoes.isRowAvailable()) {
            VwRespostaCorrecao selecionada = (VwRespostaCorrecao) this.gridCorrecoes.getRowData();
            this.correcaoSelecionada = selecionada;
            this.setCandidatoAtual(new RespostaServiceImpl().pesquisarPorIDLong(this.correcaoSelecionada.getIdResposta()));
        }
        this.consultaCorrecao(this.correcaoSelecionada);
        List<TbCorrecao> retListaCorrecoes = (new CorrecaoServiceImpl()).pesquisarPorResposta(this.correcaoSelecionada.getIdResposta());
        this.setListaCorrecao(retListaCorrecoes);*/
        
        VwRespostaCorrecao selecionada =null;
        if (this.gridCorrecoes != null && this.gridCorrecoes.isRowAvailable()) {
            selecionada = (VwRespostaCorrecao) this.gridCorrecoes.getRowData();
            this.correcaoSelecionada = new CorrecaoServiceImpl().pesquisarPorIDLong(selecionada.getIdCorrecao());
            this.setCandidatoAtual(new RespostaServiceImpl().pesquisarPorIDLong(this.correcaoSelecionada.getIdResposta().getIdResposta()));
        }
        this.consultaCorrecao(selecionada);
        List<TbCorrecao> retListaCorrecoes = (new CorrecaoServiceImpl()).pesquisarPorResposta(this.correcaoSelecionada.getIdResposta().getIdResposta());
        this.setListaCorrecao(retListaCorrecoes);
        
        //this.setRespostaSelecionada(this.correcaoSelecionada.getIdResposta());
        
        //pesquisar detalhe da prova
        if(this.getCandidatoAtual().getIdDisciplina()!=null){
            TbDisciplina disc=new DisciplinaServiceImpl().pesquisarPorID(this.getCandidatoAtual().getIdDisciplina().getIdDisciplina());
            if(disc!=null && disc.getIdTipoQuestao().getIdTipoQuestao()==Uteis.TIPO_QUESTAO_DOCENTE || disc.getIdTipoQuestao().getIdTipoQuestao()==Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA){
                return "/view/coordenador/rel/detalhado/docentes/detalhamento_prova.xhtml";
            }
        }
        
        return "/view/coordenador/rel/detalhado/detalhamento_prova_discursiva.xhtml";
    }

        
    public String fixarProva(long idRespostaAtual,long idCorrecaoAtual, long idColaboradorAtual){
        CorrecaoService cs = new CorrecaoServiceImpl();
        RespostaService rs = new RespostaServiceImpl();
        TbCorrecao correcaoAfazer = cs.pesquisarPorCorrecaoColaborador(idRespostaAtual,idColaboradorAtual);
        TbResposta atualizarResposta = rs.pesquisarPorIDLong(idRespostaAtual);
        atualizarResposta.setFlCorrigida(false);
        atualizarResposta.setFlDiscrepancia(false);
        atualizarResposta.setFlDiscrepanciaCorrigida(false);
        atualizarResposta.setFlRespostaComErro(false);
        atualizarResposta.setFlRespostaEmBranco(false);
        if(correcaoAfazer.getIdTipoCorrecao().getIdTipoCorrecao()==Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO){
            atualizarResposta.setFlPrimeiraCorrecao(false);
        }else if(correcaoAfazer.getIdTipoCorrecao().getIdTipoCorrecao()==Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO){
            atualizarResposta.setFlSegundaCorrecao(false);
        }else if(correcaoAfazer.getIdTipoCorrecao().getIdTipoCorrecao()==Uteis.TIPO_CORRECAO_TERCEIRA_CORRECAO){
            atualizarResposta.setFlTerceiraCorrecao(false);
        }
        TbColaborador consultaColaborador = new ColaboradorServiceImpl().pesquisarPorIDLong(idColaboradorAtual);
        atualizarResposta.setFlCorrigindo(true);
        atualizarResposta.setIdColaboradorAtual(consultaColaborador);
        TbResposta verificaUpdate = rs.atualizar(atualizarResposta);
        cs=null;
        rs=null;
        if(verificaUpdate!=null){
            this.setMensagem("Prova de código "+atualizarResposta.getIdResposta()+" fixada com sucesso para este corretor.");
        }
        return "/view/coordenador/rel/detalhado/lista_provas_discursiva.xhtml";
    }
        
    public String corrigirNovamente(long idRespostaAtual,long idCorrecaoAtual, long idColaboradorAtual){
        CorrecaoService cs = new CorrecaoServiceImpl();
        RespostaService rs = new RespostaServiceImpl();
        TbCorrecao correcaoAfazer = cs.pesquisarPorCorrecaoColaborador(idRespostaAtual,idColaboradorAtual);
        TbResposta atualizarResposta = rs.pesquisarPorIDLong(idRespostaAtual);
        atualizarResposta.setFlCorrigida(false);
        atualizarResposta.setFlDiscrepancia(false);
        atualizarResposta.setFlDiscrepanciaCorrigida(false);
        atualizarResposta.setFlRespostaComErro(false);
        atualizarResposta.setFlRespostaEmBranco(false);
        if(correcaoAfazer.getIdTipoCorrecao().getIdTipoCorrecao()==Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO){
            atualizarResposta.setFlPrimeiraCorrecao(false);
        }else if(correcaoAfazer.getIdTipoCorrecao().getIdTipoCorrecao()==Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO){
            atualizarResposta.setFlSegundaCorrecao(false);
        }else if(correcaoAfazer.getIdTipoCorrecao().getIdTipoCorrecao()==Uteis.TIPO_CORRECAO_TERCEIRA_CORRECAO){
            atualizarResposta.setFlTerceiraCorrecao(false);
        }
        TbResposta verificaUpdate = rs.atualizar(atualizarResposta);
        cs=null;
        rs=null;
        if(verificaUpdate!=null){
            this.setMensagem("Correção de código "+atualizarResposta.getIdResposta()+" voltada com sucesso para este corretor.");
        }
        return "/view/coordenador/rel/detalhado/lista_provas_discursiva.xhtml";
    }
    
    public String mandarDiscrepancia(long idRespostaAtual){
        RespostaService rs = new RespostaServiceImpl();
        TbResposta atualizarResposta = rs.pesquisarPorIDLong(idRespostaAtual);
        atualizarResposta.setFlCorrigida(false);
        atualizarResposta.setFlDiscrepancia(false);
        atualizarResposta.setFlDiscrepanciaCorrigida(false);
        atualizarResposta.setFlRespostaComErro(false);
        atualizarResposta.setFlRespostaEmBranco(false);
        atualizarResposta.setFlDiscrepancia(true);
        TbResposta verificaUpdate = rs.atualizar(atualizarResposta);
        rs=null;
        if(verificaUpdate!=null){
            this.setMensagem("Prova de código "+atualizarResposta.getIdResposta()+" enviada com sucesso para discrepância.");
        }
        return "/view/coordenador/rel/detalhado/lista_provas_discursiva.xhtml";
    }
        
    

    public TbProcesso getProcessoSelecionado() {
        return processoSelecionado;
    }

    public void setProcessoSelecionado(TbProcesso processoSelecionado) {
        this.processoSelecionado = processoSelecionado;
    }

    public TbDisciplina getDisciplinaSelecionada() {
        return disciplinaSelecionada;
    }

    public void setDisciplinaSelecionada(TbDisciplina disciplinaSelecionada) {
        this.disciplinaSelecionada = disciplinaSelecionada;
    }

    private List<VwProcessoDisciplina> consultaListaDisciplinas() {
        VwProcessoDisciplinaService vpds = new VwProcessoDisciplinaServiceImpl();
        this.listaDisciplinas = vpds.pesquisaPorProcesso(this.processoSelecionado.getIdProcesso().intValue());
        this.gridDisciplinas = new ListDataModel(this.listaDisciplinas);
        return listaDisciplinas;
    }

    public List<VwProcessoCurso> consultaListaCursos() {
        VwProcessoCursoService vpcs = new VwProcessoCursoServiceImpl();
        this.listaCursos = vpcs.pesquisaPorProcesso(this.processoSelecionado.getIdProcesso().intValue());
        this.gridCursos = new ListDataModel(this.listaCursos);
        return listaCursos;
    }

    public void selecionouProcesso() {
        VwConsolidadoGeralCorrecaoDisciplinaService vcgcs = new VwConsolidadoGeralCorrecaoDisciplinaServiceImpl();
        listaVwConsGeral = vcgcs.pesquisarPorProcesso(this.idProcessoRelConsGeral);

    }

    public String encaminhaRelConsolidadoGeral() {
        VwConsolidadoGeralCorrecaoService vcgcs = new VwConsolidadoGeralCorrecaoServiceImpl();
        this.gridConsolidadoGeral = new ListDataModel(vcgcs.pesquisarPorProcessoeDisciplina(idProcessoRelConsGeral, idDisciplinaRelConsGeral));
        return "/view/coordenador/rel/detalhado/consolidadoGeral.xhtml";
    }

    public String encaminhaRelConsolidadoGeral2() {
        VwConsolidadoGeralCorrecaoDisciplinaService vcgcd = new VwConsolidadoGeralCorrecaoDisciplinaServiceImpl();
        this.gridConsolidadoGeral = new ListDataModel(vcgcd.pesquisarPorProcessoeDisciplina(idProcessoRelConsGeral, idDisciplinaRelConsGeral));
        return "/view/coordenador/rel/detalhado/consolidadoGeral2.xhtml";
    }

    public DataModel getGridDisciplinas() {
        return this.gridDisciplinas;
    }

    public void setGridDisciplinas(DataModel gridDisciplinas) {
        this.gridDisciplinas = gridDisciplinas;
    }

    private void consultaListaCorretores() {
        //VwProcessoDisciplinaCorretorService vpdcs = new VwProcessoDisciplinaCorretorServiceImpl();
        //this.gridCorretores = new ListDataModel(vpdcs.pesquisaPorProcessoDisciplina(this.getDisciplinaSelecionada().getIdDisciplina().intValue(), this.getProcessoSelecionado().getIdProcesso().intValue()));
        VwCorretorDisciplinaProcessoService vcs = new VwCorretorDisciplinaProcessoServiceImpl();
        this.gridCorretores = new ListDataModel(vcs.pesquisaPorProcessoDisciplina(this.getDisciplinaSelecionada().getIdDisciplina().intValue(), this.getProcessoSelecionado().getIdProcesso().intValue()));
    }

    public DataModel getGridCorretores() {
        return gridCorretores;
    }

    public void setGridCorretores(DataModel gridCorretores) {
        this.gridCorretores = gridCorretores;
    }

    private void consultaListaCorrecoes() {

        VwRespostaCorrecaoService cs = new VwRespostaCorrecaoServiceImpl();
        this.gridCorrecoes = new ListDataModel(cs.listaCorrecoesPorCorretorDisciplinaProcesso(this.getColaboradorSelecionado().getIdColaborador().longValue(), this.getProcessoSelecionado().getIdProcesso().intValue(), this.getDisciplinaSelecionada().getIdDisciplina().intValue()));

    }
    private void consultaListaCorrecoesPorPessoa() {

        VwRespostaCorrecaoService cs = new VwRespostaCorrecaoServiceImpl();
        this.gridCorrecoes = new ListDataModel(cs.listaCorrecoesPorPessoaDisciplinaProcesso(this.getPessoaSelecionada().getNrCpf() , this.getProcessoSelecionado().getIdProcesso().intValue(), this.getDisciplinaSelecionada().getIdDisciplina().intValue()));

    }

    public void consultaListaCorrecaoConsolidada() {
        this.consultaListaCorrecaoConsolidada(this.getDisciplinaSelecionada().getIdDisciplina().intValue());
    }

    public void consultaListaCorrecaoConsolidada(int idDisciplina) {
        VwConsolidadoGeralCorrecaoService vcgc = new VwConsolidadoGeralCorrecaoServiceImpl();
        this.gridCorrecaoConsolidada = new ListDataModel(vcgc.pesquisarPorProcessoeDisciplina(this.getProcessoSelecionado().getIdProcesso().intValue(), idDisciplina));
    }

    public TbColaborador getColaboradorSelecionado() {
        return colaboradorSelecionado;
    }

    public void setColaboradorSelecionado(TbColaborador colaboradorSelecionado) {
        this.colaboradorSelecionado = colaboradorSelecionado;
    }

    private VwRespostaCorrecao consultaCorrecao(VwRespostaCorrecao procurar) {
        //CorrecaoService cs = new CorrecaoServiceImpl();
        //TbCorrecao retorno = cs.pesquisarPorIDLong(procurar.getIdCorrecao().longValue());
        //VwRespostaCorrecao consulta= (new VwRespostaCorrecaoServiceImpl()).pesquisarPorIDLong(procurar.getIdCorrecao());
        VwRespostaCorrecao consulta= (new VwRespostaCorrecaoServiceImpl()).pesquisarPorIdCorrecao((procurar.getIdCorrecao()));

        List<TbCorrecaoCriterio> listaCorrecoesAtuais=new CorrecaoCriterioServiceImpl().pesquisarPorCorrecao(consulta.getIdCorrecao());

        this.setListaCriteriosCorrecaoAtual(listaCorrecoesAtuais);

        /*
        this.colaboradorCorrecaoSelecionada=new ColaboradorServiceImpl().pesquisarPorIDLong(consulta.getIdColaborador());
        this.correcaoSelecionada = consulta;
        this.setCandidatoAtual(new RespostaServiceImpl().pesquisarPorIDLong(this.correcaoSelecionada.getIdResposta()));*/

        this.colaboradorCorrecaoSelecionada=new ColaboradorServiceImpl().pesquisarPorIDLong(consulta.getIdColaborador());
        this.correcaoSelecionada = new CorrecaoServiceImpl().pesquisarPorIDLong(consulta.getIdCorrecao());
        this.setCandidatoAtual(new RespostaServiceImpl().pesquisarPorIDLong(this.correcaoSelecionada.getIdResposta().getIdResposta()));
        
        
        this.consultaCriteriosJaCorrigidos();
        this.consultaCategoriasCorrigidas();
        return consulta;
    }

    private void consultaCriteriosJaCorrigidos() {
        //this.setCriteriosJacorrigidos((new CorrecaoCriterioServiceImpl()).pesquisarPorCorrecao(this.getCorrecaoSelecionada().getIdCorrecao().longValue()));
        this.setCriteriosJacorrigidos(new VwCriterioComCorrecaoCriterioServiceImpl().pesquisarCriteriosPorCorrecao(this.getCorrecaoSelecionada().getIdCorrecao())) ;
    }

    private void consultaCategoriasCorrigidas() {
        this.setCategoriasCorrecao((new VwCriterioComCorrecaoCriterioServiceImpl()).pesquisarCategoriasPorCorrecao(this.getCorrecaoSelecionada().getIdCorrecao()));

    }

    /*
    public VwRespostaCorrecao getCorrecaoSelecionada() {
        return correcaoSelecionada;
    }

    public void setCorrecaoSelecionada(VwRespostaCorrecao correcaoSelecionada) {
        this.correcaoSelecionada = correcaoSelecionada;
    }
*/

    public TbCorrecao getCorrecaoSelecionada() {
        return correcaoSelecionada;
    }

    public void setCorrecaoSelecionada(TbCorrecao correcaoSelecionada) {
        this.correcaoSelecionada = correcaoSelecionada;
    }
    
    public StreamedContent getImagemCandidatoAtual() {
        if (this.getCorrecaoSelecionada().getIdResposta().getTbRespostaImagem() == null) {
            return null;
        }
        try{
            InputStream is = new ByteArrayInputStream(this.getCorrecaoSelecionada().getIdResposta().getTbRespostaImagem().get(0).getImImagemResposta());
            return new DefaultStreamedContent(is);
        }catch(Exception ex){
            return null;
        }
        //return null;
    }
    
    public boolean isExisteImagemProvaAtual(){
        if (this.getCorrecaoSelecionada().getIdResposta().getTbRespostaImagem() == null) {
            return false;
        }
        if (this.getCorrecaoSelecionada().getIdResposta().getTbRespostaImagem().size()<=0) {
            return false;
        }
        if (this.getCorrecaoSelecionada().getIdResposta().getTbRespostaImagem().get(0).getImImagemResposta()==null) {
            return false;
        }
        return true;
    
    }

    public DataModel getGridCorrecoes() {
        return gridCorrecoes;
    }

    public void setGridCorrecoes(DataModel gridCorrecoes) {
        this.gridCorrecoes = gridCorrecoes;
    }

    public List<TbCategoriaCriterioComPerda> getCategoriasCorrecao() {
        return categoriasCorrecao;
    }

    public void setCategoriasCorrecao(List<TbCategoriaCriterioComPerda> categoriasCorrecao) {
        this.categoriasCorrecao = categoriasCorrecao;
    }

    public DataModel getGridCorrecaoConsolidada() {
        return gridCorrecaoConsolidada;
    }

    public void setGridCorrecaoConsolidada(DataModel gridCorrecaoConsolidada) {
        this.gridCorrecaoConsolidada = gridCorrecaoConsolidada;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public DataModel getGridConfereDiscrepancia() {
        return gridConfereDiscrepancia;
    }

    public void setGridConfereDiscrepancia(DataModel gridConfereDiscrepancia) {
        this.gridConfereDiscrepancia = gridConfereDiscrepancia;
    }

    public List<VwProcessoCurso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<VwProcessoCurso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public List<VwProcessoDisciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public void setListaDisciplinas(List<VwProcessoDisciplina> listaDisciplinas) {
        this.listaDisciplinas = listaDisciplinas;
    }

    public DataModel getGridCursos() {
        return gridCursos;
    }

    public void setGridCursos(DataModel gridCursos) {
        this.gridCursos = gridCursos;
    }

    public int getIdDisciplinaRelConsGeral() {
        return idDisciplinaRelConsGeral;
    }

    public void setIdDisciplinaRelConsGeral(int idDisciplinaRelConsGeral) {
        this.idDisciplinaRelConsGeral = idDisciplinaRelConsGeral;
    }

    public int getIdProcessoRelConsGeral() {
        return idProcessoRelConsGeral;
    }

    public void setIdProcessoRelConsGeral(int idProcessoRelConsGeral) {
        this.idProcessoRelConsGeral = idProcessoRelConsGeral;
    }

    public List<VwConsolidadoGeralCorrecaoDisciplina> getListaVwConsGeral() {
        return listaVwConsGeral;
    }

    public void setListaVwConsGeral(List<VwConsolidadoGeralCorrecaoDisciplina> listaVwConsGeral) {
        this.listaVwConsGeral = listaVwConsGeral;
    }

    public DataModel getGridConsolidadoGeral() {
        return gridConsolidadoGeral;
    }

    public void setGridConsolidadoGeral(DataModel gridConsolidadoGeral) {
        this.gridConsolidadoGeral = gridConsolidadoGeral;
    }

    public DataModel getGridDiscrepanciaCorretor() {
        return gridDiscrepanciaCorretor;
    }

    public void setGridDiscrepanciaCorretor(DataModel gridDiscrepanciaCorretor) {
        this.gridDiscrepanciaCorretor = gridDiscrepanciaCorretor;
    }

    private void consultaRelatorioDiscrepanciaCorretor() {

        this.consultaRelatorioDiscrepanciaCorretor(false);
    }

    private void consultaRelatorioDiscrepanciaCorretor(boolean consultaTodasDisciplinas) {

        if (consultaTodasDisciplinas) {
            this.gridDiscrepanciaCorretor = new ListDataModel(new VwRelatorioDiscrepanciaSinteticoServiceImpl().pesquisarTodosOrdenado());
        } else {
            this.gridDiscrepanciaCorretor = new ListDataModel(new VwRelatorioDiscrepanciaSinteticoServiceImpl().pesquisarPorProcessoDisciplina(this.processoSelecionado.getIdProcesso(), this.disciplinaSelecionada.getIdDisciplina()));
        }
    }

    public String consultaRelatorioDiscrepanciaDetalhado(int idDisciplinaSelecionada) {
        this.consultaRelatorioDiscrepanciaDetalhado(false, idDisciplinaSelecionada);
        return "/view/banca/rel/discrepancia/discrepanciaDetalhado.xhtml";
    }

    private void consultaRelatorioDiscrepanciaDetalhado(boolean consultaTodasDisciplinas, int idDisciplinaSelecionada) {

        if (consultaTodasDisciplinas) {
            this.gridDiscrepanciaDetalhado = new ListDataModel(new VwRelatorioDiscrepanciaCorretorServiceImpl().pesquisarTodosOrdenado());
        } else {

            if (this.disciplinaSelecionada == null) {
                this.disciplinaSelecionada = new TbDisciplina(idDisciplinaSelecionada);
            }
            this.gridDiscrepanciaDetalhado = new ListDataModel(new VwRelatorioDiscrepanciaCorretorServiceImpl().pesquisarPorProcessoDisciplina(this.processoSelecionado.getIdProcesso(), idDisciplinaSelecionada));
        }
    }

    public DataModel getGridDiscrepanciaDetalhado() {
        return gridDiscrepanciaDetalhado;
    }

    public void setGridDiscrepanciaDetalhado(DataModel gridDiscrepanciaDetalhado) {
        this.gridDiscrepanciaDetalhado = gridDiscrepanciaDetalhado;
    }

    public List<TbDisciplina> getListaDisciplinasUsuario() {

        boolean bolAdministrador = false;
        UsuarioController uc = UsuarioController.getInstance();
        if (uc != null && uc.getUsuario() != null) {
            TbUsuarioPerfil up = (new UsuarioPerfilServiceImpl()).pesquisarPorIDUsuario(uc.getUsuario().getIdUsuario());
            bolAdministrador = (up.getTbPerfil() != null && up.getTbPerfil().getIdPerfil() != null && up.getTbPerfil().getIdPerfil().intValue() == Uteis.PERFIL_ADMINISTRADOR);
        }

        int idDisciplinaSelecionada = 0;
        if (!bolAdministrador) {
            if (uc != null && uc.getUsuario() != null && uc.getUsuario().getIdDisciplina() != null && uc.getUsuario().getIdDisciplina().getIdDisciplina() != null && uc.getUsuario().getIdDisciplina().getIdDisciplina().intValue() > 0) {
                idDisciplinaSelecionada = uc.getUsuario().getIdDisciplina().getIdDisciplina().intValue();
            }
        }

        List<TbDisciplina> retorno = new ArrayList<TbDisciplina>();
        if (idDisciplinaSelecionada != 0) {
            TbDisciplina consulta = (new DisciplinaServiceImpl()).pesquisarPorID(idDisciplinaSelecionada);
            retorno.add(consulta);
            this.setDisciplinaSelecionada(new TbDisciplina(idDisciplinaSelecionada));
        } else {
            retorno = (new DisciplinaServiceImpl()).pesquisarTodosOrdenado();
        }

        return retorno;
    }

    public String consultaCorrecaoDetalhadaDiscrepancia(long idResposta) {

        List<TbCorrecao> retListaCorrecoes = (new CorrecaoServiceImpl()).pesquisarPorResposta(idResposta);

        List<TbCorrecaoCriterio> retornoCorrecaoCriterio = new ArrayList<TbCorrecaoCriterio>();
        for (TbCorrecao atual : retListaCorrecoes) {
            List<TbCorrecaoCriterio> consulta = (new CorrecaoCriterioServiceImpl()).pesquisarPorCorrecao(atual.getIdCorrecao());
            retornoCorrecaoCriterio.addAll(consulta);
        }

        TbResposta respostaAtual = (new RespostaServiceImpl()).pesquisarPorIDLong(idResposta);
        this.setCandidatoAtual(respostaAtual);
        
        this.setListaCorrecaoCriterio(retornoCorrecaoCriterio);

        this.setListaCorrecao(retListaCorrecoes);

        //this.setRespostaSelecionada(respostaAtual);
        this.listaImagens=(new VwRespostaImagemServiceImpl()).pesquisarPorIdResposta(idResposta);

        return "/view/banca/rel/detalhado/detalhamento_prova_discursiva.xhtml";
    }

    public List<TbCorrecao> getListaCorrecao() {
        return listaCorrecao;
    }

    public void setListaCorrecao(List<TbCorrecao> listaCorrecao) {
        this.listaCorrecao = listaCorrecao;
    }

    public StreamedContent getImagemRespostaCandidatoAtual() {
        //if (this.getRespostaSelecionada().getTbRespostaImagem() == null) {
            return null;
        //}
        //InputStream is = new ByteArrayInputStream(this.getRespostaSelecionada().getTbRespostaImagem().getImImagemResposta());
        //return new DefaultStreamedContent(is);
    }

    public void consultaListaCorrecaoConsolidadaQuestao(int idDisciplina) {
        VwConsolidadoGeralCorrecaoDisciplinaQuestaoService relatorio = new VwConsolidadoGeralCorrecaoDisciplinaQuestaoServiceImpl();
        this.gridCorrecaoConsolidadaQuestao = new ListDataModel(relatorio.pesquisarPorProcessoeDisciplina(this.getProcessoSelecionado().getIdProcesso().intValue(), idDisciplina));
    }

    public String geraRelatorioCorrecaoConsolidadoPorQuestao() {
        int newDisc = 0;
        if (this.gridCorrecaoConsolidada.isRowAvailable()) {
            VwConsolidadoGeralCorrecao selecionada = (VwConsolidadoGeralCorrecao) this.gridCorrecaoConsolidada.getRowData();
            if (selecionada != null && selecionada.getIdDisciplina() != null) {
                newDisc = selecionada.getIdDisciplina().intValue();
            }
        }
        return this.geraRelatorioCorrecaoConsolidadoPorQuestao(newDisc);
    }

    public String geraRelatorioCorrecaoConsolidadoPorQuestao(int disciplinaSelecionada) {
        boolean bolAdministrador = false;
        UsuarioController uc = UsuarioController.getInstance();

        if (uc != null && uc.getUsuario() != null) {
            TbUsuarioPerfil up = (new UsuarioPerfilServiceImpl()).pesquisarPorIDUsuario(uc.getUsuario().getIdUsuario());
            bolAdministrador = (up.getTbPerfil() != null && up.getTbPerfil().getIdPerfil() != null && up.getTbPerfil().getIdPerfil().intValue() == Uteis.PERFIL_ADMINISTRADOR);
        }

        if (bolAdministrador) {
            disciplinaSelecionada=0;
        }
        
        this.consultaListaCorrecaoConsolidadaQuestao(disciplinaSelecionada);
        return "/view/coordenador/rel/consolidado/correcaoConsolidadaDiscQuestao.xhtml";
    }

    public DataModel getGridCorrecaoConsolidadaQuestao() {
        return gridCorrecaoConsolidadaQuestao;
    }

    private boolean respostaDiferente(long idResposta){
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual.getIdResposta().longValue()!=idResposta)return true;
        }
        return false;
    }

    public void consultaImagens(long idResposta){
        if(this.listaImagens==null || (this.respostaDiferente(idResposta)) ){
            this.listaImagens=(new VwRespostaImagemServiceImpl()).pesquisarPorIdResposta(idResposta);
        }
    }

    public void setGridCorrecaoConsolidadaQuestao(DataModel gridCorrecaoConsolidadaQuestao) {
        this.gridCorrecaoConsolidadaQuestao = gridCorrecaoConsolidadaQuestao;
    }

    public StreamedContent getImagensCandidatoAtualQ1(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO1){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ2(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO2){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ3(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO3){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ4(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO4){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ5(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO5){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ6(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO6){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ7(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO7){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ8(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO8){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ9(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO9){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ10(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO10){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ1() {
        if(this.getCandidatoAtual()!=null){
        //return this.getImagensCandidatoAtualQ1(this.getCandidatoAtual().getIdResposta().longValue());
            return this.getImagensCandidatoAtualQ1(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ2() {
        if(this.getCandidatoAtual()!=null){
        //return this.getImagensCandidatoAtualQ2(this.getCandidatoAtual().getIdResposta().longValue());
        return this.getImagensCandidatoAtualQ2(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ3() {
        if(this.getCandidatoAtual()!=null){
        //return this.getImagensCandidatoAtualQ3(this.getCandidatoAtual().getIdResposta().longValue());
        return this.getImagensCandidatoAtualQ3(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ4() {
        if(this.getCandidatoAtual()!=null){
        //return this.getImagensCandidatoAtualQ4(this.getCandidatoAtual().getIdResposta().longValue());
        return this.getImagensCandidatoAtualQ4(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ5() {
        if(this.getCandidatoAtual()!=null){
        //return this.getImagensCandidatoAtualQ5(this.getCandidatoAtual().getIdResposta().longValue());
        return this.getImagensCandidatoAtualQ5(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ6() {
        if(this.getCandidatoAtual()!=null){
        //return this.getImagensCandidatoAtualQ6(this.getCandidatoAtual().getIdResposta().longValue());
        return this.getImagensCandidatoAtualQ6(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ7() {
        if(this.getCandidatoAtual()!=null){
        //return this.getImagensCandidatoAtualQ7(this.getCandidatoAtual().getIdResposta().longValue());
        return this.getImagensCandidatoAtualQ7(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ8() {
        if(this.getCandidatoAtual()!=null){
        //return this.getImagensCandidatoAtualQ8(this.getCandidatoAtual().getIdResposta().longValue());
        return this.getImagensCandidatoAtualQ8(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ9() {
        if(this.getCandidatoAtual()!=null){
        //return this.getImagensCandidatoAtualQ9(this.getCandidatoAtual().getIdResposta().longValue());
        return this.getImagensCandidatoAtualQ9(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ10() {
        if(this.getCandidatoAtual()!=null){
        //return this.getImagensCandidatoAtualQ10(this.getCandidatoAtual().getIdResposta().longValue());
        return this.getImagensCandidatoAtualQ10(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }

    /*
    private VwRespostaCorrecao getCandidatoAtual(){
        return this.correcaoSelecionada;
    }*/

    public TbResposta getCandidatoAtual(){

        return this.candidatoAtual;
    }

    public List<TbCorrecaoCriterio> getListaCriteriosCorrecaoAtual() {
        return listaCriteriosCorrecaoAtual;
    }

    public void setListaCriteriosCorrecaoAtual(List<TbCorrecaoCriterio> listaCriteriosCorrecaoAtual) {
        this.listaCriteriosCorrecaoAtual = listaCriteriosCorrecaoAtual;
    }

    public TbColaborador getColaboradorCorrecaoSelecionada() {
        return colaboradorCorrecaoSelecionada;
    }

    public void setColaboradorCorrecaoSelecionada(TbColaborador colaboradorCorrecaoSelecionada) {
        this.colaboradorCorrecaoSelecionada = colaboradorCorrecaoSelecionada;
    }

    public List<VwCriterioComCorrecaoCriterio> getCriteriosJacorrigidos() {
        return criteriosJacorrigidos;
    }

    public void setCriteriosJacorrigidos(List<VwCriterioComCorrecaoCriterio> criteriosJacorrigidos) {
        this.criteriosJacorrigidos = criteriosJacorrigidos;
    }

    public List<TbCorrecaoCriterio> getListaCorrecaoCriterio() {
        return listaCorrecaoCriterio;
    }

    public void setListaCorrecaoCriterio(List<TbCorrecaoCriterio> listaCorrecaoCriterio) {
        this.listaCorrecaoCriterio = listaCorrecaoCriterio;
    }

    public void setCandidatoAtual(TbResposta candidatoAtual) {
        this.candidatoAtual = candidatoAtual;
    }

    private void consultaListaNotas(){

        VwRelatorioNotasService vrns = new VwRelatorioNotasServiceImpl();
        this.listaNotas = vrns.pesquisarPorProcessoDisciplina(this.getProcessoSelecionado().getIdProcesso(),this.getDisciplinaSelecionada().getIdDisciplina() );

    }

    public List<VwRelatorioNotas> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(List<VwRelatorioNotas> listaNotas) {
        this.listaNotas = listaNotas;
    }

    public TbPessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(TbPessoa pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }
    
    
}
