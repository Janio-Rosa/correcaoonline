/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import model.TbInscricao;
import model.TbRespostaImagem;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import service.TbInscricaoService;
import service.impl.RespostaImagemServiceImpl;
import service.impl.TbInscricaoServiceImpl;

/**
 *
 * @author Janio
 */
@ManagedBean(name="RespostaImagemController")
@SessionScoped
public class RespostaImagemController extends BasicController {
    
    private TbRespostaImagem respostaAtual = new TbRespostaImagem();
    private long idRespostaConsultar=0;
    private TbInscricao inscricaoCandidatoAtual = new TbInscricao();

    public RespostaImagemController() {
        //this.respostaAtual=(new RespostaImagemServiceImpl()).pesquisarProximaImagem();
        //if(this.respostaAtual!=null)this.idRespostaConsultar=this.getRespostaAtual().getIdRespostaImagem();
    }

    public long getIdRespostaConsultar() {
        return idRespostaConsultar;
    }

    public void setIdRespostaConsultar(long idRespostaConsultar) {
        this.idRespostaConsultar = idRespostaConsultar;
    }

    public TbRespostaImagem getRespostaAtual() {
        return respostaAtual;
    }

    public void setRespostaAtual(TbRespostaImagem respostaAtual) {
        this.respostaAtual = respostaAtual;
    }
    

    public StreamedContent getImagemCandidatoAtual() {
        if (this.getRespostaAtual() == null || this.getRespostaAtual().getImImagemResposta()==null ) { 
            return null;
        }
        InputStream is=null;
        if(this.getRespostaAtual()!=null && this.getRespostaAtual().getImImagemResposta()!=null){
            is = new ByteArrayInputStream(this.getRespostaAtual().getImImagemResposta());
        }

        return new DefaultStreamedContent(is);
    }
    
    public String consultaProximaImagem(){
        this.setMensagem("");
        this.respostaAtual=(new RespostaImagemServiceImpl()).pesquisarProximaImagem();
        if(respostaAtual!=null){
            this.setIdRespostaConsultar(this.getRespostaAtual().getIdRespostaImagem());
            this.consultaInscricao();
        }else{
            this.setMensagem("Acabaram as respostas.");
        }
        return "/view/admin/consulta/verificarImagem.xhtml";
    }
    
    public String consultaProximaImagemEmBranco(){
        this.setMensagem("");
        this.respostaAtual=(new RespostaImagemServiceImpl()).pesquisarProximaImagemEmBranco();
        if(respostaAtual!=null){
            this.setIdRespostaConsultar(this.getRespostaAtual().getIdRespostaImagem());
        }else{
            this.setMensagem("Acabaram as respostas.");
        }
        return "/view/admin/consulta/imagemEmBranco.xhtml";
    }
            
    public String gravaErroImagemAtual(){
        if(respostaAtual!=null){
            this.respostaAtual.setFlErroImagem(true);
            this.respostaAtual.setDtUltimaAtualizacao(new Date());

            (new RespostaImagemServiceImpl()).atualizar(this.respostaAtual);
            return this.consultaProximaImagem();
        }
        return "/view/admin/consulta/verificarImagem.xhtml";
    }

    public String gravaRespostaEmBranco(){
        if(respostaAtual!=null){
            this.respostaAtual.setFlRespostaEmBranco(true);
            this.respostaAtual.setFlEmBrancoConferida(false);
            this.respostaAtual.setDtUltimaAtualizacao(new Date());

            (new RespostaImagemServiceImpl()).atualizar(this.respostaAtual);
            return this.consultaProximaImagem();
        }
        return "/view/admin/consulta/verificarImagem.xhtml";
    }
    
    public String gravaErroImagemAtualChecagemProvasEmBranco(){
        if(respostaAtual!=null){
            this.respostaAtual.setFlErroImagem(true);
            this.respostaAtual.setDtUltimaAtualizacao(new Date());

            (new RespostaImagemServiceImpl()).atualizar(this.respostaAtual);
            return this.consultaProximaImagemEmBranco();
        }
        return "/view/admin/consulta/imagemEmBranco.xhtml";
    }

    public TbInscricao getInscricaoCandidatoAtual() {
        return inscricaoCandidatoAtual;
    }

    public void setInscricaoCandidatoAtual(TbInscricao inscricaoCandidatoAtual) {
        this.inscricaoCandidatoAtual = inscricaoCandidatoAtual;
    }
    
    private void consultaInscricao(){
        TbInscricaoService is = new TbInscricaoServiceImpl();
        
        if (this.getRespostaAtual().getIdResposta() != null && this.getRespostaAtual().getIdResposta().getIdInscricao() != null) {
            TbInscricao inscricao = is.pesquisarPorIDLong(this.getRespostaAtual().getIdResposta().getIdInscricao().longValue());
            this.setInscricaoCandidatoAtual(inscricao);
        }else{
            this.setInscricaoCandidatoAtual(null);
        }
    }
    
}
