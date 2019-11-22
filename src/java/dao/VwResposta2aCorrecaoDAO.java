/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.VwResposta2aCorrecao;

/**
 *
 * @author administrator
 */
public interface VwResposta2aCorrecaoDAO {

    public List<VwResposta2aCorrecao> pesquisarTodos() ;
    public VwResposta2aCorrecao pesquisarPorIDLong(long id) ;
    public List<VwResposta2aCorrecao> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwResposta2aCorrecao> pesquisaPorInscricao(int nrInscricao ) ;
    public VwResposta2aCorrecao pesquisarProximaRespostaSegundaCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao);

}
