package dao.impl;

import dao.GenericDAO;
import dao.VwCorrecaoFeitaPorCursoDAO;
import java.util.List;
import model.VwCorrecaoFeitaPorCurso;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */
public class VwCorrecaoFeitaPorCursoDAOImpl extends GenericDAO<VwCorrecaoFeitaPorCurso> implements VwCorrecaoFeitaPorCursoDAO{
    
     public VwCorrecaoFeitaPorCursoDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwCorrecaoFeitaPorCurso.class);
    }
     
     
     @Override
    public List<VwCorrecaoFeitaPorCurso> pesquisarPorProcesso(int processo) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",processo));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwCorrecaoFeitaPorCurso> lista = (List<VwCorrecaoFeitaPorCurso>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }

    @Override
    public List<VwCorrecaoFeitaPorCurso> pesquisarPorProcessoDisciplina(int processo, int disciplina) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",processo));
        criteria.add(Restrictions.eq("idDisciplina",disciplina));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwCorrecaoFeitaPorCurso> lista = (List<VwCorrecaoFeitaPorCurso>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }
     
     
     
    
}

