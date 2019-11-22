/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwRespostaInscricaoDAO;
import dao.impl.VwRespostaInscricaoDAOImpl;
import java.util.List;
import model.VwRespostaInscricaoCorrecao;
import service.VwRespostaInscricaoService;

/**
 *
 * @author administrator
 */
public class VwRespostaInscricaoServiceImpl implements VwRespostaInscricaoService {
    
    @Override
    public List<VwRespostaInscricaoCorrecao> pesquisarTodos() {
        VwRespostaInscricaoDAO vrcd = new VwRespostaInscricaoDAOImpl();
        return vrcd.pesquisarTodos();
    }

    @Override
    public List<VwRespostaInscricaoCorrecao> pesquisarTodosOrdenado() {
        VwRespostaInscricaoDAO vrcd = new VwRespostaInscricaoDAOImpl();
        String[] criterios = {"idCorrecao"};
        return vrcd.pesquisarTodosOrdenado(criterios);
    }

    @Override
    public VwRespostaInscricaoCorrecao pesquisarPorIDLong(long id) {
        VwRespostaInscricaoDAO vrcd = new VwRespostaInscricaoDAOImpl();
        return vrcd.pesquisarPorIDLong(id);
    }

    @Override
    public List<VwRespostaInscricaoCorrecao> pesquisaPorInscricao(int nrInscricao) {
        VwRespostaInscricaoDAO vrcd = new VwRespostaInscricaoDAOImpl();
        return vrcd.pesquisaPorInscricao(nrInscricao);
    }

    @Override
    public float notaTotalPorIdResposta(long idResposta) {
        VwRespostaInscricaoDAO vrcd = new VwRespostaInscricaoDAOImpl();
        return vrcd.notaTotalPorIdResposta(idResposta);
    }

    @Override
    public List<VwRespostaInscricaoCorrecao> pesquisaPorCursoDisciplinaQuestao(int idCurso, int idDisciplina, int nrQuestao) {
        VwRespostaInscricaoDAO vrcd = new VwRespostaInscricaoDAOImpl();
        return vrcd.pesquisaPorCursoDisciplinaQuestao(idCurso, idDisciplina, nrQuestao);

    }
    
}
