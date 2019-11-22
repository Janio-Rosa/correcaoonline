/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwBancaDisciplinaCursoDAO;
import java.util.List;
import model.VwBancaDisciplinaCurso;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class VwBancaDisciplinaCursoDAOImpl extends GenericDAO<VwBancaDisciplinaCurso> implements VwBancaDisciplinaCursoDAO{
    
     public VwBancaDisciplinaCursoDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwBancaDisciplinaCurso.class);
    }
    

    @Override
    public List<VwBancaDisciplinaCurso> pesquisarPorDisciplinaCurso(int idDisciplina,int idCurso) {

        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        if(idDisciplina>0)
            criteria.add(Restrictions.eq("idDisciplina",idDisciplina));
        if(idCurso>0)
            criteria.add(Restrictions.eq("idCurso",idCurso));
        //Transaction t = (Transaction) this.getSessao().beginTransaction();
        List<VwBancaDisciplinaCurso> lista = (List<VwBancaDisciplinaCurso>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista !=null && lista.size()>0) return lista;
        return null;
    }

    @Override
    public List<VwBancaDisciplinaCurso> pesquisarTodosOrdenadoPorProcesso(String[] atributoOrdenar, int idProcesso) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        if(idProcesso>0)
            criteria.add(Restrictions.eq("idProcesso",idProcesso));
        for(String atual : atributoOrdenar){
            criteria.addOrder(Order.asc(atual).ignoreCase());
        }
        //Transaction t = (Transaction) this.getSessao().beginTransaction();
        List<VwBancaDisciplinaCurso> lista = (List<VwBancaDisciplinaCurso>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista !=null && lista.size()>0) return lista;
        return null;
        
    }

}
