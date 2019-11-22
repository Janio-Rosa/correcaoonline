/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.CursoDAO;
import dao.GenericDAO;
import model.TbCurso;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */
public class CursoDAOImpl  extends GenericDAO<TbCurso> implements  CursoDAO  {

    public CursoDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),TbCurso.class);
    }

}
