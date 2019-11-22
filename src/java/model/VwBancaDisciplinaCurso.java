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
@Table(name = "vw_banca_disciplina_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwBancaDisciplinaCurso.findAll", query = "SELECT v FROM VwBancaDisciplinaCurso v"),
    @NamedQuery(name = "VwBancaDisciplinaCurso.findByIdBanca", query = "SELECT v FROM VwBancaDisciplinaCurso v WHERE v.idBanca = :idBanca"),
    @NamedQuery(name = "VwBancaDisciplinaCurso.findByIdProcesso", query = "SELECT v FROM VwBancaDisciplinaCurso v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwBancaDisciplinaCurso.findByIdDisciplina", query = "SELECT v FROM VwBancaDisciplinaCurso v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwBancaDisciplinaCurso.findByNmBanca", query = "SELECT v FROM VwBancaDisciplinaCurso v WHERE v.nmBanca = :nmBanca"),
    @NamedQuery(name = "VwBancaDisciplinaCurso.findByFlDiscrepancia", query = "SELECT v FROM VwBancaDisciplinaCurso v WHERE v.flDiscrepancia = :flDiscrepancia"),
    @NamedQuery(name = "VwBancaDisciplinaCurso.findByFlRedacao", query = "SELECT v FROM VwBancaDisciplinaCurso v WHERE v.flRedacao = :flRedacao"),
    @NamedQuery(name = "VwBancaDisciplinaCurso.findByIdCurso", query = "SELECT v FROM VwBancaDisciplinaCurso v WHERE v.idCurso = :idCurso"),
    @NamedQuery(name = "VwBancaDisciplinaCurso.findByNmDisciplina", query = "SELECT v FROM VwBancaDisciplinaCurso v WHERE v.nmDisciplina = :nmDisciplina"),
    @NamedQuery(name = "VwBancaDisciplinaCurso.findByNmProcesso", query = "SELECT v FROM VwBancaDisciplinaCurso v WHERE v.nmProcesso = :nmProcesso"),
    @NamedQuery(name = "VwBancaDisciplinaCurso.findByNmCurso", query = "SELECT v FROM VwBancaDisciplinaCurso v WHERE v.nmCurso = :nmCurso"),
    @NamedQuery(name = "VwBancaDisciplinaCurso.findByNmTurno", query = "SELECT v FROM VwBancaDisciplinaCurso v WHERE v.nmTurno = :nmTurno")})
public class VwBancaDisciplinaCurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_banca")
    @Id
    private Integer idBanca;
    @Column(name = "id_processo")
    private Integer idProcesso;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Column(name = "nm_banca")
    private String nmBanca;
    @Column(name = "fl_discrepancia")
    private Boolean flDiscrepancia;
    @Column(name = "fl_redacao")
    private Boolean flRedacao;
    @Column(name = "id_curso")
    private Integer idCurso;
    @Column(name = "nm_disciplina")
    private String nmDisciplina;
    @Column(name = "nm_processo")
    private String nmProcesso;
    @Column(name = "nm_curso")
    private String nmCurso;
    @Column(name = "nm_turno")
    private String nmTurno;
    @Column(name = "nm_cidade")
    private String nmCidade;

    public VwBancaDisciplinaCurso() {
    }

    public Integer getIdBanca() {
        return idBanca;
    }

    public void setIdBanca(Integer idBanca) {
        this.idBanca = idBanca;
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

    public String getNmBanca() {
        return nmBanca;
    }

    public void setNmBanca(String nmBanca) {
        this.nmBanca = nmBanca;
    }

    public Boolean getFlDiscrepancia() {
        return flDiscrepancia;
    }

    public void setFlDiscrepancia(Boolean flDiscrepancia) {
        this.flDiscrepancia = flDiscrepancia;
    }

    public Boolean getFlRedacao() {
        return flRedacao;
    }

    public void setFlRedacao(Boolean flRedacao) {
        this.flRedacao = flRedacao;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
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

    public String getNmTurno() {
        return nmTurno;
    }

    public void setNmTurno(String nmTurno) {
        this.nmTurno = nmTurno;
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }
    
}
