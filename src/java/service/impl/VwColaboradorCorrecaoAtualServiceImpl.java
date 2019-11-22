/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwColaboradorCorrecaoAtualDAO;
import dao.impl.VwColaboradorCorrecaoAtualDAOImpl;
import java.util.List;
import model.VwColaboradorCorrecaoAtual;
import service.VwColaboradorCorrecaoAtualService;

/**
 *
 * @author Janio
 */
public class VwColaboradorCorrecaoAtualServiceImpl implements VwColaboradorCorrecaoAtualService {
    
     @Override
    public List<VwColaboradorCorrecaoAtual> pesquisarTodos() {
        VwColaboradorCorrecaoAtualDAO cd =  new VwColaboradorCorrecaoAtualDAOImpl();
        return cd.pesquisarTodos();
    }

    @Override
    public VwColaboradorCorrecaoAtual pesquisarPorID(int id) {
        VwColaboradorCorrecaoAtualDAO cd =  new VwColaboradorCorrecaoAtualDAOImpl();
        return cd.pesquisarPorID(id);
    }

    @Override
    public VwColaboradorCorrecaoAtual pesquisarPorIDLong(long id) {
        VwColaboradorCorrecaoAtualDAO cd =  new VwColaboradorCorrecaoAtualDAOImpl();
        return cd.pesquisarPorIDLong(id);
    }

    @Override
    public VwColaboradorCorrecaoAtual pesquisarPorCPF(String nrCpf) {
        VwColaboradorCorrecaoAtualDAO cd =  new VwColaboradorCorrecaoAtualDAOImpl();
        return cd.pesquisarPorCPF(nrCpf);
    }

    @Override
    public VwColaboradorCorrecaoAtual pesquisarPorCPFAtivo(String nrCpf) {
        VwColaboradorCorrecaoAtualDAO cd =  new VwColaboradorCorrecaoAtualDAOImpl();
        return cd.pesquisarPorCPFAtivo(nrCpf);
    }

    @Override
    public VwColaboradorCorrecaoAtual pesquisarPorCPFeProcesso(String nrCpf,int idProcesso){
        VwColaboradorCorrecaoAtualDAO cd =  new VwColaboradorCorrecaoAtualDAOImpl();
        return cd.pesquisarPorCPFeProcesso(nrCpf,idProcesso);
    }

    @Override
    public VwColaboradorCorrecaoAtual pesquisarAtivosPorProcesso(int idProcesso) {
        VwColaboradorCorrecaoAtualDAO cd =  new VwColaboradorCorrecaoAtualDAOImpl();
        return cd.pesquisarAtivosPorProcesso(idProcesso);
     }

    @Override
    public List<VwColaboradorCorrecaoAtual> pesquisarTodosOrdenado() {
        VwColaboradorCorrecaoAtualDAO cd =  new VwColaboradorCorrecaoAtualDAOImpl();
        String[] criterios = {"nmColaborador"};
        return cd.pesquisarTodosOrdenado(criterios);
    
    }
    
}