/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.VwResposta1aCorrecao;

/**
 *
 * @author administrator
 */
public interface VwResposta1aCorrecaoDAO {

    public List<VwResposta1aCorrecao> pesquisarTodos() ;
    public VwResposta1aCorrecao pesquisarPorIDLong(long id) ;
    public List<VwResposta1aCorrecao> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwResposta1aCorrecao> pesquisaPorInscricao(int nrInscricao ) ;
    public VwResposta1aCorrecao pesquisarProximaRespostaPrimeiraCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao);
    
}
