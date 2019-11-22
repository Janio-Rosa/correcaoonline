/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbDisciplina;

/**
 *
 * @author KAMYLLA
 */
public interface DisciplinaDAO {
    
    public List<TbDisciplina> pesquisarTodos() ;
    public TbDisciplina inserir(TbDisciplina obj) ;
    public TbDisciplina atualizar(TbDisciplina obj) ;
    public boolean apagar(TbDisciplina nome) ;
    public TbDisciplina pesquisarPorID(int id) ;
    public List<TbDisciplina> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<TbDisciplina> pesquisarTodosOrdenadasComResposta(String[] atributoOrdenar) ;
}
