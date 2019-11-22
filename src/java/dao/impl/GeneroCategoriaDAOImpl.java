/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.GeneroCategoriaDAO;
import java.util.List;
import model.TbGeneroCategoria;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class GeneroCategoriaDAOImpl extends GenericDAO<TbGeneroCategoria> implements GeneroCategoriaDAO {
    
     public GeneroCategoriaDAOImpl() {
        super(HibernateUtil.getSessionFactory().openSession(),TbGeneroCategoria.class);
        
    }

    @Override
    public List<TbGeneroCategoria> pesquisarTodosSemGeral(String[] atributoOrdenar) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("flGeral",false));
        criteria.add(Restrictions.eq("flAtivo",true));
        criteria.add(Restrictions.ne("idGeneroCategoria",28));
        /*
        for(String atual : atributoOrdenar){
            criteria.addOrder(Order.asc(atual).ignoreCase());
        }*/
        //Transaction t = this.getSessao().beginTransaction();
        List<TbGeneroCategoria> lista = (List<TbGeneroCategoria>) criteria.list();
        //for(TbGeneroCategoria atual : lista){atual.getIdGeneroCategoriaPai();}
        //t.commit();
        this.getSessao().close();
        return lista;
    }

    @Override
    public List<TbGeneroCategoria> pesquisarTodosSemGeralPorTipoQuestao(int tipoQuestao ) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("flGeral",false));
        criteria.add(Restrictions.eq("flAtivo",true));
        criteria.add(Restrictions.eq("idTipoQuestao", tipoQuestao));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbGeneroCategoria> lista = (List<TbGeneroCategoria>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;
    }
    
}
