/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbResposta;
import model.VwResposta2aCorrecao;

/**
 *
 * @author administrator
 */
public interface VwResposta2aCorrecaoService {

    public List<VwResposta2aCorrecao> pesquisarTodos() ;
    public VwResposta2aCorrecao pesquisarPorIDLong(long id) ;
    public List<VwResposta2aCorrecao> pesquisarTodosOrdenado() ;
    public List<VwResposta2aCorrecao> pesquisaPorInscricao(int nrInscricao ) ;
    //public VwResposta2aCorrecao pesquisarProximaRespostaTerceiraCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao);
    public TbResposta pesquisarProximaRespostaSegundaCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao) ;
    
}
