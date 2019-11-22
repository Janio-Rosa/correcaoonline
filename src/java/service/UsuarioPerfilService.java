
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbUsuarioPerfil;

/**
 *
 * @author KAMYLLA
 */
public interface UsuarioPerfilService {
    
    public List<TbUsuarioPerfil> pesquisarTodos() ;
    public TbUsuarioPerfil inserir(TbUsuarioPerfil UsuarioPerfil) ;
    public TbUsuarioPerfil atualizar(TbUsuarioPerfil UsuarioPerfil) ;
    public boolean apagar(TbUsuarioPerfil UsuarioPerfil) ;
    public TbUsuarioPerfil pesquisarPorID(int id) ;
    public List<TbUsuarioPerfil> pesquisarTodosOrdenado( ) ;
    public TbUsuarioPerfil pesquisarPorPerfilEUsuario(int idPerfil, long idUsuario);
  
    public TbUsuarioPerfil pesquisarPorIDUsuario(long idUsuario) ;
}