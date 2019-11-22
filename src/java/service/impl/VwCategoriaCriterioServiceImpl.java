
package service.impl;
import java.util.List;
import model.VwCategoriaCriterio;
import dao.VwCategoriaCriterioDAO;
import dao.impl.VwCategoriaCriterioDAOImpl;
import service.VwCategoriaCriterioService;

/**
 *
 * @author Janio
 */
public class VwCategoriaCriterioServiceImpl implements VwCategoriaCriterioService  {
    
    @Override
    public List<VwCategoriaCriterio> pesquisarTodos() {
        VwCategoriaCriterioDAO rnd = new VwCategoriaCriterioDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public VwCategoriaCriterio inserir(VwCategoriaCriterio retornoNis) {
        VwCategoriaCriterioDAO rnd = new VwCategoriaCriterioDAOImpl();
        return rnd.inserir(retornoNis);
    }

    @Override
    public VwCategoriaCriterio atualizar(VwCategoriaCriterio retornoNis) {
        VwCategoriaCriterioDAO rnd = new VwCategoriaCriterioDAOImpl();
        return rnd.atualizar(retornoNis);
    }

    @Override
    public boolean apagar(VwCategoriaCriterio retornoNis) {
        VwCategoriaCriterioDAO rnd = new VwCategoriaCriterioDAOImpl();
        return rnd.apagar(retornoNis);
    }

    @Override
    public VwCategoriaCriterio pesquisarPorID(int id) {
        VwCategoriaCriterioDAO rnd = new VwCategoriaCriterioDAOImpl();
        return rnd.pesquisarPorID(id);
    }

    @Override
    public List<VwCategoriaCriterio> pesquisarTodosOrdenado() {
        VwCategoriaCriterioDAO rnd = new VwCategoriaCriterioDAOImpl();
        String[] criterios = {"nmCategoriaCriterio","nmCriterio"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }

    
   @Override
    public List<VwCategoriaCriterio> pesquisarPorCategoriaCriterio(int categoria) {
        VwCategoriaCriterioDAO rnd = new VwCategoriaCriterioDAOImpl();
        return rnd.pesquisarPorCategoriaCriterio(categoria);
    }
   
   @Override
   public List<VwCategoriaCriterio> pesquisarPorDisciplina(int idDisciplina){
       VwCategoriaCriterioDAO rnd = new VwCategoriaCriterioDAOImpl();
       return rnd.pesquisarPorDisciplina(idDisciplina);
   }
   
   @Override
   public List<VwCategoriaCriterio> pesquisarPorQuestao(String nmQuestao){
       VwCategoriaCriterioDAO rnd = new VwCategoriaCriterioDAOImpl();
       return rnd.pesquisarPorQuestao(nmQuestao);
   }

    @Override
    public List<VwCategoriaCriterio> pesquisarPorQuestaoDisciplinaCategoria(int idQuestao, int idDisciplina, int idCategoria) {
       VwCategoriaCriterioDAO rnd = new VwCategoriaCriterioDAOImpl();
       return rnd.pesquisarPorQuestaoDisciplinaCategoria(idQuestao,idDisciplina,idCategoria);
    }
    

}
