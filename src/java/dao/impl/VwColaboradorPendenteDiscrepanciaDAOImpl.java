/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwColaboradorPendenteDiscrepanciaDAO;
import java.util.List;
import model.VwColaboradorPendenteDiscrepancia;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Jânio
 */
public class VwColaboradorPendenteDiscrepanciaDAOImpl extends GenericDAO<VwColaboradorPendenteDiscrepancia> implements VwColaboradorPendenteDiscrepanciaDAO {
    
    public VwColaboradorPendenteDiscrepanciaDAOImpl() {
        super(HibernateUtil.getSessionFactory().openSession(),VwColaboradorPendenteDiscrepancia.class);
        
    }

    @Override
    public VwColaboradorPendenteDiscrepancia pesquisarPorCPF(String nrCpf) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("nrCpf",nrCpf));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwColaboradorPendenteDiscrepancia> lista = (List<VwColaboradorPendenteDiscrepancia>) criteria.list();
        //t.commit();
        VwColaboradorPendenteDiscrepancia retorno = null;
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
    public VwColaboradorPendenteDiscrepancia pesquisarPorIDColaborador(long IdColaborador) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idColaborador",IdColaborador));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwColaboradorPendenteDiscrepancia> lista = (List<VwColaboradorPendenteDiscrepancia>) criteria.list();
        //t.commit();
        VwColaboradorPendenteDiscrepancia retorno = null;
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
    public VwColaboradorPendenteDiscrepancia pesquisarPorCPFeProcesso(String nrCpf,int idProcesso){
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("nrCpf",nrCpf));
        criteria.add(Restrictions.eq("idProcesso",idProcesso));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwColaboradorPendenteDiscrepancia> lista = (List<VwColaboradorPendenteDiscrepancia>) criteria.list();
        //t.commit();
        VwColaboradorPendenteDiscrepancia retorno=null;
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
    public VwColaboradorPendenteDiscrepancia pesquisarAtivosPorProcesso(int idProcesso){
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("flAtivo",true));
        criteria.add(Restrictions.eq("idProcesso", idProcesso));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwColaboradorPendenteDiscrepancia> lista = (List<VwColaboradorPendenteDiscrepancia>) criteria.list();
        //t.commit();
        VwColaboradorPendenteDiscrepancia retorno=null;
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
    public VwColaboradorPendenteDiscrepancia pesquisarPorCPFAtivo(String nrCpf) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        
        criteria.add(Restrictions.eq("nrCpf",nrCpf));
        criteria.add(Restrictions.eq("flAtivo",true));
        
        criteria.setMaxResults(1);
        
        //Transaction t = this.getSessao().beginTransaction();
        List<VwColaboradorPendenteDiscrepancia> lista = (List<VwColaboradorPendenteDiscrepancia>) criteria.list();
        //t.commit();
        VwColaboradorPendenteDiscrepancia retorno = null;
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
    public List<VwColaboradorPendenteDiscrepancia> pesquisarListaPorCPFAtivo(String nrCpf) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("nrCpf",nrCpf));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwColaboradorPendenteDiscrepancia> lista = (List<VwColaboradorPendenteDiscrepancia>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;
    }
}
