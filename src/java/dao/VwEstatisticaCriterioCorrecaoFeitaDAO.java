package dao;

import java.util.List;
import model.VwEstatisticaCriterioCorrecaoFeita;

/**
 *
 * @author Janio
 */
public interface VwEstatisticaCriterioCorrecaoFeitaDAO {
    
    public List<VwEstatisticaCriterioCorrecaoFeita> pesquisarTodos() ;
    public List<VwEstatisticaCriterioCorrecaoFeita> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwEstatisticaCriterioCorrecaoFeita> pesquisarPorProcesso(int processo,String[] atributoOrdenar) ;

    
}
