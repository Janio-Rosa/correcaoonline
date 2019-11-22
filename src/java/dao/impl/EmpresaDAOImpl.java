/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.EmpresaDAO;
import dao.GenericDAO;
import model.TbEmpresa;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class EmpresaDAOImpl extends GenericDAO<TbEmpresa> implements EmpresaDAO {

    public EmpresaDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),TbEmpresa.class);
    }
    
}
