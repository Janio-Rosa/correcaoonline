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
@Table(name = "tb_tipo_correcao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTipoCorrecao.findAll", query = "SELECT t FROM TbTipoCorrecao t"),
    @NamedQuery(name = "TbTipoCorrecao.findByIdTipoCorrecao", query = "SELECT t FROM TbTipoCorrecao t WHERE t.idTipoCorrecao = :idTipoCorrecao"),
    @NamedQuery(name = "TbTipoCorrecao.findByFlContabilizaNota", query = "SELECT t FROM TbTipoCorrecao t WHERE t.flContabilizaNota = :flContabilizaNota"),
    @NamedQuery(name = "TbTipoCorrecao.findByFlSobreposicaoNota", query = "SELECT t FROM TbTipoCorrecao t WHERE t.flSobreposicaoNota = :flSobreposicaoNota")})
    @SequenceGenerator(name = "tb_tipo_correcao_id_tipo_correcao_seq", sequenceName = "tb_tipo_correcao_id_tipo_correcao_seq")
public class TbTipoCorrecao implements Serializable {
    @Column(name = "nr_prioridade")
    private Integer nrPrioridade;
    @OneToMany(mappedBy = "idTipoCorrecao")
    private List<TbCorrecao> tbCorrecaoList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tb_tipo_correcao_id_tipo_correcao_seq")
    @Basic(optional = false)
    @Column(name = "id_tipo_correcao")
    private Integer idTipoCorrecao;
    @Basic(optional = false)
    @Column(name = "nm_tipo_correcao")
    private String nmTipoCorrecao;
    @Basic(optional = false)
    @Column(name = "fl_contabiliza_nota" , insertable=false )
    private boolean flContabilizaNota;
    @Basic(optional = false)
    @Column(name = "fl_sobreposicao_nota" , insertable=false)
    private boolean flSobreposicaoNota;

    public TbTipoCorrecao() {
    }

    public TbTipoCorrecao(Integer idTipoCorrecao) {
        this.idTipoCorrecao = idTipoCorrecao;
    }

    public TbTipoCorrecao(Integer idTipoCorrecao, String nmTipoCorrecao, boolean flContabilizaNota, boolean flSobreposicaoNota) {
        this.idTipoCorrecao = idTipoCorrecao;
        this.nmTipoCorrecao = nmTipoCorrecao;
        this.flContabilizaNota = flContabilizaNota;
        this.flSobreposicaoNota = flSobreposicaoNota;
    }

    public Integer getIdTipoCorrecao() {
        return idTipoCorrecao;
    }

    public void setIdTipoCorrecao(Integer idTipoCorrecao) {
        this.idTipoCorrecao = idTipoCorrecao;
    }

    public String getNmTipoCorrecao() {
        return nmTipoCorrecao;
    }

    public void setNmTipoCorrecao(String nmTipoCorrecao) {
        this.nmTipoCorrecao = nmTipoCorrecao;
    }

    public boolean getFlContabilizaNota() {
        return flContabilizaNota;
    }

    public void setFlContabilizaNota(boolean flContabilizaNota) {
        this.flContabilizaNota = flContabilizaNota;
    }

    public boolean getFlSobreposicaoNota() {
        return flSobreposicaoNota;
    }

    public void setFlSobreposicaoNota(boolean flSobreposicaoNota) {
        this.flSobreposicaoNota = flSobreposicaoNota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCorrecao != null ? idTipoCorrecao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTipoCorrecao)) {
            return false;
        }
        TbTipoCorrecao other = (TbTipoCorrecao) object;
        if ((this.idTipoCorrecao == null && other.idTipoCorrecao != null) || (this.idTipoCorrecao != null && !this.idTipoCorrecao.equals(other.idTipoCorrecao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbTipoCorrecao[ idTipoCorrecao=" + idTipoCorrecao + " ]";
    }

    @XmlTransient
    public List<TbCorrecao> getTbCorrecaoList() {
        return tbCorrecaoList;
    }

    public void setTbCorrecaoList(List<TbCorrecao> tbCorrecaoList) {
        this.tbCorrecaoList = tbCorrecaoList;
    }

    public Integer getNrPrioridade() {
        return nrPrioridade;
    }

    public void setNrPrioridade(Integer nrPrioridade) {
        this.nrPrioridade = nrPrioridade;
    }
    
}
