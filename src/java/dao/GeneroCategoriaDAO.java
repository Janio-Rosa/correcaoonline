/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbGeneroCategoria;

/**
 *
 * @author Janio
 */
public interface GeneroCategoriaDAO {
    public List<TbGeneroCategoria> pesquisarTodos() ;
    public TbGeneroCategoria inserir(TbGeneroCategoria obj) ;
    public TbGeneroCategoria atualizar(TbGeneroCategoria obj) ;
    public boolean apagar(TbGeneroCategoria nome) ;
    public TbGeneroCategoria pesquisarPorID(int id) ;
    public List<TbGeneroCategoria> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<TbGeneroCategoria> pesquisarTodosSemGeral(String[] atributoOrdenar) ;
    public List<TbGeneroCategoria> pesquisarTodosSemGeralPorTipoQuestao(int tipoQuestao );
}
