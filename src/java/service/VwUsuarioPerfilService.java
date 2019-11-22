package service;

import java.util.List;
import model.VwUsuarioPerfil;

/**
 *
 * @author KAMYLLA
 */
public interface VwUsuarioPerfilService {
    
    public List<VwUsuarioPerfil> pesquisarTodos() ;
    public VwUsuarioPerfil inserir(VwUsuarioPerfil crit) ;
    public VwUsuarioPerfil atualizar(VwUsuarioPerfil crit) ;
    public boolean apagar(VwUsuarioPerfil crit) ;
    public List<VwUsuarioPerfil> pesquisarTodosOrdenado( ) ;
    public List<VwUsuarioPerfil> pesquisarPorUsuarioPerfil( int categoria ) ;

}
