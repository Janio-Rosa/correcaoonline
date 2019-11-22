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
 * @author Janio
 */
@Entity
@Table(name = "vw_disciplina_discrepancia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwDisciplinaDiscrepancia.findAll", query = "SELECT v FROM VwDisciplinaDiscrepancia v"),
    @NamedQuery(name = "VwDisciplinaDiscrepancia.findByIdDisciplina", query = "SELECT v FROM VwDisciplinaDiscrepancia v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwDisciplinaDiscrepancia.findByNmDisciplina", query = "SELECT v FROM VwDisciplinaDiscrepancia v WHERE v.nmDisciplina = :nmDisciplina"),
    @NamedQuery(name = "VwDisciplinaDiscrepancia.findByIdTipoQuestao", query = "SELECT v FROM VwDisciplinaDiscrepancia v WHERE v.idTipoQuestao = :idTipoQuestao"),
    @NamedQuery(name = "VwDisciplinaDiscrepancia.findByNrNotaInicial", query = "SELECT v FROM VwDisciplinaDiscrepancia v WHERE v.nrNotaInicial = :nrNotaInicial"),
    @NamedQuery(name = "VwDisciplinaDiscrepancia.findByFlDiscrepanciaAtiva", query = "SELECT v FROM VwDisciplinaDiscrepancia v WHERE v.flDiscrepanciaAtiva = :flDiscrepanciaAtiva"),
    @NamedQuery(name = "VwDisciplinaDiscrepancia.findByNmQuestao", query = "SELECT v FROM VwDisciplinaDiscrepancia v WHERE v.nmQuestao = :nmQuestao")})
public class VwDisciplinaDiscrepancia implements Serializable {
    @Column(name = "id_disciplina_discrepancia")
    @Id
    private Integer idDisciplinaDiscrepancia;
    private static final long serialVersionUID = 1L;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Column(name = "nm_disciplina")
    private String nmDisciplina;
    @Column(name = "id_tipo_questao")
    private Integer idTipoQuestao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nr_nota_inicial")
    private Double nrNotaInicial;
    @Column(name = "fl_discrepancia_ativa")
    private Boolean flDiscrepanciaAtiva;
    @Column(name = "nm_questao")
    private String nmQuestao;

    public VwDisciplinaDiscrepancia() {
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

    public Boolean getFlDiscrepanciaAtiva() {
        return flDiscrepanciaAtiva;
    }

    public void setFlDiscrepanciaAtiva(Boolean flDiscrepanciaAtiva) {
        this.flDiscrepanciaAtiva = flDiscrepanciaAtiva;
    }

    public String getNmQuestao() {
        return nmQuestao;
    }

    public void setNmQuestao(String nmQuestao) {
        this.nmQuestao = nmQuestao;
    }

    public Integer getIdDisciplinaDiscrepancia() {
        return idDisciplinaDiscrepancia;
    }

    public void setIdDisciplinaDiscrepancia(Integer idDisciplinaDiscrepancia) {
        this.idDisciplinaDiscrepancia = idDisciplinaDiscrepancia;
    }
    
}
