package dao;

import java.math.BigInteger;
import java.util.List;
import model.VwPessoaColaborador;

/**
 *
 * @author KAMYLLA
 */
public interface VwPessoaColaboradorDAO {
    
    public List<VwPessoaColaborador> pesquisarTodos() ;
    public VwPessoaColaborador inserir(VwPessoaColaborador obj) ;
    public VwPessoaColaborador atualizar(VwPessoaColaborador obj) ;
    public boolean apagar(VwPessoaColaborador obj) ;
    public VwPessoaColaborador pesquisarPorID(int id) ;
    public List<VwPessoaColaborador> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwPessoaColaborador> pesquisarAtivosPorProcesso(int idProcesso);
    public List<VwPessoaColaborador> pesquisarAtivosPorCurso(int idCurso);
    public List<VwPessoaColaborador> pesquisarAtivosPorColaborador(int idColaborador);
    public List<VwPessoaColaborador> pesquisarPorColaboradorCursoProcesso(String nrCpf,int idCurso,int idProcesso);
    public List<VwPessoaColaborador> pesquisarPorColaboradorCursoProcesso(String nrCpf,int idCurso,int idProcesso,int idDisciplina);
}
