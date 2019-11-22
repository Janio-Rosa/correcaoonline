/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwProcessoCursoDAO;
import java.util.List;
import model.VwProcessoCurso;
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
public class VwProcessoCursoDAOImpl extends GenericDAO<VwProcessoCurso> implements VwProcessoCursoDAO { 

    public VwProcessoCursoDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwProcessoCurso.class);
    }
    
    @Override
    public List pesquisaPorProcesso(int idProcesso ) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",idProcesso));
        
        ProjectionList pl = Projections.projectionList();
        
        pl.add(Projections.property("idCurso"));
        pl.add(Projections.property("nmCurso"));

        pl.add(Projections.groupProperty("idCurso"));
        pl.add(Projections.groupProperty("nmCurso"));

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
