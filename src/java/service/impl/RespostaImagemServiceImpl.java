/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.RespostaImagemDAO;
import dao.impl.RespostaImagemDAOImpl;
import java.util.Date;
import java.util.List;
import model.TbResposta;
import model.TbRespostaImagem;
import service.RespostaImagemService;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Janio
 */
public class RespostaImagemServiceImpl implements RespostaImagemService {

    @Override
    public List<TbRespostaImagem> pesquisarTodos() {
        RespostaImagemDAO rnd = new RespostaImagemDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public TbRespostaImagem inserir(TbRespostaImagem respostaImagemTO) {
        RespostaImagemDAO rnd = new RespostaImagemDAOImpl();
        return rnd.inserir(respostaImagemTO);
    }

    @Override
    public TbRespostaImagem atualizar(TbRespostaImagem respostaImagemTO) {
        RespostaImagemDAO rnd = new RespostaImagemDAOImpl();
        return rnd.atualizar(respostaImagemTO);
    }

    @Override
    public boolean apagar(TbRespostaImagem respostaImagemTO) {
        RespostaImagemDAO rnd = new RespostaImagemDAOImpl();
        return rnd.apagar(respostaImagemTO);
    }

    @Override
    public TbRespostaImagem pesquisarPorID(int id) {
        RespostaImagemDAO rnd = new RespostaImagemDAOImpl();
        return rnd.pesquisarPorID(id);
    }

    @Override
    public TbRespostaImagem pesquisarPorIDLong(long id) {
        RespostaImagemDAO rnd = new RespostaImagemDAOImpl();
        return rnd.pesquisarPorIDLong(id);
    }

    @Override
    public TbRespostaImagem pesquisarProximaImagem() {
        RespostaImagemDAO rnd = new RespostaImagemDAOImpl();
        TbRespostaImagem retorno = null;
        
        retorno = rnd.pesquisarProximaImagem();
        Session sessao = rnd.getSessao();
        Transaction t = sessao.getTransaction();
        
        //ATUALIZA FLAG DE CONFERIDO
        if(retorno!=null){
            retorno.setFlConferida(true);
            retorno.setDtUltimaAtualizacao(new Date());
            rnd.atualizarFlag(retorno);
        }
        t.commit(); //libera sessão
        sessao.close();

        return retorno;
    }

    @Override
    public List<TbRespostaImagem> pesquisarTodosOrdenado() {
        RespostaImagemDAO rnd = new RespostaImagemDAOImpl();
        String[] criterios = {"dtImportacao"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }

    @Override
    public TbRespostaImagem pesquisarProximaImagemEmBranco() {
        RespostaImagemDAO rnd = new RespostaImagemDAOImpl();
        TbRespostaImagem retorno = null;
        
        retorno = rnd.pesquisarProximaImagemEmBranco();
        Session sessao = rnd.getSessao();
        Transaction t = sessao.getTransaction();
        
        //ATUALIZA FLAG DE CONFERIDO
        if(retorno!=null){
            retorno.setFlEmBrancoConferida(true);
            retorno.setDtUltimaAtualizacao(new Date());
            rnd.atualizarFlag(retorno);
        }
        t.commit(); //libera sessão
        sessao.close();

        return retorno;
    }

    @Override
    public List<TbRespostaImagem> pesquisarPorIdResposta(long idResposta) {
        //TbResposta consultarResposta = (new RespostaServiceImpl()).pesquisarPorIDLong(idResposta);
        TbResposta consultarResposta = new TbResposta(idResposta);
        RespostaImagemDAO rid = new RespostaImagemDAOImpl();
        return rid.pesquisarPorIdResposta(consultarResposta);
    }

    
}
