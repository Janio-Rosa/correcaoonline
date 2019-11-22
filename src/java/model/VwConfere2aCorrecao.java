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
@Table(name = "vw_confere_2a_correcao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwConfere2aCorrecao.findAll", query = "SELECT v FROM VwConfere2aCorrecao v"),
    @NamedQuery(name = "VwConfere2aCorrecao.findByIdResposta", query = "SELECT v FROM VwConfere2aCorrecao v WHERE v.idResposta = :idResposta"),
    @NamedQuery(name = "VwConfere2aCorrecao.findByIdDisciplina", query = "SELECT v FROM VwConfere2aCorrecao v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwConfere2aCorrecao.findByNrQuestao", query = "SELECT v FROM VwConfere2aCorrecao v WHERE v.nrQuestao = :nrQuestao"),
    @NamedQuery(name = "VwConfere2aCorrecao.findByIdCurso", query = "SELECT v FROM VwConfere2aCorrecao v WHERE v.idCurso = :idCurso")})
public class VwConfere2aCorrecao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_resposta")
    @Id
    private Long idResposta;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Column(name = "nr_questao")
    private Integer nrQuestao;
    @Column(name = "id_curso")
    private Integer idCurso;

    public VwConfere2aCorrecao() {
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Integer getNrQuestao() {
        return nrQuestao;
    }

    public void setNrQuestao(Integer nrQuestao) {
        this.nrQuestao = nrQuestao;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Long getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Long idResposta) {
        this.idResposta = idResposta;
    }
    
}
