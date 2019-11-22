/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.VwProcessoCurso;

/**
 *
 * @author Janio
 */
public interface VwProcessoCursoService {

    public List<VwProcessoCurso> pesquisarTodos() ;
    public VwProcessoCurso pesquisarPorID(int id) ;
    public List<VwProcessoCurso> pesquisarTodosOrdenado() ;
    public List<VwProcessoCurso> pesquisaPorProcesso(int idProcesso ) ;
    
}
