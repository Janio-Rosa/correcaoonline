package dao;

import java.util.List;
import model.VwEstatisticaCorrecaoTipoCorrecaoConsolidado;

/**
 *
 * @author KAMYLLA
 */
public interface VwEstatisticaCorrecaoTipoCorrecaoConsolidadoDAO {
    
    public List<VwEstatisticaCorrecaoTipoCorrecaoConsolidado> pesquisarTodos() ;
    public List<VwEstatisticaCorrecaoTipoCorrecaoConsolidado> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwEstatisticaCorrecaoTipoCorrecaoConsolidado> pesquisarPorProcesso(int processo);
    public List<VwEstatisticaCorrecaoTipoCorrecaoConsolidado> pesquisarPorProcessoeDisciplina(int processo, int disciplina);
   
    
}
