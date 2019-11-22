/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.ResumoCorrecaoCriterioDAO;
import dao.impl.ResumoCorrecaoCriterioDAOImpl;
import java.util.List;
import model.TbResumoCorrecaoCriterio;
import service.ResumoCorrecaoCriterioService;

/**
 *
 * @author administrator
 */
public class ResumoCorrecaoCriterioServiceImpl implements ResumoCorrecaoCriterioService {

    @Override
    public List<TbResumoCorrecaoCriterio> pesquisarTodos() {
        ResumoCorrecaoCriterioDAO rnd = new ResumoCorrecaoCriterioDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public TbResumoCorrecaoCriterio inserir(TbResumoCorrecaoCriterio obj) {
        ResumoCorrecaoCriterioDAO rnd = new ResumoCorrecaoCriterioDAOImpl();
        return rnd.inserir(obj);
    }

    @Override
    public TbResumoCorrecaoCriterio atualizar(TbResumoCorrecaoCriterio obj) {
        ResumoCorrecaoCriterioDAO rnd = new ResumoCorrecaoCriterioDAOImpl();
        return rnd.atualizar(obj);
    }

    @Override
    public boolean apagar(TbResumoCorrecaoCriterio retornoNis) {
        ResumoCorrecaoCriterioDAO rnd = new ResumoCorrecaoCriterioDAOImpl();
        return rnd.apagar(retornoNis);
    }

    @Override
    public TbResumoCorrecaoCriterio pesquisarPorID(int id) {
        ResumoCorrecaoCriterioDAO rnd = new ResumoCorrecaoCriterioDAOImpl();
        return rnd.pesquisarPorID(id);
    }

    @Override
    public List<TbResumoCorrecaoCriterio> pesquisarTodosOrdenado() {
        ResumoCorrecaoCriterioDAO rnd = new ResumoCorrecaoCriterioDAOImpl();
        String[] myOrder = {"idCriterio"};
        return rnd.pesquisarTodosOrdenado(myOrder);
    }

    @Override
    public List<TbResumoCorrecaoCriterio> pesquisarPorIdCorrecao(long idCorrecao) {
        ResumoCorrecaoCriterioDAO rnd = new ResumoCorrecaoCriterioDAOImpl();
        return rnd.pesquisarPorIdCorrecao(idCorrecao);
    }

    @Override
    public TbResumoCorrecaoCriterio pesquisarPorIDLong(long idCorrecaoCriterio) {
        ResumoCorrecaoCriterioDAO rnd = new ResumoCorrecaoCriterioDAOImpl();
        return rnd.pesquisarPorIDLong(idCorrecaoCriterio);
    }

    @Override
    public TbResumoCorrecaoCriterio pesquisarPorIdCorrecaoIdCriterio(long idCorrecao,int criterio) {
        ResumoCorrecaoCriterioDAO rnd = new ResumoCorrecaoCriterioDAOImpl();
        return rnd.pesquisarPorIdCorrecaoIdCriterio(idCorrecao,criterio);
    }
    
    
}
