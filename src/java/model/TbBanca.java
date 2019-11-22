/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Janio
 */
@Entity
@Table(name = "tb_banca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbBanca.findAll", query = "SELECT t FROM TbBanca t"),
    @NamedQuery(name = "TbBanca.findByIdBanca", query = "SELECT t FROM TbBanca t WHERE t.idBanca = :idBanca"),
    @NamedQuery(name = "TbBanca.findByNmBanca", query = "SELECT t FROM TbBanca t WHERE t.nmBanca = :nmBanca"),
    @NamedQuery(name = "TbBanca.findByFlDiscrepancia", query = "SELECT t FROM TbBanca t WHERE t.flDiscrepancia = :flDiscrepancia"),
    @NamedQuery(name = "TbBanca.findByFlRedacao", query = "SELECT t FROM TbBanca t WHERE t.flRedacao = :flRedacao")})
    @SequenceGenerator(name = "tb_banca_id_banca_seq", sequenceName = "tb_banca_id_banca_seq")
public class TbBanca implements Serializable {
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
    @ManyToOne
    private TbCurso idCurso;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tb_banca_id_banca_seq")
    @Basic(optional = false)
    @Column(name = "id_banca")
    private Integer idBanca;
    @Basic(optional = false)
    @Column(name = "nm_banca")
    private String nmBanca;
    @Basic(optional = false)
    @Column(name = "fl_discrepancia")
    private boolean flDiscrepancia;
    @Basic(optional = false)
    @Column(name = "fl_redacao")
    private boolean flRedacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBanca")
    private List<TbColaborador> tbColaboradorList;
    @JoinColumn(name = "id_processo", referencedColumnName = "id_processo")
    @ManyToOne(optional = false)
    private TbProcesso idProcesso;
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina")
    @ManyToOne(optional = false)
    private TbDisciplina idDisciplina;

    public TbBanca() {
    }

    public TbBanca(Integer idBanca) {
        this.idBanca = idBanca;
    }

    public TbBanca(Integer idBanca, String nmBanca, boolean flDiscrepancia, boolean flRedacao) {
        this.idBanca = idBanca;
        this.nmBanca = nmBanca;
        this.flDiscrepancia = flDiscrepancia;
        this.flRedacao = flRedacao;
    }

    public Integer getIdBanca() {
        return idBanca;
    }

    public void setIdBanca(Integer idBanca) {
        this.idBanca = idBanca;
    }

    public String getNmBanca() {
        return nmBanca;
    }

    public void setNmBanca(String nmBanca) {
        this.nmBanca = nmBanca;
    }

    public boolean getFlDiscrepancia() {
        return flDiscrepancia;
    }

    public void setFlDiscrepancia(boolean flDiscrepancia) {
        this.flDiscrepancia = flDiscrepancia;
    }

    public boolean getFlRedacao() {
        return flRedacao;
    }

    public void setFlRedacao(boolean flRedacao) {
        this.flRedacao = flRedacao;
    }

    @XmlTransient
    public List<TbColaborador> getTbColaboradorList() {
        return tbColaboradorList;
    }

    public void setTbColaboradorList(List<TbColaborador> tbColaboradorList) {
        this.tbColaboradorList = tbColaboradorList;
    }

    public TbProcesso getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(TbProcesso idProcesso) {
        this.idProcesso = idProcesso;
    }

    public TbDisciplina getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(TbDisciplina idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBanca != null ? idBanca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbBanca)) {
            return false;
        }
        TbBanca other = (TbBanca) object;
        if ((this.idBanca == null && other.idBanca != null) || (this.idBanca != null && !this.idBanca.equals(other.idBanca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbBanca[ idBanca=" + idBanca + " ]";
    }

    public TbCurso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(TbCurso idCurso) {
        this.idCurso = idCurso;
    }
    
}
