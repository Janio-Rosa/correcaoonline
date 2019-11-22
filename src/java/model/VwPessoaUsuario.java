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
@Table(name = "vw_pessoa_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwPessoaUsuario.findAll", query = "SELECT v FROM VwPessoaUsuario v"),
    @NamedQuery(name = "VwPessoaUsuario.findByNrCpf", query = "SELECT v FROM VwPessoaUsuario v WHERE v.nrCpf = :nrCpf"),
    @NamedQuery(name = "VwPessoaUsuario.findByIdEmpresa", query = "SELECT v FROM VwPessoaUsuario v WHERE v.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "VwPessoaUsuario.findByNmPessoa", query = "SELECT v FROM VwPessoaUsuario v WHERE v.nmPessoa = :nmPessoa"),
    @NamedQuery(name = "VwPessoaUsuario.findByNrRg", query = "SELECT v FROM VwPessoaUsuario v WHERE v.nrRg = :nrRg"),
    @NamedQuery(name = "VwPessoaUsuario.findByNmRgOrgao", query = "SELECT v FROM VwPessoaUsuario v WHERE v.nmRgOrgao = :nmRgOrgao"),
    @NamedQuery(name = "VwPessoaUsuario.findByNmRgUf", query = "SELECT v FROM VwPessoaUsuario v WHERE v.nmRgUf = :nmRgUf"),
    @NamedQuery(name = "VwPessoaUsuario.findByIdUsuario", query = "SELECT v FROM VwPessoaUsuario v WHERE v.idUsuario = :idUsuario"),
    @NamedQuery(name = "VwPessoaUsuario.findByNmUsuario", query = "SELECT v FROM VwPessoaUsuario v WHERE v.nmUsuario = :nmUsuario"),
    @NamedQuery(name = "VwPessoaUsuario.findByNmSenha", query = "SELECT v FROM VwPessoaUsuario v WHERE v.nmSenha = :nmSenha"),
    @NamedQuery(name = "VwPessoaUsuario.findByDsChavePublica", query = "SELECT v FROM VwPessoaUsuario v WHERE v.dsChavePublica = :dsChavePublica"),
    @NamedQuery(name = "VwPessoaUsuario.findByCdCurso", query = "SELECT v FROM VwPessoaUsuario v WHERE v.cdCurso = :cdCurso"),
    @NamedQuery(name = "VwPessoaUsuario.findByDtInclusao", query = "SELECT v FROM VwPessoaUsuario v WHERE v.dtInclusao = :dtInclusao"),
    @NamedQuery(name = "VwPessoaUsuario.findByFlAtivo", query = "SELECT v FROM VwPessoaUsuario v WHERE v.flAtivo = :flAtivo"),
    @NamedQuery(name = "VwPessoaUsuario.findByNmEmpresa", query = "SELECT v FROM VwPessoaUsuario v WHERE v.nmEmpresa = :nmEmpresa")})
public class VwPessoaUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    @Column(name = "nr_cpf")
    private String nrCpf;
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
    @Id
    @Column(name = "id_usuario")
    private BigInteger idUsuario;
    @Column(name = "nm_usuario")
    private String nmUsuario;
    @Column(name = "nm_senha")
    private String nmSenha;
    @Column(name = "ds_chave_publica")
    private String dsChavePublica;
    @Column(name = "cd_curso")
    private Integer cdCurso;
    @Column(name = "dt_inclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInclusao;
    @Column(name = "fl_ativo")
    private Boolean flAtivo;
    @Column(name = "nm_empresa")
    private String nmEmpresa;
    @Column(name = "nm_disciplina")
    private String nmDisciplina;

    public VwPessoaUsuario() {
    }

    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
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

    public String getNmEmpresa() {
        return nmEmpresa;
    }

    public void setNmEmpresa(String nmEmpresa) {
        this.nmEmpresa = nmEmpresa;
    }

    public String getNmDisciplina() {
        return nmDisciplina;
    }

    public void setNmDisciplina(String nmDisciplina) {
        this.nmDisciplina = nmDisciplina;
    }
    
}
