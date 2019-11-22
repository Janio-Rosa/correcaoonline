/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.VwCorretorDisciplinaProcesso;

/**
 *
 * @author janio
 */
public interface VwCorretorDisciplinaProcessoService {
    
    public List<VwCorretorDisciplinaProcesso> pesquisarTodos() ;
    public VwCorretorDisciplinaProcesso pesquisarPorID(int id) ;
    public List<VwCorretorDisciplinaProcesso> pesquisarTodosOrdenado() ;
    public List<VwCorretorDisciplinaProcesso> pesquisaPorProcessoDisciplina(int idDisciplina,int idProcesso );
    
}
