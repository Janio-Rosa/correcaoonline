 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwPessoaColaboradorDAO;

import java.math.BigInteger;
import java.util.List;
import model.VwPessoaColaborador;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */
public class VwPessoaColaboradorDAOImpl extends GenericDAO<VwPessoaColaborador> implements VwPessoaColaboradorDAO{
    
     public VwPessoaColaboradorDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwPessoaColaborador.class);
    }

    @Override
    public List<VwPessoaColaborador> pesquisarAtivosPorProcesso(int idProcesso){
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("flAtivo",true));
        criteria.add(Restrictions.eq("idProcesso",idProcesso));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwPessoaColaborador> lista = (List<VwPessoaColaborador>) criteria.list();
        //t.commit();this.getSessao().close();
        if(lista !=null && lista.size()>0)return lista;
        return null;
    
    }
    
    @Override
    public List<VwPessoaColaborador> pesquisarAtivosPorCurso(int idCurso){
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

       // criteria.add(Restrictions.eq("flAtivo",true));
        criteria.add(Restrictions.eq("idCurso",idCurso));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwPessoaColaborador> lista = (List<VwPessoaColaborador>) criteria.list();
        //t.commit();this.getSessao().close();
        if(lista !=null && lista.size()>0)return lista;
        return null;
    
    }
    
    @Override
    public List<VwPessoaColaborador> pesquisarAtivosPorColaborador(int idColaborador){
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("flAtivo",true));
        criteria.add(Restrictions.eq("idColaborador",idColaborador));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwPessoaColaborador> lista = (List<VwPessoaColaborador>) criteria.list();
        //t.commit();this.getSessao().close();
        if(lista !=null && lista.size()>0)return lista;
        return null;
    
    }
    
    
    @Override
    public List<VwPessoaColaborador> pesquisarPorColaboradorCursoProcesso(String nrCpf,int idCurso,int idProcesso) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        if(nrCpf!=null && !nrCpf.equals(""))
            criteria.add(Restrictions.eq("nrCpf", nrCpf));
        if(idCurso>0)
            criteria.add(Restrictions.eq("idCurso",idCurso));
        if(idProcesso>0)
            criteria.add(Restrictions.eq("idProcesso",idProcesso));
        //Transaction t = (Transaction) this.getSessao().beginTransaction();
        List<VwPessoaColaborador> lista = (List<VwPessoaColaborador>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista !=null && lista.size()>0) return lista;
        return null;
    }

    @Override
    public List<VwPessoaColaborador> pesquisarPorColaboradorCursoProcesso(String nrCpf,int idCurso,int idProcesso,int idDisciplina) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        if(nrCpf!=null && !nrCpf.equals(""))
            criteria.add(Restrictions.eq("nrCpf", nrCpf));
        if(idCurso>0)
            criteria.add(Restrictions.eq("idCurso",idCurso));
        if(idProcesso>0)
            criteria.add(Restrictions.eq("idProcesso",idProcesso));
        if(idDisciplina>0)
            criteria.add(Restrictions.eq("idDisciplina",idDisciplina));
        
        //Transaction t = (Transaction) this.getSessao().beginTransaction();
        List<VwPessoaColaborador> lista = (List<VwPessoaColaborador>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista !=null && lista.size()>0) return lista;
        return null;
    }

}
