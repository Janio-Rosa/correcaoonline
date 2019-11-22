
package service.impl;
import java.util.List;
import model.VwPessoaColaborador;
import dao.VwPessoaColaboradorDAO;
import dao.impl.VwPessoaColaboradorDAOImpl;
import service.VwPessoaColaboradorService;

/**
 *
 * @author KAMYLLA
 */
public class VwPessoaColaboradorServiceImpl implements VwPessoaColaboradorService  {
    
   
    @Override
    public List<VwPessoaColaborador> pesquisarTodos() {
        VwPessoaColaboradorDAO rnd = new VwPessoaColaboradorDAOImpl();
        return rnd.pesquisarTodos();
    }

   
    @Override
    public VwPessoaColaborador inserir(VwPessoaColaborador retornoNis) {
        VwPessoaColaboradorDAO rnd = new VwPessoaColaboradorDAOImpl();
        return rnd.inserir(retornoNis);
    }

   
    @Override
    public VwPessoaColaborador atualizar(VwPessoaColaborador retornoNis) {
        VwPessoaColaboradorDAO rnd = new VwPessoaColaboradorDAOImpl();
        return rnd.atualizar(retornoNis);
    }

   
    @Override
    public boolean apagar(VwPessoaColaborador retornoNis) {
        VwPessoaColaboradorDAO rnd = new VwPessoaColaboradorDAOImpl();
        return rnd.apagar(retornoNis);
    }

 
    @Override
    public List<VwPessoaColaborador> pesquisarTodosOrdenado() {
        VwPessoaColaboradorDAO rnd = new VwPessoaColaboradorDAOImpl();
        String[] criterios = {"nmPessoa"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }

    @Override
    public List<VwPessoaColaborador> pesquisarAtivosPorProcesso(int idProcesso) {
        VwPessoaColaboradorDAO rnd = new VwPessoaColaboradorDAOImpl();
        return rnd.pesquisarAtivosPorProcesso(idProcesso);
    }
    
    @Override
    public List<VwPessoaColaborador> pesquisarAtivosPorColaborador(int idColaborador){
        VwPessoaColaboradorDAO rnd = new VwPessoaColaboradorDAOImpl();
        return rnd.pesquisarAtivosPorColaborador(idColaborador);
        
    }
    
    @Override
    public List<VwPessoaColaborador> pesquisarAtivosPorCurso(int idCurso){
        VwPessoaColaboradorDAO rnd = new VwPessoaColaboradorDAOImpl();
        return rnd.pesquisarAtivosPorCurso(idCurso);
        
    }
    
    @Override
    public List<VwPessoaColaborador> pesquisarPorPessoaCursoProcesso(String nrCpf,int idCurso,int idProcesso){
        VwPessoaColaboradorDAO rnd = new VwPessoaColaboradorDAOImpl();
        return rnd.pesquisarPorColaboradorCursoProcesso(nrCpf, idCurso, idProcesso);
        
    }

    @Override
    public List<VwPessoaColaborador> pesquisarPorPessoaCursoProcesso(String nrcpf, int idCurso, int idProcesso, int idDisciplina) {
        VwPessoaColaboradorDAO rnd = new VwPessoaColaboradorDAOImpl();
        return rnd.pesquisarPorColaboradorCursoProcesso(nrcpf, idCurso, idProcesso,idDisciplina);
    }
    
    

}
