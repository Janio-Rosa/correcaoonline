package dao;

import java.util.List;
import model.VwCorrecaoFeitaPorCurso;

/**
 *
 * @author KAMYLLA
 */
public interface VwCorrecaoFeitaPorCursoDAO {
    
    public List<VwCorrecaoFeitaPorCurso> pesquisarTodos() ;
    public List<VwCorrecaoFeitaPorCurso> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwCorrecaoFeitaPorCurso> pesquisarPorProcesso(int processo);
    public List<VwCorrecaoFeitaPorCurso> pesquisarPorProcessoDisciplina(int processo,int disciplina);
    
}
