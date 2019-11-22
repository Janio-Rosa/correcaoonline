/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.FuncionalidadeDAO;
import dao.GenericDAO;
import model.TbFuncionalidade;
import util.dao.HibernateUtil;


public class FuncionalidadeDAOImpl extends GenericDAO<TbFuncionalidade> implements FuncionalidadeDAO {

    public FuncionalidadeDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),TbFuncionalidade.class);
    }
    
}
