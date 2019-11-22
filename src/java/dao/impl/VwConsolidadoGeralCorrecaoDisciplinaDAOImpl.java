package dao.impl;

import dao.GenericDAO;
import dao.VwConsolidadoGeralCorrecaoDisciplinaDAO;
import java.util.List;
import model.VwConsolidadoGeralCorrecaoDisciplina;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */
public class VwConsolidadoGeralCorrecaoDisciplinaDAOImpl extends GenericDAO<VwConsolidadoGeralCorrecaoDisciplina> implements VwConsolidadoGeralCorrecaoDisciplinaDAO{
    
     public VwConsolidadoGeralCorrecaoDisciplinaDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwConsolidadoGeralCorrecaoDisciplina.class);
    }
     
     
     @Override
    public List<VwConsolidadoGeralCorrecaoDisciplina> pesquisarPorProcesso(int processo) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",processo));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwConsolidadoGeralCorrecaoDisciplina> lista = (List<VwConsolidadoGeralCorrecaoDisciplina>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }
     
     @Override
    public List<VwConsolidadoGeralCorrecaoDisciplina> pesquisarPorProcessoeDisciplina(int processo, int disciplina) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",processo));
        criteria.add(Restrictions.eq("idDisciplina", disciplina));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwConsolidadoGeralCorrecaoDisciplina> lista = (List<VwConsolidadoGeralCorrecaoDisciplina>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }
    
}
