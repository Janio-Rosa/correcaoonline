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
@Table(name = "vw_estatistica_correcao_por_corretor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwEstatisticaCorrecaoPorCorretor.findAll", query = "SELECT v FROM VwEstatisticaCorrecaoPorCorretor v"),
    @NamedQuery(name = "VwEstatisticaCorrecaoPorCorretor.findByIdProcesso", query = "SELECT v FROM VwEstatisticaCorrecaoPorCorretor v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwEstatisticaCorrecaoPorCorretor.findByNmPessoa", query = "SELECT v FROM VwEstatisticaCorrecaoPorCorretor v WHERE v.nmPessoa = :nmPessoa"),
    @NamedQuery(name = "VwEstatisticaCorrecaoPorCorretor.findByNmTipoCorrecao", query = "SELECT v FROM VwEstatisticaCorrecaoPorCorretor v WHERE v.nmTipoCorrecao = :nmTipoCorrecao"),
    @NamedQuery(name = "VwEstatisticaCorrecaoPorCorretor.findByNrQuantidade", query = "SELECT v FROM VwEstatisticaCorrecaoPorCorretor v WHERE v.nrQuantidade = :nrQuantidade"),
    @NamedQuery(name = "VwEstatisticaCorrecaoPorCorretor.findByNrLinha", query = "SELECT v FROM VwEstatisticaCorrecaoPorCorretor v WHERE v.nrLinha = :nrLinha")})
public class VwEstatisticaCorrecaoPorCorretor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_processo")
    private Integer idProcesso;
    @Column(name = "id_tipo_correcao")
    private Integer idTipoCorrecao;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Column(name = "nm_pessoa")
    private String nmPessoa;
    @Column(name = "nm_tipo_correcao")
    private String nmTipoCorrecao;
    @Column(name = "nr_quantidade")
    private BigInteger nrQuantidade;
    @Id
    @Column(name = "nr_linha")
    private BigInteger nrLinha;
    @Column(name = "nr_cpf")
    private String nrCpf;

    public VwEstatisticaCorrecaoPorCorretor() {
    }

    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    public String getNmPessoa() {
        return nmPessoa;
    }

    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
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

    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public Integer getIdTipoCorrecao() {
        return idTipoCorrecao;
    }

    public void setIdTipoCorrecao(Integer idTipoCorrecao) {
        this.idTipoCorrecao = idTipoCorrecao;
    }
    
}
