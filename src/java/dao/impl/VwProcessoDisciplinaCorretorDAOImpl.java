/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwProcessoDisciplinaCorretorDAO;
import java.util.List;
import model.VwProcessoDisciplinaCorretor;
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
public class VwProcessoDisciplinaCorretorDAOImpl  extends GenericDAO<VwProcessoDisciplinaCorretor> implements VwProcessoDisciplinaCorretorDAO { 

    public VwProcessoDisciplinaCorretorDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwProcessoDisciplinaCorretor.class);
    }

    @Override
    public List<VwProcessoDisciplinaCorretor> pesquisaPorProcessoDisciplina(int idDisciplina,int idProcesso ) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",idProcesso ));
        criteria.add(Restrictions.eq("idDisciplina",idDisciplina));
        
        ProjectionList pl = Projections.projectionList();
        
        pl.add(Projections.property("idColaborador"));
        pl.add(Projections.property("nmPessoa"));
        //pl.add(Projections.property("nrRg"));

        pl.add(Projections.groupProperty("idColaborador"));
        pl.add(Projections.groupProperty("nmPessoa"));
        //pl.add(Projections.groupProperty("nrRg"));

        criteria.setProjection(pl);

        //Transaction t = this.getSessao().beginTransaction();
        List<VwProcessoDisciplinaCorretor> lista = (List<VwProcessoDisciplinaCorretor>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }

}
