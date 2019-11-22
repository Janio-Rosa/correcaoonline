/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwRespostaInscricaoDAO;
import java.util.List;
import model.VwRespostaInscricaoCorrecao;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author administrator
 */
public class VwRespostaInscricaoDAOImpl extends GenericDAO<VwRespostaInscricaoCorrecao> implements  VwRespostaInscricaoDAO {

    public VwRespostaInscricaoDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwRespostaInscricaoCorrecao.class);
    }
    
    @Override
    public List<VwRespostaInscricaoCorrecao> pesquisaPorInscricao(int nrInscricao ){
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("nrInscricao",nrInscricao));
        criteria.addOrder(Order.asc("nrQuestao"));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwRespostaInscricaoCorrecao> lista = (List<VwRespostaInscricaoCorrecao>) criteria.list();

        //t.commit();
        this.getSessao().close();
        
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }
    
    
    @Override
    public float notaTotalPorIdResposta(long idResposta) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idResposta",idResposta) );
        
        criteria.addOrder(Order.asc("idCategoriaCriterio"));

        ProjectionList pl = Projections.projectionList();
        //pl.add(Projections.property("idCategoriaCriterio"));
        //pl.add(Projections.groupProperty("idCategoriaCriterio"));
        pl.add(Projections.sum("nrNotaFinal"));
 
        criteria.setProjection(pl);

        //Transaction t = this.getSessao().beginTransaction();
        float resultado=0;
        
        try{
            resultado=((Float)criteria.list().get(0)).floatValue();
        }catch(Exception ex){}

        //t.commit();
        this.getSessao().close();
        return resultado;
    }

    @Override
    public List<VwRespostaInscricaoCorrecao> pesquisaPorCursoDisciplinaQuestao(int idCurso,int idDisciplina,int nrQuestao ){
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idCurso",idCurso));
        criteria.add(Restrictions.eq("idDisciplina",idDisciplina));
        criteria.add(Restrictions.eq("nrQuestao",nrQuestao));

        criteria.addOrder(Order.asc("flPrimeiraCorrecao"));
        criteria.addOrder(Order.asc("flSegundaCorrecao"));
        
        //Transaction t = this.getSessao().beginTransaction();
        List<VwRespostaInscricaoCorrecao> lista = (List<VwRespostaInscricaoCorrecao>) criteria.list();

        //t.commit();
        this.getSessao().close();
        
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }
    
}
