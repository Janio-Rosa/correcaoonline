/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbAtualizaResposta;

/**
 *
 * @author Janio
 */
public interface AtualizaRespostaService {

    public List<TbAtualizaResposta> pesquisarTodos() ;
    public TbAtualizaResposta inserir(TbAtualizaResposta obj) ;
    public TbAtualizaResposta atualizar(TbAtualizaResposta obj) ;
    public boolean apagar(TbAtualizaResposta email) ;
    public TbAtualizaResposta pesquisarPorID(long id) ;

}
