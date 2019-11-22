/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.VwCorretorDisciplinaProcesso;

/**
 *
 * @author janio
 */
public interface VwCorretorDisciplinaProcessoDAO {

    public List<VwCorretorDisciplinaProcesso> pesquisarTodos() ;
    public VwCorretorDisciplinaProcesso pesquisarPorID(int id) ;
    public List<VwCorretorDisciplinaProcesso> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwCorretorDisciplinaProcesso> pesquisaPorProcessoDisciplina(int idDisciplina,int idProcesso ) ;

}
