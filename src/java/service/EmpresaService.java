/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbEmpresa;

/**
 *
 * @author Janio
 */
public interface EmpresaService {

    public List<TbEmpresa> pesquisarTodos() ;
    public TbEmpresa inserir(TbEmpresa empresa) ;
    public TbEmpresa atualizar(TbEmpresa empresa) ;
    public boolean apagar(TbEmpresa empresa) ;
    public TbEmpresa pesquisarPorID(int id) ;
    public List<TbEmpresa> pesquisarTodosOrdenado( ) ;
   
}
