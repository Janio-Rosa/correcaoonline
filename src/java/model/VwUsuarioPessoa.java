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
@Table(name = "vw_usuario_pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwUsuarioPessoa.findAll", query = "SELECT v FROM VwUsuarioPessoa v"),
    @NamedQuery(name = "VwUsuarioPessoa.findByIdUsuario", query = "SELECT v FROM VwUsuarioPessoa v WHERE v.idUsuario = :idUsuario"),
    @NamedQuery(name = "VwUsuarioPessoa.findByNmUsuario", query = "SELECT v FROM VwUsuarioPessoa v WHERE v.nmUsuario = :nmUsuario"),
    @NamedQuery(name = "VwUsuarioPessoa.findByNmSenha", query = "SELECT v FROM VwUsuarioPessoa v WHERE v.nmSenha = :nmSenha"),
    @NamedQuery(name = "VwUsuarioPessoa.findByDsChavePublica", query = "SELECT v FROM VwUsuarioPessoa v WHERE v.dsChavePublica = :dsChavePublica"),
    @NamedQuery(name = "VwUsuarioPessoa.findByNrCpf", query = "SELECT v FROM VwUsuarioPessoa v WHERE v.nrCpf = :nrCpf"),
    @NamedQuery(name = "VwUsuarioPessoa.findByCdCurso", query = "SELECT v FROM VwUsuarioPessoa v WHERE v.cdCurso = :cdCurso"),
    @NamedQuery(name = "VwUsuarioPessoa.findByDtInclusao", query = "SELECT v FROM VwUsuarioPessoa v WHERE v.dtInclusao = :dtInclusao"),
    @NamedQuery(name = "VwUsuarioPessoa.findByFlAtivo", query = "SELECT v FROM VwUsuarioPessoa v WHERE v.flAtivo = :flAtivo"),
    @NamedQuery(name = "VwUsuarioPessoa.findByIdDisciplina", query = "SELECT v FROM VwUsuarioPessoa v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwUsuarioPessoa.findByIdEmpresa", query = "SELECT v FROM VwUsuarioPessoa v WHERE v.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "VwUsuarioPessoa.findByNmPessoa", query = "SELECT v FROM VwUsuarioPessoa v WHERE v.nmPessoa = :nmPessoa"),
    @NamedQuery(name = "VwUsuarioPessoa.findByNrRg", query = "SELECT v FROM VwUsuarioPessoa v WHERE v.nrRg = :nrRg"),
    @NamedQuery(name = "VwUsuarioPessoa.findByNmRgOrgao", query = "SELECT v FROM VwUsuarioPessoa v WHERE v.nmRgOrgao = :nmRgOrgao"),
    @NamedQuery(name = "VwUsuarioPessoa.findByNmRgUf", query = "SELECT v FROM VwUsuarioPessoa v WHERE v.nmRgUf = :nmRgUf")})
public class VwUsuarioPessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_usuario")
    @Id
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
    @Column(name = "fl_ativo")
    private Boolean flAtivo;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    @Column(name = "nm_pessoa")
    private String nmPessoa;
    @Column(name = "nr_rg")
    private String nrRg;
    @Column(name = "nm_rg_orgao")
    private String nmRgOrgao;
    @Column(name = "nm_rg_uf")
    private String nmRgUf;

    public VwUsuarioPessoa() {
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

    public Boolean getFlAtivo() {
        return flAtivo;
    }

    public void setFlAtivo(Boolean flAtivo) {
        this.flAtivo = flAtivo;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNmPessoa() {
        return nmPessoa;
    }

    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }

    public String getNrRg() {
        return nrRg;
    }

    public void setNrRg(String nrRg) {
        this.nrRg = nrRg;
    }

    public String getNmRgOrgao() {
        return nmRgOrgao;
    }

    public void setNmRgOrgao(String nmRgOrgao) {
        this.nmRgOrgao = nmRgOrgao;
    }

    public String getNmRgUf() {
        return nmRgUf;
    }

    public void setNmRgUf(String nmRgUf) {
        this.nmRgUf = nmRgUf;
    }
    
}
