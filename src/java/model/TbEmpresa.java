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
@Table(name = "tb_empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEmpresa.findAll", query = "SELECT t FROM TbEmpresa t"),
    @NamedQuery(name = "TbEmpresa.findByIdEmpresa", query = "SELECT t FROM TbEmpresa t WHERE t.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "TbEmpresa.findByNmEmpresa", query = "SELECT t FROM TbEmpresa t WHERE t.nmEmpresa = :nmEmpresa")})
@SequenceGenerator(name = "tb_empresa_id_empresa_seq", sequenceName = "tb_empresa_id_empresa_seq")
public class TbEmpresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tb_empresa_id_empresa_seq")
    @Basic(optional = false)
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    @Basic(optional = false)
    @Column(name = "nm_empresa")
    private String nmEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private List<TbPessoa> tbPessoaList;

    public TbEmpresa() {
    }

    public TbEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public TbEmpresa(Integer idEmpresa, String nmEmpresa) {
        this.idEmpresa = idEmpresa;
        this.nmEmpresa = nmEmpresa;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNmEmpresa() {
        return nmEmpresa;
    }

    public void setNmEmpresa(String nmEmpresa) {
        this.nmEmpresa = nmEmpresa;
    }

    @XmlTransient
    public List<TbPessoa> getTbPessoaList() {
        return tbPessoaList;
    }

    public void setTbPessoaList(List<TbPessoa> tbPessoaList) {
        this.tbPessoaList = tbPessoaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEmpresa)) {
            return false;
        }
        TbEmpresa other = (TbEmpresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbEmpresa[ idEmpresa=" + idEmpresa + " ]";
    }
    
}
