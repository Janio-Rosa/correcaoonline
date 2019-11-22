/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;
import java.util.List;
import model.TbResposta;
import dao.RespostaDAO;
import dao.impl.RespostaDAOImpl;
import model.TbDisciplina;
import model.TbProcesso;
import service.RespostaService;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Janio
 */
public class RespostaServiceImpl implements RespostaService  {
    @Override
    public List<TbResposta> pesquisarTodos() {
        RespostaDAO rnd = new RespostaDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public TbResposta inserir(TbResposta retornoNis) {
        RespostaDAO rnd = new RespostaDAOImpl();
        return rnd.inserir(retornoNis);
    }

    @Override
    public TbResposta atualizar(TbResposta retornoNis) {
        RespostaDAO rnd = new RespostaDAOImpl();
        return rnd.atualizar(retornoNis);
    }

    @Override
    public boolean apagar(TbResposta retornoNis) {
        RespostaDAO rnd = new RespostaDAOImpl();
        return rnd.apagar(retornoNis);
    }

    @Override
    public TbResposta pesquisarPorID(int id) {
        RespostaDAO rnd = new RespostaDAOImpl();
        return rnd.pesquisarPorID(id);
    }

    @Override
    public TbResposta pesquisarPorIDLong(long id) {
        RespostaDAO rnd = new RespostaDAOImpl();
        return rnd.pesquisarPorIDLong(id);
    }

    @Override
    public List<TbResposta> pesquisarTodosOrdenado() {
        RespostaDAO rnd = new RespostaDAOImpl();
        String[] criterios = {"idImagem"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }


    @Override
    public TbResposta pesquisarRespostaPresaColaboradorAtual(long idColaborador) {
        RespostaDAO rnd = new RespostaDAOImpl();
        TbResposta retorno = null;
        
        retorno = rnd.pesquisarRespostaPresaColaboradorAtual(idColaborador);
        
        
        return retorno;
    }
    @Override
    public TbResposta pesquisarProximaResposta(int idDisciplina, int idCurso, int idProcesso) {
        RespostaDAO rnd = new RespostaDAOImpl();
        TbResposta retorno = null;
        
        retorno = rnd.pesquisarProximaResposta(idDisciplina, idCurso, idProcesso);
        Session sessao = rnd.getSessao();
        Transaction t = sessao.getTransaction();
        
        //ATUALIZA FLAG DE CORRIGINDO.
        if(retorno!=null){
            /*
            TbResposta atualizaFlag = new TbResposta(retorno.getIdResposta());
            atualizaFlag.setIdDisciplina(retorno.getIdDisciplina());
            atualizaFlag.setIdImagem(retorno.getIdImagem());
            atualizaFlag.setIdCurso(retorno.getIdCurso());
            atualizaFlag.setIdProcesso(retorno.getIdProcesso());
            atualizaFlag.setFlCorrigindo(true);
             */
            retorno.setFlCorrigindo(true);
            rnd.atualizarFlag(retorno);

        }
        t.commit(); //libera sessão
        sessao.close();

        return retorno;
    }

    @Override
    public TbResposta pesquisarPrimeiraResposta() {
        RespostaDAO rnd = new RespostaDAOImpl();
        return rnd.pesquisarPrimeiraResposta();
    }

    @Override
    public TbResposta pesquisarProximaRespostaDiscrepancia(int idDisciplina, int idCurso, int idProcesso) {
        RespostaDAO rnd = new RespostaDAOImpl();
        TbResposta retorno = null;
        
        retorno = rnd.pesquisarProximaRespostaDiscrepancia(idDisciplina, idCurso, idProcesso);
        Session sessao = rnd.getSessao();
        Transaction t = sessao.getTransaction();
        
        if(retorno!=null){
            retorno.setFlCorrigindo(true);
            rnd.atualizarFlag(retorno);
        }
        t.commit(); //libera sessão
        sessao.close();

        return retorno;
    }

    @Override
    public TbResposta pesquisarProximaRespostaDiscrepancia(int idDisciplina, int idCurso, int idProcesso,int idQuestao) {
        RespostaDAO rnd = new RespostaDAOImpl();
        TbResposta retorno = null;
        
        retorno = rnd.pesquisarProximaRespostaDiscrepancia(idDisciplina, idCurso, idProcesso,idQuestao);
        Session sessao = rnd.getSessao();
        Transaction t = sessao.getTransaction();
        
        if(retorno!=null){
            retorno.setFlCorrigindo(true);
            rnd.atualizarFlag(retorno);
        }
        t.commit(); //libera sessão
        sessao.close();

        return retorno;
    }
    

    @Override
    public TbResposta pesquisarProximaRespostaSegundaCorrecao(int idDisciplina, int idCurso, int idProcesso) {
        RespostaDAO rnd = new RespostaDAOImpl();
        TbResposta retorno = null;
        
        retorno = rnd.pesquisarProximaRespostaSegundaCorrecao(idDisciplina, idCurso, idProcesso);
        Session sessao = rnd.getSessao();
        Transaction t = sessao.getTransaction();
        
        //ATUALIZA FLAG DE CORRIGINDO.
        if(retorno!=null){
            retorno.setFlCorrigindo(true);
            rnd.atualizarFlag(retorno);
        }
        t.commit(); //libera sessão
        sessao.close();

        return retorno;
    }

    @Override
    public TbResposta pesquisarProximaRespostaPrimeiraCorrecao(int idDisciplina, int idCurso, int idProcesso) {
        RespostaDAO rnd = new RespostaDAOImpl();
        TbResposta retorno = null;
        
        retorno = rnd.pesquisarProximaRespostaPrimeiraCorrecao(idDisciplina, idCurso, idProcesso);
        Session sessao = rnd.getSessao();
        Transaction t = sessao.getTransaction();
        
        //ATUALIZA FLAG DE CORRIGINDO.
        if(retorno!=null){
            retorno.setFlCorrigindo(true);
            rnd.atualizarFlag(retorno);
        }
        t.commit(); //libera sessão
        sessao.close();

        return retorno;
    }

    @Override
    public List<TbResposta> pesquisarRespostasComErro() {
        RespostaDAO rnd = new RespostaDAOImpl();
        return rnd.pesquisarRespostasComErro();
    }

    @Override
    public int quantidadePrimeiraCorrecao(int idDisciplina, int idProcesso) {
        RespostaDAO rnd = new RespostaDAOImpl();
        TbDisciplina disc = new TbDisciplina(idDisciplina);TbProcesso proc = new TbProcesso(idProcesso);
        return rnd.quantidadePrimeiraCorrecao(disc,proc);
    }

    @Override
    public int quantidadeSegundaCorrecao(int idDisciplina, int idProcesso) {
        RespostaDAO rnd = new RespostaDAOImpl();
        TbDisciplina disc = new TbDisciplina(idDisciplina);TbProcesso proc = new TbProcesso(idProcesso);
        return rnd.quantidadeSegundaCorrecao(disc,proc);
    }

    @Override
    public int quantidadeDiscrepancia(int idDisciplina, int idProcesso) {
        RespostaDAO rnd = new RespostaDAOImpl();
        TbDisciplina disc = new TbDisciplina(idDisciplina);TbProcesso proc = new TbProcesso(idProcesso);
        return rnd.quantidadeDiscrepancia(disc,proc);
    }

    @Override
    public int quantidadeDiscrepanciaCorrigida(int idDisciplina, int idProcesso) {
        RespostaDAO rnd = new RespostaDAOImpl();
        TbDisciplina disc = new TbDisciplina(idDisciplina);TbProcesso proc = new TbProcesso(idProcesso);
        return rnd.quantidadeDiscrepanciaCorrigida(disc,proc);
    }

    @Override
    public int quantidadeRespostasSemErro() {
        RespostaDAO rnd = new RespostaDAOImpl();
        return rnd.quantidadeRespostasSemErro();
    }

    @Override
    public int quantidadeProvasPorDisciplinaProcesso(int idDisciplina, int idProcesso) {
        RespostaDAO rnd = new RespostaDAOImpl();
        return rnd.quantidadeProvasPorDisciplinaProcesso(idDisciplina, idProcesso);
    }

    
    @Override
    public TbResposta pesquisarProximaRespostaPrimeiraCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso,int idQuestao) {
        RespostaDAO rnd = new RespostaDAOImpl();
        TbResposta retorno = null;
        
        retorno = rnd.pesquisarProximaRespostaPrimeiraCorrecaoPorQuestao(idDisciplina, idCurso, idProcesso,idQuestao);
        Session sessao = rnd.getSessao();
        Transaction t = sessao.getTransaction();
        
        //ATUALIZA FLAG DE CORRIGINDO.
        if(retorno!=null){
            retorno.setFlCorrigindo(true);
            rnd.atualizarFlag(retorno);
        }
        t.commit(); //libera sessão
        sessao.close();

        return retorno;
    }

    @Override
    public TbResposta pesquisarProximaRespostaSegundaCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso,int idQuestao) {
        RespostaDAO rnd = new RespostaDAOImpl();
        TbResposta retorno = null;
        
        retorno = rnd.pesquisarProximaRespostaSegundaCorrecaoPorQuestao(idDisciplina, idCurso, idProcesso,idQuestao);
        Session sessao = rnd.getSessao();
        Transaction t = sessao.getTransaction();
        
        //ATUALIZA FLAG DE CORRIGINDO.
        if(retorno!=null){
            retorno.setFlCorrigindo(true);
            rnd.atualizarFlag(retorno);
        }
        t.commit(); //libera sessão
        sessao.close();

        return retorno;
    }

    
    @Override
    public TbResposta pesquisarProximaRespostaPrimeiraCorrecaoPorQuestaoComSegundaCorrecao(int idDisciplina, int idCurso, int idProcesso,int idQuestao) {
        RespostaDAO rnd = new RespostaDAOImpl();
        TbResposta retorno = null;
        
        retorno = rnd.pesquisarProximaRespostaPrimeiraCorrecaoPorQuestaoComSegundaCorrecao(idDisciplina, idCurso, idProcesso,idQuestao);
        Session sessao = rnd.getSessao();
        Transaction t = sessao.getTransaction();
        
        //ATUALIZA FLAG DE CORRIGINDO.
        if(retorno!=null){
            retorno.setFlCorrigindo(true);
            rnd.atualizarFlag(retorno);
        }
        t.commit(); //libera sessão
        sessao.close();

        return retorno;
    }

    @Override
    public TbResposta pesquisarProximaRespostaSegundaCorrecaoPorQuestaoComPrimeiraCorrecao(int idDisciplina, int idCurso, int idProcesso,int idQuestao) {
        RespostaDAO rnd = new RespostaDAOImpl();
        TbResposta retorno = null;
        
        retorno = rnd.pesquisarProximaRespostaSegundaCorrecaoPorQuestaoComPrimeiraCorrecao(idDisciplina, idCurso, idProcesso,idQuestao);
        Session sessao = rnd.getSessao();
        Transaction t = sessao.getTransaction();
        
        //ATUALIZA FLAG DE CORRIGINDO.
        if(retorno!=null){
            retorno.setFlCorrigindo(true);
            rnd.atualizarFlag(retorno);
        }
        t.commit(); //libera sessão
        sessao.close();

        return retorno;
    }

    @Override
    public TbResposta pesquisarProximaRespostaTerceiraCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso,int idQuestao) {
        RespostaDAO rnd = new RespostaDAOImpl();
        TbResposta retorno = null;
        
        retorno = rnd.pesquisarProximaRespostaTerceiraCorrecaoPorQuestao(idDisciplina, idCurso, idProcesso,idQuestao);
        Session sessao = rnd.getSessao();
        Transaction t = sessao.getTransaction();
        
        //ATUALIZA FLAG DE CORRIGINDO.
        if(retorno!=null){
            retorno.setFlCorrigindo(true);
            rnd.atualizarFlag(retorno);
        }
        t.commit(); //libera sessão
        sessao.close();

        return retorno;
    }
    
    
}
