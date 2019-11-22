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
 * @author KAMYLLA
 */
@Entity
@Table(name = "vw_estatistica_correcao_tipo_correcao_consolidado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwEstatisticaCorrecaoTipoCorrecaoConsolidado.findAll", query = "SELECT v FROM VwEstatisticaCorrecaoTipoCorrecaoConsolidado v"),
    @NamedQuery(name = "VwEstatisticaCorrecaoTipoCorrecaoConsolidado.findByQtResposta", query = "SELECT v FROM VwEstatisticaCorrecaoTipoCorrecaoConsolidado v WHERE v.qtResposta = :qtResposta"),
    @NamedQuery(name = "VwEstatisticaCorrecaoTipoCorrecaoConsolidado.findByQtPrimeiraCorrecao", query = "SELECT v FROM VwEstatisticaCorrecaoTipoCorrecaoConsolidado v WHERE v.qtPrimeiraCorrecao = :qtPrimeiraCorrecao"),
    @NamedQuery(name = "VwEstatisticaCorrecaoTipoCorrecaoConsolidado.findByQtSegundaCorrecao", query = "SELECT v FROM VwEstatisticaCorrecaoTipoCorrecaoConsolidado v WHERE v.qtSegundaCorrecao = :qtSegundaCorrecao"),
    @NamedQuery(name = "VwEstatisticaCorrecaoTipoCorrecaoConsolidado.findByQtDiscrepancia", query = "SELECT v FROM VwEstatisticaCorrecaoTipoCorrecaoConsolidado v WHERE v.qtDiscrepancia = :qtDiscrepancia"),
    @NamedQuery(name = "VwEstatisticaCorrecaoTipoCorrecaoConsolidado.findByIdQuestao", query = "SELECT v FROM VwEstatisticaCorrecaoTipoCorrecaoConsolidado v WHERE v.idQuestao = :idQuestao"),
    @NamedQuery(name = "VwEstatisticaCorrecaoTipoCorrecaoConsolidado.findByIdCurso", query = "SELECT v FROM VwEstatisticaCorrecaoTipoCorrecaoConsolidado v WHERE v.idCurso = :idCurso"),
    @NamedQuery(name = "VwEstatisticaCorrecaoTipoCorrecaoConsolidado.findByIdDisciplina", query = "SELECT v FROM VwEstatisticaCorrecaoTipoCorrecaoConsolidado v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwEstatisticaCorrecaoTipoCorrecaoConsolidado.findByIdProcesso", query = "SELECT v FROM VwEstatisticaCorrecaoTipoCorrecaoConsolidado v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwEstatisticaCorrecaoTipoCorrecaoConsolidado.findByNmDisciplina", query = "SELECT v FROM VwEstatisticaCorrecaoTipoCorrecaoConsolidado v WHERE v.nmDisciplina = :nmDisciplina"),
    @NamedQuery(name = "VwEstatisticaCorrecaoTipoCorrecaoConsolidado.findByNmProcesso", query = "SELECT v FROM VwEstatisticaCorrecaoTipoCorrecaoConsolidado v WHERE v.nmProcesso = :nmProcesso"),
    @NamedQuery(name = "VwEstatisticaCorrecaoTipoCorrecaoConsolidado.findByNmCurso", query = "SELECT v FROM VwEstatisticaCorrecaoTipoCorrecaoConsolidado v WHERE v.nmCurso = :nmCurso"),
    @NamedQuery(name = "VwEstatisticaCorrecaoTipoCorrecaoConsolidado.findByNrLinha", query = "SELECT v FROM VwEstatisticaCorrecaoTipoCorrecaoConsolidado v WHERE v.nrLinha = :nrLinha")})
public class VwEstatisticaCorrecaoTipoCorrecaoConsolidado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "qt_resposta")
    private BigInteger qtResposta;
    @Column(name = "qt_primeira_correcao")
    private BigInteger qtPrimeiraCorrecao;
    @Column(name = "qt_segunda_correcao")
    private BigInteger qtSegundaCorrecao;
    @Column(name = "qt_discrepancia")
    private BigInteger qtDiscrepancia;
    @Column(name = "id_questao")
    private Integer idQuestao;
    @Column(name = "id_curso")
    private Integer idCurso;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Column(name = "id_processo")
    private Integer idProcesso;
    @Column(name = "nm_disciplina")
    private String nmDisciplina;
    @Column(name = "nm_processo")
    private String nmProcesso;
    @Column(name = "nm_curso")
    private String nmCurso;
    @Column(name = "nr_linha")
    @Id
    private BigInteger nrLinha;

    public VwEstatisticaCorrecaoTipoCorrecaoConsolidado() {
    }

    public BigInteger getQtResposta() {
        return qtResposta;
    }

    public void setQtResposta(BigInteger qtResposta) {
        this.qtResposta = qtResposta;
    }

    public BigInteger getQtPrimeiraCorrecao() {
        return qtPrimeiraCorrecao;
    }

    public void setQtPrimeiraCorrecao(BigInteger qtPrimeiraCorrecao) {
        this.qtPrimeiraCorrecao = qtPrimeiraCorrecao;
    }

    public BigInteger getQtSegundaCorrecao() {
        return qtSegundaCorrecao;
    }

    public void setQtSegundaCorrecao(BigInteger qtSegundaCorrecao) {
        this.qtSegundaCorrecao = qtSegundaCorrecao;
    }

    public BigInteger getQtDiscrepancia() {
        return qtDiscrepancia;
    }

    public void setQtDiscrepancia(BigInteger qtDiscrepancia) {
        this.qtDiscrepancia = qtDiscrepancia;
    }

    public Integer getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    public String getNmDisciplina() {
        return nmDisciplina;
    }

    public void setNmDisciplina(String nmDisciplina) {
        this.nmDisciplina = nmDisciplina;
    }

    public String getNmProcesso() {
        return nmProcesso;
    }

    public void setNmProcesso(String nmProcesso) {
        this.nmProcesso = nmProcesso;
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
