/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwRespostasComProblemaDAO;
import dao.impl.VwRespostasComProblemaDAOImpl;
import java.util.List;
import model.VwRespostasComProblema;
import service.VwRespostasComProblemaService;

/**
 *
 * @author Janio
 */
public class VwRespostasComProblemaServiceImpl implements VwRespostasComProblemaService {

    @Override
    public List<VwRespostasComProblema> pesquisarTodos() {
        VwRespostasComProblemaDAO vrcpd = new VwRespostasComProblemaDAOImpl();
        return vrcpd.pesquisarTodos();
    }

    @Override
    public List<VwRespostasComProblema> pesquisarTodosOrdenado() {
        VwRespostasComProblemaDAO vrcpd = new VwRespostasComProblemaDAOImpl();
        String[] criterios={"nmDisciplina"};
        return vrcpd.pesquisarTodosOrdenado(criterios);
    }

    @Override
    public List<VwRespostasComProblema> pesquisarPorDisciplina(int idDisciplina) {
        VwRespostasComProblemaDAO vrcpd = new VwRespostasComProblemaDAOImpl();
        return vrcpd.pesquisarPorDisciplina(idDisciplina);
    }
    
}
