
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbPerfilFuncionalidade;

/**
 *
 * @author KAMYLLA
 */
public interface PerfilFuncionalidadeService {
    
    public List<TbPerfilFuncionalidade> pesquisarTodos() ;
    public TbPerfilFuncionalidade inserir(TbPerfilFuncionalidade perfilFuncionalidade) ;
    public TbPerfilFuncionalidade atualizar(TbPerfilFuncionalidade perfilFuncionalidade) ;
    public boolean apagar(TbPerfilFuncionalidade perfilFuncionalidade) ;
    public TbPerfilFuncionalidade pesquisarPorID(int id) ;
    //public List<TbPerfilFuncionalidade> pesquisarTodosOrdenado( ) ;
    public TbPerfilFuncionalidade pesquisarPorPerfilEFuncionalidade(int idPerfil, int idFuncionalidade) ;
}