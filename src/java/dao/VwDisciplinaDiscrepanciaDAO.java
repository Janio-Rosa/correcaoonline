package dao;

import java.util.List;
import model.TbDisciplina;
import model.VwDisciplinaDiscrepancia;

/**
 *
 * @author KAMYLLA
 */
public interface VwDisciplinaDiscrepanciaDAO {
    
    public List<VwDisciplinaDiscrepancia> pesquisarTodos() ;
    public List<VwDisciplinaDiscrepancia> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
  
    public List<VwDisciplinaDiscrepancia> pesquisarPorDisciplina(int disc) ;
}
