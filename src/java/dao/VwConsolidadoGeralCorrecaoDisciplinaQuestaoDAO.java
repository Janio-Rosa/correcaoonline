/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.VwConsolidadoGeralCorrecaoDisciplinaQuestao;

/**
 *
 * @author Janio
 */
public interface VwConsolidadoGeralCorrecaoDisciplinaQuestaoDAO {

    public List<VwConsolidadoGeralCorrecaoDisciplinaQuestao> pesquisarTodos() ;
    public List<VwConsolidadoGeralCorrecaoDisciplinaQuestao> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwConsolidadoGeralCorrecaoDisciplinaQuestao> pesquisarPorProcesso(int processo);
    public List<VwConsolidadoGeralCorrecaoDisciplinaQuestao> pesquisarPorProcessoeDisciplina(int processo, int disciplina);

}
