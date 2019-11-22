/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.ResumoCorrecaoCriterioDAO;
import java.util.List;
import model.TbResumoCorrecaoCriterio;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author administrator
 */
public class ResumoCorrecaoCriterioDAOImpl  extends GenericDAO<TbResumoCorrecaoCriterio> implements  ResumoCorrecaoCriterioDAO {

    public ResumoCorrecaoCriterioDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),TbResumoCorrecaoCriterio.class);
    }

    @Override
    public List<TbResumoCorrecaoCriterio> pesquisarPorIdCorrecao(long idCorrecao) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idCorrecao",idCorrecao));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbResumoCorrecaoCriterio> lista = (List<TbResumoCorrecaoCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;

    }

    @Override
    public TbResumoCorrecaoCriterio pesquisarPorIdCorrecaoIdCriterio(long idCorrecao, int idCriterio) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idCorrecao",idCorrecao));
        criteria.add(Restrictions.eq("idCriterio",idCriterio));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbResumoCorrecaoCriterio> lista = (List<TbResumoCorrecaoCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null && lista.size()>0)return lista.get(0);
        return null;
        
    }


}
