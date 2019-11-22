/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.RespostaImagemDAO;
import java.util.List;
import model.TbResposta;
import model.TbRespostaImagem;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class RespostaImagemDAOImpl extends GenericDAO<TbRespostaImagem> implements  RespostaImagemDAO  {

    public RespostaImagemDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),TbRespostaImagem.class);
    }
    
    @Override
    public TbRespostaImagem pesquisarProximaImagem() {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("flConferida", false));

        criteria.add(Restrictions.sqlRestriction(" 1=1 order by random()"));

        criteria.setMaxResults(1);
        
        criteria.setLockMode(LockMode.UPGRADE_NOWAIT); //Lock
        
        Transaction t = this.getSessao().beginTransaction();
        List<TbRespostaImagem> lista = (List<TbRespostaImagem>) criteria.list();
        if(lista==null)return null;
        if(lista.size()<=0)return null;
        //t.commit();
        //this.getSessao().close();
        try{
            TbRespostaImagem retorno=lista.get(0);
            return retorno;
        }catch(Exception ex){
            return null;
        }
    }
    
    @Override
    public TbRespostaImagem pesquisarProximaImagemEmBranco() {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("flEmBrancoConferida", false)); 
        criteria.add(Restrictions.eq("flRespostaEmBranco", true)); 
        criteria.add(Restrictions.sqlRestriction(" 1=1 order by random()"));
        criteria.setMaxResults(1);
        criteria.setLockMode(LockMode.UPGRADE_NOWAIT); //Lock
        
        Transaction t = this.getSessao().beginTransaction();
        List<TbRespostaImagem> lista = (List<TbRespostaImagem>) criteria.list();
        if(lista==null)return null;
        if(lista.size()<=0)return null;
        //t.commit();
        //this.getSessao().close();
        try{
            TbRespostaImagem retorno=lista.get(0);
            return retorno;
        }catch(Exception ex){
            return null;
        }
    }
    
    @Override
    public TbRespostaImagem atualizarFlag(TbRespostaImagem resp) {
        //Transaction t = this.getSessao().beginTransaction();
        this.getSessao().update(resp);
        //atual.update(resp);
        return resp;

    }
    
    @Override
    public List<TbRespostaImagem> pesquisarPorIdResposta(TbResposta idResposta){
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idResposta", idResposta));
        criteria.addOrder(Order.asc("nrOrdem"));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbRespostaImagem> lista = (List<TbRespostaImagem>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;
        
    }

}
