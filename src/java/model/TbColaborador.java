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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Janio
 */
@Entity
@Table(name = "tb_colaborador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbColaborador.findAll", query = "SELECT t FROM TbColaborador t"),
    @NamedQuery(name = "TbColaborador.findByIdColaborador", query = "SELECT t FROM TbColaborador t WHERE t.idColaborador = :idColaborador")})
    @SequenceGenerator(name = "tb_colaborador_id_colaborador_seq", sequenceName = "tb_colaborador_id_colaborador_seq")
public class TbColaborador implements Serializable {
    @OneToMany(mappedBy = "idColaboradorAtual")
    private List<TbResposta> tbRespostaList;
    private static final long serialVersionUID = 1L;
    @Id
     @GeneratedValue(strategy = GenerationType.AUTO, generator="tb_colaborador_id_colaborador_seq")
    @Basic(optional = false)
    @Column(name = "id_colaborador")
    private Long idColaborador;
    @JoinColumn(name = "id_tipo_correcao", referencedColumnName = "id_tipo_correcao")
    @ManyToOne(optional = false)
    private TbTipoCorrecao idTipoCorrecao;
    @JoinColumn(name = "id_questao", referencedColumnName = "id_questao")
    @ManyToOne(optional = false)
    private TbQuestao idQuestao;
    @JoinColumn(name = "id_processo", referencedColumnName = "id_processo")
    @ManyToOne(optional = false)
    private TbProcesso idProcesso;
    @JoinColumn(name = "nr_cpf", referencedColumnName = "nr_cpf")
    @ManyToOne(optional = false)
    private TbPessoa nrCpf;
    @JoinColumn(name = "id_funcao", referencedColumnName = "id_funcao")
    @ManyToOne(optional = false)
    private TbFuncao idFuncao;
    @JoinColumn(name = "id_banca", referencedColumnName = "id_banca")
    @ManyToOne(optional = false)
    private TbBanca idBanca;
    
    @Column(name = "fl_ativo")
    private Boolean flAtivo;

    public TbColaborador() {
    }

    public TbColaborador(Long idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Long getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Long idColaborador) {
        this.idColaborador = idColaborador;
    }

    public TbTipoCorrecao getIdTipoCorrecao() {
        return idTipoCorrecao;
    }

    public void setIdTipoCorrecao(TbTipoCorrecao idTipoCorrecao) {
        this.idTipoCorrecao = idTipoCorrecao;
    }

    public TbQuestao getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(TbQuestao idQuestao) {
        this.idQuestao = idQuestao;
    }

       
    public TbProcesso getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(TbProcesso idProcesso) {
        this.idProcesso = idProcesso;
    }

    public TbPessoa getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(TbPessoa nrCpf) {
        this.nrCpf = nrCpf;
    }

    public TbFuncao getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(TbFuncao idFuncao) {
        this.idFuncao = idFuncao;
    }

    public TbBanca getIdBanca() {
        return idBanca;
    }

    public void setIdBanca(TbBanca idBanca) {
        this.idBanca = idBanca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColaborador != null ? idColaborador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbColaborador)) {
            return false;
        }
        TbColaborador other = (TbColaborador) object;
        if ((this.idColaborador == null && other.idColaborador != null) || (this.idColaborador != null && !this.idColaborador.equals(other.idColaborador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbColaborador[ idColaborador=" + idColaborador + " ]";
    }

    @XmlTransient
    public List<TbResposta> getTbRespostaList() {
        return tbRespostaList;
    }

    public void setTbRespostaList(List<TbResposta> tbRespostaList) {
        this.tbRespostaList = tbRespostaList;
    }

    public Boolean getFlAtivo() {
        return flAtivo;
    }

    public void setFlAtivo(Boolean flAtivo) {
        this.flAtivo = flAtivo;
    }
    
}
