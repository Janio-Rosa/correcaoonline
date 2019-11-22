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
@Table(name = "tb_criterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCriterio.findAll", query = "SELECT t FROM TbCriterio t"),
    @NamedQuery(name = "TbCriterio.findByIdCriterio", query = "SELECT t FROM TbCriterio t WHERE t.idCriterio = :idCriterio"),
    @NamedQuery(name = "TbCriterio.findByNmCriterio", query = "SELECT t FROM TbCriterio t WHERE t.nmCriterio = :nmCriterio"),
    @NamedQuery(name = "TbCriterio.findByNrValorMaximo", query = "SELECT t FROM TbCriterio t WHERE t.nrValorMaximo = :nrValorMaximo"),
    @NamedQuery(name = "TbCriterio.findByFlCriterioNegativo", query = "SELECT t FROM TbCriterio t WHERE t.flCriterioNegativo = :flCriterioNegativo")})
    @SequenceGenerator(name = "tb_criterio_id_criterio_seq", sequenceName = "tb_criterio_id_criterio_seq")
public class TbCriterio implements Serializable {
    @Column(name = "nr_ordem")
    private Short nrOrdem;
    @Column(name = "fl_ativo",insertable=false)
    private Boolean flAtivo;
    @JoinColumn(name = "id_questao", referencedColumnName = "id_questao")
    @ManyToOne
    private TbQuestao idQuestao;
    @Column(name = "ds_criterio")
    private String dsCriterio;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tb_criterio_id_criterio_seq")
    @Basic(optional = false)
    @Column(name = "id_criterio")
    private Integer idCriterio;
    @Basic(optional = false)
    @Column(name = "nm_criterio")
    private String nmCriterio;
    @Basic(optional = false)
    @Column(name = "nr_valor_maximo")
    private double nrValorMaximo;
    @Basic(optional = false)
    @Column(name = "fl_criterio_negativo" )
    private boolean flCriterioNegativo;
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina")
    @ManyToOne(optional = false)
    private TbDisciplina idDisciplina;
    
    /*
    @JoinColumn(name = "id_categoria_criterio", referencedColumnName = "id_categoria_criterio")
    @ManyToOne(optional = false)
    private TbCategoriaCriterio id_categoria_criterio;
    */
    @Basic(optional = false)
    @Column(name = "id_categoria_criterio")
    private int idCategoriaCriterio;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCriterio")
    private List<TbCorrecaoCriterio> tbCorrecaoCriterioList;
  
  public TbCriterio() {
    }

    public TbCriterio(Integer idCriterio) {
        this.idCriterio = idCriterio;
    }

    public TbCriterio(Integer idCriterio, String nmCriterio, double nrValorMaximo, boolean flCriterioNegativo) {
        this.idCriterio = idCriterio;
        this.nmCriterio = nmCriterio;
        this.nrValorMaximo = nrValorMaximo;
        this.flCriterioNegativo = flCriterioNegativo;
    }

    public Integer getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(Integer idCriterio) {
        this.idCriterio = idCriterio;
    }

    public String getNmCriterio() {
        return nmCriterio;
    }

    public void setNmCriterio(String nmCriterio) {
        this.nmCriterio = nmCriterio;
    }

    public double getNrValorMaximo() {
        return nrValorMaximo;
    }

    public void setNrValorMaximo(double nrValorMaximo) {
        this.nrValorMaximo = nrValorMaximo;
    }

    public boolean getFlCriterioNegativo() {
        return flCriterioNegativo;
    }

    public void setFlCriterioNegativo(boolean flCriterioNegativo) {
        this.flCriterioNegativo = flCriterioNegativo;
    }

    public TbDisciplina getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(TbDisciplina idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    @XmlTransient
    public List<TbCorrecaoCriterio> getTbCorrecaoCriterioList() {
        return tbCorrecaoCriterioList;
    }

    public void setTbCorrecaoCriterioList(List<TbCorrecaoCriterio> tbCorrecaoCriterioList) {
        this.tbCorrecaoCriterioList = tbCorrecaoCriterioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCriterio != null ? idCriterio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCriterio)) {
            return false;
        }
        TbCriterio other = (TbCriterio) object;
        if ((this.idCriterio == null && other.idCriterio != null) || (this.idCriterio != null && !this.idCriterio.equals(other.idCriterio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbCriterio[ idCriterio=" + idCriterio+" Questao="+ this.idQuestao + " ]";
    }

    public int getIdCategoriaCriterio() {
        return idCategoriaCriterio;
    }

    public void setIdCategoriaCriterio(int idCategoriaCriterio) {
        this.idCategoriaCriterio = idCategoriaCriterio;
    }

    public String getDsCriterio() {
        return dsCriterio;
    }

    public void setDsCriterio(String dsCriterio) {
        this.dsCriterio = dsCriterio;
    }

    public TbQuestao getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(TbQuestao idQuestao) {
        this.idQuestao = idQuestao;
    }

    public Boolean getFlAtivo() {
        return flAtivo;
    }

    public void setFlAtivo(Boolean flAtivo) {
        this.flAtivo = flAtivo;
    }

    public Short getNrOrdem() {
        return nrOrdem;
    }

    public void setNrOrdem(Short nrOrdem) {
        this.nrOrdem = nrOrdem;
    }

}
