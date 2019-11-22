/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.VwConfere2aCorrecao;

/**
 *
 * @author janio
 */
public interface VwConfere2aCorrecaoDAO {
    //public List<VwConfere2aCorrecao> pesquisarTodos() ;
    public VwConfere2aCorrecao pesquisarPorID(int id) ;
    public VwConfere2aCorrecao pesquisarPorIDLong(long id) ;
    //public List<VwConfere2aCorrecao> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwConfere2aCorrecao> pesquisarPorDisciplinaQuestao(int idDisciplina,int nrQuestao);
    
}
