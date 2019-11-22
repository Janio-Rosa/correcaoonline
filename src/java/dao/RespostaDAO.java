/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbDisciplina;
import model.TbProcesso;
import model.TbResposta;
import org.hibernate.Session;

/**
 *
 * @author Janio
 */
public interface RespostaDAO {

    public List<TbResposta> pesquisarTodos() ;
    public TbResposta inserir(TbResposta obj) ;
    public TbResposta atualizar(TbResposta obj) ;
    public boolean apagar(TbResposta email) ;
    public TbResposta pesquisarPorID(int id) ;
    public TbResposta pesquisarPorIDLong(long id) ;
    public List<TbResposta> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public TbResposta pesquisarProximaResposta(int idDisciplina, int idCurso, int idProcesso);
    public Session getSessao();
    public TbResposta pesquisarRespostaPresaColaboradorAtual(long idColaborador) ;
    public TbResposta atualizarFlag(TbResposta resp) ;
    public TbResposta pesquisarPrimeiraResposta() ;
    public TbResposta pesquisarProximaRespostaDiscrepancia(int idDisciplina, int idCurso, int idProcesso);
    public TbResposta pesquisarProximaRespostaDiscrepancia(int idDisciplina, int idCurso, int idProcesso,int idQuestao);
    public TbResposta pesquisarProximaRespostaSegundaCorrecao(int idDisciplina, int idCurso, int idProcesso);
    public TbResposta pesquisarProximaRespostaPrimeiraCorrecao(int idDisciplina, int idCurso, int idProcesso);

    public List<TbResposta> pesquisarRespostasComErro();
    
    public int quantidadePrimeiraCorrecao(TbDisciplina idDisciplina,TbProcesso idProcesso) ;
    public int quantidadeSegundaCorrecao(TbDisciplina idDisciplina,TbProcesso idProcesso) ;
    public int quantidadeDiscrepancia(TbDisciplina idDisciplina,TbProcesso idProcesso) ;
    public int quantidadeDiscrepanciaCorrigida(TbDisciplina idDisciplina,TbProcesso idProcesso) ;

    public int quantidadeRespostasSemErro() ;
    
    public int quantidadeProvasPorDisciplinaProcesso(int idDisciplina, int idProcesso) ;
    
    public TbResposta pesquisarProximaRespostaPrimeiraCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao) ;
    public TbResposta pesquisarProximaRespostaSegundaCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso,int idQuestao) ;
    
    public TbResposta pesquisarProximaRespostaSegundaCorrecaoPorQuestaoComPrimeiraCorrecao(int idDisciplina, int idCurso, int idProcesso, int idQuestao);
    public TbResposta pesquisarProximaRespostaPrimeiraCorrecaoPorQuestaoComSegundaCorrecao(int idDisciplina, int idCurso, int idProcesso, int idQuestao);
    
    public TbResposta pesquisarProximaRespostaTerceiraCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao) ;
}
