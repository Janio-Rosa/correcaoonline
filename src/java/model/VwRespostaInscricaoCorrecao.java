/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import util.Uteis;

/**
 *
 * @author administrator
 */
@Entity
@Table(name = "vw_resposta_inscricao_correcao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwRespostaInscricaoCorrecao.findAll", query = "SELECT v FROM VwRespostaInscricaoCorrecao v"),
    @NamedQuery(name = "VwRespostaInscricaoCorrecao.findByNrQuestao", query = "SELECT v FROM VwRespostaInscricaoCorrecao v WHERE v.nrQuestao = :nrQuestao"),
    @NamedQuery(name = "VwRespostaInscricaoCorrecao.findByIdResposta", query = "SELECT v FROM VwRespostaInscricaoCorrecao v WHERE v.idResposta = :idResposta"),
    @NamedQuery(name = "VwRespostaInscricaoCorrecao.findByNrNotaFinal", query = "SELECT v FROM VwRespostaInscricaoCorrecao v WHERE v.nrNotaFinal = :nrNotaFinal"),
    @NamedQuery(name = "VwRespostaInscricaoCorrecao.findByFlPrimeiraCorrecao", query = "SELECT v FROM VwRespostaInscricaoCorrecao v WHERE v.flPrimeiraCorrecao = :flPrimeiraCorrecao"),
    @NamedQuery(name = "VwRespostaInscricaoCorrecao.findByFlSegundaCorrecao", query = "SELECT v FROM VwRespostaInscricaoCorrecao v WHERE v.flSegundaCorrecao = :flSegundaCorrecao"),
    @NamedQuery(name = "VwRespostaInscricaoCorrecao.findByFlDiscrepancia", query = "SELECT v FROM VwRespostaInscricaoCorrecao v WHERE v.flDiscrepancia = :flDiscrepancia"),
    @NamedQuery(name = "VwRespostaInscricaoCorrecao.findByFlDiscrepanciaCorrigida", query = "SELECT v FROM VwRespostaInscricaoCorrecao v WHERE v.flDiscrepanciaCorrigida = :flDiscrepanciaCorrigida"),
    @NamedQuery(name = "VwRespostaInscricaoCorrecao.findByFlRespostaComErro", query = "SELECT v FROM VwRespostaInscricaoCorrecao v WHERE v.flRespostaComErro = :flRespostaComErro"),
    @NamedQuery(name = "VwRespostaInscricaoCorrecao.findByNrInscricao", query = "SELECT v FROM VwRespostaInscricaoCorrecao v WHERE v.nrInscricao = :nrInscricao"),
    @NamedQuery(name = "VwRespostaInscricaoCorrecao.findByIdInscricao", query = "SELECT v FROM VwRespostaInscricaoCorrecao v WHERE v.idInscricao = :idInscricao"),
    @NamedQuery(name = "VwRespostaInscricaoCorrecao.findByIdProcesso", query = "SELECT v FROM VwRespostaInscricaoCorrecao v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwRespostaInscricaoCorrecao.findByIdCurso", query = "SELECT v FROM VwRespostaInscricaoCorrecao v WHERE v.idCurso = :idCurso")})
public class VwRespostaInscricaoCorrecao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "nr_questao")
    private Integer nrQuestao;
    @Column(name = "id_resposta")
    @Id
    private Long idResposta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nr_nota_final")
    private Double nrNotaFinal;
    @Column(name = "fl_primeira_correcao")
    private Boolean flPrimeiraCorrecao;
    @Column(name = "fl_segunda_correcao")
    private Boolean flSegundaCorrecao;
    @Column(name = "fl_terceira_correcao")
    private Boolean flTerceiraCorrecao;
    @Column(name = "fl_discrepancia")
    private Boolean flDiscrepancia;
    @Column(name = "fl_discrepancia_corrigida")
    private Boolean flDiscrepanciaCorrigida;
    @Column(name = "fl_resposta_com_erro")
    private Boolean flRespostaComErro;
    @Column(name = "nr_inscricao")
    private Integer nrInscricao;
    @Column(name = "id_inscricao")
    private BigInteger idInscricao;
    @Column(name = "id_processo")
    private Integer idProcesso;
    @Column(name = "id_curso")
    private Integer idCurso;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;

    public VwRespostaInscricaoCorrecao() {
    }

    public Integer getNrQuestao() {
        return nrQuestao;
    }

    public void setNrQuestao(Integer nrQuestao) {
        this.nrQuestao = nrQuestao;
    }

    public Double getNrNotaFinal() {
        return nrNotaFinal;
    }

    public void setNrNotaFinal(Double nrNotaFinal) {
        this.nrNotaFinal = nrNotaFinal;
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

    public Boolean getFlRespostaComErro() {
        return flRespostaComErro;
    }

    public void setFlRespostaComErro(Boolean flRespostaComErro) {
        this.flRespostaComErro = flRespostaComErro;
    }

    public Integer getNrInscricao() {
        return nrInscricao;
    }

    public void setNrInscricao(Integer nrInscricao) {
        this.nrInscricao = nrInscricao;
    }

    public BigInteger getIdInscricao() {
        return idInscricao;
    }

    public void setIdInscricao(BigInteger idInscricao) {
        this.idInscricao = idInscricao;
    }

    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Long getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Long idResposta) {
        this.idResposta = idResposta;
    }

    public Boolean getFlTerceiraCorrecao() {
        return flTerceiraCorrecao;
    }

    public void setFlTerceiraCorrecao(Boolean flTerceiraCorrecao) {
        this.flTerceiraCorrecao = flTerceiraCorrecao;
    }

    @Override
    public String toString() {
        return "VwRespostaInscricaoCorrecao{" + "nrQuestao=" + nrQuestao + ", idResposta=" + idResposta + ", nrNotaFinal=" + nrNotaFinal + ", nrInscricao=" + nrInscricao + ", idInscricao=" + idInscricao + ", idProcesso=" + idProcesso + ", idCurso=" + idCurso + '}';
    }

    public String getNotaConvertida() {
        if(this.getNrNotaFinal()!=null)
            return String.valueOf(Uteis.arredonda(this.getNrNotaFinal(), 2));
        return "";
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }
    
    
}
