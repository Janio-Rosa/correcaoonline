/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbCriterio;
import model.TbDisciplina;
import model.TbQuestao;

/**
 *
 * @author Janio
 */
public interface CriterioDAO {
    public List<TbCriterio> pesquisarTodos() ;
    public TbCriterio inserir(TbCriterio obj) ;
    public TbCriterio atualizar(TbCriterio obj) ;
    public boolean apagar(TbCriterio email) ;
    public TbCriterio pesquisarPorID(int id) ;
    public List<TbCriterio> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<TbCriterio> pesquisarPorCategoriaCriterio(int categoria) ;
    public List<TbCriterio> pesquisarPorCategoriaCriterioEDisciplina(int categoria,TbDisciplina disc) ;
    public List<TbCriterio> pesquisarPorCategoriaCriterioEDisciplinaEQuestao(int categoria,TbDisciplina disc,TbQuestao questao) ;

}
