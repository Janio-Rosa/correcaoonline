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
 * @author administrator
 */
@Entity
@Table(name = "vw_colaborador_pendente_discrepancia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwColaboradorPendenteDiscrepancia.findAll", query = "SELECT v FROM VwColaboradorPendenteDiscrepancia v"),
    @NamedQuery(name = "VwColaboradorPendenteDiscrepancia.findByIdColaborador", query = "SELECT v FROM VwColaboradorPendenteDiscrepancia v WHERE v.idColaborador = :idColaborador"),
    @NamedQuery(name = "VwColaboradorPendenteDiscrepancia.findByNrCpf", query = "SELECT v FROM VwColaboradorPendenteDiscrepancia v WHERE v.nrCpf = :nrCpf"),
    @NamedQuery(name = "VwColaboradorPendenteDiscrepancia.findByIdProcesso", query = "SELECT v FROM VwColaboradorPendenteDiscrepancia v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwColaboradorPendenteDiscrepancia.findByIdBanca", query = "SELECT v FROM VwColaboradorPendenteDiscrepancia v WHERE v.idBanca = :idBanca"),
    @NamedQuery(name = "VwColaboradorPendenteDiscrepancia.findByIdFuncao", query = "SELECT v FROM VwColaboradorPendenteDiscrepancia v WHERE v.idFuncao = :idFuncao"),
    @NamedQuery(name = "VwColaboradorPendenteDiscrepancia.findByIdTipoCorrecao", query = "SELECT v FROM VwColaboradorPendenteDiscrepancia v WHERE v.idTipoCorrecao = :idTipoCorrecao"),
    @NamedQuery(name = "VwColaboradorPendenteDiscrepancia.findByFlAtivo", query = "SELECT v FROM VwColaboradorPendenteDiscrepancia v WHERE v.flAtivo = :flAtivo"),
    @NamedQuery(name = "VwColaboradorPendenteDiscrepancia.findByIdQuestao", query = "SELECT v FROM VwColaboradorPendenteDiscrepancia v WHERE v.idQuestao = :idQuestao"),
    @NamedQuery(name = "VwColaboradorPendenteDiscrepancia.findByQtCorrecao", query = "SELECT v FROM VwColaboradorPendenteDiscrepancia v WHERE v.qtCorrecao = :qtCorrecao"),
    @NamedQuery(name = "VwColaboradorPendenteDiscrepancia.findByNrLinha", query = "SELECT v FROM VwColaboradorPendenteDiscrepancia v WHERE v.nrLinha = :nrLinha")})
public class VwColaboradorPendenteDiscrepancia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_colaborador")
    @Id
    private Long idColaborador;
    @Column(name = "nr_cpf")
    private String nrCpf;
    @Column(name = "id_processo")
    private Integer idProcesso;
    @Column(name = "id_banca")
    private Integer idBanca;
    @Column(name = "id_funcao")
    private Integer idFuncao;
    @Column(name = "id_tipo_correcao")
    private Integer idTipoCorrecao;
    @Column(name = "fl_ativo")
    private Boolean flAtivo;
    @Column(name = "id_questao")
    private Integer idQuestao;
    @Column(name = "qt_correcao")
    private BigInteger qtCorrecao;
    @Column(name = "nr_linha")
    private BigInteger nrLinha;

    public VwColaboradorPendenteDiscrepancia() {
    }

    public Long getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Long idColaborador) {
        this.idColaborador = idColaborador;
    }


    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    public Integer getIdBanca() {
        return idBanca;
    }

    public void setIdBanca(Integer idBanca) {
        this.idBanca = idBanca;
    }

    public Integer getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(Integer idFuncao) {
        this.idFuncao = idFuncao;
    }

    public Integer getIdTipoCorrecao() {
        return idTipoCorrecao;
    }

    public void setIdTipoCorrecao(Integer idTipoCorrecao) {
        this.idTipoCorrecao = idTipoCorrecao;
    }

    public Boolean getFlAtivo() {
        return flAtivo;
    }

    public void setFlAtivo(Boolean flAtivo) {
        this.flAtivo = flAtivo;
    }

    public Integer getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public BigInteger getQtCorrecao() {
        return qtCorrecao;
    }

    public void setQtCorrecao(BigInteger qtCorrecao) {
        this.qtCorrecao = qtCorrecao;
    }

    public BigInteger getNrLinha() {
        return nrLinha;
    }

    public void setNrLinha(BigInteger nrLinha) {
        this.nrLinha = nrLinha;
    }
    
}
