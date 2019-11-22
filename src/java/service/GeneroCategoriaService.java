/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbGeneroCategoria;

/**
 *
 * @author Janio
 */
public interface GeneroCategoriaService {
    public List<TbGeneroCategoria> pesquisarTodos() ;
    public TbGeneroCategoria inserir(TbGeneroCategoria obj) ;
    public TbGeneroCategoria atualizar(TbGeneroCategoria obj) ;
    public boolean apagar(TbGeneroCategoria nome) ;
    public TbGeneroCategoria pesquisarPorID(int id) ;
    public List<TbGeneroCategoria> pesquisarTodosOrdenado() ;
    public List<TbGeneroCategoria> pesquisarTodosSemGeral() ;
    public List<TbGeneroCategoria> pesquisarTodosSemGeralPorTipoQuestao(int tipoQuestao );
}
