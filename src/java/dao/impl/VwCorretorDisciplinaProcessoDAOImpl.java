/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwCorretorDisciplinaProcessoDAO;
import java.util.List;
import model.VwCorretorDisciplinaProcesso;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author janio
 */
public class VwCorretorDisciplinaProcessoDAOImpl  extends GenericDAO<VwCorretorDisciplinaProcesso> implements VwCorretorDisciplinaProcessoDAO { 

    public VwCorretorDisciplinaProcessoDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwCorretorDisciplinaProcesso.class);
    }

    @Override
    public List<VwCorretorDisciplinaProcesso> pesquisaPorProcessoDisciplina(int idDisciplina,int idProcesso ) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",idProcesso ));
        criteria.add(Restrictions.eq("idDisciplina",idDisciplina));
        
        List<VwCorretorDisciplinaProcesso> lista = (List<VwCorretorDisciplinaProcesso>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }

}
