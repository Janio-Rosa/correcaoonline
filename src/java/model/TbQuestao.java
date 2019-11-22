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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author KAMYLLA
 */
@Entity
@Table(name = "tb_questao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbQuestao.findAll", query = "SELECT t FROM TbQuestao t"),
    @NamedQuery(name = "TbQuestao.findByIdQuestao", query = "SELECT t FROM TbQuestao t WHERE t.idQuestao = :idQuestao"),
    @NamedQuery(name = "TbQuestao.findByNmQuestao", query = "SELECT t FROM TbQuestao t WHERE t.nmQuestao = :nmQuestao")})
public class TbQuestao implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idQuestao")
    private List<TbDisciplinaDiscrepancia> tbDisciplinaDiscrepanciaList;
    @OneToMany(mappedBy = "idQuestao")
    private List<TbCriterio> tbCriterioList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_questao")
    private Integer idQuestao;
    @Basic(optional = false)
    @Column(name = "nm_questao")
    private String nmQuestao;

    public TbQuestao() {
    }

    public TbQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public TbQuestao(Integer idQuestao, String nmQuestao) {
        this.idQuestao = idQuestao;
        this.nmQuestao = nmQuestao;
    }

    public Integer getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public String getNmQuestao() {
        return nmQuestao;
    }

    public void setNmQuestao(String nmQuestao) {
        this.nmQuestao = nmQuestao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestao != null ? idQuestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbQuestao)) {
            return false;
        }
        TbQuestao other = (TbQuestao) object;
        if ((this.idQuestao == null && other.idQuestao != null) || (this.idQuestao != null && !this.idQuestao.equals(other.idQuestao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbQuestao[ idQuestao=" + idQuestao + " ]";
    }

    @XmlTransient
    public List<TbCriterio> getTbCriterioList() {
        return tbCriterioList;
    }

    public void setTbCriterioList(List<TbCriterio> tbCriterioList) {
        this.tbCriterioList = tbCriterioList;
    }

    @XmlTransient
    public List<TbDisciplinaDiscrepancia> getTbDisciplinaDiscrepanciaList() {
        return tbDisciplinaDiscrepanciaList;
    }

    public void setTbDisciplinaDiscrepanciaList(List<TbDisciplinaDiscrepancia> tbDisciplinaDiscrepanciaList) {
        this.tbDisciplinaDiscrepanciaList = tbDisciplinaDiscrepanciaList;
    }
    
}
