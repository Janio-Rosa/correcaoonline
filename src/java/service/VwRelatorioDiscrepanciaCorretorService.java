/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.VwRelatorioDiscrepanciaCorretor;

/**
 *
 * @author Janio
 */
public interface VwRelatorioDiscrepanciaCorretorService {
 
    public List<VwRelatorioDiscrepanciaCorretor> pesquisarTodos() ;
    public VwRelatorioDiscrepanciaCorretor pesquisarPorID(int id) ;
    public List<VwRelatorioDiscrepanciaCorretor> pesquisarTodosOrdenado() ;
    public List<VwRelatorioDiscrepanciaCorretor> pesquisarPorProcessoDisciplina(int idProcesso,int idDIsciplina) ;

}
