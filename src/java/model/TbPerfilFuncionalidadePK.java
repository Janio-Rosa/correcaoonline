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
public class TbPerfilFuncionalidadePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_perfil")
    private int idPerfil;
    @Basic(optional = false)
    @Column(name = "id_funcionalidade")
    private int idFuncionalidade;

    public TbPerfilFuncionalidadePK() {
    }

    public TbPerfilFuncionalidadePK(int idPerfil, int idFuncionalidade) {
        this.idPerfil = idPerfil;
        this.idFuncionalidade = idFuncionalidade;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public int getIdFuncionalidade() {
        return idFuncionalidade;
    }

    public void setIdFuncionalidade(int idFuncionalidade) {
        this.idFuncionalidade = idFuncionalidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPerfil;
        hash += (int) idFuncionalidade;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPerfilFuncionalidadePK)) {
            return false;
        }
        TbPerfilFuncionalidadePK other = (TbPerfilFuncionalidadePK) object;
        if (this.idPerfil != other.idPerfil) {
            return false;
        }
        if (this.idFuncionalidade != other.idFuncionalidade) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbPerfilFuncionalidadePK[ idPerfil=" + idPerfil + ", idFuncionalidade=" + idFuncionalidade + " ]";
    }
    
}
