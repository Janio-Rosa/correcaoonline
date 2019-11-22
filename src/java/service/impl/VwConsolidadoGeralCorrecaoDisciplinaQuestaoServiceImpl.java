/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwConsolidadoGeralCorrecaoDisciplinaQuestaoDAO;
import dao.impl.VwConsolidadoGeralCorrecaoDisciplinaQuestaoDAOImpl;
import java.util.List;
import model.VwConsolidadoGeralCorrecaoDisciplinaQuestao;
import service.VwConsolidadoGeralCorrecaoDisciplinaQuestaoService;

/**
 *
 * @author Janio
 */
public class VwConsolidadoGeralCorrecaoDisciplinaQuestaoServiceImpl implements VwConsolidadoGeralCorrecaoDisciplinaQuestaoService  {
   
    @Override
    public List<VwConsolidadoGeralCorrecaoDisciplinaQuestao> pesquisarTodos() {
        VwConsolidadoGeralCorrecaoDisciplinaQuestaoDAO rnd = new VwConsolidadoGeralCorrecaoDisciplinaQuestaoDAOImpl();
        return rnd.pesquisarTodos();
    }
   
 
    @Override
    public List<VwConsolidadoGeralCorrecaoDisciplinaQuestao> pesquisarTodosOrdenado() {
        VwConsolidadoGeralCorrecaoDisciplinaQuestaoDAO rnd = new VwConsolidadoGeralCorrecaoDisciplinaQuestaoDAOImpl();
        String[] criterios = {"nmProcesso","nmDisciplina","nrQuestao"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }
    
    @Override
    public List<VwConsolidadoGeralCorrecaoDisciplinaQuestao> pesquisarPorProcesso(int processo){
        VwConsolidadoGeralCorrecaoDisciplinaQuestaoDAO rnd = new VwConsolidadoGeralCorrecaoDisciplinaQuestaoDAOImpl();
        return rnd.pesquisarPorProcesso(processo);
    }
    
    @Override
    public List<VwConsolidadoGeralCorrecaoDisciplinaQuestao> pesquisarPorProcessoeDisciplina(int processo, int disciplina){
        VwConsolidadoGeralCorrecaoDisciplinaQuestaoDAO rnd = new VwConsolidadoGeralCorrecaoDisciplinaQuestaoDAOImpl();
        return rnd.pesquisarPorProcessoeDisciplina(processo, disciplina);
    }
   
}
