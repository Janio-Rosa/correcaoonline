package dao;

import java.util.List;
import model.VwPessoaUsuario;

/**
 *
 * @author KAMYLLA
 */
public interface VwPessoaUsuarioDAO {
    
    public List<VwPessoaUsuario> pesquisarTodos() ;
    public VwPessoaUsuario inserir(VwPessoaUsuario obj) ;
    public VwPessoaUsuario atualizar(VwPessoaUsuario obj) ;
    public boolean apagar(VwPessoaUsuario obj) ;
    public VwPessoaUsuario pesquisarPorID(int id) ;
    public List<VwPessoaUsuario> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwPessoaUsuario> pesquisarAtivos();
    
}
