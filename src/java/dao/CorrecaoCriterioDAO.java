/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbCorrecao;
import model.TbCorrecaoCriterio;
import model.TbCriterio;

/**
 *
 * @author Janio
 */
public interface CorrecaoCriterioDAO {

    public List<TbCorrecaoCriterio> pesquisarTodos() ;
    public TbCorrecaoCriterio inserir(TbCorrecaoCriterio obj) ;
    public TbCorrecaoCriterio atualizar(TbCorrecaoCriterio obj) ;
    public boolean apagar(TbCorrecaoCriterio email) ;
    public TbCorrecaoCriterio pesquisarPorID(int id) ;
    public TbCorrecaoCriterio pesquisarPorIDLong(long id) ;
    public List<TbCorrecaoCriterio> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<TbCorrecaoCriterio> pesquisarPorCorrecao(TbCorrecao idCorrecao) ;
    public TbCorrecaoCriterio pesquisarPorCorrecaoCriterio(TbCorrecao idCorrecao,TbCriterio idCriterio) ;
}
