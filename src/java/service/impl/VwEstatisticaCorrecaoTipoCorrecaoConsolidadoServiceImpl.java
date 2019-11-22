package service.impl;
import java.util.List;
import model.VwEstatisticaCorrecaoTipoCorrecaoConsolidado;
import dao.VwEstatisticaCorrecaoTipoCorrecaoConsolidadoDAO;
import dao.impl.VwEstatisticaCorrecaoTipoCorrecaoConsolidadoDAOImpl;
import service.VwEstatisticaCorrecaoTipoCorrecaoConsolidadoService;

/**
 *
 * @author KAMYLLA
 */
public class VwEstatisticaCorrecaoTipoCorrecaoConsolidadoServiceImpl implements VwEstatisticaCorrecaoTipoCorrecaoConsolidadoService  {
   
    @Override
    public List<VwEstatisticaCorrecaoTipoCorrecaoConsolidado> pesquisarTodos() {
        VwEstatisticaCorrecaoTipoCorrecaoConsolidadoDAO rnd = new VwEstatisticaCorrecaoTipoCorrecaoConsolidadoDAOImpl();
        return rnd.pesquisarTodos();
    }
   
 
    @Override
    public List<VwEstatisticaCorrecaoTipoCorrecaoConsolidado> pesquisarTodosOrdenado() {
        VwEstatisticaCorrecaoTipoCorrecaoConsolidadoDAO rnd = new VwEstatisticaCorrecaoTipoCorrecaoConsolidadoDAOImpl();
        String[] criterios = {"nmProcesso"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }
    
    @Override
    public List<VwEstatisticaCorrecaoTipoCorrecaoConsolidado> pesquisarPorProcesso(int processo){
        VwEstatisticaCorrecaoTipoCorrecaoConsolidadoDAO rnd = new VwEstatisticaCorrecaoTipoCorrecaoConsolidadoDAOImpl();
        return rnd.pesquisarPorProcesso(processo);
    }
    
    @Override
    public List<VwEstatisticaCorrecaoTipoCorrecaoConsolidado> pesquisarPorProcessoeDisciplina(int processo, int disciplina){
        VwEstatisticaCorrecaoTipoCorrecaoConsolidadoDAO rnd = new VwEstatisticaCorrecaoTipoCorrecaoConsolidadoDAOImpl();
        return rnd.pesquisarPorProcessoeDisciplina(processo, disciplina);
    }
   
}
