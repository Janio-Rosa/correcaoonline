/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbBanca;
import model.TbCurso;

/**
 *
 * @author KAMYLLA
 */
public interface BancaDAO {
    
    public List<TbBanca> pesquisarTodos() ;
    public TbBanca inserir(TbBanca obj) ;
    public TbBanca atualizar(TbBanca obj) ;
    public boolean apagar(TbBanca nome) ;
    public TbBanca pesquisarPorID(int id) ;
    public List<TbBanca> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<TbBanca> pesquisarTodosOrdenadoPorProcesso(String[] atributoOrdenar,int idProcesso ) ;
    public List<TbBanca> pesquisarPorDisciplina(int idDisciplina);
    public List<TbBanca> pesquisarPorCurso(int idCurso);
    public List<TbBanca> pesquisarPorDisciplinaCurso(int idDisciplina,int idCurso);
    
}
