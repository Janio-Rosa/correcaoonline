/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbUsuario;

/**
 *
 * @author Janio
 */
public interface UsuarioDAO {

    public List<TbUsuario> pesquisarTodos() ;
    public List<TbUsuario> pesquisarAtivos() ;
    public TbUsuario inserir(TbUsuario obj) ;
    public TbUsuario atualizar(TbUsuario obj) ;
    public boolean apagar(TbUsuario email) ;
    public TbUsuario pesquisarPorIDLong(long id);
    public List<TbUsuario> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public TbUsuario pesquisarPorCpf(TbUsuario usuario);
    public TbUsuario pesquisarPorUsuario(TbUsuario usuario);
    public TbUsuario login(TbUsuario filtro);
    
}
