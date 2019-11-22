/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbResposta;
/**
 *
 * @author Janio
 */
public interface RespostaService {
    
    public List<TbResposta> pesquisarTodos() ;
    public TbResposta inserir(TbResposta resp) ;
    public TbResposta atualizar(TbResposta resp) ;
    public boolean apagar(TbResposta resp) ;
    public TbResposta pesquisarPorID(int id) ;
    public TbResposta pesquisarPorIDLong(long id) ;
    public List<TbResposta> pesquisarTodosOrdenado( ) ;
    public TbResposta pesquisarProximaResposta(int idDisciplina, int idCurso, int idProcesso) ;
    public TbResposta pesquisarRespostaPresaColaboradorAtual(long idColaborador) ;
    public TbResposta pesquisarPrimeiraResposta() ;
    public TbResposta pesquisarProximaRespostaDiscrepancia(int idDisciplina, int idCurso, int idProcesso);
    public TbResposta pesquisarProximaRespostaSegundaCorrecao(int idDisciplina, int idCurso, int idProcesso);
    public TbResposta pesquisarProximaRespostaPrimeiraCorrecao(int idDisciplina, int idCurso, int idProcesso);
    
    public List<TbResposta> pesquisarRespostasComErro() ;
    
    public int quantidadePrimeiraCorrecao(int idDisciplina,int idProcesso) ;
    public int quantidadeSegundaCorrecao(int idDisciplina,int idProcesso) ;
    public int quantidadeDiscrepancia(int idDisciplina,int idProcesso) ;
    public int quantidadeDiscrepanciaCorrigida(int idDisciplina,int idProcesso) ;

    public int quantidadeRespostasSemErro() ;
    
    public int quantidadeProvasPorDisciplinaProcesso(int idDisciplina, int idProcesso) ;
    
    public TbResposta pesquisarProximaRespostaPrimeiraCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao) ;
    public TbResposta pesquisarProximaRespostaSegundaCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso,int idQuestao) ;

    public TbResposta pesquisarProximaRespostaDiscrepancia(int idDisciplina, int idCurso, int idProcesso,int idQuestao);
    
    public TbResposta pesquisarProximaRespostaSegundaCorrecaoPorQuestaoComPrimeiraCorrecao(int idDisciplina, int idCurso, int idProcesso,int idQuestao) ;
    public TbResposta pesquisarProximaRespostaPrimeiraCorrecaoPorQuestaoComSegundaCorrecao(int idDisciplina, int idCurso, int idProcesso,int idQuestao) ;

    public TbResposta pesquisarProximaRespostaTerceiraCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao) ;
}
