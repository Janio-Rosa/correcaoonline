package dao;

import java.util.List;
import model.VwEstatisticaCorrecaoPorCorretor;

/**
 *
 * @author KAMYLLA
 */
public interface VwEstatisticaCorrecaoPorCorretorDAO {
    
    public List<VwEstatisticaCorrecaoPorCorretor> pesquisarTodos() ;
    public List<VwEstatisticaCorrecaoPorCorretor> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwEstatisticaCorrecaoPorCorretor> pesquisarPorProcesso(int processo);
    public List<VwEstatisticaCorrecaoPorCorretor> pesquisarPorProcessoDisciplina(int processo,int disciplina);
    public int pesquisarTotalPorCPF(String nrCpf) ;
}
