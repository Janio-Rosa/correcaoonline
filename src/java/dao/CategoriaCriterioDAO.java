/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbCategoriaCriterio;
import model.TbGeneroCategoria;

/**
 *
 * @author Janio
 */
public interface CategoriaCriterioDAO {

    public List<TbCategoriaCriterio> pesquisarTodos() ;
    public TbCategoriaCriterio inserir(TbCategoriaCriterio obj) ;
    public TbCategoriaCriterio atualizar(TbCategoriaCriterio obj) ;
    public boolean apagar(TbCategoriaCriterio email) ;
    public TbCategoriaCriterio pesquisarPorID(int id) ;
    public List<TbCategoriaCriterio> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<TbCategoriaCriterio> pesquisarPorErroPenalizacao(boolean ehErroPenalizacao) ;
    public List<TbCategoriaCriterio> pesquisarPorGeneros(List<TbGeneroCategoria> generos,boolean ehErroPenalizacao);
    public List<TbCategoriaCriterio> pesquisarPorGenero(TbGeneroCategoria pesquisar,boolean ehErroPenalizacao);
}
