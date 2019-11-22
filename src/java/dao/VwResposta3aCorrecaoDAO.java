/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.VwResposta3aCorrecao;

/**
 *
 * @author administrator
 */
public interface VwResposta3aCorrecaoDAO {

    public List<VwResposta3aCorrecao> pesquisarTodos() ;
    public VwResposta3aCorrecao pesquisarPorIDLong(long id) ;
    public List<VwResposta3aCorrecao> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwResposta3aCorrecao> pesquisaPorInscricao(int nrInscricao ) ;
    public VwResposta3aCorrecao pesquisarProximaRespostaTerceiraCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao);


}
