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
@Table(name = "vw_processo_disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwProcessoDisciplina.findAll", query = "SELECT v FROM VwProcessoDisciplina v"),
    @NamedQuery(name = "VwProcessoDisciplina.findByIdResposta", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.idResposta = :idResposta"),
    @NamedQuery(name = "VwProcessoDisciplina.findByIdDisciplina", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwProcessoDisciplina.findByCdSerial", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.cdSerial = :cdSerial"),
    @NamedQuery(name = "VwProcessoDisciplina.findByNrQuestao", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.nrQuestao = :nrQuestao"),
    @NamedQuery(name = "VwProcessoDisciplina.findByIdProcesso", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwProcessoDisciplina.findByNrNotaFinal", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.nrNotaFinal = :nrNotaFinal"),
    @NamedQuery(name = "VwProcessoDisciplina.findByFlDiscrepancia", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.flDiscrepancia = :flDiscrepancia"),
    @NamedQuery(name = "VwProcessoDisciplina.findByFlDiscrepanciaCorrigida", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.flDiscrepanciaCorrigida = :flDiscrepanciaCorrigida"),
    @NamedQuery(name = "VwProcessoDisciplina.findByFlCorrigida", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.flCorrigida = :flCorrigida"),
    @NamedQuery(name = "VwProcessoDisciplina.findByIdColaboradorAtual", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.idColaboradorAtual = :idColaboradorAtual"),
    @NamedQuery(name = "VwProcessoDisciplina.findByFlCorrigindo", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.flCorrigindo = :flCorrigindo"),
    @NamedQuery(name = "VwProcessoDisciplina.findByIdCurso", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.idCurso = :idCurso"),
    @NamedQuery(name = "VwProcessoDisciplina.findByIdInscricao", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.idInscricao = :idInscricao"),
    @NamedQuery(name = "VwProcessoDisciplina.findByDtInsercao", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.dtInsercao = :dtInsercao"),
    @NamedQuery(name = "VwProcessoDisciplina.findByFlRespostaComErro", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.flRespostaComErro = :flRespostaComErro"),
    @NamedQuery(name = "VwProcessoDisciplina.findByFlPrimeiraCorrecao", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.flPrimeiraCorrecao = :flPrimeiraCorrecao"),
    @NamedQuery(name = "VwProcessoDisciplina.findByFlSegundaCorrecao", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.flSegundaCorrecao = :flSegundaCorrecao"),
    @NamedQuery(name = "VwProcessoDisciplina.findByNmProcesso", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.nmProcesso = :nmProcesso"),
    @NamedQuery(name = "VwProcessoDisciplina.findByDtValidadeFinal", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.dtValidadeFinal = :dtValidadeFinal"),
    @NamedQuery(name = "VwProcessoDisciplina.findByDtValidadeInicial", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.dtValidadeInicial = :dtValidadeInicial"),
    @NamedQuery(name = "VwProcessoDisciplina.findByNmDisciplina", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.nmDisciplina = :nmDisciplina"),
    @NamedQuery(name = "VwProcessoDisciplina.findByIdTipoQuestao", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.idTipoQuestao = :idTipoQuestao"),
    @NamedQuery(name = "VwProcessoDisciplina.findByNrNotaInicial", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.nrNotaInicial = :nrNotaInicial"),
    @NamedQuery(name = "VwProcessoDisciplina.findByNrLinha", query = "SELECT v FROM VwProcessoDisciplina v WHERE v.nrLinha = :nrLinha")})
public class VwProcessoDisciplina implements Serializable {
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
    @Column(name = "nm_disciplina")
    private String nmDisciplina;
    @Column(name = "id_tipo_questao")
    private Integer idTipoQuestao;
    @Column(name = "nr_nota_inicial")
    private Double nrNotaInicial;
    @Column(name = "nr_linha")
    @Id
    private BigInteger nrLinha;

    public VwProcessoDisciplina() {
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

    public String getNmDisciplina() {
        return nmDisciplina;
    }

    public void setNmDisciplina(String nmDisciplina) {
        this.nmDisciplina = nmDisciplina;
    }

    public Integer getIdTipoQuestao() {
        return idTipoQuestao;
    }

    public void setIdTipoQuestao(Integer idTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
    }

    public Double getNrNotaInicial() {
        return nrNotaInicial;
    }

    public void setNrNotaInicial(Double nrNotaInicial) {
        this.nrNotaInicial = nrNotaInicial;
    }

    public BigInteger getNrLinha() {
        return nrLinha;
    }

    public void setNrLinha(BigInteger nrLinha) {
        this.nrLinha = nrLinha;
    }
    
}
