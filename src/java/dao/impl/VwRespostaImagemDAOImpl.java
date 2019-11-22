/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwRespostaImagemDAO;
import java.util.List;
import model.VwRespostaImagem;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author administrator
 */
public class VwRespostaImagemDAOImpl extends GenericDAO<VwRespostaImagem> implements  VwRespostaImagemDAO {

    public VwRespostaImagemDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwRespostaImagem.class);
    }

    @Override
    public List<VwRespostaImagem> pesquisarPorIdResposta(long idResposta) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idResposta", idResposta));
        criteria.addOrder(Order.asc("nrOrdem"));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwRespostaImagem> lista = (List<VwRespostaImagem>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;

    }
    
}
