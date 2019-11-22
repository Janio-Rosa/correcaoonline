/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbUsuario;

/**
 *
 * @author Janio
 */
public interface UsuarioService {

    public List<TbUsuario> pesquisarTodos() ;
    public List<TbUsuario> pesquisarAtivos() ;
    public TbUsuario inserir(TbUsuario usuario) ;
    public TbUsuario atualizar(TbUsuario email) ;
    public boolean apagar(TbUsuario email) ;
    public TbUsuario pesquisarPorIDLong(long id) ;
    public TbUsuario pesquisarPorCpf(TbUsuario usuario);
    public List<TbUsuario> pesquisarTodosOrdenado( ) ;
    public TbUsuario login(TbUsuario filtro);
    public TbUsuario pesquisarPorUsuario(TbUsuario filtro);
}
