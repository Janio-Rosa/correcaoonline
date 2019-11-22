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
@Table(name = "tb_funcao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFuncao.findAll", query = "SELECT t FROM TbFuncao t"),
    @NamedQuery(name = "TbFuncao.findByIdFuncao", query = "SELECT t FROM TbFuncao t WHERE t.idFuncao = :idFuncao"),
    @NamedQuery(name = "TbFuncao.findByNmFuncao", query = "SELECT t FROM TbFuncao t WHERE t.nmFuncao = :nmFuncao")})
@SequenceGenerator(name = "tb_funcao_id_funcao_seq", sequenceName = "tb_funcao_id_funcao_seq")
public class TbFuncao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tb_funcao_id_funcao_seq")
    @Basic(optional = false)
    @Column(name = "id_funcao")
    private Integer idFuncao;
    @Basic(optional = false)
    @Column(name = "nm_funcao")
    private String nmFuncao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncao")
    private List<TbColaborador> tbColaboradorList;

    public TbFuncao() {
    }

    public TbFuncao(Integer idFuncao) {
        this.idFuncao = idFuncao;
    }

    public TbFuncao(Integer idFuncao, String nmFuncao) {
        this.idFuncao = idFuncao;
        this.nmFuncao = nmFuncao;
    }

    public Integer getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(Integer idFuncao) {
        this.idFuncao = idFuncao;
    }

    public String getNmFuncao() {
        return nmFuncao;
    }

    public void setNmFuncao(String nmFuncao) {
        this.nmFuncao = nmFuncao;
    }

    @XmlTransient
    public List<TbColaborador> getTbColaboradorList() {
        return tbColaboradorList;
    }

    public void setTbColaboradorList(List<TbColaborador> tbColaboradorList) {
        this.tbColaboradorList = tbColaboradorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncao != null ? idFuncao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFuncao)) {
            return false;
        }
        TbFuncao other = (TbFuncao) object;
        if ((this.idFuncao == null && other.idFuncao != null) || (this.idFuncao != null && !this.idFuncao.equals(other.idFuncao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbFuncao[ idFuncao=" + idFuncao + " ]";
    }
    
}
