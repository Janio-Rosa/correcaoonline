package service;

import java.util.List;
import model.TbDisciplina;
import model.VwDisciplinaDiscrepancia;

/**
 *
 * @author KAMYLLA
 */
public interface VwDisciplinaDiscrepanciaService {
    
    public List<VwDisciplinaDiscrepancia> pesquisarTodos() ;
    public List<VwDisciplinaDiscrepancia> pesquisarTodosOrdenado( ) ;

    public List<VwDisciplinaDiscrepancia> pesquisarPorDisciplina(int disc) ;
}
