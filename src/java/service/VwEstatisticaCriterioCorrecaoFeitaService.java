
package service;

import java.util.List;
import model.VwEstatisticaCriterioCorrecaoFeita;

/**
 *
 * @author KAMYLLA
 */
public interface VwEstatisticaCriterioCorrecaoFeitaService {
    
    public List<VwEstatisticaCriterioCorrecaoFeita> pesquisarTodos() ;
    public List<VwEstatisticaCriterioCorrecaoFeita> pesquisarTodosOrdenado( ) ;
    public List<VwEstatisticaCriterioCorrecaoFeita> pesquisarPorProcesso(int processo) ;
    public List<VwEstatisticaCriterioCorrecaoFeita> pesquisarPorProcessoOrdenadoQuant(int processo) ;
}
