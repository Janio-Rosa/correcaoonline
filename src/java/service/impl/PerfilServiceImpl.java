/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.PerfilDAO;
import dao.impl.PerfilDAOImpl;
import java.util.List;
import model.TbPerfil;
import service.PerfilService;

/**
 *
 * @author KAMYLLA
 */
public class PerfilServiceImpl implements PerfilService {
    
     @Override
    public List<TbPerfil> pesquisarTodos() {
        PerfilDAO dd =  new PerfilDAOImpl();
        return dd.pesquisarTodos();
    }

    @Override
    public TbPerfil inserir(TbPerfil nome) {
        PerfilDAO dd = new PerfilDAOImpl();
        return dd.inserir(nome);
    }

    @Override
    public TbPerfil atualizar(TbPerfil nome) {
        PerfilDAO dd =  new PerfilDAOImpl();
        return dd.atualizar(nome);
    }

    @Override
    public boolean apagar(TbPerfil nome) {
        PerfilDAO dd =  new PerfilDAOImpl();
        return dd.apagar(nome);
    }

    @Override
    public TbPerfil pesquisarPorID(int id) {
        PerfilDAO dd =  new PerfilDAOImpl();
        return dd.pesquisarPorID(id);
    }

    @Override
    public List<TbPerfil> pesquisarTodosOrdenado() {
        PerfilDAO dd =  new PerfilDAOImpl();
        String[] criterios = {"nmPerfil"};
        return dd.pesquisarTodosOrdenado(criterios);
    
    }

}