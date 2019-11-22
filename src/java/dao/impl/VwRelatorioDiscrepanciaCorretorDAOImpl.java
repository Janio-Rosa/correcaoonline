/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwRelatorioDiscrepanciaCorretorDAO;
import java.util.List;
import model.VwRelatorioDiscrepanciaCorretor;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class VwRelatorioDiscrepanciaCorretorDAOImpl extends GenericDAO<VwRelatorioDiscrepanciaCorretor> implements VwRelatorioDiscrepanciaCorretorDAO { 

    public VwRelatorioDiscrepanciaCorretorDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwRelatorioDiscrepanciaCorretor.class);
    }
    
    @Override
    public List<VwRelatorioDiscrepanciaCorretor>  pesquisarPorProcessoDisciplina(int idProcesso,int idDIsciplina) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("idDisciplina",idDIsciplina));
        criteria.add(Restrictions.eq("idProcesso",idProcesso));
        criteria.addOrder(Order.asc("nrQuestao"));

        //Transaction t = this.getSessao().beginTransaction();
        List<VwRelatorioDiscrepanciaCorretor> lista = (List<VwRelatorioDiscrepanciaCorretor>) criteria.list();
        //t.commit();this.getSessao().close();
        if(lista !=null && lista.size()>0)return lista;
        return null;
    
    }
    
}