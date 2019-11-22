/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbFuncionalidade;

/**
 *
 * @author Janio
 */
public interface FuncionalidadeDAO {

    public List<TbFuncionalidade> pesquisarTodos() ;
    public TbFuncionalidade inserir(TbFuncionalidade obj) ;
    public TbFuncionalidade atualizar(TbFuncionalidade obj) ;
    public boolean apagar(TbFuncionalidade email) ;
    public TbFuncionalidade pesquisarPorID(int id) ;
    public List<TbFuncionalidade> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    
}
