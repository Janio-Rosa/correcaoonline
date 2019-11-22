/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbDisciplina;
import model.TbDisciplinaDiscrepancia;
import model.TbQuestao;

/**
 *
 * @author KAMYLLA
 */
public interface DisciplinaDiscrepanciaService {
    public List<TbDisciplinaDiscrepancia> pesquisarTodos() ;
    public TbDisciplinaDiscrepancia inserir(TbDisciplinaDiscrepancia nome) ;
    public TbDisciplinaDiscrepancia atualizar(TbDisciplinaDiscrepancia nome) ;
    public boolean apagar(TbDisciplinaDiscrepancia nome) ;
    public TbDisciplinaDiscrepancia pesquisarPorID(int id) ;
    public List<TbDisciplinaDiscrepancia> pesquisarTodosOrdenado( ) ;
    public List<TbDisciplinaDiscrepancia> pesquisarPorDisciplinaEQuestao(TbDisciplina disc,TbQuestao questao);
    public boolean verificaDiscrepanciaAtivada(int disc, int questao) ;
}
