package dao.impl;

import dao.GenericDAO;
import dao.VwEstatisticaCriterioCorrecaoFeitaDAO;
import java.util.List;
import model.VwEstatisticaCriterioCorrecaoFeita;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */
public class VwEstatisticaCriterioCorrecaoFeitaDAOImpl extends GenericDAO<VwEstatisticaCriterioCorrecaoFeita> implements VwEstatisticaCriterioCorrecaoFeitaDAO{
    
     public VwEstatisticaCriterioCorrecaoFeitaDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwEstatisticaCriterioCorrecaoFeita.class);
    }
     
    @Override
    public List<VwEstatisticaCriterioCorrecaoFeita> pesquisarPorProcesso(int processo,String[] atributoOrdenar) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",processo));

        for(String atual : atributoOrdenar){
            criteria.addOrder(Order.asc(atual).ignoreCase());
        }
        
        //Transaction t = this.getSessao().beginTransaction();
        List<VwEstatisticaCriterioCorrecaoFeita> lista = (List<VwEstatisticaCriterioCorrecaoFeita>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }
    
    
    
   

}
