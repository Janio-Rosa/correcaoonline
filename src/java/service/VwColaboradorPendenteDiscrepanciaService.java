/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.VwColaboradorPendenteDiscrepancia;

/**
 *
 * @author Jânio
 */
public interface VwColaboradorPendenteDiscrepanciaService {
    
    public List<VwColaboradorPendenteDiscrepancia> pesquisarTodos() ;
    public VwColaboradorPendenteDiscrepancia pesquisarPorID(int id) ;
    public VwColaboradorPendenteDiscrepancia pesquisarPorIDLong(long id) ;
    public List<VwColaboradorPendenteDiscrepancia> pesquisarTodosOrdenado() ;
    public VwColaboradorPendenteDiscrepancia pesquisarPorCPF(String nrCpf);
    public VwColaboradorPendenteDiscrepancia pesquisarPorCPFeProcesso(String nrCpf,int idPessoa);
    public VwColaboradorPendenteDiscrepancia pesquisarAtivosPorProcesso(int idProcesso);
    public VwColaboradorPendenteDiscrepancia pesquisarPorCPFAtivo(String nrCpf) ;
    public VwColaboradorPendenteDiscrepancia pesquisarPorIDColaborador(long IdColaborador) ;
    public List<VwColaboradorPendenteDiscrepancia> pesquisarListaPorCPFAtivo(String nrCpf) ;

}
