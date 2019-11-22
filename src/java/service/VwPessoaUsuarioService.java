package service;

import java.util.List;
import model.VwPessoaUsuario;

/**
 *
 * @author KAMYLLA
 */
public interface VwPessoaUsuarioService {
    
    public List<VwPessoaUsuario> pesquisarTodos() ;
    public VwPessoaUsuario inserir(VwPessoaUsuario crit) ;
    public VwPessoaUsuario atualizar(VwPessoaUsuario crit) ;
    public boolean apagar(VwPessoaUsuario crit) ;
    public List<VwPessoaUsuario> pesquisarTodosOrdenado( ) ;
    public List<VwPessoaUsuario> pesquisarAtivos();

}
