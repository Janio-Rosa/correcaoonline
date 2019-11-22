/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.VwRespostasComProblema;

/**
 *
 * @author Janio
 */
public interface VwRespostasComProblemaDAO {

    public List<VwRespostasComProblema> pesquisarTodos() ;
    public List<VwRespostasComProblema> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwRespostasComProblema> pesquisarPorDisciplina(int idDisciplina  );
}
