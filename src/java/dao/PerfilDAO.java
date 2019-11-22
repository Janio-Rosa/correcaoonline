/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbPerfil;

/**
 *
 * @author Janio
 */
public interface PerfilDAO {

    public List<TbPerfil> pesquisarTodos() ;
    public TbPerfil inserir(TbPerfil obj) ;
    public TbPerfil atualizar(TbPerfil obj) ;
    public boolean apagar(TbPerfil email) ;
    public TbPerfil pesquisarPorID(int id) ;
    public List<TbPerfil> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    
}
