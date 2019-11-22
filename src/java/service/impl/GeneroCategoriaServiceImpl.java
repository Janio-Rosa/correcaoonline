/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.GeneroCategoriaDAO;
import dao.impl.GeneroCategoriaDAOImpl;
import java.util.List;
import model.TbGeneroCategoria;
import service.GeneroCategoriaService;

/**
 *
 * @author Janio
 */
public class GeneroCategoriaServiceImpl implements GeneroCategoriaService {

    @Override
    public List<TbGeneroCategoria> pesquisarTodos() {
        GeneroCategoriaDAO cd =  new GeneroCategoriaDAOImpl();
        return cd.pesquisarTodos();
    }

    @Override
    public TbGeneroCategoria inserir(TbGeneroCategoria nome) {
        GeneroCategoriaDAO cd = new GeneroCategoriaDAOImpl();
        return cd.inserir(nome);
    }

    @Override
    public TbGeneroCategoria atualizar(TbGeneroCategoria nome) {
        GeneroCategoriaDAO cd =  new GeneroCategoriaDAOImpl();
        return cd.atualizar(nome);
    }

    @Override
    public boolean apagar(TbGeneroCategoria nome) {
        GeneroCategoriaDAO cd =  new GeneroCategoriaDAOImpl();
        return cd.apagar(nome);
    }

    @Override
    public TbGeneroCategoria pesquisarPorID(int id) {
        GeneroCategoriaDAO cd =  new GeneroCategoriaDAOImpl();
        return cd.pesquisarPorID(id);
    }

    @Override
    public List<TbGeneroCategoria> pesquisarTodosOrdenado() {
        GeneroCategoriaDAO cd =  new GeneroCategoriaDAOImpl();
        String[] criterios = {"nmGeneroCategoria"};
        return cd.pesquisarTodosOrdenado(criterios);
    }

    @Override
    public List<TbGeneroCategoria> pesquisarTodosSemGeral() {
        GeneroCategoriaDAO cd =  new GeneroCategoriaDAOImpl();
        String[] criterios = {"nmGeneroCategoria"};
        return cd.pesquisarTodosSemGeral(criterios);
    }


    @Override
    public List<TbGeneroCategoria> pesquisarTodosSemGeralPorTipoQuestao(int tipoQuestao) {
        GeneroCategoriaDAO cd =  new GeneroCategoriaDAOImpl();
        return cd.pesquisarTodosSemGeralPorTipoQuestao(tipoQuestao);
    }
    
}
