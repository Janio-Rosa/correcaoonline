package dao;

import java.util.List;
import model.VwEstatisticaCorrecaoConsolidadoDisciplina;

/**
 *
 * @author KAMYLLA
 */
public interface VwEstatisticaCorrecaoConsolidadoDisciplinaDAO {
    
    public List<VwEstatisticaCorrecaoConsolidadoDisciplina> pesquisarTodos() ;
    public List<VwEstatisticaCorrecaoConsolidadoDisciplina> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwEstatisticaCorrecaoConsolidadoDisciplina> pesquisarPorProcesso(int processo);
    public List<VwEstatisticaCorrecaoConsolidadoDisciplina> pesquisarPorProcessoDisciplina(int processo,int disciplina);
    
}
