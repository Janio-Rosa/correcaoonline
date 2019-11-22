/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwConfere2aCorrecaoDAO;
import java.util.List;
import model.VwConfere2aCorrecao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author janio
 */
public class VwConfere2aCorrecaoDAOImpl  extends GenericDAO<VwConfere2aCorrecao> implements VwConfere2aCorrecaoDAO {
    
    public VwConfere2aCorrecaoDAOImpl() {
        super(HibernateUtil.getSessionFactory().openSession(),VwConfere2aCorrecao.class);
        
    }

    @Override
    public List<VwConfere2aCorrecao> pesquisarPorDisciplinaQuestao(int idDisciplina, int nrQuestao) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("nrQuestao",nrQuestao));
        criteria.add(Restrictions.eq("idDisciplina",idDisciplina));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwConfere2aCorrecao> lista = (List<VwConfere2aCorrecao>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }

}
