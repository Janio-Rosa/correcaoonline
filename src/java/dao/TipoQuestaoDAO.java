/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbTipoQuestao;

/**
 *
 * @author KAMYLLA
 */
public interface TipoQuestaoDAO {
    
    public List<TbTipoQuestao> pesquisarTodos() ;
    public TbTipoQuestao inserir(TbTipoQuestao obj) ;
    public TbTipoQuestao atualizar(TbTipoQuestao obj) ;
    public boolean apagar(TbTipoQuestao nome) ;
    public TbTipoQuestao pesquisarPorID(int id) ;
    public List<TbTipoQuestao> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    
}
