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
 * @author Janio
 */
@Entity
@Table(name = "vw_relatorio_discrepancia_corretor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwRelatorioDiscrepanciaCorretor.findAll", query = "SELECT v FROM VwRelatorioDiscrepanciaCorretor v"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaCorretor.findByNrLinha", query = "SELECT v FROM VwRelatorioDiscrepanciaCorretor v WHERE v.nrLinha = :nrLinha"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaCorretor.findByIdResposta", query = "SELECT v FROM VwRelatorioDiscrepanciaCorretor v WHERE v.idResposta = :idResposta"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaCorretor.findByNrNota1", query = "SELECT v FROM VwRelatorioDiscrepanciaCorretor v WHERE v.nrNota1 = :nrNota1"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaCorretor.findByNrNota2", query = "SELECT v FROM VwRelatorioDiscrepanciaCorretor v WHERE v.nrNota2 = :nrNota2"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaCorretor.findByNrDiferenca", query = "SELECT v FROM VwRelatorioDiscrepanciaCorretor v WHERE v.nrDiferenca = :nrDiferenca"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaCorretor.findByIdCurso", query = "SELECT v FROM VwRelatorioDiscrepanciaCorretor v WHERE v.idCurso = :idCurso"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaCorretor.findByIdProcesso", query = "SELECT v FROM VwRelatorioDiscrepanciaCorretor v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaCorretor.findByIdDisciplina", query = "SELECT v FROM VwRelatorioDiscrepanciaCorretor v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaCorretor.findByNrQuestao", query = "SELECT v FROM VwRelatorioDiscrepanciaCorretor v WHERE v.nrQuestao = :nrQuestao"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaCorretor.findByNrNotaDiscrepancia", query = "SELECT v FROM VwRelatorioDiscrepanciaCorretor v WHERE v.nrNotaDiscrepancia = :nrNotaDiscrepancia"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaCorretor.findByNrNotaFinal", query = "SELECT v FROM VwRelatorioDiscrepanciaCorretor v WHERE v.nrNotaFinal = :nrNotaFinal"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaCorretor.findByNmCorretor1", query = "SELECT v FROM VwRelatorioDiscrepanciaCorretor v WHERE v.nmCorretor1 = :nmCorretor1"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaCorretor.findByNrCpfCorretor1", query = "SELECT v FROM VwRelatorioDiscrepanciaCorretor v WHERE v.nrCpfCorretor1 = :nrCpfCorretor1"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaCorretor.findByNmCorretor2", query = "SELECT v FROM VwRelatorioDiscrepanciaCorretor v WHERE v.nmCorretor2 = :nmCorretor2"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaCorretor.findByNrCpfCorretor2", query = "SELECT v FROM VwRelatorioDiscrepanciaCorretor v WHERE v.nrCpfCorretor2 = :nrCpfCorretor2"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaCorretor.findByIdColaboradorCorretor1", query = "SELECT v FROM VwRelatorioDiscrepanciaCorretor v WHERE v.idColaboradorCorretor1 = :idColaboradorCorretor1"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaCorretor.findByIdColaboradorCorretor2", query = "SELECT v FROM VwRelatorioDiscrepanciaCorretor v WHERE v.idColaboradorCorretor2 = :idColaboradorCorretor2")})
public class VwRelatorioDiscrepanciaCorretor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "nr_linha")
    @Id
    private BigInteger nrLinha;
    @Column(name = "id_resposta")
    private Long idResposta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nr_nota1")
    private Double nrNota1;
    @Column(name = "nr_nota2")
    private Double nrNota2;
    @Column(name = "nr_diferenca")
    private Double nrDiferenca;
    @Column(name = "id_curso")
    private Integer idCurso;
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
    @Column(name = "nm_corretor1")
    private String nmCorretor1;
    @Column(name = "nr_cpf_corretor1")
    private String nrCpfCorretor1;
    @Column(name = "nm_corretor2")
    private String nmCorretor2;
    @Column(name = "nr_cpf_corretor2")
    private String nrCpfCorretor2;
    @Column(name = "id_colaborador_corretor1")
    private BigInteger idColaboradorCorretor1;
    @Column(name = "id_colaborador_corretor2")
    private BigInteger idColaboradorCorretor2;

    public VwRelatorioDiscrepanciaCorretor() {
    }

    public BigInteger getNrLinha() {
        return nrLinha;
    }

    public void setNrLinha(BigInteger nrLinha) {
        this.nrLinha = nrLinha;
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

    public String getNmCorretor1() {
        return nmCorretor1;
    }

    public void setNmCorretor1(String nmCorretor1) {
        this.nmCorretor1 = nmCorretor1;
    }

    public String getNrCpfCorretor1() {
        return nrCpfCorretor1;
    }

    public void setNrCpfCorretor1(String nrCpfCorretor1) {
        this.nrCpfCorretor1 = nrCpfCorretor1;
    }

    public String getNmCorretor2() {
        return nmCorretor2;
    }

    public void setNmCorretor2(String nmCorretor2) {
        this.nmCorretor2 = nmCorretor2;
    }

    public String getNrCpfCorretor2() {
        return nrCpfCorretor2;
    }

    public void setNrCpfCorretor2(String nrCpfCorretor2) {
        this.nrCpfCorretor2 = nrCpfCorretor2;
    }

    public BigInteger getIdColaboradorCorretor1() {
        return idColaboradorCorretor1;
    }

    public void setIdColaboradorCorretor1(BigInteger idColaboradorCorretor1) {
        this.idColaboradorCorretor1 = idColaboradorCorretor1;
    }

    public BigInteger getIdColaboradorCorretor2() {
        return idColaboradorCorretor2;
    }

    public void setIdColaboradorCorretor2(BigInteger idColaboradorCorretor2) {
        this.idColaboradorCorretor2 = idColaboradorCorretor2;
    }

    public Long getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Long idResposta) {
        this.idResposta = idResposta;
    }

    
}
