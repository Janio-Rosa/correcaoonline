/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwColaboradorPendenteDiscrepanciaDAO;
import dao.impl.VwColaboradorPendenteDiscrepanciaDAOImpl;
import java.util.List;
import model.VwColaboradorPendenteDiscrepancia;
import service.VwColaboradorPendenteDiscrepanciaService;

/**
 *
 * @author Jânio
 */
public class VwColaboradorPendenteDiscrepanciaServiceImpl implements VwColaboradorPendenteDiscrepanciaService {
    
     @Override
    public List<VwColaboradorPendenteDiscrepancia> pesquisarTodos() {
        VwColaboradorPendenteDiscrepanciaDAO cd =  new VwColaboradorPendenteDiscrepanciaDAOImpl();
        return cd.pesquisarTodos();
    }

    @Override
    public VwColaboradorPendenteDiscrepancia pesquisarPorID(int id) {
        VwColaboradorPendenteDiscrepanciaDAO cd =  new VwColaboradorPendenteDiscrepanciaDAOImpl();
        return cd.pesquisarPorID(id);
    }

    @Override
    public VwColaboradorPendenteDiscrepancia pesquisarPorIDLong(long id) {
        VwColaboradorPendenteDiscrepanciaDAO cd =  new VwColaboradorPendenteDiscrepanciaDAOImpl();
        return cd.pesquisarPorIDLong(id);
    }

    @Override
    public VwColaboradorPendenteDiscrepancia pesquisarPorCPF(String nrCpf) {
        VwColaboradorPendenteDiscrepanciaDAO cd =  new VwColaboradorPendenteDiscrepanciaDAOImpl();
        return cd.pesquisarPorCPF(nrCpf);
    }

    @Override
    public VwColaboradorPendenteDiscrepancia pesquisarPorCPFAtivo(String nrCpf) {
        VwColaboradorPendenteDiscrepanciaDAO cd =  new VwColaboradorPendenteDiscrepanciaDAOImpl();
        return cd.pesquisarPorCPFAtivo(nrCpf);
    }

    @Override
    public List<VwColaboradorPendenteDiscrepancia> pesquisarListaPorCPFAtivo(String nrCpf) {
        VwColaboradorPendenteDiscrepanciaDAO cd =  new VwColaboradorPendenteDiscrepanciaDAOImpl();
        return cd.pesquisarListaPorCPFAtivo(nrCpf);
    }

    @Override
    public VwColaboradorPendenteDiscrepancia pesquisarPorCPFeProcesso(String nrCpf,int idProcesso){
        VwColaboradorPendenteDiscrepanciaDAO cd =  new VwColaboradorPendenteDiscrepanciaDAOImpl();
        return cd.pesquisarPorCPFeProcesso(nrCpf,idProcesso);
    }

    @Override
    public VwColaboradorPendenteDiscrepancia pesquisarAtivosPorProcesso(int idProcesso) {
        VwColaboradorPendenteDiscrepanciaDAO cd =  new VwColaboradorPendenteDiscrepanciaDAOImpl();
        return cd.pesquisarAtivosPorProcesso(idProcesso);
     }

    @Override
    public List<VwColaboradorPendenteDiscrepancia> pesquisarTodosOrdenado() {
        VwColaboradorPendenteDiscrepanciaDAO cd =  new VwColaboradorPendenteDiscrepanciaDAOImpl();
        String[] criterios = {"nmColaborador"};
        return cd.pesquisarTodosOrdenado(criterios);
    
    }

    @Override
    public VwColaboradorPendenteDiscrepancia pesquisarPorIDColaborador(long IdColaborador) {
         VwColaboradorPendenteDiscrepanciaDAO cd =  new VwColaboradorPendenteDiscrepanciaDAOImpl();
        return cd.pesquisarPorIDColaborador(IdColaborador);
   }
    
}