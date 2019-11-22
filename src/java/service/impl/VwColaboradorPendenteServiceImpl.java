/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwColaboradorPendenteDAO;
import dao.impl.VwColaboradorPendenteDAOImpl;
import java.util.List;
import model.VwColaboradorPendente;
import service.VwColaboradorPendenteService;

/**
 *
 * @author Janio
 */
public class VwColaboradorPendenteServiceImpl implements VwColaboradorPendenteService {
    
     @Override
    public List<VwColaboradorPendente> pesquisarTodos() {
        VwColaboradorPendenteDAO cd =  new VwColaboradorPendenteDAOImpl();
        return cd.pesquisarTodos();
    }

    @Override
    public VwColaboradorPendente pesquisarPorID(int id) {
        VwColaboradorPendenteDAO cd =  new VwColaboradorPendenteDAOImpl();
        return cd.pesquisarPorID(id);
    }

    @Override
    public VwColaboradorPendente pesquisarPorIDLong(long id) {
        VwColaboradorPendenteDAO cd =  new VwColaboradorPendenteDAOImpl();
        return cd.pesquisarPorIDLong(id);
    }

    @Override
    public VwColaboradorPendente pesquisarPorCPF(String nrCpf) {
        VwColaboradorPendenteDAO cd =  new VwColaboradorPendenteDAOImpl();
        return cd.pesquisarPorCPF(nrCpf);
    }

    @Override
    public VwColaboradorPendente pesquisarPorCPFAtivo(String nrCpf) {
        VwColaboradorPendenteDAO cd =  new VwColaboradorPendenteDAOImpl();
        return cd.pesquisarPorCPFAtivo(nrCpf);
    }

    @Override
    public VwColaboradorPendente pesquisarPorCPFeProcesso(String nrCpf,int idProcesso){
        VwColaboradorPendenteDAO cd =  new VwColaboradorPendenteDAOImpl();
        return cd.pesquisarPorCPFeProcesso(nrCpf,idProcesso);
    }

    @Override
    public VwColaboradorPendente pesquisarAtivosPorProcesso(int idProcesso) {
        VwColaboradorPendenteDAO cd =  new VwColaboradorPendenteDAOImpl();
        return cd.pesquisarAtivosPorProcesso(idProcesso);
     }

    @Override
    public List<VwColaboradorPendente> pesquisarTodosOrdenado() {
        VwColaboradorPendenteDAO cd =  new VwColaboradorPendenteDAOImpl();
        String[] criterios = {"nmColaborador"};
        return cd.pesquisarTodosOrdenado(criterios);
    
    }

    @Override
    public List<VwColaboradorPendente> pesquisarListaPorCPF(String nrCpf) {
         VwColaboradorPendenteDAO cd =  new VwColaboradorPendenteDAOImpl();
        return cd.pesquisarListaPorCPF(nrCpf);
   }
    
}