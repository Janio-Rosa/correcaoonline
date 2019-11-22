/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.PessoaDAO;
import dao.impl.PessoaDAOImpl;
import java.util.List;
import model.TbPessoa;
import service.PessoaService;

/**
 *
 * @author KAMYLLA
 */
public class PessoaServiceImpl implements PessoaService{
    
    @Override
    public List<TbPessoa> pesquisarTodos() {
        PessoaDAO pd = new PessoaDAOImpl();
        return pd.pesquisarTodos();
    }

    @Override
    public TbPessoa inserir(TbPessoa nome) {
        PessoaDAO pd = new PessoaDAOImpl();
        return pd.inserir(nome);
    }

    @Override
    public TbPessoa atualizar(TbPessoa nome) {
        PessoaDAO pd = new PessoaDAOImpl();
        return pd.atualizar(nome);
    }

    @Override
    public boolean apagar(TbPessoa nome) {
        PessoaDAO pd = new PessoaDAOImpl();
        return pd.apagar(nome);
    }

    @Override
    public TbPessoa pesquisarPorID(int id) {
        PessoaDAO pd = new PessoaDAOImpl();
        return pd.pesquisarPorID(id);
    }

    @Override
    public List<TbPessoa> pesquisarTodosOrdenado() {
        PessoaDAO pd = new PessoaDAOImpl();
        String[] criterios = {"nmPessoa"};
        return pd.pesquisarTodosOrdenado(criterios);
    }
    
    @Override
    public TbPessoa pesquisarPorCpf(TbPessoa pessoa) {
        PessoaDAO rnd = new PessoaDAOImpl();
        return rnd.pesquisarPorCpf(pessoa);
}
    
}
