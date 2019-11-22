/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwCriterioComCorrecaoCriterioDAO;
import java.math.BigInteger;
import java.util.List;
import model.VwCriterioComCorrecaoCriterio;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class VwCriterioComCorrecaoCriterioDAOImpl extends GenericDAO<VwCriterioComCorrecaoCriterio> implements VwCriterioComCorrecaoCriterioDAO{
    
     public VwCriterioComCorrecaoCriterioDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwCriterioComCorrecaoCriterio.class);
    }

    @Override
    public List<VwCriterioComCorrecaoCriterio> pesquisarPorCorrecao(long idCorrecao) {

        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idCorrecao",BigInteger.valueOf(idCorrecao)));
        //Transaction t = (Transaction) this.getSessao().beginTransaction();
        List<VwCriterioComCorrecaoCriterio> lista = (List<VwCriterioComCorrecaoCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        //if(lista !=null && !lista.isEmpty())return (VwCriterioComCorrecaoCriterio) lista.get(0);
        return lista;
    }
    
    @Override
    public List<VwCriterioComCorrecaoCriterio> pesquisarPorCategoriaCriterio(int categoria) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idCategoriaCriterio",categoria));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwCriterioComCorrecaoCriterio> lista = (List<VwCriterioComCorrecaoCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;
    }
    
    @Override
    public List<VwCriterioComCorrecaoCriterio> pesquisarPorCategoriaCriterioECorretor(int categoria,BigInteger corretor){
    
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idCategoriaCriterio",categoria));
        criteria.add(Restrictions.eq("idColaborador",corretor));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwCriterioComCorrecaoCriterio> lista = (List<VwCriterioComCorrecaoCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;
    }

    @Override
    public List<VwCriterioComCorrecaoCriterio> pesquisarPorCategoriaCriterioECorretorECorrecao(int categoria,BigInteger corretor,long idCorrecao){
    
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idCategoriaCriterio",categoria));
        criteria.add(Restrictions.eq("idColaborador",corretor));
        criteria.add(Restrictions.eq("idCorrecao",BigInteger.valueOf(idCorrecao)));
        
        //Transaction t = this.getSessao().beginTransaction();
        List<VwCriterioComCorrecaoCriterio> lista = (List<VwCriterioComCorrecaoCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;
    }
    
    
    
    @Override
    public List<VwCriterioComCorrecaoCriterio> pesquisarPorCorrecaoCriterio(long idCorrecao,int idCriterio) {

        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idCorrecao",BigInteger.valueOf(idCorrecao)));
        criteria.add(Restrictions.eq("idCriterio", idCriterio ));
        //Transaction t = (Transaction) this.getSessao().beginTransaction();
        List<VwCriterioComCorrecaoCriterio> lista = (List<VwCriterioComCorrecaoCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        //if(lista !=null && !lista.isEmpty())return (VwCriterioComCorrecaoCriterio) lista.get(0);
        return lista;
    }
    
    @Override
    public List pesquisarCategoriasPorCorrecao(long idCorrecao) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idCorrecao",BigInteger.valueOf(idCorrecao ) ));
        
        criteria.addOrder(Order.asc("idCategoriaCriterio"));

        ProjectionList pl = Projections.projectionList();
        pl.add(Projections.property("idCategoriaCriterio"));
        pl.add(Projections.sum("nrValor"));
        pl.add(Projections.groupProperty("idCategoriaCriterio"));
 
        criteria.setProjection(pl);

        //Transaction t = this.getSessao().beginTransaction();
        List  lista =  criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;
    }

    @Override
    public List<VwCriterioComCorrecaoCriterio> pesquisarCriteriosPorCorrecao(long idCorrecao) {

        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idCorrecao",BigInteger.valueOf(idCorrecao)));
        
        criteria.add(Restrictions.isNotNull("idCorrecaoCriterio"));
        
        //Transaction t = (Transaction) this.getSessao().beginTransaction();
        List<VwCriterioComCorrecaoCriterio> lista = (List<VwCriterioComCorrecaoCriterio>) criteria.list();
        //t.commit();
        this.getSessao().close();
        //if(lista !=null && !lista.isEmpty())return (VwCriterioComCorrecaoCriterio) lista.get(0);
        return lista;
    }
    
    
}
