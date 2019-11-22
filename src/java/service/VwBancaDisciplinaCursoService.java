/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.VwBancaDisciplinaCurso;

/**
 *
 * @author Janio
 */
public interface VwBancaDisciplinaCursoService {
    
    public List<VwBancaDisciplinaCurso> pesquisarTodos();
    public VwBancaDisciplinaCurso inserir(VwBancaDisciplinaCurso obj);
    public VwBancaDisciplinaCurso atualizar(VwBancaDisciplinaCurso obj);
    public VwBancaDisciplinaCurso pesquisarPorID(int id);
    public List<VwBancaDisciplinaCurso> pesquisarTodosOrdenado();
    public List<VwBancaDisciplinaCurso> pesquisarTodosOrdenadoPorProcesso(int idProcesso);
    public List<VwBancaDisciplinaCurso> pesquisarPorDisciplinaCurso(int idDisciplina, int idCurso);

}
