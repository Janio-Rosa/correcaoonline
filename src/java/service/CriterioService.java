/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbCriterio;

/**
 *
 * @author Janio
 */
public interface CriterioService {
    
    public List<TbCriterio> pesquisarTodos() ;
    public TbCriterio inserir(TbCriterio crit) ;
    public TbCriterio atualizar(TbCriterio crit) ;
    public boolean apagar(TbCriterio crit) ;
    public TbCriterio pesquisarPorID(int id) ;
    public List<TbCriterio> pesquisarTodosOrdenado( ) ;
    public List<TbCriterio> pesquisarPorCategoriaCriterio( int categoria ) ;
    public List<TbCriterio> pesquisarPorCategoriaCriterioEDisciplina(int categoria,int disc) ;
    public List<TbCriterio> pesquisarPorCategoriaCriterioEDisciplinaEQuestao(int categoria,int disc,int questao) ;

}
