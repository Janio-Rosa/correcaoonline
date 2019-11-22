/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.TbAtualizaResposta;
import model.TbDisciplina;
import model.TbResposta;
import model.VwConfere1aCorrecao;
import model.VwConfere2aCorrecao;
import model.VwConfere3aCorrecao;
import service.VwConfere1aCorrecaoService;
import service.VwConfere2aCorrecaoService;
import service.VwConfere3aCorrecaoService;
import service.impl.AtualizaRespostaServiceImpl;
import service.impl.DisciplinaServiceImpl;
import service.impl.RespostaServiceImpl;
import service.impl.VwConfere1aCorrecaoServiceImpl;
import service.impl.VwConfere2aCorrecaoServiceImpl;
import service.impl.VwConfere3aCorrecaoServiceImpl;

/**
 *
 * @author janio
 */
@ManagedBean(name = "LiberacaoProva")
@SessionScoped
public class LiberacaoProvaController {

    private int idDisciplinaSelecionada=0;
    private int nrQuestaoSelecionada=0;
    private int quantProvasPendentesPrimeiraCorrecao=0;
    private int quantProvasPendentesSegundaCorrecao=0;
    private int quantProvasPendentesTerceiraCorrecao=0;
    private static final int LIMITE_INFERIOR_POUCAS_PROVAS=5;
    private static final int LIMITE_PARA_ATUALIZAR=800;
    private String mensagemAviso="";

    private List<VwConfere1aCorrecao> listaPendenciasPrimeiraCorrecao = null;
    private List<VwConfere2aCorrecao> listaPendenciasSegundaCorrecao = null;
    private List<VwConfere3aCorrecao> listaPendenciasTerceiraCorrecao = null;
    private TbDisciplina disciplinaSelecionada = null;

    public LiberacaoProvaController() {

    }

    public int getIdDisciplinaSelecionada() {
        return idDisciplinaSelecionada;
    }

    public void setIdDisciplinaSelecionada(int idDisciplinaSelecionada) {
        this.idDisciplinaSelecionada = idDisciplinaSelecionada;
    }

    public int getNrQuestaoSelecionada() {
        return nrQuestaoSelecionada;
    }

    public void setNrQuestaoSelecionada(int nrQuestaoSelecionada) {
        this.nrQuestaoSelecionada = nrQuestaoSelecionada;
    }

    public int getQuantProvasPendentesPrimeiraCorrecao() {
        return quantProvasPendentesPrimeiraCorrecao;
    }

    public void setQuantProvasPendentesPrimeiraCorrecao(int quantProvasPendentesPrimeiraCorrecao) {
        this.quantProvasPendentesPrimeiraCorrecao = quantProvasPendentesPrimeiraCorrecao;
    }

    public int getQuantProvasPendentesSegundaCorrecao() {
        return quantProvasPendentesSegundaCorrecao;
    }

    public void setQuantProvasPendentesSegundaCorrecao(int quantProvasPendentesSegundaCorrecao) {
        this.quantProvasPendentesSegundaCorrecao = quantProvasPendentesSegundaCorrecao;
    }

    public int getQuantProvasPendentesTerceiraCorrecao() {
        return quantProvasPendentesTerceiraCorrecao;
    }

    public void setQuantProvasPendentesTerceiraCorrecao(int quantProvasPendentesTerceiraCorrecao) {
        this.quantProvasPendentesTerceiraCorrecao = quantProvasPendentesTerceiraCorrecao;
    }

    public String consultaPendencias(){
        this.setQuantProvasPendentesPrimeiraCorrecao(0);
        this.setQuantProvasPendentesSegundaCorrecao(0);
        this.setQuantProvasPendentesTerceiraCorrecao(0);
        if(this.getIdDisciplinaSelecionada()==0){
            this.setMensagemAviso("Selecione uma disciplina antes");
            return "/view/coordenador/liberaprovas.xhtml";
        }
        if(this.getNrQuestaoSelecionada()==0){
            this.setMensagemAviso("Selecione uma questao antes");
            return "/view/coordenador/liberaprovas.xhtml";
        }
        this.setDisciplinaSelecionada(new DisciplinaServiceImpl().pesquisarPorID(this.getIdDisciplinaSelecionada()));
        VwConfere1aCorrecaoService vc1cs = new VwConfere1aCorrecaoServiceImpl();
        VwConfere2aCorrecaoService vc2cs = new VwConfere2aCorrecaoServiceImpl();
        VwConfere3aCorrecaoService vc3cs = new VwConfere3aCorrecaoServiceImpl();

        this.listaPendenciasPrimeiraCorrecao=vc1cs.pesquisarPorDisciplinaQuestao(idDisciplinaSelecionada,nrQuestaoSelecionada);
        this.listaPendenciasSegundaCorrecao=vc2cs.pesquisarPorDisciplinaQuestao(idDisciplinaSelecionada,nrQuestaoSelecionada);
        this.listaPendenciasTerceiraCorrecao=vc3cs.pesquisarPorDisciplinaQuestao(idDisciplinaSelecionada,nrQuestaoSelecionada);

        try{
            this.setQuantProvasPendentesPrimeiraCorrecao(this.listaPendenciasPrimeiraCorrecao.size());
        }catch(Exception ex){
            this.setQuantProvasPendentesPrimeiraCorrecao(0);
        }
        try{
            this.setQuantProvasPendentesSegundaCorrecao(this.listaPendenciasSegundaCorrecao.size());
        }catch(Exception ex){
            this.setQuantProvasPendentesSegundaCorrecao(0);
        }
        try{
            this.setQuantProvasPendentesTerceiraCorrecao(this.listaPendenciasTerceiraCorrecao.size());
        }catch(Exception ex){
            this.setQuantProvasPendentesTerceiraCorrecao(0);
        }
        
        this.setMensagemAviso("Consulta efetuada para a disciplina: "+this.getDisciplinaSelecionada().getNmDisciplina() +", questão "+this.getNrQuestaoSelecionada());
        
        return "/view/coordenador/liberaprovas.xhtml";
    }

    public String liberaPendenciasPrimeiraCorrecao(){
        if(this.getQuantProvasPendentesPrimeiraCorrecao()>=LiberacaoProvaController.LIMITE_PARA_ATUALIZAR){
            this.setMensagemAviso("Nº de provas muito grande na 1ª correção. Ainda não é necessária esta ação");
            return "/view/coordenador/liberaprovas.xhtml";
        }
        for(VwConfere1aCorrecao respostaAtual : listaPendenciasPrimeiraCorrecao){
            TbAtualizaResposta atualizar1aC = new TbAtualizaResposta();
            
            atualizar1aC.setIdResposta(respostaAtual.getIdResposta().longValue());
            this.liberaPrimeiraCorrecao(atualizar1aC);
        }
        this.setMensagemAviso("Primeira correção liberada com sucesso.");
        return "/view/coordenador/liberaprovas.xhtml";
    }

    public String liberaPendenciasSegundaCorrecao(){
        if(this.getQuantProvasPendentesSegundaCorrecao()>=LiberacaoProvaController.LIMITE_PARA_ATUALIZAR){
            this.setMensagemAviso("Nº de provas muito grande na 2ª correção. Ainda não é necessária esta ação");
            return "/view/coordenador/liberaprovas.xhtml";
        }
        
        for(VwConfere2aCorrecao respostaAtual : listaPendenciasSegundaCorrecao){
            TbAtualizaResposta atualizar2C = new TbAtualizaResposta();

            atualizar2C.setIdResposta(respostaAtual.getIdResposta().longValue());
            this.liberaSegundaCorrecao(atualizar2C);
        }
        this.setMensagemAviso("Segunda correção liberada com sucesso.");
        return "/view/coordenador/liberaprovas.xhtml";
    }

    public String liberaPendenciasTerceiraCorrecao(){
        if(this.getQuantProvasPendentesTerceiraCorrecao()>=LiberacaoProvaController.LIMITE_PARA_ATUALIZAR){
            this.setMensagemAviso("Nº de provas muito grande na 3ª correção. Ainda não é necessária esta ação");
            return "/view/coordenador/liberaprovas.xhtml";
        }

        for(VwConfere3aCorrecao respostaAtual : listaPendenciasTerceiraCorrecao){
            TbAtualizaResposta atualizar3C = new TbAtualizaResposta();
            
            atualizar3C.setIdResposta(respostaAtual.getIdResposta().longValue());

            this.liberaTerceiraCorrecao(atualizar3C);
        }
        this.setMensagemAviso("Terceira correção liberada com sucesso.");
        return "/view/coordenador/liberaprovas.xhtml";
    }

    private void liberaPrimeiraCorrecao(TbAtualizaResposta resp){
        resp.setFlPrimeiraCorrecao(false);
        resp.setFlCorrigida(false);
        resp.setFlRespostaComErro(false);
        resp.setFlDiscrepancia(false);
        resp.setFlDiscrepanciaCorrigida(false);
        resp.setFlRespostaEmBranco(false);

        if(this.getQuantProvasPendentesPrimeiraCorrecao()<this.LIMITE_INFERIOR_POUCAS_PROVAS)resp.setFlCorrigindo(false);//So atualiza este flag se estiver no "FINALMENTE", ou seja, so se estiver faltando poucas provas
        this.atualizaResposta(resp);
    }

    private void liberaSegundaCorrecao(TbAtualizaResposta resp){
        resp.setFlSegundaCorrecao(false);
        resp.setFlCorrigida(false);
        resp.setFlRespostaComErro(false);
        resp.setFlDiscrepancia(false);
        resp.setFlDiscrepanciaCorrigida(false);
        resp.setFlRespostaEmBranco(false);
        
        if(this.getQuantProvasPendentesSegundaCorrecao()<this.LIMITE_INFERIOR_POUCAS_PROVAS)resp.setFlCorrigindo(false);//So atualiza este flag se estiver no "FINALMENTE", ou seja, so se estiver faltando poucas provas
        this.atualizaResposta(resp);
    }

    private void liberaTerceiraCorrecao(TbAtualizaResposta resp){
        resp.setFlTerceiraCorrecao(false);
        resp.setFlCorrigida(false);
        resp.setFlRespostaComErro(false);
        resp.setFlDiscrepancia(false);
        resp.setFlDiscrepanciaCorrigida(false);
        resp.setFlRespostaEmBranco(false);

        if(this.getQuantProvasPendentesTerceiraCorrecao()<this.LIMITE_INFERIOR_POUCAS_PROVAS)resp.setFlCorrigindo(false);//So atualiza este flag se estiver no "FINALMENTE", ou seja, so se estiver faltando poucas provas
        this.atualizaResposta(resp);
    }

    private boolean atualizaResposta(TbAtualizaResposta respAtual){
        respAtual.setFlCorrigida(false);
        respAtual.setFlDiscrepancia(false);
        respAtual.setFlDiscrepanciaCorrigida(false);
        respAtual.setFlRespostaComErro(false);
        respAtual.setFlRespostaEmBranco(false);
        
        TbAtualizaResposta atualiza = new AtualizaRespostaServiceImpl().atualizar(respAtual);
        if(atualiza!=null)return true;

        return false;
    }

    public String getMensagemAviso() {
        return mensagemAviso;
    }

    public void setMensagemAviso(String mensagemAviso) {
        this.mensagemAviso = mensagemAviso;
    }

    public TbDisciplina getDisciplinaSelecionada() {
        return disciplinaSelecionada;
    }

    public void setDisciplinaSelecionada(TbDisciplina disciplinaSelecionada) {
        this.disciplinaSelecionada = disciplinaSelecionada;
    }

    public boolean isLiberarAcaoAtualizacaoPrimeiraCorrecao(){
        return this.getQuantProvasPendentesPrimeiraCorrecao()<LiberacaoProvaController.LIMITE_PARA_ATUALIZAR;
    }
    public boolean isLiberarAcaoAtualizacaoSegundaCorrecao(){
        return this.getQuantProvasPendentesSegundaCorrecao()<LiberacaoProvaController.LIMITE_PARA_ATUALIZAR;
    }
    public boolean isLiberarAcaoAtualizacaoTerceiraCorrecao(){
        return this.getQuantProvasPendentesTerceiraCorrecao()<LiberacaoProvaController.LIMITE_PARA_ATUALIZAR;
    }
    
}
