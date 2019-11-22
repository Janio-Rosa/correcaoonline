/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.ResumoCorrecaoDAO;
import java.util.List;
import model.TbResumoCorrecao;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author administrator
 */
public class ResumoCorrecaoDAOImpl extends GenericDAO<TbResumoCorrecao> implements  ResumoCorrecaoDAO {

    public ResumoCorrecaoDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),TbResumoCorrecao.class);
    }
    
    @Override
    public List<TbResumoCorrecao> pesquisarPorIdResposta(long idResposta) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idResposta",idResposta));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbResumoCorrecao> lista = (List<TbResumoCorrecao>) criteria.list();

        //t.commit();
        this.getSessao().close();
        return lista;
        
    }

    @Override
    public TbResumoCorrecao pesquisarPorRespostaColaborador(long idResposta, long colaborador) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idResposta",idResposta));
        criteria.add(Restrictions.eq("idColaborador",colaborador));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbResumoCorrecao> lista = (List<TbResumoCorrecao>) criteria.list();
        
        //t.commit();
        this.getSessao().close();
        if(lista==null || lista.isEmpty())return null;
        return lista.get(0);

    }

    @Override
    public TbResumoCorrecao pesquisarPorRespostaTipoCorrecao(long idResposta, int tipo) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idResposta",idResposta));
        criteria.add(Restrictions.eq("idTipoCorrecao",tipo));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbResumoCorrecao> lista = (List<TbResumoCorrecao>) criteria.list();
        
        //t.commit();
        this.getSessao().close();
        if(lista==null || lista.isEmpty())return null;
        return lista.get(0);

    }

    @Override
    public TbResumoCorrecao pesquisarPorRespostaColaborador(long idResposta, long colaborador, int tipoCorrecao) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idResposta",idResposta));
        criteria.add(Restrictions.eq("idColaborador",colaborador));
        criteria.add(Restrictions.eq("idTipoCorrecao",tipoCorrecao));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbResumoCorrecao> lista = (List<TbResumoCorrecao>) criteria.list();
        
        //t.commit();
        this.getSessao().close();
        if(lista==null || lista.isEmpty())return null;
        return lista.get(0);

    }
    
}
