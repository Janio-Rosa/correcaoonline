/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.VwConfere1aCorrecao;

/**
 *
 * @author janio
 */
public interface VwConfere1aCorrecaoDAO {
    //public List<VwConfere1aCorrecao> pesquisarTodos() ;
    public VwConfere1aCorrecao pesquisarPorID(int id) ;
    public VwConfere1aCorrecao pesquisarPorIDLong(long id) ;
    //public List<VwConfere1aCorrecao> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwConfere1aCorrecao> pesquisarPorDisciplinaQuestao(int idDisciplina,int nrQuestao);

}
