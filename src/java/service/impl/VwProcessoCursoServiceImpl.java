/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwProcessoCursoDAO;
import dao.impl.VwProcessoCursoDAOImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.VwProcessoCurso;
import service.VwProcessoCursoService;

/**
 *
 * @author Janio
 */
public class VwProcessoCursoServiceImpl implements VwProcessoCursoService {

    @Override
    public List<VwProcessoCurso> pesquisarTodos() {
        VwProcessoCursoDAO xy = new VwProcessoCursoDAOImpl();
        return xy.pesquisarTodos();
    }

    @Override
    public VwProcessoCurso pesquisarPorID(int id) {
        VwProcessoCursoDAO xy = new VwProcessoCursoDAOImpl();
        return xy.pesquisarPorID(id);
    }

    @Override
    public List<VwProcessoCurso> pesquisarTodosOrdenado() {
        VwProcessoCursoDAO xy = new VwProcessoCursoDAOImpl();
        String[] criterioOrdenar={"nmCurso"};
        return xy.pesquisarTodosOrdenado(criterioOrdenar);
    }

    @Override
    public List<VwProcessoCurso> pesquisaPorProcesso(int idProcesso) {
        VwProcessoCursoDAO xy = new VwProcessoCursoDAOImpl();
        List lista = xy.pesquisaPorProcesso(idProcesso);
        
        List<VwProcessoCurso> retorno = new ArrayList<VwProcessoCurso>();
        if(lista!=null && lista.size()>0){
            Iterator iterando = lista.iterator();
            while(iterando.hasNext()){
                Object[] obj = (Object[]) iterando.next();
                VwProcessoCurso atual = new VwProcessoCurso();
                for(int k=0;k<obj.length;k++){
                    try{
                        atual.setIdCurso(Integer.valueOf(""+ obj[k]));
                    }catch(NumberFormatException ex){
                        atual.setNmCurso(""+obj[k]);
                    }
                }
                retorno.add(atual);
            }
        }
        return retorno;
    }

}
