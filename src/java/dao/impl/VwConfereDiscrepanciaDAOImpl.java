/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwConfereDiscrepanciaDAO;
import java.util.List;

import model.VwConfereDiscrepancia;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class VwConfereDiscrepanciaDAOImpl extends GenericDAO<VwConfereDiscrepancia> implements VwConfereDiscrepanciaDAO { 

    public VwConfereDiscrepanciaDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwConfereDiscrepancia.class);
    }

     @Override
    public List<VwConfereDiscrepancia> pesquisarPorDisciplinaCursoProcesso(int idDisciplina, int idCurso, int idProcesso) {
         
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
         criteria.add(Restrictions.eq("idProcesso", idProcesso));
        if(idDisciplina == 0){ 
            criteria.add(Restrictions.eq("idCurso",idCurso));
           
        }
        if(idCurso == 0){
            criteria.add(Restrictions.eq("idDisciplina",idDisciplina));
           
        }
        else{    
            criteria.add(Restrictions.eq("idDisciplina",idDisciplina));
            criteria.add(Restrictions.eq("idCurso",idCurso));
            
        }
        //Transaction t = (Transaction) this.getSessao().beginTransaction();
        List<VwConfereDiscrepancia> lista = (List<VwConfereDiscrepancia>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista !=null && lista.size()>0) return lista;
        return null;
    }
     
     @Override
    public List<VwConfereDiscrepancia> pesquisarPorDisciplina(int idDisciplina) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idDisciplina",idDisciplina));
        //Transaction t = (Transaction) this.getSessao().beginTransaction();
        List<VwConfereDiscrepancia> lista = (List<VwConfereDiscrepancia>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista !=null && lista.size()>0) return lista;
        return null;
    }
     
     @Override
    public List<VwConfereDiscrepancia> pesquisarPorCurso(int idCurso) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idCurso",idCurso));
        //Transaction t = (Transaction) this.getSessao().beginTransaction();
        List<VwConfereDiscrepancia> lista = (List<VwConfereDiscrepancia>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista !=null && lista.size()>0) return lista;
        return null;
    }
    
}
