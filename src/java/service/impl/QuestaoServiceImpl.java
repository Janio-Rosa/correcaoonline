/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.QuestaoDAO;
import dao.impl.QuestaoDAOImpl;
import java.util.List;
import model.TbQuestao;
import service.QuestaoService;

/**
 *
 * @author KAMYLLA
 */
public class QuestaoServiceImpl implements QuestaoService{
    
    @Override
    public List<TbQuestao> pesquisarTodos() {
        QuestaoDAO pd = new QuestaoDAOImpl();
        return pd.pesquisarTodos();
    }

    @Override
    public TbQuestao inserir(TbQuestao email) {
        QuestaoDAO pd = new QuestaoDAOImpl();
        return pd.inserir(email);
    }

    @Override
    public TbQuestao atualizar(TbQuestao email) {
        QuestaoDAO pd = new QuestaoDAOImpl();
        return pd.atualizar(email);
    }

    @Override
    public boolean apagar(TbQuestao email) {
        QuestaoDAO pd = new QuestaoDAOImpl();
        return pd.apagar(email);
    }

    @Override
    public TbQuestao pesquisarPorID(int id) {
        QuestaoDAO pd = new QuestaoDAOImpl();
        return pd.pesquisarPorID(id);
    }

    @Override
    public List<TbQuestao> pesquisarTodosOrdenado() {
        QuestaoDAO pd = new QuestaoDAOImpl();
        String[] criterios = {"nmQuestao"};
        return pd.pesquisarTodosOrdenado(criterios);
    }

    
    
}
