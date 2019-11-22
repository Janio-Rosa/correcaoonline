/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigInteger;
import java.util.List;
import model.VwCriterioComCorrecaoCriterio;

/**
 *
 * @author Janio
 */
public interface VwCriterioComCorrecaoCriterioDAO {

    public List<VwCriterioComCorrecaoCriterio> pesquisarTodos() ;
    public VwCriterioComCorrecaoCriterio inserir(VwCriterioComCorrecaoCriterio obj) ;
    public VwCriterioComCorrecaoCriterio atualizar(VwCriterioComCorrecaoCriterio obj) ;

    public VwCriterioComCorrecaoCriterio pesquisarPorID(int id) ;
    public List<VwCriterioComCorrecaoCriterio> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwCriterioComCorrecaoCriterio> pesquisarPorCorrecao(long idCorrecao);
    
    public List<VwCriterioComCorrecaoCriterio> pesquisarPorCategoriaCriterio(int categoria) ;
    
    public List<VwCriterioComCorrecaoCriterio> pesquisarPorCorrecaoCriterio(long idCorrecao,int idCriterio) ;
    
    public List<VwCriterioComCorrecaoCriterio> pesquisarPorCategoriaCriterioECorretor(int categoria,BigInteger corretor);
    
    public List<VwCriterioComCorrecaoCriterio> pesquisarPorCategoriaCriterioECorretorECorrecao(int categoria,BigInteger corretor,long idCorrecao);

    public List pesquisarCategoriasPorCorrecao(long idCorrecao) ;
    
    public List<VwCriterioComCorrecaoCriterio> pesquisarCriteriosPorCorrecao(long idCorrecao) ;
}
