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
 * @author KAMYLLA
 */
@Entity
@Table(name = "vw_processo_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwProcessoCurso.findAll", query = "SELECT v FROM VwProcessoCurso v"),
    @NamedQuery(name = "VwProcessoCurso.findByIdResposta", query = "SELECT v FROM VwProcessoCurso v WHERE v.idResposta = :idResposta"),
    @NamedQuery(name = "VwProcessoCurso.findByIdDisciplina", query = "SELECT v FROM VwProcessoCurso v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwProcessoCurso.findByCdSerial", query = "SELECT v FROM VwProcessoCurso v WHERE v.cdSerial = :cdSerial"),
    @NamedQuery(name = "VwProcessoCurso.findByNrQuestao", query = "SELECT v FROM VwProcessoCurso v WHERE v.nrQuestao = :nrQuestao"),
    @NamedQuery(name = "VwProcessoCurso.findByIdProcesso", query = "SELECT v FROM VwProcessoCurso v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwProcessoCurso.findByNrNotaFinal", query = "SELECT v FROM VwProcessoCurso v WHERE v.nrNotaFinal = :nrNotaFinal"),
    @NamedQuery(name = "VwProcessoCurso.findByFlDiscrepancia", query = "SELECT v FROM VwProcessoCurso v WHERE v.flDiscrepancia = :flDiscrepancia"),
    @NamedQuery(name = "VwProcessoCurso.findByFlDiscrepanciaCorrigida", query = "SELECT v FROM VwProcessoCurso v WHERE v.flDiscrepanciaCorrigida = :flDiscrepanciaCorrigida"),
    @NamedQuery(name = "VwProcessoCurso.findByFlCorrigida", query = "SELECT v FROM VwProcessoCurso v WHERE v.flCorrigida = :flCorrigida"),
    @NamedQuery(name = "VwProcessoCurso.findByIdColaboradorAtual", query = "SELECT v FROM VwProcessoCurso v WHERE v.idColaboradorAtual = :idColaboradorAtual"),
    @NamedQuery(name = "VwProcessoCurso.findByFlCorrigindo", query = "SELECT v FROM VwProcessoCurso v WHERE v.flCorrigindo = :flCorrigindo"),
    @NamedQuery(name = "VwProcessoCurso.findByIdCurso", query = "SELECT v FROM VwProcessoCurso v WHERE v.idCurso = :idCurso"),
    @NamedQuery(name = "VwProcessoCurso.findByIdInscricao", query = "SELECT v FROM VwProcessoCurso v WHERE v.idInscricao = :idInscricao"),
    @NamedQuery(name = "VwProcessoCurso.findByDtInsercao", query = "SELECT v FROM VwProcessoCurso v WHERE v.dtInsercao = :dtInsercao"),
    @NamedQuery(name = "VwProcessoCurso.findByFlRespostaComErro", query = "SELECT v FROM VwProcessoCurso v WHERE v.flRespostaComErro = :flRespostaComErro"),
    @NamedQuery(name = "VwProcessoCurso.findByFlPrimeiraCorrecao", query = "SELECT v FROM VwProcessoCurso v WHERE v.flPrimeiraCorrecao = :flPrimeiraCorrecao"),
    @NamedQuery(name = "VwProcessoCurso.findByFlSegundaCorrecao", query = "SELECT v FROM VwProcessoCurso v WHERE v.flSegundaCorrecao = :flSegundaCorrecao"),
    @NamedQuery(name = "VwProcessoCurso.findByNmProcesso", query = "SELECT v FROM VwProcessoCurso v WHERE v.nmProcesso = :nmProcesso"),
    @NamedQuery(name = "VwProcessoCurso.findByDtValidadeFinal", query = "SELECT v FROM VwProcessoCurso v WHERE v.dtValidadeFinal = :dtValidadeFinal"),
    @NamedQuery(name = "VwProcessoCurso.findByDtValidadeInicial", query = "SELECT v FROM VwProcessoCurso v WHERE v.dtValidadeInicial = :dtValidadeInicial"),
    @NamedQuery(name = "VwProcessoCurso.findByNmCurso", query = "SELECT v FROM VwProcessoCurso v WHERE v.nmCurso = :nmCurso"),
    @NamedQuery(name = "VwProcessoCurso.findByNrLinha", query = "SELECT v FROM VwProcessoCurso v WHERE v.nrLinha = :nrLinha")})
public class VwProcessoCurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_resposta")
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
    @Column(name = "nm_processo")
    private String nmProcesso;
    @Column(name = "dt_validade_final")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtValidadeFinal;
    @Column(name = "dt_validade_inicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtValidadeInicial;
    @Column(name = "nm_curso")
    private String nmCurso;
    @Column(name = "nr_linha")
    @Id
    private BigInteger nrLinha;

    public VwProcessoCurso() {
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

    public String getNmProcesso() {
        return nmProcesso;
    }

    public void setNmProcesso(String nmProcesso) {
        this.nmProcesso = nmProcesso;
    }

    public Date getDtValidadeFinal() {
        return dtValidadeFinal;
    }

    public void setDtValidadeFinal(Date dtValidadeFinal) {
        this.dtValidadeFinal = dtValidadeFinal;
    }

    public Date getDtValidadeInicial() {
        return dtValidadeInicial;
    }

    public void setDtValidadeInicial(Date dtValidadeInicial) {
        this.dtValidadeInicial = dtValidadeInicial;
    }

    public String getNmCurso() {
        return nmCurso;
    }

    public void setNmCurso(String nmCurso) {
        this.nmCurso = nmCurso;
    }

    public BigInteger getNrLinha() {
        return nrLinha;
    }

    public void setNrLinha(BigInteger nrLinha) {
        this.nrLinha = nrLinha;
    }
    
}
