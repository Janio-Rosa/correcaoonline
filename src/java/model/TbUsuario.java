/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Janio
 */
@Entity
@Table(name = "tb_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUsuario.findAll", query = "SELECT t FROM TbUsuario t"),
    @NamedQuery(name = "TbUsuario.findByIdUsuario", query = "SELECT t FROM TbUsuario t WHERE t.idUsuario = :idUsuario"),
    @NamedQuery(name = "TbUsuario.findByNmUsuario", query = "SELECT t FROM TbUsuario t WHERE t.nmUsuario = :nmUsuario"),
    @NamedQuery(name = "TbUsuario.findByNmSenha", query = "SELECT t FROM TbUsuario t WHERE t.nmSenha = :nmSenha"),
    @NamedQuery(name = "TbUsuario.findByDsChavePublica", query = "SELECT t FROM TbUsuario t WHERE t.dsChavePublica = :dsChavePublica"),
    @NamedQuery(name = "TbUsuario.findByNrCpf", query = "SELECT t FROM TbUsuario t WHERE t.nrCpf = :nrCpf"),
    @NamedQuery(name = "TbUsuario.findByCdCurso", query = "SELECT t FROM TbUsuario t WHERE t.cdCurso = :cdCurso"),
    @NamedQuery(name = "TbUsuario.findByDtInclusao", query = "SELECT t FROM TbUsuario t WHERE t.dtInclusao = :dtInclusao")})
    @SequenceGenerator(name = "tb_usuario_id_usuario_seq", sequenceName = "tb_usuario_id_usuario_seq")

public class TbUsuario implements Serializable {
    @Basic(optional = false)
    @Column(name = "dt_inclusao",updatable=false,insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInclusao;
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina")
    @ManyToOne
    private TbDisciplina idDisciplina;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tb_usuario_id_usuario_seq")
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Basic(optional = false)
    @Column(name = "nm_usuario")
    private String nmUsuario;
    @Basic(optional = false)
    @Column(name = "nm_senha")
    private String nmSenha;
    @Column(name = "ds_chave_publica")
    private String dsChavePublica;
    @Column(name = "nr_cpf")
    private String nrCpf;
    @Column(name = "cd_curso")
    private Integer cdCurso;
    @Basic(optional = true)
    @Column(name = "fl_ativo",insertable=false,updatable=true)
    private boolean flAtivo;
    @Basic(optional = true)
    @Column(name = "fl_primeiro_acesso",insertable=false,updatable=true)
    private boolean flPrimeiroAcesso;
    

    public TbUsuario() {
    }

    public TbUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TbUsuario(Long idUsuario, String nmUsuario, String nmSenha, Date dtInclusao) {
        this.idUsuario = idUsuario;
        this.nmUsuario = nmUsuario;
        this.nmSenha = nmSenha;
        this.dtInclusao = dtInclusao;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
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
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUsuario)) {
            return false;
        }
        TbUsuario other = (TbUsuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    public boolean isFlAtivo() {
        return flAtivo;
    }

    public void setFlAtivo(boolean flAtivo) {
        this.flAtivo = flAtivo;
    }

    @Override
    public String toString() {
        return "id: " + idUsuario + " - Usuario: "+nmUsuario;
    }

    public TbDisciplina getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(TbDisciplina idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public boolean isFlPrimeiroAcesso() {
        return flPrimeiroAcesso;
    }

    public void setFlPrimeiroAcesso(boolean flPrimeiroAcesso) {
        this.flPrimeiroAcesso = flPrimeiroAcesso;
    }

    
}
