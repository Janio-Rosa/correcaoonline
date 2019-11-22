package service.impl;
import java.util.List;
import model.VwTipoCorrecaoFeita;
import dao.VwTipoCorrecaoFeitaDAO;
import dao.impl.VwTipoCorrecaoFeitaDAOImpl;
import service.VwTipoCorrecaoFeitaService;

/**
 *
 * @author KAMYLLA
 */
public class VwTipoCorrecaoFeitaServiceImpl implements VwTipoCorrecaoFeitaService  {
    
   
    @Override
    public List<VwTipoCorrecaoFeita> pesquisarTodos() {
        VwTipoCorrecaoFeitaDAO rnd = new VwTipoCorrecaoFeitaDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public List<VwTipoCorrecaoFeita> pesquisarTodosOrdenado() {
        VwTipoCorrecaoFeitaDAO rnd = new VwTipoCorrecaoFeitaDAOImpl();
        String[] criterios = {"nmTipoCorrecao"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }
    
    @Override
    public List<VwTipoCorrecaoFeita> pesquisarPorProcessoEDisciplina(int processo, int disciplina){
        VwTipoCorrecaoFeitaDAO rnd = new VwTipoCorrecaoFeitaDAOImpl();
        return rnd.pesquisarPorProcessoEDisciplina(processo, disciplina);
    }

    @Override
    public int pesquisarTotalPorProcessoEDisciplina(int processo, int disciplina) {
        VwTipoCorrecaoFeitaDAO rnd = new VwTipoCorrecaoFeitaDAOImpl();
        return rnd.pesquisarTotalPorProcessoEDisciplina(processo, disciplina);
    }


}
