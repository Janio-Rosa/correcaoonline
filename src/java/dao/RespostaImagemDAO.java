/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbResposta;
import model.TbRespostaImagem;
import org.hibernate.Session;

/**
 *
 * @author Janio
 */
public interface RespostaImagemDAO {

    public List<TbRespostaImagem> pesquisarTodos() ;
    public TbRespostaImagem inserir(TbRespostaImagem obj) ;
    public TbRespostaImagem atualizar(TbRespostaImagem obj) ;
    public boolean apagar(TbRespostaImagem email) ;
    public TbRespostaImagem pesquisarPorID(int id) ;
    public TbRespostaImagem pesquisarPorIDLong(long id) ;
    public List<TbRespostaImagem> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public TbRespostaImagem pesquisarProximaImagem();
    public Session getSessao();
    public TbRespostaImagem atualizarFlag(TbRespostaImagem resp) ;
    public TbRespostaImagem pesquisarProximaImagemEmBranco();
    public List<TbRespostaImagem> pesquisarPorIdResposta(TbResposta idResposta);

}
