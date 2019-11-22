package dao;

import java.util.List;
import model.VwUsuarioPerfil;

/**
 *
 * @author KAMYLLA
 */
public interface VwUsuarioPerfilDAO {
    
    public List<VwUsuarioPerfil> pesquisarTodos() ;
    public VwUsuarioPerfil inserir(VwUsuarioPerfil obj) ;
    public VwUsuarioPerfil atualizar(VwUsuarioPerfil obj) ;
    public boolean apagar(VwUsuarioPerfil obj) ;
    public List<VwUsuarioPerfil> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    
    
}
