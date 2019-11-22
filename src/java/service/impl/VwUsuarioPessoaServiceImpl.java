/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwUsuarioPessoaDAO;
import dao.impl.VwUsuarioPessoaDAOImpl;
import java.util.List;
import model.VwUsuarioPessoa;
import service.VwUsuarioPessoaService;

/**
 *
 * @author Janio
 */
public class VwUsuarioPessoaServiceImpl implements VwUsuarioPessoaService  {

    @Override
    public List<VwUsuarioPessoa> pesquisarTodos() {
        VwUsuarioPessoaDAO rnd = new VwUsuarioPessoaDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public VwUsuarioPessoa pesquisarPorID(int id) {
        VwUsuarioPessoaDAO rnd = new VwUsuarioPessoaDAOImpl();
        return rnd.pesquisarPorID(id);
    }

    @Override
    public VwUsuarioPessoa pesquisarPorIDLong(long id) {
        VwUsuarioPessoaDAO rnd = new VwUsuarioPessoaDAOImpl();
        return rnd.pesquisarPorIDLong(id);
    }

    @Override
    public List<VwUsuarioPessoa> pesquisarTodosOrdenado() {
        VwUsuarioPessoaDAO rnd = new VwUsuarioPessoaDAOImpl();
        String[] criteriosOrdenacao = {"nmPessoa"};
        return rnd.pesquisarTodosOrdenado(criteriosOrdenacao);
    }
    
}
