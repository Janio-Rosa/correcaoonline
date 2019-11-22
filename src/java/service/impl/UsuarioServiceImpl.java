/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.UsuarioDAO;
import dao.impl.UsuarioDAOImpl;
import java.util.List;
import model.TbUsuario;
import service.UsuarioService;

/**
 *
 * @author Janio
 */
public class UsuarioServiceImpl implements UsuarioService {

    @Override
    public List<TbUsuario> pesquisarTodos() {
        UsuarioDAO rnd = new UsuarioDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public TbUsuario inserir(TbUsuario retornoNis) {
        UsuarioDAO rnd = new UsuarioDAOImpl();
        return rnd.inserir(retornoNis);
    }

    @Override
    public TbUsuario atualizar(TbUsuario retornoNis) {
        UsuarioDAO rnd = new UsuarioDAOImpl();
        return rnd.atualizar(retornoNis);
    }

    @Override
    public boolean apagar(TbUsuario retornoNis) {
        UsuarioDAO rnd = new UsuarioDAOImpl();
        return rnd.apagar(retornoNis);
    }

    @Override
    public TbUsuario pesquisarPorIDLong(long id) {
        UsuarioDAO rnd = new UsuarioDAOImpl();
        return rnd.pesquisarPorIDLong(id);
    }

    @Override
    public List<TbUsuario> pesquisarTodosOrdenado() {
        UsuarioDAO rnd = new UsuarioDAOImpl();
        String[] criterios = {"nmUsuario"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }
    
    @Override
    public TbUsuario login(TbUsuario filtro){    
        if(filtro.getNmUsuario().equalsIgnoreCase(""))return null;
        if(filtro.getNmSenha().equalsIgnoreCase(""))return null;
        
        UsuarioDAO rnd = new UsuarioDAOImpl();
        return rnd.login(filtro);
    }

    @Override
    public List<TbUsuario> pesquisarAtivos() {
        UsuarioDAO rnd = new UsuarioDAOImpl();
        return rnd.pesquisarAtivos();
    }
    
  
    @Override
    public TbUsuario pesquisarPorCpf(TbUsuario usuario) {
        UsuarioDAO rnd = new UsuarioDAOImpl();
        return rnd.pesquisarPorCpf(usuario);

    }

    @Override
    public TbUsuario pesquisarPorUsuario(TbUsuario usuario){
         UsuarioDAO rnd = new UsuarioDAOImpl();
         return rnd.pesquisarPorUsuario(usuario);
    }
}
