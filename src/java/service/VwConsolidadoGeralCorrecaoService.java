package service;

import java.util.List;
import model.VwConsolidadoGeralCorrecao;

/**
 *
 * @author KAMYLLA
 */
public interface VwConsolidadoGeralCorrecaoService {
    
    public List<VwConsolidadoGeralCorrecao> pesquisarTodos() ;
    public List<VwConsolidadoGeralCorrecao> pesquisarTodosOrdenado( ) ;
    public List<VwConsolidadoGeralCorrecao> pesquisarPorProcesso(int processo);
    public List<VwConsolidadoGeralCorrecao> pesquisarPorProcessoeDisciplina(int processo, int disciplina);
    
}
