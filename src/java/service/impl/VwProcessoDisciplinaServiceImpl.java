/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwProcessoDisciplinaDAO;
import dao.impl.VwProcessoDisciplinaDAOImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.VwProcessoDisciplina;
import service.VwProcessoDisciplinaService;

/**
 *
 * @author Janio
 */
public class VwProcessoDisciplinaServiceImpl implements VwProcessoDisciplinaService {

    @Override
    public List<VwProcessoDisciplina> pesquisarTodos() {
        VwProcessoDisciplinaDAO xy = new VwProcessoDisciplinaDAOImpl();
        return xy.pesquisarTodos();
    }

    @Override
    public VwProcessoDisciplina pesquisarPorID(int id) {
        VwProcessoDisciplinaDAO xy = new VwProcessoDisciplinaDAOImpl();
        return xy.pesquisarPorID(id);
    }

    @Override
    public List<VwProcessoDisciplina> pesquisarTodosOrdenado() {
        VwProcessoDisciplinaDAO xy = new VwProcessoDisciplinaDAOImpl();
        String[] criterioOrdenar={"nmDisciplina"};
        return xy.pesquisarTodosOrdenado(criterioOrdenar);
    }

    @Override
    public List<VwProcessoDisciplina> pesquisaPorProcesso(int idProcesso) {
        VwProcessoDisciplinaDAO xy = new VwProcessoDisciplinaDAOImpl();
        List lista = xy.pesquisaPorProcesso(idProcesso);
        
        List<VwProcessoDisciplina> retorno = new ArrayList<VwProcessoDisciplina>();
        if(lista!=null && lista.size()>0){
            Iterator iterando = lista.iterator();
            while(iterando.hasNext()){
                Object[] obj = (Object[]) iterando.next();
                VwProcessoDisciplina atual = new VwProcessoDisciplina();
                for(int k=0;k<obj.length;k++){
                    try{
                        atual.setIdDisciplina(Integer.valueOf(""+ obj[k]));
                    }catch(NumberFormatException ex){
                        atual.setNmDisciplina(""+obj[k]);
                    }
                }
                retorno.add(atual);
            }
        }
        return retorno;
    }

}
