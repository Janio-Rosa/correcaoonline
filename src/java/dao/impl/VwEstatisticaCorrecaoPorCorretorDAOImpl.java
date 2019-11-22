
package dao.impl;

import dao.GenericDAO;
import dao.VwEstatisticaCorrecaoPorCorretorDAO;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.VwEstatisticaCorrecaoPorCorretor;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author KAMYLLA
 */
public class VwEstatisticaCorrecaoPorCorretorDAOImpl extends GenericDAO<VwEstatisticaCorrecaoPorCorretor> implements VwEstatisticaCorrecaoPorCorretorDAO{
    
     public VwEstatisticaCorrecaoPorCorretorDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwEstatisticaCorrecaoPorCorretor.class);
    }
     
     
     @Override
    public List<VwEstatisticaCorrecaoPorCorretor> pesquisarPorProcesso(int processo) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",processo));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwEstatisticaCorrecaoPorCorretor> lista = (List<VwEstatisticaCorrecaoPorCorretor>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }

    @Override
    public List<VwEstatisticaCorrecaoPorCorretor> pesquisarPorProcessoDisciplina(int processo, int disciplina) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idProcesso",processo));
        criteria.add(Restrictions.eq("idDisciplina",disciplina));
        //Transaction t = this.getSessao().beginTransaction();
        List<VwEstatisticaCorrecaoPorCorretor> lista = (List<VwEstatisticaCorrecaoPorCorretor>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if(lista!=null )
            if(lista.size()>0)
                return lista;
         return null;
    }
     
    @Override
    public int pesquisarTotalPorCPF(String nrCpf) {
        
        int retorno=0;
        List<Integer> tiposCorrecao = new ArrayList<Integer>();
        tiposCorrecao.add(new Integer(14));
        tiposCorrecao.add(new Integer(15));
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("nrCpf",nrCpf));
        criteria.add(Restrictions.in("idTipoCorrecao", tiposCorrecao ) );
        
        ProjectionList pl = Projections.projectionList();
        pl.add(Projections.property("nrCpf"));
        pl.add(Projections.sum("nrQuantidade"));
        pl.add(Projections.groupProperty("nrCpf"));
 
        criteria.setProjection(pl);
        
        //Transaction t = this.getSessao().beginTransaction();
        List<VwEstatisticaCorrecaoPorCorretor> lista = (List<VwEstatisticaCorrecaoPorCorretor>) criteria.list();
        //t.commit();
        
        this.getSessao().close();
        
        if(lista!=null && lista.size()>0){
            Iterator iterando = lista.iterator();
            if(iterando.hasNext()){
                Object[] obj = (Object[]) iterando.next();
                BigInteger novo = (BigInteger) obj[1];
                retorno=(novo).intValue();
            }
        }

        return retorno;
    }
     
     
    
}

