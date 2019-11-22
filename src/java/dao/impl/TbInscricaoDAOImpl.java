/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.TbInscricaoDAO;
import model.TbInscricao;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class TbInscricaoDAOImpl extends GenericDAO<TbInscricao> implements  TbInscricaoDAO  {

    public TbInscricaoDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),TbInscricao.class);
    }
    
}
