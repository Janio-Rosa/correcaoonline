/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwUsuarioPessoaDAO;
import model.VwUsuarioPessoa;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class VwUsuarioPessoaDAOImpl extends GenericDAO<VwUsuarioPessoa> implements VwUsuarioPessoaDAO{
    
     public VwUsuarioPessoaDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwUsuarioPessoa.class);
    }

}
