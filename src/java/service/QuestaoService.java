/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbQuestao;

/**
 *
 * @author KAMYLLA
 */
public interface QuestaoService {
    public List<TbQuestao> pesquisarTodos() ;
    public TbQuestao inserir(TbQuestao obj) ;
    public TbQuestao atualizar(TbQuestao obj) ;
    public boolean apagar(TbQuestao obj) ;
    public TbQuestao pesquisarPorID(int id) ;
    public List<TbQuestao> pesquisarTodosOrdenado( ) ;
    
}
