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
 * @author KAMYLLA
 */
@Entity
@Table(name = "vw_usuario_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwUsuarioPerfil.findAll", query = "SELECT v FROM VwUsuarioPerfil v"),
    @NamedQuery(name = "VwUsuarioPerfil.findByIdUsuario", query = "SELECT v FROM VwUsuarioPerfil v WHERE v.idUsuario = :idUsuario"),
    @NamedQuery(name = "VwUsuarioPerfil.findByIdPerfil", query = "SELECT v FROM VwUsuarioPerfil v WHERE v.idPerfil = :idPerfil"),
    @NamedQuery(name = "VwUsuarioPerfil.findByDtInclusao", query = "SELECT v FROM VwUsuarioPerfil v WHERE v.dtInclusao = :dtInclusao"),
    @NamedQuery(name = "VwUsuarioPerfil.findByNmPerfil", query = "SELECT v FROM VwUsuarioPerfil v WHERE v.nmPerfil = :nmPerfil"),
    @NamedQuery(name = "VwUsuarioPerfil.findByIdPerfilPai", query = "SELECT v FROM VwUsuarioPerfil v WHERE v.idPerfilPai = :idPerfilPai"),
    @NamedQuery(name = "VwUsuarioPerfil.findByNmUsuario", query = "SELECT v FROM VwUsuarioPerfil v WHERE v.nmUsuario = :nmUsuario"),
    @NamedQuery(name = "VwUsuarioPerfil.findByNmSenha", query = "SELECT v FROM VwUsuarioPerfil v WHERE v.nmSenha = :nmSenha"),
    @NamedQuery(name = "VwUsuarioPerfil.findByDsChavePublica", query = "SELECT v FROM VwUsuarioPerfil v WHERE v.dsChavePublica = :dsChavePublica"),
    @NamedQuery(name = "VwUsuarioPerfil.findByNrCpf", query = "SELECT v FROM VwUsuarioPerfil v WHERE v.nrCpf = :nrCpf"),
    @NamedQuery(name = "VwUsuarioPerfil.findByCdCurso", query = "SELECT v FROM VwUsuarioPerfil v WHERE v.cdCurso = :cdCurso"),
    @NamedQuery(name = "VwUsuarioPerfil.findByDtIncluscaoUsuario", query = "SELECT v FROM VwUsuarioPerfil v WHERE v.dtIncluscaoUsuario = :dtIncluscaoUsuario"),
    @NamedQuery(name = "VwUsuarioPerfil.findByFlAtivo", query = "SELECT v FROM VwUsuarioPerfil v WHERE v.flAtivo = :flAtivo")})
public class VwUsuarioPerfil implements Serializable {
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Column(name = "dt_inclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInclusao;
    @Column(name = "dt_incluscao_usuario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtIncluscaoUsuario;
    @Column(name = "id_usuario_perfil")
    @Id
    private BigInteger idUsuarioPerfil;
    private static final long serialVersionUID = 1L;
    @Column(name = "id_perfil")
    private Integer idPerfil;
    @Column(name = "nm_perfil")
    private String nmPerfil;
    @Column(name = "id_perfil_pai")
    private Integer idPerfilPai;
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
    @Column(name = "fl_ativo")
    private Boolean flAtivo;
    @Column(name = "nm_pessoa")
    private String nmPessoa;

    public VwUsuarioPerfil() {
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Date getDtInclusao() {
        return dtInclusao;
    }

    public void setDtInclusao(Date dtInclusao) {
        this.dtInclusao = dtInclusao;
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

    public Date getDtIncluscaoUsuario() {
        return dtIncluscaoUsuario;
    }

    public void setDtIncluscaoUsuario(Date dtIncluscaoUsuario) {
        this.dtIncluscaoUsuario = dtIncluscaoUsuario;
    }

    public Boolean getFlAtivo() {
        return flAtivo;
    }

    public void setFlAtivo(Boolean flAtivo) {
        this.flAtivo = flAtivo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BigInteger getIdUsuarioPerfil() {
        return idUsuarioPerfil;
    }

    public void setIdUsuarioPerfil(BigInteger idUsuarioPerfil) {
        this.idUsuarioPerfil = idUsuarioPerfil;
    }

    public String getNmPessoa() {
        return nmPessoa;
    }

    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }
    
}
