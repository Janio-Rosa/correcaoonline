/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbColaborador;
import model.TbCorrecao;
import model.TbResposta;
import model.TbTipoCorrecao;

/**
 *
 * @author Janio
 */
public interface CorrecaoDAO {

    public List<TbCorrecao> pesquisarTodos() ;
    public TbCorrecao inserir(TbCorrecao obj) ;
    public TbCorrecao atualizar(TbCorrecao obj) ;
    public boolean apagar(TbCorrecao email) ;
    public TbCorrecao pesquisarPorID(int id) ;
    public TbCorrecao pesquisarPorIDLong(long id) ;
    public List<TbCorrecao> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<TbCorrecao> pesquisarPorResposta(TbResposta resposta);
    public TbCorrecao pesquisarPorRespostaColaborador(TbResposta resposta,TbColaborador colaborador) ;
    public int quantidadePorColaborador(TbColaborador colaborador) ;
    public TbCorrecao pesquisarPorRespostaTipoCorrecao(TbResposta resposta, TbTipoCorrecao tipo);
    public TbCorrecao pesquisarPorRespostaColaborador(TbResposta resposta, TbColaborador colaborador,TbTipoCorrecao tipoCorrecao);
    public int quantidadePorColaboradorSemDiscrepancia(TbColaborador colaborador) ;
}
