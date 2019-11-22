/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Janio
 */
@Embeddable
public class TbUsuarioPerfilPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private long idUsuario;
    @Basic(optional = false)
    @Column(name = "id_perfil")
    private int idPerfil;

    public TbUsuarioPerfilPK() {
    }

    public TbUsuarioPerfilPK(long idUsuario, int idPerfil) {
        this.idUsuario = idUsuario;
        this.idPerfil = idPerfil;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuario;
        hash += (int) idPerfil;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUsuarioPerfilPK)) {
            return false;
        }
        TbUsuarioPerfilPK other = (TbUsuarioPerfilPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idPerfil != other.idPerfil) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbUsuarioPerfilPK[ idUsuario=" + idUsuario + ", idPerfil=" + idPerfil + " ]";
    }
    
}
