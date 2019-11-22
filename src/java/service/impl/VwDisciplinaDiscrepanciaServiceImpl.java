package service.impl;
import java.util.List;
import model.TbDisciplina;
import model.VwDisciplinaDiscrepancia;
import dao.VwDisciplinaDiscrepanciaDAO;
import dao.impl.VwDisciplinaDiscrepanciaDAOImpl;
import service.VwDisciplinaDiscrepanciaService;

/**
 *
 * @author KAMYLLA
 */
public class VwDisciplinaDiscrepanciaServiceImpl implements VwDisciplinaDiscrepanciaService  {
   
    @Override
    public List<VwDisciplinaDiscrepancia> pesquisarTodos() {
        VwDisciplinaDiscrepanciaDAO rnd = new VwDisciplinaDiscrepanciaDAOImpl();
        return rnd.pesquisarTodos();
    }
 
    @Override
    public List<VwDisciplinaDiscrepancia> pesquisarTodosOrdenado() {
        VwDisciplinaDiscrepanciaDAO rnd = new VwDisciplinaDiscrepanciaDAOImpl();
        String[] criterios = {"idDisciplina"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }

    @Override
    public List<VwDisciplinaDiscrepancia> pesquisarPorDisciplina(int disc) {
        VwDisciplinaDiscrepanciaDAO rnd = new VwDisciplinaDiscrepanciaDAOImpl();
        return rnd.pesquisarPorDisciplina( disc);
    }
    

   
}

