
package service.impl;
import java.util.List;
import model.VwPerfilFuncionalidade;
import dao.VwPerfilFuncionalidadeDAO;
import dao.impl.VwPerfilFuncionalidadeDAOImpl;
import service.VwPerfilFuncionalidadeService;

/**
 *
 * @author KAMYLLA
 */
public class VwPerfilFuncionalidadeServiceImpl implements VwPerfilFuncionalidadeService  {
    
   
    @Override
    public List<VwPerfilFuncionalidade> pesquisarTodos() {
        VwPerfilFuncionalidadeDAO rnd = new VwPerfilFuncionalidadeDAOImpl();
        return rnd.pesquisarTodos();
    }

   
    @Override
    public VwPerfilFuncionalidade inserir(VwPerfilFuncionalidade retornoNis) {
        VwPerfilFuncionalidadeDAO rnd = new VwPerfilFuncionalidadeDAOImpl();
        return rnd.inserir(retornoNis);
    }

   
    @Override
    public VwPerfilFuncionalidade atualizar(VwPerfilFuncionalidade retornoNis) {
        VwPerfilFuncionalidadeDAO rnd = new VwPerfilFuncionalidadeDAOImpl();
        return rnd.atualizar(retornoNis);
    }

   
    @Override
    public boolean apagar(VwPerfilFuncionalidade retornoNis) {
        VwPerfilFuncionalidadeDAO rnd = new VwPerfilFuncionalidadeDAOImpl();
        return rnd.apagar(retornoNis);
    }

 
    @Override
    public List<VwPerfilFuncionalidade> pesquisarTodosOrdenado() {
        VwPerfilFuncionalidadeDAO rnd = new VwPerfilFuncionalidadeDAOImpl();
        String[] criterios = {"nmPerfil","nmFuncionalidade"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }

    


    

}
