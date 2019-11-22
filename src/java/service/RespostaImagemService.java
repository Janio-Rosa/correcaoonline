/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.util.List;
import model.TbRespostaImagem;

/**
 *
 * @author Janio
 */
public interface RespostaImagemService {

    public List<TbRespostaImagem> pesquisarTodos() ;
    public TbRespostaImagem inserir(TbRespostaImagem obj) ;
    public TbRespostaImagem atualizar(TbRespostaImagem obj) ;
    public boolean apagar(TbRespostaImagem email) ;
    public TbRespostaImagem pesquisarPorID(int id) ;
    public TbRespostaImagem pesquisarPorIDLong(long id) ;
    public List<TbRespostaImagem> pesquisarTodosOrdenado() ;
    public TbRespostaImagem pesquisarProximaImagem();
    public TbRespostaImagem pesquisarProximaImagemEmBranco();
    public List<TbRespostaImagem> pesquisarPorIdResposta(long idResposta);
}
