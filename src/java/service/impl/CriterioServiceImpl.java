/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;
import java.util.List;
import model.TbCriterio;
import dao.CriterioDAO;
import dao.impl.CriterioDAOImpl;
import model.TbDisciplina;
import model.TbQuestao;
import service.CriterioService;

/**
 *
 * @author Janio
 */
public class CriterioServiceImpl implements CriterioService  {
    @Override
    public List<TbCriterio> pesquisarTodos() {
        CriterioDAO rnd = new CriterioDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public TbCriterio inserir(TbCriterio retornoNis) {
        CriterioDAO rnd = new CriterioDAOImpl();
        return rnd.inserir(retornoNis);
    }

    @Override
    public TbCriterio atualizar(TbCriterio retornoNis) {
        CriterioDAO rnd = new CriterioDAOImpl();
        return rnd.atualizar(retornoNis);
    }

    @Override
    public boolean apagar(TbCriterio retornoNis) {
        CriterioDAO rnd = new CriterioDAOImpl();
        return rnd.apagar(retornoNis);
    }

    @Override
    public TbCriterio pesquisarPorID(int id) {
        CriterioDAO rnd = new CriterioDAOImpl();
        return rnd.pesquisarPorID(id);
    }

    @Override
    public List<TbCriterio> pesquisarTodosOrdenado() {
        CriterioDAO rnd = new CriterioDAOImpl();
        //String[] criterios = {"nmCategoriaCriterio","nmCriterio"};
        String[] criterios = {"nmCriterio"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }

    @Override
    public List<TbCriterio> pesquisarPorCategoriaCriterio(int categoria) {
        CriterioDAO rnd = new CriterioDAOImpl();
        return rnd.pesquisarPorCategoriaCriterio(categoria);
    }

    @Override
    public List<TbCriterio> pesquisarPorCategoriaCriterioEDisciplina(int categoria, int disc) {
        TbDisciplina tbDisc = (new DisciplinaServiceImpl()).pesquisarPorID(disc);
        CriterioDAO rnd = new CriterioDAOImpl();
        return rnd.pesquisarPorCategoriaCriterioEDisciplina(categoria,tbDisc);
        
    }

    @Override
    public List<TbCriterio> pesquisarPorCategoriaCriterioEDisciplinaEQuestao(int categoria, int disc,int questao) {
        TbDisciplina tbDisc = (new DisciplinaServiceImpl()).pesquisarPorID(disc);
        TbQuestao tbQuestao = (new QuestaoServiceImpl()).pesquisarPorID(questao);
        CriterioDAO rnd = new CriterioDAOImpl();
        return rnd.pesquisarPorCategoriaCriterioEDisciplinaEQuestao(categoria,tbDisc,tbQuestao);
        
    }
    

}
