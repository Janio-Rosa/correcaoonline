/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import dao.RespostaDAO;
import java.util.List;
import model.TbColaborador;
import model.TbCurso;
import model.TbDisciplina;
import model.TbProcesso;
import model.TbResposta;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import util.dao.HibernateUtil;

/**
 *
 * @author Janio
 */
public class RespostaDAOImpl extends GenericDAO<TbResposta> implements RespostaDAO {

    public RespostaDAOImpl() {
        super(HibernateUtil.getSessionFactory().openSession(), TbResposta.class);
    }

    @Override
    public TbResposta pesquisarProximaResposta(int idDisciplina, int idCurso, int idProcesso) {
        //this.getSessao().lock( TbResposta.class, LockMode.UPGRADE_NOWAIT);
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("idDisciplina", (new TbDisciplina(idDisciplina))));
        criteria.add(Restrictions.eq("idCurso", (new TbCurso(idCurso))));
        criteria.add(Restrictions.eq("idProcesso", (new TbProcesso(idProcesso))));

        //Flag corrigindo - para não pegar nenhuma prova - resposta - bloqueada por outro corretor
        //Flag corrigida - para não pegar nenhuma prova - resposta - que já foi corrigida

        criteria.add(Restrictions.eq("flCorrigindo", false)); // Alterar, posteriormente, consulta do flag corrigindo
        criteria.add(Restrictions.eq("flCorrigida", false));
        criteria.add(Restrictions.eq("flDiscrepanciaCorrigida", false));
        criteria.add(Restrictions.eq("flRespostaComErro", false));

        criteria.add(Restrictions.sqlRestriction(" 1=1 order by random()"));

        criteria.setMaxResults(1);

        criteria.setLockMode(LockMode.UPGRADE_NOWAIT); //Lock

        Transaction t = this.getSessao().beginTransaction();
        List<TbResposta> lista = (List<TbResposta>) criteria.list();
        if (lista == null) {
            return null;
        }
        if (lista.size() <= 0) {
            return null;
        }
        //t.commit();
        //this.getSessao().close();
        try {
            TbResposta retorno = lista.get(0);
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

    @Override
    public TbResposta pesquisarRespostaPresaColaboradorAtual(long idColaborador) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("idColaboradorAtual", (new TbColaborador(idColaborador))));
        criteria.add(Restrictions.eq("flCorrigida", false));
        //Transaction t = this.getSessao().beginTransaction();
        List<TbResposta> lista = (List<TbResposta>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if (lista != null) {
            if (lista.size() > 0) {
                return lista.get(0);
            }
        }
        return null;
    }

    //Pendente: pesquisar discrepância
    //Pendente: pesquisar recorreção
    //Pendente: verificar tipo de correção, primeira ou segunda
    @Override
    public TbResposta atualizarFlag(TbResposta resp) {
        //Transaction t = this.getSessao().beginTransaction();
        this.getSessao().update(resp);
        //atual.update(resp);
        return resp;

    }

    @Override
    public TbResposta pesquisarPrimeiraResposta() {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.addOrder(Order.desc("idResposta"));
        criteria.setMaxResults(1);

        //Transaction t = this.getSessao().beginTransaction();
        List<TbResposta> lista = (List<TbResposta>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if (lista != null) {
            if (lista.size() > 0) {
                return lista.get(0);
            }
        }
        return null;

    }

    @Override
    public TbResposta pesquisarProximaRespostaDiscrepancia(int idDisciplina, int idCurso, int idProcesso) {
        //this.getSessao().lock( TbResposta.class, LockMode.UPGRADE_NOWAIT);
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("idDisciplina", (new TbDisciplina(idDisciplina))));
        criteria.add(Restrictions.eq("idCurso", (new TbCurso(idCurso))));
        criteria.add(Restrictions.eq("idProcesso", (new TbProcesso(idProcesso))));

        criteria.add(Restrictions.eq("flCorrigindo", false));
        criteria.add(Restrictions.eq("flDiscrepancia", true));
        criteria.add(Restrictions.eq("flDiscrepanciaCorrigida", false));
        criteria.add(Restrictions.eq("flRespostaComErro", false));

        criteria.add(Restrictions.sqlRestriction(" 1=1 order by random()"));

        criteria.setMaxResults(1);

        criteria.setLockMode(LockMode.UPGRADE_NOWAIT); //Lock

        Transaction t = this.getSessao().beginTransaction();
        List<TbResposta> lista = (List<TbResposta>) criteria.list();
        if (lista == null) {
            return null;
        }
        if (lista.size() <= 0) {
            return null;
        }
        //t.commit();
        //this.getSessao().close();
        try {
            TbResposta retorno = lista.get(0);
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

    @Override
    public TbResposta pesquisarProximaRespostaDiscrepancia(int idDisciplina, int idCurso, int idProcesso,int idQuestao) {
        //this.getSessao().lock( TbResposta.class, LockMode.UPGRADE_NOWAIT);
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("idDisciplina", (new TbDisciplina(idDisciplina))));
        criteria.add(Restrictions.eq("idCurso", (new TbCurso(idCurso))));
        criteria.add(Restrictions.eq("idProcesso", (new TbProcesso(idProcesso))));
        criteria.add(Restrictions.eq("nrQuestao", idQuestao));

        criteria.add(Restrictions.eq("flCorrigindo", false));
        criteria.add(Restrictions.eq("flDiscrepancia", true));
        criteria.add(Restrictions.eq("flDiscrepanciaCorrigida", false));
        criteria.add(Restrictions.eq("flRespostaComErro", false));

        criteria.add(Restrictions.sqlRestriction(" 1=1 order by random()"));

        criteria.setMaxResults(1);

        criteria.setLockMode(LockMode.UPGRADE_NOWAIT); //Lock

        Transaction t = this.getSessao().beginTransaction();
        List<TbResposta> lista = (List<TbResposta>) criteria.list();
        if (lista == null) {
            return null;
        }
        if (lista.size() <= 0) {
            return null;
        }
        //t.commit();
        //this.getSessao().close();
        try {
            TbResposta retorno = lista.get(0);
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
    
    @Override
    public TbResposta pesquisarProximaRespostaPrimeiraCorrecao(int idDisciplina, int idCurso, int idProcesso) {
        //this.getSessao().lock( TbResposta.class, LockMode.UPGRADE_NOWAIT);
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("idDisciplina", (new TbDisciplina(idDisciplina))));
        criteria.add(Restrictions.eq("idCurso", (new TbCurso(idCurso))));
        criteria.add(Restrictions.eq("idProcesso", (new TbProcesso(idProcesso))));

        //Flag corrigindo - para não pegar nenhuma prova - resposta - bloqueada por outro corretor
        //Flag corrigida - para não pegar nenhuma prova - resposta - que já foi corrigida

        criteria.add(Restrictions.eq("flCorrigindo", false)); // Alterar, posteriormente, consulta do flag corrigindo
        criteria.add(Restrictions.eq("flCorrigida", false));
        criteria.add(Restrictions.eq("flDiscrepanciaCorrigida", false));
        criteria.add(Restrictions.eq("flPrimeiraCorrecao", false));
        criteria.add(Restrictions.eq("flRespostaComErro", false));
        criteria.add(Restrictions.eq("flRespostaEmBranco", false)); //Modificado por Jânio em 12/11/2012 - não trazer as respostas em branco para corrigir. Este controle era feito de outra forma.
        

        criteria.add(Restrictions.sqlRestriction(" 1=1 order by random()"));

        criteria.setMaxResults(1);

        criteria.setLockMode(LockMode.UPGRADE_NOWAIT); //Lock

        Transaction t = this.getSessao().beginTransaction();
        List<TbResposta> lista = (List<TbResposta>) criteria.list();
        if (lista == null) {
            return null;
        }
        if (lista.size() <= 0) {
            return null;
        }
        //t.commit();
        //this.getSessao().close();
        try {
            TbResposta retorno = lista.get(0);
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

    @Override
    public TbResposta pesquisarProximaRespostaSegundaCorrecao(int idDisciplina, int idCurso, int idProcesso) {
        //this.getSessao().lock( TbResposta.class, LockMode.UPGRADE_NOWAIT);
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("idDisciplina", (new TbDisciplina(idDisciplina))));
        criteria.add(Restrictions.eq("idCurso", (new TbCurso(idCurso))));
        criteria.add(Restrictions.eq("idProcesso", (new TbProcesso(idProcesso))));

        //Flag corrigindo - para não pegar nenhuma prova - resposta - bloqueada por outro corretor
        //Flag corrigida - para não pegar nenhuma prova - resposta - que já foi corrigida

        criteria.add(Restrictions.eq("flCorrigindo", false)); // Alterar, posteriormente, consulta do flag corrigindo
        criteria.add(Restrictions.eq("flCorrigida", false));
        criteria.add(Restrictions.eq("flDiscrepanciaCorrigida", false));
        criteria.add(Restrictions.eq("flSegundaCorrecao", false));
        criteria.add(Restrictions.eq("flRespostaComErro", false));
        criteria.add(Restrictions.eq("flRespostaEmBranco", false)); //Modificado por Jânio em 12/11/2012 - não trazer as respostas em branco para corrigir. Este controle era feito de outra forma.

        criteria.add(Restrictions.sqlRestriction(" 1=1 order by random()"));

        criteria.setMaxResults(1);

        criteria.setLockMode(LockMode.UPGRADE_NOWAIT); //Lock

        Transaction t = this.getSessao().beginTransaction();
        List<TbResposta> lista = (List<TbResposta>) criteria.list();
        if (lista == null) {
            return null;
        }
        if (lista.size() <= 0) {
            return null;
        }
        //t.commit();
        //this.getSessao().close();
        try {
            TbResposta retorno = lista.get(0);
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

    @Override
    public List<TbResposta> pesquisarRespostasComErro() {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("flRespostaComErro", true));

        /*
        TbRespostaImagem procura = new TbRespostaImagem();
        procura.setFlRespostaEmBranco(false);
        criteria.add(Restrictions.eq("tbRespostaImagem",procura ));*/

        //Transaction t = this.getSessao().beginTransaction();
        List<TbResposta> lista = (List<TbResposta>) criteria.list();
        //t.commit();
        this.getSessao().close();
        if (lista != null) {
            if (lista.size() > 0) {
                return lista;
            }
        }
        return null;

    }

    @Override
    public int quantidadePrimeiraCorrecao(TbDisciplina idDisciplina, TbProcesso idProcesso) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("flPrimeiraCorrecao", true));
        criteria.add(Restrictions.eq("idDisciplina", idDisciplina));
        criteria.add(Restrictions.eq("idProcesso", idProcesso));
        criteria.setProjection(Projections.rowCount());
        //Transaction t = this.getSessao().beginTransaction();
        int result = 0;
        try {
            result = ((Integer) criteria.list().get(0)).intValue();
        } catch (Exception ex) {
        }
        //t.commit();
        this.getSessao().close();
        return result;
    }

    @Override
    public int quantidadeSegundaCorrecao(TbDisciplina idDisciplina, TbProcesso idProcesso) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("flSegundaCorrecao", true));
        criteria.add(Restrictions.eq("idDisciplina", idDisciplina));
        criteria.add(Restrictions.eq("idProcesso", idProcesso));
        criteria.setProjection(Projections.rowCount());
        //Transaction t = this.getSessao().beginTransaction();
        int result = 0;
        try {
            result = ((Integer) criteria.list().get(0)).intValue();
        } catch (Exception ex) {
        }
        //t.commit();
        this.getSessao().close();
        return result;
    }

    @Override
    public int quantidadeDiscrepancia(TbDisciplina idDisciplina, TbProcesso idProcesso) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("flDiscrepancia", true));
        criteria.add(Restrictions.eq("idDisciplina", idDisciplina));
        criteria.add(Restrictions.eq("idProcesso", idProcesso));
        criteria.setProjection(Projections.rowCount());
        //Transaction t = this.getSessao().beginTransaction();
        int result = 0;
        try {
            result = ((Integer) criteria.list().get(0)).intValue();
        } catch (Exception ex) {
        }
        //t.commit();
        this.getSessao().close();
        return result;
    }

    @Override
    public int quantidadeDiscrepanciaCorrigida(TbDisciplina idDisciplina, TbProcesso idProcesso) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("flDiscrepanciaCorrigida", true));
        criteria.add(Restrictions.eq("idDisciplina", idDisciplina));
        criteria.add(Restrictions.eq("idProcesso", idProcesso));
        criteria.setProjection(Projections.rowCount());
        //Transaction t = this.getSessao().beginTransaction();
        int result = 0;
        try {
            result = ((Integer) criteria.list().get(0)).intValue();
        } catch (Exception ex) {
        }
        //t.commit();
        this.getSessao().close();
        return result;
    }

    @Override
    public int quantidadeRespostasSemErro() {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        criteria.add(Restrictions.eq("flRespostaComErro", false));
        criteria.setProjection(Projections.rowCount());
        //Transaction t = this.getSessao().beginTransaction();
        int result = 0;
        try {
            result = ((Integer) criteria.list().get(0)).intValue();
        } catch (Exception ex) {
        }
        //t.commit();
        this.getSessao().close();
        return result;
    }

    @Override
    public int quantidadeProvasPorDisciplinaProcesso(int idDisciplina, int idProcesso) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("idDisciplina", (new TbDisciplina(idDisciplina))));
        criteria.add(Restrictions.eq("idProcesso", (new TbProcesso(idProcesso))));
        criteria.add(Restrictions.eq("flRespostaComErro", false));

        criteria.setProjection(Projections.rowCount());
        //Transaction t = this.getSessao().beginTransaction();

        int result = 0;

        try {
            result = ((Integer) criteria.list().get(0)).intValue();
        } catch (Exception ex) {
        }

        //t.commit();
        this.getSessao().close();
        return result;

    }

    @Override
    public TbResposta pesquisarProximaRespostaPrimeiraCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao) {
        //this.getSessao().lock( TbResposta.class, LockMode.UPGRADE_NOWAIT);
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("idDisciplina", (new TbDisciplina(idDisciplina))));
        criteria.add(Restrictions.eq("idCurso", (new TbCurso(idCurso))));
        criteria.add(Restrictions.eq("idProcesso", (new TbProcesso(idProcesso))));
        criteria.add(Restrictions.eq("nrQuestao", idQuestao));

        //Flag corrigindo - para não pegar nenhuma prova - resposta - bloqueada por outro corretor
        //Flag corrigida - para não pegar nenhuma prova - resposta - que já foi corrigida

        //criteria.add(Restrictions.eq("flCorrigindo", false)); // Alterar, posteriormente, consulta do flag corrigindo
        //criteria.add(Restrictions.eq("flCorrigida", false));
        criteria.add(Restrictions.eq("flDiscrepanciaCorrigida", false));
        criteria.add(Restrictions.eq("flPrimeiraCorrecao", false));
        criteria.add(Restrictions.eq("flRespostaComErro", false));
        criteria.add(Restrictions.eq("flRespostaEmBranco", false)); //Modificado por Jânio em 12/11/2012 - não trazer as respostas em branco para corrigir. Este controle era feito de outra forma.
        

        //criteria.add(Restrictions.sqlRestriction(" 1=1 order by random()"));
        //criteria.add(Restrictions.sqlRestriction(" 1=1 order by id_curso_ordem "));

        criteria.setMaxResults(1);

        criteria.setLockMode(LockMode.UPGRADE_NOWAIT); //Lock

        Transaction t = this.getSessao().beginTransaction();
        List<TbResposta> lista = (List<TbResposta>) criteria.list();
        if (lista == null) {
            return null;
        }
        if (lista.size() <= 0) {
            return null;
        }
        //t.commit();
        //this.getSessao().close();
        try {
            TbResposta retorno = lista.get(0);
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

    @Override
    public TbResposta pesquisarProximaRespostaSegundaCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao) {
        //this.getSessao().lock( TbResposta.class, LockMode.UPGRADE_NOWAIT);
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        //System.out.println("CONSULTA PROXIMA RESPOSTA: disc.: " + idDisciplina + " - curso: "+idCurso +" - Processo: "+idProcesso+" - idQuestao: "+idQuestao);
        criteria.add(Restrictions.eq("idDisciplina", (new TbDisciplina(idDisciplina))));
        criteria.add(Restrictions.eq("idCurso", (new TbCurso(idCurso))));
        criteria.add(Restrictions.eq("idProcesso", (new TbProcesso(idProcesso))));
        criteria.add(Restrictions.eq("nrQuestao", idQuestao));

        //Flag corrigindo - para não pegar nenhuma prova - resposta - bloqueada por outro corretor
        //Flag corrigida - para não pegar nenhuma prova - resposta - que já foi corrigida

        //criteria.add(Restrictions.eq("flCorrigindo", false)); // Alterar, posteriormente, consulta do flag corrigindo
        //criteria.add(Restrictions.eq("flCorrigida", false));
        criteria.add(Restrictions.eq("flDiscrepanciaCorrigida", false));
        criteria.add(Restrictions.eq("flSegundaCorrecao", false));
        criteria.add(Restrictions.eq("flRespostaComErro", false));
        criteria.add(Restrictions.eq("flRespostaEmBranco", false)); //Modificado por Jânio em 12/11/2012 - não trazer as respostas em branco para corrigir. Este controle era feito de outra forma.

        //criteria.add(Restrictions.sqlRestriction(" 1=1 order by random()"));
        //criteria.add(Restrictions.sqlRestriction(" 1=1 order by id_curso_ordem "));

        criteria.setMaxResults(1);

        criteria.setLockMode(LockMode.UPGRADE_NOWAIT); //Lock

        Transaction t = this.getSessao().beginTransaction();
        List<TbResposta> lista = null;
        try {
            lista = (List<TbResposta>) criteria.list();
        } catch (Exception ex) {
            return null;
        }
        if (lista == null) {
            return null;
        }
        if (lista.size() <= 0) {
            return null;
        }
        //t.commit();
        //this.getSessao().close();
        try {
            TbResposta retorno = lista.get(0);
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
    
    
    @Override
    public TbResposta pesquisarProximaRespostaSegundaCorrecaoPorQuestaoComPrimeiraCorrecao(int idDisciplina, int idCurso, int idProcesso, int idQuestao) {
        //this.getSessao().lock( TbResposta.class, LockMode.UPGRADE_NOWAIT);
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        //System.out.println("CONSULTA PROXIMA RESPOSTA: disc.: " + idDisciplina + " - curso: "+idCurso +" - Processo: "+idProcesso+" - idQuestao: "+idQuestao);
        criteria.add(Restrictions.eq("idDisciplina", (new TbDisciplina(idDisciplina))));
        criteria.add(Restrictions.eq("idCurso", (new TbCurso(idCurso))));
        criteria.add(Restrictions.eq("idProcesso", (new TbProcesso(idProcesso))));
        criteria.add(Restrictions.eq("nrQuestao", idQuestao));

        //Flag corrigindo - para não pegar nenhuma prova - resposta - bloqueada por outro corretor
        //Flag corrigida - para não pegar nenhuma prova - resposta - que já foi corrigida

        criteria.add(Restrictions.eq("flCorrigindo", false)); // Alterar, posteriormente, consulta do flag corrigindo
        criteria.add(Restrictions.eq("flCorrigida", false));
        criteria.add(Restrictions.eq("flDiscrepanciaCorrigida", false));
        criteria.add(Restrictions.eq("flSegundaCorrecao", false));
        criteria.add(Restrictions.eq("flPrimeiraCorrecao", true));
        criteria.add(Restrictions.eq("flRespostaComErro", false));
        criteria.add(Restrictions.eq("flRespostaEmBranco", false)); //Modificado por Jânio em 12/11/2012 - não trazer as respostas em branco para corrigir. Este controle era feito de outra forma.

        //criteria.add(Restrictions.sqlRestriction(" 1=1 order by random()"));
        //criteria.add(Restrictions.sqlRestriction(" 1=1 order by id_curso_ordem "));

        criteria.setMaxResults(1);

        criteria.setLockMode(LockMode.UPGRADE_NOWAIT); //Lock

        Transaction t = this.getSessao().beginTransaction();
        List<TbResposta> lista = null;
        try {
            lista = (List<TbResposta>) criteria.list();
        } catch (Exception ex) {
            return null;
        }
        if (lista == null) {
            return null;
        }
        if (lista.size() <= 0) {
            return null;
        }
        //t.commit();
        //this.getSessao().close();
        try {
            TbResposta retorno = lista.get(0);
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

    @Override
    public TbResposta pesquisarProximaRespostaPrimeiraCorrecaoPorQuestaoComSegundaCorrecao(int idDisciplina, int idCurso, int idProcesso, int idQuestao) {
        //this.getSessao().lock( TbResposta.class, LockMode.UPGRADE_NOWAIT);
        //System.out.println("Here");
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("idDisciplina", (new TbDisciplina(idDisciplina))));
        criteria.add(Restrictions.eq("idCurso", (new TbCurso(idCurso))));
        criteria.add(Restrictions.eq("idProcesso", (new TbProcesso(idProcesso))));
        criteria.add(Restrictions.eq("nrQuestao", idQuestao));

        //Flag corrigindo - para não pegar nenhuma prova - resposta - bloqueada por outro corretor
        //Flag corrigida - para não pegar nenhuma prova - resposta - que já foi corrigida

        criteria.add(Restrictions.eq("flCorrigindo", false)); // Alterar, posteriormente, consulta do flag corrigindo
        criteria.add(Restrictions.eq("flCorrigida", false));
        criteria.add(Restrictions.eq("flDiscrepanciaCorrigida", false));
        criteria.add(Restrictions.eq("flPrimeiraCorrecao", false));
        criteria.add(Restrictions.eq("flSegundaCorrecao", true)); //Busca respostas que já tenham a primeira correção feita, para que as discrepâncias apareçam mais cedo. Mas se não houver nenhuma, usa-se o método acima para pegar outra prova mesmo que não tenha a primeira correção feita.
        criteria.add(Restrictions.eq("flRespostaComErro", false));
        criteria.add(Restrictions.eq("flRespostaEmBranco", false)); //Modificado por Jânio em 12/11/2012 - não trazer as respostas em branco para corrigir. Este controle era feito de outra forma.
        

        //criteria.add(Restrictions.sqlRestriction(" 1=1 order by random()"));
        //criteria.add(Restrictions.sqlRestriction(" 1=1 order by id_curso_ordem"));
        //criteria.addOrder()

        criteria.setMaxResults(1);

        criteria.setLockMode(LockMode.UPGRADE_NOWAIT); //Lock

        Transaction t = this.getSessao().beginTransaction();
        List<TbResposta> lista = (List<TbResposta>) criteria.list();
        if (lista == null) {
            return null;
        }
        if (lista.size() <= 0) {
            return null;
        }
        //t.commit();
        //this.getSessao().close();
        try {
            TbResposta retorno = lista.get(0);
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

    @Override
    public TbResposta pesquisarProximaRespostaTerceiraCorrecaoPorQuestao(int idDisciplina, int idCurso, int idProcesso, int idQuestao) {
        //this.getSessao().lock( TbResposta.class, LockMode.UPGRADE_NOWAIT);
        //System.out.println("Here");
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());

        criteria.add(Restrictions.eq("idDisciplina", (new TbDisciplina(idDisciplina))));
        criteria.add(Restrictions.eq("idCurso", (new TbCurso(idCurso))));
        criteria.add(Restrictions.eq("idProcesso", (new TbProcesso(idProcesso))));
        criteria.add(Restrictions.eq("nrQuestao", idQuestao));

        //Flag corrigindo - para não pegar nenhuma prova - resposta - bloqueada por outro corretor
        //Flag corrigida - para não pegar nenhuma prova - resposta - que já foi corrigida

        criteria.add(Restrictions.eq("flCorrigindo", false)); // Alterar, posteriormente, consulta do flag corrigindo
        //criteria.add(Restrictions.eq("flCorrigida", false));
        //criteria.add(Restrictions.eq("flDiscrepanciaCorrigida", false));
        criteria.add(Restrictions.eq("flTerceiraCorrecao", false));
        criteria.add(Restrictions.eq("flRespostaComErro", false));
        criteria.add(Restrictions.eq("flRespostaEmBranco", false)); //Modificado por Jânio em 12/11/2012 - não trazer as respostas em branco para corrigir. Este controle era feito de outra forma.
        

        criteria.add(Restrictions.sqlRestriction(" 1=1 order by random()"));

        criteria.setMaxResults(1);

        criteria.setLockMode(LockMode.UPGRADE_NOWAIT); //Lock

        Transaction t = this.getSessao().beginTransaction();
        List<TbResposta> lista = (List<TbResposta>) criteria.list();
        if (lista == null) {
            return null;
        }
        if (lista.size() <= 0) {
            return null;
        }
        //t.commit();
        //this.getSessao().close();
        try {
            TbResposta retorno = lista.get(0);
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
