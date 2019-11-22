/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.UsuarioDAO;
import java.util.List;
import model.TbUsuario;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class UsuarioDAOImpl extends GenericDAO<TbUsuario> implements UsuarioDAO {

    public UsuarioDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),TbUsuario.class);
    }
    
    @Override
    public TbUsuario login(TbUsuario filtro){
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("nmUsuario", filtro.getNmUsuario()).ignoreCase() );
        criteria.add(Restrictions.eq("nmSenha",  filtro.getNmSenha() ));
        criteria.add(Restrictions.eq("flAtivo", true));
        
        //Transaction t = this.getSessao().beginTransaction();
        List<TbUsuario> lista = (List<TbUsuario>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista.get(0);
        return null;
    }

    @Override
    public List<TbUsuario> pesquisarAtivos() {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("flAtivo",true ));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbUsuario> lista = (List<TbUsuario>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;
    }
    
    @Override
    public TbUsuario pesquisarPorCpf(TbUsuario filtro){
         Criteria criteria = this.getSessao().createCriteria(this.getClasse());
         criteria.add(Restrictions.eq("nrCpf", filtro.getNrCpf()));
         //Transaction t = this.getSessao().beginTransaction();
         List<TbUsuario> lista = (List<TbUsuario>) criteria.list();
         //t.commit();
         this.getSessao().close();
         if(lista!=null )
            if(lista.size()>0)
                return lista.get(0);
         return null;
       
    }
    
    @Override
    public TbUsuario pesquisarPorUsuario(TbUsuario filtro){
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
         criteria.add(Restrictions.eq("nmUsuario", filtro.getNmUsuario()));
         //Transaction t = this.getSessao().beginTransaction();
         List<TbUsuario> lista = (List<TbUsuario>) criteria.list();
         //t.commit();
         this.getSessao().close();
         if(lista!=null )
            if(lista.size()>0)
                return lista.get(0);
         return null;
    }
}
