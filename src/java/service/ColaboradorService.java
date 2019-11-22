
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbColaborador;
import model.TbPessoa;
import model.TbProcesso;

/**
 *
 * @author KAMYLLA
 */
public interface ColaboradorService {
    
    public List<TbColaborador> pesquisarTodos() ;
    public TbColaborador inserir(TbColaborador nome) ;
    public TbColaborador atualizar(TbColaborador nome) ;
    public boolean apagar(TbColaborador nome) ;
    public TbColaborador pesquisarPorID(int id) ;
    public TbColaborador pesquisarPorIDLong(long id) ;
    public List<TbColaborador> pesquisarTodosOrdenado( ) ;
    public TbColaborador pesquisarPorCPF(String nrCpf);
    public TbColaborador pesquisarPorCPFeProcesso(TbPessoa procurarPessoa,TbProcesso procurarProcesso);
    public TbColaborador pesquisarAtivosPorProcesso(int idProcesso);   
    public TbColaborador pesquisarPorCPFAtivo(String nrCpf);
    public List<TbColaborador> pesquisarTodosPorCPF(String nrCpf,TbProcesso processo) ;

}