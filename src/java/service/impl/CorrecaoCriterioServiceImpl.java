/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;
import java.util.List;
import model.TbCorrecaoCriterio;
import dao.CorrecaoCriterioDAO;
import dao.impl.CorrecaoCriterioDAOImpl;
import model.TbCorrecao;
import model.TbCriterio;
import service.CorrecaoCriterioService;

/**
 *
 * @author Janio
 */
public class CorrecaoCriterioServiceImpl  implements CorrecaoCriterioService {
    @Override
    public List<TbCorrecaoCriterio> pesquisarTodos() {
        CorrecaoCriterioDAO rnd = new CorrecaoCriterioDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public TbCorrecaoCriterio inserir(TbCorrecaoCriterio retornoNis) {
        CorrecaoCriterioDAO rnd = new CorrecaoCriterioDAOImpl();
        return rnd.inserir(retornoNis);
    }

    @Override
    public TbCorrecaoCriterio atualizar(TbCorrecaoCriterio retornoNis) {
        CorrecaoCriterioDAO rnd = new CorrecaoCriterioDAOImpl();
        return rnd.atualizar(retornoNis);
    }

    @Override
    public boolean apagar(TbCorrecaoCriterio retornoNis) {
        CorrecaoCriterioDAO rnd = new CorrecaoCriterioDAOImpl();
        return rnd.apagar(retornoNis);
    }

    @Override
    public TbCorrecaoCriterio pesquisarPorID(int id) {
        CorrecaoCriterioDAO rnd = new CorrecaoCriterioDAOImpl();
        return rnd.pesquisarPorID(id);
    }

    @Override
    public List<TbCorrecaoCriterio> pesquisarTodosOrdenado() {
        CorrecaoCriterioDAO rnd = new CorrecaoCriterioDAOImpl();
        String[] criterios = {"idCriterio"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }

    @Override
    public List<TbCorrecaoCriterio> pesquisarPorCorrecao(long idCorrecao) {
        CorrecaoCriterioDAO rnd = new CorrecaoCriterioDAOImpl();
        TbCorrecao pesquisa=new TbCorrecao(idCorrecao);
        return rnd.pesquisarPorCorrecao(pesquisa);
    }

    @Override
    public TbCorrecaoCriterio pesquisarPorIDLong(long idCorrecaoCriterio) {
        CorrecaoCriterioDAO rnd = new CorrecaoCriterioDAOImpl();
        return rnd.pesquisarPorIDLong(idCorrecaoCriterio);
    }

    @Override
    public TbCorrecaoCriterio pesquisarPorCorrecaoCriterio(long idCorrecao,TbCriterio criterio) {
        CorrecaoCriterioDAO rnd = new CorrecaoCriterioDAOImpl();
        TbCorrecao pesquisa=new TbCorrecao(idCorrecao);
        return rnd.pesquisarPorCorrecaoCriterio(pesquisa,criterio);
    }
    

}
