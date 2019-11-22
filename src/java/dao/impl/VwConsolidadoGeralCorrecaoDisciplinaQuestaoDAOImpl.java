/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;
import dao.GenericDAO;
import dao.VwConsolidadoGeralCorrecaoDisciplinaQuestaoDAO;
import java.util.List;
import model.VwConsolidadoGeralCorrecaoDisciplinaQuestao;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class VwConsolidadoGeralCorrecaoDisciplinaQuestaoDAOImpl  extends GenericDAO<VwConsolidadoGeralCorrecaoDisciplinaQuestao> implements VwConsolidadoGeralCorrecaoDisciplinaQuestaoDAO {
    
     public VwConsolidadoGeralCorrecaoDisciplinaQuestaoDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwConsolidadoGeralCorrecaoDisciplinaQuestao.class);
    }
     
     
     @Override
    public List<VwConsolidadoGeralCorrecaoDisciplinaQuestao> pesquisarPorProcesso(int processo) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",processo));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwConsolidadoGeralCorrecaoDisciplinaQuestao> lista = (List<VwConsolidadoGeralCorrecaoDisciplinaQuestao>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }
     
     @Override
    public List<VwConsolidadoGeralCorrecaoDisciplinaQuestao> pesquisarPorProcessoeDisciplina(int processo, int disciplina) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        if(processo>0)
            criteria.add(Restrictions.eq("idProcesso",processo));

        if(disciplina>0)
            criteria.add(Restrictions.eq("idDisciplina", disciplina));

        criteria.addOrder(Order.asc("nmDisciplina"));
        criteria.addOrder(Order.asc("nrQuestao"));

        //Transaction t = this.getSessao().beginTransaction();
        List<VwConsolidadoGeralCorrecaoDisciplinaQuestao> lista = (List<VwConsolidadoGeralCorrecaoDisciplinaQuestao>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }
    
}
