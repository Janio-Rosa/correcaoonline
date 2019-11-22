/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbCorrecaoCriterio;
import model.TbCriterio;

/**
 *
 * @author Janio
 */
public interface CorrecaoCriterioService {
    public List<TbCorrecaoCriterio> pesquisarTodos() ;
    public TbCorrecaoCriterio inserir(TbCorrecaoCriterio correcaoCriterio) ;
    public TbCorrecaoCriterio atualizar(TbCorrecaoCriterio correcaoCriterio) ;
    public boolean apagar(TbCorrecaoCriterio correcaoCriterio) ;
    public TbCorrecaoCriterio pesquisarPorID(int id) ;
    public TbCorrecaoCriterio pesquisarPorIDLong(long idCorrecaoCriterio) ;
    public List<TbCorrecaoCriterio> pesquisarTodosOrdenado( ) ;
    public List<TbCorrecaoCriterio> pesquisarPorCorrecao(long idCorrecao) ;
    public TbCorrecaoCriterio pesquisarPorCorrecaoCriterio(long idCorrecao,TbCriterio idCriterio) ;
}
