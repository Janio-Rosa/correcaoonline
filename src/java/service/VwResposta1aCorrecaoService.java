/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.util.List;
import model.TbResposta;
import model.VwResposta1aCorrecao;

/**
 *
 * @author administrator
 */
public interface VwResposta1aCorrecaoService {

    public List<VwResposta1aCorrecao> pesquisarTodos() ;
    public VwResposta1aCorrecao pesquisarPorIDLong(long id) ;
    public List<VwResposta1aCorrecao> pesquisarTodosOrdenado() ;
    public List<VwResposta1aCorrecao> pesquisaPorInscricao(int nrInscricao ) ;
    //public VwResposta1aCorrecao pesquisarProximaRespostaTerceiraCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao);
    public TbResposta pesquisarProximaRespostaPrimeiraCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao) ;
    
}
