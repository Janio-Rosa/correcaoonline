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
 * @author Janio
 */
@Entity
@Table(name = "vw_processo_disciplina_corretor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findAll", query = "SELECT v FROM VwProcessoDisciplinaCorretor v"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByIdResposta", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.idResposta = :idResposta"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByIdDisciplina", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByCdSerial", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.cdSerial = :cdSerial"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByNrQuestao", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.nrQuestao = :nrQuestao"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByIdProcesso", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByNrNotaFinal", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.nrNotaFinal = :nrNotaFinal"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByFlDiscrepancia", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.flDiscrepancia = :flDiscrepancia"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByFlDiscrepanciaCorrigida", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.flDiscrepanciaCorrigida = :flDiscrepanciaCorrigida"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByFlCorrigida", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.flCorrigida = :flCorrigida"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByIdColaboradorAtual", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.idColaboradorAtual = :idColaboradorAtual"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByFlCorrigindo", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.flCorrigindo = :flCorrigindo"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByIdCurso", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.idCurso = :idCurso"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByIdInscricao", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.idInscricao = :idInscricao"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByDtInsercao", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.dtInsercao = :dtInsercao"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByFlRespostaComErro", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.flRespostaComErro = :flRespostaComErro"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByFlPrimeiraCorrecao", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.flPrimeiraCorrecao = :flPrimeiraCorrecao"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByFlSegundaCorrecao", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.flSegundaCorrecao = :flSegundaCorrecao"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByNrCpf", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.nrCpf = :nrCpf"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByIdBanca", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.idBanca = :idBanca"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByIdFuncao", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.idFuncao = :idFuncao"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByIdTipoCorrecao", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.idTipoCorrecao = :idTipoCorrecao"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByFlAtivo", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.flAtivo = :flAtivo"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByIdEmpresa", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByNmPessoa", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.nmPessoa = :nmPessoa"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByNrRg", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.nrRg = :nrRg"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByNmRgOrgao", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.nmRgOrgao = :nmRgOrgao"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByNmRgUf", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.nmRgUf = :nmRgUf"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByNmDisciplina", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.nmDisciplina = :nmDisciplina"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByIdTipoQuestao", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.idTipoQuestao = :idTipoQuestao"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByNrNotaInicial", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.nrNotaInicial = :nrNotaInicial"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByNrLinha", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.nrLinha = :nrLinha"),
    @NamedQuery(name = "VwProcessoDisciplinaCorretor.findByIdColaborador", query = "SELECT v FROM VwProcessoDisciplinaCorretor v WHERE v.idColaborador = :idColaborador")})
public class VwProcessoDisciplinaCorretor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_resposta")
    private BigInteger idResposta;
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
    private BigInteger idColaboradorAtual;
    @Column(name = "fl_corrigindo")
    private Boolean flCorrigindo;
    @Column(name = "id_curso")
    private Integer idCurso;
    @Column(name = "id_inscricao")
    private BigInteger idInscricao;
    @Column(name = "dt_insercao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInsercao;
    @Column(name = "fl_resposta_com_erro")
    private Boolean flRespostaComErro;
    @Column(name = "fl_primeira_correcao")
    private Boolean flPrimeiraCorrecao;
    @Column(name = "fl_segunda_correcao")
    private Boolean flSegundaCorrecao;
    @Column(name = "nr_cpf")
    private String nrCpf;
    @Column(name = "id_banca")
    private Integer idBanca;
    @Column(name = "id_funcao")
    private Integer idFuncao;
    @Column(name = "id_tipo_correcao")
    private Integer idTipoCorrecao;
    @Column(name = "fl_ativo")
    private Boolean flAtivo;
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
    @Column(name = "nm_disciplina")
    private String nmDisciplina;
    @Column(name = "id_tipo_questao")
    private Integer idTipoQuestao;
    @Column(name = "nr_nota_inicial")
    private Double nrNotaInicial;
    @Column(name = "nr_linha")
    @Id
    private BigInteger nrLinha;
    @Column(name = "id_colaborador")
    private BigInteger idColaborador;

    public VwProcessoDisciplinaCorretor() {
    }

    public BigInteger getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(BigInteger idResposta) {
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

    public BigInteger getIdColaboradorAtual() {
        return idColaboradorAtual;
    }

    public void setIdColaboradorAtual(BigInteger idColaboradorAtual) {
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

    public BigInteger getIdInscricao() {
        return idInscricao;
    }

    public void setIdInscricao(BigInteger idInscricao) {
        this.idInscricao = idInscricao;
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

    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
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

    public String getNmDisciplina() {
        return nmDisciplina;
    }

    public void setNmDisciplina(String nmDisciplina) {
        this.nmDisciplina = nmDisciplina;
    }

    public Integer getIdTipoQuestao() {
        return idTipoQuestao;
    }

    public void setIdTipoQuestao(Integer idTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
    }

    public Double getNrNotaInicial() {
        return nrNotaInicial;
    }

    public void setNrNotaInicial(Double nrNotaInicial) {
        this.nrNotaInicial = nrNotaInicial;
    }

    public BigInteger getNrLinha() {
        return nrLinha;
    }

    public void setNrLinha(BigInteger nrLinha) {
        this.nrLinha = nrLinha;
    }

    public BigInteger getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(BigInteger idColaborador) {
        this.idColaborador = idColaborador;
    }
    
}
