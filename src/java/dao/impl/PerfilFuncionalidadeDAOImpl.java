/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.PerfilFuncionalidadeDAO;
import dao.GenericDAO;
import java.util.List;
import model.TbPerfilFuncionalidade;
import model.TbPerfilFuncionalidadePK;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;


public class PerfilFuncionalidadeDAOImpl extends GenericDAO<TbPerfilFuncionalidade> implements PerfilFuncionalidadeDAO {

    public PerfilFuncionalidadeDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),TbPerfilFuncionalidade.class);
    }

    @Override
    public TbPerfilFuncionalidade pesquisarPorPerfilEFuncionalidade(int idPerfil, int idFuncionalidade) {
        TbPerfilFuncionalidadePK pk = new TbPerfilFuncionalidadePK( idPerfil , idFuncionalidade);

        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("tbPerfilFuncionalidadePK",pk));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbPerfilFuncionalidade> lista = (List<TbPerfilFuncionalidade>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista==null || lista.isEmpty())return null;
        return lista.get(0);
    }

}
