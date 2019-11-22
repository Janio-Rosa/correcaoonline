/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.CorrecaoDAO;
import dao.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import model.TbColaborador;
import model.TbCorrecao;
import model.TbResposta;
import model.TbTipoCorrecao;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class CorrecaoDAOImpl extends GenericDAO<TbCorrecao> implements  CorrecaoDAO {

    public CorrecaoDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),TbCorrecao.class);
    }

    @Override
    public List<TbCorrecao> pesquisarPorResposta(TbResposta resposta) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idResposta",resposta));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbCorrecao> lista = (List<TbCorrecao>) criteria.list();

        //t.commit();
        this.getSessao().close();
        return lista;
    }

    @Override
    public TbCorrecao pesquisarPorRespostaColaborador(TbResposta resposta, TbColaborador colaborador) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idResposta",resposta));
        criteria.add(Restrictions.eq("idColaborador",colaborador));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbCorrecao> lista = (List<TbCorrecao>) criteria.list();
        
        //t.commit();
        this.getSessao().close();
        if(lista==null || lista.isEmpty())return null;
        return lista.get(0);
    }

    @Override
    public TbCorrecao pesquisarPorRespostaColaborador(TbResposta resposta, TbColaborador colaborador,TbTipoCorrecao tipoCorrecao) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idResposta",resposta));
        criteria.add(Restrictions.eq("idColaborador",colaborador));
        criteria.add(Restrictions.eq("idTipoCorrecao",tipoCorrecao));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbCorrecao> lista = (List<TbCorrecao>) criteria.list();
        
        //t.commit();
        this.getSessao().close();
        if(lista==null || lista.isEmpty())return null;
        return lista.get(0);
    }

    @Override
    public int quantidadePorColaborador(TbColaborador colaborador) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idColaborador",colaborador));
        criteria.setProjection(Projections.rowCount());
        //Transaction t = this.getSessao().beginTransaction();

        int result=0;
        
        try{
        result=((Integer)criteria.list().get(0)).intValue();
        }catch(Exception ex){}

        //t.commit();
        this.getSessao().close();
        return result;
    }

    @Override
    public int quantidadePorColaboradorSemDiscrepancia(TbColaborador colaborador) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idColaborador",colaborador));
        List<TbTipoCorrecao> tipoCorrecao = new ArrayList<TbTipoCorrecao>();
        tipoCorrecao.add(new TbTipoCorrecao(14));
        tipoCorrecao.add(new TbTipoCorrecao(15));
        tipoCorrecao.add(new TbTipoCorrecao(13));
                
        criteria.add(Restrictions.in("idTipoCorrecao",tipoCorrecao));
        criteria.setProjection(Projections.rowCount());
        //Transaction t = this.getSessao().beginTransaction();

        int result=0;
        
        try{
        result=((Integer)criteria.list().get(0)).intValue();
        }catch(Exception ex){}

        //t.commit();
        this.getSessao().close();
        return result;
    }

    @Override
    public TbCorrecao pesquisarPorRespostaTipoCorrecao(TbResposta resposta, TbTipoCorrecao tipo) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idResposta",resposta));
        criteria.add(Restrictions.eq("idTipoCorrecao",tipo));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbCorrecao> lista = (List<TbCorrecao>) criteria.list();
        
        //t.commit();
        this.getSessao().close();
        if(lista==null || lista.isEmpty())return null;
        return lista.get(0);
    }
    
}
