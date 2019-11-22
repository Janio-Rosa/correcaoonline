package dao;

import java.util.List;
import model.VwConsolidadoGeralCorrecaoDisciplina;

/**
 *
 * @author KAMYLLA
 */
public interface VwConsolidadoGeralCorrecaoDisciplinaDAO {
    
    public List<VwConsolidadoGeralCorrecaoDisciplina> pesquisarTodos() ;
    public List<VwConsolidadoGeralCorrecaoDisciplina> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwConsolidadoGeralCorrecaoDisciplina> pesquisarPorProcesso(int processo);
    public List<VwConsolidadoGeralCorrecaoDisciplina> pesquisarPorProcessoeDisciplina(int processo, int disciplina);
   
    
}
