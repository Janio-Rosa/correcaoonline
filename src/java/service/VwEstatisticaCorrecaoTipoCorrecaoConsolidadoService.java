package service;

import java.util.List;
import model.VwEstatisticaCorrecaoTipoCorrecaoConsolidado;

/**
 *
 * @author KAMYLLA
 */
public interface VwEstatisticaCorrecaoTipoCorrecaoConsolidadoService {
    
    public List<VwEstatisticaCorrecaoTipoCorrecaoConsolidado> pesquisarTodos() ;
    public List<VwEstatisticaCorrecaoTipoCorrecaoConsolidado> pesquisarTodosOrdenado( ) ;
    public List<VwEstatisticaCorrecaoTipoCorrecaoConsolidado> pesquisarPorProcesso(int processo);
    public List<VwEstatisticaCorrecaoTipoCorrecaoConsolidado> pesquisarPorProcessoeDisciplina(int processo, int disciplina);
    
}
