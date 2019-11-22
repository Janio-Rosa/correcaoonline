/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.UsuarioPerfilDAO;
import dao.impl.UsuarioPerfilDAOImpl;
import java.util.List;
import model.TbUsuarioPerfil;
import service.UsuarioPerfilService;

/**
 *
 * @author KAMYLLA
 */
public class UsuarioPerfilServiceImpl implements UsuarioPerfilService {

    @Override
    public List<TbUsuarioPerfil> pesquisarTodos() {
        UsuarioPerfilDAO dd = new UsuarioPerfilDAOImpl();
        return dd.pesquisarTodos();
    }

    @Override
    public TbUsuarioPerfil inserir(TbUsuarioPerfil nome) {
        UsuarioPerfilDAO dd = new UsuarioPerfilDAOImpl();
        return dd.inserir(nome);
    }

    @Override
    public TbUsuarioPerfil atualizar(TbUsuarioPerfil nome) {
        UsuarioPerfilDAO dd = new UsuarioPerfilDAOImpl();
        return dd.atualizar(nome);
    }

    @Override
    public boolean apagar(TbUsuarioPerfil nome) {
        UsuarioPerfilDAO dd = new UsuarioPerfilDAOImpl();
        return dd.apagar(nome);
    }

    @Override
    public TbUsuarioPerfil pesquisarPorID(int id) {
        UsuarioPerfilDAO dd = new UsuarioPerfilDAOImpl();
        return dd.pesquisarPorID(id);
    }

    @Override
    public List<TbUsuarioPerfil> pesquisarTodosOrdenado() {
        UsuarioPerfilDAO dd = new UsuarioPerfilDAOImpl();
        String[] criterios = {"dtInclusao"};
        return dd.pesquisarTodosOrdenado(criterios);

    }

    @Override
    public TbUsuarioPerfil pesquisarPorPerfilEUsuario(int idPerfil, long idUsuario) {
        UsuarioPerfilDAO dd = new UsuarioPerfilDAOImpl();
        return dd.pesquisarPorPerfilEUsuario(idPerfil, idUsuario);
    }

    @Override
    public TbUsuarioPerfil pesquisarPorIDUsuario(long idUsuario) {
        UsuarioPerfilDAO dd = new UsuarioPerfilDAOImpl();
        return dd.pesquisarPorIDUsuario(idUsuario);
    }
}