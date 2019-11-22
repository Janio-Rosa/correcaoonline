/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.UsuarioPerfilDAO;
import dao.GenericDAO;
import java.util.List;
import model.TbUsuario;
import model.TbUsuarioPerfil;
import model.TbUsuarioPerfilPK;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;


public class UsuarioPerfilDAOImpl extends GenericDAO<TbUsuarioPerfil> implements UsuarioPerfilDAO {

    public UsuarioPerfilDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),TbUsuarioPerfil.class);
    }
    
    
    @Override
    public TbUsuarioPerfil pesquisarPorPerfilEUsuario(int idPerfil, long idUsuario) {
        TbUsuarioPerfilPK pk = new TbUsuarioPerfilPK( idUsuario , idPerfil);

        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("tbUsuarioPerfilPK",pk));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbUsuarioPerfil> lista = (List<TbUsuarioPerfil>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista==null || lista.isEmpty())return null;
        return lista.get(0);
    }

    @Override
    public TbUsuarioPerfil pesquisarPorIDUsuario(long idUsuario) {

        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("tbUsuario",new TbUsuario(idUsuario)));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbUsuarioPerfil> lista = (List<TbUsuarioPerfil>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista==null || lista.isEmpty())return null;
        return lista.get(0);
    }
    
}
