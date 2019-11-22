/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.TipoQuestaoDAO;
import dao.impl.TipoQuestaoDAOImpl;
import java.util.List;
import model.TbTipoQuestao;
import service.TipoQuestaoService;

/**
 *
 * @author KAMYLLA
 */
public class TipoQuestaoServiceImpl implements TipoQuestaoService {
    
    @Override
    public List<TbTipoQuestao> pesquisarTodos() {
        TipoQuestaoDAO cd =  new TipoQuestaoDAOImpl();
        return cd.pesquisarTodos();
    }

    @Override
    public TbTipoQuestao inserir(TbTipoQuestao nome) {
        TipoQuestaoDAO cd = new TipoQuestaoDAOImpl();
        return cd.inserir(nome);
    }

    @Override
    public TbTipoQuestao atualizar(TbTipoQuestao nome) {
        TipoQuestaoDAO cd =  new TipoQuestaoDAOImpl();
        return cd.atualizar(nome);
    }

    @Override
    public boolean apagar(TbTipoQuestao nome) {
        TipoQuestaoDAO cd =  new TipoQuestaoDAOImpl();
        return cd.apagar(nome);
    }

    @Override
    public TbTipoQuestao pesquisarPorID(int id) {
        TipoQuestaoDAO cd =  new TipoQuestaoDAOImpl();
        return cd.pesquisarPorID(id);
    }

    @Override
    public List<TbTipoQuestao> pesquisarTodosOrdenado() {
        TipoQuestaoDAO cd =  new TipoQuestaoDAOImpl();
        String[] criterios = {"nmCategoria"};
        return cd.pesquisarTodosOrdenado(criterios);
    
    }

    
}
