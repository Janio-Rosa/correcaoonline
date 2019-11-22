/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.VwResposta3aCorrecaoDAO;
import java.util.List;
import model.VwResposta3aCorrecao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author administrator
 */
public class VwResposta3aCorrecaoDAOImpl extends GenericDAO<VwResposta3aCorrecao> implements  VwResposta3aCorrecaoDAO {

    public VwResposta3aCorrecaoDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),VwResposta3aCorrecao.class);
    }

    @Override
    public List<VwResposta3aCorrecao> pesquisaPorInscricao(int nrInscricao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public VwResposta3aCorrecao pesquisarProximaRespostaTerceiraCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao) {

        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("idDisciplina", (idDisciplina)));
        criteria.add(Restrictions.eq("idCurso", (idCurso)));
        criteria.add(Restrictions.eq("idProcesso", (idProcesso)));
        criteria.add(Restrictions.eq("nrQuestao", idQuestao));

        criteria.add(Restrictions.eq("flCorrigindo", false));

        criteria.add(Restrictions.sqlRestriction(" 1=1 order by random()"));

        criteria.setMaxResults(1);

        //Transaction t = this.getSessao().beginTransaction();
        List<VwResposta3aCorrecao> lista = (List<VwResposta3aCorrecao>) criteria.list();
        this.getSessao().close();

        if (lista == null) {
            return null;
        }
        if (lista.size() <= 0) {
            return null;
        }
        //t.commit();
        //this.getSessao().close();
        try {
            VwResposta3aCorrecao retorno = lista.get(0);
            retorno.getIdColaboradorAtual();
            retorno.getIdCurso();
            retorno.getIdDisciplina();
            retorno.getIdProcesso();
            //retorno.getTbRespostaImagem();
            return retorno;
        } catch (Exception ex) {
            return null;
        }
        
    }

    
}
