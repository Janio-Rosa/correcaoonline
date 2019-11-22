/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.UsuarioXFuncionalidadeDAO;
import java.math.BigInteger;
import java.util.List;
import model.VwUsuarioFuncionalidade;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class UsuarioXFuncionalidadeDAOImpl extends GenericDAO<VwUsuarioFuncionalidade> implements UsuarioXFuncionalidadeDAO {

    
    public UsuarioXFuncionalidadeDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwUsuarioFuncionalidade.class);
    }
    
    @Override
    public List<VwUsuarioFuncionalidade> getFuncionalidadesPorUsuario(String nmUsuario) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        System.out.println("Consulta usuários 3: "+nmUsuario);
        criteria.add(Restrictions.eq("nmUsuario", nmUsuario   ));
        
        //Transaction t = this.getSessao().beginTransaction();
        List<VwUsuarioFuncionalidade> lista = (List<VwUsuarioFuncionalidade>) criteria.list();
        //t.commit();
        return lista;

    }
    
    @Override
    public List<VwUsuarioFuncionalidade> getFuncionalidadesPorUsuarioById(long idUsuario ){

        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idUsuario",  BigInteger.valueOf(idUsuario ) ));
        //Transaction t = this.getSessao().beginTransaction();
        List  lista =  criteria.list();
        //t.commit();
        this.getSessao().close();

        /*
        Transaction t = this.getSessao().beginTransaction();
        List lista = this.getSessao().createQuery("from "+this.getClasse().getName()).list();
        t.commit();
         */
        
        
        
        return (List<VwUsuarioFuncionalidade>)lista;
    }
    
}
