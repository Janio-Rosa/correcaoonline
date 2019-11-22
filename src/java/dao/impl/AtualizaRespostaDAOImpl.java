/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.AtualizaRespostaDAO;
import dao.GenericDAO;
import model.TbAtualizaResposta;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class AtualizaRespostaDAOImpl extends GenericDAO<TbAtualizaResposta> implements  AtualizaRespostaDAO  {

    public AtualizaRespostaDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),TbAtualizaResposta.class);
    }
    
}
