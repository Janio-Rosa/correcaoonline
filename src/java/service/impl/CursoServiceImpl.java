/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.CursoDAO;
import dao.impl.CursoDAOImpl;
import java.util.List;
import model.TbCurso;
import service.CursoService;

/**
 *
 * @author KAMYLLA
 */
public class CursoServiceImpl implements CursoService {
    
     @Override
    public List<TbCurso> pesquisarTodos() {
        CursoDAO dd =  new CursoDAOImpl();
        return dd.pesquisarTodos();
    }

    @Override
    public TbCurso inserir(TbCurso nome) {
        CursoDAO dd = new CursoDAOImpl();
        return dd.inserir(nome);
    }

    @Override
    public TbCurso atualizar(TbCurso nome) {
        CursoDAO dd =  new CursoDAOImpl();
        return dd.atualizar(nome);
    }

    @Override
    public boolean apagar(TbCurso nome) {
        CursoDAO dd =  new CursoDAOImpl();
        return dd.apagar(nome);
    }

    @Override
    public TbCurso pesquisarPorID(int id) {
        CursoDAO dd =  new CursoDAOImpl();
        return dd.pesquisarPorID(id);
    }

    @Override
    public List<TbCurso> pesquisarTodosOrdenado() {
        CursoDAO dd =  new CursoDAOImpl();
        String[] criterios = {"nmCurso"};
        return dd.pesquisarTodosOrdenado(criterios);
    
    }

}