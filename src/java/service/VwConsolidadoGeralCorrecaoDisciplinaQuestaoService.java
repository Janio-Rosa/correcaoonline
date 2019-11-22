/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.util.List;
import model.VwConsolidadoGeralCorrecaoDisciplinaQuestao;

/**
 *
 * @author Janio
 */
public interface VwConsolidadoGeralCorrecaoDisciplinaQuestaoService {
    public List<VwConsolidadoGeralCorrecaoDisciplinaQuestao> pesquisarTodos() ;
    public List<VwConsolidadoGeralCorrecaoDisciplinaQuestao> pesquisarTodosOrdenado() ;
    public List<VwConsolidadoGeralCorrecaoDisciplinaQuestao> pesquisarPorProcesso(int processo);
    public List<VwConsolidadoGeralCorrecaoDisciplinaQuestao> pesquisarPorProcessoeDisciplina(int processo, int disciplina);
    
}
