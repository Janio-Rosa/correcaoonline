/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbTipoCorrecao;

/**
 *
 * @author Janio
 */
public interface TipoCorrecaoDAO {

    public List<TbTipoCorrecao> pesquisarTodos() ;
    public TbTipoCorrecao inserir(TbTipoCorrecao obj) ;
    public TbTipoCorrecao atualizar(TbTipoCorrecao obj) ;
    public boolean apagar(TbTipoCorrecao email) ;
    public TbTipoCorrecao pesquisarPorID(int id) ;
    public List<TbTipoCorrecao> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    
}
