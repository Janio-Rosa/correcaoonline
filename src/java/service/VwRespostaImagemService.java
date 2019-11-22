/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.VwRespostaImagem;

/**
 *
 * @author administrator
 */
public interface VwRespostaImagemService {

    public List<VwRespostaImagem> pesquisarTodos() ;
    public VwRespostaImagem pesquisarPorIDLong(long id) ;
    public List<VwRespostaImagem> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwRespostaImagem> pesquisarPorIdResposta(long idResposta);
    

}
