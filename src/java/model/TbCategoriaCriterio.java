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
@Table(name = "tb_categoria_criterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCategoriaCriterio.findAll", query = "SELECT t FROM TbCategoriaCriterio t"),
    @NamedQuery(name = "TbCategoriaCriterio.findByIdCategoriaCriterio", query = "SELECT t FROM TbCategoriaCriterio t WHERE t.idCategoriaCriterio = :idCategoriaCriterio"),
    @NamedQuery(name = "TbCategoriaCriterio.findByNmCategoriaCriterio", query = "SELECT t FROM TbCategoriaCriterio t WHERE t.nmCategoriaCriterio = :nmCategoriaCriterio"),
    @NamedQuery(name = "TbCategoriaCriterio.findByNrValorMaximo", query = "SELECT t FROM TbCategoriaCriterio t WHERE t.nrValorMaximo = :nrValorMaximo"),
    @NamedQuery(name = "TbCategoriaCriterio.findByFlErroPenalizacaoGeral", query = "SELECT t FROM TbCategoriaCriterio t WHERE t.flErroPenalizacaoGeral = :flErroPenalizacaoGeral")})
    @SequenceGenerator(name = "tb_catcriterio_id_catcriterio_seq", sequenceName = "tb_catcriterio_id_catcriterio_seq")
public class TbCategoriaCriterio implements Serializable {
    @OneToMany(mappedBy = "idCategoriaCriterioPai")
    private List<TbCategoriaCriterio> tbCategoriaCriterioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriaCriterio")
    private List<TbCriterio> tbCriterioList;

    @JoinColumn(name = "id_categoria_criterio_pai", referencedColumnName = "id_categoria_criterio")
    @ManyToOne
    private TbCategoriaCriterio idCategoriaCriterioPai;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tb_catcriterio_id_catcriterio_seq")
    @Basic(optional = false)
    @Column(name = "id_categoria_criterio")
    private int idCategoriaCriterio;
    @Basic(optional = false)
    @Column(name = "nm_categoria_criterio")
    private String nmCategoriaCriterio;
    @Basic(optional = false)
    @Column(name = "nr_valor_maximo")
    private double nrValorMaximo;
    @Column(name = "fl_erro_penalizacao_geral")
    private Boolean flErroPenalizacaoGeral;
    @JoinColumn(name = "id_genero_categoria", referencedColumnName = "id_genero_categoria")
    @ManyToOne
    private TbGeneroCategoria idGeneroCategoria;

    @Column(name = "fl_ativo")
    private Boolean flAtivo;
    
    public TbCategoriaCriterio() {
    }
    
    public TbCategoriaCriterio(int idCategoriaCriterioPai) {
        this.idCategoriaCriterio = idCategoriaCriterioPai;
    }

    public TbCategoriaCriterio( int idCategoriaCriterio, String nmCategoriaCriterio, double nrValorMaximo) {
        this.idCategoriaCriterio = idCategoriaCriterio;
        this.nmCategoriaCriterio = nmCategoriaCriterio;
        this.nrValorMaximo = nrValorMaximo;
    }

    public int getIdCategoriaCriterio() {
        return idCategoriaCriterio;
    }

    public void setIdCategoriaCriterio(int idCategoriaCriterio) {
        this.idCategoriaCriterio = idCategoriaCriterio;
    }

    public String getNmCategoriaCriterio() {
        return nmCategoriaCriterio;
    }

    public void setNmCategoriaCriterio(String nmCategoriaCriterio) {
        this.nmCategoriaCriterio = nmCategoriaCriterio;
    }

    public double getNrValorMaximo() {
        return nrValorMaximo;
    }

    public void setNrValorMaximo(double nrValorMaximo) {
        this.nrValorMaximo = nrValorMaximo;
    }

    public Boolean getFlErroPenalizacaoGeral() {
        return flErroPenalizacaoGeral;
    }

    public void setFlErroPenalizacaoGeral(Boolean flErroPenalizacaoGeral) {
        this.flErroPenalizacaoGeral = flErroPenalizacaoGeral;
    }

    public TbGeneroCategoria getIdGeneroCategoria() {
        return idGeneroCategoria;
    }

    public void setIdGeneroCategoria(TbGeneroCategoria idGeneroCategoria) {
        this.idGeneroCategoria = idGeneroCategoria;
    }
    
        public TbCategoriaCriterio getIdCategoriaCriterioPai() {
        return idCategoriaCriterioPai;
    }

    public void setIdCategoriaCriterioPai(TbCategoriaCriterio idCategoriaCriterioPai) {
        this.idCategoriaCriterioPai = idCategoriaCriterioPai;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCategoriaCriterio)) {
            return false;
        }
        TbCategoriaCriterio other = (TbCategoriaCriterio) object;
        if ((this == null && other != null) || (this != null && !(this.idCategoriaCriterio==other.idCategoriaCriterio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbCategoriaCriterio[ id =" + this.idCategoriaCriterio + " - nmCategoria "+ this.nmCategoriaCriterio +"";
    }

    @XmlTransient
    public List<TbCategoriaCriterio> getTbCategoriaCriterioList() {
        return tbCategoriaCriterioList;
    }

    public void setTbCategoriaCriterioList(List<TbCategoriaCriterio> tbCategoriaCriterioList) {
        this.tbCategoriaCriterioList = tbCategoriaCriterioList;
    }

    @XmlTransient
    public List<TbCriterio> getTbCriterioList() {
        return tbCriterioList;
    }

    public void setTbCriterioList(List<TbCriterio> tbCriterioList) {
        this.tbCriterioList = tbCriterioList;
    }

    public Boolean getFlAtivo() {
        return flAtivo;
    }

    public void setFlAtivo(Boolean flAtivo) {
        this.flAtivo = flAtivo;
    }

}
