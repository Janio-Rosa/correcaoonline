/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.VwRelatorioDiscrepanciaSintetico;

/**
 *
 * @author Janio
 */
public interface VwRelatorioDiscrepanciaSinteticoService {

    public List<VwRelatorioDiscrepanciaSintetico> pesquisarTodos() ;
    public VwRelatorioDiscrepanciaSintetico pesquisarPorID(int id) ;
    public List<VwRelatorioDiscrepanciaSintetico> pesquisarTodosOrdenado() ;
    public List<VwRelatorioDiscrepanciaSintetico> pesquisarPorProcessoDisciplina(int idProcesso,int idDIsciplina) ;

}
