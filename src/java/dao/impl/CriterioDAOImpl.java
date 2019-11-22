/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.CriterioDAO;
import dao.GenericDAO;
import java.util.List;
import model.TbCriterio;
import model.TbDisciplina;
import model.TbQuestao;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class CriterioDAOImpl  extends GenericDAO<TbCriterio> implements  CriterioDAO  {

    public CriterioDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),TbCriterio.class);
    }
    
    @Override
    public List<TbCriterio> pesquisarPorCategoriaCriterio(int categoria) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idCategoriaCriterio",categoria));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbCriterio> lista = (List<TbCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;
    }

    @Override
    public List<TbCriterio> pesquisarPorCategoriaCriterioEDisciplina(int categoria,TbDisciplina disc) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idCategoriaCriterio",categoria));
        criteria.add(Restrictions.eq("idDisciplina",disc));
        
        //Transaction t = this.getSessao().beginTransaction();
        List<TbCriterio> lista = (List<TbCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;
    }

    @Override
    public List<TbCriterio> pesquisarPorCategoriaCriterioEDisciplinaEQuestao(int categoria,TbDisciplina disc,TbQuestao questao) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idCategoriaCriterio",categoria));
        criteria.add(Restrictions.eq("idDisciplina",disc));
        criteria.add(Restrictions.eq("idQuestao",questao));
        criteria.add(Restrictions.eq("flAtivo",true)); //Buscar somente critérios ativos
        
        criteria.addOrder(Order.asc("nrOrdem"));
        
        //Transaction t = this.getSessao().beginTransaction();
        List<TbCriterio> lista = (List<TbCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;
    }

}
