/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbEmpresa;

/**
 *
 * @author Janio
 */
public interface EmpresaDAO {

    public List<TbEmpresa> pesquisarTodos() ;
    public TbEmpresa inserir(TbEmpresa obj) ;
    public TbEmpresa atualizar(TbEmpresa obj) ;
    public boolean apagar(TbEmpresa email) ;
    public TbEmpresa pesquisarPorID(int id) ;
    public List<TbEmpresa> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    
}
