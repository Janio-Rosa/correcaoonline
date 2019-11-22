package service.impl;
import java.util.List;
import model.VwEstatisticaCorrecaoConsolidadoDisciplina;
import dao.VwEstatisticaCorrecaoConsolidadoDisciplinaDAO;
import dao.impl.VwEstatisticaCorrecaoConsolidadoDisciplinaDAOImpl;
import service.VwEstatisticaCorrecaoConsolidadoDisciplinaService;

/**
 *
 * @author KAMYLLA
 */
public class VwEstatisticaCorrecaoConsolidadoDisciplinaServiceImpl implements VwEstatisticaCorrecaoConsolidadoDisciplinaService  {
   
    @Override
    public List<VwEstatisticaCorrecaoConsolidadoDisciplina> pesquisarTodos() {
        VwEstatisticaCorrecaoConsolidadoDisciplinaDAO rnd = new VwEstatisticaCorrecaoConsolidadoDisciplinaDAOImpl();
        return rnd.pesquisarTodos();
    }
 
    @Override
    public List<VwEstatisticaCorrecaoConsolidadoDisciplina> pesquisarTodosOrdenado() {
        VwEstatisticaCorrecaoConsolidadoDisciplinaDAO rnd = new VwEstatisticaCorrecaoConsolidadoDisciplinaDAOImpl();
        String[] criterios = {"idDisciplina"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }
    
    @Override
    public List<VwEstatisticaCorrecaoConsolidadoDisciplina> pesquisarPorProcesso(int processo){
        VwEstatisticaCorrecaoConsolidadoDisciplinaDAO rnd = new VwEstatisticaCorrecaoConsolidadoDisciplinaDAOImpl();
        return rnd.pesquisarPorProcesso(processo);
    }

    @Override
    public List<VwEstatisticaCorrecaoConsolidadoDisciplina> pesquisarPorProcessoDisciplina(int processo, int disciplina) {
        VwEstatisticaCorrecaoConsolidadoDisciplinaDAO rnd = new VwEstatisticaCorrecaoConsolidadoDisciplinaDAOImpl();
        return rnd.pesquisarPorProcessoDisciplina(processo,disciplina);
    }
   
}

