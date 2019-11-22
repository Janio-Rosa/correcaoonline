/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.ResumoCorrecaoDAO;
import dao.impl.ResumoCorrecaoDAOImpl;
import java.util.List;
import model.TbResumoCorrecao;
import service.ResumoCorrecaoService;

/**
 *
 * @author administrator
 */
public class ResumoCorrecaoServiceImpl implements ResumoCorrecaoService {
    @Override
    public List<TbResumoCorrecao> pesquisarTodos() {
        ResumoCorrecaoDAO rnd = new ResumoCorrecaoDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public TbResumoCorrecao inserir(TbResumoCorrecao retornoNis) {
        ResumoCorrecaoDAO rnd = new ResumoCorrecaoDAOImpl();
        return rnd.inserir(retornoNis);
    }

    @Override
    public TbResumoCorrecao atualizar(TbResumoCorrecao retornoNis) {
        ResumoCorrecaoDAO rnd = new ResumoCorrecaoDAOImpl();
        return rnd.atualizar(retornoNis);
    }

    @Override
    public TbResumoCorrecao pesquisarPorID(int id) {
        ResumoCorrecaoDAO rnd = new ResumoCorrecaoDAOImpl();
        return rnd.pesquisarPorID(id);
    }

    @Override
    public List<TbResumoCorrecao> pesquisarTodosOrdenado() {
        ResumoCorrecaoDAO rnd = new ResumoCorrecaoDAOImpl();
        String[] criterios = {"idResposta"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }

    @Override
    public List<TbResumoCorrecao> pesquisarPorIdResposta(long idResposta) {
        ResumoCorrecaoDAO rnd = new ResumoCorrecaoDAOImpl();
        return rnd.pesquisarPorIdResposta(idResposta);
    }

    @Override
    public TbResumoCorrecao pesquisarPorRespostaColaborador(long resposta, long colaborador) {
        ResumoCorrecaoDAO rnd = new ResumoCorrecaoDAOImpl();
        return rnd.pesquisarPorRespostaColaborador(resposta, colaborador);
    }

    @Override
    public TbResumoCorrecao pesquisarPorRespostaColaborador(long resposta, long colaborador,int idTipoCorrecao) {
        ResumoCorrecaoDAO rnd = new ResumoCorrecaoDAOImpl();
        return rnd.pesquisarPorRespostaColaborador(resposta, colaborador,idTipoCorrecao);
    }

    @Override
    public TbResumoCorrecao pesquisarPorRespostaTipoCorrecao(long resposta, int tipo) {
        ResumoCorrecaoDAO rnd = new ResumoCorrecaoDAOImpl();
        return rnd.pesquisarPorRespostaTipoCorrecao(resposta,tipo);
    }

    @Override
    public TbResumoCorrecao pesquisarPorIDLong(long id) {
        ResumoCorrecaoDAO rnd = new ResumoCorrecaoDAOImpl();
        return rnd.pesquisarPorIDLong(id);
    }
    
}
