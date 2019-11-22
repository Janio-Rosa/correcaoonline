package service;

import java.util.List;
import model.VwPerfilFuncionalidade;

/**
 *
 * @author KAMYLLA
 */
public interface VwPerfilFuncionalidadeService {
    
    public List<VwPerfilFuncionalidade> pesquisarTodos() ;
    public VwPerfilFuncionalidade inserir(VwPerfilFuncionalidade crit) ;
    public VwPerfilFuncionalidade atualizar(VwPerfilFuncionalidade crit) ;
    public boolean apagar(VwPerfilFuncionalidade crit) ;
    public List<VwPerfilFuncionalidade> pesquisarTodosOrdenado( ) ;

}
