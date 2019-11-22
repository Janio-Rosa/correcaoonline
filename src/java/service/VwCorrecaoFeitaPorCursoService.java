package service;

import java.util.List;
import model.VwCorrecaoFeitaPorCurso;

/**
 *
 * @author KAMYLLA
 */
public interface VwCorrecaoFeitaPorCursoService {
    
    public List<VwCorrecaoFeitaPorCurso> pesquisarTodos() ;
    public List<VwCorrecaoFeitaPorCurso> pesquisarTodosOrdenado( ) ;
    public List<VwCorrecaoFeitaPorCurso> pesquisarPorProcesso(int processo);
    public List<VwCorrecaoFeitaPorCurso> pesquisarPorProcessoDisciplina(int processo,int disciplina);
}
