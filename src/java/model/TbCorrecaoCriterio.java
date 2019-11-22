/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Janio
 */
@Entity
@Table(name = "tb_correcao_criterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCorrecaoCriterio.findAll", query = "SELECT t FROM TbCorrecaoCriterio t"),
    @NamedQuery(name = "TbCorrecaoCriterio.findByIdCorrecaoCriterio", query = "SELECT t FROM TbCorrecaoCriterio t WHERE t.idCorrecaoCriterio = :idCorrecaoCriterio"),
    @NamedQuery(name = "TbCorrecaoCriterio.findByNrLinha", query = "SELECT t FROM TbCorrecaoCriterio t WHERE t.nrLinha = :nrLinha"),
    @NamedQuery(name = "TbCorrecaoCriterio.findByNrValor", query = "SELECT t FROM TbCorrecaoCriterio t WHERE t.nrValor = :nrValor")})
@SequenceGenerator(name = "tb_correcao_criterio_id_correcao_criterio_seq", sequenceName = "tb_correcao_criterio_id_correcao_criterio_seq")
public class TbCorrecaoCriterio implements Serializable {
    @JoinColumn(name = "id_criterio", referencedColumnName = "id_criterio")
    @ManyToOne(optional = false)
    private TbCriterio idCriterio;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tb_correcao_criterio_id_correcao_criterio_seq")
    @Basic(optional = false)
    @Column(name = "id_correcao_criterio")
    private Long idCorrecaoCriterio;
    @Basic(optional = false)
    @Column(name = "nr_linha")
    private int nrLinha;
    @Basic(optional = false)
    @Column(name = "nr_valor")
    private double nrValor;
    @Basic(optional = true)
    @Column(name = "ds_justificativa")
    private String dsJustificativa;
    
    /*
    @Basic(optional = false)
    @Column(name = "id_criterio")
    private int idCriterio;
    */

    @JoinColumn(name = "id_correcao", referencedColumnName = "id_correcao")
    @ManyToOne(optional = false)
    private TbCorrecao idCorrecao;

    public TbCorrecaoCriterio() {
    }

    public TbCorrecaoCriterio(Long idCorrecaoCriterio) {
        this.idCorrecaoCriterio = idCorrecaoCriterio;
    }

    public TbCorrecaoCriterio(Long idCorrecaoCriterio, int nrLinha, double nrValor) {
        this.idCorrecaoCriterio = idCorrecaoCriterio;
        this.nrLinha = nrLinha;
        this.nrValor = nrValor;
    }

    public Long getIdCorrecaoCriterio() {
        return idCorrecaoCriterio;
    }

    public void setIdCorrecaoCriterio(Long idCorrecaoCriterio) {
        this.idCorrecaoCriterio = idCorrecaoCriterio;
    }

    public int getNrLinha() {
        return nrLinha;
    }

    public void setNrLinha(int nrLinha) {
        this.nrLinha = nrLinha;
    }

    public double getNrValor() {
        return nrValor;
    }

    public void setNrValor(double nrValor) {
        this.nrValor = nrValor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCorrecaoCriterio != null ? idCorrecaoCriterio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCorrecaoCriterio)) {
            return false;
        }
        TbCorrecaoCriterio other = (TbCorrecaoCriterio) object;
        if ((this.idCorrecaoCriterio == null && other.idCorrecaoCriterio != null) || (this.idCorrecaoCriterio != null && !this.idCorrecaoCriterio.equals(other.idCorrecaoCriterio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbCorrecaoCriterio[ idCorrecaoCriterio=" + idCorrecaoCriterio + " nrLinha="+ this.nrLinha +" nrValor="+ this.nrValor + " idCorrecao="+this.getIdCorrecao()+" ]";
    }


    public TbCriterio getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(TbCriterio idCriterio) {
        this.idCriterio = idCriterio;
    }

    public String getDsJustificativa() {
        return dsJustificativa;
    }

    public void setDsJustificativa(String dsJustificativa) {
        this.dsJustificativa = dsJustificativa;
    }

    public TbCorrecao getIdCorrecao() {
        return idCorrecao;
    }

    public void setIdCorrecao(TbCorrecao idCorrecao) {
        this.idCorrecao = idCorrecao;
    }

}
