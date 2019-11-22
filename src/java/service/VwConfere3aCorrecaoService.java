/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.VwConfere3aCorrecao;

/**
 *
 * @author janio
 */
public interface VwConfere3aCorrecaoService {
    public VwConfere3aCorrecao pesquisarPorID(int id) ;
    public VwConfere3aCorrecao pesquisarPorIDLong(long id) ;
    public List<VwConfere3aCorrecao> pesquisarPorDisciplinaQuestao(int idDisciplina,int nrQuestao);

}
