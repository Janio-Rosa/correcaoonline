/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbAtualizaResposta;
import org.hibernate.Session;
/**
 *
 * @author Janio
 */
public interface AtualizaRespostaDAO {

    public List<TbAtualizaResposta> pesquisarTodos() ;
    public TbAtualizaResposta inserir(TbAtualizaResposta obj) ;
    public TbAtualizaResposta atualizar(TbAtualizaResposta obj) ;
    public boolean apagar(TbAtualizaResposta email) ;
    public TbAtualizaResposta pesquisarPorID(int id) ;
    public TbAtualizaResposta pesquisarPorIDLong(long id);
    public Session getSessao();
    
}
