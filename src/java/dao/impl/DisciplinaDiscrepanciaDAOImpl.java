/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DisciplinaDAO;
import dao.DisciplinaDiscrepanciaDAO;
import dao.GenericDAO;
import java.util.List;
import model.TbDisciplina;
import model.TbDisciplinaDiscrepancia;
import model.TbQuestao;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */
public class DisciplinaDiscrepanciaDAOImpl extends GenericDAO<TbDisciplinaDiscrepancia> implements DisciplinaDiscrepanciaDAO{
    
     public DisciplinaDiscrepanciaDAOImpl() {
        super(HibernateUtil.getSessionFactory().openSession(),TbDisciplinaDiscrepancia.class);
        
    }

    @Override
    public List<TbDisciplinaDiscrepancia> pesquisarPorDisciplinaEQuestao(TbDisciplina disc,TbQuestao questao) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        if(disc!=null && disc.getIdDisciplina()!=null && disc.getIdDisciplina().intValue()>0)
            criteria.add(Restrictions.eq("idDisciplina",disc));
        
        if(questao!=null && questao.getIdQuestao()!=null && questao.getIdQuestao().intValue()>0)
            criteria.add(Restrictions.eq("idQuestao",questao));
        
        //Transaction t = this.getSessao().beginTransaction();
        List<TbDisciplinaDiscrepancia> lista = (List<TbDisciplinaDiscrepancia>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;
    }
     
}
