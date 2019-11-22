/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwRelatorioNotasDAO;
import dao.impl.VwRelatorioNotasDAOImpl;
import java.util.List;
import model.VwRelatorioNotas;
import service.VwRelatorioNotasService;

/**
 *
 * @author janio
 */
public class VwRelatorioNotasServiceImpl implements VwRelatorioNotasService {

    @Override
    public List<VwRelatorioNotas> pesquisarTodos() {
        VwRelatorioNotasDAO vrnd = new VwRelatorioNotasDAOImpl();
        return vrnd.pesquisarTodos();
    }

    @Override
    public VwRelatorioNotas pesquisarPorID(int id) {
        VwRelatorioNotasDAO vrnd = new VwRelatorioNotasDAOImpl();
        return vrnd.pesquisarPorID(id);
    }

    @Override
    public List<VwRelatorioNotas> pesquisarTodosOrdenado(String[] atributoOrdenar) {
        VwRelatorioNotasDAO vrnd = new VwRelatorioNotasDAOImpl();
        return vrnd.pesquisarTodosOrdenado(atributoOrdenar);
    }

    @Override
    public List<VwRelatorioNotas> pesquisarPorProcesso(int idProcesso) {
        VwRelatorioNotasDAO vrnd = new VwRelatorioNotasDAOImpl();
        return vrnd.pesquisarPorProcesso(idProcesso);
    }

    @Override
    public List<VwRelatorioNotas> pesquisarPorProcessoDisciplina(int idProcesso, int idDIsciplina) {
        VwRelatorioNotasDAO vrnd = new VwRelatorioNotasDAOImpl();
        return vrnd.pesquisarPorProcessoDisciplina(idProcesso,idDIsciplina);
    }

    @Override
    public List<VwRelatorioNotas> pesquisarPorProcessoDisciplinaCurso(int idProcesso, int idDIsciplina, int idCurso) {
        VwRelatorioNotasDAO vrnd = new VwRelatorioNotasDAOImpl();
        return vrnd.pesquisarPorProcessoDisciplinaCurso(idProcesso, idDIsciplina, idCurso);
    }
    
}
