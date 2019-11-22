/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbPerfilFuncionalidade;

/**
 *
 * @author Janio
 */
public interface PerfilFuncionalidadeDAO {

    public List<TbPerfilFuncionalidade> pesquisarTodos() ;
    public TbPerfilFuncionalidade inserir(TbPerfilFuncionalidade obj) ;
    public TbPerfilFuncionalidade atualizar(TbPerfilFuncionalidade obj) ;
    public boolean apagar(TbPerfilFuncionalidade email) ;
    public TbPerfilFuncionalidade pesquisarPorID(int id) ;
    public List<TbPerfilFuncionalidade> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public TbPerfilFuncionalidade pesquisarPorPerfilEFuncionalidade(int idPerfil,int idFuncionalidade) ;
    
}
