
package service.impl;
import java.util.List;
import model.VwUsuarioPerfil;
import dao.VwUsuarioPerfilDAO;
import dao.impl.VwUsuarioPerfilDAOImpl;
import service.VwUsuarioPerfilService;

/**
 *
 * @author KAMYLLA
 */
public class VwUsuarioPerfilServiceImpl implements VwUsuarioPerfilService  {
    
    @Override
    public List<VwUsuarioPerfil> pesquisarTodos() {
        VwUsuarioPerfilDAO rnd = new VwUsuarioPerfilDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public VwUsuarioPerfil inserir(VwUsuarioPerfil retornoNis) {
        VwUsuarioPerfilDAO rnd = new VwUsuarioPerfilDAOImpl();
        return rnd.inserir(retornoNis);
    }

    @Override
    public VwUsuarioPerfil atualizar(VwUsuarioPerfil retornoNis) {
        VwUsuarioPerfilDAO rnd = new VwUsuarioPerfilDAOImpl();
        return rnd.atualizar(retornoNis);
    }

    @Override
    public boolean apagar(VwUsuarioPerfil retornoNis) {
        VwUsuarioPerfilDAO rnd = new VwUsuarioPerfilDAOImpl();
        return rnd.apagar(retornoNis);
    }

  
    @Override
    public List<VwUsuarioPerfil> pesquisarTodosOrdenado() {
        VwUsuarioPerfilDAO rnd = new VwUsuarioPerfilDAOImpl();
        String[] criterios = {"nmUsuario","nmPerfil"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }

    
    // Esse metodo está errado
   @Override
    public List<VwUsuarioPerfil> pesquisarPorUsuarioPerfil(int categoria) {
        VwUsuarioPerfilDAO rnd = new VwUsuarioPerfilDAOImpl();
        return rnd.pesquisarTodos();
    }
    

}
