package dao.impl;

import dao.GenericDAO;
import dao.VwEstatisticaCorrecaoTipoCorrecaoConsolidadoDAO;
import java.util.List;
import model.VwEstatisticaCorrecaoTipoCorrecaoConsolidado;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
//import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */
public class VwEstatisticaCorrecaoTipoCorrecaoConsolidadoDAOImpl extends GenericDAO<VwEstatisticaCorrecaoTipoCorrecaoConsolidado> implements VwEstatisticaCorrecaoTipoCorrecaoConsolidadoDAO{
    
     public VwEstatisticaCorrecaoTipoCorrecaoConsolidadoDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwEstatisticaCorrecaoTipoCorrecaoConsolidado.class);
    }
     
     
     @Override
    public List<VwEstatisticaCorrecaoTipoCorrecaoConsolidado> pesquisarPorProcesso(int processo) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",processo));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwEstatisticaCorrecaoTipoCorrecaoConsolidado> lista = (List<VwEstatisticaCorrecaoTipoCorrecaoConsolidado>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }
     
     @Override
    public List<VwEstatisticaCorrecaoTipoCorrecaoConsolidado> pesquisarPorProcessoeDisciplina(int processo, int disciplina) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",processo));
        criteria.add(Restrictions.eq("idDisciplina", disciplina));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwEstatisticaCorrecaoTipoCorrecaoConsolidado> lista = (List<VwEstatisticaCorrecaoTipoCorrecaoConsolidado>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }

   
}
