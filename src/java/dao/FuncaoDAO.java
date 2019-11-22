/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbFuncao;

/**
 *
 * @author KAMYLLA
 */
public interface FuncaoDAO {
    
    public List<TbFuncao> pesquisarTodos() ;
    public TbFuncao inserir(TbFuncao obj) ;
    public TbFuncao atualizar(TbFuncao obj) ;
    public boolean apagar(TbFuncao nome) ;
    public TbFuncao pesquisarPorID(int id) ;
    public List<TbFuncao> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    
}
