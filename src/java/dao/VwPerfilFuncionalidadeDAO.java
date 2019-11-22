package dao;

import java.util.List;
import model.VwPerfilFuncionalidade;

/**
 *
 * @author KAMYLLA
 */
public interface VwPerfilFuncionalidadeDAO {
    
    public List<VwPerfilFuncionalidade> pesquisarTodos() ;
    public VwPerfilFuncionalidade inserir(VwPerfilFuncionalidade obj) ;
    public VwPerfilFuncionalidade atualizar(VwPerfilFuncionalidade obj) ;
    public boolean apagar(VwPerfilFuncionalidade nome) ;
    public VwPerfilFuncionalidade pesquisarPorID(int id) ;
    public List<VwPerfilFuncionalidade> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    
}
