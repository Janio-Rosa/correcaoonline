/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.DisciplinaDAO;
import dao.impl.DisciplinaDAOImpl;
import java.util.List;
import model.TbDisciplina;
import service.DisciplinaService;

/**
 *
 * @author KAMYLLA
 */
public class DisciplinaServiceImpl implements DisciplinaService {
    
     @Override
    public List<TbDisciplina> pesquisarTodos() {
        DisciplinaDAO dd =  new DisciplinaDAOImpl();
        return dd.pesquisarTodos();
    }

    @Override
    public TbDisciplina inserir(TbDisciplina nome) {
        DisciplinaDAO dd = new DisciplinaDAOImpl();
        return dd.inserir(nome);
    }

    @Override
    public TbDisciplina atualizar(TbDisciplina nome) {
        DisciplinaDAO dd =  new DisciplinaDAOImpl();
        return dd.atualizar(nome);
    }

    @Override
    public boolean apagar(TbDisciplina nome) {
        DisciplinaDAO dd =  new DisciplinaDAOImpl();
        return dd.apagar(nome);
    }

    @Override
    public TbDisciplina pesquisarPorID(int id) {
        DisciplinaDAO dd =  new DisciplinaDAOImpl();
        return dd.pesquisarPorID(id);
    }

    @Override
    public List<TbDisciplina> pesquisarTodosOrdenado() {
        DisciplinaDAO dd =  new DisciplinaDAOImpl();
        String[] criterios = {"nmDisciplina"};
        return dd.pesquisarTodosOrdenado(criterios);
    
    }

    @Override
    public List<TbDisciplina> pesquisarTodosOrdenadasComResposta() {
        DisciplinaDAO dd =  new DisciplinaDAOImpl();
        String[] criterios = {"nmDisciplina"};
        return dd.pesquisarTodosOrdenadasComResposta(criterios);
    
    }

}