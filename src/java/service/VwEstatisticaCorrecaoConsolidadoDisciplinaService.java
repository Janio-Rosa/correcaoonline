package service;

import java.util.List;
import model.VwEstatisticaCorrecaoConsolidadoDisciplina;

/**
 *
 * @author KAMYLLA
 */
public interface VwEstatisticaCorrecaoConsolidadoDisciplinaService {
    
    public List<VwEstatisticaCorrecaoConsolidadoDisciplina> pesquisarTodos() ;
    public List<VwEstatisticaCorrecaoConsolidadoDisciplina> pesquisarTodosOrdenado( ) ;
    public List<VwEstatisticaCorrecaoConsolidadoDisciplina> pesquisarPorProcesso(int processo);
    public List<VwEstatisticaCorrecaoConsolidadoDisciplina> pesquisarPorProcessoDisciplina(int processo,int disciplina);
}
