/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.EmpresaDAO;
import dao.impl.EmpresaDAOImpl;
import java.util.List;
import model.TbEmpresa;
import service.EmpresaService;

/**
 *
 * @author Janio
 */
public class EmpresaServiceImpl implements EmpresaService {

    @Override
    public List<TbEmpresa> pesquisarTodos() {
        EmpresaDAO rnd = new EmpresaDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public TbEmpresa inserir(TbEmpresa retornoNis) {
        EmpresaDAO rnd = new EmpresaDAOImpl();
        return rnd.inserir(retornoNis);
    }

    @Override
    public TbEmpresa atualizar(TbEmpresa retornoNis) {
        EmpresaDAO rnd = new EmpresaDAOImpl();
        return rnd.atualizar(retornoNis);
    }

    @Override
    public boolean apagar(TbEmpresa retornoNis) {
        EmpresaDAO rnd = new EmpresaDAOImpl();
        return rnd.apagar(retornoNis);
    }

    @Override
    public TbEmpresa pesquisarPorID(int id) {
        EmpresaDAO rnd = new EmpresaDAOImpl();
        return rnd.pesquisarPorID(id);
    }

    @Override
    public List<TbEmpresa> pesquisarTodosOrdenado() {
        EmpresaDAO rnd = new EmpresaDAOImpl();
        String[] criterios = {"nmEmpresa"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }
    
}
