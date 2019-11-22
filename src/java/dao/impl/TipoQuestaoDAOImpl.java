/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.TipoQuestaoDAO;
import dao.GenericDAO;
import model.TbTipoQuestao;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */
public class TipoQuestaoDAOImpl extends GenericDAO<TbTipoQuestao> implements TipoQuestaoDAO {
    
     public TipoQuestaoDAOImpl() {
        super(HibernateUtil.getSessionFactory().openSession(),TbTipoQuestao.class);
        
    }
    
}
