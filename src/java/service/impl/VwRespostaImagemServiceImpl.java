/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwRespostaImagemDAO;
import dao.impl.VwRespostaImagemDAOImpl;
import java.util.List;
import model.VwRespostaImagem;
import service.VwRespostaImagemService;

/**
 *
 * @author administrator
 */
public class VwRespostaImagemServiceImpl implements VwRespostaImagemService {

    @Override
    public List<VwRespostaImagem> pesquisarTodos() {
        VwRespostaImagemDAO vrcd = new VwRespostaImagemDAOImpl();
        return vrcd.pesquisarTodos();
    }

    @Override
    public VwRespostaImagem pesquisarPorIDLong(long id) {
        VwRespostaImagemDAO vrcd = new VwRespostaImagemDAOImpl();
        return vrcd.pesquisarPorIDLong(id);
    }

    @Override
    public List<VwRespostaImagem> pesquisarTodosOrdenado(String[] atributoOrdenar) {
        VwRespostaImagemDAO vrcd = new VwRespostaImagemDAOImpl();
        return vrcd.pesquisarTodosOrdenado(atributoOrdenar);
    }

    @Override
    public List<VwRespostaImagem> pesquisarPorIdResposta(long idResposta) {
        VwRespostaImagemDAO vrcd = new VwRespostaImagemDAOImpl();
        return vrcd.pesquisarPorIdResposta(idResposta);
    }

    
    
}
