/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwConfere3aCorrecaoDAO;
import java.util.List;
import model.VwConfere3aCorrecao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author janio  
 */
public class VwConfere3aCorrecaoDAOImpl extends GenericDAO<VwConfere3aCorrecao> implements VwConfere3aCorrecaoDAO {
    
    public VwConfere3aCorrecaoDAOImpl() {
        super(HibernateUtil.getSessionFactory().openSession(),VwConfere3aCorrecao.class);
        
    }

    @Override
    public List<VwConfere3aCorrecao> pesquisarPorDisciplinaQuestao(int idDisciplina, int nrQuestao) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("nrQuestao",nrQuestao));
        criteria.add(Restrictions.eq("idDisciplina",idDisciplina));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwConfere3aCorrecao> lista = (List<VwConfere3aCorrecao>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }

}
