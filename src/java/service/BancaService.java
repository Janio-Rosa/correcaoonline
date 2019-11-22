/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbBanca;


/**
 *
 * @author KAMYLLA
 */
public interface BancaService {
    
    public List<TbBanca> pesquisarTodos() ;
    public TbBanca inserir(TbBanca banca) ;
    public TbBanca atualizar(TbBanca banca) ;
    public boolean apagar(TbBanca banca) ;
    public TbBanca pesquisarPorID(int id) ;
    public List<TbBanca> pesquisarTodosOrdenado( ) ;
    public List<TbBanca> pesquisarTodosOrdenadoPorProcesso(int idProcesso ) ;
    public List<TbBanca> pesquisarPorDisciplina(int idDisciplina);
    public List<TbBanca> pesquisarPorCurso(int idCurso);
    public List<TbBanca> pesquisarPorDisciplinaCurso(int idDisciplina,int idCurso);
    
}
