/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.PerfilFuncionalidadeDAO;
import dao.impl.PerfilFuncionalidadeDAOImpl;
import java.util.List;
import model.TbPerfilFuncionalidade;
import service.PerfilFuncionalidadeService;

/**
 *
 * @author KAMYLLA
 */
public class PerfilFuncionalidadeServiceImpl implements PerfilFuncionalidadeService {
    
     @Override
    public List<TbPerfilFuncionalidade> pesquisarTodos() {
        PerfilFuncionalidadeDAO dd =  new PerfilFuncionalidadeDAOImpl();
        return dd.pesquisarTodos();
    }

    @Override
    public TbPerfilFuncionalidade inserir(TbPerfilFuncionalidade nome) {
        PerfilFuncionalidadeDAO dd = new PerfilFuncionalidadeDAOImpl();
        return dd.inserir(nome);
    }

    @Override
    public TbPerfilFuncionalidade atualizar(TbPerfilFuncionalidade nome) {
        PerfilFuncionalidadeDAO dd =  new PerfilFuncionalidadeDAOImpl();
        return dd.atualizar(nome);
    }

    @Override
    public boolean apagar(TbPerfilFuncionalidade nome) {
        PerfilFuncionalidadeDAO dd =  new PerfilFuncionalidadeDAOImpl();
        return dd.apagar(nome);
    }

    @Override
    public TbPerfilFuncionalidade pesquisarPorID(int id) {
        PerfilFuncionalidadeDAO dd =  new PerfilFuncionalidadeDAOImpl();
        return dd.pesquisarPorID(id);
    }

   /* @Override
    public List<TbPerfilFuncionalidade> pesquisarTodosOrdenado() {
        PerfilFuncionalidadeDAO dd =  new PerfilFuncionalidadeDAOImpl();
        String[] criterios = {"nmPerfilFuncionalidade"};
        return dd.pesquisarTodosOrdenado(criterios);
    
    }*/

    @Override
    public TbPerfilFuncionalidade pesquisarPorPerfilEFuncionalidade(int idPerfil, int idFuncionalidade) {
         PerfilFuncionalidadeDAO dd =  new PerfilFuncionalidadeDAOImpl();
        return dd.pesquisarPorPerfilEFuncionalidade(idPerfil,idFuncionalidade);
   }

}