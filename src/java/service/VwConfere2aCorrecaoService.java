/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.VwConfere2aCorrecao;

/**
 *
 * @author janio
 */
public interface VwConfere2aCorrecaoService {
    public VwConfere2aCorrecao pesquisarPorID(int id) ;
    public VwConfere2aCorrecao pesquisarPorIDLong(long id) ;
    public List<VwConfere2aCorrecao> pesquisarPorDisciplinaQuestao(int idDisciplina,int nrQuestao);

}
