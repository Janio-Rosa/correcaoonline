package service.impl;
import java.util.List;
import model.VwEstatisticaCorrecaoPorCorretor;
import dao.VwEstatisticaCorrecaoPorCorretorDAO;
import dao.impl.VwEstatisticaCorrecaoPorCorretorDAOImpl;
import service.VwEstatisticaCorrecaoPorCorretorService;

/**
 *
 * @author KAMYLLA
 */
public class VwEstatisticaCorrecaoPorCorretorServiceImpl implements VwEstatisticaCorrecaoPorCorretorService  {
   
    @Override
    public List<VwEstatisticaCorrecaoPorCorretor> pesquisarTodos() {
        VwEstatisticaCorrecaoPorCorretorDAO rnd = new VwEstatisticaCorrecaoPorCorretorDAOImpl();
        return rnd.pesquisarTodos();
    }
    
    

 
    @Override
    public List<VwEstatisticaCorrecaoPorCorretor> pesquisarTodosOrdenado() {
        VwEstatisticaCorrecaoPorCorretorDAO rnd = new VwEstatisticaCorrecaoPorCorretorDAOImpl();
        String[] criterios = {"nmPessoa"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }
    
    @Override
    public List<VwEstatisticaCorrecaoPorCorretor> pesquisarPorProcesso(int processo){
        VwEstatisticaCorrecaoPorCorretorDAO rnd = new VwEstatisticaCorrecaoPorCorretorDAOImpl();
        return rnd.pesquisarPorProcesso(processo);
    }

    @Override
    public List<VwEstatisticaCorrecaoPorCorretor> pesquisarPorProcessoDisciplina(int processo, int disciplina) {
        VwEstatisticaCorrecaoPorCorretorDAO rnd = new VwEstatisticaCorrecaoPorCorretorDAOImpl();
        return rnd.pesquisarPorProcessoDisciplina(processo,disciplina);
    }
   
    @Override
    public int pesquisarTotalPorCPF(String nrCpf) {
        VwEstatisticaCorrecaoPorCorretorDAO rnd = new VwEstatisticaCorrecaoPorCorretorDAOImpl();
        return rnd.pesquisarTotalPorCPF(nrCpf);
        
    }
}
