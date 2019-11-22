/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.VwRelatorioDiscrepanciaSintetico;

/**
 *
 * @author Janio
 */
public interface VwRelatorioDiscrepanciaSinteticoDAO {

    public List<VwRelatorioDiscrepanciaSintetico> pesquisarTodos() ;
    public VwRelatorioDiscrepanciaSintetico pesquisarPorID(int id) ;
    public List<VwRelatorioDiscrepanciaSintetico> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwRelatorioDiscrepanciaSintetico> pesquisarPorProcessoDisciplina(int idProcesso,int idDIsciplina) ;


}
