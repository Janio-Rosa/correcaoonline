/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.dao;

//import org.hibernate.cfg.AnnotationConfiguration;
import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
//import org.hibernate.cfg.Configuration;


/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author Janio
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            
            AnnotationConfiguration ac=new AnnotationConfiguration();

            
            ac.addAnnotatedClass(TbUsuario.class);
            ac.addAnnotatedClass(VwUsuarioFuncionalidade.class);
            
            ac.addAnnotatedClass(TbBanca.class);
            ac.addAnnotatedClass(TbCategoriaCriterio.class);
            ac.addAnnotatedClass(TbTipoQuestao.class);
            ac.addAnnotatedClass(TbColaborador.class);
            ac.addAnnotatedClass(TbCorrecaoCriterio.class);
            ac.addAnnotatedClass(TbCorrecao.class);
            ac.addAnnotatedClass(TbCriterio.class);
            ac.addAnnotatedClass(TbDisciplina.class);
            ac.addAnnotatedClass(TbEmpresa.class);
            ac.addAnnotatedClass(TbFuncao.class);
            ac.addAnnotatedClass(TbFuncionalidade.class);
            ac.addAnnotatedClass(TbPerfilFuncionalidade.class);
            ac.addAnnotatedClass(TbPerfilFuncionalidadePK.class);
            ac.addAnnotatedClass(TbPerfil.class);
            ac.addAnnotatedClass(TbPessoa.class);
            ac.addAnnotatedClass(TbProcesso.class);
            ac.addAnnotatedClass(TbResposta.class);
            ac.addAnnotatedClass(TbTipoCorrecao.class);
            ac.addAnnotatedClass(TbGeneroCategoria.class);
            ac.addAnnotatedClass(VwCategoriaCriterio.class);
            ac.addAnnotatedClass(VwUsuarioPerfil.class);
            ac.addAnnotatedClass(TbRespostaImagem.class);
            ac.addAnnotatedClass(TbCurso.class);
            ac.addAnnotatedClass(TbAtualizaResposta.class);
            ac.addAnnotatedClass(TbUsuarioPerfil.class);
            ac.addAnnotatedClass(TbQuestao.class);
            ac.addAnnotatedClass(VwPerfilFuncionalidade.class);
            ac.addAnnotatedClass(VwCriterioComCorrecaoCriterio.class);
            ac.addAnnotatedClass(VwPessoaColaborador.class);
            ac.addAnnotatedClass(VwPessoaUsuario.class);
            ac.addAnnotatedClass(VwRespostasComProblema.class);
            
            ac.addAnnotatedClass(VwTipoCorrecaoFeita.class);
            //ac.addAnnotatedClass(VwCorrecaoCriterio.class);
            
            ac.addAnnotatedClass(VwEstatisticaCriterioCorrecaoFeita.class);
            ac.addAnnotatedClass(VwEstatisticaCorrecaoPorCorretor.class);
            ac.addAnnotatedClass(VwCorrecaoFeitaPorCurso.class);
            
            ac.addAnnotatedClass(VwRepostaCorrecao.class);
            
            ac.addAnnotatedClass(VwProcessoDisciplina.class);
            ac.addAnnotatedClass(VwProcessoDisciplinaCorretor.class);
            ac.addAnnotatedClass(VwRespostaCorrecao.class);
            
            ac.addAnnotatedClass(VwEstatisticaCorrecaoTipoCorrecaoConsolidado.class);
            ac.addAnnotatedClass(VwConfereDiscrepancia.class);
            ac.addAnnotatedClass(VwProcessoCurso.class);
            ac.addAnnotatedClass(VwEstatisticaCorrecaoConsolidadoDisciplina.class);
            ac.addAnnotatedClass(VwConsolidadoGeralCorrecao.class);
            ac.addAnnotatedClass(VwConsolidadoGeralCorrecaoDisciplina.class);
            ac.addAnnotatedClass(VwBancaDisciplinaCurso.class);
            
            ac.addAnnotatedClass(VwDisciplinaDiscrepancia.class);
            ac.addAnnotatedClass(TbDisciplinaDiscrepancia.class);

            ac.addAnnotatedClass(TbInscricao.class);
            
            ac.addAnnotatedClass(VwUsuarioPessoa.class);

            ac.addAnnotatedClass(VwRelatorioDiscrepanciaCorretor.class);
            ac.addAnnotatedClass(VwRelatorioDiscrepanciaSintetico.class);

            ac.addAnnotatedClass(VwConsolidadoGeralCorrecaoDisciplinaQuestao.class);
            
            ac.addAnnotatedClass(VwRespostaInscricaoCorrecao.class);

            ac.addAnnotatedClass(VwColaboradorPendente.class);
            ac.addAnnotatedClass(VwColaboradorPendenteDiscrepancia.class);
            
            ac.addAnnotatedClass(VwRespostaImagem.class);

            ac.addAnnotatedClass(VwResposta1aCorrecao.class);
            ac.addAnnotatedClass(VwResposta2aCorrecao.class);
            ac.addAnnotatedClass(VwResposta3aCorrecao.class);
            
            ac.addAnnotatedClass(VwConfere1aCorrecao.class);
            ac.addAnnotatedClass(VwConfere2aCorrecao.class);
            ac.addAnnotatedClass(VwConfere3aCorrecao.class);
            ac.addAnnotatedClass(VwRelatorioNotas.class);
            
            ac.addAnnotatedClass(VwCorretorDisciplinaProcesso.class);
            
            
            sessionFactory=ac.configure().buildSessionFactory();

        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        //if(sessionFactory==null)
        return sessionFactory;
    }

    
}
