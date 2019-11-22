/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.VwUsuarioFuncionalidade;

/**
 *
 * @author Janio
 */
public interface UsuarioXFuncionalidadeService {
    public List<VwUsuarioFuncionalidade> pesquisarTodos() ;
    public VwUsuarioFuncionalidade inserir(VwUsuarioFuncionalidade obj) ;
    public VwUsuarioFuncionalidade atualizar(VwUsuarioFuncionalidade obj) ;
    public boolean apagar(VwUsuarioFuncionalidade email) ;
    public VwUsuarioFuncionalidade pesquisarPorID(int id) ;
    public List<VwUsuarioFuncionalidade> pesquisarTodosOrdenado() ;
    
    public List<VwUsuarioFuncionalidade> getFuncionalidadesPorUsuario(String idUsuario );
    
    public List getFuncionalidadesPorUsuarioById(long idUsuario );
    
}
