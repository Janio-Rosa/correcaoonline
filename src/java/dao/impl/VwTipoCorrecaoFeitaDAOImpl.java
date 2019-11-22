
package dao.impl;

import dao.GenericDAO;
import dao.VwTipoCorrecaoFeitaDAO;
import java.util.List;
import model.VwTipoCorrecaoFeita;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */
public class VwTipoCorrecaoFeitaDAOImpl extends GenericDAO<VwTipoCorrecaoFeita> implements VwTipoCorrecaoFeitaDAO{
    
     public VwTipoCorrecaoFeitaDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwTipoCorrecaoFeita.class);
    }
     
     
    @Override
    public List<VwTipoCorrecaoFeita> pesquisarPorProcessoEDisciplina(int processo, int disciplina) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",processo));
        criteria.add(Restrictions.eq("idDisciplina",disciplina));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwTipoCorrecaoFeita> lista = (List<VwTipoCorrecaoFeita>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }

    @Override
    public int pesquisarTotalPorProcessoEDisciplina(int processo, int disciplina) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",processo));
        criteria.add(Restrictions.eq("idDisciplina",disciplina));
        
        criteria.setProjection(Projections.sum("nrQuantidade") );
        
        //Transaction t = this.getSessao().beginTransaction();
        
        int result=0;
        
        try{
            result=((Integer)criteria.list().get(0)).intValue();
        }catch(Exception ex){}

        //t.commit();
        this.getSessao().close();
        
        return result;
    }
     
}

