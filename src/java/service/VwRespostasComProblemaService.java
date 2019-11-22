/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.VwRespostasComProblema;

/**
 *
 * @author Janio
 */
public interface VwRespostasComProblemaService {

    public List<VwRespostasComProblema> pesquisarTodos() ;
    public List<VwRespostasComProblema> pesquisarTodosOrdenado() ;
    public List<VwRespostasComProblema> pesquisarPorDisciplina(int idDisciplina  );

}
