/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
//@Table(name = "vw_consolidado_geral_correcao_discrepancia_mv")
//@Table(name = "vw_consolidado_geral_correcao_discrepancia")
@Entity
@Table(name = "vw_consolidado_geral_correcao_discrepancia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwConsolidadoGeralCorrecao.findAll", query = "SELECT v FROM VwConsolidadoGeralCorrecao v"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecao.findByIdDisciplina", query = "SELECT v FROM VwConsolidadoGeralCorrecao v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecao.findByNmDisciplina", query = "SELECT v FROM VwConsolidadoGeralCorrecao v WHERE v.nmDisciplina = :nmDisciplina"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecao.findByIdProcesso", query = "SELECT v FROM VwConsolidadoGeralCorrecao v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecao.findByNmProcesso", query = "SELECT v FROM VwConsolidadoGeralCorrecao v WHERE v.nmProcesso = :nmProcesso"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecao.findByQtTotalRespostas", query = "SELECT v FROM VwConsolidadoGeralCorrecao v WHERE v.qtTotalRespostas = :qtTotalRespostas"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecao.findByQtTotalDiscrepancias", query = "SELECT v FROM VwConsolidadoGeralCorrecao v WHERE v.qtTotalDiscrepancias = :qtTotalDiscrepancias"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecao.findByQtPrimeiraCorrecao", query = "SELECT v FROM VwConsolidadoGeralCorrecao v WHERE v.qtPrimeiraCorrecao = :qtPrimeiraCorrecao"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecao.findByQtSegundaCorrecao", query = "SELECT v FROM VwConsolidadoGeralCorrecao v WHERE v.qtSegundaCorrecao = :qtSegundaCorrecao"),
    @NamedQuery(name = "VwConsolidadoGeralCorrecao.findByNrLinha", query = "SELECT v FROM VwConsolidadoGeralCorrecao v WHERE v.nrLinha = :nrLinha")})
public class VwConsolidadoGeralCorrecao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Column(name = "nm_disciplina")
    private String nmDisciplina;
    @Column(name = "id_processo")
    private Integer idProcesso;
    @Column(name = "nm_processo")
    private String nmProcesso;

    @Column(name = "qt_discrepancia")
    private Integer qtDiscrepancia;
    
    @Column(name = "qt_total_respostas")
    private Integer qtTotalRespostas;
    @Column(name = "qt_total_discrepancias")
    private Integer qtTotalDiscrepancias;
    @Column(name = "qt_primeira_correcao")
    private Integer qtPrimeiraCorrecao;
    @Column(name = "qt_segunda_correcao")
    private Integer qtSegundaCorrecao;
    @Column(name = "nr_linha")
    @Id
    private Integer nrLinha;

    public VwConsolidadoGeralCorrecao() {
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

    public Integer getQtTotalRespostas() {
        return qtTotalRespostas;
    }

    public void setQtTotalRespostas(Integer qtTotalRespostas) {
        this.qtTotalRespostas = qtTotalRespostas;
    }

    public Integer getQtTotalDiscrepancias() {
        return qtTotalDiscrepancias;
    }

    public void setQtTotalDiscrepancias(Integer qtTotalDiscrepancias) {
        this.qtTotalDiscrepancias = qtTotalDiscrepancias;
    }

    public Integer getQtPrimeiraCorrecao() {
        return qtPrimeiraCorrecao;
    }

    public void setQtPrimeiraCorrecao(Integer qtPrimeiraCorrecao) {
        this.qtPrimeiraCorrecao = qtPrimeiraCorrecao;
    }

    public Integer getQtSegundaCorrecao() {
        return qtSegundaCorrecao;
    }

    public void setQtSegundaCorrecao(Integer qtSegundaCorrecao) {
        this.qtSegundaCorrecao = qtSegundaCorrecao;
    }

    public Integer getNrLinha() {
        return nrLinha;
    }

    public void setNrLinha(Integer nrLinha) {
        this.nrLinha = nrLinha;
    }
 
    public float getPorcentagemPrimeiraCorrecao(){
        float retorno=0;
        retorno= (float) ((this.getQtPrimeiraCorrecao().floatValue() /  this.getQtTotalRespostas().floatValue())*100 );
        
        return retorno;
    }
    public float getPorcentagemSegundaCorrecao(){
        float retorno=0;
        retorno= (float) ((this.getQtSegundaCorrecao().floatValue() /  this.getQtTotalRespostas().floatValue())*100 );
        
        return retorno;
    }

    public Integer getQtDiscrepancia() {
        return qtDiscrepancia;
    }

    public void setQtDiscrepancia(Integer qtDiscrepancia) {
        this.qtDiscrepancia = qtDiscrepancia;
    }

    public float getPorcentagemDiscrepancia(){
        float retorno=0;
        if(this.getQtDiscrepancia()!=null && this.getQtTotalDiscrepancias()!=null && this.getQtTotalDiscrepancias()!=0)
            retorno= (float) ((this.getQtDiscrepancia().floatValue() /  this.getQtTotalDiscrepancias().floatValue())*100 );
        
        return retorno;
    }
    
    
}
