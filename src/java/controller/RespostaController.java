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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.TbAtualizaResposta;
import model.TbCurso;
import model.TbDisciplina;
import model.TbInscricao;
import model.TbProcesso;
import model.TbResposta;
import model.TbRespostaImagem;
import model.VwRespostaImagem;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import service.RespostaService;
import service.TbInscricaoService;
import service.impl.AtualizaRespostaServiceImpl;
import service.impl.RespostaImagemServiceImpl;
import service.impl.RespostaServiceImpl;
import service.impl.TbInscricaoServiceImpl;
import service.impl.VwRespostaImagemServiceImpl;
import util.TrataImagem;
import util.Uteis;

/**
 *
 * @author Janio
 */
@ManagedBean(name = "RespostaController")
@SessionScoped
public class RespostaController extends BasicController {

    private TbResposta candidatoAtual = new TbResposta();
    private VwRespostaImagem respostaImagemAtual = new VwRespostaImagem();
    private TbInscricao inscricaoCandidatoAtual = new TbInscricao();
    private TbCurso cursoAtual = new TbCurso();
    private TbDisciplina disciplinaAtual = new TbDisciplina();
    private TbProcesso processoAtual = new TbProcesso();
    
    private long idRespostaConsultar = 0;
    private String paginaRetorno = "/view/admin/consulta/imagemResposta.xhtml";
    private List<VwRespostaImagem> listaImagens = null;

    public RespostaController() {
        this.candidatoAtual = (new RespostaServiceImpl()).pesquisarPrimeiraResposta();
        List<VwRespostaImagem> resp=null;
        if(this.getCandidatoAtual()!=null)
            resp= new VwRespostaImagemServiceImpl().pesquisarPorIdResposta(this.getCandidatoAtual().getIdResposta());
        if(resp!=null && resp.size()>0)
            this.respostaImagemAtual = resp.get(0);
        this.consultaInscricao();
        if(this.getCandidatoAtual()!=null && this.getCandidatoAtual().getIdResposta()!=null)this.idRespostaConsultar = this.getCandidatoAtual().getIdResposta();
    }

    public static RespostaController getInstance() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Object temp = session.getAttribute("RespostaController");
        if (temp instanceof RespostaController) {
            RespostaController pc = (RespostaController) temp;
            return pc;
        }
        return null;
    }

    public StreamedContent getImagemCandidatoAtual() {
        if (this.getCandidatoAtual() == null || this.getCandidatoAtual().getTbRespostaImagem() == null) {
            return null;
        }
        //InputStream is = new ByteArrayInputStream(this.getCandidatoAtual().getTbRespostaImagem().getImImagemResposta());
        InputStream is = null;
        if(this.getCandidatoAtual().getTbRespostaImagem()!=null && this.getCandidatoAtual().getTbRespostaImagem().size()>0)
            is = new ByteArrayInputStream(this.getCandidatoAtual().getTbRespostaImagem().get(0).getImImagemResposta());

        return new DefaultStreamedContent(is);
    }

    public final TbResposta getCandidatoAtual() {
        return candidatoAtual;
    }

    public void setCandidatoAtual(TbResposta candidatoAtual) {
        this.candidatoAtual = candidatoAtual;
    }

    public String consultaProximaResposta() {
        long resposta = 0;
        this.setMensagem("");
        resposta = this.getIdRespostaConsultar();
        for (int k = 0; k < 1000; k++) {
            consultaRespostaEspecifica(resposta + 1);
            if (this.getCandidatoAtual() != null) {
                break;
            }
            resposta++;
        }
        if (this.getCandidatoAtual() == null) {
            this.setMensagem("Resposta não encontrada");
        }
        return this.getPaginaRetorno();
    }

    public String consultaRespostaAnterior() {
        long resposta = 0;
        this.setMensagem("");
        resposta = this.getIdRespostaConsultar();
        for (int k = 0; k < 1000; k++) {
            consultaRespostaEspecifica(resposta - 1);
            if (this.getCandidatoAtual() != null) {
                break;
            }
            resposta--;
        }
        if (this.getCandidatoAtual() == null) {
            this.setMensagem("Resposta não encontrada");
        }
        return this.getPaginaRetorno();
    }

    protected void consultaRespostaEspecifica(long resposta) {
        RespostaService resp = new RespostaServiceImpl();
        this.setMensagem("");
        TbResposta retorno = resp.pesquisarPorIDLong(resposta);
        this.setCandidatoAtual(retorno);
        this.setIdRespostaConsultar(resposta);
        this.consultaInscricao();
        this.getTodasImagensCandidatoAtual();
    }

    private void consultaInscricao(){
        TbInscricaoService is = new TbInscricaoServiceImpl();
        if (this.getCandidatoAtual() != null && this.getCandidatoAtual().getIdInscricao() != null) {
            TbInscricao inscricao = is.pesquisarPorIDLong(this.getCandidatoAtual().getIdInscricao().longValue());
            this.setInscricaoCandidatoAtual(inscricao);
        }else{
            this.setInscricaoCandidatoAtual(null);
        }
    }

    public String consultaPorId() {
        this.consultaRespostaEspecifica(this.getIdRespostaConsultar());
        return this.getPaginaRetorno();
    }

    public long getIdRespostaConsultar() {
        return idRespostaConsultar;
    }

    public void setIdRespostaConsultar(long idRespostaConsultar) {
        this.idRespostaConsultar = idRespostaConsultar;
    }

    public String gravaRespostaEmBranco() {
        if (candidatoAtual != null) {
            //TbRespostaImagem tri = this.candidatoAtual.getTbRespostaImagem();
            TbRespostaImagem tri = this.candidatoAtual.getTbRespostaImagem().get(0);
            tri.setFlRespostaEmBranco(true);
            tri.setFlErroImagem(false);
            tri.setDtUltimaAtualizacao(new Date());

            (new RespostaImagemServiceImpl()).atualizar(tri);
        }
        return this.getPaginaRetorno();
    }

    public String gravaRespostaOKSemErro() {
        if (candidatoAtual != null) {
            //TbRespostaImagem tri = this.candidatoAtual.getTbRespostaImagem();
            TbRespostaImagem tri = this.candidatoAtual.getTbRespostaImagem().get(0);
            tri.setFlRespostaEmBranco(false);
            tri.setFlErroImagem(false);
            tri.setFlConferida(false);
            tri.setDtUltimaAtualizacao(new Date());

            (new RespostaImagemServiceImpl()).atualizar(tri);
            this.atualizaRespostaSemErro();
            this.setMensagem("Resposta gravada e enviada para corretores.");
        }
        return this.getPaginaRetorno();
    }

    private boolean atualizaRespostaSemErro() {
        TbAtualizaResposta atualizar = new TbAtualizaResposta();
        atualizar = (new AtualizaRespostaServiceImpl()).pesquisarPorID(this.getCandidatoAtual().getIdResposta());
        atualizar.setIdResposta(this.getCandidatoAtual().getIdResposta());
        atualizar.setFlRespostaComErro(false);
        try {
            (new AtualizaRespostaServiceImpl()).atualizar(atualizar);
            return true;
        } catch (Exception ex) {
            this.setMensagem("Erro ao atualizar a rsposta atual.");
            return false;
        }
    }

    public String desidentificarImagem() {
        if (candidatoAtual != null) {
            //TrataImagem trataImagem = new TrataImagem(new ByteArrayInputStream(this.getCandidatoAtual().getTbRespostaImagem().getImImagemResposta()));
            TrataImagem trataImagem = new TrataImagem(new ByteArrayInputStream(this.getCandidatoAtual().getTbRespostaImagem().get(0).getImImagemResposta()));
            //this.getCandidatoAtual().getTbRespostaImagem().setImImagemResposta(TrataImagem.fromInputStreamToByte(trataImagem.getCropPAAESDesParteSup()));
            this.getCandidatoAtual().getTbRespostaImagem().get(0).setImImagemResposta(TrataImagem.fromInputStreamToByte(trataImagem.getCropPAAESDesParteSup()));
        }
        this.setMensagem("Imagem desidentificada.");
        return this.getPaginaRetorno();
    }

    public String cortaPedacinhoSuperior() {
        if (candidatoAtual != null) {
            //TrataImagem trataImagem = new TrataImagem(new ByteArrayInputStream(this.getCandidatoAtual().getTbRespostaImagem().getImImagemResposta()));
            //this.getCandidatoAtual().getTbRespostaImagem().setImImagemResposta(TrataImagem.fromInputStreamToByte(trataImagem.getCropPedacinhoSuperior()));
            TrataImagem trataImagem = new TrataImagem(new ByteArrayInputStream(this.getCandidatoAtual().getTbRespostaImagem().get(0).getImImagemResposta()));
            this.getCandidatoAtual().getTbRespostaImagem().get(0).setImImagemResposta(TrataImagem.fromInputStreamToByte(trataImagem.getCropPedacinhoSuperior()));
        }
        this.setMensagem("Imagem cortada.");
        return this.getPaginaRetorno();
    }

    public String cortaParteSuperior() {
        if (candidatoAtual != null) {
            //TrataImagem trataImagem = new TrataImagem(new ByteArrayInputStream(this.getCandidatoAtual().getTbRespostaImagem().getImImagemResposta()));
            //this.getCandidatoAtual().getTbRespostaImagem().setImImagemResposta(TrataImagem.fromInputStreamToByte(trataImagem.getCropPedacoMedioSuperior()));
            TrataImagem trataImagem = new TrataImagem(new ByteArrayInputStream(this.getCandidatoAtual().getTbRespostaImagem().get(0).getImImagemResposta()));
            this.getCandidatoAtual().getTbRespostaImagem().get(0).setImImagemResposta(TrataImagem.fromInputStreamToByte(trataImagem.getCropPedacoMedioSuperior()));
        }
        this.setMensagem("Imagem cortada.");
        return this.getPaginaRetorno();
    }

    public String cortaPedacinhoInferior() {
        if (candidatoAtual != null) {
            //TrataImagem trataImagem = new TrataImagem(new ByteArrayInputStream(this.getCandidatoAtual().getTbRespostaImagem().getImImagemResposta()));
            //this.getCandidatoAtual().getTbRespostaImagem().setImImagemResposta(TrataImagem.fromInputStreamToByte(trataImagem.getCropPedacinhoInferior()));
            TrataImagem trataImagem = new TrataImagem(new ByteArrayInputStream(this.getCandidatoAtual().getTbRespostaImagem().get(0).getImImagemResposta()));
            this.getCandidatoAtual().getTbRespostaImagem().get(0).setImImagemResposta(TrataImagem.fromInputStreamToByte(trataImagem.getCropPedacinhoInferior()));
        }
        this.setMensagem("Imagem cortada.");
        return this.getPaginaRetorno();
    }

    public String cortaFilipetaDireita() {
        if (candidatoAtual != null) {
            //TrataImagem trataImagem = new TrataImagem(new ByteArrayInputStream(this.getCandidatoAtual().getTbRespostaImagem().getImImagemResposta()));
            //this.getCandidatoAtual().getTbRespostaImagem().setImImagemResposta(TrataImagem.fromInputStreamToByte(trataImagem.cortaFilipetaDireita()));
            TrataImagem trataImagem = new TrataImagem(new ByteArrayInputStream(this.getCandidatoAtual().getTbRespostaImagem().get(0).getImImagemResposta()));
            this.getCandidatoAtual().getTbRespostaImagem().get(0).setImImagemResposta(TrataImagem.fromInputStreamToByte(trataImagem.cortaFilipetaDireita()));
        }
        this.setMensagem("Imagem cortada.");
        return this.getPaginaRetorno();
    }

    public String giraParaDireita() {
        if (candidatoAtual != null) {
            //TrataImagem trataImagem = new TrataImagem(new ByteArrayInputStream(this.getCandidatoAtual().getTbRespostaImagem().getImImagemResposta()));
            //this.getCandidatoAtual().getTbRespostaImagem().setImImagemResposta(TrataImagem.fromInputStreamToByte(trataImagem.giraParaDireita()));
            TrataImagem trataImagem = new TrataImagem(new ByteArrayInputStream(this.getCandidatoAtual().getTbRespostaImagem().get(0).getImImagemResposta()));
            this.getCandidatoAtual().getTbRespostaImagem().get(0).setImImagemResposta(TrataImagem.fromInputStreamToByte(trataImagem.giraParaDireita()));
        }
        this.setMensagem("Imagem cortada.");
        return this.getPaginaRetorno();
    }

    public String giraParaEsquerda() {
        if (candidatoAtual != null) {
            //TrataImagem trataImagem = new TrataImagem(new ByteArrayInputStream(this.getCandidatoAtual().getTbRespostaImagem().getImImagemResposta()));
            //this.getCandidatoAtual().getTbRespostaImagem().setImImagemResposta(TrataImagem.fromInputStreamToByte(trataImagem.giraParaEsquerda()));
            TrataImagem trataImagem = new TrataImagem(new ByteArrayInputStream(this.getCandidatoAtual().getTbRespostaImagem().get(0).getImImagemResposta()));
            this.getCandidatoAtual().getTbRespostaImagem().get(0).setImImagemResposta(TrataImagem.fromInputStreamToByte(trataImagem.giraParaEsquerda()));
        }
        this.setMensagem("Imagem cortada.");
        return this.getPaginaRetorno();
    }

    public String gravaDesidentificacao() {
        if (candidatoAtual != null) {

            //TbRespostaImagem tri = this.candidatoAtual.getTbRespostaImagem();
            TbRespostaImagem tri = this.candidatoAtual.getTbRespostaImagem().get(0);
            (new RespostaImagemServiceImpl()).atualizar(tri);
            this.setMensagem("Desidentificação gravada com sucesso.");
        }
        return this.getPaginaRetorno();
    }

    public String getPaginaRetorno() {
        return paginaRetorno;
    }

    public void setPaginaRetorno(String paginaRetorno) {
        this.paginaRetorno = paginaRetorno;
    }

    public TbInscricao getInscricaoCandidatoAtual() {
        return inscricaoCandidatoAtual;
    }

    public void setInscricaoCandidatoAtual(TbInscricao inscricaoCandidatoAtual) {
        this.inscricaoCandidatoAtual = inscricaoCandidatoAtual;
    }
    
    public List<StreamedContent> getTodasImagensCandidatoAtual() {
        List<StreamedContent> retorno = new ArrayList<StreamedContent>();
        //List<TbRespostaImagem> listaImagens = (new RespostaImagemServiceImpl()).pesquisarPorIdResposta(this.getCandidatoAtual().getIdResposta());
        List<VwRespostaImagem> consultaListaImagens = (new VwRespostaImagemServiceImpl()).pesquisarPorIdResposta(this.getCandidatoAtual().getIdResposta());
        this.listaImagens=consultaListaImagens;
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                retorno.add(new DefaultStreamedContent(is));
            }
        }
        return retorno;
    }
    public void consultaImagens(long idResposta){
        if(this.listaImagens==null || (this.respostaDiferente(idResposta)) ){
            this.listaImagens=(new VwRespostaImagemServiceImpl()).pesquisarPorIdResposta(idResposta);
        }
    }
    private boolean respostaDiferente(long idResposta){
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual.getIdResposta().longValue()!=idResposta)return true;
        }
        return false;
    }
    public StreamedContent getImagensCandidatoAtualQ1(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null){
                    if(imagemAtual.getNrOrdem()==Uteis.QUESTAO1){
                        InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                        return (new DefaultStreamedContent(is));
                    }
                }else{
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ2(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO2){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ3(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO3){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ4(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO4){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ5(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO5){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ6(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO6){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ7(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO7){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ8(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO8){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ9(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO9){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ10(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO10){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }

    public StreamedContent getImagensCandidatoAtualQ11(long idResposta) {
        this.consultaImagens(idResposta);
        for(VwRespostaImagem imagemAtual : listaImagens){
            if(imagemAtual!=null){
                if(imagemAtual.getNrOrdem()!=null && imagemAtual.getNrOrdem()==Uteis.QUESTAO11){
                    InputStream is = new ByteArrayInputStream(imagemAtual.getImImagemResposta());
                    return (new DefaultStreamedContent(is));
                }
            }
        }
        return null;
    }
    
    public StreamedContent getImagensCandidatoAtualQ1() {
        if(this.getCandidatoAtual()!=null)
            return this.getImagensCandidatoAtualQ1(this.getCandidatoAtual().getIdResposta());
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ2() {
        if(this.getCandidatoAtual()!=null)
            return this.getImagensCandidatoAtualQ2(this.getCandidatoAtual().getIdResposta());
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ3() {
        if(this.getCandidatoAtual()!=null)
            return this.getImagensCandidatoAtualQ3(this.getCandidatoAtual().getIdResposta());
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ4() {
        if(this.getCandidatoAtual()!=null)
            return this.getImagensCandidatoAtualQ4(this.getCandidatoAtual().getIdResposta());
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ5() {
        if(this.getCandidatoAtual()!=null)
            return this.getImagensCandidatoAtualQ5(this.getCandidatoAtual().getIdResposta());
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ6() {
        if(this.getCandidatoAtual()!=null)
            return this.getImagensCandidatoAtualQ6(this.getCandidatoAtual().getIdResposta());
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ7() {
        if(this.getCandidatoAtual()!=null)
            return this.getImagensCandidatoAtualQ7(this.getCandidatoAtual().getIdResposta());
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ8() {
        if(this.getCandidatoAtual()!=null)
            return this.getImagensCandidatoAtualQ8(this.getCandidatoAtual().getIdResposta());
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ9() {
        if(this.getCandidatoAtual()!=null)
            return this.getImagensCandidatoAtualQ9(this.getCandidatoAtual().getIdResposta());
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ10() {
        if(this.getCandidatoAtual()!=null)
            return this.getImagensCandidatoAtualQ10(this.getCandidatoAtual().getIdResposta());
        return null;
    }
    public StreamedContent getImagensCandidatoAtualQ11() {
        if(this.getCandidatoAtual()!=null && this.getCandidatoAtual().getIdResposta()!=null)
            return this.getImagensCandidatoAtualQ11(this.getCandidatoAtual().getIdResposta());
        return null;
    }

    public VwRespostaImagem getRespostaImagemAtual() {
        return respostaImagemAtual;
    }

    public void setRespostaImagemAtual(VwRespostaImagem respostaImagemAtual) {
        this.respostaImagemAtual = respostaImagemAtual;
    }

    public TbCurso getCursoAtual() {
        return cursoAtual;
    }

    public void setCursoAtual(TbCurso cursoAtual) {
        this.cursoAtual = cursoAtual;
    }

    public TbDisciplina getDisciplinaAtual() {
        return disciplinaAtual;
    }

    public void setDisciplinaAtual(TbDisciplina disciplinaAtual) {
        this.disciplinaAtual = disciplinaAtual;
    }

    public TbProcesso getProcessoAtual() {
        return processoAtual;
    }

    public void setProcessoAtual(TbProcesso processoAtual) {
        this.processoAtual = processoAtual;
    }
    
}
