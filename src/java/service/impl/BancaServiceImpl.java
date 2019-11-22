/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.BancaDAO;
import dao.impl.BancaDAOImpl;
import java.util.List;
import model.TbBanca;
import service.BancaService;

/**
 *
 * @author KAMYLLA
 */
public class BancaServiceImpl implements BancaService {
    
    @Override
    public List<TbBanca> pesquisarTodos() {
        BancaDAO cd =  new BancaDAOImpl();
        return cd.pesquisarTodos();
    }

    @Override
    public TbBanca inserir(TbBanca nome) {
        BancaDAO cd = new BancaDAOImpl();
        return cd.inserir(nome);
    }

    @Override
    public TbBanca atualizar(TbBanca nome) {
        BancaDAO cd =  new BancaDAOImpl();
        return cd.atualizar(nome);
    }

    @Override
    public boolean apagar(TbBanca nome) {
        BancaDAO cd =  new BancaDAOImpl();
        return cd.apagar(nome);
    }

    @Override
    public TbBanca pesquisarPorID(int id) {
        BancaDAO cd =  new BancaDAOImpl();
        return cd.pesquisarPorID(id);
    }

    @Override
    public List<TbBanca> pesquisarTodosOrdenado() {
        BancaDAO cd =  new BancaDAOImpl();
        String[] criterios = {"nmCategoria"};
        return cd.pesquisarTodosOrdenado(criterios);
    
    }
    
    @Override
    public List<TbBanca> pesquisarPorDisciplina(int idDisciplina){
         BancaDAO cd =  new BancaDAOImpl();
         return cd.pesquisarPorDisciplina(idDisciplina);
    }
    
    @Override
    public List<TbBanca> pesquisarPorCurso(int idCurso){
         BancaDAO cd =  new BancaDAOImpl();
         return cd.pesquisarPorCurso(idCurso);
    }
    
    @Override
    public List<TbBanca> pesquisarPorDisciplinaCurso(int idDisciplina,int idCurso){
        BancaDAO cd =  new BancaDAOImpl();
        return cd.pesquisarPorDisciplinaCurso(idDisciplina, idCurso);
        
    }

    @Override
    public List<TbBanca> pesquisarTodosOrdenadoPorProcesso(int idProcesso) {
        BancaDAO cd =  new BancaDAOImpl();
        String[] criterios = {"nmCategoria"};
        return cd.pesquisarTodosOrdenadoPorProcesso(criterios,idProcesso);
    
    }
    
    
}
