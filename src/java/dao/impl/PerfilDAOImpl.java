/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.PerfilDAO;
import dao.GenericDAO;
import model.TbPerfil;
import util.dao.HibernateUtil;


public class PerfilDAOImpl extends GenericDAO<TbPerfil> implements PerfilDAO {

    public PerfilDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),TbPerfil.class);
    }
    
}
