/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwResposta3aCorrecaoDAO;
import dao.impl.RespostaDAOImpl;
import dao.impl.VwResposta3aCorrecaoDAOImpl;
import java.util.List;
import model.TbResposta;
import model.VwResposta3aCorrecao;
import service.VwResposta3aCorrecaoService;

/**
 *
 * @author administrator
 */
public class VwResposta3aCorrecaoServiceImpl implements VwResposta3aCorrecaoService {

    @Override
    public List<VwResposta3aCorrecao> pesquisarTodos() {
        VwResposta3aCorrecaoDAO xy = new VwResposta3aCorrecaoDAOImpl();
        return xy.pesquisarTodos();
    }

    @Override
    public VwResposta3aCorrecao pesquisarPorIDLong(long id) {
        VwResposta3aCorrecaoDAO xy = new VwResposta3aCorrecaoDAOImpl();
        return xy.pesquisarPorIDLong(id);
    }

    @Override
    public List<VwResposta3aCorrecao> pesquisarTodosOrdenado() {
        VwResposta3aCorrecaoDAO xy = new VwResposta3aCorrecaoDAOImpl();
        String[] atributoOrdenar={"IdResposta"};
        return xy.pesquisarTodosOrdenado(atributoOrdenar);
    }

    @Override
    public List<VwResposta3aCorrecao> pesquisaPorInscricao(int nrInscricao) {
        VwResposta3aCorrecaoDAO xy = new VwResposta3aCorrecaoDAOImpl();
        return xy.pesquisaPorInscricao(nrInscricao);
    }

    @Override
    public TbResposta pesquisarProximaRespostaTerceiraCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao) {
        VwResposta3aCorrecaoDAO xy = new VwResposta3aCorrecaoDAOImpl();
        VwResposta3aCorrecao retorno = xy.pesquisarProximaRespostaTerceiraCorrecaoPorQuestao(idDisciplina,idCurso,idProcesso,idQuestao);
        TbResposta corrigir = null;
        if(retorno!=null)
            corrigir = new RespostaDAOImpl().pesquisarPorIDLong(retorno.getIdResposta().longValue());
        return corrigir;
    }
    
}
