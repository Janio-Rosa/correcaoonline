package service.impl;
import java.util.List;
import model.VwConsolidadoGeralCorrecao;
import dao.VwConsolidadoGeralCorrecaoDAO;
import dao.impl.VwConsolidadoGeralCorrecaoDAOImpl;
import service.VwConsolidadoGeralCorrecaoService;

/**
 *
 * @author KAMYLLA
 */
public class VwConsolidadoGeralCorrecaoServiceImpl implements VwConsolidadoGeralCorrecaoService  {
   
    @Override
    public List<VwConsolidadoGeralCorrecao> pesquisarTodos() {
        VwConsolidadoGeralCorrecaoDAO rnd = new VwConsolidadoGeralCorrecaoDAOImpl();
        return rnd.pesquisarTodos();
    }
   
 
    @Override
    public List<VwConsolidadoGeralCorrecao> pesquisarTodosOrdenado() {
        VwConsolidadoGeralCorrecaoDAO rnd = new VwConsolidadoGeralCorrecaoDAOImpl();
        String[] criterios = {"nmProcesso"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }
    
    @Override
    public List<VwConsolidadoGeralCorrecao> pesquisarPorProcesso(int processo){
        VwConsolidadoGeralCorrecaoDAO rnd = new VwConsolidadoGeralCorrecaoDAOImpl();
        return rnd.pesquisarPorProcesso(processo);
    }
    
    @Override
    public List<VwConsolidadoGeralCorrecao> pesquisarPorProcessoeDisciplina(int processo, int disciplina){
        VwConsolidadoGeralCorrecaoDAO rnd = new VwConsolidadoGeralCorrecaoDAOImpl();
        return rnd.pesquisarPorProcessoeDisciplina(processo, disciplina);
    }
   
}
