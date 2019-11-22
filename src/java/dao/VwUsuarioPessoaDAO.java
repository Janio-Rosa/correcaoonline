/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.VwUsuarioPessoa;

/**
 *
 * @author Janio
 */
public interface VwUsuarioPessoaDAO {

    public List<VwUsuarioPessoa> pesquisarTodos() ;
    public VwUsuarioPessoa pesquisarPorID(int id) ;
    public VwUsuarioPessoa pesquisarPorIDLong(long id) ;
    public List<VwUsuarioPessoa> pesquisarTodosOrdenado(String[] atributoOrdenar) ;

}
