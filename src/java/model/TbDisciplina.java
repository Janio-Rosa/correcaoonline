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
@Table(name = "tb_disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbDisciplina.findAll", query = "SELECT t FROM TbDisciplina t"),
    @NamedQuery(name = "TbDisciplina.findByIdDisciplina", query = "SELECT t FROM TbDisciplina t WHERE t.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "TbDisciplina.findByNmDisciplina", query = "SELECT t FROM TbDisciplina t WHERE t.nmDisciplina = :nmDisciplina")})
    @SequenceGenerator(name = "tb_disciplina_id_disciplina_seq", sequenceName = "tb_disciplina_id_disciplina_seq")
public class TbDisciplina implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDisciplina")
    private List<TbDisciplinaDiscrepancia> tbDisciplinaDiscrepanciaList;
    @OneToMany(mappedBy = "idDisciplina")
    private List<TbUsuario> tbUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDisciplina")
    private List<TbCriterio> tbCriterioList;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nr_nota_inicial")
    private Double nrNotaInicial;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tb_disciplina_id_disciplina_seq")
    @Basic(optional = false)
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Basic(optional = false)
    @Column(name = "nm_disciplina")
    private String nmDisciplina;
    @JoinColumn(name = "id_tipo_questao", referencedColumnName = "id_tipo_questao")
    @ManyToOne
    private TbTipoQuestao idTipoQuestao;

    public TbDisciplina() {
    }

    public TbDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public TbDisciplina(Integer idDisciplina, String nmDisciplina) {
        this.idDisciplina = idDisciplina;
        this.nmDisciplina = nmDisciplina;
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

    public TbTipoQuestao getIdTipoQuestao() {
        return idTipoQuestao;
    }

    public void setIdTipoQuestao(TbTipoQuestao idTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDisciplina != null ? idDisciplina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbDisciplina)) {
            return false;
        }
        TbDisciplina other = (TbDisciplina) object;
        if ((this.idDisciplina == null && other.idDisciplina != null) || (this.idDisciplina != null && !this.idDisciplina.equals(other.idDisciplina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbDisciplina[ idDisciplina=" + idDisciplina + " ]";
    }

    public Double getNrNotaInicial() {
        return nrNotaInicial;
    }

    public void setNrNotaInicial(Double nrNotaInicial) {
        this.nrNotaInicial = nrNotaInicial;
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

    @XmlTransient
    public List<TbUsuario> getTbUsuarioList() {
        return tbUsuarioList;
    }

    public void setTbUsuarioList(List<TbUsuario> tbUsuarioList) {
        this.tbUsuarioList = tbUsuarioList;
    }
    
}
