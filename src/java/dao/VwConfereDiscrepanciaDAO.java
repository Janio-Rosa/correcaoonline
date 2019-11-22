/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.VwConfereDiscrepancia;

/**
 *
 * @author Janio
 */
public interface VwConfereDiscrepanciaDAO {

    public List<VwConfereDiscrepancia> pesquisarTodos() ;
    public VwConfereDiscrepancia pesquisarPorID(int id) ;
    public List<VwConfereDiscrepancia> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwConfereDiscrepancia> pesquisarPorDisciplinaCursoProcesso(int idDisciplina, int idCurso, int idProcesso);
    public List<VwConfereDiscrepancia> pesquisarPorCurso(int idCurso) ;
    public List<VwConfereDiscrepancia> pesquisarPorDisciplina(int idDisciplina);

}
