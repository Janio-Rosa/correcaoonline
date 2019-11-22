package service;

import java.util.List;
import model.VwPessoaColaborador;

/**
 *
 * @author KAMYLLA
 */
public interface VwPessoaColaboradorService {
    
    public List<VwPessoaColaborador> pesquisarTodos() ;
    public VwPessoaColaborador inserir(VwPessoaColaborador crit) ;
    public VwPessoaColaborador atualizar(VwPessoaColaborador crit) ;
    public boolean apagar(VwPessoaColaborador crit) ;
    public List<VwPessoaColaborador> pesquisarTodosOrdenado( ) ;
    public List<VwPessoaColaborador> pesquisarAtivosPorProcesso(int idProcesso);
    public List<VwPessoaColaborador> pesquisarAtivosPorCurso(int idCurso);
    public List<VwPessoaColaborador> pesquisarAtivosPorColaborador(int idColaborador);
    public List<VwPessoaColaborador> pesquisarPorPessoaCursoProcesso(String nrcpf ,int idCurso,int idProcesso);
    public List<VwPessoaColaborador> pesquisarPorPessoaCursoProcesso(String nrcpf ,int idCurso,int idProcesso,int idDisciplina);
}
