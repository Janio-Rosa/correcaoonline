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
 * @author administrator
 */
@Entity
@Table(name = "vw_resposta_2a_correcao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwResposta2aCorrecao.findAll", query = "SELECT v FROM VwResposta2aCorrecao v"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByIdResposta", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.idResposta = :idResposta"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByIdDisciplina", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByCdSerial", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.cdSerial = :cdSerial"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByNrQuestao", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.nrQuestao = :nrQuestao"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByIdProcesso", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByNrNotaFinal", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.nrNotaFinal = :nrNotaFinal"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByFlDiscrepancia", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.flDiscrepancia = :flDiscrepancia"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByFlDiscrepanciaCorrigida", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.flDiscrepanciaCorrigida = :flDiscrepanciaCorrigida"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByFlCorrigida", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.flCorrigida = :flCorrigida"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByIdColaboradorAtual", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.idColaboradorAtual = :idColaboradorAtual"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByFlCorrigindo", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.flCorrigindo = :flCorrigindo"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByIdCurso", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.idCurso = :idCurso"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByDtInsercaoResposta", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.dtInsercaoResposta = :dtInsercaoResposta"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByDtInsercao", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.dtInsercao = :dtInsercao"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByFlRespostaComErro", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.flRespostaComErro = :flRespostaComErro"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByFlPrimeiraCorrecao", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.flPrimeiraCorrecao = :flPrimeiraCorrecao"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByFlSegundaCorrecao", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.flSegundaCorrecao = :flSegundaCorrecao"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByIdCorrecao", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.idCorrecao = :idCorrecao"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByIdColaborador", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.idColaborador = :idColaborador"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByNrNota", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.nrNota = :nrNota"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByDtAtualizacao", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.dtAtualizacao = :dtAtualizacao"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByIdTipoCorrecao", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.idTipoCorrecao = :idTipoCorrecao"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByFlSucesso", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.flSucesso = :flSucesso"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByDtInsercaoCorrecao", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.dtInsercaoCorrecao = :dtInsercaoCorrecao"),
    @NamedQuery(name = "VwResposta2aCorrecao.findByIdInscricao", query = "SELECT v FROM VwResposta2aCorrecao v WHERE v.idInscricao = :idInscricao")})
public class VwResposta2aCorrecao implements Serializable {
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
    @Column(name = "dt_insercao_resposta")
    private BigInteger dtInsercaoResposta;
    @Column(name = "dt_insercao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInsercao;
    @Column(name = "fl_resposta_com_erro")
    private Boolean flRespostaComErro;
    @Column(name = "fl_primeira_correcao")
    private Boolean flPrimeiraCorrecao;
    @Column(name = "fl_segunda_correcao")
    private Boolean flSegundaCorrecao;
    @Column(name = "id_correcao")
    private BigInteger idCorrecao;
    @Column(name = "id_colaborador")
    private BigInteger idColaborador;
    @Column(name = "nr_nota")
    private Double nrNota;
    @Column(name = "dt_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAtualizacao;
    @Column(name = "id_tipo_correcao")
    private Integer idTipoCorrecao;
    @Column(name = "fl_sucesso")
    private Boolean flSucesso;
    @Column(name = "dt_insercao_correcao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInsercaoCorrecao;
    @Column(name = "id_inscricao")
    private BigInteger idInscricao;

    public VwResposta2aCorrecao() {
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

    public BigInteger getDtInsercaoResposta() {
        return dtInsercaoResposta;
    }

    public void setDtInsercaoResposta(BigInteger dtInsercaoResposta) {
        this.dtInsercaoResposta = dtInsercaoResposta;
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

    public BigInteger getIdCorrecao() {
        return idCorrecao;
    }

    public void setIdCorrecao(BigInteger idCorrecao) {
        this.idCorrecao = idCorrecao;
    }

    public BigInteger getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(BigInteger idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Double getNrNota() {
        return nrNota;
    }

    public void setNrNota(Double nrNota) {
        this.nrNota = nrNota;
    }

    public Date getDtAtualizacao() {
        return dtAtualizacao;
    }

    public void setDtAtualizacao(Date dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }

    public Integer getIdTipoCorrecao() {
        return idTipoCorrecao;
    }

    public void setIdTipoCorrecao(Integer idTipoCorrecao) {
        this.idTipoCorrecao = idTipoCorrecao;
    }

    public Boolean getFlSucesso() {
        return flSucesso;
    }

    public void setFlSucesso(Boolean flSucesso) {
        this.flSucesso = flSucesso;
    }

    public Date getDtInsercaoCorrecao() {
        return dtInsercaoCorrecao;
    }

    public void setDtInsercaoCorrecao(Date dtInsercaoCorrecao) {
        this.dtInsercaoCorrecao = dtInsercaoCorrecao;
    }

    public BigInteger getIdInscricao() {
        return idInscricao;
    }

    public void setIdInscricao(BigInteger idInscricao) {
        this.idInscricao = idInscricao;
    }
    
}
