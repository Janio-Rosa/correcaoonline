/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbResumoCorrecaoCriterio;

/**
 *
 * @author administrator
 */
public interface ResumoCorrecaoCriterioService {
    public List<TbResumoCorrecaoCriterio> pesquisarTodos() ;
    public TbResumoCorrecaoCriterio inserir(TbResumoCorrecaoCriterio obj) ;
    public TbResumoCorrecaoCriterio atualizar(TbResumoCorrecaoCriterio obj) ;
    public boolean apagar(TbResumoCorrecaoCriterio email) ;
    public TbResumoCorrecaoCriterio pesquisarPorID(int id) ;
    public TbResumoCorrecaoCriterio pesquisarPorIDLong(long id) ;
    public List<TbResumoCorrecaoCriterio> pesquisarTodosOrdenado() ;
    public List<TbResumoCorrecaoCriterio> pesquisarPorIdCorrecao(long idCorrecao) ;
    public TbResumoCorrecaoCriterio pesquisarPorIdCorrecaoIdCriterio(long idCorrecao,int idCriterio) ;

}
