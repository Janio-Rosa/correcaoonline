/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbCorrecao;

/**
 *
 * @author Janio
 */
public interface CorrecaoService {
    
    public List<TbCorrecao> pesquisarTodos() ;
    public TbCorrecao inserir(TbCorrecao correcao) ;
    public TbCorrecao atualizar(TbCorrecao correcao) ;
    public boolean apagar(TbCorrecao correcao) ;
    public TbCorrecao pesquisarPorID(int id) ;
    public TbCorrecao pesquisarPorIDLong(long id) ;
    public List<TbCorrecao> pesquisarTodosOrdenado( ) ;
    public List<TbCorrecao> pesquisarPorResposta(long idResposta);
    public TbCorrecao pesquisarPorCorrecaoColaborador(long resposta,long colaborador) ;
    public int quantidadePorColaborador(long colaborador) ;
    public TbCorrecao pesquisarPorRespostaTipoCorrecao(long resposta, int tipo);
    public TbCorrecao pesquisarPorCorrecaoColaborador(long resposta, long colaborador,int idTipoCorrecao) ;
    public int quantidadePorColaboradorSemDiscrepancia(long colaborador) ;
}
