/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Janio
 */
@Entity
@Table(name = "tb_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCurso.findAll", query = "SELECT t FROM TbCurso t"),
    @NamedQuery(name = "TbCurso.findByIdCurso", query = "SELECT t FROM TbCurso t WHERE t.idCurso = :idCurso"),
    @NamedQuery(name = "TbCurso.findByNmCurso", query = "SELECT t FROM TbCurso t WHERE t.nmCurso = :nmCurso"),
    @NamedQuery(name = "TbCurso.findByNmTurno", query = "SELECT t FROM TbCurso t WHERE t.nmTurno = :nmTurno"),
    @NamedQuery(name = "TbCurso.findByIdCidade", query = "SELECT t FROM TbCurso t WHERE t.idCidade = :idCidade"),
    @NamedQuery(name = "TbCurso.findByIdArea", query = "SELECT t FROM TbCurso t WHERE t.idArea = :idArea"),
    @NamedQuery(name = "TbCurso.findByCdCurso", query = "SELECT t FROM TbCurso t WHERE t.cdCurso = :cdCurso")})
public class TbCurso implements Serializable {
    @OneToMany(mappedBy = "idCurso")
    private List<TbBanca> tbBancaList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_curso")
    private Integer idCurso;
    @Basic(optional = false)
    @Column(name = "nm_curso")
    private String nmCurso;
    @Column(name = "nm_turno")
    private String nmTurno;
    @Column(name = "id_cidade")
    private Integer idCidade;
    @Column(name = "id_area")
    private Integer idArea;
    @Column(name = "cd_curso")
    private Integer cdCurso;
    @OneToMany(mappedBy = "idCurso")
    private List<TbResposta> tbRespostaList;

    public TbCurso() {
    }

    public TbCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public TbCurso(Integer idCurso, String nmCurso) {
        this.idCurso = idCurso;
        this.nmCurso = nmCurso;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
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

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public Integer getCdCurso() {
        return cdCurso;
    }

    public void setCdCurso(Integer cdCurso) {
        this.cdCurso = cdCurso;
    }

    @XmlTransient
    public List<TbResposta> getTbRespostaList() {
        return tbRespostaList;
    }

    public void setTbRespostaList(List<TbResposta> tbRespostaList) {
        this.tbRespostaList = tbRespostaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCurso)) {
            return false;
        }
        TbCurso other = (TbCurso) object;
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbCurso[ idCurso=" + idCurso + " ]";
    }

    @XmlTransient
    public List<TbBanca> getTbBancaList() {
        return tbBancaList;
    }

    public void setTbBancaList(List<TbBanca> tbBancaList) {
        this.tbBancaList = tbBancaList;
    }
    
}
