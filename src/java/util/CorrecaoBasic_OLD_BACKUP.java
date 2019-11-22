/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import controller.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.TbAtualizaResposta;
import model.TbColaborador;
import model.TbCorrecao;
import model.TbCorrecaoCriterio;
import model.TbCorrecaoCriterioDigitacaoNota;
import model.TbCriterio;
import model.TbLinha;
import model.TbResposta;
import model.TbTipoCorrecao;
import model.TbTipoQuestao;
import model.VwCriterioComCorrecaoCriterio;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import service.AtualizaRespostaService;
import service.ColaboradorService;
import service.CorrecaoService;
import service.RespostaService;
import service.impl.AtualizaRespostaServiceImpl;
import service.impl.ColaboradorServiceImpl;
import service.impl.CorrecaoCriterioServiceImpl;
import service.impl.CorrecaoServiceImpl;
import service.impl.RespostaServiceImpl;

/**
 *
 * @author Janio
 */
public class CorrecaoBasic_OLD_BACKUP extends BasicController {

    private double notaParcial = 0.0;
    private String MensNotaCriterio = "";
    public static final int NUMERO_LINHAS = 35;
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

    public CorrecaoBasic_OLD_BACKUP() {
        this.getCorrecaoCriterioAtual().setNrLinha(1);
        this.getCorrecaoCriterioAtual().setIdCriterio(new TbCriterio());
        this.setErroBuscarInformacoesProibirCorrecao(false);
        this.consultaColaborador();
        this.consultaProximaResposta();
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

        return this.paginaCorrecaoDisciplinaAtual();//return "/view/corretor/redacao/corretor.xhtml";
    }

    public List<TbLinha> getListaLinhas() {

        List<TbLinha> retorno = new ArrayList<TbLinha>();
        for (int k = 1; k < NUMERO_LINHAS + 1; k++) { //30 linhas
            retorno.add(new TbLinha(k));
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
        ColaboradorService cs = new ColaboradorServiceImpl();
        if (UsuarioController.getInstance() == null) {
            return;
        }
        //this.setColaborador(cs.pesquisarPorCPFeProcesso(UsuarioController.getInstance().getUsuario().getNrCpf(), UsuarioController.getInstance().getProcessoAtual().getIdProcesso()));
        this.setColaborador(cs.pesquisarPorCPF(UsuarioController.getInstance().getUsuario().getNrCpf()));
    }

    private TbResposta consultaProximaResposta() {
        TbResposta retorno = null;
        this.setBolMostraBotaoEnviar(false);
        retorno = consultaProximaRespostaPrimeiraSegundaCorrecao();
        if (retorno == null) {
            for (int k = 0; k < Uteis.LIMITE_PROCURA_RESPOSTA; k++) {
                retorno = consultaProximaRespostaDiscrepancia();
                if (retorno != null) {
                    break;
                }
            }
        }
        if (retorno == null) {
            this.setMensNotaCriterio("Não há mais respostas para serem corrigidas.");
            this.setMensagem("Não há mais respostas para serem corrigidas.");
            Uteis.Redireciona("/correcao/view/corretor/principal.xhtml");
        }
        this.setQuantidadeProvasCorrigidas((new CorrecaoServiceImpl()).quantidadePorColaborador(this.getColaborador().getIdColaborador().longValue()));
        this.atualizaBotaoEnviar();
        return retorno;
        //return this.consultaProximaResposta(0,0);
    }

    private TbResposta consultaProximaResposta(long idAnterior, int contador) { //BUSCA RESPOSTA DO CANDIDATO PARA SER CORRIGIDA
        this.zeraInformacoes();
        //Pelo corretor se OBTÉM TODAS AS INFORMAÇÕES PARA EFETUAR CORREÇÃO: Processo, Tipo de Correção (primeira, segunda), Tipo de Questão (redação, discursiva) 
        //e Disciplina (se for redação só tem redação, mas se for Discursiva, pode ter Química, Matemática, etc...
        //Pelo login se chega ao colaborador e pelo Colaborador se obtém as informações acima
        RespostaService rs = new RespostaServiceImpl();
        if (!this.verificaRestricao()) {
            return null; //Verifica restrições antes de obter próxima resposta para corrigir
        }
        TbResposta retorno = rs.pesquisarRespostaPresaColaboradorAtual(this.getColaborador().getIdColaborador()); //Correção ainda não terminada
        if (retorno != null) {
            this.setCandidatoAtual(retorno);
            this.atualizaColaboradorAtualCorrecaoAtual();
            this.setBolRespostaEncontrada(true);
            buscaCorrecaoAtual(); //Busca correção atual , caso exista
            this.calculaNota();
            //this.atualizaGeneroRecarregaCriterios();
            return retorno;
        } else { //PRÓXIMA DISPONÍVEL - Se não tem nenhuma correção presa para o corretor atual então pega a próxima
            int idDisciplina = this.getColaborador().getIdBanca().getIdDisciplina().getIdDisciplina();
            int idCurso = this.getColaborador().getIdBanca().getIdCurso().getIdCurso();
            int idProcesso = this.getColaborador().getIdProcesso().getIdProcesso();
            retorno = rs.pesquisarProximaResposta(idDisciplina, idCurso, idProcesso);
        }
        if (retorno == null) {
            this.setMensNotaCriterio("Não há mais respostas para serem corrigidas.");
            this.setMensagem("Não há mais respostas para serem corrigidas.");
            Uteis.Redireciona("/correcao/view/corretor/principal.xhtml");
            return null;
        } else { //Verifica tipo de correção conforme o Colaborador atual (primeira correção ou segunda correção)
            if (!this.validaTipoCorrecao(retorno)) { //PENDENTE: Aqui há risco de LOOP infinito - melhorar posteriormente
                if (contador > Uteis.LIMITE_PROCURA_RESPOSTA) {
                    this.setMensNotaCriterio("Não há mais respostas para serem corrigidas.");
                    this.setMensagem("Não há mais respostas para serem corrigidas.");
                    Uteis.Redireciona("/correcao/view/corretor/principal.xhtml");
                    return null;
                }
                long idAtualizar = retorno.getIdResposta().longValue();
                if (retorno.getIdResposta().intValue() == idAnterior) {
                    return null;//Achou a mesma resposta para ser corrigida novamente
                }
                retorno = consultaProximaResposta(retorno.getIdResposta(), contador + 1);
                if (retorno == null) {
                    return null;
                }
                if (retorno != null) {
                    idAtualizar = retorno.getIdResposta().longValue();
                }
                //Atualiza flag corrigindo para disponibilizar a prova
                this.liberaRespostaEspecifica(idAtualizar);
            }
        }
        if (retorno == null) {
            return null;
        }
        this.setCandidatoAtual(retorno);
        buscaCorrecaoAtual(); //Busca correção atual , caso exista
        this.atualizaColaboradorAtualCorrecaoAtual();
        this.setBolRespostaEncontrada(true);
        this.calculaNota();
        return retorno;
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
        List<TbCorrecao> lista = cs.pesquisarPorResposta(validar.getIdResposta().intValue());
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
        }

        this.setBolDiscrepanciaCorretorQueCorrigiuAntes(false); //O tipo de correção (Primeira Correção, segunda, etc...) é buscado do corretor atual. Mas no caso da discursiva será usado este flag para indicar se é discrepância ou não.

        if (validar.getFlDiscrepancia()) {
            return false;
        }

        for (TbCorrecao atual : lista) { //Verifica se JÁ FEZ PRIMEIRA OU SEGUNDA CORREÇÃO (conforme o corretor)
            if (atual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue()) {
                return false;
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

        //DISCREPÂNCIA: no caso da discursiva, a discrepância volta para o mesmo corretor

        if (validar.getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DISCURSIVA) { //Se for discursiva, a discrepância vai para um dos corretores que a corrigiu antes
            if (validar.getFlDiscrepancia() && !validar.getFlDiscrepanciaCorrigida()) {
                for (TbCorrecao atual : lista) { //DISCREPÂNCIA volta para o mesmo corretor que fez a primeira ou segunda correção. Portanto, verifica se o corretor atual JÁ FEZ PRIMEIRA OU SEGUNDA CORREÇÃO 
                    if (atual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO
                            || atual.getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO) {
                        if (atual.getIdColaborador().getIdColaborador().longValue() == this.getColaborador().getIdColaborador().longValue()) {
                            this.setCorrecaoAtual(null);
                            this.setBolDiscrepanciaCorretorQueCorrigiuAntes(true); //Discrepância pertence a um dos corretores que fizeram a correção
                            return true;
                        }
                    }
                }
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
            TbCorrecao cor=null;
            if(this.getCandidatoAtual().getFlDiscrepancia()){
                cor = (new CorrecaoServiceImpl()).pesquisarPorRespostaTipoCorrecao(this.getCandidatoAtual().getIdResposta().longValue(), Uteis.TIPO_CORRECAO_DISCREPANCIA);
            }else{
                cor = (new CorrecaoServiceImpl()).pesquisarPorCorrecaoColaborador(this.getCandidatoAtual().getIdResposta().longValue(), this.getColaborador().getIdColaborador().longValue());
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
        if (this.getCorrecaoAtual() != null) {
            List<TbCorrecaoCriterio> listaCorrecoes = (new CorrecaoCriterioServiceImpl()).pesquisarPorCorrecao(this.getCorrecaoAtual().getIdCorrecao());
            this.notaParcial = this.getCandidatoAtual().getIdDisciplina().getNrNotaInicial();
            for (TbCorrecaoCriterio atual : listaCorrecoes) {
                if (this.getCandidatoAtual().getFlDiscrepancia()) {
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
            if (listaCorrecoes.size() >= 1) {
                this.atualizaCorrecao(true);
            } else {
                this.atualizaCorrecao();
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
        this.getCorrecaoAtual().setNrNota(this.getNotaParcial());
        this.getCorrecaoAtual().setDtAtualizacao(new Date()); //Data de atualização
        this.getCorrecaoAtual().setFlSucesso(atualizaFlag);
        try {
            TbCorrecao atualiza = (new CorrecaoServiceImpl()).atualizar(this.getCorrecaoAtual());
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
        }

        atualizar.setFlRespostaComErro(bolRespostaComErro);

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
            double notaDiscrepancia=0.0;
            for (TbCorrecao atual : listaCorrecoes) {
                if (atual.getIdTipoCorrecao().getFlSobreposicaoNota()) { //quando o flag sobreposição é true, significa que a correção foi uma discrepância ou recorreção
                    if (atual.getIdTipoCorrecao().getNrPrioridade() > prioridadeAtual) { //Discrepância tem prioridade sobre as demais notas (flag sobreposicao true), mas recorreção tem prioridade sobre discrepância (além do flag, o número da prioridade é maior)
                        soma = atual.getNrNota();
                        prioridadeAtual = atual.getIdTipoCorrecao().getNrPrioridade();
                        notaDiscrepancia=atual.getNrNota();
                        flDiscrepancia = true;
                    }
                } else {
                    soma += atual.getNrNota();
                    quantidade++; // Só incrementa a quantidade quando é correção normal (1a correção ou 2a correção)

                    //Verifica se há discrepância - Compara as notas das correções para procurar se há discrepância (1a ou 2a correção) 
                    for (Double temp : notas) { //Compara nota atual com as demais para ver se tem discrepância
                        if (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DISCURSIVA) {
                            if (atual.getNrNota() > 0 && temp > 0) {
                                if (((Math.abs(atual.getNrNota() - temp)) > 4.0) || (temp == 0.0) || (atual.getNrNota() == 0.0)) {
                                    flDiscrepancia = true;
                                }
                            }
                        } else {
                            if (((Math.abs(atual.getNrNota() - temp)) > 4.0) || (temp == 0.0) || (atual.getNrNota() == 0.0)) {
                                flDiscrepancia = true;
                            }
                        }
                    }
                    notas.add(atual.getNrNota());
                }
            }

            notaFinal = soma / quantidade; //Calcula a nota mesmo com discrepância. Depois a nota será sobreposta no momento da correção da discrepância
            if (!flDiscrepancia && (prioridadeAtual == 0)) { //Se não teve discrepância, nem recorreção, a nota é a média das outras
                notaFinal = soma / quantidade;
            } else {
                if (quantidade >= 2 && (flDiscrepancia || prioridadeAtual > 0)) { //2 correções mais a discrepância
                    if (this.getCorrecaoAtual().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_DISCREPANCIA) {
                        flDiscrepanciaCorrigida = true;
                    }
                    notaFinal = notaDiscrepancia;
                }
            }

            TbAtualizaResposta atualizar = new TbAtualizaResposta();

            atualizar = (new AtualizaRespostaServiceImpl()).pesquisarPorID(this.getCandidatoAtual().getIdResposta());

            atualizar.setIdResposta(this.getCandidatoAtual().getIdResposta());
            atualizar.setNrNotaFinal(notaFinal);
            atualizar.setFlDiscrepancia(flDiscrepancia);
            atualizar.setFlDiscrepanciaCorrigida(flDiscrepanciaCorrigida);

            atualizar.setFlCorrigindo(false); //Desprende a resposta do corretor atual
            atualizar.setIdColaboradorAtual(null);

            if (quantidade > 1) { //Se já teve as duas correções, a correção pode ter terminado
                if (!flDiscrepancia || flDiscrepanciaCorrigida) { //Se não teve discrepância a correção terminou. Se teve discrepância, só termina se a discrepância foi corrigida
                    atualizar.setFlCorrigida(true);
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

        if (this.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DISCURSIVA) {
            return "/view/corretor/discursiva/correcao.xhtml";
        } else {
            return "/view/corretor/redacao/corretor.xhtml";
        }
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

    private TbResposta consultaProximaRespostaPrimeiraSegundaCorrecao() { //BUSCA RESPOSTA DO CANDIDATO PARA SER CORRIGIDA
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
            if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_PRIMEIRA_CORRECAO) {
                retorno = rs.pesquisarProximaRespostaPrimeiraCorrecao(idDisciplina, idCurso, idProcesso);
            } else if (this.getColaborador().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_SEGUNDA_CORRECAO) {
                retorno = rs.pesquisarProximaRespostaSegundaCorrecao(idDisciplina, idCurso, idProcesso);
            } else {
                retorno = rs.pesquisarProximaResposta(idDisciplina, idCurso, idProcesso);
            }
        }
        if (retorno == null) {
            /*
            this.setMensNotaCriterio("Não há mais respostas para serem corrigidas.");
            this.setMensagem("Não há mais respostas para serem corrigidas.");
            Uteis.Redireciona("/correcao/view/corretor/principal.xhtml");*/
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
            retorno = rs.pesquisarProximaRespostaDiscrepancia(idDisciplina, idCurso, idProcesso);
        }
        if (retorno == null) {
            this.setMensNotaCriterio("Não há mais respostas para serem corrigidas.");
            this.setMensagem("Não há mais respostas para serem corrigidas.");
            Uteis.Redireciona("/correcao/view/corretor/principal.xhtml");
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
        this.setBolRespostaEncontrada(true);
        this.calculaNota();
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
            boolean todos = true;
            for (VwCriterioComCorrecaoCriterio atual : cc.getListaCriterios()) {
                if (!atual.isExisteCorrecaoCriterio()) {
                    todos = false;break;
                }
            }
            this.setBolMostraBotaoEnviar(todos);
        } else {
            this.setBolMostraBotaoEnviar(true);
        }
    }
}
