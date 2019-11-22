/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbPessoa;

/**
 *
 * @author KAMYLLA
 */
public interface PessoaService {
    
    public List<TbPessoa> pesquisarTodos() ;
    public TbPessoa inserir(TbPessoa nome) ;
    public TbPessoa atualizar(TbPessoa nome) ;
    public boolean apagar(TbPessoa nome) ;
    public TbPessoa pesquisarPorID(int id) ;
    public TbPessoa pesquisarPorCpf(TbPessoa usuario);
    public List<TbPessoa> pesquisarTodosOrdenado( ) ;
    
}
