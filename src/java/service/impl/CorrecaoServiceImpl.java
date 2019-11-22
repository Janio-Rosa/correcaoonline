/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;
import java.util.List;
import model.TbCorrecao;
import dao.CorrecaoDAO;
import dao.impl.CorrecaoDAOImpl;
import model.TbColaborador;
import model.TbResposta;
import model.TbTipoCorrecao;
import service.CorrecaoService;
/**
 *
 * @author Janio
 */
public class CorrecaoServiceImpl implements CorrecaoService {
    @Override
    public List<TbCorrecao> pesquisarTodos() {
        CorrecaoDAO rnd = new CorrecaoDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public TbCorrecao inserir(TbCorrecao retornoNis) {
        CorrecaoDAO rnd = new CorrecaoDAOImpl();
        return rnd.inserir(retornoNis);
    }

    @Override
    public TbCorrecao atualizar(TbCorrecao retornoNis) {
        CorrecaoDAO rnd = new CorrecaoDAOImpl();
        return rnd.atualizar(retornoNis);
    }

    @Override
    public boolean apagar(TbCorrecao retornoNis) {
        CorrecaoDAO rnd = new CorrecaoDAOImpl();
        return rnd.apagar(retornoNis);
    }

    @Override
    public TbCorrecao pesquisarPorID(int id) {
        CorrecaoDAO rnd = new CorrecaoDAOImpl();
        return rnd.pesquisarPorID(id);
    }

    @Override
    public List<TbCorrecao> pesquisarTodosOrdenado() {
        CorrecaoDAO rnd = new CorrecaoDAOImpl();
        String[] criterios = {"idResposta"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }

    @Override
    public List<TbCorrecao> pesquisarPorResposta(long idResposta) {
        CorrecaoDAO rnd = new CorrecaoDAOImpl();
        TbResposta resp = new TbResposta();
        resp.setIdResposta(idResposta);
        return rnd.pesquisarPorResposta(resp);
    }

    @Override
    public TbCorrecao pesquisarPorCorrecaoColaborador(long resposta, long colaborador) {
        CorrecaoDAO rnd = new CorrecaoDAOImpl();
        TbResposta resp = new TbResposta();
        resp.setIdResposta(resposta);
        TbColaborador colab = new TbColaborador();
        colab.setIdColaborador(colaborador);
        return rnd.pesquisarPorRespostaColaborador(resp, colab);
    }

    @Override
    public TbCorrecao pesquisarPorCorrecaoColaborador(long resposta, long colaborador,int idTipoCorrecao) {
        CorrecaoDAO rnd = new CorrecaoDAOImpl();
        TbResposta resp = new TbResposta();
        TbTipoCorrecao tipoCorrecao=new TbTipoCorrecao(idTipoCorrecao);
        resp.setIdResposta(resposta);
        TbColaborador colab = new TbColaborador();
        colab.setIdColaborador(colaborador);
        return rnd.pesquisarPorRespostaColaborador(resp, colab,tipoCorrecao);
    }

    @Override
    public int quantidadePorColaborador(long colaborador) {
        TbColaborador col= new TbColaborador(colaborador);
        CorrecaoDAO rnd = new CorrecaoDAOImpl();
        return rnd.quantidadePorColaborador(col);
        
    }

    @Override
    public int quantidadePorColaboradorSemDiscrepancia(long colaborador) {
        TbColaborador col= new TbColaborador(colaborador);
        CorrecaoDAO rnd = new CorrecaoDAOImpl();
        return rnd.quantidadePorColaboradorSemDiscrepancia(col);
        
    }

    @Override
    public TbCorrecao pesquisarPorRespostaTipoCorrecao(long resposta, int tipo) {
        CorrecaoDAO rnd = new CorrecaoDAOImpl();
        return rnd.pesquisarPorRespostaTipoCorrecao(new TbResposta(resposta),new TbTipoCorrecao(tipo));
    }

    @Override
    public TbCorrecao pesquisarPorIDLong(long id) {
        CorrecaoDAO rnd = new CorrecaoDAOImpl();
        return rnd.pesquisarPorIDLong(id);
    }
    

}
