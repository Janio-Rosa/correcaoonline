/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Janio
 */
@Entity
@Table(name = "vw_usuario_funcionalidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwUsuarioFuncionalidade.findAll", query = "SELECT v FROM VwUsuarioFuncionalidade v"),
    @NamedQuery(name = "VwUsuarioFuncionalidade.findByIdUsuario", query = "SELECT v FROM VwUsuarioFuncionalidade v WHERE v.idUsuario = :idUsuario"),
    @NamedQuery(name = "VwUsuarioFuncionalidade.findByNmUsuario", query = "SELECT v FROM VwUsuarioFuncionalidade v WHERE v.nmUsuario = :nmUsuario"),
    @NamedQuery(name = "VwUsuarioFuncionalidade.findByNmSenha", query = "SELECT v FROM VwUsuarioFuncionalidade v WHERE v.nmSenha = :nmSenha"),
    @NamedQuery(name = "VwUsuarioFuncionalidade.findByDsChavePublica", query = "SELECT v FROM VwUsuarioFuncionalidade v WHERE v.dsChavePublica = :dsChavePublica"),
    @NamedQuery(name = "VwUsuarioFuncionalidade.findByNrCpf", query = "SELECT v FROM VwUsuarioFuncionalidade v WHERE v.nrCpf = :nrCpf"),
    @NamedQuery(name = "VwUsuarioFuncionalidade.findByCdCurso", query = "SELECT v FROM VwUsuarioFuncionalidade v WHERE v.cdCurso = :cdCurso"),
    @NamedQuery(name = "VwUsuarioFuncionalidade.findByDtInclusao", query = "SELECT v FROM VwUsuarioFuncionalidade v WHERE v.dtInclusao = :dtInclusao"),
    @NamedQuery(name = "VwUsuarioFuncionalidade.findByIdFuncionalidade", query = "SELECT v FROM VwUsuarioFuncionalidade v WHERE v.idFuncionalidade = :idFuncionalidade"),
    @NamedQuery(name = "VwUsuarioFuncionalidade.findByNmPaginaSistema", query = "SELECT v FROM VwUsuarioFuncionalidade v WHERE v.nmPaginaSistema = :nmPaginaSistema"),
    @NamedQuery(name = "VwUsuarioFuncionalidade.findByNmFuncionalidade", query = "SELECT v FROM VwUsuarioFuncionalidade v WHERE v.nmFuncionalidade = :nmFuncionalidade"),
    @NamedQuery(name = "VwUsuarioFuncionalidade.findByFlTitulo", query = "SELECT v FROM VwUsuarioFuncionalidade v WHERE v.flTitulo = :flTitulo"),
    @NamedQuery(name = "VwUsuarioFuncionalidade.findByIdFuncionalidadeMae", query = "SELECT v FROM VwUsuarioFuncionalidade v WHERE v.idFuncionalidadeMae = :idFuncionalidadeMae"),
    @NamedQuery(name = "VwUsuarioFuncionalidade.findByIdPerfil", query = "SELECT v FROM VwUsuarioFuncionalidade v WHERE v.idPerfil = :idPerfil"),
    @NamedQuery(name = "VwUsuarioFuncionalidade.findByDtInclusaoNoPerfil", query = "SELECT v FROM VwUsuarioFuncionalidade v WHERE v.dtInclusaoNoPerfil = :dtInclusaoNoPerfil"),
    @NamedQuery(name = "VwUsuarioFuncionalidade.findByNmPerfil", query = "SELECT v FROM VwUsuarioFuncionalidade v WHERE v.nmPerfil = :nmPerfil"),
    @NamedQuery(name = "VwUsuarioFuncionalidade.findByIdPerfilPai", query = "SELECT v FROM VwUsuarioFuncionalidade v WHERE v.idPerfilPai = :idPerfilPai"),
    @NamedQuery(name = "VwUsuarioFuncionalidade.findByNrOrdem", query = "SELECT v FROM VwUsuarioFuncionalidade v WHERE v.nrOrdem = :nrOrdem")})
public class VwUsuarioFuncionalidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_usuario")
    private BigInteger idUsuario;
    @Column(name = "nm_usuario")
    private String nmUsuario;
    @Column(name = "nm_senha")
    private String nmSenha;
    @Column(name = "ds_chave_publica")
    private String dsChavePublica;
    @Column(name = "nr_cpf")
    private String nrCpf;
    @Column(name = "cd_curso")
    private Integer cdCurso;
    @Column(name = "dt_inclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInclusao;
    @Column(name = "id_funcionalidade")
    @Id
    private Integer idFuncionalidade;
    @Column(name = "nm_pagina_sistema")
    private String nmPaginaSistema;
    @Column(name = "nm_funcionalidade")
    private String nmFuncionalidade;
    @Column(name = "fl_titulo")
    private Boolean flTitulo;
    @Column(name = "id_funcionalidade_mae")
    private Integer idFuncionalidadeMae;
    @Column(name = "id_perfil")
    private Integer idPerfil;
    @Column(name = "dt_inclusao_no_perfil")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInclusaoNoPerfil;
    @Column(name = "nm_perfil")
    private String nmPerfil;
    @Column(name = "id_perfil_pai")
    private Integer idPerfilPai;
    @Column(name = "nr_ordem")
    private Integer nrOrdem;

    public VwUsuarioFuncionalidade() {
    }

    public BigInteger getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigInteger idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getNmSenha() {
        return nmSenha;
    }

    public void setNmSenha(String nmSenha) {
        this.nmSenha = nmSenha;
    }

    public String getDsChavePublica() {
        return dsChavePublica;
    }

    public void setDsChavePublica(String dsChavePublica) {
        this.dsChavePublica = dsChavePublica;
    }

    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public Integer getCdCurso() {
        return cdCurso;
    }

    public void setCdCurso(Integer cdCurso) {
        this.cdCurso = cdCurso;
    }

    public Date getDtInclusao() {
        return dtInclusao;
    }

    public void setDtInclusao(Date dtInclusao) {
        this.dtInclusao = dtInclusao;
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

    public Integer getIdFuncionalidadeMae() {
        return idFuncionalidadeMae;
    }

    public void setIdFuncionalidadeMae(Integer idFuncionalidadeMae) {
        this.idFuncionalidadeMae = idFuncionalidadeMae;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Date getDtInclusaoNoPerfil() {
        return dtInclusaoNoPerfil;
    }

    public void setDtInclusaoNoPerfil(Date dtInclusaoNoPerfil) {
        this.dtInclusaoNoPerfil = dtInclusaoNoPerfil;
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

    public Integer getNrOrdem() {
        return nrOrdem;
    }

    public void setNrOrdem(Integer nrOrdem) {
        this.nrOrdem = nrOrdem;
    }
    
}
