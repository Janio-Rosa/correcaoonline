package dao;

import java.util.List;
import model.VwCategoriaCriterio;

/**
 *
 * @author KAMYLLA
 */
public interface VwCategoriaCriterioDAO {
    
    public List<VwCategoriaCriterio> pesquisarTodos() ;
    public VwCategoriaCriterio inserir(VwCategoriaCriterio obj) ;
    public VwCategoriaCriterio atualizar(VwCategoriaCriterio obj) ;
    public boolean apagar(VwCategoriaCriterio nome) ;
    public VwCategoriaCriterio pesquisarPorID(int id) ;
    public List<VwCategoriaCriterio> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public List<VwCategoriaCriterio> pesquisarPorCategoriaCriterio(int categoria);
    public List<VwCategoriaCriterio> pesquisarPorDisciplina(int idDisciplina);
    public List<VwCategoriaCriterio> pesquisarPorQuestao(String nmQuestao);
    public List<VwCategoriaCriterio> pesquisarPorQuestaoDisciplinaCategoria(int idQuestao,int idDisciplina,int idCategoria);
    
}
