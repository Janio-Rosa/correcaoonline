/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KAMYLLA
 */
@Entity
@Table(name = "vw_pessoa_colaborador")
//@Table(name = "vw_pessoa_colaborador_mv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwPessoaColaborador.findAll", query = "SELECT v FROM VwPessoaColaborador v"),
    @NamedQuery(name = "VwPessoaColaborador.findByIdColaborador", query = "SELECT v FROM VwPessoaColaborador v WHERE v.idColaborador = :idColaborador"),
    @NamedQuery(name = "VwPessoaColaborador.findByIdProcesso", query = "SELECT v FROM VwPessoaColaborador v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwPessoaColaborador.findByIdBanca", query = "SELECT v FROM VwPessoaColaborador v WHERE v.idBanca = :idBanca"),
    @NamedQuery(name = "VwPessoaColaborador.findByIdFuncao", query = "SELECT v FROM VwPessoaColaborador v WHERE v.idFuncao = :idFuncao"),
    @NamedQuery(name = "VwPessoaColaborador.findByIdTipoCorrecao", query = "SELECT v FROM VwPessoaColaborador v WHERE v.idTipoCorrecao = :idTipoCorrecao"),
    @NamedQuery(name = "VwPessoaColaborador.findByNrCpf", query = "SELECT v FROM VwPessoaColaborador v WHERE v.nrCpf = :nrCpf"),
    @NamedQuery(name = "VwPessoaColaborador.findByIdEmpresa", query = "SELECT v FROM VwPessoaColaborador v WHERE v.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "VwPessoaColaborador.findByNmPessoa", query = "SELECT v FROM VwPessoaColaborador v WHERE v.nmPessoa = :nmPessoa"),
    @NamedQuery(name = "VwPessoaColaborador.findByNrRg", query = "SELECT v FROM VwPessoaColaborador v WHERE v.nrRg = :nrRg"),
    @NamedQuery(name = "VwPessoaColaborador.findByNmRgOrgao", query = "SELECT v FROM VwPessoaColaborador v WHERE v.nmRgOrgao = :nmRgOrgao"),
    @NamedQuery(name = "VwPessoaColaborador.findByNmRgUf", query = "SELECT v FROM VwPessoaColaborador v WHERE v.nmRgUf = :nmRgUf"),
    @NamedQuery(name = "VwPessoaColaborador.findByNmProcesso", query = "SELECT v FROM VwPessoaColaborador v WHERE v.nmProcesso = :nmProcesso"),
    @NamedQuery(name = "VwPessoaColaborador.findByDtValidadeFinal", query = "SELECT v FROM VwPessoaColaborador v WHERE v.dtValidadeFinal = :dtValidadeFinal"),
    @NamedQuery(name = "VwPessoaColaborador.findByDtValidadeInicial", query = "SELECT v FROM VwPessoaColaborador v WHERE v.dtValidadeInicial = :dtValidadeInicial"),
    @NamedQuery(name = "VwPessoaColaborador.findByNmBanca", query = "SELECT v FROM VwPessoaColaborador v WHERE v.nmBanca = :nmBanca"),
    @NamedQuery(name = "VwPessoaColaborador.findByIdDisciplina", query = "SELECT v FROM VwPessoaColaborador v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwPessoaColaborador.findByFlDiscrepancia", query = "SELECT v FROM VwPessoaColaborador v WHERE v.flDiscrepancia = :flDiscrepancia"),
    @NamedQuery(name = "VwPessoaColaborador.findByFlRedacao", query = "SELECT v FROM VwPessoaColaborador v WHERE v.flRedacao = :flRedacao"),
    @NamedQuery(name = "VwPessoaColaborador.findByIdCurso", query = "SELECT v FROM VwPessoaColaborador v WHERE v.idCurso = :idCurso"),
    @NamedQuery(name = "VwPessoaColaborador.findByNmFuncao", query = "SELECT v FROM VwPessoaColaborador v WHERE v.nmFuncao = :nmFuncao"),
    @NamedQuery(name = "VwPessoaColaborador.findByNmTipoCorrecao", query = "SELECT v FROM VwPessoaColaborador v WHERE v.nmTipoCorrecao = :nmTipoCorrecao"),
    @NamedQuery(name = "VwPessoaColaborador.findByFlContabilizaNota", query = "SELECT v FROM VwPessoaColaborador v WHERE v.flContabilizaNota = :flContabilizaNota"),
    @NamedQuery(name = "VwPessoaColaborador.findByFlSobreposicaoNota", query = "SELECT v FROM VwPessoaColaborador v WHERE v.flSobreposicaoNota = :flSobreposicaoNota"),
    @NamedQuery(name = "VwPessoaColaborador.findByNrPrioridade", query = "SELECT v FROM VwPessoaColaborador v WHERE v.nrPrioridade = :nrPrioridade")})
public class VwPessoaColaborador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_colaborador")
    private BigInteger idColaborador;
    @Column(name = "id_processo")
    private Integer idProcesso;
    @Column(name = "id_banca")
    private Integer idBanca;
    @Column(name = "id_funcao")
    private Integer idFuncao;
    @Column(name = "id_tipo_correcao")
    private Integer idTipoCorrecao;
    @Column(name = "id_questao")
    private Integer idQuestao;
    @Column(name = "nr_cpf")
    private String nrCpf;
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    @Column(name = "nm_pessoa")
    private String nmPessoa;
    @Column(name = "nr_rg")
    private String nrRg;
    @Column(name = "nm_rg_orgao")
    private String nmRgOrgao;
    @Column(name = "nm_rg_uf")
    private String nmRgUf;
    @Column(name = "nm_processo")
    private String nmProcesso;
    @Column(name = "dt_validade_final")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtValidadeFinal;
    @Column(name = "dt_validade_inicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtValidadeInicial;
    @Column(name = "nm_banca")
    private String nmBanca;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Column(name = "fl_discrepancia")
    private Boolean flDiscrepancia;
    @Column(name = "fl_redacao")
    private Boolean flRedacao;
    @Column(name = "id_curso")
    private Integer idCurso;
    @Column(name = "nm_funcao")
    private String nmFuncao;
    @Column(name = "nm_tipo_correcao")
    private String nmTipoCorrecao;
    @Column(name = "nm_questao")
    private String nmQuestao;
    @Column(name = "fl_contabiliza_nota")
    private Boolean flContabilizaNota;
    @Column(name = "fl_sobreposicao_nota")
    private Boolean flSobreposicaoNota;
    @Column(name = "nr_prioridade")
    private Integer nrPrioridade;
    @Column(name = "fl_ativo")
    private Boolean flAtivo;
    @Column(name = "qt_resposta")
    private Integer qtResposta;
    @Column(name = "qt_correcoes")
    private Integer qtCorrecoes;
    @Column(name = "nr_linha")
    @Id
    private Integer nrLinha;

    public VwPessoaColaborador() {
    }

    public BigInteger getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(BigInteger idColaborador) {
        this.idColaborador = idColaborador;
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

    public Integer getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public String getNmQuestao() {
        return nmQuestao;
    }

    public void setNmQuestao(String nmQuestao) {
        this.nmQuestao = nmQuestao;
    }
    
    
    
    

    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNmPessoa() {
        return nmPessoa;
    }

    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }

    public String getNrRg() {
        return nrRg;
    }

    public void setNrRg(String nrRg) {
        this.nrRg = nrRg;
    }

    public String getNmRgOrgao() {
        return nmRgOrgao;
    }

    public void setNmRgOrgao(String nmRgOrgao) {
        this.nmRgOrgao = nmRgOrgao;
    }

    public String getNmRgUf() {
        return nmRgUf;
    }

    public void setNmRgUf(String nmRgUf) {
        this.nmRgUf = nmRgUf;
    }

    public String getNmProcesso() {
        return nmProcesso;
    }

    public void setNmProcesso(String nmProcesso) {
        this.nmProcesso = nmProcesso;
    }

    public Date getDtValidadeFinal() {
        return dtValidadeFinal;
    }

    public void setDtValidadeFinal(Date dtValidadeFinal) {
        this.dtValidadeFinal = dtValidadeFinal;
    }

    public Date getDtValidadeInicial() {
        return dtValidadeInicial;
    }

    public void setDtValidadeInicial(Date dtValidadeInicial) {
        this.dtValidadeInicial = dtValidadeInicial;
    }

    public String getNmBanca() {
        return nmBanca;
    }

    public void setNmBanca(String nmBanca) {
        this.nmBanca = nmBanca;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Boolean getFlDiscrepancia() {
        return flDiscrepancia;
    }

    public void setFlDiscrepancia(Boolean flDiscrepancia) {
        this.flDiscrepancia = flDiscrepancia;
    }

    public Boolean getFlRedacao() {
        return flRedacao;
    }

    public void setFlRedacao(Boolean flRedacao) {
        this.flRedacao = flRedacao;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNmFuncao() {
        return nmFuncao;
    }

    public void setNmFuncao(String nmFuncao) {
        this.nmFuncao = nmFuncao;
    }

    public String getNmTipoCorrecao() {
        return nmTipoCorrecao;
    }

    public void setNmTipoCorrecao(String nmTipoCorrecao) {
        this.nmTipoCorrecao = nmTipoCorrecao;
    }

    public Boolean getFlContabilizaNota() {
        return flContabilizaNota;
    }

    public void setFlContabilizaNota(Boolean flContabilizaNota) {
        this.flContabilizaNota = flContabilizaNota;
    }

    public Boolean getFlSobreposicaoNota() {
        return flSobreposicaoNota;
    }

    public void setFlSobreposicaoNota(Boolean flSobreposicaoNota) {
        this.flSobreposicaoNota = flSobreposicaoNota;
    }

    public Integer getNrPrioridade() {
        return nrPrioridade;
    }

    public void setNrPrioridade(Integer nrPrioridade) {
        this.nrPrioridade = nrPrioridade;
    }

    public Boolean getFlAtivo() {
        return flAtivo;
    }

    public void setFlAtivo(Boolean flAtivo) {
        this.flAtivo = flAtivo;
    }

    public Integer getQtCorrecoes() {
        return qtCorrecoes;
    }

    public void setQtCorrecoes(Integer qtCorrecoes) {
        this.qtCorrecoes = qtCorrecoes;
    }

    public Integer getQtResposta() {
        return qtResposta;
    }

    public void setQtResposta(Integer qtResposta) {
        this.qtResposta = qtResposta;
    }

    public Integer getNrLinha() {
        return nrLinha;
    }

    public void setNrLinha(Integer nrLinha) {
        this.nrLinha = nrLinha;
    }

    
}
