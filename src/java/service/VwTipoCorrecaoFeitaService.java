package service;

import java.util.List;
import model.VwTipoCorrecaoFeita;

/**
 *
 * @author KAMYLLA
 */
public interface VwTipoCorrecaoFeitaService {
    
    public List<VwTipoCorrecaoFeita> pesquisarTodos() ;
    public List<VwTipoCorrecaoFeita> pesquisarTodosOrdenado( ) ;
    public List<VwTipoCorrecaoFeita> pesquisarPorProcessoEDisciplina(int processo, int Disciplina);
    public int pesquisarTotalPorProcessoEDisciplina(int processo, int disciplina) ;

}
