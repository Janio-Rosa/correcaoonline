/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwPerfilFuncionalidadeDAO;

import model.VwPerfilFuncionalidade;

import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */
public class VwPerfilFuncionalidadeDAOImpl extends GenericDAO<VwPerfilFuncionalidade> implements VwPerfilFuncionalidadeDAO{
    
     public VwPerfilFuncionalidadeDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwPerfilFuncionalidade.class);
    }
    
    
}
