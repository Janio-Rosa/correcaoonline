/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.FuncionalidadeDAO;
import dao.impl.FuncionalidadeDAOImpl;
import java.util.List;
import model.TbFuncionalidade;
import service.FuncionalidadeService;

/**
 *
 * @author KAMYLLA
 */
public class FuncionalidadeServiceImpl implements FuncionalidadeService {
    
     @Override
    public List<TbFuncionalidade> pesquisarTodos() {
        FuncionalidadeDAO dd =  new FuncionalidadeDAOImpl();
        return dd.pesquisarTodos();
    }

    @Override
    public TbFuncionalidade inserir(TbFuncionalidade nome) {
        FuncionalidadeDAO dd = new FuncionalidadeDAOImpl();
        return dd.inserir(nome);
    }

    @Override
    public TbFuncionalidade atualizar(TbFuncionalidade nome) {
        FuncionalidadeDAO dd =  new FuncionalidadeDAOImpl();
        return dd.atualizar(nome);
    }

    @Override
    public boolean apagar(TbFuncionalidade nome) {
        FuncionalidadeDAO dd =  new FuncionalidadeDAOImpl();
        return dd.apagar(nome);
    }

    @Override
    public TbFuncionalidade pesquisarPorID(int id) {
        FuncionalidadeDAO dd =  new FuncionalidadeDAOImpl();
        return dd.pesquisarPorID(id);
    }

    @Override
    public List<TbFuncionalidade> pesquisarTodosOrdenado() {
        FuncionalidadeDAO dd =  new FuncionalidadeDAOImpl();
        String[] criterios = {"nmFuncionalidade"};
        return dd.pesquisarTodosOrdenado(criterios);
    
    }

}