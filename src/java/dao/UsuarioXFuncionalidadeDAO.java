/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.VwUsuarioFuncionalidade;

/**
 *
 * @author Janio
 */
public interface UsuarioXFuncionalidadeDAO {
    public List<VwUsuarioFuncionalidade> pesquisarTodos() ;
    public VwUsuarioFuncionalidade inserir(VwUsuarioFuncionalidade obj) ;
    public VwUsuarioFuncionalidade atualizar(VwUsuarioFuncionalidade obj) ;
    public boolean apagar(VwUsuarioFuncionalidade email) ;
    public VwUsuarioFuncionalidade pesquisarPorID(int id) ;
    public List<VwUsuarioFuncionalidade> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    
    public List<VwUsuarioFuncionalidade> getFuncionalidadesPorUsuario(String nmUsuario );
    public List<VwUsuarioFuncionalidade> getFuncionalidadesPorUsuarioById(long nmUsuario );
    
    
}
