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
 * @author janio
 */
@Entity
//@Table(name = "vw_relatorio_notas")
@Table(name = "vw_relatorio_notas_")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwRelatorioNotas.findAll", query = "SELECT v FROM VwRelatorioNotas v"),
    @NamedQuery(name = "VwRelatorioNotas.findByIdResposta", query = "SELECT v FROM VwRelatorioNotas v WHERE v.idResposta = :idResposta"),
    @NamedQuery(name = "VwRelatorioNotas.findByDiscrepancia", query = "SELECT v FROM VwRelatorioNotas v WHERE v.discrepancia = :discrepancia")})
public class VwRelatorioNotas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_resposta")
    @Id
    private Long idResposta;
    @Column(name = "id_processo")
    private Integer idProcesso;
    @Column(name = "id_curso")
    private Integer idCurso;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;

    @Column(name = "nr_nota_final")
    private Float nrNotaFinal;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nr_nota3")
    private Float nrNota3;
    @Column(name = "nr_nota1")
    private Float nrNota1;
    @Column(name = "nr_nota2")
    private Float nrNota2;
    @Column(name = "nr_nota_discrepancia")
    private Float nrNotaDiscrepancia;

    @Column(name = "vl_media")
    private Float vlMedia;

    @Column(name = "nr_inscricao")
    private String nrInscricao;

    @Column(name = "nm_arquivo")
    private String nmArquivo;

    @Column(name = "nr_cpf")
    private String nrCpf;

    @Column(name = "discrepancia")
    private Float discrepancia;

    @Column(name = "nr_nota4")
    private Float nrNota4;

    public VwRelatorioNotas() {
    }


    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }



    public Long getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Long idResposta) {
        this.idResposta = idResposta;
    }

    public Float getDiscrepancia() {
        return discrepancia;
    }

    public void setDiscrepancia(Float discrepancia) {
        this.discrepancia = discrepancia;
    }

    public Float getNrNota1() {
        return nrNota1;
    }

    public void setNrNota1(Float nrNota1) {
        this.nrNota1 = nrNota1;
    }

    public Float getNrNota2() {
        return nrNota2;
    }

    public void setNrNota2(Float nrNota2) {
        this.nrNota2 = nrNota2;
    }

    public Float getNrNota3() {
        return nrNota3;
    }

    public void setNrNota3(Float nrNota3) {
        this.nrNota3 = nrNota3;
    }

    public Float getNrNotaDiscrepancia() {
        return nrNotaDiscrepancia;
    }

    public void setNrNotaDiscrepancia(Float nrNotaDiscrepancia) {
        this.nrNotaDiscrepancia = nrNotaDiscrepancia;
    }

    public Float getNrNotaFinal() {
        return nrNotaFinal;
    }

    public void setNrNotaFinal(Float nrNotaFinal) {
        this.nrNotaFinal = nrNotaFinal;
    }

    public Float getVlMedia() {
        return vlMedia;
    }

    public void setVlMedia(Float vlMedia) {
        this.vlMedia = vlMedia;
    }

    public String getNmArquivo() {
        return nmArquivo;
    }

    public void setNmArquivo(String nmArquivo) {
        this.nmArquivo = nmArquivo;
    }

    public String getNrInscricao() {
        return nrInscricao;
    }

    public void setNrInscricao(String nrInscricao) {
        this.nrInscricao = nrInscricao;
    }

    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public Float getNrNota4() {
        return nrNota4;
    }

    public void setNrNota4(Float nrNota4) {
        this.nrNota4 = nrNota4;
    }

    
}
