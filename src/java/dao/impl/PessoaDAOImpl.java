/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.PessoaDAO;
import java.util.List;
import model.TbPessoa;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */
public class PessoaDAOImpl  extends GenericDAO<TbPessoa> implements PessoaDAO {
    
     public PessoaDAOImpl() {
        super(HibernateUtil.getSessionFactory().openSession(),TbPessoa.class);
    }
     
     @Override
    public TbPessoa pesquisarPorCpf(TbPessoa filtro){
         Criteria criteria = this.getSessao().createCriteria(this.getClasse());
         criteria.add(Restrictions.eq("nrCpf", filtro.getNrCpf()));
         //Transaction t = this.getSessao().beginTransaction();
         List<TbPessoa> lista = (List<TbPessoa>) criteria.list();
         //t.commit();
         this.getSessao().close();
         if(lista!=null )
            if(lista.size()>0)
                return lista.get(0);
         return null;
       
    }
}
    

