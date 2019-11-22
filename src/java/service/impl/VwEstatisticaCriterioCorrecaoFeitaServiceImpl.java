package service.impl;
import java.util.List;
import model.VwEstatisticaCriterioCorrecaoFeita;
import dao.VwEstatisticaCriterioCorrecaoFeitaDAO;
import dao.impl.VwEstatisticaCriterioCorrecaoFeitaDAOImpl;
import service.VwEstatisticaCriterioCorrecaoFeitaService;

/**
 *
 * @author KAMYLLA
 */
public class VwEstatisticaCriterioCorrecaoFeitaServiceImpl implements VwEstatisticaCriterioCorrecaoFeitaService  {
    
   
    @Override
    public List<VwEstatisticaCriterioCorrecaoFeita> pesquisarTodos() {
        VwEstatisticaCriterioCorrecaoFeitaDAO rnd = new VwEstatisticaCriterioCorrecaoFeitaDAOImpl();
        return rnd.pesquisarTodos();
    }

    
    @Override
    public List<VwEstatisticaCriterioCorrecaoFeita> pesquisarTodosOrdenado() {
        VwEstatisticaCriterioCorrecaoFeitaDAO rnd = new VwEstatisticaCriterioCorrecaoFeitaDAOImpl();
        String[] criterios = {"nmCategoria"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }
    
      @Override
    public List<VwEstatisticaCriterioCorrecaoFeita> pesquisarPorProcesso(int processo) {
        VwEstatisticaCriterioCorrecaoFeitaDAO rnd = new VwEstatisticaCriterioCorrecaoFeitaDAOImpl();
        String[] criterioOrdenacao = {"nmCategoriaCriterio","nmCriterio"};
        return rnd.pesquisarPorProcesso(processo,criterioOrdenacao);
    }

    @Override
    public List<VwEstatisticaCriterioCorrecaoFeita> pesquisarPorProcessoOrdenadoQuant(int processo) {
        VwEstatisticaCriterioCorrecaoFeitaDAO rnd = new VwEstatisticaCriterioCorrecaoFeitaDAOImpl();
        String[] criterioOrdenacao = {"nrQuantidade"};
        return rnd.pesquisarPorProcesso(processo,criterioOrdenacao);
    }

}
