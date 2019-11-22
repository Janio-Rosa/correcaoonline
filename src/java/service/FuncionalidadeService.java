
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbFuncionalidade;

/**
 *
 * @author KAMYLLA
 */
public interface FuncionalidadeService {
    
    public List<TbFuncionalidade> pesquisarTodos() ;
    public TbFuncionalidade inserir(TbFuncionalidade funcionalidade) ;
    public TbFuncionalidade atualizar(TbFuncionalidade funcionalidade) ;
    public boolean apagar(TbFuncionalidade funcionalidade) ;
    public TbFuncionalidade pesquisarPorID(int id) ;
    public List<TbFuncionalidade> pesquisarTodosOrdenado( ) ;
  
}