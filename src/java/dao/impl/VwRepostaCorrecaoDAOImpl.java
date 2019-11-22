/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwRepostaCorrecaoDAO;
import java.math.BigInteger;
import java.util.List;
import model.VwRespostaCorrecao;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class VwRepostaCorrecaoDAOImpl extends GenericDAO<VwRespostaCorrecao> implements  VwRepostaCorrecaoDAO {

    public VwRepostaCorrecaoDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwRespostaCorrecao.class);
    }
    
    @Override
    public int quantidadePorColaborador(long idColaborador,int idProcesso ) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idColaborador",idColaborador ));
        criteria.add(Restrictions.eq("idProcesso",idProcesso));
        criteria.add(Restrictions.ne("idTipoCorrecao",16));
        criteria.setProjection(Projections.rowCount());
        //Transaction t = this.getSessao().beginTransaction();

        int result=0;
        
        try{
        result=((Integer)criteria.list().get(0)).intValue();
        }catch(Exception ex){}

        //t.commit();
        this.getSessao().close();
        return result;
    }

    @Override
    public List<VwRespostaCorrecao> listaCorrecoesPorCorretorDisciplinaProcesso(long idColaborador,int idProcesso, int idDisciplina  ) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idColaborador",idColaborador));
        criteria.add(Restrictions.eq("idProcesso",idProcesso));
        criteria.add(Restrictions.eq("idDisciplina",idDisciplina));
        criteria.addOrder(Order.desc("dtInsercaoCorrecao"));

        //Transaction t = this.getSessao().beginTransaction();
        List<VwRespostaCorrecao> lista = (List<VwRespostaCorrecao>) criteria.list();

        //t.commit();
        this.getSessao().close();
        
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }

    @Override
    public List<VwRespostaCorrecao> pesquisarPorIdResposta(long idResposta) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idResposta", BigInteger.valueOf(idResposta)));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwRespostaCorrecao> lista = (List<VwRespostaCorrecao>) criteria.list();
        //t.commit();
        this.getSessao().close();
        return lista;

    }

    @Override
    public VwRespostaCorrecao pesquisarPorIdCorrecao(Long idCorrecao) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idCorrecao", idCorrecao));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwRespostaCorrecao> lista = (List<VwRespostaCorrecao>) criteria.list();
        //t.commit();
        this.getSessao().close();
        
        if(lista!=null && lista.size()>0)return lista.get(0);
        return null;

    }

    @Override
    public VwRespostaCorrecao pesquisarPorIdResposta(long idResposta,long idColaborador) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idResposta", BigInteger.valueOf(idResposta)));
        //criteria.add(Restrictions.eq("idColaborador", BigInteger.valueOf(idColaborador)));
        criteria.add(Restrictions.eq("idColaborador", idColaborador));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwRespostaCorrecao> lista = (List<VwRespostaCorrecao>) criteria.list();
        //t.commit();
        this.getSessao().close();
        
        if(lista!=null && lista.size()>0)return lista.get(0);
        return null;

    }

    @Override
    public List<VwRespostaCorrecao> listaCorrecoesPorPessoaDisciplinaProcesso(String nrCpf, int idProcesso, int idDisciplina) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("nrCpf",nrCpf));
        criteria.add(Restrictions.eq("idProcesso",idProcesso));
        criteria.add(Restrictions.eq("idDisciplina",idDisciplina));
        criteria.addOrder(Order.desc("dtInsercaoCorrecao"));

        //Transaction t = this.getSessao().beginTransaction();
        List<VwRespostaCorrecao> lista = (List<VwRespostaCorrecao>) criteria.list();

        //t.commit();
        this.getSessao().close();
        
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }
    
}
