/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.VwRespostaInscricaoCorrecao;

/**
 *
 * @author administrator
 */
public interface VwRespostaInscricaoDAO {

    public List<VwRespostaInscricaoCorrecao> pesquisarTodos() ;
    public VwRespostaInscricaoCorrecao pesquisarPorIDLong(long id) ;
    public List<VwRespostaInscricaoCorrecao> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwRespostaInscricaoCorrecao> pesquisaPorInscricao(int nrInscricao ) ;
    public float notaTotalPorIdResposta(long idResposta) ;
    public List<VwRespostaInscricaoCorrecao> pesquisaPorCursoDisciplinaQuestao(int idCurso,int idDisciplina,int nrQuestao );
    
}
