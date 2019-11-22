/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwCorretorDisciplinaProcessoDAO;
import dao.impl.VwCorretorDisciplinaProcessoDAOImpl;
import java.util.List;
import model.VwCorretorDisciplinaProcesso;
import service.VwCorretorDisciplinaProcessoService;

/**
 *
 * @author janio
 */
public class VwCorretorDisciplinaProcessoServiceImpl implements VwCorretorDisciplinaProcessoService {

    @Override
    public List<VwCorretorDisciplinaProcesso> pesquisarTodos() {
        VwCorretorDisciplinaProcessoDAO vdcDAO = new VwCorretorDisciplinaProcessoDAOImpl();
        return vdcDAO.pesquisarTodos();
    }

    @Override
    public VwCorretorDisciplinaProcesso pesquisarPorID(int id) {
        VwCorretorDisciplinaProcessoDAO vdcDAO = new VwCorretorDisciplinaProcessoDAOImpl();
        return vdcDAO.pesquisarPorID(id);
    }

    @Override
    public List<VwCorretorDisciplinaProcesso> pesquisarTodosOrdenado() {
        VwCorretorDisciplinaProcessoDAO vdcDAO = new VwCorretorDisciplinaProcessoDAOImpl();
        String[] ordenar = {"nmPessoa"};
        return vdcDAO.pesquisarTodosOrdenado(ordenar);
    }

    @Override
    public List<VwCorretorDisciplinaProcesso> pesquisaPorProcessoDisciplina(int idDisciplina,int idProcesso) {
        VwCorretorDisciplinaProcessoDAO vdcDAO = new VwCorretorDisciplinaProcessoDAOImpl();
        List lista = vdcDAO.pesquisaPorProcessoDisciplina(idDisciplina,idProcesso);
        return lista;
    }
    
}
