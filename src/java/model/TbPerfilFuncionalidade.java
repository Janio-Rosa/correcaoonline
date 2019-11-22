/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Janio
 */
@Entity
@Table(name = "tb_perfil_funcionalidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPerfilFuncionalidade.findAll", query = "SELECT t FROM TbPerfilFuncionalidade t"),
    @NamedQuery(name = "TbPerfilFuncionalidade.findByIdPerfil", query = "SELECT t FROM TbPerfilFuncionalidade t WHERE t.tbPerfilFuncionalidadePK.idPerfil = :idPerfil"),
    @NamedQuery(name = "TbPerfilFuncionalidade.findByIdFuncionalidade", query = "SELECT t FROM TbPerfilFuncionalidade t WHERE t.tbPerfilFuncionalidadePK.idFuncionalidade = :idFuncionalidade"),
    @NamedQuery(name = "TbPerfilFuncionalidade.findByNrOrdem", query = "SELECT t FROM TbPerfilFuncionalidade t WHERE t.nrOrdem = :nrOrdem")})
public class TbPerfilFuncionalidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbPerfilFuncionalidadePK tbPerfilFuncionalidadePK;
    @Column(name = "nr_ordem")
    private Integer nrOrdem;
    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbPerfil tbPerfil;
    @JoinColumn(name = "id_funcionalidade", referencedColumnName = "id_funcionalidade", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbFuncionalidade tbFuncionalidade;

    public TbPerfilFuncionalidade() {
    }

    public TbPerfilFuncionalidade(TbPerfilFuncionalidadePK tbPerfilFuncionalidadePK) {
        this.tbPerfilFuncionalidadePK = tbPerfilFuncionalidadePK;
    }

    public TbPerfilFuncionalidade(int idPerfil, int idFuncionalidade) {
        this.tbPerfilFuncionalidadePK = new TbPerfilFuncionalidadePK(idPerfil, idFuncionalidade);
    }

    public TbPerfilFuncionalidadePK getTbPerfilFuncionalidadePK() {
        return tbPerfilFuncionalidadePK;
    }

    public void setTbPerfilFuncionalidadePK(TbPerfilFuncionalidadePK tbPerfilFuncionalidadePK) {
        this.tbPerfilFuncionalidadePK = tbPerfilFuncionalidadePK;
    }

    public Integer getNrOrdem() {
        return nrOrdem;
    }

    public void setNrOrdem(Integer nrOrdem) {
        this.nrOrdem = nrOrdem;
    }

    public TbPerfil getTbPerfil() {
        return tbPerfil;
    }

    public void setTbPerfil(TbPerfil tbPerfil) {
        this.tbPerfil = tbPerfil;
    }

    public TbFuncionalidade getTbFuncionalidade() {
        return tbFuncionalidade;
    }

    public void setTbFuncionalidade(TbFuncionalidade tbFuncionalidade) {
        this.tbFuncionalidade = tbFuncionalidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbPerfilFuncionalidadePK != null ? tbPerfilFuncionalidadePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPerfilFuncionalidade)) {
            return false;
        }
        TbPerfilFuncionalidade other = (TbPerfilFuncionalidade) object;
        if ((this.tbPerfilFuncionalidadePK == null && other.tbPerfilFuncionalidadePK != null) || (this.tbPerfilFuncionalidadePK != null && !this.tbPerfilFuncionalidadePK.equals(other.tbPerfilFuncionalidadePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbPerfilFuncionalidade[ tbPerfilFuncionalidadePK=" + tbPerfilFuncionalidadePK + " ]";
    }
    
}
