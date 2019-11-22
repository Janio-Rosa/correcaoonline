/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwRelatorioNotasDAO;
import java.util.List;
import model.VwRelatorioNotas;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author janio
 */
public class VwRelatorioNotasDAOImpl extends GenericDAO<VwRelatorioNotas> implements VwRelatorioNotasDAO { 

    public VwRelatorioNotasDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwRelatorioNotas.class);
    }
    
    @Override
    public List<VwRelatorioNotas>  pesquisarPorProcessoDisciplina(int idProcesso,int idDIsciplina) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("idDisciplina",idDIsciplina));
        criteria.add(Restrictions.eq("idProcesso",idProcesso));

        //Transaction t = this.getSessao().beginTransaction();
        List<VwRelatorioNotas> lista = (List<VwRelatorioNotas>) criteria.list();
        //t.commit();this.getSessao().close();
        if(lista !=null && lista.size()>0)return lista;
        return null;
    
    }

    @Override
    public List<VwRelatorioNotas> pesquisarPorProcesso(int idProcesso) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("idProcesso",idProcesso));

        List<VwRelatorioNotas> lista = (List<VwRelatorioNotas>) criteria.list();

        if(lista !=null && lista.size()>0)return lista;
        return null;
    }

    @Override
    public List<VwRelatorioNotas> pesquisarPorProcessoDisciplinaCurso(int idProcesso, int idDIsciplina, int idCurso) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idDisciplina",idDIsciplina));
        criteria.add(Restrictions.eq("idProcesso",idProcesso));
        criteria.add(Restrictions.eq("idCurso",idCurso));
        List<VwRelatorioNotas> lista = (List<VwRelatorioNotas>) criteria.list();
        if(lista !=null && lista.size()>0)return lista;
        return null;
    }
    
}