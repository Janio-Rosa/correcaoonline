package dao.impl;

import dao.GenericDAO;
import dao.VwConsolidadoGeralCorrecaoDAO;
import java.util.List;
import model.VwConsolidadoGeralCorrecao;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */
public class VwConsolidadoGeralCorrecaoDAOImpl extends GenericDAO<VwConsolidadoGeralCorrecao> implements VwConsolidadoGeralCorrecaoDAO{
    
     public VwConsolidadoGeralCorrecaoDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwConsolidadoGeralCorrecao.class);
    }
     
     
     @Override
    public List<VwConsolidadoGeralCorrecao> pesquisarPorProcesso(int processo) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",processo));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwConsolidadoGeralCorrecao> lista = (List<VwConsolidadoGeralCorrecao>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }
     
     @Override
    public List<VwConsolidadoGeralCorrecao> pesquisarPorProcessoeDisciplina(int processo, int disciplina) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        if(processo>0)
            criteria.add(Restrictions.eq("idProcesso",processo));

        if(disciplina>0)
            criteria.add(Restrictions.eq("idDisciplina", disciplina));

        //Transaction t = this.getSessao().beginTransaction();
        List<VwConsolidadoGeralCorrecao> lista = (List<VwConsolidadoGeralCorrecao>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }
    
}
