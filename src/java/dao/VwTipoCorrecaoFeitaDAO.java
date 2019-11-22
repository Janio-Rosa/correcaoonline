
package dao;

import java.util.List;
import model.VwTipoCorrecaoFeita;

/**
 *
 * @author KAMYLLA
 */
public interface VwTipoCorrecaoFeitaDAO {
    
    public List<VwTipoCorrecaoFeita> pesquisarTodos() ;
    //public VwTipoCorrecaoFeita pesquisarPorID(int id) ;
    public List<VwTipoCorrecaoFeita> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwTipoCorrecaoFeita> pesquisarPorProcessoEDisciplina(int processo, int disciplina);
    public int pesquisarTotalPorProcessoEDisciplina(int processo, int disciplina) ;

}
