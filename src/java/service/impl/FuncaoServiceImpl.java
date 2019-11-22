/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.FuncaoDAO;
import dao.impl.FuncaoDAOImpl;
import java.util.List;
import model.TbFuncao;
import service.FuncaoService;

/**
 *
 * @author KAMYLLA
 */
public class FuncaoServiceImpl implements FuncaoService {
    
     @Override
    public List<TbFuncao> pesquisarTodos() {
        FuncaoDAO fd =  new FuncaoDAOImpl();
        return fd.pesquisarTodos();
    }

    @Override
    public TbFuncao inserir(TbFuncao nome) {
        FuncaoDAO fd = new FuncaoDAOImpl();
        return fd.inserir(nome);
    }

    @Override
    public TbFuncao atualizar(TbFuncao nome) {
        FuncaoDAO fd =  new FuncaoDAOImpl();
        return fd.atualizar(nome);
    }

    @Override
    public boolean apagar(TbFuncao nome) {
        FuncaoDAO fd =  new FuncaoDAOImpl();
        return fd.apagar(nome);
    }

    @Override
    public TbFuncao pesquisarPorID(int id) {
        FuncaoDAO fd =  new FuncaoDAOImpl();
        return fd.pesquisarPorID(id);
    }

    @Override
    public List<TbFuncao> pesquisarTodosOrdenado() {
        FuncaoDAO fd =  new FuncaoDAOImpl();
        String[] criterios = {"nmFuncao"};
        return fd.pesquisarTodosOrdenado(criterios);
    
    }

}