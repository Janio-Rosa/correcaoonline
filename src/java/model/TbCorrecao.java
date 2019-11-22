/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Janio
 */
@Entity
@Table(name = "tb_correcao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCorrecao.findAll", query = "SELECT t FROM TbCorrecao t"),
    @NamedQuery(name = "TbCorrecao.findByIdCorrecao", query = "SELECT t FROM TbCorrecao t WHERE t.idCorrecao = :idCorrecao"),
    @NamedQuery(name = "TbCorrecao.findByNrNota", query = "SELECT t FROM TbCorrecao t WHERE t.nrNota = :nrNota"),
    @NamedQuery(name = "TbCorrecao.findByDtAtualizacao", query = "SELECT t FROM TbCorrecao t WHERE t.dtAtualizacao = :dtAtualizacao"),
    @NamedQuery(name = "TbCorrecao.findByFlSucesso", query = "SELECT t FROM TbCorrecao t WHERE t.flSucesso = :flSucesso")})
@SequenceGenerator(name = "tb_correcao_id_resposta_seq", sequenceName = "tb_correcao_id_resposta_seq")
public class TbCorrecao implements Serializable {
    @Basic(optional = false)
    @Column(name = "dt_atualizacao",insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAtualizacao;
    @JoinColumn(name = "id_tipo_correcao", referencedColumnName = "id_tipo_correcao")
    @ManyToOne
    private TbTipoCorrecao idTipoCorrecao;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tb_correcao_id_resposta_seq")
    @Basic(optional = false)
    @Column(name = "id_correcao")
    private Long idCorrecao;

    @Basic(optional = false)
    @Column(name = "nr_nota")
    private double nrNota;

    @Basic(optional = false)
    @Column(name = "id_genero_categoria")
    private Integer idGeneroCategoria;
    
    @Basic(optional = false)
    @Column(name = "fl_sucesso")
    private boolean flSucesso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCorrecao")
    private List<TbCorrecaoCriterio> tbCorrecaoCriterioList;
    
    /*
    @Basic(optional = false)
    @Column(name = "id_tipo_correcao")
    private Integer idTipoCorrecao;
    */
    @JoinColumn(name = "id_resposta", referencedColumnName = "id_resposta")
    @ManyToOne(optional = false)
    private TbResposta idResposta;
    @JoinColumn(name = "id_colaborador", referencedColumnName = "id_colaborador")
    @ManyToOne(optional = false)
    private TbColaborador idColaborador;

    @Basic(optional = false)
    @Column(name = "dt_insercao",insertable=false,updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInsercao;
    
    public TbCorrecao() {
    }

    public TbCorrecao(Long idCorrecao) {
        this.idCorrecao = idCorrecao;
    }

    public TbCorrecao(Long idCorrecao, double nrNota, Date dtAtualizacao, boolean flSucesso) {
        this.idCorrecao = idCorrecao;
        this.nrNota = nrNota;
        this.dtAtualizacao = dtAtualizacao;
        this.flSucesso = flSucesso;
    }

    public Long getIdCorrecao() {
        return idCorrecao;
    }

    public void setIdCorrecao(Long idCorrecao) {
        this.idCorrecao = idCorrecao;
    }

    public double getNrNota() {
        return nrNota;
    }

    public void setNrNota(double nrNota) {
        this.nrNota = nrNota;
    }

    public Date getDtAtualizacao() {
        return dtAtualizacao;
    }

    public void setDtAtualizacao(Date dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }

    public boolean getFlSucesso() {
        return flSucesso;
    }

    public void setFlSucesso(boolean flSucesso) {
        this.flSucesso = flSucesso;
    }

    @XmlTransient
    public List<TbCorrecaoCriterio> getTbCorrecaoCriterioList() {
        return tbCorrecaoCriterioList;
    }

    public void setTbCorrecaoCriterioList(List<TbCorrecaoCriterio> tbCorrecaoCriterioList) {
        this.tbCorrecaoCriterioList = tbCorrecaoCriterioList;
    }

    public TbResposta getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(TbResposta idResposta) {
        this.idResposta = idResposta;
    }

    public TbColaborador getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(TbColaborador idColaborador) {
        this.idColaborador = idColaborador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCorrecao != null ? idCorrecao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCorrecao)) {
            return false;
        }
        TbCorrecao other = (TbCorrecao) object;
        if ((this.idCorrecao == null && other.idCorrecao != null) || (this.idCorrecao != null && !this.idCorrecao.equals(other.idCorrecao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbCorrecao[ idCorrecao=" + idCorrecao + " nrNota="+ nrNota + " ]";
    }


    public TbTipoCorrecao getIdTipoCorrecao() {
        return idTipoCorrecao;
    }

    public void setIdTipoCorrecao(TbTipoCorrecao idTipoCorrecao) {
        this.idTipoCorrecao = idTipoCorrecao;
    }

    public Date getDtInsercao() {
        return dtInsercao;
    }

    public void setDtInsercao(Date dtInsercao) {
        this.dtInsercao = dtInsercao;
    }

    public Integer getIdGeneroCategoria() {
        return idGeneroCategoria;
    }

    public void setIdGeneroCategoria(Integer idGeneroCategoria) {
        this.idGeneroCategoria = idGeneroCategoria;
    }

    
}
