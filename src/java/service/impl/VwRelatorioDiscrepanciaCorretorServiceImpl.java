/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwRelatorioDiscrepanciaCorretorDAO;
import dao.impl.VwRelatorioDiscrepanciaCorretorDAOImpl;
import java.util.List;
import model.VwRelatorioDiscrepanciaCorretor;
import service.VwRelatorioDiscrepanciaCorretorService;

/**
 *
 * @author Janio
 */
public class VwRelatorioDiscrepanciaCorretorServiceImpl implements VwRelatorioDiscrepanciaCorretorService {

    @Override
    public List<VwRelatorioDiscrepanciaCorretor> pesquisarTodos() {
        VwRelatorioDiscrepanciaCorretorDAO xy = new VwRelatorioDiscrepanciaCorretorDAOImpl();
        return xy.pesquisarTodos();
    }

    @Override
    public VwRelatorioDiscrepanciaCorretor pesquisarPorID(int id) {
        VwRelatorioDiscrepanciaCorretorDAO xy = new VwRelatorioDiscrepanciaCorretorDAOImpl();
        return xy.pesquisarPorID(id);
    }

    @Override
    public List<VwRelatorioDiscrepanciaCorretor> pesquisarTodosOrdenado() {
        VwRelatorioDiscrepanciaCorretorDAO xy = new VwRelatorioDiscrepanciaCorretorDAOImpl();
        String[] criterioOrdenar={"nrQuestao"};
        return xy.pesquisarTodosOrdenado(criterioOrdenar);
    }

    @Override
    public List<VwRelatorioDiscrepanciaCorretor> pesquisarPorProcessoDisciplina(int idProcesso,int idDisciplina) {
        VwRelatorioDiscrepanciaCorretorDAO xy = new VwRelatorioDiscrepanciaCorretorDAOImpl();
        return xy.pesquisarPorProcessoDisciplina(idProcesso, idDisciplina);
    }


}
