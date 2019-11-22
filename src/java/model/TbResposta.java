/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import util.Uteis;

/**
 *
 * @author Janio
 */
@Entity
@Table(name = "tb_resposta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbResposta.findAll", query = "SELECT t FROM TbResposta t"),
    @NamedQuery(name = "TbResposta.findByIdResposta", query = "SELECT t FROM TbResposta t WHERE t.idResposta = :idResposta"),
    @NamedQuery(name = "TbResposta.findByNrQuestao", query = "SELECT t FROM TbResposta t WHERE t.nrQuestao = :nrQuestao"),
    @NamedQuery(name = "TbResposta.findByNrNotaFinal", query = "SELECT t FROM TbResposta t WHERE t.nrNotaFinal = :nrNotaFinal"),
    @NamedQuery(name = "TbResposta.findByFlDiscrepancia", query = "SELECT t FROM TbResposta t WHERE t.flDiscrepancia = :flDiscrepancia"),
    @NamedQuery(name = "TbResposta.findByFlDiscrepanciaCorrigida", query = "SELECT t FROM TbResposta t WHERE t.flDiscrepanciaCorrigida = :flDiscrepanciaCorrigida"),
    @NamedQuery(name = "TbResposta.findByFlCorrigida", query = "SELECT t FROM TbResposta t WHERE t.flCorrigida = :flCorrigida")})
@SequenceGenerator(name = "tb_resposta_id_resposta_seq", sequenceName = "tb_resposta_id_resposta_seq")
public class TbResposta implements Serializable {
    @JoinColumn(name = "id_colaborador_atual", referencedColumnName = "id_colaborador")
    @ManyToOne
    private TbColaborador idColaboradorAtual;
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso",updatable=false)
    @ManyToOne
    private TbCurso idCurso;
    @Basic(optional = false)
    @Column(name = "fl_corrigindo")
    private boolean flCorrigindo;
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "idResposta")
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idResposta")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResposta",fetch = FetchType.EAGER)
    private List<TbRespostaImagem> tbRespostaImagem;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tb_resposta_id_resposta_seq")
    @Basic(optional = false)
    @Column(name = "id_resposta")
    private Long idResposta;
    @Basic(optional = false)
    @Column(name = "cd_serial",updatable=false)
    private String idImagem;
    @Basic(optional = false)
    @Column(name = "nr_questao")
    private int nrQuestao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nr_nota_final")
    private Double nrNotaFinal;
    @Column(name = "fl_discrepancia")
    private Boolean flDiscrepancia;
    
    @Column(name = "fl_discrepancia_corrigida")
    private Boolean flDiscrepanciaCorrigida;

    @Column(name = "fl_atendimento_especial",insertable=false,updatable=false)
    private Boolean flAtendimentoEspecial;

    @Column(name = "fl_resposta_com_erro")
    private Boolean flRespostaComErro;

    @Column(name = "fl_resposta_em_branco")
    private Boolean flRespostaEmBranco;

    @Column(name = "fl_primeira_correcao")
    private Boolean flPrimeiraCorrecao;

    @Column(name = "fl_segunda_correcao")
    private Boolean flSegundaCorrecao;

    @Column(name = "fl_terceira_correcao")
    private Boolean flTerceiraCorrecao;
    
    @Column(name = "id_inscricao")
    private Long idInscricao;

    @Column(name = "id_curso_ordem")
    private Long idCursoOrdem;
    
    @Basic(optional = false)
    @Column(name = "fl_corrigida")
    private boolean flCorrigida;
    @JoinColumn(name = "id_processo", referencedColumnName = "id_processo",updatable=false)
    @ManyToOne(optional = false)
    private TbProcesso idProcesso;
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina",updatable=false)
    @ManyToOne(optional = false)
    private TbDisciplina idDisciplina;
    
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResposta")
    private List<TbCorrecao> tbCorrecaoList;
*/
    public TbResposta() {
    }

    public TbResposta(Long idResposta) {
        this.idResposta = idResposta;
    }

    public TbResposta(Long idResposta, String idImagem, int nrQuestao, byte[] blobImage, boolean flCorrigida) {
        this.idResposta = idResposta;
        this.idImagem = idImagem;
        this.nrQuestao = nrQuestao;
        this.flCorrigida = flCorrigida;
    }

    public Long getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Long idResposta) {
        this.idResposta = idResposta;
    }

    public String getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(String idImagem) {
        this.idImagem = idImagem;
    }

    public int getNrQuestao() {
        return nrQuestao;
    }

    public void setNrQuestao(int nrQuestao) {
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

    public boolean getFlCorrigida() {
        return flCorrigida;
    }

    public void setFlCorrigida(boolean flCorrigida) {
        this.flCorrigida = flCorrigida;
    }

    public TbProcesso getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(TbProcesso idProcesso) {
        this.idProcesso = idProcesso;
    }

    public TbDisciplina getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(TbDisciplina idDisciplina) {
        this.idDisciplina = idDisciplina;
    }
/*
    @XmlTransient
    public List<TbCorrecao> getTbCorrecaoList() {
        return tbCorrecaoList;
    }

    public void setTbCorrecaoList(List<TbCorrecao> tbCorrecaoList) {
        this.tbCorrecaoList = tbCorrecaoList;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResposta != null ? idResposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbResposta)) {
            return false;
        }
        TbResposta other = (TbResposta) object;
        if ((this.idResposta == null && other.idResposta != null) || (this.idResposta != null && !this.idResposta.equals(other.idResposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbResposta[ idResposta=" + idResposta + " idQuestao="+ this.nrQuestao + " ]";
    }

    public boolean getFlCorrigindo() {
        return flCorrigindo;
    }

    public void setFlCorrigindo(boolean flCorrigindo) {
        this.flCorrigindo = flCorrigindo;
    }
/*
    public TbRespostaImagem getTbRespostaImagem() {
        return tbRespostaImagem;
    }

    public void setTbRespostaImagem(TbRespostaImagem tbRespostaImagem) {
        this.tbRespostaImagem = tbRespostaImagem;
    }
*/
    public TbCurso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(TbCurso idCurso) {
        this.idCurso = idCurso;
    }

    public TbColaborador getIdColaboradorAtual() {
        return idColaboradorAtual;
    }

    public void setIdColaboradorAtual(TbColaborador idColaboradorAtual) {
        this.idColaboradorAtual = idColaboradorAtual;
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

    public Long getIdInscricao() {
        return idInscricao;
    }

    public void setIdInscricao(Long idInscricao) {
        this.idInscricao = idInscricao;
    }

    public Boolean getFlAtendimentoEspecial() {
        return flAtendimentoEspecial;
    }

    public void setFlAtendimentoEspecial(Boolean flAtendimentoEspecial) {
        this.flAtendimentoEspecial = flAtendimentoEspecial;
    }

    public Boolean getFlRespostaEmBranco() {
        return flRespostaEmBranco;
    }

    public void setFlRespostaEmBranco(Boolean flRespostaEmBranco) {
        this.flRespostaEmBranco = flRespostaEmBranco;
    }

    public Boolean getFlTerceiraCorrecao() {
        return flTerceiraCorrecao;
    }

    public void setFlTerceiraCorrecao(Boolean flTerceiraCorrecao) {
        this.flTerceiraCorrecao = flTerceiraCorrecao;
    }


   public String getNotaConvertida() {
       if(this.getNrNotaFinal()!=null) 
        return String.valueOf(Uteis.arredonda(this.getNrNotaFinal(), 2));
       return "";
    }

    public List<TbRespostaImagem> getTbRespostaImagem() {
        return tbRespostaImagem;
    }

    public void setTbRespostaImagem(List<TbRespostaImagem> tbRespostaImagem) {
        this.tbRespostaImagem = tbRespostaImagem;
    }

    public Long getIdCursoOrdem() {
        return idCursoOrdem;
    }

    public void setIdCursoOrdem(Long idCursoOrdem) {
        this.idCursoOrdem = idCursoOrdem;
    }

}
