/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbProcesso;

/**
 *
 * @author Janio
 */
public interface ProcessoService {
    
    public List<TbProcesso> pesquisarTodos() ;
    public TbProcesso inserir(TbProcesso email) ;
    public TbProcesso atualizar(TbProcesso email) ;
    public boolean apagar(TbProcesso email) ;
    public TbProcesso pesquisarPorID(int id) ;
    public List<TbProcesso> pesquisarTodosOrdenado( ) ;
    public List<TbProcesso> pesquisarTodosAtivos() ;

}
