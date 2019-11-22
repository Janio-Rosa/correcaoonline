/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwRespostasComProblemaDAO;
import java.util.List;
import model.VwRespostasComProblema;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class VwRespostasComProblemaDAOImpl extends GenericDAO<VwRespostasComProblema> implements VwRespostasComProblemaDAO{
    
     public VwRespostasComProblemaDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwRespostasComProblema.class);
    }

    @Override
    public List<VwRespostasComProblema> pesquisarPorDisciplina(int idDisciplina  ) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("idDisciplina",idDisciplina));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwRespostasComProblema> lista = (List<VwRespostasComProblema>) criteria.list();
        //t.commit();this.getSessao().close();
        if(lista !=null && lista.size()>0)return lista;
        return null;
    }
     
}
