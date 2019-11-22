/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.ProcessoDAO;
import java.util.List;
import model.TbProcesso;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class ProcessoDAOImpl extends GenericDAO<TbProcesso> implements ProcessoDAO {
    
    public ProcessoDAOImpl() {
        super(HibernateUtil.getSessionFactory().openSession(),TbProcesso.class);
    }

    @Override
    public List<TbProcesso> pesquisarTodosAtivos() {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("flAtivo",true ));
        List<TbProcesso> lista = (List<TbProcesso>) criteria.list();
        this.getSessao().close();
        return lista;
    }
    
}
