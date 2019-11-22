package service.impl;
import java.util.List;
import model.VwConsolidadoGeralCorrecaoDisciplina;
import dao.VwConsolidadoGeralCorrecaoDisciplinaDAO;
import dao.impl.VwConsolidadoGeralCorrecaoDisciplinaDAOImpl;
import service.VwConsolidadoGeralCorrecaoDisciplinaService;

/**
 *
 * @author KAMYLLA
 */
public class VwConsolidadoGeralCorrecaoDisciplinaServiceImpl implements VwConsolidadoGeralCorrecaoDisciplinaService  {
   
    @Override
    public List<VwConsolidadoGeralCorrecaoDisciplina> pesquisarTodos() {
        VwConsolidadoGeralCorrecaoDisciplinaDAO rnd = new VwConsolidadoGeralCorrecaoDisciplinaDAOImpl();
        return rnd.pesquisarTodos();
    }
   
 
    @Override
    public List<VwConsolidadoGeralCorrecaoDisciplina> pesquisarTodosOrdenado() {
        VwConsolidadoGeralCorrecaoDisciplinaDAO rnd = new VwConsolidadoGeralCorrecaoDisciplinaDAOImpl();
        String[] criterios = {"nmProcesso"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }
    
    @Override
    public List<VwConsolidadoGeralCorrecaoDisciplina> pesquisarPorProcesso(int processo){
        VwConsolidadoGeralCorrecaoDisciplinaDAO rnd = new VwConsolidadoGeralCorrecaoDisciplinaDAOImpl();
        return rnd.pesquisarPorProcesso(processo);
    }
    
    @Override
    public List<VwConsolidadoGeralCorrecaoDisciplina> pesquisarPorProcessoeDisciplina(int processo, int disciplina){
        VwConsolidadoGeralCorrecaoDisciplinaDAO rnd = new VwConsolidadoGeralCorrecaoDisciplinaDAOImpl();
        return rnd.pesquisarPorProcessoeDisciplina(processo, disciplina);
    }
   
}
