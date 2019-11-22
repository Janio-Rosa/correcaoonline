/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwUsuarioPerfilDAO;
import model.VwUsuarioPerfil;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */
public class VwUsuarioPerfilDAOImpl extends GenericDAO<VwUsuarioPerfil> implements VwUsuarioPerfilDAO{
    
     public VwUsuarioPerfilDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwUsuarioPerfil.class);
    }
    
 
    
}
