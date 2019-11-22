/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwColaboradorCorrecaoAtualDAO;
import java.util.List;
import model.VwColaboradorCorrecaoAtual;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author administrator
 */
public class VwColaboradorCorrecaoAtualDAOImpl extends GenericDAO<VwColaboradorCorrecaoAtual> implements VwColaboradorCorrecaoAtualDAO {
    
    public VwColaboradorCorrecaoAtualDAOImpl() {
        super(HibernateUtil.getSessionFactory().openSession(),VwColaboradorCorrecaoAtual.class);
        
    }

    @Override
    public VwColaboradorCorrecaoAtual pesquisarPorCPF(String nrCpf) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("nrCpf",nrCpf));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwColaboradorCorrecaoAtual> lista = (List<VwColaboradorCorrecaoAtual>) criteria.list();
        //t.commit();
        VwColaboradorCorrecaoAtual retorno = null;
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
    public VwColaboradorCorrecaoAtual pesquisarPorCPFeProcesso(String nrCpf,int idProcesso){
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("nrCpf",nrCpf));
        criteria.add(Restrictions.eq("idProcesso",idProcesso));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwColaboradorCorrecaoAtual> lista = (List<VwColaboradorCorrecaoAtual>) criteria.list();
        //t.commit();
        VwColaboradorCorrecaoAtual retorno=null;
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
    public VwColaboradorCorrecaoAtual pesquisarAtivosPorProcesso(int idProcesso){
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("flAtivo",true));
        criteria.add(Restrictions.eq("idProcesso", idProcesso));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwColaboradorCorrecaoAtual> lista = (List<VwColaboradorCorrecaoAtual>) criteria.list();
        //t.commit();
        VwColaboradorCorrecaoAtual retorno=null;
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
    public VwColaboradorCorrecaoAtual pesquisarPorCPFAtivo(String nrCpf) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        
        criteria.add(Restrictions.eq("nrCpf",nrCpf));
        criteria.add(Restrictions.eq("flAtivo",true));
        
        criteria.setMaxResults(1);
        
        //Transaction t = this.getSessao().beginTransaction();
        List<VwColaboradorCorrecaoAtual> lista = (List<VwColaboradorCorrecaoAtual>) criteria.list();
        //t.commit();

        this.getSessao().close();
        if(lista !=null && lista.size()>0)return lista.get(0);
        return null;
    }
}
