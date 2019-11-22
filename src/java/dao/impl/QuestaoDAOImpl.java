/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.QuestaoDAO;
import model.TbQuestao;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class QuestaoDAOImpl extends GenericDAO<TbQuestao> implements QuestaoDAO {
    
    public QuestaoDAOImpl() {
        super(HibernateUtil.getSessionFactory().openSession(),TbQuestao.class);
    }
    
}
