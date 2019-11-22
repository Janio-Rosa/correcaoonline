/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbCurso;

/**
 *
 * @author KAMYLLA
 */
public interface CursoDAO {
    public List<TbCurso> pesquisarTodos() ;
    public TbCurso inserir(TbCurso obj) ;
    public TbCurso atualizar(TbCurso obj) ;
    public boolean apagar(TbCurso email) ;
    public TbCurso pesquisarPorID(int id) ;
    public List<TbCurso> pesquisarTodosOrdenado(String[] atributoOrdenar) ;


}
