/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.FuncaoDAO;
import dao.GenericDAO;
import model.TbFuncao;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */

public class FuncaoDAOImpl extends GenericDAO<TbFuncao> implements FuncaoDAO {
    
    public FuncaoDAOImpl() {
        super(HibernateUtil.getSessionFactory().openSession(),TbFuncao.class);
        
    }
    
}
