/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
//import java.math.BigInteger;
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
@Table(name = "vw_resposta_correcao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwRespostaCorrecao.findAll", query = "SELECT v FROM VwRespostaCorrecao v"),
    @NamedQuery(name = "VwRespostaCorrecao.findByIdResposta", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.idResposta = :idResposta"),
    @NamedQuery(name = "VwRespostaCorrecao.findByIdDisciplina", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwRespostaCorrecao.findByCdSerial", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.cdSerial = :cdSerial"),
    @NamedQuery(name = "VwRespostaCorrecao.findByNrQuestao", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.nrQuestao = :nrQuestao"),
    @NamedQuery(name = "VwRespostaCorrecao.findByIdProcesso", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwRespostaCorrecao.findByNrNotaFinal", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.nrNotaFinal = :nrNotaFinal"),
    @NamedQuery(name = "VwRespostaCorrecao.findByFlDiscrepancia", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.flDiscrepancia = :flDiscrepancia"),
    @NamedQuery(name = "VwRespostaCorrecao.findByFlDiscrepanciaCorrigida", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.flDiscrepanciaCorrigida = :flDiscrepanciaCorrigida"),
    @NamedQuery(name = "VwRespostaCorrecao.findByFlCorrigida", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.flCorrigida = :flCorrigida"),
    @NamedQuery(name = "VwRespostaCorrecao.findByIdColaboradorAtual", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.idColaboradorAtual = :idColaboradorAtual"),
    @NamedQuery(name = "VwRespostaCorrecao.findByFlCorrigindo", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.flCorrigindo = :flCorrigindo"),
    @NamedQuery(name = "VwRespostaCorrecao.findByIdCurso", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.idCurso = :idCurso"),
    @NamedQuery(name = "VwRespostaCorrecao.findByDtInsercaoResposta", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.dtInsercaoResposta = :dtInsercaoResposta"),
    @NamedQuery(name = "VwRespostaCorrecao.findByDtInsercao", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.dtInsercao = :dtInsercao"),
    @NamedQuery(name = "VwRespostaCorrecao.findByFlRespostaComErro", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.flRespostaComErro = :flRespostaComErro"),
    @NamedQuery(name = "VwRespostaCorrecao.findByFlPrimeiraCorrecao", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.flPrimeiraCorrecao = :flPrimeiraCorrecao"),
    @NamedQuery(name = "VwRespostaCorrecao.findByFlSegundaCorrecao", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.flSegundaCorrecao = :flSegundaCorrecao"),
    @NamedQuery(name = "VwRespostaCorrecao.findByIdCorrecao", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.idCorrecao = :idCorrecao"),
    @NamedQuery(name = "VwRespostaCorrecao.findByIdColaborador", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.idColaborador = :idColaborador"),
    @NamedQuery(name = "VwRespostaCorrecao.findByNrNota", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.nrNota = :nrNota"),
    @NamedQuery(name = "VwRespostaCorrecao.findByDtAtualizacao", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.dtAtualizacao = :dtAtualizacao"),
    @NamedQuery(name = "VwRespostaCorrecao.findByIdTipoCorrecao", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.idTipoCorrecao = :idTipoCorrecao"),
    @NamedQuery(name = "VwRespostaCorrecao.findByFlSucesso", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.flSucesso = :flSucesso"),
    @NamedQuery(name = "VwRespostaCorrecao.findByDtInsercaoCorrecao", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.dtInsercaoCorrecao = :dtInsercaoCorrecao"),
    @NamedQuery(name = "VwRespostaCorrecao.findByNmTipoCorrecao", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.nmTipoCorrecao = :nmTipoCorrecao"),
    @NamedQuery(name = "VwRespostaCorrecao.findByNmCurso", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.nmCurso = :nmCurso"),
    @NamedQuery(name = "VwRespostaCorrecao.findByIdInscricao", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.idInscricao = :idInscricao"),
    @NamedQuery(name = "VwRespostaCorrecao.findByFlContabilizaNota", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.flContabilizaNota = :flContabilizaNota"),
    @NamedQuery(name = "VwRespostaCorrecao.findByFlSobreposicaoNota", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.flSobreposicaoNota = :flSobreposicaoNota"),
    @NamedQuery(name = "VwRespostaCorrecao.findByIdBanca", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.idBanca = :idBanca"),
    @NamedQuery(name = "VwRespostaCorrecao.findByIdEmpresa", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "VwRespostaCorrecao.findByIdFuncao", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.idFuncao = :idFuncao"),
    @NamedQuery(name = "VwRespostaCorrecao.findByIdQuestao", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.idQuestao = :idQuestao"),
    @NamedQuery(name = "VwRespostaCorrecao.findByNmPessoa", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.nmPessoa = :nmPessoa"),
    @NamedQuery(name = "VwRespostaCorrecao.findByNrRg", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.nrRg = :nrRg"),
    @NamedQuery(name = "VwRespostaCorrecao.findByNmRgOrgao", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.nmRgOrgao = :nmRgOrgao"),
    @NamedQuery(name = "VwRespostaCorrecao.findByNmRgUf", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.nmRgUf = :nmRgUf"),
    @NamedQuery(name = "VwRespostaCorrecao.findByNrCpf", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.nrCpf = :nrCpf"),
    @NamedQuery(name = "VwRespostaCorrecao.findByNrPrioridade", query = "SELECT v FROM VwRespostaCorrecao v WHERE v.nrPrioridade = :nrPrioridade")})
public class VwRespostaCorrecao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_resposta")
    private Long idResposta;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Column(name = "cd_serial")
    private String cdSerial;
    @Column(name = "nr_questao")
    private Integer nrQuestao;
    @Column(name = "id_processo")
    private Integer idProcesso;
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
    @Column(name = "dt_insercao_resposta")
    private Long dtInsercaoResposta;
    @Column(name = "dt_insercao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInsercao;
    @Column(name = "fl_resposta_com_erro")
    private Boolean flRespostaComErro;
    @Column(name = "fl_primeira_correcao")
    private Boolean flPrimeiraCorrecao;
    @Column(name = "fl_segunda_correcao")
    private Boolean flSegundaCorrecao;
    @Column(name = "id_correcao")
    @Id
    private Long idCorrecao;
    @Column(name = "id_colaborador")
    private Long idColaborador;
    @Column(name = "nr_nota")
    private Double nrNota;
    @Column(name = "dt_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAtualizacao;
    @Column(name = "id_tipo_correcao")
    private Integer idTipoCorrecao;
    @Column(name = "fl_sucesso")
    private Boolean flSucesso;
    @Column(name = "dt_insercao_correcao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInsercaoCorrecao;
    @Column(name = "nm_tipo_correcao")
    private String nmTipoCorrecao;
    @Column(name = "nm_curso")
    private String nmCurso;
    @Column(name = "id_inscricao")
    private Long idInscricao;
    @Column(name = "fl_contabiliza_nota")
    private Boolean flContabilizaNota;
    @Column(name = "fl_sobreposicao_nota")
    private Boolean flSobreposicaoNota;
    @Column(name = "id_banca")
    private Integer idBanca;
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    @Column(name = "id_funcao")
    private Integer idFuncao;
    @Column(name = "id_questao")
    private Integer idQuestao;
    @Column(name = "nm_pessoa")
    private String nmPessoa;
    @Column(name = "nr_rg")
    private String nrRg;
    @Column(name = "nm_rg_orgao")
    private String nmRgOrgao;
    @Column(name = "nm_rg_uf")
    private String nmRgUf;
    @Column(name = "nr_cpf")
    private String nrCpf;
    @Column(name = "nr_prioridade")
    private Integer nrPrioridade;

    public VwRespostaCorrecao() {
    }

    public long getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(long idResposta) {
        this.idResposta = idResposta;
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

    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
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

    public long getIdColaboradorAtual() {
        return idColaboradorAtual;
    }

    public void setIdColaboradorAtual(long idColaboradorAtual) {
        this.idColaboradorAtual = idColaboradorAtual;
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

    public long getDtInsercaoResposta() {
        return dtInsercaoResposta;
    }

    public void setDtInsercaoResposta(long dtInsercaoResposta) {
        this.dtInsercaoResposta = dtInsercaoResposta;
    }

    public Date getDtInsercao() {
        return dtInsercao;
    }

    public void setDtInsercao(Date dtInsercao) {
        this.dtInsercao = dtInsercao;
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

    public long getIdCorrecao() {
        return idCorrecao;
    }

    public void setIdCorrecao(long idCorrecao) {
        this.idCorrecao = idCorrecao;
    }

    public long getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(long idColaborador) {
        this.idColaborador = idColaborador;
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

    public Integer getIdTipoCorrecao() {
        return idTipoCorrecao;
    }

    public void setIdTipoCorrecao(Integer idTipoCorrecao) {
        this.idTipoCorrecao = idTipoCorrecao;
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

    public String getNmTipoCorrecao() {
        return nmTipoCorrecao;
    }

    public void setNmTipoCorrecao(String nmTipoCorrecao) {
        this.nmTipoCorrecao = nmTipoCorrecao;
    }

    public String getNmCurso() {
        return nmCurso;
    }

    public void setNmCurso(String nmCurso) {
        this.nmCurso = nmCurso;
    }

    public long getIdInscricao() {
        return idInscricao;
    }

    public void setIdInscricao(long idInscricao) {
        this.idInscricao = idInscricao;
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

    public Integer getIdBanca() {
        return idBanca;
    }

    public void setIdBanca(Integer idBanca) {
        this.idBanca = idBanca;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(Integer idFuncao) {
        this.idFuncao = idFuncao;
    }

    public Integer getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
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

    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public Integer getNrPrioridade() {
        return nrPrioridade;
    }

    public void setNrPrioridade(Integer nrPrioridade) {
        this.nrPrioridade = nrPrioridade;
    }
    
}
