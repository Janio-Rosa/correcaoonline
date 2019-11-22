/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbProcesso;
import model.TbQuestao;

/**
 *
 * @author KAMYLLA
 */
public interface QuestaoDAO  {
    
    public List<TbQuestao> pesquisarTodos() ;
    public TbQuestao inserir(TbQuestao obj) ;
    public TbQuestao atualizar(TbQuestao obj) ;
    public boolean apagar(TbQuestao email) ;
    public TbQuestao pesquisarPorID(int id) ;
    public List<TbQuestao> pesquisarTodosOrdenado(String[] atributoOrdenar) ;

}
