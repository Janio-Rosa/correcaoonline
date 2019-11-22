package service;

import java.util.List;
import model.VwConsolidadoGeralCorrecaoDisciplina;

/**
 *
 * @author KAMYLLA
 */
public interface VwConsolidadoGeralCorrecaoDisciplinaService {
    
    public List<VwConsolidadoGeralCorrecaoDisciplina> pesquisarTodos() ;
    public List<VwConsolidadoGeralCorrecaoDisciplina> pesquisarTodosOrdenado( ) ;
    public List<VwConsolidadoGeralCorrecaoDisciplina> pesquisarPorProcesso(int processo);
    public List<VwConsolidadoGeralCorrecaoDisciplina> pesquisarPorProcessoeDisciplina(int processo, int disciplina);
    
}
