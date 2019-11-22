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
 * @author KAMYLLA
 */
//@Table(name = "vw_correcao_feita_por_curso")
@Entity
//@Table(name = "vw_correcao_feita_por_curso_mv")
@Table(name = "vw_correcao_feita_por_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwCorrecaoFeitaPorCurso.findAll", query = "SELECT v FROM VwCorrecaoFeitaPorCurso v"),
    @NamedQuery(name = "VwCorrecaoFeitaPorCurso.findByIdProcesso", query = "SELECT v FROM VwCorrecaoFeitaPorCurso v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwCorrecaoFeitaPorCurso.findByNrLinha", query = "SELECT v FROM VwCorrecaoFeitaPorCurso v WHERE v.nrLinha = :nrLinha"),
    @NamedQuery(name = "VwCorrecaoFeitaPorCurso.findByIdDisciplina", query = "SELECT v FROM VwCorrecaoFeitaPorCurso v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwCorrecaoFeitaPorCurso.findByNmCurso", query = "SELECT v FROM VwCorrecaoFeitaPorCurso v WHERE v.nmCurso = :nmCurso"),
    @NamedQuery(name = "VwCorrecaoFeitaPorCurso.findByIdCurso", query = "SELECT v FROM VwCorrecaoFeitaPorCurso v WHERE v.idCurso = :idCurso")})
public class VwCorrecaoFeitaPorCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "id_processo")
    private Integer idProcesso;
    @Column(name = "qt_resposta")
    private BigInteger qtResposta;
    @Column(name = "nr_linha")
    @Id
    private BigInteger nrLinha;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Column(name = "nm_curso")
    private String nmCurso;
    @Column(name = "nm_cidade")
    private String nmCidade;
    @Column(name = "id_curso")
    private Integer idCurso;
    @Column(name = "qt_primeira_correcao")
    private Integer qtPrimeiraCorrecao;
    @Column(name = "qt_segunda_correcao")
    private Integer qtSegundaCorrecao;
    @Column(name = "qt_terceira_correcao")
    private Integer qtTerceiraCorrecao;
    @Column(name = "qt_discrepancia")
    private Integer qtDiscrepancia;
    @Column(name = "qt_discrepancia_corrigida")
    private Integer qtDiscrepanciaCorrigida;

    public VwCorrecaoFeitaPorCurso() {
    }

    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
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

    public String getNmCurso() {
        return nmCurso;
    }

    public void setNmCurso(String nmCurso) {
        this.nmCurso = nmCurso;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public BigInteger getQtResposta() {
        return qtResposta;
    }

    public void setQtResposta(BigInteger qtResposta) {
        this.qtResposta = qtResposta;
    }

    public Integer getQtPrimeiraCorrecao() {
        return qtPrimeiraCorrecao;
    }

    public void setQtPrimeiraCorrecao(Integer qtPrimeiraCorrecao) {
        this.qtPrimeiraCorrecao = qtPrimeiraCorrecao;
    }

    public Integer getQtSegundaCorrecao() {
        return qtSegundaCorrecao;
    }

    public void setQtSegundaCorrecao(Integer qtSegundaCorrecao) {
        this.qtSegundaCorrecao = qtSegundaCorrecao;
    }

    public float getPorcentagemPrimeiraCorrecao() {
        float retorno = 0;
        if(this.getQtPrimeiraCorrecao()!=null && this.getQtResposta()!=null )
            retorno = (float) ((this.getQtPrimeiraCorrecao().floatValue() / this.getQtResposta().floatValue()) * 100);

        return retorno;
    }

    public float getPorcentagemSegundaCorrecao() {
        float retorno = 0;
        if(this.getQtSegundaCorrecao()!=null && this.getQtResposta() !=null)
            retorno = (float) ((this.getQtSegundaCorrecao().floatValue() / this.getQtResposta().floatValue()) * 100);

        return retorno;
    }

    public float getPorcentagemTerceiraCorrecao() {
        float retorno = 0;
        if(this.getQtTerceiraCorrecao()!=null && this.getQtResposta() !=null)
            retorno = (float) ((this.getQtTerceiraCorrecao().floatValue() / this.getQtResposta().floatValue()) * 100);

        return retorno;
    }

    public Integer getQtDiscrepancia() {
        return qtDiscrepancia;
    }

    public void setQtDiscrepancia(Integer qtDiscrepancia) {
        this.qtDiscrepancia = qtDiscrepancia;
    }

    public Integer getQtDiscrepanciaCorrigida() {
        return qtDiscrepanciaCorrigida;
    }

    public void setQtDiscrepanciaCorrigida(Integer qtDiscrepanciaCorrigida) {
        this.qtDiscrepanciaCorrigida = qtDiscrepanciaCorrigida;
    }

    public float getPorcentagemDiscrepancia() {
        if (this.getQtDiscrepanciaCorrigida() != null && this.getQtDiscrepancia() != null) {
            return (float) ((this.getQtDiscrepanciaCorrigida().floatValue() / this.getQtDiscrepancia().floatValue()) * 100);
        }
        return 0;
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }

    public Integer getQtTerceiraCorrecao() {
        return qtTerceiraCorrecao;
    }

    public void setQtTerceiraCorrecao(Integer qtTerceiraCorrecao) {
        this.qtTerceiraCorrecao = qtTerceiraCorrecao;
    }

    
}
