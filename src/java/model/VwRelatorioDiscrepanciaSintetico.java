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
@Table(name = "vw_relatorio_discrepancia_sintetico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwRelatorioDiscrepanciaSintetico.findAll", query = "SELECT v FROM VwRelatorioDiscrepanciaSintetico v"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaSintetico.findByNmDisciplina", query = "SELECT v FROM VwRelatorioDiscrepanciaSintetico v WHERE v.nmDisciplina = :nmDisciplina"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaSintetico.findByNmProcesso", query = "SELECT v FROM VwRelatorioDiscrepanciaSintetico v WHERE v.nmProcesso = :nmProcesso"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaSintetico.findByNmQuestao", query = "SELECT v FROM VwRelatorioDiscrepanciaSintetico v WHERE v.nmQuestao = :nmQuestao"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaSintetico.findByIdProcesso", query = "SELECT v FROM VwRelatorioDiscrepanciaSintetico v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaSintetico.findByIdDisciplina", query = "SELECT v FROM VwRelatorioDiscrepanciaSintetico v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaSintetico.findByNrQuestao", query = "SELECT v FROM VwRelatorioDiscrepanciaSintetico v WHERE v.nrQuestao = :nrQuestao"),
    @NamedQuery(name = "VwRelatorioDiscrepanciaSintetico.findByNrLinha", query = "SELECT v FROM VwRelatorioDiscrepanciaSintetico v WHERE v.nrLinha = :nrLinha")})
public class VwRelatorioDiscrepanciaSintetico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "nm_disciplina")
    private String nmDisciplina;
    @Column(name = "nm_processo")
    private String nmProcesso;
    @Column(name = "nm_questao")
    private String nmQuestao;
    @Column(name = "id_processo")
    private Integer idProcesso;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Column(name = "nr_questao")
    private Integer nrQuestao;
    @Column(name = "nr_quant_discrepancia_corrigida")
    private BigInteger nrQuantDiscrepanciaCorrigida;
    @Column(name = "nr_discrepancia")
    private BigInteger nrDiscrepancia;
    @Column(name = "nr_linha")
    @Id
    private BigInteger nrLinha;

    public VwRelatorioDiscrepanciaSintetico() {
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

    public String getNmQuestao() {
        return nmQuestao;
    }

    public void setNmQuestao(String nmQuestao) {
        this.nmQuestao = nmQuestao;
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

    public BigInteger getNrLinha() {
        return nrLinha;
    }

    public void setNrLinha(BigInteger nrLinha) {
        this.nrLinha = nrLinha;
    }

    public BigInteger getNrDiscrepancia() {
        return nrDiscrepancia;
    }

    public void setNrDiscrepancia(BigInteger nrDiscrepancia) {
        this.nrDiscrepancia = nrDiscrepancia;
    }

    public BigInteger getNrQuantDiscrepanciaCorrigida() {
        return nrQuantDiscrepanciaCorrigida;
    }

    public void setNrQuantDiscrepanciaCorrigida(BigInteger nrQuantDiscrepanciaCorrigida) {
        this.nrQuantDiscrepanciaCorrigida = nrQuantDiscrepanciaCorrigida;
    }

    public float getPorcentagemDiscrepancia(){
        float retorno=0;
        retorno= (float) ((this.getNrQuantDiscrepanciaCorrigida().floatValue() /  this.getNrDiscrepancia().floatValue())*100 );
        
        return retorno;
    }
    
}
