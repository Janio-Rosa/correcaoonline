/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwBancaDisciplinaCursoDAO;
import dao.impl.VwBancaDisciplinaCursoDAOImpl;
import java.util.List;
import model.VwBancaDisciplinaCurso;
import service.VwBancaDisciplinaCursoService;

/**
 *
 * @author Janio
 */
public class VwBancaDisciplinaCursoServiceImpl implements VwBancaDisciplinaCursoService  {
    
    @Override
    public List<VwBancaDisciplinaCurso> pesquisarTodos() {
        VwBancaDisciplinaCursoDAO rnd = new VwBancaDisciplinaCursoDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public VwBancaDisciplinaCurso inserir(VwBancaDisciplinaCurso retornoNis) {
        VwBancaDisciplinaCursoDAO rnd = new VwBancaDisciplinaCursoDAOImpl();
        return rnd.inserir(retornoNis);
    }

    @Override
    public VwBancaDisciplinaCurso atualizar(VwBancaDisciplinaCurso retornoNis) {
        VwBancaDisciplinaCursoDAO rnd = new VwBancaDisciplinaCursoDAOImpl();
        return rnd.atualizar(retornoNis);
    }


    @Override
    public VwBancaDisciplinaCurso pesquisarPorID(int id) {
        VwBancaDisciplinaCursoDAO rnd = new VwBancaDisciplinaCursoDAOImpl();
        return rnd.pesquisarPorID(id);
    }

    @Override
    public List<VwBancaDisciplinaCurso> pesquisarTodosOrdenado() {
        VwBancaDisciplinaCursoDAO rnd = new VwBancaDisciplinaCursoDAOImpl();
        String[] criterios = {"nmDisciplina","nmCurso"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }

    
    @Override
    public List<VwBancaDisciplinaCurso> pesquisarPorDisciplinaCurso(int idDisciplina, int idCurso) {
       VwBancaDisciplinaCursoDAO rnd = new VwBancaDisciplinaCursoDAOImpl();
       return rnd.pesquisarPorDisciplinaCurso(idDisciplina,idCurso);
    }

    @Override
    public List<VwBancaDisciplinaCurso> pesquisarTodosOrdenadoPorProcesso(int idProcesso) {
        VwBancaDisciplinaCursoDAO rnd = new VwBancaDisciplinaCursoDAOImpl();
        String[] criterios = {"nmDisciplina","nmCurso"};
        return rnd.pesquisarTodosOrdenadoPorProcesso(criterios,idProcesso);
    }
    

}
