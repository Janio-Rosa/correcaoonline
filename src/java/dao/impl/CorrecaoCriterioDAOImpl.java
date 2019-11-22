/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.CorrecaoCriterioDAO;
import dao.GenericDAO;
import java.util.List;
import model.TbCorrecao;
import model.TbCorrecaoCriterio;
import model.TbCriterio;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class CorrecaoCriterioDAOImpl extends GenericDAO<TbCorrecaoCriterio> implements  CorrecaoCriterioDAO {
    
    public CorrecaoCriterioDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),TbCorrecaoCriterio.class);
    }
    
    @Override
    public List<TbCorrecaoCriterio> pesquisarPorCorrecao(TbCorrecao idCorrecao) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idCorrecao",new TbCorrecao(idCorrecao.getIdCorrecao().longValue())));
        criteria.addOrder(Order.asc("nrLinha"));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbCorrecaoCriterio> lista = (List<TbCorrecaoCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;
    }

    @Override
    public TbCorrecaoCriterio pesquisarPorCorrecaoCriterio(TbCorrecao idCorrecao,TbCriterio idCriterio) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idCorrecao",idCorrecao));
        criteria.add(Restrictions.eq("idCriterio",idCriterio));
        criteria.addOrder(Order.asc("nrLinha"));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbCorrecaoCriterio> lista = (List<TbCorrecaoCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null && lista.size()>0)return lista.get(0);
        return null;
    }
    
}
