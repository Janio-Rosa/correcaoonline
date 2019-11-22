package service;

import java.util.List;
import model.VwCategoriaCriterio;

/**
 *
 * @author Janio
 */
public interface VwCategoriaCriterioService {
    
    public List<VwCategoriaCriterio> pesquisarTodos() ;
    public VwCategoriaCriterio inserir(VwCategoriaCriterio crit) ;
    public VwCategoriaCriterio atualizar(VwCategoriaCriterio crit) ;
    public boolean apagar(VwCategoriaCriterio crit) ;
    public VwCategoriaCriterio pesquisarPorID(int id) ;
    public List<VwCategoriaCriterio> pesquisarTodosOrdenado( ) ;
    public List<VwCategoriaCriterio> pesquisarPorCategoriaCriterio( int categoria ) ;
    public List<VwCategoriaCriterio> pesquisarPorDisciplina(int idDisciplina);
    public List<VwCategoriaCriterio> pesquisarPorQuestao(String nmQuestao);
    public List<VwCategoriaCriterio> pesquisarPorQuestaoDisciplinaCategoria(int idQuestao,int idDisciplina,int idCategoria);

}
