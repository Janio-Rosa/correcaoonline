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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_disciplina_discrepancia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbDisciplinaDiscrepancia.findAll", query = "SELECT t FROM TbDisciplinaDiscrepancia t"),
    @NamedQuery(name = "TbDisciplinaDiscrepancia.findByIdDisciplinaDiscrepancia", query = "SELECT t FROM TbDisciplinaDiscrepancia t WHERE t.idDisciplinaDiscrepancia = :idDisciplinaDiscrepancia"),
    @NamedQuery(name = "TbDisciplinaDiscrepancia.findByFlDiscrepanciaAtiva", query = "SELECT t FROM TbDisciplinaDiscrepancia t WHERE t.flDiscrepanciaAtiva = :flDiscrepanciaAtiva")})
@SequenceGenerator(name = "tb_disciplina_discrepancia_id_disciplina_discrepancia_seq", sequenceName = "tb_disciplina_discrepancia_id_disciplina_discrepancia_seq")
public class TbDisciplinaDiscrepancia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tb_disciplina_discrepancia_id_disciplina_discrepancia_seq")
    @Basic(optional = false)
    @Column(name = "id_disciplina_discrepancia")
    private Integer idDisciplinaDiscrepancia;
    @Basic(optional = false)
    @Column(name = "fl_discrepancia_ativa")
    private boolean flDiscrepanciaAtiva;
    @JoinColumn(name = "id_questao", referencedColumnName = "id_questao")
    @ManyToOne(optional = false)
    private TbQuestao idQuestao;
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina")
    @ManyToOne(optional = false)
    private TbDisciplina idDisciplina;

    public TbDisciplinaDiscrepancia() {
    }

    public TbDisciplinaDiscrepancia(Integer idDisciplinaDiscrepancia) {
        this.idDisciplinaDiscrepancia = idDisciplinaDiscrepancia;
    }

    public TbDisciplinaDiscrepancia(Integer idDisciplinaDiscrepancia, boolean flDiscrepanciaAtiva) {
        this.idDisciplinaDiscrepancia = idDisciplinaDiscrepancia;
        this.flDiscrepanciaAtiva = flDiscrepanciaAtiva;
    }

    public Integer getIdDisciplinaDiscrepancia() {
        return idDisciplinaDiscrepancia;
    }

    public void setIdDisciplinaDiscrepancia(Integer idDisciplinaDiscrepancia) {
        this.idDisciplinaDiscrepancia = idDisciplinaDiscrepancia;
    }

    public boolean getFlDiscrepanciaAtiva() {
        return flDiscrepanciaAtiva;
    }

    public void setFlDiscrepanciaAtiva(boolean flDiscrepanciaAtiva) {
        this.flDiscrepanciaAtiva = flDiscrepanciaAtiva;
    }

    public TbQuestao getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(TbQuestao idQuestao) {
        this.idQuestao = idQuestao;
    }

    public TbDisciplina getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(TbDisciplina idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDisciplinaDiscrepancia != null ? idDisciplinaDiscrepancia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbDisciplinaDiscrepancia)) {
            return false;
        }
        TbDisciplinaDiscrepancia other = (TbDisciplinaDiscrepancia) object;
        if ((this.idDisciplinaDiscrepancia == null && other.idDisciplinaDiscrepancia != null) || (this.idDisciplinaDiscrepancia != null && !this.idDisciplinaDiscrepancia.equals(other.idDisciplinaDiscrepancia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbDisciplinaDiscrepancia[ idDisciplinaDiscrepancia=" + idDisciplinaDiscrepancia + " ]";
    }
    
}
