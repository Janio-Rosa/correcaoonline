/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
 * @author Janio
 */
@Entity
@Table(name = "vw_reposta_correcao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwRepostaCorrecao.findAll", query = "SELECT v FROM VwRepostaCorrecao v"),
    @NamedQuery(name = "VwRepostaCorrecao.findByIdResposta", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.idResposta = :idResposta"),
    @NamedQuery(name = "VwRepostaCorrecao.findByIdDisciplina", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwRepostaCorrecao.findByCdSerial", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.cdSerial = :cdSerial"),
    @NamedQuery(name = "VwRepostaCorrecao.findByNrQuestao", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.nrQuestao = :nrQuestao"),
    @NamedQuery(name = "VwRepostaCorrecao.findByNrNotaFinal", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.nrNotaFinal = :nrNotaFinal"),
    @NamedQuery(name = "VwRepostaCorrecao.findByFlDiscrepancia", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.flDiscrepancia = :flDiscrepancia"),
    @NamedQuery(name = "VwRepostaCorrecao.findByFlDiscrepanciaCorrigida", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.flDiscrepanciaCorrigida = :flDiscrepanciaCorrigida"),
    @NamedQuery(name = "VwRepostaCorrecao.findByFlCorrigida", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.flCorrigida = :flCorrigida"),
    @NamedQuery(name = "VwRepostaCorrecao.findByIdColaboradorAtual", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.idColaboradorAtual = :idColaboradorAtual"),
    @NamedQuery(name = "VwRepostaCorrecao.findByFlCorrigindo", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.flCorrigindo = :flCorrigindo"),
    @NamedQuery(name = "VwRepostaCorrecao.findByIdCurso", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.idCurso = :idCurso"),
    @NamedQuery(name = "VwRepostaCorrecao.findByIdInscricao", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.idInscricao = :idInscricao"),
    @NamedQuery(name = "VwRepostaCorrecao.findByDtInsercaoResposta", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.dtInsercaoResposta = :dtInsercaoResposta"),
    @NamedQuery(name = "VwRepostaCorrecao.findByFlRespostaComErro", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.flRespostaComErro = :flRespostaComErro"),
    @NamedQuery(name = "VwRepostaCorrecao.findByFlPrimeiraCorrecao", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.flPrimeiraCorrecao = :flPrimeiraCorrecao"),
    @NamedQuery(name = "VwRepostaCorrecao.findByFlSegundaCorrecao", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.flSegundaCorrecao = :flSegundaCorrecao"),
    @NamedQuery(name = "VwRepostaCorrecao.findByIdCorrecao", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.idCorrecao = :idCorrecao"),
    @NamedQuery(name = "VwRepostaCorrecao.findByNrNota", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.nrNota = :nrNota"),
    @NamedQuery(name = "VwRepostaCorrecao.findByDtAtualizacao", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.dtAtualizacao = :dtAtualizacao"),
    @NamedQuery(name = "VwRepostaCorrecao.findByFlSucesso", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.flSucesso = :flSucesso"),
    @NamedQuery(name = "VwRepostaCorrecao.findByDtInsercaoCorrecao", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.dtInsercaoCorrecao = :dtInsercaoCorrecao"),
    @NamedQuery(name = "VwRepostaCorrecao.findByIdTipoCorrecao", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.idTipoCorrecao = :idTipoCorrecao"),
    @NamedQuery(name = "VwRepostaCorrecao.findByNmTipoCorrecao", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.nmTipoCorrecao = :nmTipoCorrecao"),
    @NamedQuery(name = "VwRepostaCorrecao.findByFlContabilizaNota", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.flContabilizaNota = :flContabilizaNota"),
    @NamedQuery(name = "VwRepostaCorrecao.findByFlSobreposicaoNota", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.flSobreposicaoNota = :flSobreposicaoNota"),
    @NamedQuery(name = "VwRepostaCorrecao.findByNrPrioridade", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.nrPrioridade = :nrPrioridade"),
    @NamedQuery(name = "VwRepostaCorrecao.findByIdColaborador", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.idColaborador = :idColaborador"),
    @NamedQuery(name = "VwRepostaCorrecao.findByIdProcesso", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwRepostaCorrecao.findByIdBanca", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.idBanca = :idBanca"),
    @NamedQuery(name = "VwRepostaCorrecao.findByIdFuncao", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.idFuncao = :idFuncao"),
    @NamedQuery(name = "VwRepostaCorrecao.findByNrCpf", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.nrCpf = :nrCpf"),
    @NamedQuery(name = "VwRepostaCorrecao.findByIdEmpresa", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "VwRepostaCorrecao.findByNmPessoa", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.nmPessoa = :nmPessoa"),
    @NamedQuery(name = "VwRepostaCorrecao.findByNrRg", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.nrRg = :nrRg"),
    @NamedQuery(name = "VwRepostaCorrecao.findByNmRgOrgao", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.nmRgOrgao = :nmRgOrgao"),
    @NamedQuery(name = "VwRepostaCorrecao.findByNmRgUf", query = "SELECT v FROM VwRepostaCorrecao v WHERE v.nmRgUf = :nmRgUf")})
public class VwRepostaCorrecao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_resposta")
    private Long idResposta;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Column(name = "cd_serial")
    private String cdSerial;
    @Column(name = "nr_questao")
    private Integer nrQuestao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nr_nota_final")
    private Double nrNotaFinal;
    @Column(name = "fl_discrepancia")
    private Boolean flDiscrepancia;
    @Column(name = "fl_discrepancia_corrigida")
    private Boolean flDiscrepanciaCorrigida;
    @Column(name = "fl_corrigida")
    private Boolean flCorrigida;
    @Column(name = "id_colaborador_atual")
    private Long idColaboradorAtual;
    @Column(name = "fl_corrigindo")
    private Boolean flCorrigindo;
    @Column(name = "id_curso")
    private Integer idCurso;
    @Column(name = "id_inscricao")
    private Long idInscricao;
    @Column(name = "dt_insercao_resposta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInsercaoResposta;
    @Column(name = "fl_resposta_com_erro")
    private Boolean flRespostaComErro;
    @Column(name = "fl_primeira_correcao")
    private Boolean flPrimeiraCorrecao;
    @Column(name = "fl_segunda_correcao")
    private Boolean flSegundaCorrecao;
    @Column(name = "id_correcao")
    @Id
    private Long idCorrecao;
    @Column(name = "nr_nota")
    private Double nrNota;
    @Column(name = "dt_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAtualizacao;
    @Column(name = "fl_sucesso")
    private Boolean flSucesso;
    @Column(name = "dt_insercao_correcao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInsercaoCorrecao;
    @Column(name = "id_tipo_correcao")
    private Integer idTipoCorrecao;
    @Column(name = "nm_tipo_correcao")
    private String nmTipoCorrecao;
    @Column(name = "fl_contabiliza_nota")
    private Boolean flContabilizaNota;
    @Column(name = "fl_sobreposicao_nota")
    private Boolean flSobreposicaoNota;
    @Column(name = "nr_prioridade")
    private Integer nrPrioridade;
    @Column(name = "id_colaborador")
    private Long idColaborador;
    @Column(name = "id_processo")
    private Integer idProcesso;
    @Column(name = "id_banca")
    private Integer idBanca;
    @Column(name = "id_funcao")
    private Integer idFuncao;
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

    public VwRepostaCorrecao() {
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getCdSerial() {
        return cdSerial;
    }

    public void setCdSerial(String cdSerial) {
        this.cdSerial = cdSerial;
    }

    public Integer getNrQuestao() {
        return nrQuestao;
    }

    public void setNrQuestao(Integer nrQuestao) {
        this.nrQuestao = nrQuestao;
    }

    public Double getNrNotaFinal() {
        return nrNotaFinal;
    }

    public void setNrNotaFinal(Double nrNotaFinal) {
        this.nrNotaFinal = nrNotaFinal;
    }

    public Boolean getFlDiscrepancia() {
        return flDiscrepancia;
    }

    public void setFlDiscrepancia(Boolean flDiscrepancia) {
        this.flDiscrepancia = flDiscrepancia;
    }

    public Boolean getFlDiscrepanciaCorrigida() {
        return flDiscrepanciaCorrigida;
    }

    public void setFlDiscrepanciaCorrigida(Boolean flDiscrepanciaCorrigida) {
        this.flDiscrepanciaCorrigida = flDiscrepanciaCorrigida;
    }

    public Boolean getFlCorrigida() {
        return flCorrigida;
    }

    public void setFlCorrigida(Boolean flCorrigida) {
        this.flCorrigida = flCorrigida;
    }


    public Boolean getFlCorrigindo() {
        return flCorrigindo;
    }

    public void setFlCorrigindo(Boolean flCorrigindo) {
        this.flCorrigindo = flCorrigindo;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }


    public Date getDtInsercaoResposta() {
        return dtInsercaoResposta;
    }

    public void setDtInsercaoResposta(Date dtInsercaoResposta) {
        this.dtInsercaoResposta = dtInsercaoResposta;
    }

    public Boolean getFlRespostaComErro() {
        return flRespostaComErro;
    }

    public void setFlRespostaComErro(Boolean flRespostaComErro) {
        this.flRespostaComErro = flRespostaComErro;
    }

    public Boolean getFlPrimeiraCorrecao() {
        return flPrimeiraCorrecao;
    }

    public void setFlPrimeiraCorrecao(Boolean flPrimeiraCorrecao) {
        this.flPrimeiraCorrecao = flPrimeiraCorrecao;
    }

    public Boolean getFlSegundaCorrecao() {
        return flSegundaCorrecao;
    }

    public void setFlSegundaCorrecao(Boolean flSegundaCorrecao) {
        this.flSegundaCorrecao = flSegundaCorrecao;
    }


    public Double getNrNota() {
        return nrNota;
    }

    public void setNrNota(Double nrNota) {
        this.nrNota = nrNota;
    }

    public Date getDtAtualizacao() {
        return dtAtualizacao;
    }

    public void setDtAtualizacao(Date dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }

    public Boolean getFlSucesso() {
        return flSucesso;
    }

    public void setFlSucesso(Boolean flSucesso) {
        this.flSucesso = flSucesso;
    }

    public Date getDtInsercaoCorrecao() {
        return dtInsercaoCorrecao;
    }

    public void setDtInsercaoCorrecao(Date dtInsercaoCorrecao) {
        this.dtInsercaoCorrecao = dtInsercaoCorrecao;
    }

    public Integer getIdTipoCorrecao() {
        return idTipoCorrecao;
    }

    public void setIdTipoCorrecao(Integer idTipoCorrecao) {
        this.idTipoCorrecao = idTipoCorrecao;
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

    public Long getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Long idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Long getIdColaboradorAtual() {
        return idColaboradorAtual;
    }

    public void setIdColaboradorAtual(Long idColaboradorAtual) {
        this.idColaboradorAtual = idColaboradorAtual;
    }

    public Long getIdInscricao() {
        return idInscricao;
    }

    public void setIdInscricao(Long idInscricao) {
        this.idInscricao = idInscricao;
    }

    public Long getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Long idResposta) {
        this.idResposta = idResposta;
    }

    public Long getIdCorrecao() {
        return idCorrecao;
    }

    public void setIdCorrecao(Long idCorrecao) {
        this.idCorrecao = idCorrecao;
    }

    
}
