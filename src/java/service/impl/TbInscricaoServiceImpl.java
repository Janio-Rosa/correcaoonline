/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.TbInscricaoDAO;
import dao.impl.TbInscricaoDAOImpl;
import java.util.List;
import model.TbInscricao;
import service.TbInscricaoService;

/**
 *
 * @author Janio
 */
public class TbInscricaoServiceImpl implements TbInscricaoService  {

    @Override
    public List<TbInscricao> pesquisarTodos() {
        TbInscricaoDAO rnd = new TbInscricaoDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public TbInscricao pesquisarPorID(int id) {
        TbInscricaoDAO rnd = new TbInscricaoDAOImpl();
        return rnd.pesquisarPorID(id);
    }

    @Override
    public TbInscricao pesquisarPorIDLong(long id) {
        TbInscricaoDAO rnd = new TbInscricaoDAOImpl();
        return rnd.pesquisarPorIDLong(id);
    }

    @Override
    public List<TbInscricao> pesquisarTodosOrdenado() {
        TbInscricaoDAO rnd = new TbInscricaoDAOImpl();
        String[] criterios = {"nr_inscricao"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }
    
}
