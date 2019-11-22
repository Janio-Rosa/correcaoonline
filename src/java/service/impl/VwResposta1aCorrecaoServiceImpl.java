/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;
import dao.VwResposta1aCorrecaoDAO;
import dao.impl.RespostaDAOImpl;
import dao.impl.VwResposta1aCorrecaoDAOImpl;
import java.util.List;
import model.TbResposta;
import model.VwResposta1aCorrecao;
import service.VwResposta1aCorrecaoService;

/**
 *
 * @author administrator
 */
public class VwResposta1aCorrecaoServiceImpl implements VwResposta1aCorrecaoService {

    @Override
    public List<VwResposta1aCorrecao> pesquisarTodos() {
        VwResposta1aCorrecaoDAO xy = new VwResposta1aCorrecaoDAOImpl();
        return xy.pesquisarTodos();
    }

    @Override
    public VwResposta1aCorrecao pesquisarPorIDLong(long id) {
        VwResposta1aCorrecaoDAO xy = new VwResposta1aCorrecaoDAOImpl();
        return xy.pesquisarPorIDLong(id);
    }

    @Override
    public List<VwResposta1aCorrecao> pesquisarTodosOrdenado() {
        VwResposta1aCorrecaoDAO xy = new VwResposta1aCorrecaoDAOImpl();
        String[] atributoOrdenar={"IdResposta"};
        return xy.pesquisarTodosOrdenado(atributoOrdenar);
    }

    @Override
    public List<VwResposta1aCorrecao> pesquisaPorInscricao(int nrInscricao) {
        VwResposta1aCorrecaoDAO xy = new VwResposta1aCorrecaoDAOImpl();
        return xy.pesquisaPorInscricao(nrInscricao);
    }

    @Override
    public TbResposta pesquisarProximaRespostaPrimeiraCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao) {
        VwResposta1aCorrecaoDAO xy = new VwResposta1aCorrecaoDAOImpl();
        VwResposta1aCorrecao retorno = xy.pesquisarProximaRespostaPrimeiraCorrecaoPorQuestao(idDisciplina,idCurso,idProcesso,idQuestao);
        TbResposta corrigir = null;
        if(retorno!=null)
            corrigir = new RespostaDAOImpl().pesquisarPorIDLong(retorno.getIdResposta().longValue());
        return corrigir;
    }
    
}
