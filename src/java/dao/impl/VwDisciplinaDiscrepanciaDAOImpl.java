/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwDisciplinaDiscrepanciaDAO;
import java.util.List;
import model.TbDisciplina;
import model.VwDisciplinaDiscrepancia;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */
public class VwDisciplinaDiscrepanciaDAOImpl extends GenericDAO<VwDisciplinaDiscrepancia> implements VwDisciplinaDiscrepanciaDAO{
    
     public VwDisciplinaDiscrepanciaDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwDisciplinaDiscrepancia.class);
    }
    
    @Override
    public List<VwDisciplinaDiscrepancia> pesquisarPorDisciplina(int disc) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        if(disc>0)
            criteria.add(Restrictions.eq("idDisciplina",disc));
        
        //Transaction t = this.getSessao().beginTransaction();
        List<VwDisciplinaDiscrepancia> lista = (List<VwDisciplinaDiscrepancia>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;
    }



}
