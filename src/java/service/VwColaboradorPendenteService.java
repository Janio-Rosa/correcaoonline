/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.VwColaboradorPendente;

/**
 *
 * @author Janio
 */
public interface VwColaboradorPendenteService {
    
    public List<VwColaboradorPendente> pesquisarTodos() ;
    public VwColaboradorPendente pesquisarPorID(int id) ;
    public VwColaboradorPendente pesquisarPorIDLong(long id) ;
    public List<VwColaboradorPendente> pesquisarTodosOrdenado() ;
    public VwColaboradorPendente pesquisarPorCPF(String nrCpf);
    public VwColaboradorPendente pesquisarPorCPFeProcesso(String nrCpf,int idPessoa);
    public VwColaboradorPendente pesquisarAtivosPorProcesso(int idProcesso);
    public VwColaboradorPendente pesquisarPorCPFAtivo(String nrCpf) ;
    public List<VwColaboradorPendente> pesquisarListaPorCPF(String nrCpf) ;

}
