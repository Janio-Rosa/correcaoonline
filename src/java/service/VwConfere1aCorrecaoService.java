/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.VwConfere1aCorrecao;

/**
 *
 * @author janio
 */
public interface VwConfere1aCorrecaoService {
    public VwConfere1aCorrecao pesquisarPorID(int id) ;
    public VwConfere1aCorrecao pesquisarPorIDLong(long id) ;
    public List<VwConfere1aCorrecao> pesquisarPorDisciplinaQuestao(int idDisciplina,int nrQuestao);
    
}
