/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;
import dao.GenericDAO;
import dao.VwConfere1aCorrecaoDAO;
import java.util.List;
import model.VwConfere1aCorrecao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author janio
 */
public class VwConfere1aCorrecaoDAOImpl extends GenericDAO<VwConfere1aCorrecao> implements VwConfere1aCorrecaoDAO {
    
    public VwConfere1aCorrecaoDAOImpl() {
        super(HibernateUtil.getSessionFactory().openSession(),VwConfere1aCorrecao.class);
        
    }

    @Override
    public List<VwConfere1aCorrecao> pesquisarPorDisciplinaQuestao(int idDisciplina, int nrQuestao) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("nrQuestao",nrQuestao));
        criteria.add(Restrictions.eq("idDisciplina",idDisciplina));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwConfere1aCorrecao> lista = (List<VwConfere1aCorrecao>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }

}
