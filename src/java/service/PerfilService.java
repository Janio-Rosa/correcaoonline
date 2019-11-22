
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbPerfil;

/**
 *
 * @author KAMYLLA
 */
public interface PerfilService {
    
    public List<TbPerfil> pesquisarTodos() ;
    public TbPerfil inserir(TbPerfil perfil) ;
    public TbPerfil atualizar(TbPerfil perfil) ;
    public boolean apagar(TbPerfil perfil) ;
    public TbPerfil pesquisarPorID(int id) ;
    public List<TbPerfil> pesquisarTodosOrdenado( ) ;
  
}