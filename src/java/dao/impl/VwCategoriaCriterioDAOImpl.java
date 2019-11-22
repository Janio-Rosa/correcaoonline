/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwCategoriaCriterioDAO;
import java.util.List;
import model.VwCategoriaCriterio;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */
public class VwCategoriaCriterioDAOImpl extends GenericDAO<VwCategoriaCriterio> implements VwCategoriaCriterioDAO{
    
     public VwCategoriaCriterioDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwCategoriaCriterio.class);
    }
    
   
    @Override
    public List<VwCategoriaCriterio> pesquisarPorCategoriaCriterio(int categoria) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idCategoriaCriterio",categoria));
        //Transaction t = (Transaction) this.getSessao().beginTransaction();
        List<VwCategoriaCriterio> lista = (List<VwCategoriaCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista !=null && lista.size()>0) return lista;
        return null;
    }
    
     @Override
    public List<VwCategoriaCriterio> pesquisarPorDisciplina(int idDisciplina) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idDisciplina",idDisciplina));
        //Transaction t = (Transaction) this.getSessao().beginTransaction();
        List<VwCategoriaCriterio> lista = (List<VwCategoriaCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista !=null && lista.size()>0) return lista;
        return null;
    }
     
     
    @Override
    public List<VwCategoriaCriterio> pesquisarPorQuestao(String nmQuestao) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("nmQuestao",nmQuestao));
        //Transaction t = (Transaction) this.getSessao().beginTransaction();
        List<VwCategoriaCriterio> lista = (List<VwCategoriaCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista !=null && lista.size()>0) return lista;
        return null;
    }

    @Override
    public List<VwCategoriaCriterio> pesquisarPorQuestaoDisciplinaCategoria(int idQuestao,int idDisciplina,int idCategoria) {

        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        if(idQuestao>0)
            criteria.add(Restrictions.eq("idQuestao",idQuestao));
        if(idDisciplina>0)
            criteria.add(Restrictions.eq("idDisciplina",idDisciplina));
        if(idCategoria>0)
            criteria.add(Restrictions.eq("idCategoriaCriterio",idCategoria));
        //Transaction t = (Transaction) this.getSessao().beginTransaction();
        List<VwCategoriaCriterio> lista = (List<VwCategoriaCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista !=null && lista.size()>0) return lista;
        return null;
    }
     
    
    
}
