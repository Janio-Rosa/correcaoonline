
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbCurso;

/**
 *
 * @author KAMYLLA
 */
public interface CursoService {
    
    public List<TbCurso> pesquisarTodos() ;
    public TbCurso inserir(TbCurso curso) ;
    public TbCurso atualizar(TbCurso curso) ;
    public boolean apagar(TbCurso curso) ;
    public TbCurso pesquisarPorID(int id) ;
    public List<TbCurso> pesquisarTodosOrdenado( ) ;
  
}