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
@Table(name = "vw_colaborador_correcao_atual")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwColaboradorCorrecaoAtual.findAll", query = "SELECT v FROM VwColaboradorCorrecaoAtual v"),
    @NamedQuery(name = "VwColaboradorCorrecaoAtual.findByIdColaborador", query = "SELECT v FROM VwColaboradorCorrecaoAtual v WHERE v.idColaborador = :idColaborador"),
    @NamedQuery(name = "VwColaboradorCorrecaoAtual.findByNrCpf", query = "SELECT v FROM VwColaboradorCorrecaoAtual v WHERE v.nrCpf = :nrCpf"),
    @NamedQuery(name = "VwColaboradorCorrecaoAtual.findByIdProcesso", query = "SELECT v FROM VwColaboradorCorrecaoAtual v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwColaboradorCorrecaoAtual.findByIdBanca", query = "SELECT v FROM VwColaboradorCorrecaoAtual v WHERE v.idBanca = :idBanca"),
    @NamedQuery(name = "VwColaboradorCorrecaoAtual.findByIdFuncao", query = "SELECT v FROM VwColaboradorCorrecaoAtual v WHERE v.idFuncao = :idFuncao"),
    @NamedQuery(name = "VwColaboradorCorrecaoAtual.findByIdTipoCorrecao", query = "SELECT v FROM VwColaboradorCorrecaoAtual v WHERE v.idTipoCorrecao = :idTipoCorrecao"),
    @NamedQuery(name = "VwColaboradorCorrecaoAtual.findByFlAtivo", query = "SELECT v FROM VwColaboradorCorrecaoAtual v WHERE v.flAtivo = :flAtivo"),
    @NamedQuery(name = "VwColaboradorCorrecaoAtual.findByIdQuestao", query = "SELECT v FROM VwColaboradorCorrecaoAtual v WHERE v.idQuestao = :idQuestao"),
    @NamedQuery(name = "VwColaboradorCorrecaoAtual.findByNrLinha", query = "SELECT v FROM VwColaboradorCorrecaoAtual v WHERE v.nrLinha = :nrLinha")})
public class VwColaboradorCorrecaoAtual implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_colaborador")
    private BigInteger idColaborador;
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
    @Id
    @Column(name = "nr_linha")
    private BigInteger nrLinha;

    public VwColaboradorCorrecaoAtual() {
    }

    public BigInteger getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(BigInteger idColaborador) {
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

    public BigInteger getNrLinha() {
        return nrLinha;
    }

    public void setNrLinha(BigInteger nrLinha) {
        this.nrLinha = nrLinha;
    }
    
}
