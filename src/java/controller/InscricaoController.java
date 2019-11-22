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
import model.TbColaborador;
import model.TbResposta;
import model.VwRespostaInscricaoCorrecao;
import service.RespostaService;
import service.impl.RespostaServiceImpl;
import service.impl.VwRespostaInscricaoServiceImpl;

/**
 *
 * @author Janio
 */
@ManagedBean(name = "InscricaoController")
@SessionScoped
public class InscricaoController {

    private List<VwRespostaInscricaoCorrecao> listaInscricoes = null;
    private DataModel gridInscricoes;
    private VwRespostaInscricaoCorrecao inscricaoSelecionada = null;

    public InscricaoController() {

        consultaInscricoes();
    }

    public String prepararSelecaoInscricao() {
        if (this.gridInscricoes.isRowAvailable()) {
            VwRespostaInscricaoCorrecao sel = (VwRespostaInscricaoCorrecao) this.gridInscricoes.getRowData();
            this.inscricaoSelecionada = sel;
        }
        UsuarioController uc = UsuarioController.getInstance();
        TbColaborador col = this.getColaboradorAtual();


        if (col != null) {
            //Libera alguma eventual resposta que esteja presa ao corretor atual
            this.liberaRespostaColaboradorAtual(col);

            //Atrela a resposta/inscrição selecionada ao colaborador atual
            this.prendeNovaRespostaSelecionada(col, this.inscricaoSelecionada);
        }
        //Chama tela de correção (a resposta selecionada será automaticamente mostrada para o corretor, uma vez que ela foi atrelada ao corretor/colaborador atual)
        String paginaRetorno = "/view/corretor/arquitetura/correcao.xhtml";

        if (uc != null) {
            CorrecaoController cc = CorrecaoController.getInstance();
            if (cc != null) {
                cc.proximaCorrecao();
            }
            paginaRetorno = uc.paginaCorrecaoUsuarioAtual(col);
        }

        return paginaRetorno;
        //return "/view/corretor/arquitetura/seleciona_inscricao.xhtml";
        //return "/view/banca/relatorio/definitivo/com/tela/da/view/rel_cor_feita.xhtml";
    }

    public DataModel getGridInscricoes() {
        return gridInscricoes;
    }

    public void setGridInscricoes(DataModel gridInscricoes) {
        this.gridInscricoes = gridInscricoes;
    }

    public VwRespostaInscricaoCorrecao getInscricaoSelecionada() {
        return inscricaoSelecionada;
    }

    public void setInscricaoSelecionada(VwRespostaInscricaoCorrecao inscricaoSelecionada) {
        this.inscricaoSelecionada = inscricaoSelecionada;
    }

    public List<VwRespostaInscricaoCorrecao> getListaInscricoes() {
        return listaInscricoes;
    }

    public void setListaInscricoes(List<VwRespostaInscricaoCorrecao> listaInscricoes) {
        this.listaInscricoes = listaInscricoes;
    }

    private void consultaInscricoes() {

        TbColaborador col = this.getColaboradorAtual();

        if (col != null) {
            int idCurso = 0;
            int idDisciplina = 0;
            int nrQuestao = 0;

            if (col.getIdBanca() != null && col.getIdBanca().getIdCurso() != null) {
                idCurso = col.getIdBanca().getIdCurso().getIdCurso();
            }

            if (col.getIdBanca() != null && col.getIdBanca().getIdDisciplina() != null) {
                idDisciplina = col.getIdBanca().getIdDisciplina().getIdDisciplina();
            }

            if (col.getIdQuestao() != null) {
                nrQuestao = col.getIdQuestao().getIdQuestao();
            }

            this.listaInscricoes = new VwRespostaInscricaoServiceImpl().pesquisaPorCursoDisciplinaQuestao(idCurso, idDisciplina, nrQuestao);

            this.gridInscricoes = new ListDataModel(this.listaInscricoes);

        }


    }

    private void liberaRespostaColaboradorAtual(TbColaborador colaborador) {
        RespostaService rs = new RespostaServiceImpl();
        TbResposta respTemp = rs.pesquisarRespostaPresaColaboradorAtual(colaborador.getIdColaborador());
        if (respTemp != null) {
            respTemp.setIdColaboradorAtual(null);
            respTemp.setFlCorrigindo(false);
            rs.atualizar(respTemp);
            respTemp = null;
        }
    }

    private void prendeNovaRespostaSelecionada(TbColaborador colaborador, VwRespostaInscricaoCorrecao respostaInscricao) {
        RespostaService rs = new RespostaServiceImpl();
        List<VwRespostaInscricaoCorrecao> respTemp = new VwRespostaInscricaoServiceImpl().pesquisaPorInscricao(respostaInscricao.getNrInscricao());
        TbResposta respostaACorrigir = null;
        for (VwRespostaInscricaoCorrecao inscricaoAtual : respTemp) {
            if (inscricaoAtual.getIdDisciplina().intValue() == colaborador.getIdBanca().getIdDisciplina().getIdDisciplina().intValue()) {
                respostaACorrigir = rs.pesquisarPorIDLong(inscricaoAtual.getIdResposta());
            }
        }
        if (respostaACorrigir != null) {
            respostaACorrigir.setIdColaboradorAtual(colaborador);
            respostaACorrigir.setFlCorrigindo(true);
            rs.atualizar(respostaACorrigir);
            respostaACorrigir = null;
        }
    }

    public String chamaTelaSelecaoInscricao() {
        this.consultaInscricoes();
        return "/view/corretor/certificacao/seleciona_inscricao.xhtml";
    }

    private TbColaborador getColaboradorAtual() {

        CorrecaoController cc = CorrecaoController.getInstance();
        UsuarioController uc = UsuarioController.getInstance();
        TbColaborador col = null;

        if (cc != null && cc.getColaborador() != null) {
            col = cc.getColaborador();
        } else if (uc != null && uc.getColaboradorLogado() != null) {
            col = uc.getColaboradorLogado();
        }

        return col;
    }
}
