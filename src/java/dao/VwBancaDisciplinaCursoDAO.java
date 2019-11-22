/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author administrator
 */
import java.util.List;
import model.VwBancaDisciplinaCurso;

/**
 *
 * @author KAMYLLA
 */
public interface VwBancaDisciplinaCursoDAO {
    
    public List<VwBancaDisciplinaCurso> pesquisarTodos();
    public VwBancaDisciplinaCurso inserir(VwBancaDisciplinaCurso obj);
    public VwBancaDisciplinaCurso atualizar(VwBancaDisciplinaCurso obj);
    public VwBancaDisciplinaCurso pesquisarPorID(int id);
    public List<VwBancaDisciplinaCurso> pesquisarTodosOrdenado(String[] atributoOrdenar);
    public List<VwBancaDisciplinaCurso> pesquisarTodosOrdenadoPorProcesso(String[] atributoOrdenar,int idProcesso);
    public List<VwBancaDisciplinaCurso> pesquisarPorDisciplinaCurso(int idDisciplina, int idCurso);

}
