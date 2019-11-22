/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Janio
 */
@Entity
@Table(name = "tb_tipo_questao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTipoQuestao.findAll", query = "SELECT t FROM TbTipoQuestao t"),
    @NamedQuery(name = "TbTipoQuestao.findByIdTipoQuestao", query = "SELECT t FROM TbTipoQuestao t WHERE t.idTipoQuestao = :idTipoQuestao"),
    @NamedQuery(name = "TbTipoQuestao.findByNmTipoQuestao", query = "SELECT t FROM TbTipoQuestao t WHERE t.nmTipoQuestao = :nmTipoQuestao")})
public class TbTipoQuestao implements Serializable {
    @OneToMany(mappedBy = "idTipoQuestao")
    private List<TbDisciplina> tbDisciplinaList;
    @OneToMany(mappedBy = "idTipoQuestao")
    private List<TbGeneroCategoria> tbGeneroCategoriaList;
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_tipo_questao")
    private int idTipoQuestao;
    @Basic(optional = false)
    @Column(name = "nm_tipo_questao")
    private String nmTipoQuestao;

    public TbTipoQuestao() {
    }


    public TbTipoQuestao(int idTipoQuestao, String nmTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
        this.nmTipoQuestao = nmTipoQuestao;
    }

    public int getIdTipoQuestao() {
        return idTipoQuestao;
    }

    public void setIdTipoQuestao(int idTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
    }

    public String getNmTipoQuestao() {
        return nmTipoQuestao;
    }

    public void setNmTipoQuestao(String nmTipoQuestao) {
        this.nmTipoQuestao = nmTipoQuestao;
    }

    @Override
    public String toString() {
        return "model.TbTipoQuestao[ tbTipoQuestaoPK=" + this.idTipoQuestao + " - "+this.nmTipoQuestao +" ]";
    }

    @XmlTransient
    public List<TbDisciplina> getTbDisciplinaList() {
        return tbDisciplinaList;
    }

    public void setTbDisciplinaList(List<TbDisciplina> tbDisciplinaList) {
        this.tbDisciplinaList = tbDisciplinaList;
    }

    @XmlTransient
    public List<TbGeneroCategoria> getTbGeneroCategoriaList() {
        return tbGeneroCategoriaList;
    }

    public void setTbGeneroCategoriaList(List<TbGeneroCategoria> tbGeneroCategoriaList) {
        this.tbGeneroCategoriaList = tbGeneroCategoriaList;
    }

}
