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

/**
 *
 * @author janio
 */
@Entity
@Table(name = "vw_relatorio_discrepancia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwRelatorioDiscrepancia.findAll", query = "SELECT v FROM VwRelatorioDiscrepancia v"),
    @NamedQuery(name = "VwRelatorioDiscrepancia.findByIdResposta", query = "SELECT v FROM VwRelatorioDiscrepancia v WHERE v.idResposta = :idResposta"),
    @NamedQuery(name = "VwRelatorioDiscrepancia.findByNrNota1", query = "SELECT v FROM VwRelatorioDiscrepancia v WHERE v.nrNota1 = :nrNota1"),
    @NamedQuery(name = "VwRelatorioDiscrepancia.findByNrNota2", query = "SELECT v FROM VwRelatorioDiscrepancia v WHERE v.nrNota2 = :nrNota2"),
    @NamedQuery(name = "VwRelatorioDiscrepancia.findByNrDiferenca", query = "SELECT v FROM VwRelatorioDiscrepancia v WHERE v.nrDiferenca = :nrDiferenca"),
    @NamedQuery(name = "VwRelatorioDiscrepancia.findByIdCurso", query = "SELECT v FROM VwRelatorioDiscrepancia v WHERE v.idCurso = :idCurso"),
    @NamedQuery(name = "VwRelatorioDiscrepancia.findByNrLinha", query = "SELECT v FROM VwRelatorioDiscrepancia v WHERE v.nrLinha = :nrLinha"),
    @NamedQuery(name = "VwRelatorioDiscrepancia.findByIdProcesso", query = "SELECT v FROM VwRelatorioDiscrepancia v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwRelatorioDiscrepancia.findByIdDisciplina", query = "SELECT v FROM VwRelatorioDiscrepancia v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwRelatorioDiscrepancia.findByNrQuestao", query = "SELECT v FROM VwRelatorioDiscrepancia v WHERE v.nrQuestao = :nrQuestao"),
    @NamedQuery(name = "VwRelatorioDiscrepancia.findByNrNotaDiscrepancia", query = "SELECT v FROM VwRelatorioDiscrepancia v WHERE v.nrNotaDiscrepancia = :nrNotaDiscrepancia"),
    @NamedQuery(name = "VwRelatorioDiscrepancia.findByNrNotaFinal", query = "SELECT v FROM VwRelatorioDiscrepancia v WHERE v.nrNotaFinal = :nrNotaFinal"),
    @NamedQuery(name = "VwRelatorioDiscrepancia.findByIdCorrecaoDiscrepancia", query = "SELECT v FROM VwRelatorioDiscrepancia v WHERE v.idCorrecaoDiscrepancia = :idCorrecaoDiscrepancia")})
public class VwRelatorioDiscrepancia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_resposta")
    @Id
    private BigInteger idResposta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nr_nota1")
    private Double nrNota1;
    @Column(name = "nr_nota2")
    private Double nrNota2;
    @Column(name = "nr_diferenca")
    private Double nrDiferenca;
    @Column(name = "id_curso")
    private Integer idCurso;
    @Column(name = "nr_linha")
    private BigInteger nrLinha;
    @Column(name = "id_processo")
    private Integer idProcesso;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Column(name = "nr_questao")
    private Integer nrQuestao;
    @Column(name = "nr_nota_discrepancia")
    private Double nrNotaDiscrepancia;
    @Column(name = "nr_nota_final")
    private Double nrNotaFinal;
    @Column(name = "id_correcao_discrepancia")
    private BigInteger idCorrecaoDiscrepancia;

    public VwRelatorioDiscrepancia() {
    }

    public BigInteger getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(BigInteger idResposta) {
        this.idResposta = idResposta;
    }

    public Double getNrNota1() {
        return nrNota1;
    }

    public void setNrNota1(Double nrNota1) {
        this.nrNota1 = nrNota1;
    }

    public Double getNrNota2() {
        return nrNota2;
    }

    public void setNrNota2(Double nrNota2) {
        this.nrNota2 = nrNota2;
    }

    public Double getNrDiferenca() {
        return nrDiferenca;
    }

    public void setNrDiferenca(Double nrDiferenca) {
        this.nrDiferenca = nrDiferenca;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public BigInteger getNrLinha() {
        return nrLinha;
    }

    public void setNrLinha(BigInteger nrLinha) {
        this.nrLinha = nrLinha;
    }

    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Integer getNrQuestao() {
        return nrQuestao;
    }

    public void setNrQuestao(Integer nrQuestao) {
        this.nrQuestao = nrQuestao;
    }

    public Double getNrNotaDiscrepancia() {
        return nrNotaDiscrepancia;
    }

    public void setNrNotaDiscrepancia(Double nrNotaDiscrepancia) {
        this.nrNotaDiscrepancia = nrNotaDiscrepancia;
    }

    public Double getNrNotaFinal() {
        return nrNotaFinal;
    }

    public void setNrNotaFinal(Double nrNotaFinal) {
        this.nrNotaFinal = nrNotaFinal;
    }

    public BigInteger getIdCorrecaoDiscrepancia() {
        return idCorrecaoDiscrepancia;
    }

    public void setIdCorrecaoDiscrepancia(BigInteger idCorrecaoDiscrepancia) {
        this.idCorrecaoDiscrepancia = idCorrecaoDiscrepancia;
    }
    
}
