/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwConfereDiscrepanciaDAO;
import dao.impl.VwConfereDiscrepanciaDAOImpl;
import java.util.List;
import model.VwConfereDiscrepancia;
import service.VwConfereDiscrepanciaService;

/**
 *
 * @author Janio
 */
public class VwConfereDiscrepanciaServiceImpl implements VwConfereDiscrepanciaService {

    @Override
    public List<VwConfereDiscrepancia> pesquisarTodos() {
        VwConfereDiscrepanciaDAO xy = new VwConfereDiscrepanciaDAOImpl();
        return xy.pesquisarTodos();
    }

    @Override
    public VwConfereDiscrepancia pesquisarPorID(int id) {
        VwConfereDiscrepanciaDAO xy = new VwConfereDiscrepanciaDAOImpl();
        return xy.pesquisarPorID(id);
    }

    @Override
    public List<VwConfereDiscrepancia> pesquisarTodosOrdenado() {
        VwConfereDiscrepanciaDAO xy = new VwConfereDiscrepanciaDAOImpl();
        String[] criterioOrdenar={"nmDisciplina"};
        return xy.pesquisarTodosOrdenado(criterioOrdenar);
    }
    
    @Override
    public List<VwConfereDiscrepancia> pesquisarPorDisciplinaCursoProcesso(int idDisciplina, int idCurso, int idProcesso){
        VwConfereDiscrepanciaDAO xy = new VwConfereDiscrepanciaDAOImpl();
        return xy.pesquisarPorDisciplinaCursoProcesso(idDisciplina, idCurso, idProcesso);
        
    }
    

}
