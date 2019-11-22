/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DisciplinaDAO;
import dao.GenericDAO;
import java.util.List;
import model.TbDisciplina;
import model.TbResposta;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */

public class DisciplinaDAOImpl extends GenericDAO<TbDisciplina> implements DisciplinaDAO {
    
    public DisciplinaDAOImpl() {
        super(HibernateUtil.getSessionFactory().openSession(),TbDisciplina.class);
        
    }

    @Override
    public List<TbDisciplina> pesquisarTodosOrdenadasComResposta(String[] atributoOrdenar) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        for(String atual : atributoOrdenar){
            criteria.addOrder(Order.asc(atual).ignoreCase());
        }
        
        //DetachedCriteria subquery = DetachedCriteria.forClass(TbResposta.class,"resp");
        //criteria.add(Property.forName("Disciplina.idDisciplina").in(subquery));
        
        //criteria.add(Restrictions.in("idGeneroCategoria", generos));
        //criteria.add(Restrictions.sqlRestriction(" {Disciplina}.id_disciplina IN (select id_disciplina from tb_resposta) "));
        criteria.add(Restrictions.sqlRestriction(" id_disciplina IN (select id_disciplina from tb_resposta) "));
        
        //DetachedCriteria subQuery = DetachedCriteria.forClass(TbResposta.class);
        //Criterion subQueryCrit = Subqueries.in("queryDetails", subQuery);
        //criteria.add(subQueryCrit);
        
        
        //Transaction t = this.getSessao().beginTransaction();
        List lista = criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;
    }
    
}
