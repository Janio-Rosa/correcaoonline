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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPessoa.findAll", query = "SELECT t FROM TbPessoa t"),
    @NamedQuery(name = "TbPessoa.findByNrCpf", query = "SELECT t FROM TbPessoa t WHERE t.nrCpf = :nrCpf"),
    @NamedQuery(name = "TbPessoa.findByNmPessoa", query = "SELECT t FROM TbPessoa t WHERE t.nmPessoa = :nmPessoa"),
    @NamedQuery(name = "TbPessoa.findByNrRg", query = "SELECT t FROM TbPessoa t WHERE t.nrRg = :nrRg"),
    @NamedQuery(name = "TbPessoa.findByNmRgOrgao", query = "SELECT t FROM TbPessoa t WHERE t.nmRgOrgao = :nmRgOrgao"),
    @NamedQuery(name = "TbPessoa.findByNmRgUf", query = "SELECT t FROM TbPessoa t WHERE t.nmRgUf = :nmRgUf")})
public class TbPessoa implements Serializable {
    @OneToMany(mappedBy = "nrCpf")
    private List<TbUsuario> tbUsuarioList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nr_cpf")
    private String nrCpf;
    @Basic(optional = false)
    @Column(name = "nm_pessoa")
    private String nmPessoa;
    @Basic(optional = false)
    @Column(name = "nr_rg")
    private String nrRg;
    @Basic(optional = false)
    @Column(name = "nm_rg_orgao")
    private String nmRgOrgao;
    @Basic(optional = false)
    @Column(name = "nm_rg_uf")
    private String nmRgUf;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false)
    private TbEmpresa idEmpresa;

    public TbPessoa() {
    }

    public TbPessoa(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public TbPessoa(String nrCpf, String nmPessoa, String nrRg, String nmRgOrgao, String nmRgUf) {
        this.nrCpf = nrCpf;
        this.nmPessoa = nmPessoa;
        this.nrRg = nrRg;
        this.nmRgOrgao = nmRgOrgao;
        this.nmRgUf = nmRgUf;
    }

    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public String getNmPessoa() {
        return nmPessoa;
    }

    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }

    public String getNrRg() {
        return nrRg;
    }

    public void setNrRg(String nrRg) {
        this.nrRg = nrRg;
    }

    public String getNmRgOrgao() {
        return nmRgOrgao;
    }

    public void setNmRgOrgao(String nmRgOrgao) {
        this.nmRgOrgao = nmRgOrgao;
    }

    public String getNmRgUf() {
        return nmRgUf;
    }

    public void setNmRgUf(String nmRgUf) {
        this.nmRgUf = nmRgUf;
    }

    public TbEmpresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(TbEmpresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrCpf != null ? nrCpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPessoa)) {
            return false;
        }
        TbPessoa other = (TbPessoa) object;
        if ((this.nrCpf == null && other.nrCpf != null) || (this.nrCpf != null && !this.nrCpf.equals(other.nrCpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbPessoa[ nrCpf=" + nrCpf + " ]";
    }

    @XmlTransient
    public List<TbUsuario> getTbUsuarioList() {
        return tbUsuarioList;
    }

    public void setTbUsuarioList(List<TbUsuario> tbUsuarioList) {
        this.tbUsuarioList = tbUsuarioList;
    }
    
}
