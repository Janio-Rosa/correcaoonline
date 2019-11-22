/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.VwProcessoDisciplina;

/**
 *
 * @author Janio
 */
public interface VwProcessoDisciplinaDAO {

    public List<VwProcessoDisciplina> pesquisarTodos() ;
    public VwProcessoDisciplina pesquisarPorID(int id) ;
    public List<VwProcessoDisciplina> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List pesquisaPorProcesso(int idProcesso ) ;

}
