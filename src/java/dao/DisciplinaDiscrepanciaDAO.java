/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbDisciplina;
import model.TbDisciplinaDiscrepancia;
import model.TbQuestao;

/**
 *
 * @author KAMYLLA
 */
public interface DisciplinaDiscrepanciaDAO {
    
    public List<TbDisciplinaDiscrepancia> pesquisarTodos() ;
    public TbDisciplinaDiscrepancia inserir(TbDisciplinaDiscrepancia obj) ;
    public TbDisciplinaDiscrepancia atualizar(TbDisciplinaDiscrepancia obj) ;
    public boolean apagar(TbDisciplinaDiscrepancia nome) ;
    public TbDisciplinaDiscrepancia pesquisarPorID(int id) ;
    public List<TbDisciplinaDiscrepancia> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<TbDisciplinaDiscrepancia> pesquisarPorDisciplinaEQuestao(TbDisciplina disc,TbQuestao questao);
}
