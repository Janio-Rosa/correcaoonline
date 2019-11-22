/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.VwProcessoDisciplinaCorretor;

/**
 *
 * @author Janio
 */
public interface VwProcessoDisciplinaCorretorDAO {
    
    public List<VwProcessoDisciplinaCorretor> pesquisarTodos() ;
    public VwProcessoDisciplinaCorretor pesquisarPorID(int id) ;
    public List<VwProcessoDisciplinaCorretor> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwProcessoDisciplinaCorretor> pesquisaPorProcessoDisciplina(int idDisciplina,int idProcesso ) ;
}
