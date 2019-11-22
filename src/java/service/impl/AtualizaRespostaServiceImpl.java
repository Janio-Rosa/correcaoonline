/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.AtualizaRespostaDAO;
import dao.impl.AtualizaRespostaDAOImpl;
import java.util.List;
import model.TbAtualizaResposta;
import service.AtualizaRespostaService;

/**
 *
 * @author Janio
 */
public class AtualizaRespostaServiceImpl implements AtualizaRespostaService {
    
    @Override
    public List<TbAtualizaResposta> pesquisarTodos() {
        AtualizaRespostaDAO rnd = new AtualizaRespostaDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public TbAtualizaResposta inserir(TbAtualizaResposta retornoNis) {
        AtualizaRespostaDAO rnd = new AtualizaRespostaDAOImpl();
        return rnd.inserir(retornoNis);
    }

    @Override
    public TbAtualizaResposta atualizar(TbAtualizaResposta retornoNis) {
        AtualizaRespostaDAO rnd = new AtualizaRespostaDAOImpl();
        return rnd.atualizar(retornoNis);
    }

    @Override
    public boolean apagar(TbAtualizaResposta retornoNis) {
        AtualizaRespostaDAO rnd = new AtualizaRespostaDAOImpl();
        return rnd.apagar(retornoNis);
    }

    @Override
    public TbAtualizaResposta pesquisarPorID(long id) {
        AtualizaRespostaDAO rnd = new AtualizaRespostaDAOImpl();
        return rnd.pesquisarPorIDLong(id);
    }

}
