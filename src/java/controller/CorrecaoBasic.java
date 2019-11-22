/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.TbAtualizaResposta;
import model.TbCategoriaCriterio;
import model.TbColaborador;
import model.TbCorrecao;
import model.TbCorrecaoCriterio;
import model.TbCorrecaoCriterioDigitacaoNota;
import model.TbCriterio;
import model.TbInscricao;
import model.TbLinha;
import model.TbResposta;
import model.TbTipoCorrecao;
import model.TbTipoQuestao;
import model.VwColaboradorPendente;
import model.VwColaboradorPendenteDiscrepancia;
import model.VwCriterioComCorrecaoCriterio;
import model.VwRespostaInscricaoCorrecao;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import service.AtualizaRespostaService;
import service.CategoriaCriterioService;
import service.ColaboradorService;
import service.CorrecaoCriterioService;
import service.CorrecaoService;
import service.DisciplinaDiscrepanciaService;
import service.RespostaService;
import service.impl.AtualizaRespostaServiceImpl;
import service.impl.CategoriaCriterioServiceImpl;
import service.impl.ColaboradorServiceImpl;
import service.impl.CorrecaoCriterioServiceImpl;
import service.impl.CorrecaoServiceImpl;
import service.impl.CriterioServiceImpl;
import service.impl.DisciplinaDiscrepanciaServiceImpl;
import service.impl.RespostaServiceImpl;
import service.impl.TbInscricaoServiceImpl;
import service.impl.VwColaboradorPendenteDiscrepanciaServiceImpl;
import service.impl.VwColaboradorPendenteServiceImpl;
import service.impl.VwCriterioComCorrecaoCriterioServiceImpl;
import service.impl.VwEstatisticaCorrecaoPorCorretorServiceImpl;
import service.impl.VwResposta1aCorrecaoServiceImpl;
import service.impl.VwResposta2aCorrecaoServiceImpl;
import service.impl.VwResposta3aCorrecaoServiceImpl;
import service.impl.VwRespostaInscricaoServiceImpl;
import util.Uteis;

/**
 *
 * @author Janio
 */
public class CorrecaoBasic extends BasicController {

    private double notaParcial = 0.0;
    private String MensNotaCriterio = "";
    public static final int NUMERO_LINHAS = 36;
    private TbResposta candidatoAtual = new TbResposta();
    private List<TbCorrecaoCriterio> notasLinhas = new ArrayList<TbCorrecaoCriterio>();
    //private TbCorrecaoCriterio correcaoCriterioAtual = new TbCorrecaoCriterio();
    private TbCorrecaoCriterioDigitacaoNota correcaoCriterioAtual = new TbCorrecaoCriterioDigitacaoNota();
    private String nomeCriterioAtualSelecionado = "";
    private TbTipoCorrecao tipoCorrecao = new TbTipoCorrecao();
    private TbTipoQuestao tipoQuestao = new TbTipoQuestao();
    private TbColaborador colaborador = new TbColaborador();
    private TbCorrecao correcaoAtual = new TbCorrecao();
    private boolean erroBuscarInformacoesProibirCorrecao = false;
    private boolean bolRespostaEncontrada = false;
    private boolean bolDiscrepanciaCorretorQueCorrigiuAntes = false;
    private boolean bolExisteCriterioNasCorrecoesFeitas = false;
    private int quantidadeProvasCorrigidas = 0;
    private boolean bolMostraBotaoEnviar = false;
    private int linhaSelecionada = 1;
    List<TbCorrecaoCriterio> criteriosCorrigidosCorrecaoAtual = null;
    List<VwRespostaInscricaoCorrecao> listaRespostasQuestoes = null;
    TbResposta outraQuestaoCandidatoAtual = new TbResposta();
    List<TbResposta> listaQuestoesCandidatoAtual = new ArrayList<TbResposta>();
    private TbInscricao inscricaoCandidatoAtual = new TbInscricao();

    public CorrecaoBasic() {
        this.getCorrecaoCriterioAtual().setNrLinha(1);
        this.getCorrecaoCriterioAtual().setIdCriterio(new TbCriterio());
        this.setErroBuscarInformacoesProibirCorrecao(false);
        this.consultaColaborador();
        this.consultaProximaResposta();
        this.consultaInscricaoCandidatoAtual();
        /*
        if(this.getCandidatoAtual()!=null){
        Uteis.Redireciona(this.paginaCorrecaoDisciplinaAtual());
        }*/
    }

    public TbResposta getCandidatoAtual() {
        return candidatoAtual;
    }

    public void setCandidatoAtual(TbResposta candidatoAtual) {
        this.candidatoAtual = candidatoAtual;
    }

    public TbColaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(TbColaborador colaborador) {
        this.colaborador = colaborador;
    }

    public TbCorrecao getCorrecaoAtual() {
        return correcaoAtual;
    }

    public void setCorrecaoAtual(TbCorrecao correcaoAtual) {
        this.correcaoAtual = correcaoAtual;
    }

    public final TbCorrecaoCriterioDigitacaoNota getCorrecaoCriterioAtual() {
        return correcaoCriterioAtual;
    }

    public void setCorrecaoCriterioAtual(TbCorrecaoCriterioDigitacaoNota correcaoCriterioAtual) {
        this.correcaoCriterioAtual = correcaoCriterioAtual;
    }

    public List<TbCorrecaoCriterio> getNotasLinhas() {
        return notasLinhas;
    }

    public void setNotasLinhas(List<TbCorrecaoCriterio> notasLinhas) {
        this.notasLinhas = notasLinhas;
    }

    public TbTipoCorrecao getTipoCorrecao() {
        return tipoCorrecao;
    }

    public void setTipoCorrecao(TbTipoCorrecao tipoCorrecao) {
        this.tipoCorrecao = tipoCorrecao;
    }

    public String getMensNotaCriterio() {
        return MensNotaCriterio;
    }

    public void setMensNotaCriterio(String MensNotaAtribuida) {
        this.MensNotaCriterio = MensNotaAtribuida;
        this.setMensagem(MensNotaAtribuida);
    }

    public String mudaLinha() {
        //this.setMensNotaAtribuida(CriterioController.getInstance().getNomeCriterioNaMemoriaById(this.getCorrecaoCriterioAtual().getIdCriterio())  +": "+this.getCorrecaoCriterioAtual().getNrValor());
        //this.setLinhaSelecionada(this.getCorrecaoCriterioAtual().getNrLinha());
        return this.paginaCorrecaoDisciplinaAtual();
    }

    public List<TbLinha> getListaLinhas() {

        List<TbCorrecaoCriterio> listaCorrecoes = null;
        List<TbLinha> retorno = new ArrayList<TbLinha>();

        if (this.getCorrecaoAtual() != null) {
            listaCorrecoes = (new CorrecaoCriterioServiceImpl()).pesquisarPorCorrecao(this.getCorrecaoAtual().getIdCorrecao());
            //listaCorrecoes = this.getCriteriosCorrigidosCorrecaoAtual();
        }

        for (int k = 1; k < NUMERO_LINHAS + 1; k++) { //30 linhas
            TbLinha novaLinha = new TbLinha(k);
            novaLinha.setBolPossuiMarcacao(false);
            if (listaCorrecoes != null) {
                for (TbCorrecaoCriterio atual : listaCorrecoes) {
                    if (atual.getNrLinha() == k) {
                        novaLinha.setBolPossuiMarcacao(true);
                    }
                }
            }
            retorno.add(novaLinha);
        }

        return retorno;
    }

    public TbTipoQuestao getTipoQuestao() {
        return tipoQuestao;
    }

    public void setTipoQuestao(TbTipoQuestao tipoQuestao) {
        this.tipoQuestao = tipoQuestao;
    }

    private void consultaColaborador() {
        UsuarioController uc = UsuarioController.getInstance();
        if (uc != null && uc.getColaboradorLogado() != null) {
            this.setColaborador(uc.getColaboradorLogado());
            return;
        }
        ColaboradorService cs = new ColaboradorServiceImpl();
        if (UsuarioController.getInstance() == null) {
            return;
        }
        //this.setColaborador(cs.pesquisarPorCPF(UsuarioController.getInstance().getUsuario().getNrCpf()));
        //BUSCA DE COLABORADOR - ALTERADO POR JÂNIO EM 22/05/2012 - É necessário buscar somente os colaboradores ativos. Pois pode ser necessário desativar e ativar cursos
        this.setColaborador(cs.pesquisarPorCPFAtivo(UsuarioController.getInstance().getUsuario().getNrCpf()));
    }

    private TbResposta consultaProximaResposta() {
        TbResposta retorno = null;
        this.setBolMostraBotaoEnviar(false);
        boolean discrepanciaAtivada = false;

        if (this.getColaborador() == null) {
            return null;
        }

        if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_DISCREPANCIA
                && (this.getColaborador().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO
                || this.getColaborador().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE)) {
            for (int k = 0; k < Uteis.LIMITE_PROCURA_RESPOSTA; k++) {
                retorno = consultaProximaRespostaDiscrepancia();
                if (retorno != null) {
                    break;
                }
            }
        } else if (this.getColaborador().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO && (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO 
                || this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_TERCEIRA_CORRECAO
                || this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_QUARTA_CORRECAO
                || this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO)) {
            retorno = consultaProximaRespostaPrimeiraSegundaCorrecao(this.getColaborador());

            //Como pode haver alterância entre primeira e segunda correção, e, como o sistema olha somente a tabela resposta no sorteio (devido ao risco de LOCK, que tem que ser só numa tabela)
            //é preciso sortear uma prova que não tenha sido corrigida pelo mesmo corretor.
            if (retorno == null) {
                for (int k = 0; k < Uteis.LIMITE_PROCURA_RESPOSTA; k++) {
                    retorno = consultaProximaRespostaPrimeiraSegundaCorrecao(this.getColaborador());
                    if (retorno != null) {
                        break;
                    }
                }
            }

        } else { //No caso das discursivas, a discrepância deverá ir para a dupla que fez a primeira e segunda correção. Já na redação, irá para uma banca específica de discrepância
            //-------------------- CONTROLE DE DISCREPÂNCIA ---------------------------------------------------------------------\\
            //-------------------- Verifica se a discrepância está ativa para esta questão nesta disciplina ----------------------
            //SE A DISCREPÂNCIA NÃO ESTIVER ATIVADA, TRAZ RESPOSTAS NORMAIS AINDA NÃO CORRIGIDAS. CASO CONTRÁRIO, SE A DISCREPÂNCIA ESTIVER ATIVADA, TRAZ SOMENTE DISCREPÂNCIA PARA SER CORRIGIDA
            DisciplinaDiscrepanciaService dds = new DisciplinaDiscrepanciaServiceImpl();
            //Discrepância ativada
            discrepanciaAtivada = dds.verificaDiscrepanciaAtivada(this.getColaborador().getIdBanca().getIdDisciplina().getIdDisciplina().intValue(), this.getColaborador().getIdQuestao().getIdQuestao().intValue());
            if (discrepanciaAtivada) {
                for (int k = 0; k < Uteis.LIMITE_PROCURA_RESPOSTA; k++) {
                    retorno = consultaProximaRespostaDiscrepancia();
                    if (retorno != null) {
                        return retorno;
                    }
                }
                if(retorno==null){
                    List<TbColaborador> listaColaboradoresAtivos = new ColaboradorServiceImpl().pesquisarTodosPorCPF(this.getColaborador().getNrCpf().getNrCpf(), this.getColaborador().getIdProcesso());
                    for(TbColaborador atual : listaColaboradoresAtivos){
                        if(atual.getIdColaborador().longValue() !=this.getColaborador().getIdColaborador().longValue()){
                            retorno = consultaProximaRespostaDiscrepancia();
                            if(retorno!=null)return retorno;
                        }
                    }
                }
                /*
                String consultarCPF = this.getColaborador().getNrCpf().getNrCpf();
                List<VwColaboradorPendenteDiscrepancia> colaboradorPendente = (new VwColaboradorPendenteDiscrepanciaServiceImpl()).pesquisarListaPorCPFAtivo(consultarCPF);

                for (VwColaboradorPendenteDiscrepancia colAtual : colaboradorPendente) {
                    TbColaborador tentarColaboradorAtual = new ColaboradorServiceImpl().pesquisarPorIDLong(colAtual.getIdColaborador());
                    this.setColaborador(tentarColaboradorAtual);

                    TbResposta discRetorno = null;

                    if (discrepanciaAtivada || (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_DISCREPANCIA && (this.getColaborador().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO || this.getColaborador().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE))) {
                        discRetorno = consultaProximaRespostaDiscrepancia();
                    }

                    if (discRetorno != null) {
                        return discRetorno;
                    }
                }*/

            } else {
                retorno = consultaProximaRespostaPrimeiraSegundaCorrecao(this.getColaborador());
            }
        }
        if (retorno == null) {

            if (!this.acabaramProvasColaboradorAtual()) {
                boolean buscaDoProximoColaborador = false;

                String consultarCPF = this.getColaborador().getNrCpf().getNrCpf();
                boolean verificaDiscr = new DisciplinaDiscrepanciaServiceImpl().verificaDiscrepanciaAtivada(this.getColaborador().getIdBanca().getIdDisciplina().getIdDisciplina().intValue(), this.getColaborador().getIdQuestao().getIdQuestao().intValue());

                if (this.getColaborador() != null && this.getColaborador().getIdTipoCorrecao() != null && this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_DISCREPANCIA) {

                    List<VwColaboradorPendenteDiscrepancia> colaboradorPendente = (new VwColaboradorPendenteDiscrepanciaServiceImpl()).pesquisarListaPorCPFAtivo(consultarCPF);

                    for (VwColaboradorPendenteDiscrepancia colAtual : colaboradorPendente) {
                        TbColaborador tentarColaboradorAtual = new ColaboradorServiceImpl().pesquisarPorIDLong(colAtual.getIdColaborador());
                        this.setColaborador(tentarColaboradorAtual);

                        TbResposta discRetorno = null;

                        if (verificaDiscr || (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_DISCREPANCIA && (this.getColaborador().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO || this.getColaborador().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE))) {
                            discRetorno = consultaProximaRespostaDiscrepancia();
                        }

                        if (discRetorno != null) {
                            buscaDoProximoColaborador = true;
                            return discRetorno;
                            //break;
                        }
                    }

                } else {
                    List<VwColaboradorPendente> colaboradorPendente = (new VwColaboradorPendenteServiceImpl()).pesquisarListaPorCPF(consultarCPF);

                    for (VwColaboradorPendente colAtual : colaboradorPendente) {
                        TbColaborador tentarColaboradorAtual = new ColaboradorServiceImpl().pesquisarPorIDLong(colAtual.getIdColaborador());
                        this.setColaborador(tentarColaboradorAtual);

                        TbResposta respRetorno = consultaProximaRespostaPrimeiraSegundaCorrecao(this.getColaborador());
                        if (respRetorno != null) {
                            buscaDoProximoColaborador = true;
                            return respRetorno;
                            //break;
                        }

                    }

                }
                //if (!this.buscaProximoColaboradorPendente()) {
                if (!buscaDoProximoColaborador) {
                    this.setMensNotaCriterio("Não há mais respostas para serem corrigidas.");
                    this.setMensagem("Não há mais respostas para serem corrigidas.");
                    //Alterado por Jânio em 17/07/2013 - Alterar a forma como o sistema redireciona para a página principal
                    //Uteis.Redireciona("/view/corretor/principal.xhtml");
                    if ((this.getColaborador().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DISCURSIVA)
                            || (this.getColaborador().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA)
                            || (this.getColaborador().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE)
                            || (this.getColaborador().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA)) {
                        if (discrepanciaAtivada) {
                            this.setMensNotaCriterio("Discrepâncias corrigidas - solicite ao coordenador para desativar a discrepância. Em seguida entre novamente no sistema.");
                            this.setMensagem("Discrepâncias corrigidas - solicite ao coordenador para desativar a discrepância. Em seguida entre novamente no sistema.");
                        } else {
                            this.setMensNotaCriterio("Correção concluída. Peça ao coordenador para conferir as discrepâncias.");
                            this.setMensagem("Correção concluída. Peça ao coordenador para conferir as discrepâncias.");
                        }
                    } else {
                        this.setMensNotaCriterio("Não há mais respostas para serem corrigidas.");
                        this.setMensagem("Não há mais respostas para serem corrigidas.");
                    }
                } else {
                    if (!discrepanciaAtivada) {
                        return this.consultaProximaResposta();
                        //return null;
                    }
                }
            }
            //Alterado por Jânio em 17/07/2013 - Alterar a forma como o sistema redireciona para a página principal
            //Uteis.Redireciona("/view/corretor/principal.xhtml");
        }

        //this.setQuantidadeProvasCorrigidas((new VwRespostaCorrecaoServiceImpl()).quantidadePorColaborador(this.getColaborador().getIdColaborador().longValue(), this.getColaborador().getIdBanca().getIdProcesso().getIdProcesso().intValue()));
        try {
            //Alterado por Jânio em 30/06/2014 - Melhoria de performance (só fará a consulta se for correção de prova para concurso de docente)
            if(this.getColaborador().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE){
                this.setQuantidadeProvasCorrigidas((new VwEstatisticaCorrecaoPorCorretorServiceImpl()).pesquisarTotalPorCPF(this.getColaborador().getNrCpf().getNrCpf()));
                
            }else{
                int quantidadeTotal=0;
                List<TbColaborador> colCadastrado = new ColaboradorServiceImpl().pesquisarTodosPorCPF(this.getColaborador().getNrCpf().getNrCpf(),this.getColaborador().getIdProcesso());
                for(TbColaborador pesqAtual : colCadastrado){
                    quantidadeTotal+=new CorrecaoServiceImpl().quantidadePorColaboradorSemDiscrepancia(pesqAtual.getIdColaborador());
                }
                this.setQuantidadeProvasCorrigidas(quantidadeTotal);
            }
        } catch (Exception ex) {
        }

        this.enviaAvisoDiscrepancia();

        this.buscaCorrecaoOutrasQuestoes();

        //Consulta inscricao candidato atual
        if (retorno != null) {
            this.setInscricaoCandidatoAtual((new TbInscricaoServiceImpl()).pesquisarPorIDLong(retorno.getIdInscricao().longValue()));
        }

        RespostaController rc = RespostaController.getInstance();
        if (rc != null) {
            rc.setCandidatoAtual(retorno);
        }
        return retorno;
        //return this.consultaProximaResposta(0,0);
    }

    private boolean atualizaColaboradorAtualCorrecaoAtual() {
        if (this.getCandidatoAtual() != null && this.getCandidatoAtual().getIdResposta() != null) {
            TbAtualizaResposta atualiza = new TbAtualizaResposta();
            TbColaborador colAtual = new TbColaborador(this.getColaborador().getIdColaborador());

            AtualizaRespostaService ars = new AtualizaRespostaServiceImpl();
            atualiza = ars.pesquisarPorID(this.getCandidatoAtual().getIdResposta());

            atualiza.setIdColaboradorAtual(colAtual);
            atualiza.setIdResposta(this.getCandidatoAtual().getIdResposta());
            atualiza.setFlCorrigindo(true);
            atualiza.setNrNotaFinal(this.getCandidatoAtual().getNrNotaFinal());

            if (atualiza.getFlDiscrepancia() == null) {
                atualiza.setFlDiscrepancia(false);
            }
            if (atualiza.getFlDiscrepanciaCorrigida() == null) {
                atualiza.setFlDiscrepanciaCorrigida(false);
            }

            ars.atualizar(atualiza);

            //this.imagemRespostaCandidatoAtual=this.converteParaImagem(this.getCandidatoAtual().getTbRespostaImagem().getImImagemResposta());
            return true;
        }
        return false;
    }

    public boolean proximaCorrecao() {
        if (this.consultaProximaResposta() == null) {
            return false;
        }
        return true;
    }

    public StreamedContent getImagemCandidatoAtual() {
        if (this.getCandidatoAtual() == null || this.getCandidatoAtual().getTbRespostaImagem() == null) { //CANDIDATO ATUAL
            return null;
        }
        //InputStream is = new ByteArrayInputStream(this.getCandidatoAtual().getTbRespostaImagem().getImImagemResposta());
        if (this.getCandidatoAtual() == null || this.getCandidatoAtual().getTbRespostaImagem() == null) {
            return null;
        }
        if (this.getCandidatoAtual().getTbRespostaImagem().size() <= 0 || this.getCandidatoAtual().getTbRespostaImagem().get(0) == null || this.getCandidatoAtual().getTbRespostaImagem().get(0).getImImagemResposta() == null) {
            return null;
        }
        InputStream is = new ByteArrayInputStream(this.getCandidatoAtual().getTbRespostaImagem().get(0).getImImagemResposta());

        return new DefaultStreamedContent(is);
    }

    public boolean isErroBuscarInformacoesProibirCorrecao() {
        return erroBuscarInformacoesProibirCorrecao;
    }

    public final void setErroBuscarInformacoesProibirCorrecao(boolean erroBuscarInformacoesProibirCorrecao) {
        this.erroBuscarInformacoesProibirCorrecao = erroBuscarInformacoesProibirCorrecao;
    }

    private boolean verificaRestricao() {
        if (this.getColaborador() == null || this.getColaborador().getIdColaborador() == null) { //COLABORADOR
            this.setErroBuscarInformacoesProibirCorrecao(true);
            this.setMensagem("Erro ao buscar informações do colaborador.");
            return false;
        }
        if (this.getColaborador().getIdBanca() == null) { //BANCA
            this.setErroBuscarInformacoesProibirCorrecao(true);
            this.setMensagem("Erro: não foi possível definir informações da banca.");
            return false;
        }
        if (this.getColaborador().getIdBanca().getIdDisciplina() == null) { //DISCIPLINA
            this.setErroBuscarInformacoesProibirCorrecao(true);
            this.setMensagem("Erro: não foi possível definir a disciplina.");
            return false;
        }
        if (this.getColaborador().getIdBanca().getIdCurso() == null) { //CURSO
            this.setErroBuscarInformacoesProibirCorrecao(true);
            this.setMensagem("Erro: não foi possível definir o curso.");
            return false;
        }
        if (this.getColaborador().getIdProcesso() == null) { //PROCESSO
            this.setErroBuscarInformacoesProibirCorrecao(true);
            this.setMensagem("Erro: não foi possível definir o processo.");
            return false;
        }
        if (this.getColaborador().getIdTipoCorrecao() == null) { //TIPO DE CORREÇÃO: Primeira Correção / Segunda Correção / Discrepância / Recorreção
            this.setErroBuscarInformacoesProibirCorrecao(true);
            this.setMensagem("Erro: não foi possível definir o tipo de correção do colaborador.");
            return false;
        }
        return true;
    }

    protected boolean validaTipoCorrecao(TbResposta validar) {

        CorrecaoService cs = new CorrecaoServiceImpl();
        /*List<VwRespostaCorrecao> listaTemp = (new VwRespostaCorrecaoServiceImpl()).pesquisarPorIdResposta(validar.getIdResposta().longValue());
        List<TbCorrecao> atualizaListaCorrecoes = new ArrayList<TbCorrecao>();
        for(VwRespostaCorrecao atual : listaTemp){
        atualizaListaCorrecoes.add(cs.pesquisarPorIDLong(atual.getIdResposta().longValue()));
        }*/
        List<TbCorrecao> lista = cs.pesquisarPorResposta(validar.getIdResposta().intValue());
        //List<TbCorrecao> lista = atualizaListaCorrecoes;
        if (lista == null || lista.isEmpty()) { //Primeira correção - a resposta do candidato ainda não tem nenhuma correção
            //Se não for corretor de discrepância, nem de recorreção, deixa corrigir (ou seja, primeira ou segunda correção poderão corrigir)
            if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() != Uteis.TIPO_CORRECAO_DISCREPANCIA
                    && this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() != Uteis.TIPO_CORRECAO_RECORRECAO) {
                if (validar.getFlDiscrepancia()) {
                    return false;
                }
                return true;
            } else {
                return false; //Se for corretor de discrepância ou de recorreção, passa para a próxima prova (resposta)
            }
        } else {
            for (TbCorrecao corAtual : lista) {
                //Verifica se a resposta atual tem alguma correção feita pelo corretor atual.
                //Se o tipo de correção for diferente, o corretor não pode corrigir esta prova (pois um corretor só não pode ter duas correções).
                if (corAtual.getIdColaborador().getIdColaborador().longValue() == this.getColaborador().getIdColaborador().longValue()) {
                    if (corAtual.getIdTipoCorrecao() != null && corAtual.getIdTipoCorrecao().getIdTipoCorrecao() != null) {
                        if (corAtual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO ||
                                corAtual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO ||
                                corAtual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_TERCEIRA_CORRECAO ||
                                corAtual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_DISCREPANCIA ||
                                corAtual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_RECORRECAO
                                ) {

                            if (corAtual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() != this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue()) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        //Na discursiva, discrepância volta pro mesmo corretor que corrigiu antes
        this.setBolDiscrepanciaCorretorQueCorrigiuAntes(false); //O tipo de correção (Primeira Correção, segunda, etc...) é buscado do corretor atual. Mas no caso da discursiva será usado este flag para indicar se é discrepância ou não.

        //if (validar.getFlDiscrepancia()) {
        //return false;
        //}

        for (TbCorrecao atual : lista) { //Verifica se JÁ FEZ PRIMEIRA OU SEGUNDA CORREÇÃO (conforme o corretor)
            if (atual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue()) {
                if (atual.getIdColaborador().getIdColaborador().longValue() != this.getColaborador().getIdColaborador().longValue()) {
                    return false;
                }
            }
            if (validar.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO) { //se é mesmo corretor que fez esta correção, invalida. O mesmo corretor não pode corrigir 2 vezes.
                if (atual.getIdColaborador().getIdColaborador().longValue() == this.getColaborador().getIdColaborador().longValue()) {
                    return false;
                }
            } else if ((validar.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DISCURSIVA)
                    || (validar.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA)
                    || (validar.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE)
                    || (validar.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA)) {
                if (!validar.getFlDiscrepancia()) {
                    if (atual.getIdColaborador().getIdColaborador().longValue() == this.getColaborador().getIdColaborador().longValue()) {
                        //return false;
                        if (atual.getIdColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() != this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue()) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    protected boolean validaTipoCorrecaoDiscrepanciaRecorrecao(TbResposta validar) {

        CorrecaoService cs = new CorrecaoServiceImpl();
        List<TbCorrecao> lista = cs.pesquisarPorResposta(validar.getIdResposta().intValue());
        if (lista == null || lista.isEmpty()) { //Se ainda não tiveram as duas correções, só deixa corrigir se for recorreção. Pois a recorreção pode ter tido um motivo especial de ter sido solicitada
            if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_RECORRECAO) {
                return true;
            }
        }

        this.setBolDiscrepanciaCorretorQueCorrigiuAntes(false); //Diz que a discrepância pertence a um dos corretores que corrigiu antes
        //System.out.println("Validando correção: "+validar);
        //DISCREPÂNCIA: no caso da discursiva, a discrepância volta para o mesmo corretor
        //Se for discursiva, a discrepância vai para um dos corretores que a corrigiu antes
        boolean retorno=false;
        if ((validar.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DISCURSIVA)
                || (validar.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA)
                //|| (validar.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE)
                || (validar.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA)) {
            if (validar.getFlDiscrepancia() && !validar.getFlDiscrepanciaCorrigida()) {
                for (TbCorrecao atual : lista) { //DISCREPÂNCIA volta para o mesmo corretor que fez a primeira ou segunda correção. Portanto, verifica se o corretor atual JÁ FEZ PRIMEIRA OU SEGUNDA CORREÇÃO 
                    if (atual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO
                            || atual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO) {
                        if (atual.getIdColaborador().getIdColaborador().longValue() == this.getColaborador().getIdColaborador().longValue()) {
                            this.setBolDiscrepanciaCorretorQueCorrigiuAntes(true); //Discrepância pertence a um dos corretores que fizeram a correção
                            retorno=true;
                        }
                    }else if (atual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_DISCREPANCIA ){
                        this.setCorrecaoAtual(atual);
                    }
                }
                return retorno;
            } else {
                return false;
            }
        } else { //Se for redação, vai para uma banca específica de discrepância
            if ((this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_RECORRECAO)
                    || (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_DISCREPANCIA)) {
                return true;
            }
        }

        return false;
    }

    public boolean isBolRespostaEncontrada() {
        return bolRespostaEncontrada;
    }

    public void setBolRespostaEncontrada(boolean bolRespostaEncontrada) {
        this.bolRespostaEncontrada = bolRespostaEncontrada;
    }

    public String getNomeCriterioAtualSelecionado() {
        return nomeCriterioAtualSelecionado;
    }

    public void setNomeCriterioAtualSelecionado(String nomeCriterioAtualSelecionado) {
        this.nomeCriterioAtualSelecionado = nomeCriterioAtualSelecionado;
    }

    protected boolean buscaCorrecaoAtual() {
        if (this.getCandidatoAtual().getIdResposta() != null) {
            TbCorrecao cor = null;
            if (this.getCandidatoAtual().getFlDiscrepancia() || this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao()==Uteis.TIPO_CORRECAO_DISCREPANCIA) {
                cor = (new CorrecaoServiceImpl()).pesquisarPorRespostaTipoCorrecao(this.getCandidatoAtual().getIdResposta().longValue(), Uteis.TIPO_CORRECAO_DISCREPANCIA);
            } else {
                //cor = (new CorrecaoServiceImpl()).pesquisarPorCorrecaoColaborador(this.getCandidatoAtual().getIdResposta().longValue(), this.getColaborador().getIdColaborador().longValue());
                cor = (new CorrecaoServiceImpl()).pesquisarPorCorrecaoColaborador(this.getCandidatoAtual().getIdResposta().longValue(), this.getColaborador().getIdColaborador().longValue(),this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao());
                
            }
            this.setCorrecaoAtual(cor);

        } else {
            this.setCorrecaoAtual(null);
        }
        return true;
    }

    public String atualizarSessao() {
        this.setMensagem("");
        return "";
    }

    protected String calculaNota() { //Caso ja exista alguma correção atual, calcula-se a nota
        return this.calculaNota(this.getCorrecaoAtual());
    }

    protected String calculaNota(TbCorrecao atualizarEstaCorrecao) { //Caso ja exista alguma correção atual, calcula-se a nota
        if ((this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DISCURSIVA)
                || (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA)
                || (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE)
                || (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA)) {
            this.notaParcial = 0;
        } else if (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA_TRADUCAO_ESTILO_REDACAO) {
            this.notaParcial = this.getCandidatoAtual().getIdDisciplina().getNrNotaInicial();
        }
        if (atualizarEstaCorrecao != null) {


            /*
            List<VwCriterioComCorrecaoCriterio> listaCorrecoes = (new VwCriterioComCorrecaoCriterioServiceImpl()).pesquisarPorCorrecao(atualizarEstaCorrecao.getIdCorrecao());
            
            List<TbCorrecaoCriterio> criteriosCorrigidos = new ArrayList<TbCorrecaoCriterio>();
            for (VwCriterioComCorrecaoCriterio converter : listaCorrecoes) {
            TbCorrecaoCriterio adiciona = (new CorrecaoCriterioServiceImpl()).pesquisarPorIDLong(converter.getIdCorrecaoCriterio().longValue());
            criteriosCorrigidos.add(adiciona);
            }
            this.setCriteriosCorrigidosCorrecaoAtual(criteriosCorrigidos);
            
            
            
            //List<TbCorrecaoCriterio> listaCorrecoes = (new CorrecaoCriterioServiceImpl()).pesquisarPorCorrecao(atualizarEstaCorrecao.getIdCorrecao());
            
            //this.setCriteriosCorrigidosCorrecaoAtual(listaCorrecoes);
            //this.setCriteriosCorrigidosCorrecaoAtual(criteriosCorrigidos);
            
            
            if (this.getCandidatoAtual() != null) {
            this.notaParcial = (this.getCandidatoAtual() != null) ? this.getCandidatoAtual().getIdDisciplina().getNrNotaInicial() : 0;
            }
            for (TbCorrecaoCriterio atual : this.getCriteriosCorrigidosCorrecaoAtual()) {
            if (this.getCandidatoAtual().getFlDiscrepancia()) { //Se a prova tem discrepância, analisa se a correção atual é, também, de discrepância. Senão, não mostra a nota.
            if (atual.getIdCorrecao().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_DISCREPANCIA) {
            if (atual.getIdCriterio().getFlCriterioNegativo()) {
            this.notaParcial = this.notaParcial - atual.getNrValor();
            } else {
            this.notaParcial = this.notaParcial + atual.getNrValor();
            }
            }
            } else {
            if (atual.getIdCriterio().getFlCriterioNegativo()) {
            this.notaParcial = this.notaParcial - atual.getNrValor();
            } else {
            this.notaParcial = this.notaParcial + atual.getNrValor();
            }
            }
            }
            if (this.notaParcial < 0) {
            this.notaParcial = 0;
            }
            if (listaCorrecoes.size() >= 1) {
            this.atualizaCorrecao(true);
            } else {
            this.atualizaCorrecao();
            }*/
            List<VwCriterioComCorrecaoCriterio> listaCorrecoes = (new VwCriterioComCorrecaoCriterioServiceImpl()).pesquisarPorCorrecao(atualizarEstaCorrecao.getIdCorrecao());

            if (this.getCandidatoAtual() != null) {
                this.notaParcial = (this.getCandidatoAtual() != null && this.getCandidatoAtual().getIdDisciplina() != null && this.getCandidatoAtual().getIdDisciplina().getNrNotaInicial() != null) ? this.getCandidatoAtual().getIdDisciplina().getNrNotaInicial() : 0;
            }
            for (VwCriterioComCorrecaoCriterio atual : listaCorrecoes) {
                if (this.getCandidatoAtual().getFlDiscrepancia()) { //Se a prova tem discrepância, analisa se a correção atual é, também, de discrepância. Senão, não mostra a nota.
                    if (atual.getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_DISCREPANCIA) {
                        if (atual.getFlCriterioNegativo()) {
                            this.notaParcial = this.notaParcial - atual.getNrValor();
                        } else {
                            this.notaParcial = this.notaParcial + atual.getNrValor();
                        }
                    }
                } else {
                    if (atual.getFlCriterioNegativo()) {
                        this.notaParcial = this.notaParcial - atual.getNrValor();
                    } else {
                        this.notaParcial = this.notaParcial + atual.getNrValor();
                    }
                }
            }
            if (this.notaParcial < 0) {
                this.notaParcial = 0;
            }
            if (listaCorrecoes.size() >= 1) {
                //TWEAK DE PERFORMANCE REALIZADO EM 18/06/2014 - Trecho de codigo comentado para ficar mais rapido
                //this.atualizaCorrecao(true);
            } else {
                //TWEAK DE PERFORMANCE REALIZADO EM 18/06/2014 - Trecho de codigo comentado para ficar mais rapido
                //this.atualizaCorrecao();
            }

            return String.valueOf(this.notaParcial);
        } else {
            return String.valueOf(this.getCandidatoAtual().getIdDisciplina().getNrNotaInicial());
        }
    }

    public double getNotaParcial() {
        return notaParcial;
    }

    public void setNotaParcial(double notaParcial) {
        this.notaParcial = notaParcial;
    }

    protected boolean atualizaCorrecao() {
        return this.atualizaCorrecao(false);
    }

    protected boolean atualizaCorrecao(boolean atualizaFlag) {

        return this.atualizaCorrecao(this.getCorrecaoAtual(), atualizaFlag);
    }

    protected boolean atualizaCorrecao(TbCorrecao atualizarEstaCorrecao, boolean atualizaFlag) {
        if (atualizarEstaCorrecao == null) {
            return false;
        }
        atualizarEstaCorrecao.setNrNota(this.getNotaParcial());
        atualizarEstaCorrecao.setDtAtualizacao(new Date()); //Data de atualização
        atualizarEstaCorrecao.setFlSucesso(atualizaFlag);
        CriterioController cc = CriterioController.getInstance();
        if (cc != null) {
            if (cc.getGeneroSelecionado() != null) {
                atualizarEstaCorrecao.setIdGeneroCategoria(cc.getGeneroSelecionado().getIdGeneroCategoria());
            }
        }
        try {
            TbCorrecao atualiza = (new CorrecaoServiceImpl()).atualizar(atualizarEstaCorrecao);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            this.setMensagem("Erro ao atualizar a nota. Comunique à DIRPS");
            return false;
        }
    }

    protected boolean atualizaRespostaAtual() { //Gravar a resposta para ir à próxima correção
        return this.atualizaRespostaAtual(false); //Flag de erro. Ao fazer esta chamada, grava erro = false, pois não houve erro.
    }

    protected boolean atualizaRespostaAtual(boolean bolRespostaComErro) {
        TbAtualizaResposta atualizar = new TbAtualizaResposta();
        atualizar = (new AtualizaRespostaServiceImpl()).pesquisarPorID(this.getCandidatoAtual().getIdResposta());
        atualizar.setIdResposta(this.getCandidatoAtual().getIdResposta());
        atualizar.setFlCorrigindo(false);
        atualizar.setIdColaboradorAtual(null);
        if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO) {
            atualizar.setFlPrimeiraCorrecao(true);
        } else if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO) {
            atualizar.setFlSegundaCorrecao(true);
        } else if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_TERCEIRA_CORRECAO) {
            atualizar.setFlTerceiraCorrecao(true);
        }

        atualizar.setFlRespostaComErro(bolRespostaComErro);

        try {
            (new AtualizaRespostaServiceImpl()).atualizar(atualizar);
            return true;
        } catch (Exception ex) {
            this.setMensagem("Erro ao atualizar a rsposta atual.");
            return false;
        }

        /*
        if (this.getColaborador().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA) {
        try {
        
        List<VwRespostaInscricaoCorrecao> lista = null;
        VwRespostaInscricaoCorrecao inscricao = (new VwRespostaInscricaoServiceImpl()).pesquisarPorIDLong(this.getCandidatoAtual().getIdResposta().longValue());
        if (inscricao != null) {
        lista = (new VwRespostaInscricaoServiceImpl()).pesquisaPorInscricao(inscricao.getNrInscricao());
        }
        if (lista != null) {
        for (VwRespostaInscricaoCorrecao atual : lista) {
        System.out.println("Atualizando resposta: " + atual.getIdResposta() + " de " + lista.size() + " respostas.");
        double notaTotal = 0, anterior = 0;
        int quantCorrecoes = 0;
        boolean discrepancia = false, corrigida = false;
        for (TbCorrecao percorreCorrecoes : (new CorrecaoServiceImpl()).pesquisarPorResposta(atual.getIdResposta())) {
        if ((percorreCorrecoes.getIdTipoCorrecao().getIdTipoCorrecao() == Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO) || (percorreCorrecoes.getIdTipoCorrecao().getIdTipoCorrecao() == Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO)) {
        notaTotal += percorreCorrecoes.getNrNota();
        quantCorrecoes++;
        if (quantCorrecoes > 0) {
        if ((Math.abs(anterior - percorreCorrecoes.getNrNota())) > Uteis.DISCREPANCIA_ARQUITETURA) {
        discrepancia = true;
        }
        }
        anterior = percorreCorrecoes.getNrNota();
        }
        }
        corrigida = (quantCorrecoes > 1) && (!discrepancia);
        TbAtualizaResposta gravaResposta = new TbAtualizaResposta();
        gravaResposta.setIdResposta(atual.getIdResposta());
        gravaResposta.setFlCorrigindo(false);
        gravaResposta.setFlCorrigida(false);
        gravaResposta.setFlDiscrepanciaCorrigida(false);
        gravaResposta.setFlRespostaComErro(false);
        gravaResposta.setFlCorrigida(corrigida);
        gravaResposta.setIdColaboradorAtual(null);
        if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO) {
        gravaResposta.setFlPrimeiraCorrecao(true);
        if (atual.getFlSegundaCorrecao() == null || !atual.getFlSegundaCorrecao()) {
        gravaResposta.setFlSegundaCorrecao(false);
        }
        } else if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO) {
        gravaResposta.setFlSegundaCorrecao(true);
        if (atual.getFlPrimeiraCorrecao() == null || !atual.getFlPrimeiraCorrecao()) {
        gravaResposta.setFlPrimeiraCorrecao(false);
        }
        }
        if (quantCorrecoes > 0) {
        gravaResposta.setNrNotaFinal(notaTotal / quantCorrecoes);
        }
        //gravaResposta.setFlDiscrepancia(discrepancia);
        gravaResposta.setFlDiscrepancia(false);
        (new AtualizaRespostaServiceImpl()).atualizar(gravaResposta);
        }
        }
        return true;
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
        this.setMensagem("Erro ao atualizar a rsposta atual.");
        return false;
        }
        } else */

        /*
        if (this.getColaborador().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE) {
        try {
        
        List<VwRespostaInscricaoCorrecao> lista = null;
        VwRespostaInscricaoCorrecao inscricao = (new VwRespostaInscricaoServiceImpl()).pesquisarPorIDLong(this.getCandidatoAtual().getIdResposta().longValue());
        if (inscricao != null) {
        lista = (new VwRespostaInscricaoServiceImpl()).pesquisaPorInscricao(inscricao.getNrInscricao());
        }
        if (lista != null) {
        for (VwRespostaInscricaoCorrecao atual : lista) {
        //System.out.println("Atualizando resposta: " + atual.getIdResposta() + " de " + lista.size() + " respostas.");
        double notaTotal = 0, anterior = 0;
        int quantCorrecoes = 0;
        boolean discrepancia = false, corrigida = false;
        for (TbCorrecao percorreCorrecoes : (new CorrecaoServiceImpl()).pesquisarPorResposta(atual.getIdResposta())) {
        if ((percorreCorrecoes.getIdTipoCorrecao().getIdTipoCorrecao() == Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO) 
        || (percorreCorrecoes.getIdTipoCorrecao().getIdTipoCorrecao() == Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO)
        || (percorreCorrecoes.getIdTipoCorrecao().getIdTipoCorrecao() == Uteis.TIPO_CORRECAO_TERCEIRA_CORRECAO)) {
        notaTotal += percorreCorrecoes.getNrNota();
        quantCorrecoes++;
        if (quantCorrecoes > 0) {
        if ((Math.abs(anterior - percorreCorrecoes.getNrNota())) > Uteis.DISCREPANCIA_DOCENTES) {
        //discrepancia = true;
        }
        }
        anterior = percorreCorrecoes.getNrNota();
        }
        }
        corrigida = (quantCorrecoes > 1) && (!discrepancia);
        TbAtualizaResposta gravaResposta = new TbAtualizaResposta();
        gravaResposta.setIdResposta(atual.getIdResposta());
        gravaResposta.setFlCorrigindo(false);
        gravaResposta.setFlCorrigida(false);
        gravaResposta.setFlDiscrepanciaCorrigida(false);
        gravaResposta.setFlRespostaComErro(false);
        gravaResposta.setFlCorrigida(corrigida);
        gravaResposta.setIdColaboradorAtual(null);
        if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO) {
        gravaResposta.setFlPrimeiraCorrecao(true);
        if (atual.getFlSegundaCorrecao() == null || !atual.getFlSegundaCorrecao()) {
        gravaResposta.setFlSegundaCorrecao(false);
        }
        if (atual.getFlTerceiraCorrecao() == null || !atual.getFlTerceiraCorrecao()) {
        gravaResposta.setFlTerceiraCorrecao(false);
        }
        } else if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO) {
        gravaResposta.setFlSegundaCorrecao(true);
        if (atual.getFlPrimeiraCorrecao() == null || !atual.getFlPrimeiraCorrecao()) {
        gravaResposta.setFlPrimeiraCorrecao(false);
        }
        if (atual.getFlTerceiraCorrecao() == null || !atual.getFlTerceiraCorrecao()) {
        gravaResposta.setFlTerceiraCorrecao(false);
        }
        } else if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_TERCEIRA_CORRECAO) {
        gravaResposta.setFlTerceiraCorrecao(true);
        if (atual.getFlPrimeiraCorrecao() == null || !atual.getFlPrimeiraCorrecao()) {
        gravaResposta.setFlPrimeiraCorrecao(false);
        }
        if (atual.getFlSegundaCorrecao() == null || !atual.getFlSegundaCorrecao()) {
        gravaResposta.setFlSegundaCorrecao(false);
        }
        }
        if (quantCorrecoes > 0) {
        gravaResposta.setNrNotaFinal(notaTotal / quantCorrecoes);
        }
        //gravaResposta.setFlDiscrepancia(discrepancia);
        gravaResposta.setFlDiscrepancia(false);
        (new AtualizaRespostaServiceImpl()).atualizar(gravaResposta);
        }
        }
        return true;
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
        this.setMensagem("Erro ao atualizar a rsposta atual.");
        return false;
        }
        }else{
        return true;
        }*/

    }

    protected boolean atualizaRespostaAtualEmBranco(boolean bolRespostaComErro) {
        TbAtualizaResposta atualizar = new TbAtualizaResposta();
        atualizar = (new AtualizaRespostaServiceImpl()).pesquisarPorID(this.getCandidatoAtual().getIdResposta());
        atualizar.setIdResposta(this.getCandidatoAtual().getIdResposta());
        atualizar.setFlCorrigindo(false);
        atualizar.setIdColaboradorAtual(null);
        if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO) {
            atualizar.setFlPrimeiraCorrecao(true);
        } else if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO) {
            atualizar.setFlSegundaCorrecao(true);
        }
        atualizar.setFlRespostaEmBranco(true);
        atualizar.setFlRespostaComErro(bolRespostaComErro);

        try {
            (new AtualizaRespostaServiceImpl()).atualizar(atualizar);
            return true;
        } catch (Exception ex) {
            this.setMensagem("Erro ao atualizar a rsposta atual.");
            return false;
        }
    }

    protected boolean pularRespostaAtual() {
        TbAtualizaResposta atualizar = new TbAtualizaResposta();
        atualizar = (new AtualizaRespostaServiceImpl()).pesquisarPorID(this.getCandidatoAtual().getIdResposta());
        atualizar.setIdResposta(this.getCandidatoAtual().getIdResposta());
        atualizar.setFlCorrigindo(false);
        atualizar.setIdColaboradorAtual(null);
        atualizar.setFlRespostaComErro(false);

        try {
            (new AtualizaRespostaServiceImpl()).atualizar(atualizar);
            return true;
        } catch (Exception ex) {
            this.setMensagem("Erro ao atualizar a rsposta atual.");
            return false;
        }
    }

    protected boolean verificaDiscrepanciaCalculaNotaFinal() { //Gravar a resposta para ir à próxima correção
        List<TbCorrecao> listaCorrecoes = (new CorrecaoServiceImpl()).pesquisarPorResposta(this.getCandidatoAtual().getIdResposta());
        if (listaCorrecoes != null && !listaCorrecoes.isEmpty()) {
            double notaFinal = 0.0;
            int quantidade = 0; // Quantidade de correções
            double soma = 0.0;
            int prioridadeAtual = 0;
            List<Double> notas = new ArrayList<Double>();
            boolean flDiscrepancia = false;
            boolean flDiscrepanciaCorrigida = false;
            double notaDiscrepancia = 0.0;
            for (TbCorrecao atual : listaCorrecoes) {
                //if (atual.getIdTipoCorrecao().getFlSobreposicaoNota()) { //quando o flag sobreposição é true, significa que a correção foi uma discrepância ou recorreção
                if (atual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_DISCREPANCIA || atual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_RECORRECAO) {
                    if (atual.getIdTipoCorrecao().getNrPrioridade() > prioridadeAtual) { //Discrepância tem prioridade sobre as demais notas (flag sobreposicao true), mas recorreção tem prioridade sobre discrepância (além do flag, o número da prioridade é maior)
                        soma = atual.getNrNota();
                        prioridadeAtual = atual.getIdTipoCorrecao().getNrPrioridade();
                        notaDiscrepancia = atual.getNrNota();
                        flDiscrepancia = true;
                    }
                } else {
                    soma += atual.getNrNota();
                    quantidade++; // Só incrementa a quantidade quando é correção normal (1a correção ou 2a correção)

                    //Verifica se há discrepância - Compara as notas das correções para procurar se há discrepância (1a ou 2a correção) 
                    for (Double temp : notas) { //Compara nota atual com as demais para ver se tem discrepância
                        if ((this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DISCURSIVA)
                                || (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA)
                                || (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE)
                                || (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA)) {
                            if (atual.getNrNota() > 0 || temp > 0) {
                                if ((this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA)) {
                                    if ((Math.abs(atual.getNrNota() - temp) > Uteis.DISCREPANCIA_ARQUITETURA)) {
                                        flDiscrepancia = true;
                                    }

                                } else {
                                    //No caso de correção de provas para concurso de docentes, não haverá discrepância automática. Uma vez que são muitas particularidades, cada caso será analisado manualmente
                                    if(this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() != Uteis.TIPO_QUESTAO_DOCENTE){
                                        //if (((Math.abs(atual.getNrNota() - temp)) > 20.0)) {
                                        if (((Math.abs(atual.getNrNota() - temp)) > 4.0)) {
                                            flDiscrepancia = true;
                                        }
                                    }
                                }
                            }
                        } else {
                            //No caso de correção de provas para concurso de docentes, não haverá discrepância automática. Uma vez que são muitas particularidades, cada caso será analisado manualmente
                            if(this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() != Uteis.TIPO_QUESTAO_DOCENTE){
                                if (((Math.abs(atual.getNrNota() - temp)) > 4.0) || (temp == 0.0) || (atual.getNrNota() == 0.0)) {
                                    flDiscrepancia = true;
                                }
                            }
                        }
                    }
                    notas.add(atual.getNrNota());
                }
            }

            notaFinal = soma / quantidade; //Calcula a nota mesmo com discrepância. Depois a nota será sobreposta no momento da correção da discrepância
            if (!flDiscrepancia) { //Se não teve discrepância, nem recorreção, a nota é a média das outras
                notaFinal = soma / quantidade;
            } else {
                if (quantidade >= 2 && (flDiscrepancia || prioridadeAtual > 0)) { //2 correções mais a discrepância
                    if (this.getCorrecaoAtual().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_DISCREPANCIA || notaDiscrepancia > 0) {
                        flDiscrepanciaCorrigida = true;
                        notaFinal = notaDiscrepancia;
                    }
                }
            }

            TbAtualizaResposta atualizar = new TbAtualizaResposta();

            atualizar = (new AtualizaRespostaServiceImpl()).pesquisarPorID(this.getCandidatoAtual().getIdResposta());

            atualizar.setIdResposta(this.getCandidatoAtual().getIdResposta());
            atualizar.setNrNotaFinal(notaFinal);
            //No caso de correção de provas para concurso de docentes, não haverá discrepância automática. Uma vez que são muitas particularidades, cada caso será analisado manualmente
            if(this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() != Uteis.TIPO_QUESTAO_DOCENTE){
                atualizar.setFlDiscrepancia(flDiscrepancia);
            }else{
                atualizar.setFlDiscrepancia(false);
            }

            atualizar.setFlDiscrepanciaCorrigida(flDiscrepanciaCorrigida);

            atualizar.setFlCorrigindo(false); //Desprende a resposta do corretor atual
            atualizar.setIdColaboradorAtual(null);

            
            if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO) {
                atualizar.setFlPrimeiraCorrecao(true);
            } else if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO) {
                atualizar.setFlSegundaCorrecao(true);
            } else if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_TERCEIRA_CORRECAO) {
                atualizar.setFlTerceiraCorrecao(true);
            }

            //atualizar.setFlRespostaComErro(false);
            
            
            if (quantidade > 1) { //Se já teve as duas correções, a correção pode ter terminado
                if (!flDiscrepancia || flDiscrepanciaCorrigida) { //Se não teve discrepância a correção terminou. Se teve discrepância, só termina se a discrepância foi corrigida
                    atualizar.setFlCorrigida(false);
                }
            }
            (new AtualizaRespostaServiceImpl()).atualizar(atualizar);
            return true;
        } else {
            return false;
        }
    }

    public boolean isBolExisteCriterioNasCorrecoesFeitas() {
        return bolExisteCriterioNasCorrecoesFeitas;
    }

    public void setBolExisteCriterioNasCorrecoesFeitas(boolean bolExisteCriterioNasCorrecoesFeitas) {
        this.bolExisteCriterioNasCorrecoesFeitas = bolExisteCriterioNasCorrecoesFeitas;
    }

    protected boolean liberaRespostaEspecifica(long idResposta) { //Gravar a resposta para ir à próxima correção
        TbAtualizaResposta atualizar = new TbAtualizaResposta();
        atualizar = (new AtualizaRespostaServiceImpl()).pesquisarPorID(idResposta);
        atualizar.setIdResposta(idResposta);
        atualizar.setFlCorrigindo(false);
        atualizar.setIdColaboradorAtual(null);

        try {
            (new AtualizaRespostaServiceImpl()).atualizar(atualizar);
            return true;
        } catch (Exception ex) {
            this.setMensagem("Erro ao atualizar a rsposta atual.");
            return false;
        }
    }

    protected String paginaCorrecaoDisciplinaAtual() {


        UsuarioController uc = UsuarioController.getInstance();
        if (uc != null) {
            return uc.paginaCorrecaoUsuarioAtual(this.getColaborador());
        }
        this.setMensNotaCriterio("Erro ao continuar correção. Favor comunicar ao administrador do sistema.");
        this.setMensagem("Erro ao continuar correção. Favor comunicar ao administrador do sistema.");
        //Alterado por Jânio em 17/07/2013 - Alterar a forma como o sistema redireciona para a página principal
        //Uteis.Redireciona("/view/corretor/principal.xhtml");
        return "/view/corretor/principal.xhtml";
    }

    protected void atualizaGeneroRecarregaCriterios() {

        CriterioController cc = CriterioController.getInstance();
        if (cc != null) {
            cc.verificaGeneroCorrecaoAtualERecarregaCriterios();
        }
    }

    public boolean isBolDiscrepanciaCorretorQueCorrigiuAntes() {
        return bolDiscrepanciaCorretorQueCorrigiuAntes;
    }

    public void setBolDiscrepanciaCorretorQueCorrigiuAntes(boolean bolDiscrepanciaCorretorQueCorrigiuAntes) {
        this.bolDiscrepanciaCorretorQueCorrigiuAntes = bolDiscrepanciaCorretorQueCorrigiuAntes;
    }

    private boolean zeraInformacoes() {
        this.setErroBuscarInformacoesProibirCorrecao(false);
        this.setBolRespostaEncontrada(false);
        this.setMensNotaCriterio("");
        this.setMensagem("");
        this.setCorrecaoAtual(null);
        this.setCandidatoAtual(null);
        this.setCorrecaoCriterioAtual(null);
        this.correcaoCriterioAtual = new TbCorrecaoCriterioDigitacaoNota();
        this.setNotaParcial(0);
        return true;
    }

    private TbResposta consultaProximaRespostaPrimeiraSegundaCorrecao(TbColaborador colaboradorLogado) { //BUSCA RESPOSTA DO CANDIDATO PARA SER CORRIGIDA
        this.zeraInformacoes();
        //Pelo corretor se OBTÉM TODAS AS INFORMAÇÕES PARA EFETUAR CORREÇÃO: Processo, Tipo de Correção (primeira, segunda), Tipo de Questão (redação, discursiva) 
        //e Disciplina (se for redação só tem redação, mas se for Discursiva, pode ter Química, Matemática, etc...
        //Pelo login se chega ao colaborador e pelo Colaborador se obtém as informações acima
        RespostaService rs = new RespostaServiceImpl();
        if (!this.verificaRestricao()) { //Verifica se não falta informação para busca. Ex.: Falta de código de disciplina, falta de código do curso, etc...
            return null; //Verifica restrições antes de obter próxima resposta para corrigir
        }
        TbResposta retorno = rs.pesquisarRespostaPresaColaboradorAtual(colaboradorLogado.getIdColaborador()); //Correção ainda não terminada, presa ao colaborador atual
        if (retorno != null) {
            atualizaDadosAtuaisTelaPreparaCorrecaoAtual(retorno);
            return retorno;
        } else { //PRÓXIMA DISPONÍVEL - Se não tem nenhuma correção presa para o corretor atual então pega a próxima
            int idDisciplina = colaboradorLogado.getIdBanca().getIdDisciplina().getIdDisciplina();
            int idCurso = colaboradorLogado.getIdBanca().getIdCurso().getIdCurso();
            int idProcesso = colaboradorLogado.getIdProcesso().getIdProcesso();
            int idQuestao = colaboradorLogado.getIdQuestao().getIdQuestao();
            if (colaboradorLogado.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO) {
                //retorno = rs.pesquisarProximaRespostaPrimeiraCorrecao(idDisciplina, idCurso, idProcesso);
                //CONSULTA DA PRÓXIMA RESPOSTA - ALTERADO POR JÂNIO em 22/05/2012 - É necessário buscar POR QUESTÃO
                //Alterado por Jânio em 28/02/2013 - Primeiro busca as que já houveram uma correção. Se não houver nenhuma, pega as demais , mesmo que não tenha tido a correção de contrapartida
                //(procura uma segunda correção pendente, mas que já tenha primeira correção. Se não houver, busca uma outra qualquer que tenha somente segunda correção pendente).
                if (colaboradorLogado.getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE) {
                    TbResposta busca = (new VwResposta1aCorrecaoServiceImpl()).pesquisarProximaRespostaPrimeiraCorrecaoPorQuestao(idDisciplina, idCurso, idProcesso, idQuestao);
                    retorno = busca;
                } else {
                    retorno = rs.pesquisarProximaRespostaPrimeiraCorrecaoPorQuestaoComSegundaCorrecao(idDisciplina, idCurso, idProcesso, idQuestao);
                }
                if (retorno == null) {
                    //System.out.println("Resposta com segunda correção não encontrada: idDisciplina.: "+idDisciplina + " idCurso: "+idCurso + " idProcesso: "+idProcesso + " idQuestao: "+idQuestao);
                    retorno = rs.pesquisarProximaRespostaPrimeiraCorrecaoPorQuestao(idDisciplina, idCurso, idProcesso, idQuestao);
                }
            } else if (colaboradorLogado.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO) {
                //retorno = rs.pesquisarProximaRespostaSegundaCorrecao(idDisciplina, idCurso, idProcesso);
                //Alterado por Jânio em 28/02/2013 - Primeiro busca as que já houveram uma correção. Se não houver nenhuma, pega as demais , mesmo que não tenha tido a correção de contrapartida
                //(procura uma segunda correção pendente, mas que já tenha primeira correção. Se não houver, busca uma outra qualquer que tenha somente segunda correção pendente).
                if (colaboradorLogado.getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE) {
                    TbResposta busca = (new VwResposta2aCorrecaoServiceImpl()).pesquisarProximaRespostaSegundaCorrecaoPorQuestao(idDisciplina, idCurso, idProcesso, idQuestao);
                    retorno = busca;
                } else {
                    retorno = rs.pesquisarProximaRespostaSegundaCorrecaoPorQuestaoComPrimeiraCorrecao(idDisciplina, idCurso, idProcesso, idQuestao);
                }
                if (retorno == null) {
                    //System.out.println("Resposta com primeira correção não encontrada.");
                    retorno = rs.pesquisarProximaRespostaSegundaCorrecaoPorQuestao(idDisciplina, idCurso, idProcesso, idQuestao);
                }
            } else if (colaboradorLogado.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_TERCEIRA_CORRECAO) {

                if (colaboradorLogado.getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE) {

                    TbResposta busca = (new VwResposta3aCorrecaoServiceImpl()).pesquisarProximaRespostaTerceiraCorrecaoPorQuestao(idDisciplina, idCurso, idProcesso, idQuestao);
                    retorno = busca;

                } else {
                    retorno = rs.pesquisarProximaRespostaTerceiraCorrecaoPorQuestao(idDisciplina, idCurso, idProcesso, idQuestao);
                }

                if (retorno == null) {
                    retorno = rs.pesquisarProximaRespostaTerceiraCorrecaoPorQuestao(idDisciplina, idCurso, idProcesso, idQuestao);
                    //System.out.println("Resposta com primeira correção não encontrada.");
                }

            } else {
                //retorno = rs.pesquisarProximaResposta(idDisciplina, idCurso, idProcesso);
                retorno = null;
            }
        }
        if (retorno == null) {
            /*
            this.setMensNotaCriterio("Não há mais respostas para serem corrigidas.");
            this.setMensagem("Não há mais respostas para serem corrigidas.");
            Uteis.Redireciona("/correcao/view/corretor/principal.xhtml");*/
            System.out.println("Não foram encontradas mais respostas.");
            return null;
        } else { //Verifica tipo de correção conforme o Colaborador atual (primeira correção ou segunda correção)
            if (!this.validaTipoCorrecao(retorno)) { //Valida (verifica se já foi corrigida pelo corretor atual )
                this.liberaRespostaEspecifica(retorno.getIdResposta().longValue());
                /*
                this.setMensNotaCriterio("Não há mais respostas para serem corrigidas.");
                this.setMensagem("Não há mais respostas para serem corrigidas.");
                Uteis.Redireciona("/correcao/view/corretor/principal.xhtml");*/
                return null;
            }
        }
        if (retorno == null) {
            return null;
        }
        atualizaDadosAtuaisTelaPreparaCorrecaoAtual(retorno);
        return retorno;
    }

    private TbResposta consultaProximaRespostaDiscrepancia() { //BUSCA RESPOSTA DO CANDIDATO PARA SER CORRIGIDA
        this.zeraInformacoes();
        //Pelo corretor se OBTÉM TODAS AS INFORMAÇÕES PARA EFETUAR CORREÇÃO: Processo, Tipo de Correção (primeira, segunda), Tipo de Questão (redação, discursiva) 
        //e Disciplina (se for redação só tem redação, mas se for Discursiva, pode ter Química, Matemática, etc...
        //Pelo login se chega ao colaborador e pelo Colaborador se obtém as informações acima
        RespostaService rs = new RespostaServiceImpl();
        if (!this.verificaRestricao()) { //Verifica se não falta informação para busca. Ex.: Falta de código de disciplina, falta de código do curso, etc...
            return null; //Verifica restrições antes de obter próxima resposta para corrigir
        }
        TbResposta retorno = rs.pesquisarRespostaPresaColaboradorAtual(this.getColaborador().getIdColaborador()); //Correção ainda não terminada, presa ao colaborador atual
        if (retorno != null) {
            atualizaDadosAtuaisTelaPreparaCorrecaoAtual(retorno);
            return retorno;
        } else { //PRÓXIMA DISPONÍVEL - Se não tem nenhuma correção presa para o corretor atual então pega a próxima
            int idDisciplina = this.getColaborador().getIdBanca().getIdDisciplina().getIdDisciplina();
            int idCurso = this.getColaborador().getIdBanca().getIdCurso().getIdCurso();
            int idProcesso = this.getColaborador().getIdProcesso().getIdProcesso();
            int nrQuestao = this.getColaborador().getIdQuestao().getIdQuestao();
            //retorno = rs.pesquisarProximaRespostaDiscrepancia(idDisciplina, idCurso, idProcesso);
            System.out.println("Procurando discrepância. Disc:" + idDisciplina + " - Curso: " + idCurso + " - Processo: " + idProcesso + " Questão: " + nrQuestao);
            retorno = rs.pesquisarProximaRespostaDiscrepancia(idDisciplina, idCurso, idProcesso, nrQuestao);
        }
        if (retorno == null) {
            //if(!this.acabaramProvasColaboradorAtual()){
            //    return this.consultaProximaRespostaDiscrepancia();
            //}
            return null;
        } else { //Verifica tipo de correção conforme o Colaborador atual (primeira correção ou segunda correção)
            if (!this.validaTipoCorrecaoDiscrepanciaRecorrecao(retorno)) { //Valida (verifica se já foi corrigida pelo corretor atual )
                this.liberaRespostaEspecifica(retorno.getIdResposta().longValue());
                return null;
            }
        }
        if (retorno == null) {
            return null;
        }
        atualizaDadosAtuaisTelaPreparaCorrecaoAtual(retorno);
        return retorno;
    }

    private void atualizaDadosAtuaisTelaPreparaCorrecaoAtual(TbResposta atual) {
        this.setCandidatoAtual(atual);
        buscaCorrecaoAtual(); //Busca correção atual , caso exista
        this.atualizaColaboradorAtualCorrecaoAtual();
        this.getCorrecaoCriterioAtual().setNrLinha(1);
        this.setBolRespostaEncontrada(true);
        this.calculaNota();
        this.consultaInscricaoCandidatoAtual();
    }

    public List<TbCorrecao> getListaCorrecoes() {
        List<TbCorrecao> retorno = null;
        try {
            //retorno = new 
            retorno = (new CorrecaoServiceImpl()).pesquisarPorResposta(this.getCandidatoAtual().getIdResposta().longValue());

        } catch (Exception ex) {
        }
        return retorno;
    }

    public int getQuantidadeProvasCorrigidas() {
        return quantidadeProvasCorrigidas;
    }

    public void setQuantidadeProvasCorrigidas(int quantidadeProvasCorrigidas) {
        this.quantidadeProvasCorrigidas = quantidadeProvasCorrigidas;
    }

    public boolean isBolMostraBotaoEnviar() {
        return bolMostraBotaoEnviar;
    }

    public void setBolMostraBotaoEnviar(boolean bolMostraBotaoEnviar) {
        this.bolMostraBotaoEnviar = bolMostraBotaoEnviar;
    }

    protected void atualizaBotaoEnviar() {
        CriterioController cc = CriterioController.getInstance();

        if (cc != null) {
            List<VwCriterioComCorrecaoCriterio> lista = cc.getListaCriterios();
            if (lista != null && lista.size() > 0) {
                boolean todos = true;
                for (VwCriterioComCorrecaoCriterio atual : lista) {
                    if (!atual.isExisteCorrecaoCriterio()) {
                        todos = false;
                        break;
                    }
                }
                if(this.getCorrecaoAtual()!=null && this.getCorrecaoAtual().getIdTipoCorrecao()!=null && this.getCorrecaoAtual().getIdTipoCorrecao().getIdTipoCorrecao()!=null && 
                        this.getCorrecaoAtual().getIdTipoCorrecao().getIdTipoCorrecao().intValue()==Uteis.TIPO_CORRECAO_DISCREPANCIA){
                    this.setBolMostraBotaoEnviar(true);
                }else{
                    this.setBolMostraBotaoEnviar(todos);
                }
            } else {
                this.setBolMostraBotaoEnviar(false);
            }

        } else {
            this.setBolMostraBotaoEnviar(false);
        }
    }
//CriterioController.getInstance()
    protected boolean ultrapassouLimiteCategoriaSemConsultarBanco(TbCategoriaCriterio retorna, long idCorrecao, int criterioAtual, TbCriterio verificaLimiteCategoriaAtual) {
        CorrecaoCriterioService ccs = new CorrecaoCriterioServiceImpl();
        List<TbCorrecaoCriterio> lista = ccs.pesquisarPorCorrecao(idCorrecao);
        TbCriterio criterioAPesquisar = (new CriterioServiceImpl()).pesquisarPorID(criterioAtual);
        if (criterioAPesquisar == null) {
            return false;
        }
        double notaDada = 0.0;
        for (TbCorrecaoCriterio atual : lista) {
            if (atual.getIdCriterio().getIdCategoriaCriterio() == criterioAPesquisar.getIdCategoriaCriterio()) {
                notaDada += atual.getNrValor();
            }
        }

        CategoriaCriterioService cs = new CategoriaCriterioServiceImpl();
        TbCategoriaCriterio cat = cs.pesquisarPorID(criterioAPesquisar.getIdCategoriaCriterio());
        if (cat == null) {
            return false;
        }
        retorna.setNrValorMaximo(cat.getNrValorMaximo());
        //return (notaDada>=cat.getNrValorMaximo());
        verificaLimiteCategoriaAtual.setNrValorMaximo(0.0);
        if (notaDada >= cat.getNrValorMaximo()) {
            return true;
        }
        if ((notaDada + criterioAPesquisar.getNrValorMaximo()) > cat.getNrValorMaximo()) {
            verificaLimiteCategoriaAtual.setNrValorMaximo(cat.getNrValorMaximo() - notaDada);
            return true;
        }
        return false;
    }
    
    protected boolean ultrapassouLimiteCategoria(TbCategoriaCriterio retorna, long idCorrecao, int criterioAtual, TbCriterio verificaLimiteCategoriaAtual) {
        CorrecaoCriterioService ccs = new CorrecaoCriterioServiceImpl();
        List<TbCorrecaoCriterio> lista = ccs.pesquisarPorCorrecao(idCorrecao);
        TbCriterio criterioAPesquisar = (new CriterioServiceImpl()).pesquisarPorID(criterioAtual);
        if (criterioAPesquisar == null) {
            return false;
        }
        double notaDada = 0.0;
        for (TbCorrecaoCriterio atual : lista) {
            if (atual.getIdCriterio().getIdCategoriaCriterio() == criterioAPesquisar.getIdCategoriaCriterio()) {
                notaDada += atual.getNrValor();
            }
        }

        CategoriaCriterioService cs = new CategoriaCriterioServiceImpl();
        TbCategoriaCriterio cat = cs.pesquisarPorID(criterioAPesquisar.getIdCategoriaCriterio());
        if (cat == null) {
            return false;
        }
        retorna.setNrValorMaximo(cat.getNrValorMaximo());
        //return (notaDada>=cat.getNrValorMaximo());
        verificaLimiteCategoriaAtual.setNrValorMaximo(0.0);
        if (notaDada >= cat.getNrValorMaximo()) {
            return true;
        }
        if ((notaDada + criterioAPesquisar.getNrValorMaximo()) > cat.getNrValorMaximo()) {
            verificaLimiteCategoriaAtual.setNrValorMaximo(cat.getNrValorMaximo() - notaDada);
            return true;
        }
        return false;
    }

    public int getLinhaSelecionada() {
        return linhaSelecionada;
    }

    public void setLinhaSelecionada(int linhaSelecionada) {
        this.linhaSelecionada = linhaSelecionada;
    }

    public List<TbCorrecaoCriterio> getCriteriosCorrigidosCorrecaoAtual() {
        return criteriosCorrigidosCorrecaoAtual;
    }

    public void setCriteriosCorrigidosCorrecaoAtual(List<TbCorrecaoCriterio> criteriosCorrigidosCorrecaoAtual) {
        this.criteriosCorrigidosCorrecaoAtual = criteriosCorrigidosCorrecaoAtual;
    }

    protected void enviaAvisoDiscrepancia() {
        if (this.getCandidatoAtual() != null) {
            if (this.getCandidatoAtual().getFlDiscrepancia()
                    && this.getCandidatoAtual().getIdDisciplina() != null
                    && this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao() != null
                    && (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DISCURSIVA
                    || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA
                    || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE
                    || this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Atenção! Prova com discrepância.", "Chame seu parceiro de correção para fazer a discrepância!"));
            }
        }
        if (this.getCandidatoAtual() != null) {
            //if(this.getCandidatoAtual().getFlAtendimentoEspecial() ){
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Atenção! Prova de candidato com necessidade especial.", "Comunique o seu coordenador para alinhamento de eventuais procedimentos!"));
            //}
            if (this.getCandidatoAtual().getFlAtendimentoEspecial()) {
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Atenção! Prova de candidato para transferência.", "Comunique o seu coordenador para alinhamento de eventuais procedimentos!"));
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Atenção! Prova de candidato com necessidade especial.", "Comunique o seu coordenador para alinhamento de eventuais procedimentos!"));
            }
        }
    }

    public List<VwRespostaInscricaoCorrecao> getListaRespostasQuestoes(TbInscricao inscricao) {
        if (listaRespostasQuestoes == null && inscricao.getNrInscricao() != null) {
            if (inscricao != null) {
                List<VwRespostaInscricaoCorrecao> consulta = (new VwRespostaInscricaoServiceImpl()).pesquisaPorInscricao(inscricao.getNrInscricao());
                if (consulta == null) {
                    return null;
                }
                this.listaRespostasQuestoes = consulta;
            }
        }
        return listaRespostasQuestoes;
    }

    public List<VwRespostaInscricaoCorrecao> getListaRespostasQuestoes() {
        return this.getListaRespostasQuestoes(this.getInscricaoCandidatoAtual());
    }

    public void setListaRespostasQuestoes(List<VwRespostaInscricaoCorrecao> listaRespostasQuestoes) {
        this.listaRespostasQuestoes = listaRespostasQuestoes;
    }

    public float getNotaTotal() {
        float retorno = 0;
        if (listaRespostasQuestoes != null) {
            for (VwRespostaInscricaoCorrecao atual : listaRespostasQuestoes) {
                if (atual.getNrNotaFinal() != null) {
                    retorno += atual.getNrNotaFinal();
                }
            }
        }
        if ((this.getColaborador().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA)) {

            //System.out.println("Nota atual: " + retorno);

            //retorno=(new VwRespostaInscricaoServiceImpl()).notaTotalPorIdResposta(this.getCandidatoAtual().getIdResposta());

            retorno = 0;
            //VwRespostaInscricaoCorrecao consultarInscricao=(new VwRespostaInscricaoServiceImpl()).pesquisarPorIDLong(this.getCandidatoAtual().getIdResposta());
            //for (VwRespostaInscricaoCorrecao atual : (new VwRespostaInscricaoServiceImpl()).pesquisaPorInscricao(consultarInscricao.getNrInscricao())) {
            if (listaRespostasQuestoes != null) {
                for (VwRespostaInscricaoCorrecao atual : listaRespostasQuestoes) {
                    List<TbCorrecao> buscaCorrecao = (new CorrecaoServiceImpl()).pesquisarPorResposta(atual.getIdResposta());
                    double soma = 0, discrepancia = 0;
                    int quant = 0;
                    if (buscaCorrecao != null && buscaCorrecao.size() > 0) {
                        for (TbCorrecao cor : buscaCorrecao) {
                            soma += cor.getNrNota();
                            quant++;
                        }
                        for (TbCorrecao cor : buscaCorrecao) {
                            if (cor.getIdTipoCorrecao().getIdTipoCorrecao() == Uteis.TIPO_CORRECAO_DISCREPANCIA) {
                                soma = cor.getNrNota();
                                quant = 1;
                                discrepancia = cor.getNrNota();
                            }
                        }
                        retorno += (soma / quant);
                        atual.setNrNotaFinal((soma / quant));
                    }
                    if (discrepancia != 0) {
                        atual.setNrNotaFinal(discrepancia);
                    }
                    //System.out.println("Nota parcial - total: " + retorno + " atual: " + (soma / quant) + " resposta: " + atual.getIdResposta()+" Discrepancia: "+discrepancia);
                }
            }
            //}
        } else {
            if (this.getCorrecaoAtual() != null) {
                retorno += this.getCorrecaoAtual().getNrNota();
            }
        }
        return retorno;
    }

    protected void buscaCorrecaoOutrasQuestoes() {
        if (this.getCandidatoAtual() != null) {
            VwRespostaInscricaoCorrecao atual = (new VwRespostaInscricaoServiceImpl()).pesquisarPorIDLong(this.getCandidatoAtual().getIdResposta().longValue());
            if (atual != null) {
                this.setListaRespostasQuestoes((new VwRespostaInscricaoServiceImpl()).pesquisaPorInscricao(atual.getNrInscricao()));
            }
        }
    }

    public void consultaOutraQuestaoCandidatoAtual(long respostaAtual) {
        //System.out.println("CONSULTA QUESTÃO " + respostaAtual);
        TbResposta resp = (new RespostaServiceImpl()).pesquisarPorIDLong(respostaAtual);
        this.setOutraQuestaoCandidatoAtual(resp);
    }

    public StreamedContent getImagemQuestao1() {

        List<VwRespostaInscricaoCorrecao> lista = this.getListaRespostasQuestoes();

        TbResposta resp = null;
        if (lista != null) {
            for (VwRespostaInscricaoCorrecao atual : lista) {
                if (atual.getNrQuestao().intValue() == Uteis.QUESTAO1) {
                    resp = (new RespostaServiceImpl()).pesquisarPorIDLong(atual.getIdResposta());
                }
            }
        }
        if (resp == null || resp.getTbRespostaImagem() == null) {
            return null;
        }
        if (resp.getTbRespostaImagem().size() <= 0 || resp.getTbRespostaImagem().get(0) == null || resp.getTbRespostaImagem().get(0).getImImagemResposta() == null) {
            return null;
        }
        //InputStream is = new ByteArrayInputStream(resp.getTbRespostaImagem().getImImagemResposta());
        InputStream is = null;
        if(resp!=null && resp.getTbRespostaImagem()!=null && resp.getTbRespostaImagem().size()>0 && resp.getTbRespostaImagem().get(0)!=null && resp.getTbRespostaImagem().get(0).getImImagemResposta()!=null){
            is = new ByteArrayInputStream(resp.getTbRespostaImagem().get(0).getImImagemResposta());
            return new DefaultStreamedContent(is);
        }
        return null;
    }

    public StreamedContent getImagemQuestao2() {

        List<VwRespostaInscricaoCorrecao> lista = this.getListaRespostasQuestoes();

        TbResposta resp = null;
        if (lista != null) {

            for (VwRespostaInscricaoCorrecao atual : lista) {
                if (atual.getNrQuestao().intValue() == Uteis.QUESTAO2) {
                    resp = (new RespostaServiceImpl()).pesquisarPorIDLong(atual.getIdResposta());
                }
            }
        }
        if (resp == null || resp.getTbRespostaImagem() == null) {
            return null;
        }
        InputStream is=null;
        
        if(resp!=null && resp.getTbRespostaImagem()!=null && resp.getTbRespostaImagem().size()>0 && resp.getTbRespostaImagem().get(0)!=null && resp.getTbRespostaImagem().get(0).getImImagemResposta()!=null){
            is = new ByteArrayInputStream(resp.getTbRespostaImagem().get(0).getImImagemResposta());
            return new DefaultStreamedContent(is);
        }
        //InputStream is = new ByteArrayInputStream(resp.getTbRespostaImagem().get(1).getImImagemResposta());
        return null;
    }

    public StreamedContent getImagemQuestao3() {

        List<VwRespostaInscricaoCorrecao> lista = this.getListaRespostasQuestoes();

        TbResposta resp = null;
        if (lista != null) {
            for (VwRespostaInscricaoCorrecao atual : lista) {
                if (atual.getNrQuestao().intValue() == Uteis.QUESTAO3) {
                    resp = (new RespostaServiceImpl()).pesquisarPorIDLong(atual.getIdResposta());
                }
            }
        }
        if (resp == null || resp.getTbRespostaImagem() == null) {
            return null;
        }
        //InputStream is = new ByteArrayInputStream(resp.getTbRespostaImagem().getImImagemResposta());
        InputStream is = null;
        
        if(resp!=null && resp.getTbRespostaImagem()!=null && resp.getTbRespostaImagem().size()>0 && resp.getTbRespostaImagem().get(0)!=null && resp.getTbRespostaImagem().get(0).getImImagemResposta()!=null){
            is = new ByteArrayInputStream(resp.getTbRespostaImagem().get(0).getImImagemResposta());
            return new DefaultStreamedContent(is);
        }
        return null;
    }

    public StreamedContent getImagemQuestao4() {

        List<VwRespostaInscricaoCorrecao> lista = this.getListaRespostasQuestoes();

        TbResposta resp = null;
        if (lista != null) {
            for (VwRespostaInscricaoCorrecao atual : lista) {
                if (atual.getNrQuestao().intValue() == Uteis.QUESTAO4) {
                    resp = (new RespostaServiceImpl()).pesquisarPorIDLong(atual.getIdResposta());
                }
            }
        }
        if (resp == null || resp.getTbRespostaImagem() == null) {
            return null;
        }
        //InputStream is = new ByteArrayInputStream(resp.getTbRespostaImagem().getImImagemResposta());
        InputStream is = null;
        if(resp!=null && resp.getTbRespostaImagem()!=null && resp.getTbRespostaImagem().size()>0 && resp.getTbRespostaImagem().get(0)!=null && resp.getTbRespostaImagem().get(0).getImImagemResposta()!=null){
            is = new ByteArrayInputStream(resp.getTbRespostaImagem().get(0).getImImagemResposta());
            return new DefaultStreamedContent(is);
        }
        return null;
    }

    public TbResposta getOutraQuestaoCandidatoAtual() {
        return outraQuestaoCandidatoAtual;
    }

    public void setOutraQuestaoCandidatoAtual(TbResposta outraQuestaoCandidatoAtual) {
        this.outraQuestaoCandidatoAtual = outraQuestaoCandidatoAtual;
    }

    private boolean acabaramProvasColaboradorAtual() {
        if (this.getColaborador() == null || this.getColaborador().getIdColaborador() == null) {
            return true;
        }
        if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_DISCREPANCIA) { //Discrepância
            //VwColaboradorPendenteDiscrepancia vcpd = (new VwColaboradorPendenteDiscrepanciaServiceImpl()).pesquisarPorIDLong(this.getColaborador().getIdColaborador().longValue());
            //VwColaboradorPendenteDiscrepancia vcpd = (new VwColaboradorPendenteDiscrepanciaServiceImpl()).pesquisarPorIDColaborador(this.getColaborador().getIdColaborador().longValue());
            VwColaboradorPendenteDiscrepancia vcpd = (new VwColaboradorPendenteDiscrepanciaServiceImpl()).pesquisarPorCPF(this.getColaborador().getNrCpf().getNrCpf());
            //VwColaboradorPendenteDiscrepancia vcpd = (new VwColaboradorPendenteDiscrepanciaServiceImpl()).pesquisarPorCPF(this.getColaborador().getNrCpf().getNrCpf());
            if (vcpd == null) {
                return true;
            }
            //this.setColaborador(new ColaboradorServiceImpl().pesquisarPorCPF(vcpd.getNrCpf()));
        } else { //Primeira e Segunda correções
            //VwColaboradorPendente vcp = (new VwColaboradorPendenteServiceImpl()).pesquisarPorIDLong(this.getColaborador().getIdColaborador().longValue());
            VwColaboradorPendente vcp = (new VwColaboradorPendenteServiceImpl()).pesquisarPorCPF(this.getColaborador().getNrCpf().getNrCpf());
            if (vcp == null) {
                return true;
            }
            //this.setColaborador(new ColaboradorServiceImpl().pesquisarPorCPF(vcp.getNrCpf()));
        }

        return false;
    }

    private boolean buscaProximoColaboradorPendente() {

        UsuarioController uc = UsuarioController.getInstance();
        if (uc != null) {
            TbColaborador proximo = null;
            if (this.getColaborador() != null && this.getColaborador().getIdTipoCorrecao() != null && this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_DISCREPANCIA) {
                proximo = uc.carregaProximoColaboradorPendenteDiscrepancia();
            } else {
                proximo = uc.carregaProximoColaboradorPendente();
            }
            if (proximo != null) {
                this.setColaborador(proximo);
                return true;
            }
        }
        return false;
    }

    public TbInscricao getInscricaoCandidatoAtual() {
        return inscricaoCandidatoAtual;
    }

    public void setInscricaoCandidatoAtual(TbInscricao inscricaoCandidatoAtual) {
        this.inscricaoCandidatoAtual = inscricaoCandidatoAtual;
    }

    public TbResposta getDadosQuestao1() {
        List<VwRespostaInscricaoCorrecao> lista = this.getListaRespostasQuestoes();

        TbResposta resp = null;
        //System.out.println("Obtendo dados da Questão 1");
        if (lista != null) {
            for (VwRespostaInscricaoCorrecao atual : lista) {
                if (atual.getNrQuestao().intValue() == Uteis.QUESTAO1) {
                    resp = (new RespostaServiceImpl()).pesquisarPorIDLong(atual.getIdResposta());
                    resp.setNrNotaFinal(atual.getNrNotaFinal());
                }
            }
        }
        return resp;
    }

    public TbResposta getDadosQuestao2() {
        List<VwRespostaInscricaoCorrecao> lista = this.getListaRespostasQuestoes();
        TbResposta resp = null;
        if (lista != null) {
            for (VwRespostaInscricaoCorrecao atual : lista) {
                if (atual.getNrQuestao().intValue() == Uteis.QUESTAO2) {
                    resp = (new RespostaServiceImpl()).pesquisarPorIDLong(atual.getIdResposta());
                    resp.setNrNotaFinal(atual.getNrNotaFinal());
                }
            }
        }
        return resp;
    }

    public TbResposta getDadosQuestao3() {
        List<VwRespostaInscricaoCorrecao> lista = this.getListaRespostasQuestoes();
        TbResposta resp = null;
        if (lista != null) {
            for (VwRespostaInscricaoCorrecao atual : lista) {
                if (atual.getNrQuestao().intValue() == Uteis.QUESTAO3) {
                    resp = (new RespostaServiceImpl()).pesquisarPorIDLong(atual.getIdResposta());
                    resp.setNrNotaFinal(atual.getNrNotaFinal());
                }
            }
        }
        return resp;
    }

    public TbResposta getDadosQuestao4() {
        List<VwRespostaInscricaoCorrecao> lista = this.getListaRespostasQuestoes();
        TbResposta resp = null;
        if (lista != null) {
            for (VwRespostaInscricaoCorrecao atual : lista) {
                if (atual.getNrQuestao().intValue() == Uteis.QUESTAO4) {
                    resp = (new RespostaServiceImpl()).pesquisarPorIDLong(atual.getIdResposta());
                    resp.setNrNotaFinal(atual.getNrNotaFinal());
                }
            }
        }
        return resp;
    }

    protected boolean atualizaRespostaAtualDiscrepancia(long idRespostaAtualizar) {
        TbAtualizaResposta atualizar = new TbAtualizaResposta();
        atualizar = (new AtualizaRespostaServiceImpl()).pesquisarPorID(idRespostaAtualizar);
        atualizar.setIdResposta(idRespostaAtualizar);
        if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO) {
            atualizar.setFlPrimeiraCorrecao(true);
        } else if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO) {
            atualizar.setFlSegundaCorrecao(true);
        }
        atualizar.setFlCorrigindo(true);
        atualizar.setFlCorrigida(false);
        atualizar.setNrNotaFinal(this.getNotaParcial());

        try {
            (new AtualizaRespostaServiceImpl()).atualizar(atualizar);
            return true;
        } catch (Exception ex) {
            this.setMensagem("Erro ao atualizar a rsposta atual.");
            return false;
        }

    }

    protected boolean atualizaRespostaAtualSemDiscrepancia(long idRespostaAtualizar) {
        TbAtualizaResposta atualizar = new TbAtualizaResposta();
        atualizar = (new AtualizaRespostaServiceImpl()).pesquisarPorID(idRespostaAtualizar);
        atualizar.setIdResposta(idRespostaAtualizar);
        if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO) {
            atualizar.setFlPrimeiraCorrecao(true);
        } else if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO) {
            atualizar.setFlSegundaCorrecao(true);
        }
        atualizar.setFlCorrigindo(true);
        atualizar.setFlCorrigida(false);

        List<TbCorrecao> correcoes = new CorrecaoServiceImpl().pesquisarPorResposta(idRespostaAtualizar);
        double soma = 0, discrepancia = 0, quant = 0;
        for (TbCorrecao atual : correcoes) {
            if (atual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO
                    || atual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO
                    || atual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_TERCEIRA_CORRECAO) {
                soma += atual.getNrNota();
                quant++;
            } else if (atual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_DISCREPANCIA) {
                discrepancia = atual.getNrNota();
            }
        }
        if (discrepancia == 0) {
            atualizar.setNrNotaFinal(soma / quant);
        } else {
            atualizar.setNrNotaFinal(discrepancia);
        }


        try {
            (new AtualizaRespostaServiceImpl()).atualizar(atualizar);
            return true;
        } catch (Exception ex) {
            this.setMensagem("Erro ao atualizar a rsposta atual.");
            return false;
        }

    }
    /*
    public List<StreamedContent> getTodasImagensCandidatoAtual() {
    List<StreamedContent> retorno = new ArrayList<StreamedContent>();
    List<TbRespostaImagem> listaImagens = (new RespostaImagemServiceImpl()).pesquisarPorIdResposta(this.getCandidatoAtual().getIdResposta());
    for(TbRespostaImagem imagemAtual : listaImagens){
    if(imagemAtual!=null){
    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
    retorno.add(new DefaultStreamedContent(is));
    }
    }
    return retorno;
    }
     */
    
    private void consultaInscricaoCandidatoAtual(){
        if(this.getCandidatoAtual()!=null && this.getCandidatoAtual().getIdInscricao()!=null){
            this.inscricaoCandidatoAtual=new TbInscricaoServiceImpl().pesquisarPorIDLong(this.getCandidatoAtual().getIdInscricao());
        }
    }
}
