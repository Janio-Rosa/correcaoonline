/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbInscricao;

/**
 *
 * @author Janio
 */
public interface TbInscricaoService {
    
    public List<TbInscricao> pesquisarTodos() ;
    public TbInscricao pesquisarPorID(int id) ;
    public TbInscricao pesquisarPorIDLong(long id) ;
    public List<TbInscricao> pesquisarTodosOrdenado( ) ;

}
