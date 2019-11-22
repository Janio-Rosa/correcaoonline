/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.VwProcessoDisciplinaCorretor;

/**
 *
 * @author Janio
 */
public interface VwProcessoDisciplinaCorretorService {
    
    public List<VwProcessoDisciplinaCorretor> pesquisarTodos() ;
    public VwProcessoDisciplinaCorretor pesquisarPorID(int id) ;
    public List<VwProcessoDisciplinaCorretor> pesquisarTodosOrdenado() ;
    public List<VwProcessoDisciplinaCorretor> pesquisaPorProcessoDisciplina(int idDisciplina,int idProcesso );
    
}
