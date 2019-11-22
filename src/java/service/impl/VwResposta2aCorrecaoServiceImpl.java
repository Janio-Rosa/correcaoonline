/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwResposta2aCorrecaoDAO;
import dao.impl.RespostaDAOImpl;
import dao.impl.VwResposta2aCorrecaoDAOImpl;
import java.util.List;
import model.TbResposta;
import model.VwResposta2aCorrecao;
import service.VwResposta2aCorrecaoService;

/**
 *
 * @author administrator
 */
public class VwResposta2aCorrecaoServiceImpl implements VwResposta2aCorrecaoService {

    @Override
    public List<VwResposta2aCorrecao> pesquisarTodos() {
        VwResposta2aCorrecaoDAO xy = new VwResposta2aCorrecaoDAOImpl();
        return xy.pesquisarTodos();
    }

    @Override
    public VwResposta2aCorrecao pesquisarPorIDLong(long id) {
        VwResposta2aCorrecaoDAO xy = new VwResposta2aCorrecaoDAOImpl();
        return xy.pesquisarPorIDLong(id);
    }

    @Override
    public List<VwResposta2aCorrecao> pesquisarTodosOrdenado() {
        VwResposta2aCorrecaoDAO xy = new VwResposta2aCorrecaoDAOImpl();
        String[] atributoOrdenar={"IdResposta"};
        return xy.pesquisarTodosOrdenado(atributoOrdenar);
    }

    @Override
    public List<VwResposta2aCorrecao> pesquisaPorInscricao(int nrInscricao) {
        VwResposta2aCorrecaoDAO xy = new VwResposta2aCorrecaoDAOImpl();
        return xy.pesquisaPorInscricao(nrInscricao);
    }

    @Override
    public TbResposta pesquisarProximaRespostaSegundaCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao) {
        VwResposta2aCorrecaoDAO xy = new VwResposta2aCorrecaoDAOImpl();
        VwResposta2aCorrecao retorno = xy.pesquisarProximaRespostaSegundaCorrecaoPorQuestao(idDisciplina,idCurso,idProcesso,idQuestao);
        TbResposta corrigir=null;
        if(retorno!=null)
             corrigir= new RespostaDAOImpl().pesquisarPorIDLong(retorno.getIdResposta().longValue());
        return corrigir;
    }
    
}
