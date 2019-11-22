
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbFuncao;

/**
 *
 * @author KAMYLLA
 */
public interface FuncaoService {
    
    public List<TbFuncao> pesquisarTodos() ;
    public TbFuncao inserir(TbFuncao nome) ;
    public TbFuncao atualizar(TbFuncao nome) ;
    public boolean apagar(TbFuncao nome) ;
    public TbFuncao pesquisarPorID(int id) ;
    public List<TbFuncao> pesquisarTodosOrdenado( ) ;
  
}