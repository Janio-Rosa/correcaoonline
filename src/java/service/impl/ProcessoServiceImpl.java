/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.ProcessoDAO;
import dao.impl.ProcessoDAOImpl;
import java.util.List;
import model.TbProcesso;
import service.ProcessoService;

/**
 *
 * @author Janio
 */
public class ProcessoServiceImpl implements ProcessoService {

    @Override
    public List<TbProcesso> pesquisarTodos() {
        ProcessoDAO pd = new ProcessoDAOImpl();
        return pd.pesquisarTodos();
    }

    @Override
    public TbProcesso inserir(TbProcesso email) {
        ProcessoDAO pd = new ProcessoDAOImpl();
        return pd.inserir(email);
    }

    @Override
    public TbProcesso atualizar(TbProcesso email) {
        ProcessoDAO pd = new ProcessoDAOImpl();
        return pd.atualizar(email);
    }

    @Override
    public boolean apagar(TbProcesso email) {
        ProcessoDAO pd = new ProcessoDAOImpl();
        return pd.apagar(email);
    }

    @Override
    public TbProcesso pesquisarPorID(int id) {
        ProcessoDAO pd = new ProcessoDAOImpl();
        return pd.pesquisarPorID(id);
    }

    @Override
    public List<TbProcesso> pesquisarTodosOrdenado() {
        ProcessoDAO pd = new ProcessoDAOImpl();
        String[] criterios = {"nmProcesso"};
        return pd.pesquisarTodosOrdenado(criterios);
    }

    @Override
    public List<TbProcesso> pesquisarTodosAtivos() {
        ProcessoDAO pd = new ProcessoDAOImpl();
        return pd.pesquisarTodosAtivos();
    }
    
}
