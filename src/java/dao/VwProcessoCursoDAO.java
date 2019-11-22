/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.VwProcessoCurso;

/**
 *
 * @author Janio
 */
public interface VwProcessoCursoDAO {

    public List<VwProcessoCurso> pesquisarTodos() ;
    public VwProcessoCurso pesquisarPorID(int id) ;
    public List<VwProcessoCurso> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List pesquisaPorProcesso(int idProcesso ) ;

}
