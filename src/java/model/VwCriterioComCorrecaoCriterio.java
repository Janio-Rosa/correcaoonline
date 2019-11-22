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
@Table(name = "vw_criterio_com_correcao_criterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findAll", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByIdCriterio", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.idCriterio = :idCriterio"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByIdDisciplina", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByNmCriterio", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.nmCriterio = :nmCriterio"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByNrValorMaximo", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.nrValorMaximo = :nrValorMaximo"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByFlCriterioNegativo", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.flCriterioNegativo = :flCriterioNegativo"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByIdCorrecaoCriterio", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.idCorrecaoCriterio = :idCorrecaoCriterio"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByIdCorrecao", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.idCorrecao = :idCorrecao"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByNrLinha", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.nrLinha = :nrLinha"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByNrValor", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.nrValor = :nrValor"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByDtAtualizacao", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.dtAtualizacao = :dtAtualizacao"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByIdColaborador", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.idColaborador = :idColaborador"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByNrNota", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.nrNota = :nrNota"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByIdTipoCorrecao", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.idTipoCorrecao = :idTipoCorrecao"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByFlSucesso", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.flSucesso = :flSucesso"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByIdDisciplinaCorrecao", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.idDisciplinaCorrecao = :idDisciplinaCorrecao"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByNrQuestao", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.nrQuestao = :nrQuestao"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByIdImagem", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.idImagem = :idImagem"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByIdProcesso", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByNrNotaFinal", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.nrNotaFinal = :nrNotaFinal"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByIdCurso", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.idCurso = :idCurso"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByIdTipoQuestao", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.idTipoQuestao = :idTipoQuestao"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByNmDisciplina", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.nmDisciplina = :nmDisciplina"),
    @NamedQuery(name = "VwCriterioComCorrecaoCriterio.findByNmTipoQuestao", query = "SELECT v FROM VwCriterioComCorrecaoCriterio v WHERE v.nmTipoQuestao = :nmTipoQuestao")})
public class VwCriterioComCorrecaoCriterio implements Serializable {
    @Column(name = "dt_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAtualizacao;
    @Column(name = "ds_criterio")
    private String dsCriterio;
    private static final long serialVersionUID = 1L;
    @Column(name = "id_criterio")
    private Integer idCriterio;
    @Column(name = "id_categoria_criterio")
    private Integer idCategoriaCriterio;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Column(name = "nm_criterio")
    private String nmCriterio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nr_valor_maximo")
    private Double nrValorMaximo;
    @Column(name = "fl_criterio_negativo")
    private Boolean flCriterioNegativo;
    @Id
    @Column(name = "id_correcao_criterio")
    private BigInteger idCorrecaoCriterio;
    @Column(name = "id_correcao")
    private BigInteger idCorrecao;
    @Column(name = "nr_linha")
    private Integer nrLinha;
    @Column(name = "nr_valor")
    private Double nrValor;
    @Column(name = "id_resposta")
    private BigInteger idResposta;
    @Column(name = "id_colaborador")
    private BigInteger idColaborador;
    @Column(name = "nr_nota")
    private Double nrNota;
    @Column(name = "id_tipo_correcao")
    private Integer idTipoCorrecao;
    @Column(name = "fl_sucesso")
    private Boolean flSucesso;
    @Column(name = "id_disciplina_correcao")
    private Integer idDisciplinaCorrecao;
    @Column(name = "nr_questao")
    private Integer nrQuestao;
    @Column(name = "id_imagem")
    private String idImagem;
    @Column(name = "id_processo")
    private Integer idProcesso;
    @Column(name = "nr_nota_final")
    private Double nrNotaFinal;
    @Column(name = "id_curso")
    private Integer idCurso;
    @Column(name = "id_tipo_questao")
    private Integer idTipoQuestao;
    @Column(name = "nm_disciplina")
    private String nmDisciplina;
    @Column(name = "nm_tipo_questao")
    private String nmTipoQuestao;
    @Column(name = "ds_justificativa")
    private String dsJustificativa;
    
    public VwCriterioComCorrecaoCriterio() {
    }

    public Integer getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(Integer idCriterio) {
        this.idCriterio = idCriterio;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNmCriterio() {
        return nmCriterio;
    }

    public void setNmCriterio(String nmCriterio) {
        this.nmCriterio = nmCriterio;
    }

    public Double getNrValorMaximo() {
        return nrValorMaximo;
    }

    public void setNrValorMaximo(Double nrValorMaximo) {
        this.nrValorMaximo = nrValorMaximo;
    }

    public Boolean getFlCriterioNegativo() {
        return flCriterioNegativo;
    }

    public void setFlCriterioNegativo(Boolean flCriterioNegativo) {
        this.flCriterioNegativo = flCriterioNegativo;
    }

    public BigInteger getIdCorrecaoCriterio() {
        return idCorrecaoCriterio;
    }

    public void setIdCorrecaoCriterio(BigInteger idCorrecaoCriterio) {
        this.idCorrecaoCriterio = idCorrecaoCriterio;
    }

    public BigInteger getIdCorrecao() {
        return idCorrecao;
    }

    public void setIdCorrecao(BigInteger idCorrecao) {
        this.idCorrecao = idCorrecao;
    }

    public Integer getNrLinha() {
        return nrLinha;
    }

    public void setNrLinha(Integer nrLinha) {
        this.nrLinha = nrLinha;
    }

    public Double getNrValor() {
        return nrValor;
    }

    public void setNrValor(Double nrValor) {
        this.nrValor = nrValor;
    }

    public BigInteger getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(BigInteger idResposta) {
        this.idResposta = idResposta;
    }

    public Date getDtAtualizacao() {
        return dtAtualizacao;
    }

    public void setDtAtualizacao(Date dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }

    public BigInteger getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(BigInteger idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Double getNrNota() {
        return nrNota;
    }

    public void setNrNota(Double nrNota) {
        this.nrNota = nrNota;
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

    public Integer getIdDisciplinaCorrecao() {
        return idDisciplinaCorrecao;
    }

    public void setIdDisciplinaCorrecao(Integer idDisciplinaCorrecao) {
        this.idDisciplinaCorrecao = idDisciplinaCorrecao;
    }

    public Integer getNrQuestao() {
        return nrQuestao;
    }

    public void setNrQuestao(Integer nrQuestao) {
        this.nrQuestao = nrQuestao;
    }

    public String getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(String idImagem) {
        this.idImagem = idImagem;
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

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdTipoQuestao() {
        return idTipoQuestao;
    }

    public void setIdTipoQuestao(Integer idTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
    }

    public String getNmDisciplina() {
        return nmDisciplina;
    }

    public void setNmDisciplina(String nmDisciplina) {
        this.nmDisciplina = nmDisciplina;
    }

    public String getNmTipoQuestao() {
        return nmTipoQuestao;
    }

    public void setNmTipoQuestao(String nmTipoQuestao) {
        this.nmTipoQuestao = nmTipoQuestao;
    }

    public Integer getIdCategoriaCriterio() {
        return idCategoriaCriterio;
    }

    public void setIdCategoriaCriterio(Integer idCategoriaCriterio) {
        this.idCategoriaCriterio = idCategoriaCriterio;
    }
    
    public boolean isExisteCorrecaoCriterio(){
        if(this.getIdCorrecao()==null)return false;
        if(this.getIdCorrecao().intValue()==0)return false;
        return true;
    }

    public boolean isExisteJustificativa(){
        return this.isExisteCorrecaoCriterio() && this.getDsJustificativa()!=null && !this.getDsJustificativa().equalsIgnoreCase("");
    }

    public String getDsCriterio() {
        return dsCriterio;
    }

    public void setDsCriterio(String dsCriterio) {
        this.dsCriterio = dsCriterio;
    }

    public String getDsJustificativa() {
        return dsJustificativa;
    }

    public void setDsJustificativa(String dsJustificativa) {
        this.dsJustificativa = dsJustificativa;
    }

    @Override
    public String toString() {
        return "VwCriterioComCorrecaoCriterio{" + "nrValorMaximo=" + nrValorMaximo + ", idCorrecaoCriterio=" + idCorrecaoCriterio + ", idCorrecao=" + idCorrecao + ", nrLinha=" + nrLinha + ", nrValor=" + nrValor + '}';
    }

    
    
}
