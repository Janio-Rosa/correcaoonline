/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbCategoriaCriterioComPerda;
import model.VwCriterioComCorrecaoCriterio;

/**
 *
 * @author Janio
 */
public interface VwCriterioComCorrecaoCriterioService {
    
    public List<VwCriterioComCorrecaoCriterio> pesquisarTodos() ;
    public VwCriterioComCorrecaoCriterio pesquisarPorID(int id) ;
    public List<VwCriterioComCorrecaoCriterio> pesquisarTodosOrdenado() ;
    public List<VwCriterioComCorrecaoCriterio> pesquisarPorCorrecao(long idCorrecao);

    public List<VwCriterioComCorrecaoCriterio> pesquisarPorCategoriaCriterio(int categoria) ;
    
    
    public VwCriterioComCorrecaoCriterio pesquisarPorCorrecaoCriterio(long idCorrecao,int idCriterio) ;
    
    public List<VwCriterioComCorrecaoCriterio> pesquisarPorCategoriaCriterioECorretor(int categoria,long corretor);
    
    public List<VwCriterioComCorrecaoCriterio> pesquisarPorCategoriaCriterioECorretorECorrecao(int categoria,long corretor,long idCorrecao);
    
    public List<TbCategoriaCriterioComPerda> pesquisarCategoriasPorCorrecao(long idCorrecao) ;
    
    public List<VwCriterioComCorrecaoCriterio> pesquisarCriteriosPorCorrecao(long idCorrecao) ;

}
