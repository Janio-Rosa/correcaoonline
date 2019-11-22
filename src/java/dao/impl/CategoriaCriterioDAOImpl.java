/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.CategoriaCriterioDAO;
import dao.GenericDAO;
import java.util.List;
import model.TbCategoriaCriterio;
import model.TbGeneroCategoria;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class CategoriaCriterioDAOImpl extends GenericDAO<TbCategoriaCriterio> implements CategoriaCriterioDAO {

    public CategoriaCriterioDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),TbCategoriaCriterio.class);
    }

    @Override
    public List<TbCategoriaCriterio> pesquisarPorErroPenalizacao(boolean ehErroPenalizacao) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("flErroPenalizacaoGeral",ehErroPenalizacao));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbCategoriaCriterio> lista = (List<TbCategoriaCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;
    }

    @Override
    public List<TbCategoriaCriterio> pesquisarPorGeneros(List<TbGeneroCategoria> generos,boolean ehErroPenalizacao) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.in("idGeneroCategoria", generos));
        criteria.add(Restrictions.eq("flErroPenalizacaoGeral",ehErroPenalizacao));
        criteria.add(Restrictions.eq("flAtivo",true));
        criteria.addOrder(Order.asc("nmCategoriaCriterio"));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbCategoriaCriterio> lista = (List<TbCategoriaCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;

    }

    @Override
    public List<TbCategoriaCriterio> pesquisarPorGenero(TbGeneroCategoria genero,boolean ehErroPenalizacao) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idGeneroCategoria", genero));
        criteria.add(Restrictions.eq("flErroPenalizacaoGeral",ehErroPenalizacao));
        criteria.add(Restrictions.eq("flAtivo",true));
        criteria.addOrder(Order.asc("nmCategoriaCriterio"));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbCategoriaCriterio> lista = (List<TbCategoriaCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;

    }
    
}
