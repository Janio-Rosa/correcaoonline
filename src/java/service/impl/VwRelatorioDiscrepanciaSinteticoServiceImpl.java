/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwRelatorioDiscrepanciaSinteticoDAO;
import dao.impl.VwRelatorioDiscrepanciaSinteticoDAOImpl;
import java.util.List;
import model.VwRelatorioDiscrepanciaSintetico;
import service.VwRelatorioDiscrepanciaSinteticoService;

/**
 *
 * @author Janio
 */
public class VwRelatorioDiscrepanciaSinteticoServiceImpl implements VwRelatorioDiscrepanciaSinteticoService {

    @Override
    public List<VwRelatorioDiscrepanciaSintetico> pesquisarTodos() {
        VwRelatorioDiscrepanciaSinteticoDAO xy = new VwRelatorioDiscrepanciaSinteticoDAOImpl();
        return xy.pesquisarTodos();
    }

    @Override
    public VwRelatorioDiscrepanciaSintetico pesquisarPorID(int id) {
        VwRelatorioDiscrepanciaSinteticoDAO xy = new VwRelatorioDiscrepanciaSinteticoDAOImpl();
        return xy.pesquisarPorID(id);
    }

    @Override
    public List<VwRelatorioDiscrepanciaSintetico> pesquisarTodosOrdenado() {
        VwRelatorioDiscrepanciaSinteticoDAO xy = new VwRelatorioDiscrepanciaSinteticoDAOImpl();
        String[] criterioOrdenar={"nmDisciplina","nrQuestao"};
        return xy.pesquisarTodosOrdenado(criterioOrdenar);
    }

    @Override
    public List<VwRelatorioDiscrepanciaSintetico> pesquisarPorProcessoDisciplina(int idProcesso,int idDisciplina) {
        VwRelatorioDiscrepanciaSinteticoDAO xy = new VwRelatorioDiscrepanciaSinteticoDAOImpl();
        return xy.pesquisarPorProcessoDisciplina(idProcesso, idDisciplina);
    }


}
