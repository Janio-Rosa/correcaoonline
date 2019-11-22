/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.VwProcessoDisciplina;

/**
 *
 * @author Janio
 */
public interface VwProcessoDisciplinaService {

    public List<VwProcessoDisciplina> pesquisarTodos() ;
    public VwProcessoDisciplina pesquisarPorID(int id) ;
    public List<VwProcessoDisciplina> pesquisarTodosOrdenado() ;
    public List<VwProcessoDisciplina> pesquisaPorProcesso(int idProcesso ) ;
    
}
