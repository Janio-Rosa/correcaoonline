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
@Table(name = "vw_estatistica_criterio_correcao_feita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwEstatisticaCriterioCorrecaoFeita.findAll", query = "SELECT v FROM VwEstatisticaCriterioCorrecaoFeita v"),
    @NamedQuery(name = "VwEstatisticaCriterioCorrecaoFeita.findByIdProcesso", query = "SELECT v FROM VwEstatisticaCriterioCorrecaoFeita v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwEstatisticaCriterioCorrecaoFeita.findByNmCriterio", query = "SELECT v FROM VwEstatisticaCriterioCorrecaoFeita v WHERE v.nmCriterio = :nmCriterio"),
    @NamedQuery(name = "VwEstatisticaCriterioCorrecaoFeita.findByNmCategoriaCriterio", query = "SELECT v FROM VwEstatisticaCriterioCorrecaoFeita v WHERE v.nmCategoriaCriterio = :nmCategoriaCriterio"),
    @NamedQuery(name = "VwEstatisticaCriterioCorrecaoFeita.findByNrQuantidade", query = "SELECT v FROM VwEstatisticaCriterioCorrecaoFeita v WHERE v.nrQuantidade = :nrQuantidade"),
    @NamedQuery(name = "VwEstatisticaCriterioCorrecaoFeita.findByNrLinha", query = "SELECT v FROM VwEstatisticaCriterioCorrecaoFeita v WHERE v.nrLinha = :nrLinha")})
public class VwEstatisticaCriterioCorrecaoFeita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_processo")
    private Integer idProcesso;
    @Column(name = "nm_criterio")
    private String nmCriterio;
    @Column(name = "nm_categoria_criterio")
    private String nmCategoriaCriterio;
    @Column(name = "nr_quantidade")
    private BigInteger nrQuantidade;
    @Id
    @Column(name = "nr_linha")
    private BigInteger nrLinha;

    public VwEstatisticaCriterioCorrecaoFeita() {
    }

    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    public String getNmCriterio() {
        return nmCriterio;
    }

    public void setNmCriterio(String nmCriterio) {
        this.nmCriterio = nmCriterio;
    }

    public String getNmCategoriaCriterio() {
        return nmCategoriaCriterio;
    }

    public void setNmCategoriaCriterio(String nmCategoriaCriterio) {
        this.nmCategoriaCriterio = nmCategoriaCriterio;
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
    
}
