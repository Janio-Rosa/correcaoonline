/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbProcesso;

/**
 *
 * @author Janio
 */
public interface ProcessoDAO  {
    
    public List<TbProcesso> pesquisarTodos() ;
    public List<TbProcesso> pesquisarTodosAtivos() ;
    public TbProcesso inserir(TbProcesso obj) ;
    public TbProcesso atualizar(TbProcesso obj) ;
    public boolean apagar(TbProcesso email) ;
    public TbProcesso pesquisarPorID(int id) ;
    public List<TbProcesso> pesquisarTodosOrdenado(String[] atributoOrdenar) ;

}
