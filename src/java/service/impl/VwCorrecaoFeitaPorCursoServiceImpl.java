package service.impl;
import java.util.List;
import model.VwCorrecaoFeitaPorCurso;
import dao.VwCorrecaoFeitaPorCursoDAO;
import dao.impl.VwCorrecaoFeitaPorCursoDAOImpl;
import service.VwCorrecaoFeitaPorCursoService;

/**
 *
 * @author KAMYLLA
 */
public class VwCorrecaoFeitaPorCursoServiceImpl implements VwCorrecaoFeitaPorCursoService  {
   
    @Override
    public List<VwCorrecaoFeitaPorCurso> pesquisarTodos() {
        VwCorrecaoFeitaPorCursoDAO rnd = new VwCorrecaoFeitaPorCursoDAOImpl();
        return rnd.pesquisarTodos();
    }
 
    @Override
    public List<VwCorrecaoFeitaPorCurso> pesquisarTodosOrdenado() {
        VwCorrecaoFeitaPorCursoDAO rnd = new VwCorrecaoFeitaPorCursoDAOImpl();
        String[] criterios = {"nmPessoa"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }
    
    @Override
    public List<VwCorrecaoFeitaPorCurso> pesquisarPorProcesso(int processo){
        VwCorrecaoFeitaPorCursoDAO rnd = new VwCorrecaoFeitaPorCursoDAOImpl();
        return rnd.pesquisarPorProcesso(processo);
    }

    @Override
    public List<VwCorrecaoFeitaPorCurso> pesquisarPorProcessoDisciplina(int processo, int disciplina) {
        VwCorrecaoFeitaPorCursoDAO rnd = new VwCorrecaoFeitaPorCursoDAOImpl();
        return rnd.pesquisarPorProcessoDisciplina(processo,disciplina);
    }
   
}

