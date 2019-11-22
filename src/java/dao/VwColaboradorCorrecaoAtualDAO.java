/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.VwColaboradorCorrecaoAtual;

/**
 *
 * @author Janio
 */
public interface VwColaboradorCorrecaoAtualDAO {

    public List<VwColaboradorCorrecaoAtual> pesquisarTodos() ;
    public VwColaboradorCorrecaoAtual pesquisarPorID(int id) ;
    public VwColaboradorCorrecaoAtual pesquisarPorIDLong(long id) ;
    public List<VwColaboradorCorrecaoAtual> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public VwColaboradorCorrecaoAtual pesquisarPorCPF(String nrCpf);
    public VwColaboradorCorrecaoAtual pesquisarPorCPFeProcesso(String nrCpf,int idPessoa);
    public VwColaboradorCorrecaoAtual pesquisarAtivosPorProcesso(int idProcesso);
    public VwColaboradorCorrecaoAtual pesquisarPorCPFAtivo(String nrCpf) ;
    
}
