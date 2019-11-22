/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbPessoa;

/**
 *
 * @author KAMYLLA
 */
public interface PessoaDAO {
    
    public List<TbPessoa> pesquisarTodos() ;
    public TbPessoa inserir(TbPessoa obj) ;
    public TbPessoa atualizar(TbPessoa obj) ;
    public boolean apagar(TbPessoa nome) ;
    public TbPessoa pesquisarPorID(int id) ;
    public TbPessoa pesquisarPorCpf(TbPessoa pessoa);
    public List<TbPessoa> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    
}
