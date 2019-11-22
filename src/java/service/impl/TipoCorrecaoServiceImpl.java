/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;
import java.util.List;
import model.TbTipoCorrecao;
import dao.TipoCorrecaoDAO;
import dao.impl.TipoCorrecaoDAOImpl;
import service.TipoCorrecaoService;

/**
 *
 * @author Janio
 */
public class TipoCorrecaoServiceImpl implements TipoCorrecaoService  {
    @Override
    public List<TbTipoCorrecao> pesquisarTodos() {
        TipoCorrecaoDAO rnd = new TipoCorrecaoDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public TbTipoCorrecao inserir(TbTipoCorrecao retornoNis) {
        TipoCorrecaoDAO rnd = new TipoCorrecaoDAOImpl();
        return rnd.inserir(retornoNis);
    }

    @Override
    public TbTipoCorrecao atualizar(TbTipoCorrecao retornoNis) {
        TipoCorrecaoDAO rnd = new TipoCorrecaoDAOImpl();
        return rnd.atualizar(retornoNis);
    }

    @Override
    public boolean apagar(TbTipoCorrecao retornoNis) {
        TipoCorrecaoDAO rnd = new TipoCorrecaoDAOImpl();
        return rnd.apagar(retornoNis);
    }

    @Override
    public TbTipoCorrecao pesquisarPorID(int id) {
        TipoCorrecaoDAO rnd = new TipoCorrecaoDAOImpl();
        return rnd.pesquisarPorID(id);
    }

    @Override
    public List<TbTipoCorrecao> pesquisarTodosOrdenado() {
        TipoCorrecaoDAO rnd = new TipoCorrecaoDAOImpl();
        String[] criterios = {"nmTipoCorrecao"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }
    
}
