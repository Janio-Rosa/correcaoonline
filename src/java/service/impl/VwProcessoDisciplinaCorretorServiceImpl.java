/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwProcessoDisciplinaCorretorDAO;
import dao.impl.VwProcessoDisciplinaCorretorDAOImpl;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.VwProcessoDisciplinaCorretor;
import service.VwProcessoDisciplinaCorretorService;

/**
 *
 * @author Janio
 */
public class VwProcessoDisciplinaCorretorServiceImpl implements VwProcessoDisciplinaCorretorService {

    @Override
    public List<VwProcessoDisciplinaCorretor> pesquisarTodos() {
        VwProcessoDisciplinaCorretorDAO vdcDAO = new VwProcessoDisciplinaCorretorDAOImpl();
        return vdcDAO.pesquisarTodos();
    }

    @Override
    public VwProcessoDisciplinaCorretor pesquisarPorID(int id) {
        VwProcessoDisciplinaCorretorDAO vdcDAO = new VwProcessoDisciplinaCorretorDAOImpl();
        return vdcDAO.pesquisarPorID(id);
    }

    @Override
    public List<VwProcessoDisciplinaCorretor> pesquisarTodosOrdenado() {
        VwProcessoDisciplinaCorretorDAO vdcDAO = new VwProcessoDisciplinaCorretorDAOImpl();
        String[] ordenar = {"nmPessoa"};
        return vdcDAO.pesquisarTodosOrdenado(ordenar);
    }

    @Override
    public List<VwProcessoDisciplinaCorretor> pesquisaPorProcessoDisciplina(int idDisciplina,int idProcesso) {
        VwProcessoDisciplinaCorretorDAO vdcDAO = new VwProcessoDisciplinaCorretorDAOImpl();
        List lista = vdcDAO.pesquisaPorProcessoDisciplina(idDisciplina,idProcesso);
        List<VwProcessoDisciplinaCorretor>  retorno = new ArrayList<VwProcessoDisciplinaCorretor> ();
        
        if(lista!=null && lista.size()>0){
            Iterator iterando = lista.iterator();
            while(iterando.hasNext()){
                Object[] obj = (Object[]) iterando.next();
                VwProcessoDisciplinaCorretor atual = new VwProcessoDisciplinaCorretor();
                for(int k=0;k<obj.length;k++){
                    try{
                        atual.setIdColaborador(BigInteger.valueOf(Long.valueOf(""+ obj[k])));
                    }catch(NumberFormatException ex){
                        atual.setNmPessoa(""+ obj[k]);
                    }
                }
                retorno.add(atual);
            }
        }
        return retorno;
    }
    
}
