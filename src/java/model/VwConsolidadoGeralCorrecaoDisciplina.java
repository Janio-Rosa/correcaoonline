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
@Table(name = "vw_consolidado_geral_correcao_disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplina.findAll", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplina v"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplina.findByIdDisciplina", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplina v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplina.findByNmDisciplina", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplina v WHERE v.nmDisciplina = :nmDisciplina"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplina.findByIdProcesso", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplina v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplina.findByNmProcesso", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplina v WHERE v.nmProcesso = :nmProcesso"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplina.findByQtTotalRespostas", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplina v WHERE v.qtTotalRespostas = :qtTotalRespostas"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplina.findByQtTotalDiscrepancias", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplina v WHERE v.qtTotalDiscrepancias = :qtTotalDiscrepancias"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplina.findByQtPrimeiraCorrecao", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplina v WHERE v.qtPrimeiraCorrecao = :qtPrimeiraCorrecao"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplina.findByQtSegundaCorrecao", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplina v WHERE v.qtSegundaCorrecao = :qtSegundaCorrecao"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecaoDisciplina.findByNrLinha", query = "SELECT v FROM VwConsolidadoGeralCorrecaoDisciplina v WHERE v.nrLinha = :nrLinha")})
public class VwConsolidadoGeralCorrecaoDisciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Column(name = "nm_disciplina")
    private String nmDisciplina;
    @Column(name = "id_processo")
    private Integer idProcesso;
    @Column(name = "nm_processo")
    private String nmProcesso;
    @Column(name = "qt_total_respostas")
    private BigInteger qtTotalRespostas;
    @Column(name = "qt_total_discrepancias")
    private BigInteger qtTotalDiscrepancias;
    @Column(name = "qt_primeira_correcao")
    private BigInteger qtPrimeiraCorrecao;
    @Column(name = "qt_segunda_correcao")
    private BigInteger qtSegundaCorrecao;
    @Column(name = "nr_linha")
    @Id
    private BigInteger nrLinha;

    public VwConsolidadoGeralCorrecaoDisciplina() {
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

    public BigInteger getQtTotalRespostas() {
        return qtTotalRespostas;
    }

    public void setQtTotalRespostas(BigInteger qtTotalRespostas) {
        this.qtTotalRespostas = qtTotalRespostas;
    }

    public BigInteger getQtTotalDiscrepancias() {
        return qtTotalDiscrepancias;
    }

    public void setQtTotalDiscrepancias(BigInteger qtTotalDiscrepancias) {
        this.qtTotalDiscrepancias = qtTotalDiscrepancias;
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

    public BigInteger getNrLinha() {
        return nrLinha;
    }

    public void setNrLinha(BigInteger nrLinha) {
        this.nrLinha = nrLinha;
    }
    
}
