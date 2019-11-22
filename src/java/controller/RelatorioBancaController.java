/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.TbDisciplina;
import model.TbProcesso;
import model.TbUsuarioPerfil;
import model.VwCorrecaoFeitaPorCurso;
import model.VwEstatisticaCorrecaoPorCorretor;
import model.VwEstatisticaCriterioCorrecaoFeita;
import model.VwProcessoDisciplina;
import model.VwTipoCorrecaoFeita;
import service.VwCorrecaoFeitaPorCursoService;
import service.VwEstatisticaCorrecaoPorCorretorService;
import service.VwEstatisticaCriterioCorrecaoFeitaService;
import service.VwProcessoDisciplinaService;
import service.VwTipoCorrecaoFeitaService;
import service.impl.DisciplinaServiceImpl;
import service.impl.RespostaServiceImpl;
import service.impl.UsuarioPerfilServiceImpl;
import service.impl.VwCorrecaoFeitaPorCursoServiceImpl;
import service.impl.VwEstatisticaCorrecaoPorCorretorServiceImpl;
import service.impl.VwEstatisticaCriterioCorrecaoFeitaServiceImpl;
import service.impl.VwProcessoDisciplinaServiceImpl;
import service.impl.VwTipoCorrecaoFeitaServiceImpl;
import util.Uteis;

/**
 *
 * @author KAMYLLA
 */
@ManagedBean(name = "RelatorioBancaController")
@SessionScoped
public class RelatorioBancaController extends BasicController {

    private List<VwTipoCorrecaoFeita> listaRelatorio;
    private int idProcesso;
    private List<VwEstatisticaCorrecaoPorCorretor> correcoesPorCorretor;
    private List<VwEstatisticaCriterioCorrecaoFeita> criteriosCorrecoes;
    private List<VwCorrecaoFeitaPorCurso> correcoesPorCurso;
    private boolean bolOrdenarRelCriterioCorrecaoPorQuantidade = false;
    private TbProcesso processoSelecionado = null;
    private DataModel gridDisciplinas;
    private TbDisciplina disciplinaSelecionada = null;

    public RelatorioBancaController() {
    }

    public int getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(int idProcesso) {
        this.idProcesso = idProcesso;
    }

    public List<VwTipoCorrecaoFeita> getListaRelatorio() {
        return listaRelatorio;
    }

    public void setListaRelatorio(List<VwTipoCorrecaoFeita> listaRelatorio) {
        this.listaRelatorio = listaRelatorio;
    }

    public List<VwEstatisticaCorrecaoPorCorretor> getCorrecoesPorCorretor() {
        return correcoesPorCorretor;
    }

    public void setCorrecoesPorCorretor(List<VwEstatisticaCorrecaoPorCorretor> correcoesPorCorretor) {
        this.correcoesPorCorretor = correcoesPorCorretor;
    }

    public List<VwCorrecaoFeitaPorCurso> getCorrecoesPorCurso() {
        return correcoesPorCurso;
    }

    public void setCorrecoesPorCurso(List<VwCorrecaoFeitaPorCurso> correcoesPorCurso) {
        this.correcoesPorCurso = correcoesPorCurso;
    }

    public List<VwEstatisticaCriterioCorrecaoFeita> getCriteriosCorrecoes() {
        return criteriosCorrecoes;
    }

    public void setCriteriosCorrecoes(List<VwEstatisticaCriterioCorrecaoFeita> criteriosCorrecoes) {
        this.criteriosCorrecoes = criteriosCorrecoes;
    }

    public String encaminhaPaginaDisciplinas() {
        ProcessoController pc = ProcessoController.getInstance();
        if (pc != null) {
            TbProcesso selecionado = (TbProcesso) pc.getGridProcessos().getRowData();
            this.setProcessoSelecionado(selecionado);
            this.consultaListaDisciplinasPorProcesso(selecionado.getIdProcesso().intValue());
        }
        return "/view/banca/rel/provasCorrigidasDisciplinas.xhtml";
    }

    /*public String geraRelatorioProvasCorrigidas(){
    ProcessoController pc = ProcessoController.getInstance();
    VwTipoCorrecaoFeitaService vtcf = new VwTipoCorrecaoFeitaServiceImpl();
    if(pc!=null){
    TbProcesso selecionado = (TbProcesso) pc.getGridProcessos().getRowData();
    listaRelatorio =  vtcf.pesquisarPorProcesso(selecionado.getIdProcesso());
    
    }
    
    return "/view/banca/rel/lista/listaTipoCorrecaoFeita.xhtml";
    }*/
    public String geraRelatorioProvasCorrigidas() {
        DisciplinaController dc = DisciplinaController.getInstance();
        VwTipoCorrecaoFeitaService vtcf = new VwTipoCorrecaoFeitaServiceImpl();
        if (dc != null) {
            TbDisciplina selecionada = (TbDisciplina) dc.getGridDisciplinas().getRowData();
            this.setDisciplinaSelecionada(selecionada);
            listaRelatorio = vtcf.pesquisarPorProcessoEDisciplina(processoSelecionado.getIdProcesso(), disciplinaSelecionada.getIdDisciplina());
        }
        processoSelecionado = new TbProcesso();
        disciplinaSelecionada = new TbDisciplina();
        return "/view/banca/rel/lista/listaTipoCorrecaoFeita.xhtml";
    }

    public String geraRelatorioCorrecaoFeitaPorCurso() {

        DisciplinaController dc = DisciplinaController.getInstance();
        VwCorrecaoFeitaPorCursoService vcfc = new VwCorrecaoFeitaPorCursoServiceImpl();
        if (this.getGridDisciplinas() != null && this.getGridDisciplinas().isRowAvailable()) {
            TbDisciplina dscSelecionada =  (TbDisciplina) this.gridDisciplinas.getRowData();
            this.setDisciplinaSelecionada(dscSelecionada);
            this.correcoesPorCurso = vcfc.pesquisarPorProcessoDisciplina(this.getProcessoSelecionado().getIdProcesso().intValue(), this.getDisciplinaSelecionada().getIdDisciplina().intValue());
        } else {
            this.correcoesPorCurso = vcfc.pesquisarPorProcesso(this.getProcessoSelecionado().getIdProcesso().intValue());
        }
        return "/view/banca/rel/lista/correcaoFeitaPorCurso.xhtml";
    }

    public String geraRelatorioCorrecoesPorCorretor() {

        VwEstatisticaCorrecaoPorCorretorService vecc = new VwEstatisticaCorrecaoPorCorretorServiceImpl();
        if (this.getGridDisciplinas() != null && this.getGridDisciplinas().isRowAvailable()) {
            TbDisciplina dscSelecionada = (TbDisciplina) this.gridDisciplinas.getRowData();
            this.setDisciplinaSelecionada(dscSelecionada);
            this.correcoesPorCorretor = vecc.pesquisarPorProcessoDisciplina(this.getProcessoSelecionado().getIdProcesso().intValue(), this.getDisciplinaSelecionada().getIdDisciplina().intValue());
        } else {
            this.correcoesPorCorretor = vecc.pesquisarPorProcesso(this.getProcessoSelecionado().getIdProcesso().intValue());
        }
        return "/view/banca/rel/lista/estatisticaCorrecaoPorCorretor.xhtml";
    }

    public String encaminhaListaDisciplinasProvasPorCorretor() {
        ProcessoController pc = ProcessoController.getInstance();
        if (pc != null) {
            TbProcesso selecionado = (TbProcesso) pc.getGridProcessos().getRowData();
            this.setProcessoSelecionado(selecionado);
            this.consultaListaDisciplinasPorProcesso(selecionado.getIdProcesso().intValue());
        }
        return "/view/banca/rel/provasPorCorretorDisciplinas.xhtml";
    }

    public String encaminhaListaDisciplinasCorrecoesPorCurso() {

        boolean bolAdministrador = false;
        int idDisciplinaSelecionada = 0;
        UsuarioController uc = UsuarioController.getInstance();

        if (uc != null && uc.getUsuario() != null) {
            TbUsuarioPerfil up = (new UsuarioPerfilServiceImpl()).pesquisarPorIDUsuario(uc.getUsuario().getIdUsuario());
            bolAdministrador = (up.getTbPerfil() != null && up.getTbPerfil().getIdPerfil() != null && up.getTbPerfil().getIdPerfil().intValue() == Uteis.PERFIL_ADMINISTRADOR);
        }


        if (!bolAdministrador) {
            if (uc != null && uc.getUsuario() != null && uc.getUsuario().getIdDisciplina() != null && uc.getUsuario().getIdDisciplina().getIdDisciplina() != null && uc.getUsuario().getIdDisciplina().getIdDisciplina().intValue() > 0) {
                idDisciplinaSelecionada = uc.getUsuario().getIdDisciplina().getIdDisciplina().intValue();
            }
        }

        ProcessoController pc = ProcessoController.getInstance();
        if (pc != null) {
            TbProcesso selecionado = (TbProcesso) pc.getGridProcessos().getRowData();
            this.setProcessoSelecionado(selecionado);
        }
        
        if (idDisciplinaSelecionada == 0) {
            this.consultaListaDisciplinasPorProcesso(this.getProcessoSelecionado().getIdProcesso().intValue());
            return "/view/banca/rel/correcaoFeitaPorCursoDisciplina.xhtml";
        }else{
            this.correcoesPorCurso = (new VwCorrecaoFeitaPorCursoServiceImpl()).pesquisarPorProcessoDisciplina(this.getProcessoSelecionado().getIdProcesso().intValue(), idDisciplinaSelecionada);
            return "/view/banca/rel/lista/correcaoFeitaPorCurso.xhtml";
        }

    }

    public String geraRelatorioCriterioCorrecao() {
        VwEstatisticaCriterioCorrecaoFeitaService veccf = new VwEstatisticaCriterioCorrecaoFeitaServiceImpl();

        ProcessoController pc = ProcessoController.getInstance();
        if (pc != null) {
            if (pc.getGridProcessos() != null && pc.getGridProcessos().isRowAvailable()) {
                TbProcesso selecionado = (TbProcesso) pc.getGridProcessos().getRowData();
                this.setProcessoSelecionado(selecionado);
            }
        }

        if (this.getProcessoSelecionado() != null) {
            if (this.isBolOrdenarRelCriterioCorrecaoPorQuantidade()) {
                criteriosCorrecoes = veccf.pesquisarPorProcessoOrdenadoQuant(this.getProcessoSelecionado().getIdProcesso());
            } else {
                criteriosCorrecoes = veccf.pesquisarPorProcesso(this.getProcessoSelecionado().getIdProcesso());
            }
        }
        return "/view/banca/rel/lista/estatisticaCriterioCorrecaoFeita.xhtml";
    }

    public void recarregaConsultaOrdenacaoCriterioCorrecaoQuantidade() {
        this.geraRelatorioCriterioCorrecao();
    }

    public void recarregaConsultaOrdenacaoCriterioCorrecaoQuantidadeTroca() {
        this.bolOrdenarRelCriterioCorrecaoPorQuantidade = !this.bolOrdenarRelCriterioCorrecaoPorQuantidade;
        this.geraRelatorioCriterioCorrecao();
    }

    public boolean isBolOrdenarRelCriterioCorrecaoPorQuantidade() {
        return bolOrdenarRelCriterioCorrecaoPorQuantidade;
    }

    public void setBolOrdenarRelCriterioCorrecaoPorQuantidade(boolean bolOrdenarRelCriterioCorrecaoPorQuantidade) {
        this.bolOrdenarRelCriterioCorrecaoPorQuantidade = bolOrdenarRelCriterioCorrecaoPorQuantidade;
    }

    public TbProcesso getProcessoSelecionado() {
        return processoSelecionado;
    }

    public void setProcessoSelecionado(TbProcesso processoSelecionado) {
        this.processoSelecionado = processoSelecionado;
    }

    public int getQuantidadeTotalProvasPorProcessoDisciplina() {
        System.out.println("Disciplina: " + this.getDisciplinaSelecionada());
        System.out.println("Processo: " + this.getProcessoSelecionado());
        if (this.getDisciplinaSelecionada() == null || this.getProcessoSelecionado() == null) {
            return 0;
        }
        return (new RespostaServiceImpl()).quantidadeProvasPorDisciplinaProcesso(this.getDisciplinaSelecionada().getIdDisciplina().intValue(), this.getProcessoSelecionado().getIdProcesso().intValue());
    }

    public TbDisciplina getDisciplinaSelecionada() {
        return disciplinaSelecionada;
    }

    public void setDisciplinaSelecionada(TbDisciplina disciplinaSelecionada) {
        this.disciplinaSelecionada = disciplinaSelecionada;
    }

    private void consultaListaDisciplinasPorProcesso(int idProcesso) {
        //VwProcessoDisciplinaService vpds = new VwProcessoDisciplinaServiceImpl();
        this.gridDisciplinas = new ListDataModel(new DisciplinaServiceImpl().pesquisarTodosOrdenadasComResposta());
    }

    public DataModel getGridDisciplinas() {
        return gridDisciplinas;
    }

    public void setGridDisciplinas(DataModel gridDisciplinas) {
        this.gridDisciplinas = gridDisciplinas;
    }
}
