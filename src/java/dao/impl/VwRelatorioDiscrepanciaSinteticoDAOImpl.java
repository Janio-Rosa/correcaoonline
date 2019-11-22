/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwRelatorioDiscrepanciaSinteticoDAO;
import java.util.List;
import model.VwRelatorioDiscrepanciaSintetico;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class VwRelatorioDiscrepanciaSinteticoDAOImpl extends GenericDAO<VwRelatorioDiscrepanciaSintetico> implements VwRelatorioDiscrepanciaSinteticoDAO { 

    public VwRelatorioDiscrepanciaSinteticoDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwRelatorioDiscrepanciaSintetico.class);
    }
    
    @Override
    public List<VwRelatorioDiscrepanciaSintetico>  pesquisarPorProcessoDisciplina(int idProcesso,int idDIsciplina) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("idDisciplina",idDIsciplina));
        criteria.add(Restrictions.eq("idProcesso",idProcesso));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwRelatorioDiscrepanciaSintetico> lista = (List<VwRelatorioDiscrepanciaSintetico>) criteria.list();
        //t.commit();this.getSessao().close();
        if(lista !=null && lista.size()>0)return lista;
        return null;
    
    }
    
}