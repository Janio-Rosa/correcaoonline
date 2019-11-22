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
@Table(name = "tb_funcionalidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFuncionalidade.findAll", query = "SELECT t FROM TbFuncionalidade t"),
    @NamedQuery(name = "TbFuncionalidade.findByIdFuncionalidade", query = "SELECT t FROM TbFuncionalidade t WHERE t.idFuncionalidade = :idFuncionalidade"),
    @NamedQuery(name = "TbFuncionalidade.findByNmPaginaSistema", query = "SELECT t FROM TbFuncionalidade t WHERE t.nmPaginaSistema = :nmPaginaSistema"),
    @NamedQuery(name = "TbFuncionalidade.findByNmFuncionalidade", query = "SELECT t FROM TbFuncionalidade t WHERE t.nmFuncionalidade = :nmFuncionalidade"),
    @NamedQuery(name = "TbFuncionalidade.findByFlTitulo", query = "SELECT t FROM TbFuncionalidade t WHERE t.flTitulo = :flTitulo")})
    @SequenceGenerator(name = "tb_funcionalidade_id_funcionalidade_seq", sequenceName = "tb_funcionalidade_id_funcionalidade_seq")
public class TbFuncionalidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tb_funcionalidade_id_funcionalidade_seq")
    @Basic(optional = false)
    @Column(name = "id_funcionalidade")
    private Integer idFuncionalidade;
    @Column(name = "nm_pagina_sistema")
    private String nmPaginaSistema;
    @Column(name = "nm_funcionalidade")
    private String nmFuncionalidade;
    @Column(name = "fl_titulo")
    private Boolean flTitulo;
    @OneToMany(mappedBy = "idFuncionalidadeMae")
    private List<TbFuncionalidade> tbFuncionalidadeList;
    @JoinColumn(name = "id_funcionalidade_mae", referencedColumnName = "id_funcionalidade")
    @ManyToOne
    private TbFuncionalidade idFuncionalidadeMae;

    public TbFuncionalidade() {
    }

    public TbFuncionalidade(Integer idFuncionalidade) {
        this.idFuncionalidade = idFuncionalidade;
    }

    public Integer getIdFuncionalidade() {
        return idFuncionalidade;
    }

    public void setIdFuncionalidade(Integer idFuncionalidade) {
        this.idFuncionalidade = idFuncionalidade;
    }

    public String getNmPaginaSistema() {
        return nmPaginaSistema;
    }

    public void setNmPaginaSistema(String nmPaginaSistema) {
        this.nmPaginaSistema = nmPaginaSistema;
    }

    public String getNmFuncionalidade() {
        return nmFuncionalidade;
    }

    public void setNmFuncionalidade(String nmFuncionalidade) {
        this.nmFuncionalidade = nmFuncionalidade;
    }

    public Boolean getFlTitulo() {
        return flTitulo;
    }

    public void setFlTitulo(Boolean flTitulo) {
        this.flTitulo = flTitulo;
    }

    @XmlTransient
    public List<TbFuncionalidade> getTbFuncionalidadeList() {
        return tbFuncionalidadeList;
    }

    public void setTbFuncionalidadeList(List<TbFuncionalidade> tbFuncionalidadeList) {
        this.tbFuncionalidadeList = tbFuncionalidadeList;
    }

    public TbFuncionalidade getIdFuncionalidadeMae() {
        return idFuncionalidadeMae;
    }

    public void setIdFuncionalidadeMae(TbFuncionalidade idFuncionalidadeMae) {
        this.idFuncionalidadeMae = idFuncionalidadeMae;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionalidade != null ? idFuncionalidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFuncionalidade)) {
            return false;
        }
        TbFuncionalidade other = (TbFuncionalidade) object;
        if ((this.idFuncionalidade == null && other.idFuncionalidade != null) || (this.idFuncionalidade != null && !this.idFuncionalidade.equals(other.idFuncionalidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbFuncionalidade[ idFuncionalidade=" + idFuncionalidade + " ]";
    }
    
}
