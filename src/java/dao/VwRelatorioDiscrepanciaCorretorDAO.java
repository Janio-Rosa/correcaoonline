/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.VwRelatorioDiscrepanciaCorretor;

/**
 *
 * @author Janio
 */
public interface VwRelatorioDiscrepanciaCorretorDAO {

    public List<VwRelatorioDiscrepanciaCorretor> pesquisarTodos() ;
    public VwRelatorioDiscrepanciaCorretor pesquisarPorID(int id) ;
    public List<VwRelatorioDiscrepanciaCorretor> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwRelatorioDiscrepanciaCorretor> pesquisarPorProcessoDisciplina(int idProcesso,int idDIsciplina) ;
    
}
