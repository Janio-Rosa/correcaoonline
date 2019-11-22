/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwColaboradorPendenteDAO;
import java.util.List;
import model.VwColaboradorPendente;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author administrator
 */
public class VwColaboradorPendenteDAOImpl extends GenericDAO<VwColaboradorPendente> implements VwColaboradorPendenteDAO {
    
    public VwColaboradorPendenteDAOImpl() {
        super(HibernateUtil.getSessionFactory().openSession(),VwColaboradorPendente.class);
        
    }

    @Override
    public VwColaboradorPendente pesquisarPorCPF(String nrCpf) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("nrCpf",nrCpf));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwColaboradorPendente> lista = (List<VwColaboradorPendente>) criteria.list();
        //t.commit();
        VwColaboradorPendente retorno = null;
        if(lista !=null && lista.size()>0){
            retorno = lista.get(0);
            retorno.getNrCpf();
            retorno.getIdBanca();
            retorno.getIdFuncao();
            retorno.getIdProcesso();
            retorno.getIdTipoCorrecao();
        }
        this.getSessao().close();
        if(lista !=null && lista.size()>0)return retorno;
        return null;
    }

    @Override
    public List<VwColaboradorPendente> pesquisarListaPorCPF(String nrCpf) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("nrCpf",nrCpf));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwColaboradorPendente> lista = (List<VwColaboradorPendente>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;
    }
    
    @Override
    public VwColaboradorPendente pesquisarPorCPFeProcesso(String nrCpf,int idProcesso){
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("nrCpf",nrCpf));
        criteria.add(Restrictions.eq("idProcesso",idProcesso));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwColaboradorPendente> lista = (List<VwColaboradorPendente>) criteria.list();
        //t.commit();
        VwColaboradorPendente retorno=null;
        if(lista !=null && lista.size()>0){
            retorno = lista.get(0);
            retorno.getNrCpf();
            retorno.getIdBanca();
            retorno.getIdFuncao();
            retorno.getIdProcesso();
            retorno.getIdTipoCorrecao();
        }
        this.getSessao().close();
        if(lista !=null && lista.size()>0)return retorno;
        return null;
    
    }

    @Override
    public VwColaboradorPendente pesquisarAtivosPorProcesso(int idProcesso){
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("flAtivo",true));
        criteria.add(Restrictions.eq("idProcesso", idProcesso));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwColaboradorPendente> lista = (List<VwColaboradorPendente>) criteria.list();
        //t.commit();
        VwColaboradorPendente retorno=null;
        if(lista !=null && lista.size()>0){
            retorno = lista.get(0);
            retorno.getNrCpf();
            retorno.getIdBanca();
            retorno.getIdFuncao();
            retorno.getIdProcesso();
            retorno.getIdTipoCorrecao();
        }
        this.getSessao().close();
        if(lista !=null && lista.size()>0)return retorno;
        return null;
    
    }
   
    @Override
    public VwColaboradorPendente pesquisarPorCPFAtivo(String nrCpf) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        
        criteria.add(Restrictions.eq("nrCpf",nrCpf));
        criteria.add(Restrictions.eq("flAtivo",true));
        
        criteria.setMaxResults(1);
        
        //Transaction t = this.getSessao().beginTransaction();
        List<VwColaboradorPendente> lista = (List<VwColaboradorPendente>) criteria.list();
        //t.commit();

        this.getSessao().close();
        if(lista !=null && lista.size()>0)return lista.get(0);
        return null;
    }
}
