/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Janio
 */
@Entity
@Table(name = "vw_respostas_com_problema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwRespostasComProblema.findAll", query = "SELECT v FROM VwRespostasComProblema v"),
    @NamedQuery(name = "VwRespostasComProblema.findByIdResposta", query = "SELECT v FROM VwRespostasComProblema v WHERE v.idResposta = :idResposta"),
    @NamedQuery(name = "VwRespostasComProblema.findByIdDisciplina", query = "SELECT v FROM VwRespostasComProblema v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwRespostasComProblema.findByCdSerial", query = "SELECT v FROM VwRespostasComProblema v WHERE v.cdSerial = :cdSerial"),
    @NamedQuery(name = "VwRespostasComProblema.findByNrQuestao", query = "SELECT v FROM VwRespostasComProblema v WHERE v.nrQuestao = :nrQuestao"),
    @NamedQuery(name = "VwRespostasComProblema.findByIdProcesso", query = "SELECT v FROM VwRespostasComProblema v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwRespostasComProblema.findByNrNotaFinal", query = "SELECT v FROM VwRespostasComProblema v WHERE v.nrNotaFinal = :nrNotaFinal"),
    @NamedQuery(name = "VwRespostasComProblema.findByFlDiscrepancia", query = "SELECT v FROM VwRespostasComProblema v WHERE v.flDiscrepancia = :flDiscrepancia"),
    @NamedQuery(name = "VwRespostasComProblema.findByFlDiscrepanciaCorrigida", query = "SELECT v FROM VwRespostasComProblema v WHERE v.flDiscrepanciaCorrigida = :flDiscrepanciaCorrigida"),
    @NamedQuery(name = "VwRespostasComProblema.findByFlCorrigida", query = "SELECT v FROM VwRespostasComProblema v WHERE v.flCorrigida = :flCorrigida"),
    @NamedQuery(name = "VwRespostasComProblema.findByIdColaboradorAtual", query = "SELECT v FROM VwRespostasComProblema v WHERE v.idColaboradorAtual = :idColaboradorAtual"),
    @NamedQuery(name = "VwRespostasComProblema.findByFlCorrigindo", query = "SELECT v FROM VwRespostasComProblema v WHERE v.flCorrigindo = :flCorrigindo"),
    @NamedQuery(name = "VwRespostasComProblema.findByIdCurso", query = "SELECT v FROM VwRespostasComProblema v WHERE v.idCurso = :idCurso"),
    @NamedQuery(name = "VwRespostasComProblema.findByIdInscricao", query = "SELECT v FROM VwRespostasComProblema v WHERE v.idInscricao = :idInscricao"),
    @NamedQuery(name = "VwRespostasComProblema.findByDtInsercao", query = "SELECT v FROM VwRespostasComProblema v WHERE v.dtInsercao = :dtInsercao"),
    @NamedQuery(name = "VwRespostasComProblema.findByFlRespostaComErro", query = "SELECT v FROM VwRespostasComProblema v WHERE v.flRespostaComErro = :flRespostaComErro"),
    @NamedQuery(name = "VwRespostasComProblema.findByFlPrimeiraCorrecao", query = "SELECT v FROM VwRespostasComProblema v WHERE v.flPrimeiraCorrecao = :flPrimeiraCorrecao"),
    @NamedQuery(name = "VwRespostasComProblema.findByFlSegundaCorrecao", query = "SELECT v FROM VwRespostasComProblema v WHERE v.flSegundaCorrecao = :flSegundaCorrecao"),
    @NamedQuery(name = "VwRespostasComProblema.findByIdRespostaImagem", query = "SELECT v FROM VwRespostasComProblema v WHERE v.idRespostaImagem = :idRespostaImagem"),
    @NamedQuery(name = "VwRespostasComProblema.findByDtImportacao", query = "SELECT v FROM VwRespostasComProblema v WHERE v.dtImportacao = :dtImportacao"),
    @NamedQuery(name = "VwRespostasComProblema.findByFlConferida", query = "SELECT v FROM VwRespostasComProblema v WHERE v.flConferida = :flConferida"),
    @NamedQuery(name = "VwRespostasComProblema.findByFlErroImagem", query = "SELECT v FROM VwRespostasComProblema v WHERE v.flErroImagem = :flErroImagem"),
    @NamedQuery(name = "VwRespostasComProblema.findByFlRespostaEmBranco", query = "SELECT v FROM VwRespostasComProblema v WHERE v.flRespostaEmBranco = :flRespostaEmBranco"),
    @NamedQuery(name = "VwRespostasComProblema.findByDtUltimaAtualizacao", query = "SELECT v FROM VwRespostasComProblema v WHERE v.dtUltimaAtualizacao = :dtUltimaAtualizacao"),
    @NamedQuery(name = "VwRespostasComProblema.findByFlEmBrancoConferida", query = "SELECT v FROM VwRespostasComProblema v WHERE v.flEmBrancoConferida = :flEmBrancoConferida"),
    @NamedQuery(name = "VwRespostasComProblema.findByNmDisciplina", query = "SELECT v FROM VwRespostasComProblema v WHERE v.nmDisciplina = :nmDisciplina"),
    @NamedQuery(name = "VwRespostasComProblema.findByNmCurso", query = "SELECT v FROM VwRespostasComProblema v WHERE v.nmCurso = :nmCurso")})
public class VwRespostasComProblema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_resposta")
    @Id
    private BigInteger idResposta;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Column(name = "cd_serial")
    private String cdSerial;
    @Column(name = "nr_questao")
    private Integer nrQuestao;
    @Column(name = "id_processo")
    private Integer idProcesso;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nr_nota_final")
    private Double nrNotaFinal;
    @Column(name = "fl_discrepancia")
    private Boolean flDiscrepancia;
    @Column(name = "fl_discrepancia_corrigida")
    private Boolean flDiscrepanciaCorrigida;
    @Column(name = "fl_corrigida")
    private Boolean flCorrigida;
    @Column(name = "id_colaborador_atual")
    private BigInteger idColaboradorAtual;
    @Column(name = "fl_corrigindo")
    private Boolean flCorrigindo;
    @Column(name = "id_curso")
    private Integer idCurso;
    @Column(name = "id_inscricao")
    private BigInteger idInscricao;
    @Column(name = "dt_insercao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInsercao;
    @Column(name = "fl_resposta_com_erro")
    private Boolean flRespostaComErro;
    @Column(name = "fl_primeira_correcao")
    private Boolean flPrimeiraCorrecao;
    @Column(name = "fl_segunda_correcao")
    private Boolean flSegundaCorrecao;
    @Column(name = "id_resposta_imagem")
    private BigInteger idRespostaImagem;
    @Column(name = "dt_importacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtImportacao;
    @Column(name = "fl_conferida")
    private Boolean flConferida;
    @Column(name = "fl_erro_imagem")
    private Boolean flErroImagem;
    @Column(name = "fl_resposta_em_branco")
    private Boolean flRespostaEmBranco;
    @Column(name = "dt_ultima_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtUltimaAtualizacao;
    @Column(name = "fl_em_branco_conferida")
    private Boolean flEmBrancoConferida;
    @Column(name = "nm_disciplina")
    private String nmDisciplina;
    @Column(name = "nm_curso")
    private String nmCurso;

    public VwRespostasComProblema() {
    }

    public BigInteger getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(BigInteger idResposta) {
        this.idResposta = idResposta;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getCdSerial() {
        return cdSerial;
    }

    public void setCdSerial(String cdSerial) {
        this.cdSerial = cdSerial;
    }

    public Integer getNrQuestao() {
        return nrQuestao;
    }

    public void setNrQuestao(Integer nrQuestao) {
        this.nrQuestao = nrQuestao;
    }

    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    public Double getNrNotaFinal() {
        return nrNotaFinal;
    }

    public void setNrNotaFinal(Double nrNotaFinal) {
        this.nrNotaFinal = nrNotaFinal;
    }

    public Boolean getFlDiscrepancia() {
        return flDiscrepancia;
    }

    public void setFlDiscrepancia(Boolean flDiscrepancia) {
        this.flDiscrepancia = flDiscrepancia;
    }

    public Boolean getFlDiscrepanciaCorrigida() {
        return flDiscrepanciaCorrigida;
    }

    public void setFlDiscrepanciaCorrigida(Boolean flDiscrepanciaCorrigida) {
        this.flDiscrepanciaCorrigida = flDiscrepanciaCorrigida;
    }

    public Boolean getFlCorrigida() {
        return flCorrigida;
    }

    public void setFlCorrigida(Boolean flCorrigida) {
        this.flCorrigida = flCorrigida;
    }

    public BigInteger getIdColaboradorAtual() {
        return idColaboradorAtual;
    }

    public void setIdColaboradorAtual(BigInteger idColaboradorAtual) {
        this.idColaboradorAtual = idColaboradorAtual;
    }

    public Boolean getFlCorrigindo() {
        return flCorrigindo;
    }

    public void setFlCorrigindo(Boolean flCorrigindo) {
        this.flCorrigindo = flCorrigindo;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public BigInteger getIdInscricao() {
        return idInscricao;
    }

    public void setIdInscricao(BigInteger idInscricao) {
        this.idInscricao = idInscricao;
    }

    public Date getDtInsercao() {
        return dtInsercao;
    }

    public void setDtInsercao(Date dtInsercao) {
        this.dtInsercao = dtInsercao;
    }

    public Boolean getFlRespostaComErro() {
        return flRespostaComErro;
    }

    public void setFlRespostaComErro(Boolean flRespostaComErro) {
        this.flRespostaComErro = flRespostaComErro;
    }

    public Boolean getFlPrimeiraCorrecao() {
        return flPrimeiraCorrecao;
    }

    public void setFlPrimeiraCorrecao(Boolean flPrimeiraCorrecao) {
        this.flPrimeiraCorrecao = flPrimeiraCorrecao;
    }

    public Boolean getFlSegundaCorrecao() {
        return flSegundaCorrecao;
    }

    public void setFlSegundaCorrecao(Boolean flSegundaCorrecao) {
        this.flSegundaCorrecao = flSegundaCorrecao;
    }

    public BigInteger getIdRespostaImagem() {
        return idRespostaImagem;
    }

    public void setIdRespostaImagem(BigInteger idRespostaImagem) {
        this.idRespostaImagem = idRespostaImagem;
    }

    public Date getDtImportacao() {
        return dtImportacao;
    }

    public void setDtImportacao(Date dtImportacao) {
        this.dtImportacao = dtImportacao;
    }

    public Boolean getFlConferida() {
        return flConferida;
    }

    public void setFlConferida(Boolean flConferida) {
        this.flConferida = flConferida;
    }

    public Boolean getFlErroImagem() {
        return flErroImagem;
    }

    public void setFlErroImagem(Boolean flErroImagem) {
        this.flErroImagem = flErroImagem;
    }

    public Boolean getFlRespostaEmBranco() {
        return flRespostaEmBranco;
    }

    public void setFlRespostaEmBranco(Boolean flRespostaEmBranco) {
        this.flRespostaEmBranco = flRespostaEmBranco;
    }

    public Date getDtUltimaAtualizacao() {
        return dtUltimaAtualizacao;
    }

    public void setDtUltimaAtualizacao(Date dtUltimaAtualizacao) {
        this.dtUltimaAtualizacao = dtUltimaAtualizacao;
    }

    public Boolean getFlEmBrancoConferida() {
        return flEmBrancoConferida;
    }

    public void setFlEmBrancoConferida(Boolean flEmBrancoConferida) {
        this.flEmBrancoConferida = flEmBrancoConferida;
    }

    public String getNmDisciplina() {
        return nmDisciplina;
    }

    public void setNmDisciplina(String nmDisciplina) {
        this.nmDisciplina = nmDisciplina;
    }

    public String getNmCurso() {
        return nmCurso;
    }

    public void setNmCurso(String nmCurso) {
        this.nmCurso = nmCurso;
    }
    
}
