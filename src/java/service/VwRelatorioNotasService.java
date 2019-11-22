/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.VwRelatorioNotas;

/**
 *
 * @author janio
 */
public interface VwRelatorioNotasService {

    public List<VwRelatorioNotas> pesquisarTodos() ;
    public VwRelatorioNotas pesquisarPorID(int id) ;
    public List<VwRelatorioNotas> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwRelatorioNotas> pesquisarPorProcesso(int idProcesso) ;
    public List<VwRelatorioNotas> pesquisarPorProcessoDisciplina(int idProcesso,int idDIsciplina) ;
    public List<VwRelatorioNotas> pesquisarPorProcessoDisciplinaCurso(int idProcesso,int idDIsciplina, int idCurso) ;

}
