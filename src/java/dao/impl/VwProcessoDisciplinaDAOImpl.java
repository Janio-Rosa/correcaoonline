/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwProcessoDisciplinaDAO;
import java.util.List;
import model.VwProcessoDisciplina;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class VwProcessoDisciplinaDAOImpl extends GenericDAO<VwProcessoDisciplina> implements VwProcessoDisciplinaDAO { 

    public VwProcessoDisciplinaDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwProcessoDisciplina.class);
    }
    
    @Override
    public List pesquisaPorProcesso(int idProcesso ) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",idProcesso));
        
        ProjectionList pl = Projections.projectionList();
        
        pl.add(Projections.property("idDisciplina"));
        pl.add(Projections.property("nmDisciplina"));

        pl.add(Projections.groupProperty("idDisciplina"));
        pl.add(Projections.groupProperty("nmDisciplina"));

        criteria.setProjection(pl);

        //Transaction t = this.getSessao().beginTransaction();
        List lista = criteria.list();
        //t.commit();
        
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }
    
}
