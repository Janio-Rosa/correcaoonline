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
@Table(name = "vw_consolidado_geral_correcao_disciplina_questao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplinaQuestao.findAll", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplinaQuestao v"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplinaQuestao.findByIdProcesso", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplinaQuestao v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplinaQuestao.findByNmProcesso", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplinaQuestao v WHERE v.nmProcesso = :nmProcesso"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplinaQuestao.findByIdDisciplina", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplinaQuestao v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplinaQuestao.findByNmDisciplina", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplinaQuestao v WHERE v.nmDisciplina = :nmDisciplina"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplinaQuestao.findByNrQuestao", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplinaQuestao v WHERE v.nrQuestao = :nrQuestao"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplinaQuestao.findByQtTotalRespostas", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplinaQuestao v WHERE v.qtTotalRespostas = :qtTotalRespostas"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplinaQuestao.findByQtPrimeiraCorrecao", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplinaQuestao v WHERE v.qtPrimeiraCorrecao = :qtPrimeiraCorrecao"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplinaQuestao.findByQtSegundaCorrecao", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplinaQuestao v WHERE v.qtSegundaCorrecao = :qtSegundaCorrecao"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplinaQuestao.findByQtTotalDiscrepancias", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplinaQuestao v WHERE v.qtTotalDiscrepancias = :qtTotalDiscrepancias"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplinaQuestao.findByNrLinha", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplinaQuestao v WHERE v.nrLinha = :nrLinha")})
public class VwConsolidadoGeralCorrecaoDisciplinaQuestao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_processo")
    private Integer idProcesso;
    @Column(name = "nm_processo")
    private String nmProcesso;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Column(name = "nm_disciplina")
    private String nmDisciplina;
    @Column(name = "nr_questao")
    private Integer nrQuestao;
    @Column(name = "qt_total_respostas")
    private BigInteger qtTotalRespostas;
    @Column(name = "qt_primeira_correcao")
    private BigInteger qtPrimeiraCorrecao;
    @Column(name = "qt_segunda_correcao")
    private BigInteger qtSegundaCorrecao;
    @Column(name = "qt_total_discrepancias")
    private BigInteger qtTotalDiscrepancias;
    @Column(name = "nr_linha")
    @Id
    private BigInteger nrLinha;

    public VwConsolidadoGeralCorrecaoDisciplinaQuestao() {
    }

    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    public String getNmProcesso() {
        return nmProcesso;
    }

    public void setNmProcesso(String nmProcesso) {
        this.nmProcesso = nmProcesso;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNmDisciplina() {
        return nmDisciplina;
    }

    public void setNmDisciplina(String nmDisciplina) {
        this.nmDisciplina = nmDisciplina;
    }

    public Integer getNrQuestao() {
        return nrQuestao;
    }

    public void setNrQuestao(Integer nrQuestao) {
        this.nrQuestao = nrQuestao;
    }

    public BigInteger getQtTotalRespostas() {
        return qtTotalRespostas;
    }

    public void setQtTotalRespostas(BigInteger qtTotalRespostas) {
        this.qtTotalRespostas = qtTotalRespostas;
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

    public BigInteger getQtTotalDiscrepancias() {
        return qtTotalDiscrepancias;
    }

    public void setQtTotalDiscrepancias(BigInteger qtTotalDiscrepancias) {
        this.qtTotalDiscrepancias = qtTotalDiscrepancias;
    }

    public BigInteger getNrLinha() {
        return nrLinha;
    }

    public void setNrLinha(BigInteger nrLinha) {
        this.nrLinha = nrLinha;
    }
    
}
