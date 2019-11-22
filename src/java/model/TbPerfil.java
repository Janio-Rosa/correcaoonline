/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Janio
 */
@Entity
@Table(name = "tb_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPerfil.findAll", query = "SELECT t FROM TbPerfil t"),
    @NamedQuery(name = "TbPerfil.findByIdPerfil", query = "SELECT t FROM TbPerfil t WHERE t.idPerfil = :idPerfil"),
    @NamedQuery(name = "TbPerfil.findByNmPerfil", query = "SELECT t FROM TbPerfil t WHERE t.nmPerfil = :nmPerfil")})
    @SequenceGenerator(name = "tb_perfil_id_perfil_seq", sequenceName = "tb_perfil_id_perfil_seq")
public class TbPerfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tb_perfil_id_perfil_seq")
    @Basic(optional = false)
    @Column(name = "id_perfil")
    private Integer idPerfil;
    @Column(name = "nm_perfil")
    private String nmPerfil;

    @Column(name = "id_perfil_pai")
    private Integer idPerfilPai;

    public TbPerfil() {

    }

    public TbPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNmPerfil() {
        return nmPerfil;
    }

    public void setNmPerfil(String nmPerfil) {
        this.nmPerfil = nmPerfil;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPerfil)) {
            return false;
        }
        TbPerfil other = (TbPerfil) object;
        if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbPerfil[ idPerfil=" + idPerfil + " ]";
    }

    public Integer getIdPerfilPai() {
        return idPerfilPai;
    }

    public void setIdPerfilPai(Integer idPerfilPai) {
        this.idPerfilPai = idPerfilPai;
    }

    
}
