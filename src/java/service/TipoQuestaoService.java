/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbTipoQuestao;

/**
 *
 * @author KAMYLLA
 */
public interface TipoQuestaoService {
    
    public List<TbTipoQuestao> pesquisarTodos() ;
    public TbTipoQuestao inserir(TbTipoQuestao nome) ;
    public TbTipoQuestao atualizar(TbTipoQuestao nome) ;
    public boolean apagar(TbTipoQuestao nome) ;
    public TbTipoQuestao pesquisarPorID(int id) ;
    public List<TbTipoQuestao> pesquisarTodosOrdenado( ) ;
    
}
