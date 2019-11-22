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
 * @author janio
 */
@Entity
@Table(name = "vw_corretor_disciplina_processo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwCorretorDisciplinaProcesso.findAll", query = "SELECT v FROM VwCorretorDisciplinaProcesso v"),
    @NamedQuery(name = "VwCorretorDisciplinaProcesso.findByIdProcesso", query = "SELECT v FROM VwCorretorDisciplinaProcesso v WHERE v.idProcesso = :idProcesso"),
    @NamedQuery(name = "VwCorretorDisciplinaProcesso.findByIdDisciplina", query = "SELECT v FROM VwCorretorDisciplinaProcesso v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwCorretorDisciplinaProcesso.findByIdQuestao", query = "SELECT v FROM VwCorretorDisciplinaProcesso v WHERE v.idQuestao = :idQuestao"),
    @NamedQuery(name = "VwCorretorDisciplinaProcesso.findByNrCpf", query = "SELECT v FROM VwCorretorDisciplinaProcesso v WHERE v.nrCpf = :nrCpf"),
    @NamedQuery(name = "VwCorretorDisciplinaProcesso.findByIdFuncao", query = "SELECT v FROM VwCorretorDisciplinaProcesso v WHERE v.idFuncao = :idFuncao"),
    @NamedQuery(name = "VwCorretorDisciplinaProcesso.findByNmPessoa", query = "SELECT v FROM VwCorretorDisciplinaProcesso v WHERE v.nmPessoa = :nmPessoa"),
    @NamedQuery(name = "VwCorretorDisciplinaProcesso.findByNrRg", query = "SELECT v FROM VwCorretorDisciplinaProcesso v WHERE v.nrRg = :nrRg"),
    @NamedQuery(name = "VwCorretorDisciplinaProcesso.findByNmRgOrgao", query = "SELECT v FROM VwCorretorDisciplinaProcesso v WHERE v.nmRgOrgao = :nmRgOrgao"),
    @NamedQuery(name = "VwCorretorDisciplinaProcesso.findByNmRgUf", query = "SELECT v FROM VwCorretorDisciplinaProcesso v WHERE v.nmRgUf = :nmRgUf"),
    @NamedQuery(name = "VwCorretorDisciplinaProcesso.findByNmDisciplina", query = "SELECT v FROM VwCorretorDisciplinaProcesso v WHERE v.nmDisciplina = :nmDisciplina"),
    @NamedQuery(name = "VwCorretorDisciplinaProcesso.findByIdTipoQuestao", query = "SELECT v FROM VwCorretorDisciplinaProcesso v WHERE v.idTipoQuestao = :idTipoQuestao")})
public class VwCorretorDisciplinaProcesso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_processo")
    private Integer idProcesso;
    @Column(name = "id_disciplina")
    private Integer idDisciplina;
    @Column(name = "id_questao")
    private Integer idQuestao;
    @Column(name = "nr_cpf")
    @Id
    private String nrCpf;
    @Column(name = "id_funcao")
    private Integer idFuncao;
/*    @Column(name = "id_empresa")
    private Integer idEmpresa;*/
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

    public VwCorretorDisciplinaProcesso() {
    }

    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Integer getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public Integer getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(Integer idFuncao) {
        this.idFuncao = idFuncao;
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
    
}
