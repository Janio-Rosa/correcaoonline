
package service.impl;
import java.util.List;
import model.VwPessoaUsuario;
import dao.VwPessoaUsuarioDAO;
import dao.impl.VwPessoaUsuarioDAOImpl;
import service.VwPessoaUsuarioService;

/**
 *
 * @author KAMYLLA
 */
public class VwPessoaUsuarioServiceImpl implements VwPessoaUsuarioService  {
    
   
    @Override
    public List<VwPessoaUsuario> pesquisarTodos() {
        VwPessoaUsuarioDAO rnd = new VwPessoaUsuarioDAOImpl();
        return rnd.pesquisarTodos();
    }

   
    @Override
    public VwPessoaUsuario inserir(VwPessoaUsuario retornoNis) {
        VwPessoaUsuarioDAO rnd = new VwPessoaUsuarioDAOImpl();
        return rnd.inserir(retornoNis);
    }

   
    @Override
    public VwPessoaUsuario atualizar(VwPessoaUsuario retornoNis) {
        VwPessoaUsuarioDAO rnd = new VwPessoaUsuarioDAOImpl();
        return rnd.atualizar(retornoNis);
    }

   
    @Override
    public boolean apagar(VwPessoaUsuario retornoNis) {
        VwPessoaUsuarioDAO rnd = new VwPessoaUsuarioDAOImpl();
        return rnd.apagar(retornoNis);
    }

 
    @Override
    public List<VwPessoaUsuario> pesquisarTodosOrdenado() {
        VwPessoaUsuarioDAO rnd = new VwPessoaUsuarioDAOImpl();
        String[] criterios = {"nmPessoa"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }

    
    @Override
    public List<VwPessoaUsuario> pesquisarAtivos() {
        VwPessoaUsuarioDAO rnd = new VwPessoaUsuarioDAOImpl();
        return rnd.pesquisarAtivos();
        
    }


    

}
