/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.UsuarioXFuncionalidadeDAO;
import dao.impl.UsuarioXFuncionalidadeDAOImpl;
import java.util.List;
import model.VwUsuarioFuncionalidade;
import service.UsuarioXFuncionalidadeService;

/**
 *
 * @author Janio
 */
public class UsuarioXFuncionalidadeServiceImpl implements  UsuarioXFuncionalidadeService {

    @Override
    public List<VwUsuarioFuncionalidade> pesquisarTodos() {
        UsuarioXFuncionalidadeDAO rnd = new UsuarioXFuncionalidadeDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public VwUsuarioFuncionalidade inserir(VwUsuarioFuncionalidade retornoNis) {
        UsuarioXFuncionalidadeDAO rnd = new UsuarioXFuncionalidadeDAOImpl();
        return rnd.inserir(retornoNis);
    }

    @Override
    public VwUsuarioFuncionalidade atualizar(VwUsuarioFuncionalidade retornoNis) {
        UsuarioXFuncionalidadeDAO rnd = new UsuarioXFuncionalidadeDAOImpl();
        return rnd.atualizar(retornoNis);
    }

    @Override
    public boolean apagar(VwUsuarioFuncionalidade retornoNis) {
        UsuarioXFuncionalidadeDAO rnd = new UsuarioXFuncionalidadeDAOImpl();
        return rnd.apagar(retornoNis);
    }

    @Override
    public VwUsuarioFuncionalidade pesquisarPorID(int id) {
        UsuarioXFuncionalidadeDAO rnd = new UsuarioXFuncionalidadeDAOImpl();
        return rnd.pesquisarPorID(id);
    }

    @Override
    public List<VwUsuarioFuncionalidade> pesquisarTodosOrdenado() {
        UsuarioXFuncionalidadeDAO rnd = new UsuarioXFuncionalidadeDAOImpl();
        String[] criterios = {"nrOrdem"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }

    @Override
    public List<VwUsuarioFuncionalidade> getFuncionalidadesPorUsuario(String idUsuario) {
        UsuarioXFuncionalidadeDAO rnd = new UsuarioXFuncionalidadeDAOImpl();
        return rnd.getFuncionalidadesPorUsuario(idUsuario);
    }
    
    public List getFuncionalidadesPorUsuarioById(long idUsuario ){
        UsuarioXFuncionalidadeDAO rnd = new UsuarioXFuncionalidadeDAOImpl();
        return rnd.getFuncionalidadesPorUsuarioById(idUsuario);
    }
    
}
