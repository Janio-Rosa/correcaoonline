/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ColaboradorDAO;
import dao.GenericDAO;
import java.util.List;
import model.TbColaborador;
import model.TbCurso;
import model.TbPessoa;
import model.TbProcesso;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */

public class ColaboradorDAOImpl extends GenericDAO<TbColaborador> implements ColaboradorDAO {
    
    public ColaboradorDAOImpl() {
        super(HibernateUtil.getSessionFactory().openSession(),TbColaborador.class);
        
    }

    @Override
    public TbColaborador pesquisarPorCPF(String nrCpf) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        TbPessoa procurar = new TbPessoa();
        procurar.setNrCpf(nrCpf);
        criteria.add(Restrictions.eq("nrCpf",procurar));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbColaborador> lista = (List<TbColaborador>) criteria.list();
        //t.commit();
        TbColaborador retorno = null;
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
    public TbColaborador pesquisarPorCPFeProcesso(TbPessoa procurarPessoa,TbProcesso procurarProcesso){
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("nrCpf",procurarPessoa));
        criteria.add(Restrictions.eq("idProcesso",procurarProcesso));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbColaborador> lista = (List<TbColaborador>) criteria.list();
        //t.commit();
        TbColaborador retorno=null;
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
    public TbColaborador pesquisarAtivosPorProcesso(int idProcesso){
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("flAtivo",true));
        criteria.add(Restrictions.eq("idProcesso",(new TbProcesso(idProcesso))));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbColaborador> lista = (List<TbColaborador>) criteria.list();
        //t.commit();
        TbColaborador retorno=null;
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
    public TbColaborador pesquisarPorCPFAtivo(String nrCpf) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        TbPessoa procurar = new TbPessoa();
        procurar.setNrCpf(nrCpf);
        criteria.add(Restrictions.eq("nrCpf",procurar));
        criteria.add(Restrictions.eq("flAtivo",true));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbColaborador> lista = (List<TbColaborador>) criteria.list();
        //t.commit();
        TbColaborador retorno = null;
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
    public List<TbColaborador> pesquisarTodosPorCPF(String nrCpf,TbProcesso processo) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        TbPessoa procurar = new TbPessoa();
        procurar.setNrCpf(nrCpf);
        criteria.add(Restrictions.eq("nrCpf",procurar));
        criteria.add(Restrictions.eq("idProcesso",processo));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbColaborador> lista = (List<TbColaborador>) criteria.list();
        //t.commit();
        if(lista !=null && lista.size()>0)return lista;
        return null;
    }
    
}
