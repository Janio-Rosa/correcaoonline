/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author administrator
 */
public class HibernateCFGBackup {
    /*
    <property name="hibernate.bytecode.use_reflection_optimizer">true</property>
     * 
     * Disabling JDBC Bactch Update
     * hibernate.jdbc.batch_size=0
     * 
     * tipo BLOB : ///@Type(type="org.hibernate.type.StringClobType")
     * 
     * 
     * <property name="hibernate.jdbc.use_streams_for_binary">false</property>
     *
     * 
     * EL backup
     * #{resource['images:cloudy.gif']}
     */
    

    /*<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN" "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
  <session-factory>
    <property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
    <property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
    <property name="hibernate.connection.url">jdbc:postgresql://192.168.0.135/db_sisco_25102011</property>
    <property name="hibernate.connection.username">teste</property>
    <property name="hibernate.connection.password">teste</property>
    <property name="hibernate.show_sql">true</property>
    <property name="hibernate.current_session_context_class">thread</property>
    <property name="hibernate.use_sql_comments">true</property>
  </session-factory>
</hibernate-configuration>
*/
    
        /* Transformar imagem
   FileOutputStream fos = new FileOutputStream("C:/oi.jpg");  
   fos.write(imgBytes);  
   FileDescriptor fd = fos.getFD();  
   fos.flush();  
   fd.sync();  
   fos.close();       
     */
    
    /*
    private Image converteParaImagem(byte[] vetor){
        Image retorno=null;
        retorno = new ImageIcon(vetor).getImage();
        return retorno;
    }*/

    /*
     * FUNCIONALIDADES:     
                 2 | /view/corretor/ver_corrigidas.xhtml                              | Ver Provas Corrigidas                             |           |                      
                 3 | /view/banca/relatorio_banca.xhtml                                | Relatório de Correção                             |           |                      
                 4 | /view/banca/recorrecao.xhtml                                     | Solicita Recorreção                               |           |                      
                 5 | /view/coordenador/disciplina_processo.xhtml                      | Inserir Disciplinas para Processo                 |           |                      
                 7 | /view/coordenador/relatorio/resumo.xhtml                         | Resumo da Correção                                |           |                      
                 8 | /view/admin/cadastro/processo.xhtml                              | Cadastrar Processo                                |           |                      
                10 | /view/admin/cadastro/colaborador.xhtml                           | Cadastrar Colaborador                             |           |                      
                 9 | /view/admin/cadastro/disciplinas.xhtml                           | Cadastrar Disciplinas                             |           |                      
                13 | /view/admin/cadastro/empresa.xhtml                               | Cadastrar Empresa                                 |           |                      
                14 | /view/admin/cadastro/funcao.xhtml                                | Cadastrar Função                                  |           |                      
                15 | /view/admin/cadastro/criterio.xhtml                              | Cadastrar Critério                                |           |                      
                17 | /view/admin/cadastro/tipoCorrecao.xhtml                          | Cadastrar Tipo de Correção                        |           |                      
                16 | /view/admin/cadastro/categoriaCriterio.xhtml                     | Cadastrar Categoria do Critério                   |           |                      
                18 | /view/admin/cadastro/generoCategoria.xhtml                       | Cadastrar Gênero da Categoria                     |           |                      
                21 | /view/admin/cadastro/perfil.xhtml                                | Cadastrar Perfil                                  |           |                      
                20 | /view/admin/cadastro/funcionalidade.xhtml                        | Cadastrar Funcionalidade                          |           |                      
                22 | /view/admin/cadastro/usuarioPerfil.xhtml                         | Cadastrar Perfil do Usuário                       |           |                      
                23 | /view/admin/cadastro/banca.xhtml                                 | Cadastrar Banca                                   |           |                      
                24 | /view/admin/cadastro/tipoQuestao.xhtml                           | Cadastrar Tipo de Questão                         |           |                      
                19 | /view/admin/cadastro/perfilFuncionalidade.xhtml                  | Cadastrar Funcionalidade do Perfil                |           |                      
                11 | /view/admin/cadastro/usuario.xhtml                               | Cadastrar Usuário                                 |           |                      
                25 | /view/admin/consulta/imagemResposta.xhtml                        | Ver imagens                                       | f         |                      
                26 | /view/admin/consulta/verificarImagem.xhtml                       | Conferir Imagem                                   | f         |                      
                27 | /view/admin/consulta/imagemEmBranco.xhtml                        | Conferir Imagens em Branco                        | f         |                      
                28 | /view/banca/altera/listaRespostasComErro.xhtml                   | Imagens com Problema                              | f         |                      
                 1 | /view/corretor/redacao/corretor.xhtml                            | Corrigir Redação - Discrepâncias                  |           |                      
                29 | /view/corretor/discursiva/correcao.xhtml                         | Corrigir Discursiva - Discrepância                | f         |                      
                30 | /view/banca/rel/relatorioProvasCorrigidas.xhtml                  | Relatório de Provas Corrigidas                    | f         |                      
                31 | /view/banca/rel/estatisticaCorrecaoPorCorretor.xhtml             | Relatório de Correção por Corretor                | f         |                      
                32 | /view/banca/rel/correcaoFeitaPorCurso.xhtml                      | Relatório de Correções Feitas por Curso           | f         |                      
                33 | /view/geral/alterarSenha.xhtml                                   | Alterar Senha                                     | f         |                      
                34 | /view/banca/rel/estatisticaCriterioCorrecaoFeita.xhtml           | Relatório de Critério da Correção                 | f         |                      
                41 | /view/coordenador/rel/detalhado/consolidadoGeralProcessos2.xhtml | Relatório de Andamento da Correção por Disciplina | f         |                      
                39 | /view/coordenador/rel/detalhado/consolidadoGeralProcessos.xhtml  | Relatório de Andamento da Correção por Questão    | f         |                      
                43 | /view/admin/cadastro/disciplinaDiscrepancia.xhtml                | Controle de Discrepância                          | f         |                      
                35 | /view/coordenador/rel/detalhamento.xhtml                         | Relatório de Correção Detalhada-Redação           | f         |                      
                44 | /view/coordenador/rel/detalhamento_discursiva.xhtml              | Relatório de Correção Detalhada-Discursiva        | f         |                      
                37 | /view/banca/rel/processoDiscrepancia.xhtml                       | Relatório de Discrepância                         | f         |                      
                38 | /view/coordenador/rel/detalhado/correcaoProcessos.xhtml          | Relatório de Fechamento da Correção               | f         |                      
                45 | /view/admin/listagem/usuarioPessoa.xhtml                         | Usuário/Disciplina                                | f         |                      
                46 | /view/admin/listagem/colaboradorBanca.xhtml                      | Colaborador/Banca                                 | f         |                      
                47 | /view/coordenador/liberarprovas.xhtml                            | Libera Provas                                     |           |                      
     */
    
}
