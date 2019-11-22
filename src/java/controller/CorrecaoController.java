/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.TbCorrecao;
import model.TbCorrecaoCriterio;
import model.TbCorrecaoCriterioDigitacaoNota;
import model.TbCriterio;
import model.VwCriterioComCorrecaoCriterio;
import service.CorrecaoCriterioService;
import service.VwCriterioComCorrecaoCriterioService;
import service.impl.CorrecaoCriterioServiceImpl;
import service.impl.CorrecaoServiceImpl;
import service.impl.VwCriterioComCorrecaoCriterioServiceImpl;
import util.Uteis;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TbCategoriaCriterio;
import model.TbResposta;
import model.TbTipoCorrecao;
import model.VwRespostaImagem;
import model.VwRespostaInscricaoCorrecao;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import service.CorrecaoService;
import service.impl.CriterioServiceImpl;
import service.impl.RespostaServiceImpl;
import service.impl.VwRespostaImagemServiceImpl;

/**
 *
 * @author Janio
 */
@ManagedBean(name = "CorrecaoController")
@SessionScoped
public class CorrecaoController extends CorrecaoBasic {

    private List<VwRespostaImagem> listaImagens = null;

    //Selecionar provas pendentes conforme o tipo de correção deste colaborador
    //Colaborador pode fazer : Primeira Correção / Segunda Correção / Discrepância / Recorreção
    public CorrecaoController() {
    }
    /*Tipo_correção (1a correção / 2a correção / recorreção)
    
    categoria_criterio (Paragrafação / Ordem/ Estrutura Frase / Organização
    
     */

    public static CorrecaoController getInstance() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Object temp = session.getAttribute("CorrecaoController");
        if (temp instanceof CorrecaoController) {
            CorrecaoController pc = (CorrecaoController) temp;
            return pc;
        }
        return null;
    }

    public String corrigeCriterio(int cEscolhido) {
        boolean bolUltrapassouLimiteCategoria = false;
        TbCriterio verificaLimiteNotaCategoria = new TbCriterio();
        this.getCorrecaoCriterioAtual().setIdCriterio(new TbCriterio(cEscolhido));
        this.setMensNotaCriterio(CriterioController.getInstance().getNomeCriterioNaMemoriaById(this.getCorrecaoCriterioAtual().getIdCriterio().getIdCriterio()) + ": " + this.getCorrecaoCriterioAtual().getNotaDigitada());
        TbCriterio criterioGravar = CriterioController.getInstance().getCriterioNaMemoriaById(cEscolhido);

        /////////////////////////// -------- NOTA ----------  \\\\\\\\\\\\\\\\\\\\\\\
        if (this.getCandidatoAtual() != null) {
            if (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA_TRADUCAO_ESTILO_REDACAO) {
                //Nota já vem do banco, portanto não é preciso pegar a nota digitada. Logo não tem de fazer nada.
            } else {
                this.getCorrecaoCriterioAtual().setNrValor(this.getCorrecaoCriterioAtual().getNotaDigitada());
            }
        } else {
            this.getCorrecaoCriterioAtual().setNrValor(this.getCorrecaoCriterioAtual().getNotaDigitada());
        }

        this.getCorrecaoCriterioAtual().setNotaDigitada(0);
        if (criterioGravar != null) {
            /*if (criterioGravar.getNrValorMaximo() < this.getCorrecaoCriterioAtual().getNrValor()) {
            this.setMensNotaCriterio("Nota do critério não pode ser maior do que: " + criterioGravar.getNrValorMaximo());
            return this.paginaCorrecaoDisciplinaAtual();
            }*/
            if (criterioGravar.getNrValorMaximo() < this.getCorrecaoCriterioAtual().getNrValor()) {
                //System.out.println("PASSOU AQUI - CRITERIO: "+this.getCorrecaoCriterioAtual().getNrValor());
                //this.getCorrecaoCriterioAtual().setNrValor(this.getCorrecaoCriterioAtual().getNrValor()/10.0);
                if (criterioGravar.getNrValorMaximo() < this.getCorrecaoCriterioAtual().getNrValor()) {
                    this.setMensNotaCriterio("Nota do critério não pode ser maior do que: " + criterioGravar.getNrValorMaximo());
                    return this.paginaCorrecaoDisciplinaAtual();
                }
            }

            //Verificar limite da categoria
            
            if(this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA_TRADUCAO_ESTILO_REDACAO ){
                TbCategoriaCriterio limiteCategoria = new TbCategoriaCriterio();
                if (this.getCorrecaoAtual() != null) {
                    if (this.ultrapassouLimiteCategoria(limiteCategoria, this.getCorrecaoAtual().getIdCorrecao().longValue(), criterioGravar.getIdCriterio().intValue(), verificaLimiteNotaCategoria)) {
                        //this.setMensNotaCriterio("Nota da categoria não pode ser maior do que: " + limiteCategoria.getNrValorMaximo());
                        //return this.paginaCorrecaoDisciplinaAtual();
                        bolUltrapassouLimiteCategoria = true;
                    }
                }
            }

        }

        //Grava correção, caso não exista - cada correção possui vários critérios
        if (this.getCorrecaoAtual() == null) {
            TbCorrecao nova = new TbCorrecao();
            nova.setFlSucesso(false);
            nova.setIdColaborador(this.getColaborador());
            nova.setIdResposta(this.getCandidatoAtual());
            if (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA_TRADUCAO_ESTILO_REDACAO) {
                nova.setIdTipoCorrecao(this.getColaborador().getIdTipoCorrecao());
            } else {
                if (this.getCandidatoAtual().getFlDiscrepancia()) {
                    nova.setIdTipoCorrecao(new TbTipoCorrecao(Uteis.TIPO_CORRECAO_DISCREPANCIA));
                } else {
                    nova.setIdTipoCorrecao(this.getColaborador().getIdTipoCorrecao());
                }
            }
            CriterioController cc = CriterioController.getInstance();
            if (cc != null) {
                if (cc.getGeneroSelecionado() != null) {
                    nova.setIdGeneroCategoria(cc.getGeneroSelecionado().getIdGeneroCategoria());
                }
            }

            //if( (this.getCandidatoAtual().getFlDiscrepancia()) && (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao()==Uteis.TIPO_QUESTAO_DISCURSIVA ) && this.isBolDiscrepanciaCorretorQueCorrigiuAntes() ){
            //nova.setIdTipoCorrecao(new TbTipoCorrecao(Uteis.TIPO_CORRECAO_DISCREPANCIA));
            //}

            TbCorrecao insere = (new CorrecaoServiceImpl()).inserir(nova);
            this.setCorrecaoAtual(insere);
        }

        //Se a prova é discursiva e tem discrepância, insere a correção de discrepância
        if (this.getCandidatoAtual().getFlDiscrepancia()
                && (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DISCURSIVA
                || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA
                || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE
                || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA)) {
            if (this.getCorrecaoAtual() == null || this.getCorrecaoAtual().getIdTipoCorrecao().getIdTipoCorrecao().intValue() != Uteis.TIPO_CORRECAO_DISCREPANCIA) {
                CorrecaoService cs = new CorrecaoServiceImpl();
                List<TbCorrecao> lista = cs.pesquisarPorResposta(this.getCandidatoAtual().getIdResposta().longValue());
                TbCorrecao jaExisteDiscrepancia = cs.pesquisarPorRespostaTipoCorrecao(this.getCandidatoAtual().getIdResposta().longValue(), Uteis.TIPO_CORRECAO_DISCREPANCIA);
                if (jaExisteDiscrepancia != null) {
                    this.setCorrecaoAtual(jaExisteDiscrepancia);
                } else {
                    if (lista.size() >= 2) {
                        TbCorrecao nova = new TbCorrecao();
                        nova.setFlSucesso(false);
                        nova.setIdColaborador(this.getColaborador());
                        nova.setIdResposta(this.getCandidatoAtual());
                        if (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO
                                || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA_TRADUCAO_ESTILO_REDACAO
                                || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE) {
                            nova.setIdTipoCorrecao(this.getColaborador().getIdTipoCorrecao());
                        } else {
                            if (this.getCandidatoAtual().getFlDiscrepancia()) {
                                nova.setIdTipoCorrecao(new TbTipoCorrecao(Uteis.TIPO_CORRECAO_DISCREPANCIA));
                            } else {
                                nova.setIdTipoCorrecao(this.getColaborador().getIdTipoCorrecao());
                            }
                        }

                        TbCorrecao insere = (new CorrecaoServiceImpl()).inserir(nova);
                        this.setCorrecaoAtual(insere);
                    }
                }
            }
        }

        if (this.getCorrecaoAtual() == null) {
            this.setMensagem("Erro ao gravar correção atual - comunique imediatamente à DIRPS.");
        }
        //Grava linha + critério
        TbCorrecaoCriterio gravaCriterio = new TbCorrecaoCriterio();
        gravaCriterio.setIdCorrecao(this.getCorrecaoAtual());
        gravaCriterio.setIdCriterio(new TbCriterio(cEscolhido));
        gravaCriterio.setNrValor(this.getCorrecaoCriterioAtual().getNrValor()); //No caso da discursiva, o valor é digitado. No caso da redação, o valor vem do próprio critério previamente estabelecido
        gravaCriterio.setNrLinha(this.getLinhaSelecionada());
        //if(this.getCorrecaoCriterioAtual()!=null && this.getCorrecaoCriterioAtual().getDsJustificativa()!=null && !this.getCorrecaoCriterioAtual().getDsJustificativa().equalsIgnoreCase(""))
        //gravaCriterio.setDsJustificativa(this.getCorrecaoCriterioAtual().getDsJustificativa());
        //Apaga e insere novamente, se for discursiva. Se for redação, só insere.
        //Se for discursiva, apaga o critério atual. Pois a discursiva só grava 1 correção por critério. Ex.: candidato respondeu sobre o conflito XY: 3 pontos
        if ((this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DISCURSIVA)
                || (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA)
                || (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE)
                || (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA)) {
            //this.apagaCorrecaoCriterio(this.getCorrecaoAtual(), cEscolhido, null); // A redação é diferente, pois cada critério pode ser acionado mais de uma vez para outras linhas ou até para a mesma linha.
            //Modificação feita em 21/06/2014 para diminuir a quantidade de acesso ao banco. 
            this.apagaCorrecaoCriterioDiscursiva(this.getCorrecaoAtual(), cEscolhido, null);
        }
        try {
            if (this.getCorrecaoAtual().getIdResposta().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA_TRADUCAO_ESTILO_REDACAO) {
                if (bolUltrapassouLimiteCategoria) {
                    gravaCriterio.setNrValor(verificaLimiteNotaCategoria.getNrValorMaximo());
                }
            }
            //if(bolUltrapassouLimiteCategoria)gravaCriterio.setNrValor(0.0);
            TbCorrecaoCriterio gravacaoCrit = (new CorrecaoCriterioServiceImpl()).inserir(gravaCriterio);

            /*
            float novaNotaCorrecao=0;
            for(TbCorrecaoCriterio correcaoCriterioAtual :  (new CorrecaoCriterioServiceImpl()).pesquisarPorCorrecao(this.getCorrecaoAtual().getIdCorrecao()) ){
            novaNotaCorrecao+=correcaoCriterioAtual.getNrValor();
            }
            this.getCorrecaoAtual().setNrNota(novaNotaCorrecao);this.getCorrecaoAtual().setDtAtualizacao(new java.util.Date());
            (new CorrecaoServiceImpl()).atualizar(this.getCorrecaoAtual());
            System.out.println("Nota da correção atual: "+this.getCorrecaoAtual().getNrNota());
             */
            this.calculaNota();//Calcula a nota parcial do candidato
            //this.setMensNotaCriterio("Critério " + this.getNomeCriterioAtualSelecionado() + " gravado com sucesso. Valor: " + this.getCorrecaoCriterioAtual().getNrValor());

            if (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA_TRADUCAO_ESTILO_REDACAO) {
                this.setMensNotaCriterio("Critério: " + CriterioController.getInstance().getNomeCriterioNaMemoriaById(this.getCorrecaoCriterioAtual().getIdCriterio().getIdCriterio()) + " gravado. Perda: " + gravaCriterio.getNrValor());
            } else {
                this.setMensNotaCriterio("Critério gravado com sucesso. Nota: " + this.getCorrecaoCriterioAtual().getNrValor());
            }
            //busca lista de critérios
            CriterioController.getInstance().consultaListaCriterios(true); //É necessário recarregar os critérios a cada critério corrigido para mostrar na tela. O fato de buscar no banco para mostrar gera inclusive mais segurança, pois já serve de conferência, fazendo com que o corretor ajude a conferir o sistema.

        } catch (Exception ex) {
            Logger.getLogger(CorrecaoController.class.getName()).log(Level.SEVERE, null, ex);
            this.setMensNotaCriterio("Erro ao gravar critério " + this.getNomeCriterioAtualSelecionado() + ". Comunique à DIRPS.");
        }

        if (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() != Uteis.TIPO_QUESTAO_DOCENTE) {
            //this.atualizaRespostaAtualSemDiscrepancia(this.getCandidatoAtual().getIdResposta().longValue());
        }

        this.setCorrecaoCriterioAtual(new TbCorrecaoCriterioDigitacaoNota());

        this.atualizaBotaoEnviar();
        //this.buscaCorrecaoOutrasQuestoes();
        return this.paginaCorrecaoDisciplinaAtual();
    }

    public String atualizaJustificativaCriterio(int cEscolhido, String nomeCriterio) {
        if (this.getCorrecaoAtual() != null) {
            TbCorrecaoCriterio gravaCriterio = (new CorrecaoCriterioServiceImpl()).pesquisarPorCorrecaoCriterio(this.getCorrecaoAtual().getIdCorrecao(), new TbCriterio(cEscolhido));
            if (this.getCorrecaoCriterioAtual() != null && this.getCorrecaoCriterioAtual().getDsJustificativa() != null && !this.getCorrecaoCriterioAtual().getDsJustificativa().equalsIgnoreCase("")) {
                gravaCriterio.setDsJustificativa(this.getCorrecaoCriterioAtual().getDsJustificativa());
                if (gravaCriterio != null) {
                    (new CorrecaoCriterioServiceImpl()).atualizar(gravaCriterio);
                }
            }
        }
        return this.paginaCorrecaoDisciplinaAtual();
    }

    public String corrigeCriterio(int cEscolhido, String nomeCriterio) {
        this.getCorrecaoCriterioAtual().setIdCriterio(new TbCriterio(cEscolhido));
        this.setNomeCriterioAtualSelecionado(nomeCriterio);

        return this.corrigeCriterio(cEscolhido);
    }

    public String getNotaParcialConvertida() {
        /*
        if (this.getCandidatoAtual() != null && this.getCandidatoAtual().getIdDisciplina() != null && this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao() != null) {
            if (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA) {
                //System.out.println("Soma das notas: "+this.somaTodasNotas());
                return String.valueOf(Uteis.arredonda(this.somaTodasNotas(), 2));
            }
        }*/
        if (this.getCandidatoAtual() != null && this.getCandidatoAtual().getIdDisciplina() != null && this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao() != null) {
            if (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA) {
                return String.valueOf(Uteis.arredonda(this.somaNotasCorrecaoAtual(), 2));
            }
        }

        return String.valueOf(Uteis.arredonda(this.getNotaParcial(), 2));
    }

    public String getNotaParcialCorrecaoAtual() {
        /*
        if (this.getCandidatoAtual() != null && this.getCandidatoAtual().getIdDisciplina() != null && this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao() != null) {
            if (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA) {

                return String.valueOf(Uteis.arredonda(this.somaCorrecaoAtual(), 2));
            }
        }*/
        if (this.getCandidatoAtual() != null && this.getCandidatoAtual().getIdDisciplina() != null && this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao() != null) {
            if (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA) {
                return String.valueOf(Uteis.arredonda(this.somaNotasCorrecaoAtual(), 2));
            }
        }
        return String.valueOf(Uteis.arredonda(this.getNotaParcial(), 2));
    }

    public String corrigeCriterio(long idRespostaSelecionada, int cEscolhido, String nomeCriterio) {
        this.getCorrecaoCriterioAtual().setIdCriterio(new TbCriterio(cEscolhido));
        this.setNomeCriterioAtualSelecionado(nomeCriterio);
        //System.out.println("Corrigindo respostsa: "+idRespostaSelecionada);
        
        //return this.corrigeCriterio(this.getCandidatoAtual().getIdResposta(), cEscolhido);
        return this.corrigeCriterio(idRespostaSelecionada, cEscolhido);
    }

    /*
    public boolean isExisteCriterioNasCorrecoesFeitas(int idCriterio){
    // não será necessário usar este método - deixado como comentário caso seja preciso usar no futuro
    this.setBolExisteCriterioNasCorrecoesFeitas(false);
    for(VwCriterioComCorrecaoCriterio atual : this.getCorrecoesFeitas()){
    if(atual.getIdCriterio()==idCriterio)this.setBolExisteCriterioNasCorrecoesFeitas(true);
    }
    return this.isBolExisteCriterioNasCorrecoesFeitas();
    }*/
    public String apagaCorrecaoCriterio(int idCriterio, String nomeCriterio) {
        return this.apagaCorrecaoCriterio(this.getCorrecaoAtual(), idCriterio, nomeCriterio);
    }

    public String apagaCorrecaoCriterio(TbCorrecao correcaoCorrente, int idCriterio, String nomeCriterio) {

        CorrecaoCriterioService ccs = new CorrecaoCriterioServiceImpl();

        VwCriterioComCorrecaoCriterioService vcc = new VwCriterioComCorrecaoCriterioServiceImpl();
        VwCriterioComCorrecaoCriterio apagar = vcc.pesquisarPorCorrecaoCriterio(correcaoCorrente.getIdCorrecao(), idCriterio);

        if (apagar != null) {
            TbCorrecaoCriterio corCrit = new TbCorrecaoCriterio();
            corCrit.setIdCorrecao(correcaoCorrente);
            corCrit.setIdCriterio(new TbCriterio(idCriterio));
            corCrit.setIdCorrecaoCriterio(apagar.getIdCorrecaoCriterio().longValue());

            //System.out.println("Excluindo critério: "+idCriterio + " - "+nomeCriterio + " - " + apagar.getNmCriterio());
            ccs.apagar(corCrit);

            this.buscaCorrecaoAtual(); // Reabre a resposta atual para corrigir depois de excluído o criterio
            this.calculaNota(); // Recalcula nota depois de excluído um critério

            CriterioController.getInstance().consultaListaCriterios(true); //Reconsulta critérios para retirar os X da tela
            this.setMensNotaCriterio("Criterio, " + nomeCriterio + ", na linha " + apagar.getNrLinha() + ", excluído.");
        }
        return this.paginaCorrecaoDisciplinaAtual();
    }

    public void apagaCorrecaoCriterioDiscursiva(TbCorrecao correcaoCorrente, int idCriterio, String nomeCriterio) {

        CorrecaoCriterioService ccs = new CorrecaoCriterioServiceImpl();

        VwCriterioComCorrecaoCriterioService vcc = new VwCriterioComCorrecaoCriterioServiceImpl();
        VwCriterioComCorrecaoCriterio apagar = vcc.pesquisarPorCorrecaoCriterio(correcaoCorrente.getIdCorrecao(), idCriterio);

        if (apagar != null) {
            TbCorrecaoCriterio corCrit = new TbCorrecaoCriterio();
            corCrit.setIdCorrecao(correcaoCorrente);
            corCrit.setIdCriterio(new TbCriterio(idCriterio));
            corCrit.setIdCorrecaoCriterio(apagar.getIdCorrecaoCriterio().longValue());

            //System.out.println("Excluindo critério: "+idCriterio + " - "+nomeCriterio + " - " + apagar.getNmCriterio());
            ccs.apagar(corCrit);

            //Modificação feita em 21/06/2014 para diminuir a quantidade de acesso ao banco.
            //this.buscaCorrecaoAtual(); // Reabre a resposta atual para corrigir depois de excluído o criterio
            //this.calculaNota(); // Recalcula nota depois de excluído um critério

            //Modificação feita em 21/06/2014 para diminuir a quantidade de acesso ao banco.
            //CriterioController.getInstance().consultaListaCriterios(true); //Reconsulta critérios para retirar os X da tela
            this.setMensNotaCriterio("Criterio, " + nomeCriterio + ", na linha " + apagar.getNrLinha() + ", excluído.");
        }
    }
    
    public String apagaCorrecaoCriterioPorId(int idCriterio, String nomeCriterio, long idCorrecaoCriterio) {

        CorrecaoCriterioService ccs = new CorrecaoCriterioServiceImpl();

        VwCriterioComCorrecaoCriterioService vcc = new VwCriterioComCorrecaoCriterioServiceImpl();
        TbCorrecaoCriterio apagar = (new CorrecaoCriterioServiceImpl()).pesquisarPorIDLong(idCorrecaoCriterio);


        if (apagar != null) {
            //System.out.println("Excluindo critério: "+idCriterio + " - "+nomeCriterio + " - " + apagar.getNmCriterio());
            ccs.apagar(apagar);

            this.buscaCorrecaoAtual(); // Reabre a resposta atual para corrigir depois de excluído o criterio
            this.calculaNota(); // Recalcula nota depois de excluído um critério

            CriterioController.getInstance().consultaListaCriterios(true); //Reconsulta critérios para retirar os X da tela
            this.setMensNotaCriterio("Criterio, " + nomeCriterio + ", na linha " + apagar.getNrLinha() + ", excluído.");
        }
        return this.paginaCorrecaoDisciplinaAtual();
    }

    public String gravaRespostaCandidatoAtualProximaCorrecao() { //Grava resposta atual, encerra a correção da resposta atual, abre a próxima prova para corrigir
        //Grava correcao para a resposta atual
        this.atualizaCorrecao(true);
        //Atualiza a resposta (limpa o corretor atual), muda o flag corrigindo
        //Modificação feita em 21/06/2014 para diminuir a quantidade de acesso ao banco. 
        //this.atualizaRespostaAtual();
        
        //Verifica se já teve as duas correções - atualiza flag corrigida  - Verifica discrepância e calcula a nota final
        this.verificaDiscrepanciaCalculaNotaFinal();

        if (!this.proximaCorrecao()) {
            this.setMensagem("Correção efetuada. Não há mais provas para corrigir. Comunique o término ao coordenador ou presidente da banca.");
            return "/view/corretor/principal.xhtml";
        }

        this.setMensNotaCriterio("Correção efetuada. Prosseguindo para próxima correção.");
        this.setMensagem("Correção efetuada. Prosseguindo para próxima correção.");

        //Recarrega critérios, pois a lista de critérios é alimentada com a correção atual. Ex.: Critério - mencionou o conflito xpto de 1990 - valor 2 pontos. Se este critério já estiver sido corrigido, ele carrega a nota que já foi dada
        this.atualizaGeneroRecarregaCriterios();
        this.atualizaBotaoEnviar();

        return this.paginaCorrecaoDisciplinaAtual();
    }

    public String respostaComErroEnviarCoordenador() {

        //Atualiza resposta indicando que há erro. É necessário o coordenador verificar
        this.atualizaRespostaAtual(true);

        if (!this.proximaCorrecao()) {
            this.setMensagem("Correção efetuada. Não há mais provas para corrigir. Comunique o término ao coordenador ou presidente da banca.");
            return "/view/corretor/principal.xhtml";
        }

        return this.paginaCorrecaoDisciplinaAtual();
    }

    public String pulaRespostaAtual() { //Método usado somente para testes no momento de TREINAMENTO. Pois o corretor NÃO PODE TER A OPÇÃO de PULAR uma resposta.

        //Pula a redação atual e passa para a próxima
        this.pularRespostaAtual();

        if (!this.proximaCorrecao()) {
            this.setMensagem("Correção efetuada. Não há mais provas para corrigir. Comunique o término ao coordenador ou presidente da banca.");
            return "/view/corretor/principal.xhtml";
        }

        return this.paginaCorrecaoDisciplinaAtual();
    }

    public String gravaRespostaZeroProximaCorrecao() { //Grava resposta atual, encerra a correção da resposta atual, abre a próxima prova para corrigir
        //Grava todos os critérios como zero

        this.gravaZeroTodosOsCriterios();

        //Grava correcao para a resposta atual
        this.atualizaCorrecao(true);
        //Atualiza a resposta (limpa o corretor atual), muda o flag corrigindo
        this.atualizaRespostaAtual();
        //Verifica se já teve as duas correções - atualiza flag corrigida  - Verifica discrepância e calcula a nota final
        this.verificaDiscrepanciaCalculaNotaFinal();

        if (!this.proximaCorrecao()) {
            this.setMensagem("Correção efetuada. Não há mais provas para corrigir. Comunique o término ao coordenador ou presidente da banca.");
            return "/view/corretor/principal.xhtml";
        }

        this.setMensNotaCriterio("Correção efetuada. Prosseguindo para próxima correção.");
        this.setMensagem("Correção efetuada. Prosseguindo para próxima correção.");

        //Recarrega critérios, pois a lista de critérios é alimentada com a correção atual. Ex.: Critério - mencionou o conflito xpto de 1990 - valor 2 pontos. Se este critério já estiver sido corrigido, ele carrega a nota que já foi dada
        this.atualizaGeneroRecarregaCriterios();
        return this.paginaCorrecaoDisciplinaAtual();
    }

    private void gravaZeroTodosOsCriterios() {
        CriterioController cc = CriterioController.getInstance();
        List<VwCriterioComCorrecaoCriterio> criterio = cc.getListaCriterios();
        for (VwCriterioComCorrecaoCriterio atual : criterio) {
            this.getCorrecaoCriterioAtual().setNotaDigitada(0);
            this.corrigeCriterio(atual.getIdCriterio().intValue());

        }
    }

    private void gravaNotaMaximaTodosOsCriterios() {
        CriterioController cc = CriterioController.getInstance();
        List<VwCriterioComCorrecaoCriterio> criterio = cc.getListaCriterios();
        for (VwCriterioComCorrecaoCriterio atual : criterio) {
            String notaMaxima = String.valueOf(atual.getNrValorMaximo());
            this.getCorrecaoCriterioAtual().setNotaDigitada(Integer.valueOf(notaMaxima));
            this.corrigeCriterio(atual.getIdCriterio().intValue());

        }
    }

    public String gravaRespostaEmBranco() { //Grava resposta atual, encerra a correção da resposta atual, abre a próxima prova para corrigir
        //Grava todos os critérios como zero

        this.gravaZeroTodosOsCriterios();

        //Grava correcao para a resposta atual
        this.atualizaCorrecao(true);
        //Atualiza a resposta (limpa o corretor atual), muda o flag corrigindo
        this.atualizaRespostaAtualEmBranco(false);
        //Verifica se já teve as duas correções - atualiza flag corrigida  - Verifica discrepância e calcula a nota final
        this.verificaDiscrepanciaCalculaNotaFinal();

        if (!this.proximaCorrecao()) {
            this.setMensagem("Correção efetuada. Não há mais provas para corrigir. Comunique o término ao coordenador ou presidente da banca.");
            return "/view/corretor/principal.xhtml";
        }

        this.setMensNotaCriterio("Correção efetuada. Prosseguindo para próxima correção.");
        this.setMensagem("Correção efetuada. Prosseguindo para próxima correção.");

        //Recarrega critérios, pois a lista de critérios é alimentada com a correção atual. Ex.: Critério - mencionou o conflito xpto de 1990 - valor 2 pontos. Se este critério já estiver sido corrigido, ele carrega a nota que já foi dada
        this.atualizaGeneroRecarregaCriterios();
        return this.paginaCorrecaoDisciplinaAtual();
    }

    public String gravaRespostaComNotaMaxima() { //Grava resposta atual, encerra a correção da resposta atual, abre a próxima prova para corrigir
        //Grava todos os critérios com NOTA MÁXIMA

        this.gravaNotaMaximaTodosOsCriterios();

        //Grava correcao para a resposta atual
        this.atualizaCorrecao(true);
        //Atualiza a resposta (limpa o corretor atual), muda o flag corrigindo
        this.atualizaRespostaAtualEmBranco(false);
        //Verifica se já teve as duas correções - atualiza flag corrigida  - Verifica discrepância e calcula a nota final
        this.verificaDiscrepanciaCalculaNotaFinal();

        if (!this.proximaCorrecao()) {
            this.setMensagem("Correção efetuada. Não há mais provas para corrigir. Comunique o término ao coordenador ou presidente da banca.");
            return "/view/corretor/principal.xhtml";
        }

        this.setMensNotaCriterio("Correção efetuada. Prosseguindo para próxima correção.");
        this.setMensagem("Correção efetuada. Prosseguindo para próxima correção.");

        //Recarrega critérios, pois a lista de critérios é alimentada com a correção atual. Ex.: Critério - mencionou o conflito xpto de 1990 - valor 2 pontos. Se este critério já estiver sido corrigido, ele carrega a nota que já foi dada
        this.atualizaGeneroRecarregaCriterios();
        return this.paginaCorrecaoDisciplinaAtual();
    }

    private TbCorrecao getCorrecaoPorResposta(long idRespostaSelecionada) {
        TbCorrecao buscaCorrecao = null;
        if (this.getColaborador().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO) {
            buscaCorrecao = (new CorrecaoServiceImpl()).pesquisarPorCorrecaoColaborador(idRespostaSelecionada, this.getColaborador().getIdColaborador());
        } else {
            if (this.getCandidatoAtual().getFlDiscrepancia() != null && this.getCandidatoAtual().getFlDiscrepancia()) {
                buscaCorrecao = (new CorrecaoServiceImpl()).pesquisarPorRespostaTipoCorrecao(idRespostaSelecionada, Uteis.TIPO_CORRECAO_DISCREPANCIA);
                //if(buscaCorrecao==null){
                //    buscaCorrecao = (new CorrecaoServiceImpl()).pesquisarPorCorrecaoColaborador(idRespostaSelecionada, this.getColaborador().getIdColaborador());
                //}
            } else {
                buscaCorrecao = (new CorrecaoServiceImpl()).pesquisarPorCorrecaoColaborador(idRespostaSelecionada, this.getColaborador().getIdColaborador(), this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue());
            }
        }

        return buscaCorrecao;
    }

    private TbCorrecaoCriterio consultarCorrecaoCriterio(TbCorrecao correcaoProcurar, int idCriterioProcurar) {
        TbCriterio criterioProcurar = (new CriterioServiceImpl()).pesquisarPorID(idCriterioProcurar);
        if (criterioProcurar == null || correcaoProcurar == null) {
            return null;
        }
        TbCorrecaoCriterio correcaoCriterio = (new CorrecaoCriterioServiceImpl()).pesquisarPorCorrecaoCriterio(correcaoProcurar.getIdCorrecao(), criterioProcurar);
        //System.out.println("Correcao:"+correcaoProcurar+" Critério corrigido:"+correcaoCriterio + " Critério usado: "+criterioProcurar);
        return correcaoCriterio;
    }

    public String corrigeCriterio(long idRespostaSelecionada, int cEscolhido) {

        boolean bolUltrapassouLimiteCategoria = false;
        //TbResposta respostaCorrigir = (new RespostaServiceImpl()).pesquisarPorIDLong(this.getCandidatoAtual().getIdResposta());
        TbResposta respostaCorrigir = (new RespostaServiceImpl()).pesquisarPorIDLong(idRespostaSelecionada);

        TbCorrecao correcaoQuestaoAtual = this.getCorrecaoPorResposta(respostaCorrigir.getIdResposta());
        TbCriterio verificaLimiteNotaCategoria = new TbCriterio();
        this.getCorrecaoCriterioAtual().setIdCriterio(new TbCriterio(cEscolhido));
        this.setMensNotaCriterio(CriterioController.getInstance().getNomeCriterioNaMemoriaById(this.getCorrecaoCriterioAtual().getIdCriterio().getIdCriterio()) + ": " + this.getCorrecaoCriterioAtual().getNotaDigitada());
        TbCriterio criterioGravar = criterioGravar = CriterioController.getInstance().getCriterioNaMemoriaByIdArquitetura(cEscolhido);

        //System.out.println("CORRIGINDO RESPOSTA: "+idRespostaSelecionada+" - "+respostaCorrigir);
        //TbCorrecaoCriterio consultaCriterio = this.consultarCorrecaoCriterio(correcaoQuestaoAtual,cEscolhido);
        //System.out.println("Correção critério encontrado: "+consultaCriterio);
        if (respostaCorrigir == null) {
            return null;
        }
        /////////////////////////// -------- NOTA ----------  \\\\\\\\\\\\\\\\\\\\\\\
        if (respostaCorrigir.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA_TRADUCAO_ESTILO_REDACAO) {
            //Nota já vem do banco, portanto não é preciso pegar a nota digitada. Logo não tem de fazer nada.
        } else {
            this.getCorrecaoCriterioAtual().setNrValor(this.getCorrecaoCriterioAtual().getNotaDigitada());
        }
        this.getCorrecaoCriterioAtual().setNotaDigitada(0);
        if (criterioGravar != null) {
            if (criterioGravar.getNrValorMaximo() < this.getCorrecaoCriterioAtual().getNrValor()) {
                this.getCorrecaoCriterioAtual().setNrValor(this.getCorrecaoCriterioAtual().getNrValor() / 10.0);
                if (criterioGravar.getNrValorMaximo() < this.getCorrecaoCriterioAtual().getNrValor()) {
                    this.setMensNotaCriterio("Nota do critério não pode ser maior do que: " + criterioGravar.getNrValorMaximo());
                    return this.paginaCorrecaoDisciplinaAtual();
                }
            }

            //Verificar limite da categoria
            TbCategoriaCriterio limiteCategoria = new TbCategoriaCriterio();
            if (correcaoQuestaoAtual != null) {
                long idCorrecao = correcaoQuestaoAtual.getIdCorrecao().longValue();

                if (this.ultrapassouLimiteCategoria(limiteCategoria, idCorrecao, criterioGravar.getIdCriterio().intValue(), verificaLimiteNotaCategoria)) {
                    //this.setMensNotaCriterio("Nota da categoria não pode ser maior do que: " + limiteCategoria.getNrValorMaximo());
                    //return this.paginaCorrecaoDisciplinaAtual();
                    bolUltrapassouLimiteCategoria = true;
                }
            }

        }

        //Grava correção, caso não exista - cada correção possui vários critérios
        if (correcaoQuestaoAtual == null) {
            //System.out.println("Inserindo correção");
            TbCorrecao nova = new TbCorrecao();
            nova.setFlSucesso(false);
            nova.setIdColaborador(this.getColaborador());
            nova.setIdResposta(respostaCorrigir);
            if (respostaCorrigir.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO
                    || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA
                    || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA_TRADUCAO_ESTILO_REDACAO) {
                nova.setIdTipoCorrecao(this.getColaborador().getIdTipoCorrecao());
            } else {
                if (respostaCorrigir != null && respostaCorrigir.getFlDiscrepancia()) {
                    nova.setIdTipoCorrecao(new TbTipoCorrecao(Uteis.TIPO_CORRECAO_DISCREPANCIA));
                } else {
                    if (this.getCandidatoAtual().getFlDiscrepancia() != null && this.getCandidatoAtual().getFlDiscrepancia()) {
                        nova.setIdTipoCorrecao(new TbTipoCorrecao(Uteis.TIPO_CORRECAO_DISCREPANCIA));
                    } else {
                        nova.setIdTipoCorrecao(this.getColaborador().getIdTipoCorrecao());
                    }

                }
            }
            CriterioController cc = CriterioController.getInstance();
            if (cc != null) {
                if (cc.getGeneroSelecionado() != null) {
                    nova.setIdGeneroCategoria(cc.getGeneroSelecionado().getIdGeneroCategoria());
                }
            }


            TbCorrecao insere = (new CorrecaoServiceImpl()).inserir(nova);
            this.setCorrecaoAtual(insere);
            correcaoQuestaoAtual = insere;
        }
        //System.out.println("Criterio: "+criterioGravar+" Correção: "+correcaoQuestaoAtual+" Resposta: "+respostaCorrigir);

        //Se a prova é discursiva e tem discrepância, insere a correção de discrepância
        if (respostaCorrigir != null) {
            if (respostaCorrigir.getIdDisciplina() != null && respostaCorrigir.getFlDiscrepancia() != null && respostaCorrigir.getFlDiscrepancia()
                    && (respostaCorrigir.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DISCURSIVA
                    || respostaCorrigir.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA
                    || respostaCorrigir.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE
                    || respostaCorrigir.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA)) {
                if (correcaoQuestaoAtual == null || correcaoQuestaoAtual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() != Uteis.TIPO_CORRECAO_DISCREPANCIA) {
                    CorrecaoService cs = new CorrecaoServiceImpl();
                    List<TbCorrecao> lista = cs.pesquisarPorResposta(respostaCorrigir.getIdResposta().longValue());
                    TbCorrecao jaExisteDiscrepancia = cs.pesquisarPorRespostaTipoCorrecao(respostaCorrigir.getIdResposta().longValue(), Uteis.TIPO_CORRECAO_DISCREPANCIA);
                    if (jaExisteDiscrepancia != null) {
                        this.setCorrecaoAtual(jaExisteDiscrepancia);
                    } else {
                        if (lista.size() >= 2) {
                            TbCorrecao nova = new TbCorrecao();
                            nova.setFlSucesso(false);
                            nova.setIdColaborador(this.getColaborador());
                            nova.setIdResposta(respostaCorrigir);

                            CriterioController cc = CriterioController.getInstance();
                            if (cc != null) {
                                if (cc.getGeneroSelecionado() != null) {
                                    nova.setIdGeneroCategoria(cc.getGeneroSelecionado().getIdGeneroCategoria());
                                }
                            }

                            if (respostaCorrigir.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO
                                    || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE
                                    || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA
                                    || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA_TRADUCAO_ESTILO_REDACAO) {
                                nova.setIdTipoCorrecao(this.getColaborador().getIdTipoCorrecao());
                            } else {
                                if (respostaCorrigir.getFlDiscrepancia()) {
                                    nova.setIdTipoCorrecao(new TbTipoCorrecao(Uteis.TIPO_CORRECAO_DISCREPANCIA));
                                } else {
                                    nova.setIdTipoCorrecao(this.getColaborador().getIdTipoCorrecao());
                                }
                            }

                            TbCorrecao insere = (new CorrecaoServiceImpl()).inserir(nova);
                            this.setCorrecaoAtual(insere);
                        }
                    }
                }
            }
        }
        if (correcaoQuestaoAtual == null) {
            this.setMensagem("Erro ao gravar correção atual - comunique imediatamente à DIRPS.");
        }
        //Grava linha + critério
        TbCorrecaoCriterio gravaCriterio = new TbCorrecaoCriterio();
        gravaCriterio.setIdCorrecao(correcaoQuestaoAtual);
        gravaCriterio.setIdCriterio(new TbCriterio(cEscolhido));
        gravaCriterio.setNrValor(this.getCorrecaoCriterioAtual().getNrValor()); //No caso da discursiva, o valor é digitado. No caso da redação, o valor vem do próprio critério previamente estabelecido
        gravaCriterio.setNrLinha(this.getLinhaSelecionada());
        //Apaga e insere novamente, se for discursiva. Se for redação, só insere.
        //Se for discursiva, apaga o critério atual. Pois a discursiva só grava 1 correção por critério. Ex.: candidato respondeu sobre o conflito XY: 3 pontos
        if ((respostaCorrigir.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DISCURSIVA)
                || (respostaCorrigir.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA)
                || (respostaCorrigir.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE)
                || (respostaCorrigir.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA)) {
            //Modificação feita em 21/06/2014 para diminuir a quantidade de acesso ao banco. 
            //this.apagaCorrecaoCriterio(correcaoQuestaoAtual, cEscolhido, null); // A redação é diferente, pois cada critério pode ser acionado mais de uma vez para outras linhas ou até para a mesma linha.
            this.apagaCorrecaoCriterioDiscursiva(correcaoQuestaoAtual, cEscolhido, null); // A redação é diferente, pois cada critério pode ser acionado mais de uma vez para outras linhas ou até para a mesma linha.
            
        }
        try {
            if (correcaoQuestaoAtual.getIdResposta().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA_TRADUCAO_ESTILO_REDACAO) {
                if (bolUltrapassouLimiteCategoria) {
                    gravaCriterio.setNrValor(verificaLimiteNotaCategoria.getNrValorMaximo());
                }
            }

            TbCorrecaoCriterio gravacaoCrit = (new CorrecaoCriterioServiceImpl()).inserir(gravaCriterio);

            //Atualiza correção atual
            float novaNotaCorrecao = 0;
            for (TbCorrecaoCriterio correcaoCriterioAtual : (new CorrecaoCriterioServiceImpl()).pesquisarPorCorrecao(correcaoQuestaoAtual.getIdCorrecao())) {
                novaNotaCorrecao += correcaoCriterioAtual.getNrValor();
            }
            correcaoQuestaoAtual.setNrNota(novaNotaCorrecao);
            correcaoQuestaoAtual.setDtAtualizacao(new java.util.Date());
            (new CorrecaoServiceImpl()).atualizar(correcaoQuestaoAtual);

            this.calculaNota();//Calcula a nota parcial do candidato
            //this.setMensNotaCriterio("Critério " + this.getNomeCriterioAtualSelecionado() + " gravado com sucesso. Valor: " + this.getCorrecaoCriterioAtual().getNrValor());

            if (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() != Uteis.TIPO_QUESTAO_RECACAO
                    && this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() != Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA_TRADUCAO_ESTILO_REDACAO) {
                if (this.getCandidatoAtual().getFlDiscrepancia() != null && this.getCandidatoAtual().getFlDiscrepancia()) {
                    this.atualizaRespostaAtualDiscrepancia(respostaCorrigir.getIdResposta().longValue());
                } else {
                    this.atualizaRespostaAtualSemDiscrepancia(respostaCorrigir.getIdResposta().longValue());
                }
            }

            if (respostaCorrigir.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA_TRADUCAO_ESTILO_REDACAO) {
                this.setMensNotaCriterio("Critério: " + CriterioController.getInstance().getNomeCriterioNaMemoriaById(this.getCorrecaoCriterioAtual().getIdCriterio().getIdCriterio()) + " gravado. Perda: " + gravaCriterio.getNrValor());
            } else {
                this.setMensNotaCriterio("Critério gravado com sucesso. Nota: " + this.getCorrecaoCriterioAtual().getNrValor());
            }
            //busca lista de critérios
            CriterioController.getInstance().consultaListaCriterios(true); //É necessário recarregar os critérios a cada critério corrigido para mostrar na tela. O fato de buscar no banco para mostrar gera inclusive mais segurança, pois já serve de conferência, fazendo com que o corretor ajude a conferir o sistema.

        } catch (Exception ex) {
            Logger.getLogger(CorrecaoController.class.getName()).log(Level.SEVERE, null, ex);
            this.setMensNotaCriterio("Erro ao gravar critério " + this.getNomeCriterioAtualSelecionado() + ". Comunique à DIRPS.");
        }

        this.setCorrecaoCriterioAtual(new TbCorrecaoCriterioDigitacaoNota());

        //this.atualizaBotaoEnviar();
        this.buscaCorrecaoOutrasQuestoes();
        return this.paginaCorrecaoDisciplinaAtual();
    }

    public StreamedContent getImagensCandidatoAtualQ1(long idResposta) {
        this.consultaImagens(idResposta);
        for (VwRespostaImagem imagemAtual : listaImagens) {
            if (imagemAtual != null && imagemAtual.getNrOrdem() != null) {
                if (imagemAtual.getNrOrdem() == Uteis.QUESTAO1) {
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ2(long idResposta) {
        this.consultaImagens(idResposta);
        for (VwRespostaImagem imagemAtual : listaImagens) {
            if (imagemAtual != null && imagemAtual.getNrOrdem() != null) {
                if (imagemAtual.getNrOrdem() == Uteis.QUESTAO2) {
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ3(long idResposta) {
        this.consultaImagens(idResposta);
        for (VwRespostaImagem imagemAtual : listaImagens) {
            if (imagemAtual != null && imagemAtual.getNrOrdem() != null) {
                if (imagemAtual.getNrOrdem() == Uteis.QUESTAO3) {
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ4(long idResposta) {
        this.consultaImagens(idResposta);
        for (VwRespostaImagem imagemAtual : listaImagens) {
            if (imagemAtual != null && imagemAtual.getNrOrdem() != null) {
                if (imagemAtual.getNrOrdem() == Uteis.QUESTAO4) {
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ5(long idResposta) {
        this.consultaImagens(idResposta);
        for (VwRespostaImagem imagemAtual : listaImagens) {
            if (imagemAtual != null && imagemAtual.getNrOrdem() != null) {
                if (imagemAtual.getNrOrdem() == Uteis.QUESTAO5) {
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ6(long idResposta) {
        this.consultaImagens(idResposta);
        for (VwRespostaImagem imagemAtual : listaImagens) {
            if (imagemAtual != null && imagemAtual.getNrOrdem() != null) {
                if (imagemAtual.getNrOrdem() == Uteis.QUESTAO6) {
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ7(long idResposta) {
        this.consultaImagens(idResposta);
        for (VwRespostaImagem imagemAtual : listaImagens) {
            if (imagemAtual != null && imagemAtual.getNrOrdem() != null) {
                if (imagemAtual.getNrOrdem() == Uteis.QUESTAO7) {
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ8(long idResposta) {
        this.consultaImagens(idResposta);
        for (VwRespostaImagem imagemAtual : listaImagens) {
            if (imagemAtual != null && imagemAtual.getNrOrdem() != null) {
                if (imagemAtual.getNrOrdem() == Uteis.QUESTAO8) {
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ9(long idResposta) {
        this.consultaImagens(idResposta);
        for (VwRespostaImagem imagemAtual : listaImagens) {
            if (imagemAtual != null && imagemAtual.getNrOrdem() != null) {
                if (imagemAtual.getNrOrdem() == Uteis.QUESTAO9) {
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ10(long idResposta) {
        this.consultaImagens(idResposta);
        for (VwRespostaImagem imagemAtual : listaImagens) {
            if (imagemAtual != null && imagemAtual.getNrOrdem() != null) {
                if (imagemAtual.getNrOrdem() == Uteis.QUESTAO10) {
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ11(long idResposta) {
        this.consultaImagens(idResposta);
        for (VwRespostaImagem imagemAtual : listaImagens) {
            if (imagemAtual != null && imagemAtual.getNrOrdem() != null) {
                if (imagemAtual.getNrOrdem() == Uteis.QUESTAO11) {
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ1() {
        if (this.getCandidatoAtual() != null) {
            return this.getImagensCandidatoAtualQ1(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ2() {
        if (this.getCandidatoAtual() != null) {
            return this.getImagensCandidatoAtualQ2(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ3() {
        if (this.getCandidatoAtual() != null) {
            return this.getImagensCandidatoAtualQ3(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ4() {
        if (this.getCandidatoAtual() != null) {
            return this.getImagensCandidatoAtualQ4(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ5() {
        if (this.getCandidatoAtual() != null) {
            return this.getImagensCandidatoAtualQ5(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ6() {
        if (this.getCandidatoAtual() != null) {
            return this.getImagensCandidatoAtualQ6(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ7() {
        if (this.getCandidatoAtual() != null) {
            return this.getImagensCandidatoAtualQ7(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ8() {
        if (this.getCandidatoAtual() != null) {
            return this.getImagensCandidatoAtualQ8(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ9() {
        if (this.getCandidatoAtual() != null) {
            return this.getImagensCandidatoAtualQ9(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ10() {
        if (this.getCandidatoAtual() != null) {
            return this.getImagensCandidatoAtualQ10(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ11() {
        if (this.getCandidatoAtual() != null) {
            return this.getImagensCandidatoAtualQ11(this.getCandidatoAtual().getIdResposta());
        }
        return null;
    }

    public void consultaImagens(long idResposta) {
        if (this.listaImagens == null || (this.respostaDiferente(idResposta))) {
            this.listaImagens = (new VwRespostaImagemServiceImpl()).pesquisarPorIdResposta(idResposta);
        }
    }

    public List<VwRespostaImagem> getListaImagens() {
        return listaImagens;
    }

    public void setListaImagens(List<VwRespostaImagem> listaImagens) {
        this.listaImagens = listaImagens;
    }

    private boolean respostaDiferente(long idResposta) {
        for (VwRespostaImagem imagemAtual : listaImagens) {
            if (imagemAtual.getIdResposta().longValue() != idResposta) {
                return true;
            }
        }
        return false;
    }

    private double somaTodasNotas() {
        double p = 0, s = 0, d = 0;
        for (VwRespostaInscricaoCorrecao atual : this.getListaRespostasQuestoes()) {
            for (TbCorrecao correcaoAtual : new CorrecaoServiceImpl().pesquisarPorResposta(atual.getIdResposta().longValue())) {
                if (correcaoAtual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO) {
                    p += correcaoAtual.getNrNota();
                } else if (correcaoAtual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO) {
                    s += correcaoAtual.getNrNota();
                } else if (correcaoAtual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_DISCREPANCIA) {
                    d = correcaoAtual.getNrNota();
                }
            }
        }
        if (d != 0) {
            return d;
        }
        return (p + s) / 2;
    }
    private double somaNotasCorrecaoAtual() {
        double p = 0, s = 0, d = 0;
        TbCorrecao correcaoAtual=null;
        if( this.getCandidatoAtual()!=null && this.getCandidatoAtual().getIdResposta()!=null   &&  this.getColaborador()!=null && this.getColaborador().getIdColaborador()!=null){
            correcaoAtual=new CorrecaoServiceImpl().pesquisarPorCorrecaoColaborador(this.getCandidatoAtual().getIdResposta().longValue(), this.getColaborador().getIdColaborador().longValue()) ;
            if(correcaoAtual!=null)return correcaoAtual.getNrNota();
        }
        return 0;
    }

    private float somaCorrecaoAtual() {
        float soma = 0;
        for (VwRespostaInscricaoCorrecao atual : this.getListaRespostasQuestoes()) {
            for (TbCorrecao correcaoAtual : new CorrecaoServiceImpl().pesquisarPorResposta(atual.getIdResposta().longValue())) {
                if (correcaoAtual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO || correcaoAtual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO) {
                    if (correcaoAtual.getIdColaborador().getIdColaborador().longValue() == this.getColaborador().getIdColaborador().longValue()) {
                        soma += correcaoAtual.getNrNota();
                    }
                } else if (correcaoAtual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_DISCREPANCIA) {
                    //do nothing for while
                }
            }
        }

        return soma;
    }
}
