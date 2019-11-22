
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbDisciplina;

/**
 *
 * @author KAMYLLA
 */
public interface DisciplinaService {
    
    public List<TbDisciplina> pesquisarTodos() ;
    public TbDisciplina inserir(TbDisciplina nome) ;
    public TbDisciplina atualizar(TbDisciplina nome) ;
    public boolean apagar(TbDisciplina nome) ;
    public TbDisciplina pesquisarPorID(int id) ;
    public List<TbDisciplina> pesquisarTodosOrdenado( ) ;
    public List<TbDisciplina> pesquisarTodosOrdenadasComResposta();
}