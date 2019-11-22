/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.ColaboradorDAO;
import dao.impl.ColaboradorDAOImpl;
import java.util.List;
import model.TbColaborador;
import model.TbPessoa;
import model.TbProcesso;
import service.ColaboradorService;

/**
 *
 * @author KAMYLLA
 */
public class ColaboradorServiceImpl implements ColaboradorService {
    
     @Override
    public List<TbColaborador> pesquisarTodos() {
        ColaboradorDAO cd =  new ColaboradorDAOImpl();
        return cd.pesquisarTodos();
    }

    @Override
    public TbColaborador inserir(TbColaborador nome) {
        ColaboradorDAO cd = new ColaboradorDAOImpl();
        return cd.inserir(nome);
    }

    @Override
    public TbColaborador atualizar(TbColaborador nome) {
        ColaboradorDAO cd =  new ColaboradorDAOImpl();
        return cd.atualizar(nome);
    }

    @Override
    public boolean apagar(TbColaborador nome) {
        ColaboradorDAO cd =  new ColaboradorDAOImpl();
        return cd.apagar(nome);
    }

    @Override
    public TbColaborador pesquisarPorID(int id) {
        ColaboradorDAO cd =  new ColaboradorDAOImpl();
        return cd.pesquisarPorID(id);
    }

    @Override
    public TbColaborador pesquisarPorIDLong(long id) {
        ColaboradorDAO cd =  new ColaboradorDAOImpl();
        return cd.pesquisarPorIDLong(id);
    }

    @Override
    public List<TbColaborador> pesquisarTodosOrdenado() {
        ColaboradorDAO cd =  new ColaboradorDAOImpl();
        String[] criterios = {"nmColaborador"};
        return cd.pesquisarTodosOrdenado(criterios);
    
    }
    
    @Override
    public TbColaborador pesquisarPorCPF(String nrCpf) {
        ColaboradorDAO cd =  new ColaboradorDAOImpl();
        return cd.pesquisarPorCPF(nrCpf);
    }

    @Override
    public TbColaborador pesquisarPorCPFAtivo(String nrCpf) {
        ColaboradorDAO cd =  new ColaboradorDAOImpl();
        return cd.pesquisarPorCPFAtivo(nrCpf);
    }

    @Override
    public TbColaborador pesquisarPorCPFeProcesso(TbPessoa procurarPessoa,TbProcesso procurarProcesso){
        ColaboradorDAO cd =  new ColaboradorDAOImpl();
        return cd.pesquisarPorCPFeProcesso(procurarPessoa,procurarProcesso);
    }

    @Override
    public TbColaborador pesquisarAtivosPorProcesso(int idProcesso) {
        ColaboradorDAO cd =  new ColaboradorDAOImpl();
        return cd.pesquisarAtivosPorProcesso(idProcesso);
     }

    @Override
    public List<TbColaborador> pesquisarTodosPorCPF(String nrCpf,TbProcesso processo) {
        ColaboradorDAO cd =  new ColaboradorDAOImpl();
        return cd.pesquisarTodosPorCPF(nrCpf,processo);
    }

}