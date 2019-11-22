/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbCategoriaCriterio;
import model.TbGeneroCategoria;

/**
 *
 * @author Janio
 */
public interface CategoriaCriterioService {

    public List<TbCategoriaCriterio> pesquisarTodos() ;
    public TbCategoriaCriterio inserir(TbCategoriaCriterio categoriaCriterio) ;
    public TbCategoriaCriterio atualizar(TbCategoriaCriterio categoriaCriterio) ;
    public boolean apagar(TbCategoriaCriterio categoriaCriterio) ;
    public TbCategoriaCriterio pesquisarPorID(int id) ;
    public List<TbCategoriaCriterio> pesquisarTodosOrdenado( ) ;
    public List<TbCategoriaCriterio> pesquisarPorErroPenalizacao(boolean ehErroPenalizacao) ;
    public List<TbCategoriaCriterio> pesquisarPorGeneros(TbGeneroCategoria genero,boolean ehErroPenalizacao);
    public List<TbCategoriaCriterio> pesquisarPorGenero(TbGeneroCategoria genero,boolean ehErroPenalizacao);
    public List<TbCategoriaCriterio> pesquisarPorGenerosSemCatVazias(TbGeneroCategoria genero, boolean ehErroPenalizacao);
    
}
