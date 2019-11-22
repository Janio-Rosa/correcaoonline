/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.VwConfereDiscrepancia;

/**
 *
 * @author Janio
 */
public interface VwConfereDiscrepanciaService {

    public List<VwConfereDiscrepancia> pesquisarTodos() ;
    public VwConfereDiscrepancia pesquisarPorID(int id) ;
    public List<VwConfereDiscrepancia> pesquisarTodosOrdenado() ;
    public List<VwConfereDiscrepancia> pesquisarPorDisciplinaCursoProcesso(int idDisciplina, int idCurso, int idProcesso);
    
}
