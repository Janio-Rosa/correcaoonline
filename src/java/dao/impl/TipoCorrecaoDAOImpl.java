/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.TipoCorrecaoDAO;
import model.TbTipoCorrecao;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class TipoCorrecaoDAOImpl extends GenericDAO<TbTipoCorrecao> implements  TipoCorrecaoDAO  {

    public TipoCorrecaoDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),TbTipoCorrecao.class);
    }
    
}
