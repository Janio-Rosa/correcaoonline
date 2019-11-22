/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.BancaDAO;
import dao.GenericDAO;
import java.util.List;
import model.TbBanca;
import model.TbCurso;
import model.TbDisciplina;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */
public class BancaDAOImpl extends GenericDAO<TbBanca> implements BancaDAO {
    
     public BancaDAOImpl() {
        super(HibernateUtil.getSessionFactory().openSession(),TbBanca.class);
        
    }
     
    @Override
    public List<TbBanca> pesquisarPorDisciplina(int idDisciplina) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idDisciplina",idDisciplina));
        //Transaction t = (Transaction) this.getSessao().beginTransaction();
        List<TbBanca> lista = (List<TbBanca>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista !=null && lista.size()>0) return lista;
        return null;
    }
    
    @Override
    public List<TbBanca> pesquisarPorCurso(int idCurso) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idCurso",idCurso));
        //Transaction t = (Transaction) this.getSessao().beginTransaction();
        List<TbBanca> lista = (List<TbBanca>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista !=null && lista.size()>0) return lista;
        return null;
    }
    
    
    @Override
    public List<TbBanca> pesquisarPorDisciplinaCurso(int idDisciplina,int idCurso) {

        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        if(idDisciplina>0)
            criteria.add(Restrictions.eq("idDisciplina",new TbDisciplina(idDisciplina)));
        if(idCurso>0)
            criteria.add(Restrictions.eq("idCurso",new TbCurso(idCurso)));
        //Transaction t = (Transaction) this.getSessao().beginTransaction();
        List<TbBanca> lista = (List<TbBanca>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista !=null && lista.size()>0) return lista;
        return null;
    }

    @Override
    public List<TbBanca> pesquisarTodosOrdenadoPorProcesso(String[] atributoOrdenar, int idProcesso) {

        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",idProcesso));
        for(String atual : atributoOrdenar){
            criteria.addOrder(Order.asc(atual).ignoreCase());
        }
        //Transaction t = (Transaction) this.getSessao().beginTransaction();
        List<TbBanca> lista = (List<TbBanca>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista !=null && lista.size()>0) return lista;
        return null;
    }
    
}
