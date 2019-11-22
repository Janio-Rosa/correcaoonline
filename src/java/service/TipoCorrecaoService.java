/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbTipoCorrecao;

/**
 *
 * @author Janio
 */
public interface TipoCorrecaoService {
    
    public List<TbTipoCorrecao> pesquisarTodos() ;
    public TbTipoCorrecao inserir(TbTipoCorrecao tipoCorrecao) ;
    public TbTipoCorrecao atualizar(TbTipoCorrecao tipoCorrecao) ;
    public boolean apagar(TbTipoCorrecao tipoCorrecao) ;
    public TbTipoCorrecao pesquisarPorID(int id) ;
    public List<TbTipoCorrecao> pesquisarTodosOrdenado( ) ;

}
