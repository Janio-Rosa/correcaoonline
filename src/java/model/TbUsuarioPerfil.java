/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_usuario_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUsuarioPerfil.findAll", query = "SELECT t FROM TbUsuarioPerfil t"),
    @NamedQuery(name = "TbUsuarioPerfil.findByIdUsuario", query = "SELECT t FROM TbUsuarioPerfil t WHERE t.tbUsuarioPerfilPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "TbUsuarioPerfil.findByIdPerfil", query = "SELECT t FROM TbUsuarioPerfil t WHERE t.tbUsuarioPerfilPK.idPerfil = :idPerfil"),
    @NamedQuery(name = "TbUsuarioPerfil.findByDtInclusao", query = "SELECT t FROM TbUsuarioPerfil t WHERE t.dtInclusao = :dtInclusao")})

public class TbUsuarioPerfil implements Serializable {
    @Basic(optional = true)
    @Column(name = "dt_inclusao",insertable=false,updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInclusao;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbUsuario tbUsuario;
    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbPerfil tbPerfil;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbUsuarioPerfilPK tbUsuarioPerfilPK;
    
 

    public TbUsuarioPerfil() {
    }

    public TbUsuarioPerfil(TbUsuarioPerfilPK tbUsuarioPerfilPK) {
        this.tbUsuarioPerfilPK = tbUsuarioPerfilPK;
    }

    public TbUsuarioPerfil(TbUsuarioPerfilPK tbUsuarioPerfilPK, Date dtInclusao) {
        this.tbUsuarioPerfilPK = tbUsuarioPerfilPK;
        this.dtInclusao = dtInclusao;
    }

    public TbUsuarioPerfil(long idUsuario, int idPerfil) {
        this.tbUsuarioPerfilPK = new TbUsuarioPerfilPK(idUsuario, idPerfil);
    }

    public TbUsuarioPerfilPK getTbUsuarioPerfilPK() {
        return tbUsuarioPerfilPK;
    }

    public void setTbUsuarioPerfilPK(TbUsuarioPerfilPK tbUsuarioPerfilPK) {
        this.tbUsuarioPerfilPK = tbUsuarioPerfilPK;
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
        hash += (tbUsuarioPerfilPK != null ? tbUsuarioPerfilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUsuarioPerfil)) {
            return false;
        }
        TbUsuarioPerfil other = (TbUsuarioPerfil) object;
        if ((this.tbUsuarioPerfilPK == null && other.tbUsuarioPerfilPK != null) || (this.tbUsuarioPerfilPK != null && !this.tbUsuarioPerfilPK.equals(other.tbUsuarioPerfilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbUsuarioPerfil[ tbUsuarioPerfilPK=" + tbUsuarioPerfilPK + " ]";
    }

    public TbUsuario getTbUsuario() {
        return tbUsuario;
    }

    public void setTbUsuario(TbUsuario tbUsuario) {
        this.tbUsuario = tbUsuario;
    }

    public TbPerfil getTbPerfil() {
        return tbPerfil;
    }

    public void setTbPerfil(TbPerfil tbPerfil) {
        this.tbPerfil = tbPerfil;
    }

}
