/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Janio
 */
@Entity
@Table(name = "tb_resposta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAtualizaResposta.findAll", query = "SELECT t FROM TbAtualizaResposta t"),
    @NamedQuery(name = "TbAtualizaResposta.findByIdResposta", query = "SELECT t FROM TbAtualizaResposta t WHERE t.idResposta = :idResposta"),
    @NamedQuery(name = "TbAtualizaResposta.findByNrNotaFinal", query = "SELECT t FROM TbAtualizaResposta t WHERE t.nrNotaFinal = :nrNotaFinal")})
@SequenceGenerator(name = "tb_resposta_id_resposta_seq", sequenceName = "tb_resposta_id_resposta_seq")
public class TbAtualizaResposta implements Serializable {
    private static final long serialVersionUID = 1L;
    @JoinColumn(name = "id_colaborador_atual", referencedColumnName = "id_colaborador")
    @ManyToOne
    private TbColaborador idColaboradorAtual;
    @Basic(optional = false)
    @Column(name = "fl_corrigindo")
    private boolean flCorrigindo;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tb_resposta_id_resposta_seq")
    @Basic(optional = false)
    @Column(name = "id_resposta")
    private Long idResposta;

    @Column(name = "nr_nota_final")
    private Double nrNotaFinal;

    @Basic(optional = false)
    @Column(name = "fl_discrepancia")
    private Boolean flDiscrepancia;

    @Basic(optional = false)
    @Column(name = "fl_discrepancia_corrigida")
    private Boolean flDiscrepanciaCorrigida;
    
    @Column(name = "fl_resposta_com_erro")
    private Boolean flRespostaComErro;
    
    @Column(name = "fl_primeira_correcao")
    private Boolean flPrimeiraCorrecao;

    @Column(name = "fl_segunda_correcao")
    private Boolean flSegundaCorrecao;

    @Column(name = "fl_terceira_correcao")
    private Boolean flTerceiraCorrecao;

    @Column(name = "fl_resposta_em_branco")
    private boolean flRespostaEmBranco;
    
    @Basic(optional = false)
    @Column(name = "fl_corrigida")
    private Boolean flCorrigida;
    
    public TbAtualizaResposta() {
    }

    public TbAtualizaResposta(Long idResposta) {
        this.idResposta = idResposta;
    }


    public Long getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Long idResposta) {
        this.idResposta = idResposta;
    }


    public Double getNrNotaFinal() {
        return nrNotaFinal;
    }

    public void setNrNotaFinal(Double nrNotaFinal) {
        this.nrNotaFinal = nrNotaFinal;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResposta != null ? idResposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAtualizaResposta)) {
            return false;
        }
        TbAtualizaResposta other = (TbAtualizaResposta) object;
        if ((this.idResposta == null && other.idResposta != null) || (this.idResposta != null && !this.idResposta.equals(other.idResposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbAtualizaResposta[ idResposta=" + idResposta + " ]";
    }

    public boolean getFlCorrigindo() {
        return flCorrigindo;
    }

    public void setFlCorrigindo(boolean flCorrigindo) {
        this.flCorrigindo = flCorrigindo;
    }

    public TbColaborador getIdColaboradorAtual() {
        return idColaboradorAtual;
    }

    public void setIdColaboradorAtual(TbColaborador idColaboradorAtual) {
        this.idColaboradorAtual = idColaboradorAtual;
    }

    public boolean isFlCorrigida() {
        return flCorrigida;
    }

    public boolean isFlDiscrepancia() {
        return flDiscrepancia;
    }

    public boolean isFlDiscrepanciaCorrigida() {
        return flDiscrepanciaCorrigida;
    }

    public Boolean getFlCorrigida() {
        return flCorrigida;
    }

    public void setFlCorrigida(Boolean flCorrigida) {
        this.flCorrigida = flCorrigida;
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

    public boolean isFlRespostaEmBranco() {
        return flRespostaEmBranco;
    }

    public void setFlRespostaEmBranco(boolean flRespostaEmBranco) {
        this.flRespostaEmBranco = flRespostaEmBranco;
    }

    public Boolean getFlTerceiraCorrecao() {
        return flTerceiraCorrecao;
    }

    public void setFlTerceiraCorrecao(Boolean flTerceiraCorrecao) {
        this.flTerceiraCorrecao = flTerceiraCorrecao;
    }

    
}
