package dao;

import java.util.List;
import model.VwConsolidadoGeralCorrecao;

/**
 *
 * @author KAMYLLA
 */
public interface VwConsolidadoGeralCorrecaoDAO {
    
    public List<VwConsolidadoGeralCorrecao> pesquisarTodos() ;
    public List<VwConsolidadoGeralCorrecao> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwConsolidadoGeralCorrecao> pesquisarPorProcesso(int processo);
    public List<VwConsolidadoGeralCorrecao> pesquisarPorProcessoeDisciplina(int processo, int disciplina);
   
    
}
