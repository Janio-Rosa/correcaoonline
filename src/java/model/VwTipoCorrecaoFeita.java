/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Janio
 */
@Entity
@Table(name = "vw_tipo_correcao_feita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwTipoCorrecaoFeita.findAll", query = "SELECT v FROM VwTipoCorrecaoFeita v"),
    @NamedQuery(name = "VwTipoCorrecaoFeita.findByIdProcesso", query = "SELECT v FROM VwTipoCorrecaoFeita v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwTipoCorrecaoFeita.findByNmTipoCorrecao", query = "SELECT v FROM VwTipoCorrecaoFeita v WHERE v.nmTipoCorrecao = :nmTipoCorrecao"),
    @NamedQuery(name = "VwTipoCorrecaoFeita.findByNrQuantidade", query = "SELECT v FROM VwTipoCorrecaoFeita v WHERE v.nrQuantidade = :nrQuantidade"),
    @NamedQuery(name = "VwTipoCorrecaoFeita.findByNrLinha", query = "SELECT v FROM VwTipoCorrecaoFeita v WHERE v.nrLinha = :nrLinha")})
public class VwTipoCorrecaoFeita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_processo")
    private Integer idProcesso;
    @Column(name = "nm_tipo_correcao")
    private String nmTipoCorrecao;
    @Column(name = "nr_quantidade")
    private BigInteger nrQuantidade;
    @Id
    @Column(name = "nr_linha")
    private BigInteger nrLinha;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;

    public VwTipoCorrecaoFeita() {
    }

    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    public String getNmTipoCorrecao() {
        return nmTipoCorrecao;
    }

    public void setNmTipoCorrecao(String nmTipoCorrecao) {
        this.nmTipoCorrecao = nmTipoCorrecao;
    }

    public BigInteger getNrQuantidade() {
        return nrQuantidade;
    }

    public void setNrQuantidade(BigInteger nrQuantidade) {
        this.nrQuantidade = nrQuantidade;
    }

    public BigInteger getNrLinha() {
        return nrLinha;
    }

    public void setNrLinha(BigInteger nrLinha) {
        this.nrLinha = nrLinha;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }
    
}
