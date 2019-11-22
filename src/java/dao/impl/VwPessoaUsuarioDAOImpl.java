/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwPessoaUsuarioDAO;

import java.math.BigInteger;
import java.util.List;
import model.VwPessoaUsuario;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;


/**
 *
 * @author KAMYLLA
 */
public class VwPessoaUsuarioDAOImpl extends GenericDAO<VwPessoaUsuario> implements VwPessoaUsuarioDAO{
    
     public VwPessoaUsuarioDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwPessoaUsuario.class);
    }
     
     
    @Override
    public List<VwPessoaUsuario> pesquisarAtivos() {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("flAtivo",true ));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwPessoaUsuario> lista = (List<VwPessoaUsuario>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }
    
    
}
