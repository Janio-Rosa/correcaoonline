package service.impl;

import dao.DisciplinaDiscrepanciaDAO;
import dao.impl.DisciplinaDiscrepanciaDAOImpl;
import java.util.List;
import model.TbDisciplina;
import model.TbDisciplinaDiscrepancia;
import model.TbQuestao;
import service.DisciplinaDiscrepanciaService;

/**
 *
 * @author KAMYLLA
 */
public class DisciplinaDiscrepanciaServiceImpl implements DisciplinaDiscrepanciaService {
    
     @Override
    public List<TbDisciplinaDiscrepancia> pesquisarTodos() {
        DisciplinaDiscrepanciaDAO dd =  new DisciplinaDiscrepanciaDAOImpl();
        return dd.pesquisarTodos();
    }

    @Override
    public TbDisciplinaDiscrepancia inserir(TbDisciplinaDiscrepancia nome) {
        DisciplinaDiscrepanciaDAO dd = new DisciplinaDiscrepanciaDAOImpl();
        return dd.inserir(nome);
    }

    @Override
    public TbDisciplinaDiscrepancia atualizar(TbDisciplinaDiscrepancia nome) {
        DisciplinaDiscrepanciaDAO dd =  new DisciplinaDiscrepanciaDAOImpl();
        return dd.atualizar(nome);
    }

    @Override
    public boolean apagar(TbDisciplinaDiscrepancia nome) {
        DisciplinaDiscrepanciaDAO dd =  new DisciplinaDiscrepanciaDAOImpl();
        return dd.apagar(nome);
    }

    @Override
    public TbDisciplinaDiscrepancia pesquisarPorID(int id) {
        DisciplinaDiscrepanciaDAO dd =  new DisciplinaDiscrepanciaDAOImpl();
        return dd.pesquisarPorID(id);
    }

    @Override
    public List<TbDisciplinaDiscrepancia> pesquisarTodosOrdenado() {
        DisciplinaDiscrepanciaDAO dd =  new DisciplinaDiscrepanciaDAOImpl();
        String[] criterios = {"idDisciplina","idQuestao"};
        return dd.pesquisarTodosOrdenado(criterios);
    }

    @Override
    public List<TbDisciplinaDiscrepancia> pesquisarPorDisciplinaEQuestao(TbDisciplina disc, TbQuestao questao) {
        DisciplinaDiscrepanciaDAO dd =  new DisciplinaDiscrepanciaDAOImpl();
        return dd.pesquisarPorDisciplinaEQuestao(disc, questao);
        
    }

    @Override
    public boolean verificaDiscrepanciaAtivada(int disc, int questao) {
        List<TbDisciplinaDiscrepancia> lista = this.pesquisarPorDisciplinaEQuestao(new TbDisciplina(disc), new TbQuestao(questao));
        if(lista!=null && !lista.isEmpty() && lista.size()>0){
            TbDisciplinaDiscrepancia procura = lista.get(0);
            if(procura!=null)return procura.getFlDiscrepanciaAtiva();
        }
        return false;
    }
    
}
    

