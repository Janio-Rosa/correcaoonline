/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbUsuarioPerfil;

/**
 *
 * @author KAMYLLA
 */
public interface UsuarioPerfilDAO {

    public List<TbUsuarioPerfil> pesquisarTodos() ;
    public TbUsuarioPerfil inserir(TbUsuarioPerfil obj) ;
    public TbUsuarioPerfil atualizar(TbUsuarioPerfil obj) ;
    public boolean apagar(TbUsuarioPerfil obj) ;
    public TbUsuarioPerfil pesquisarPorID(int id) ;
    public List<TbUsuarioPerfil> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public TbUsuarioPerfil pesquisarPorPerfilEUsuario(int idPerfil, long idUsuario);
    
    public TbUsuarioPerfil pesquisarPorIDUsuario(long idUsuario) ;
    
}
