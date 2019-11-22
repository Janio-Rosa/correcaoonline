/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbResposta;
import model.VwResposta3aCorrecao;

/**
 *
 * @author administrator
 */
public interface VwResposta3aCorrecaoService {

    public List<VwResposta3aCorrecao> pesquisarTodos() ;
    public VwResposta3aCorrecao pesquisarPorIDLong(long id) ;
    public List<VwResposta3aCorrecao> pesquisarTodosOrdenado() ;
    public List<VwResposta3aCorrecao> pesquisaPorInscricao(int nrInscricao ) ;
    //public VwResposta3aCorrecao pesquisarProximaRespostaTerceiraCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao);
    public TbResposta pesquisarProximaRespostaTerceiraCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao) ;
}
