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
@Table(name = "tb_genero_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbGeneroCategoria.findAll", query = "SELECT t FROM TbGeneroCategoria t"),
    @NamedQuery(name = "TbGeneroCategoria.findByIdGeneroCategoria", query = "SELECT t FROM TbGeneroCategoria t WHERE t.idGeneroCategoria = :idGeneroCategoria"),
    @NamedQuery(name = "TbGeneroCategoria.findByNmGeneroCategoria", query = "SELECT t FROM TbGeneroCategoria t WHERE t.nmGeneroCategoria = :nmGeneroCategoria")})
    @SequenceGenerator(name = "tb_tipo_categoria_id_tipo_categoria_seq", sequenceName = "tb_tipo_categoria_id_tipo_categoria_seq")
public class TbGeneroCategoria implements Serializable {
    //@OneToMany(mappedBy = "idGeneroCategoria",cascade= CascadeType.ALL)
    //private List<TbCategoriaCriterio> tbCategoriaCriterioList;
    @Column(name = "id_tipo_questao")
    private Integer idTipoQuestao;
    @Column(name = "fl_geral")
    private Boolean flGeral;
    //@OneToMany(mappedBy = "idGeneroCategoriaPai")
    //private List<TbGeneroCategoria> tbGeneroCategoriaList;
    //@JoinColumn(name = "id_genero_categoria_pai", referencedColumnName = "id_genero_categoria")
    //@ManyToOne
    //private TbGeneroCategoria idGeneroCategoriaPai;
    
    @Column(name = "id_genero_categoria_pai")
    private Integer idGeneroCategoriaPai;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tb_tipo_categoria_id_tipo_categoria_seq")
    @Basic(optional = false)
    @Column(name = "id_genero_categoria")
    private int idGeneroCategoria;
    @Basic(optional = false)
    @Column(name = "nm_genero_categoria")
    private String nmGeneroCategoria;

    @Column(name = "fl_ativo")
    private Boolean flAtivo;
    
    public TbGeneroCategoria() {
    }
    
    public TbGeneroCategoria(Integer id){
        this.idGeneroCategoria = id;
        
    }

    public TbGeneroCategoria(int idGeneroCategoria, String nmGeneroCategoria) {
        this.idGeneroCategoria = idGeneroCategoria;
        this.nmGeneroCategoria = nmGeneroCategoria;
    }

    public int getIdGeneroCategoria() {
        return idGeneroCategoria;
    }

    public void setIdGeneroCategoria(int idGeneroCategoria) {
        this.idGeneroCategoria = idGeneroCategoria;
    }

    public String getNmGeneroCategoria() {
        return nmGeneroCategoria;
    }

    public void setNmGeneroCategoria(String nmGeneroCategoria) {
        this.nmGeneroCategoria = nmGeneroCategoria;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbGeneroCategoria)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbGeneroCategoria[ idGenero=" + this.idGeneroCategoria + " - nmGenero: "+ this.nmGeneroCategoria +" - Flag: "+" - "+this.flGeral+ "]";
    }


    //public TbGeneroCategoria getIdGeneroCategoriaPai() {
    //    return idGeneroCategoriaPai;
    //}

    //public void setIdGeneroCategoriaPai(TbGeneroCategoria idGeneroCategoriaPai) {
    //    this.idGeneroCategoriaPai = idGeneroCategoriaPai;
    //}

    public Boolean getFlGeral() {
        return flGeral;
    }

    public void setFlGeral(Boolean flGeral) {
        this.flGeral = flGeral;
    }

    //@XmlTransient
    //public List<TbGeneroCategoria> getTbGeneroCategoriaList() {
    //    return tbGeneroCategoriaList;
    //}

    //public void setTbGeneroCategoriaList(List<TbGeneroCategoria> tbGeneroCategoriaList) {
    //    this.tbGeneroCategoriaList = tbGeneroCategoriaList;
    //}

    public Integer getIdTipoQuestao() {
        return idTipoQuestao;
    }

    public void setIdTipoQuestao(Integer idTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
    }

    //@XmlTransient
    //public List<TbCategoriaCriterio> getTbCategoriaCriterioList() {
    //    return tbCategoriaCriterioList;
    //}

    //public void setTbCategoriaCriterioList(List<TbCategoriaCriterio> tbCategoriaCriterioList) {
    //    this.tbCategoriaCriterioList = tbCategoriaCriterioList;
    //}

    public Integer getIdGeneroCategoriaPai() {
        return idGeneroCategoriaPai;
    }

    public void setIdGeneroCategoriaPai(Integer idGeneroCategoriaPai) {
        this.idGeneroCategoriaPai = idGeneroCategoriaPai;
    }

    public Boolean getFlAtivo() {
        return flAtivo;
    }

    public void setFlAtivo(Boolean flAtivo) {
        this.flAtivo = flAtivo;
    }

    
}
