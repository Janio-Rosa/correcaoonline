/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
@Entity
@Table(name = "vw_categoria_criterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwCategoriaCriterio.findAll", query = "SELECT v FROM VwCategoriaCriterio v"),
    @NamedQuery(name = "VwCategoriaCriterio.findByIdCriterio", query = "SELECT v FROM VwCategoriaCriterio v WHERE v.idCriterio = :idCriterio"),
    @NamedQuery(name = "VwCategoriaCriterio.findByIdCategoriaCriterio", query = "SELECT v FROM VwCategoriaCriterio v WHERE v.idCategoriaCriterio = :idCategoriaCriterio"),
    @NamedQuery(name = "VwCategoriaCriterio.findByIdDisciplina", query = "SELECT v FROM VwCategoriaCriterio v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwCategoriaCriterio.findByNmCriterio", query = "SELECT v FROM VwCategoriaCriterio v WHERE v.nmCriterio = :nmCriterio"),
    @NamedQuery(name = "VwCategoriaCriterio.findByNrValorMaximo", query = "SELECT v FROM VwCategoriaCriterio v WHERE v.nrValorMaximo = :nrValorMaximo"),
    @NamedQuery(name = "VwCategoriaCriterio.findByFlCriterioNegativo", query = "SELECT v FROM VwCategoriaCriterio v WHERE v.flCriterioNegativo = :flCriterioNegativo"),
    @NamedQuery(name = "VwCategoriaCriterio.findByNmCategoriaCriterio", query = "SELECT v FROM VwCategoriaCriterio v WHERE v.nmCategoriaCriterio = :nmCategoriaCriterio"),
    @NamedQuery(name = "VwCategoriaCriterio.findByNrCategoriaValorMaximo", query = "SELECT v FROM VwCategoriaCriterio v WHERE v.nrCategoriaValorMaximo = :nrCategoriaValorMaximo")})
public class VwCategoriaCriterio implements Serializable {
    @Column(name = "fl_ativo")
    private Boolean flAtivo;
    @Column(name = "id_questao")
    private Integer idQuestao;
    @Column(name = "nm_genero_categoria")
    private String nmGeneroCategoria;
    @Column(name = "nm_disciplina")
    private String nmDisciplina;
    @Column(name = "nm_questao")
    private String nmQuestao;
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_criterio")
    private Integer idCriterio;
    @Column(name = "id_categoria_criterio")
    private Integer idCategoriaCriterio;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Column(name = "nm_criterio")
    private String nmCriterio;
    @Column(name = "nr_valor_maximo")
    private Double nrValorMaximo;
    @Column(name = "fl_criterio_negativo")
    private Boolean flCriterioNegativo;
    @Column(name = "nm_categoria_criterio")
    private String nmCategoriaCriterio;
    @Column(name = "nr_categoria_valor_maximo")
    private Double nrCategoriaValorMaximo;

    public VwCategoriaCriterio() {
    }

    public Integer getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(Integer idCriterio) {
        this.idCriterio = idCriterio;
    }

    public Integer getIdCategoriaCriterio() {
        return idCategoriaCriterio;
    }

    public void setIdCategoriaCriterio(Integer idCategoriaCriterio) {
        this.idCategoriaCriterio = idCategoriaCriterio;
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

    public String getNmCategoriaCriterio() {
        return nmCategoriaCriterio;
    }

    public void setNmCategoriaCriterio(String nmCategoriaCriterio) {
        this.nmCategoriaCriterio = nmCategoriaCriterio;
    }

    public Double getNrCategoriaValorMaximo() {
        return nrCategoriaValorMaximo;
    }

    public void setNrCategoriaValorMaximo(Double nrCategoriaValorMaximo) {
        this.nrCategoriaValorMaximo = nrCategoriaValorMaximo;
    }

    public String getNmGeneroCategoria() {
        return nmGeneroCategoria;
    }

    public void setNmGeneroCategoria(String nmGeneroCategoria) {
        this.nmGeneroCategoria = nmGeneroCategoria;
    }

    public String getNmDisciplina() {
        return nmDisciplina;
    }

    public void setNmDisciplina(String nmDisciplina) {
        this.nmDisciplina = nmDisciplina;
    }

    public String getNmQuestao() {
        return nmQuestao;
    }

    public void setNmQuestao(String nmQuestao) {
        this.nmQuestao = nmQuestao;
    }

    public Integer getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public Boolean getFlAtivo() {
        return flAtivo;
    }

    public void setFlAtivo(Boolean flAtivo) {
        this.flAtivo = flAtivo;
    }
    
}
