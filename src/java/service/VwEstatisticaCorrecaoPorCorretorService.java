package service;

import java.util.List;
import model.VwEstatisticaCorrecaoPorCorretor;

/**
 *
 * @author KAMYLLA
 */
public interface VwEstatisticaCorrecaoPorCorretorService {
    
    public List<VwEstatisticaCorrecaoPorCorretor> pesquisarTodos() ;
    public List<VwEstatisticaCorrecaoPorCorretor> pesquisarTodosOrdenado( ) ;
    public List<VwEstatisticaCorrecaoPorCorretor> pesquisarPorProcesso(int processo);
    public List<VwEstatisticaCorrecaoPorCorretor> pesquisarPorProcessoDisciplina(int processo,int disciplina);
    public int pesquisarTotalPorCPF(String nrCpf);
}
