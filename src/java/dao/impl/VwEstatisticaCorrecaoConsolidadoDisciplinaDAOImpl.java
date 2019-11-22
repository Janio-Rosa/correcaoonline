package dao.impl;

import dao.GenericDAO;
import dao.VwEstatisticaCorrecaoConsolidadoDisciplinaDAO;
import java.util.List;
import model.VwEstatisticaCorrecaoConsolidadoDisciplina;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */
public class VwEstatisticaCorrecaoConsolidadoDisciplinaDAOImpl extends GenericDAO<VwEstatisticaCorrecaoConsolidadoDisciplina> implements VwEstatisticaCorrecaoConsolidadoDisciplinaDAO{
    
     public VwEstatisticaCorrecaoConsolidadoDisciplinaDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwEstatisticaCorrecaoConsolidadoDisciplina.class);
    }
     
     
     @Override
    public List<VwEstatisticaCorrecaoConsolidadoDisciplina> pesquisarPorProcesso(int processo) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",processo));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwEstatisticaCorrecaoConsolidadoDisciplina> lista = (List<VwEstatisticaCorrecaoConsolidadoDisciplina>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }

    @Override
    public List<VwEstatisticaCorrecaoConsolidadoDisciplina> pesquisarPorProcessoDisciplina(int processo, int disciplina) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",processo));
        criteria.add(Restrictions.eq("idDisciplina",disciplina));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwEstatisticaCorrecaoConsolidadoDisciplina> lista = (List<VwEstatisticaCorrecaoConsolidadoDisciplina>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }
     
     
     
    
}

