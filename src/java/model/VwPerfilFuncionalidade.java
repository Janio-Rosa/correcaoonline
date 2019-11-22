/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KAMYLLA
 */
@Entity
@Table(name = "vw_perfil_funcionalidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwPerfilFuncionalidade.findAll", query = "SELECT v FROM VwPerfilFuncionalidade v"),
    @NamedQuery(name = "VwPerfilFuncionalidade.findByIdPerfil", query = "SELECT v FROM VwPerfilFuncionalidade v WHERE v.idPerfil = :idPerfil"),
    @NamedQuery(name = "VwPerfilFuncionalidade.findByIdFuncionalidade", query = "SELECT v FROM VwPerfilFuncionalidade v WHERE v.idFuncionalidade = :idFuncionalidade"),
    @NamedQuery(name = "VwPerfilFuncionalidade.findByNrOrdem", query = "SELECT v FROM VwPerfilFuncionalidade v WHERE v.nrOrdem = :nrOrdem"),
    @NamedQuery(name = "VwPerfilFuncionalidade.findByNmPerfil", query = "SELECT v FROM VwPerfilFuncionalidade v WHERE v.nmPerfil = :nmPerfil"),
    @NamedQuery(name = "VwPerfilFuncionalidade.findByIdPerfilPai", query = "SELECT v FROM VwPerfilFuncionalidade v WHERE v.idPerfilPai = :idPerfilPai"),
    @NamedQuery(name = "VwPerfilFuncionalidade.findByNmPaginaSistema", query = "SELECT v FROM VwPerfilFuncionalidade v WHERE v.nmPaginaSistema = :nmPaginaSistema"),
    @NamedQuery(name = "VwPerfilFuncionalidade.findByNmFuncionalidade", query = "SELECT v FROM VwPerfilFuncionalidade v WHERE v.nmFuncionalidade = :nmFuncionalidade"),
    @NamedQuery(name = "VwPerfilFuncionalidade.findByFlTitulo", query = "SELECT v FROM VwPerfilFuncionalidade v WHERE v.flTitulo = :flTitulo"),
    @NamedQuery(name = "VwPerfilFuncionalidade.findByIdFuncionalidadeMae", query = "SELECT v FROM VwPerfilFuncionalidade v WHERE v.idFuncionalidadeMae = :idFuncionalidadeMae")})
public class VwPerfilFuncionalidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_perfil")
    private Integer idPerfil;
    @Id
    @Column(name = "nr_linha")
    private Integer nrLinha;
    @Column(name = "id_funcionalidade")
    private Integer idFuncionalidade;
    @Column(name = "nr_ordem")
    private Integer nrOrdem;
    @Column(name = "nm_perfil")
    private String nmPerfil;
    @Column(name = "id_perfil_pai")
    private Integer idPerfilPai;
    @Column(name = "nm_pagina_sistema")
    private String nmPaginaSistema;
    @Column(name = "nm_funcionalidade")
    private String nmFuncionalidade;
    @Column(name = "fl_titulo")
    private Boolean flTitulo;
    @Column(name = "id_funcionalidade_mae")
    private Integer idFuncionalidadeMae;

    public VwPerfilFuncionalidade() {
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Integer getIdFuncionalidade() {
        return idFuncionalidade;
    }

    public void setIdFuncionalidade(Integer idFuncionalidade) {
        this.idFuncionalidade = idFuncionalidade;
    }

    public Integer getNrOrdem() {
        return nrOrdem;
    }

    public void setNrOrdem(Integer nrOrdem) {
        this.nrOrdem = nrOrdem;
    }

    public String getNmPerfil() {
        return nmPerfil;
    }

    public void setNmPerfil(String nmPerfil) {
        this.nmPerfil = nmPerfil;
    }

    public Integer getIdPerfilPai() {
        return idPerfilPai;
    }

    public void setIdPerfilPai(Integer idPerfilPai) {
        this.idPerfilPai = idPerfilPai;
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

    public Integer getIdFuncionalidadeMae() {
        return idFuncionalidadeMae;
    }

    public void setIdFuncionalidadeMae(Integer idFuncionalidadeMae) {
        this.idFuncionalidadeMae = idFuncionalidadeMae;
    }

    public Integer getNrLinha() {
        return nrLinha;
    }

    public void setNrLinha(Integer nrLinha) {
        this.nrLinha = nrLinha;
    }
    
}
