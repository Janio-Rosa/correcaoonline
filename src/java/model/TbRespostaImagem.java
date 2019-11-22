/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Janio
 */
@Entity
@Table(name = "tb_resposta_imagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbRespostaImagem.findAll", query = "SELECT t FROM TbRespostaImagem t"),
    @NamedQuery(name = "TbRespostaImagem.findByIdRespostaImagem", query = "SELECT t FROM TbRespostaImagem t WHERE t.idRespostaImagem = :idRespostaImagem"),
    @NamedQuery(name = "TbRespostaImagem.findByDtImportacao", query = "SELECT t FROM TbRespostaImagem t WHERE t.dtImportacao = :dtImportacao")})
public class TbRespostaImagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_resposta_imagem")
    private Long idRespostaImagem;
    @Basic(optional = false)
    @Column(name = "dt_importacao",updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtImportacao;

    @Basic(optional = true)
    @Column(name = "dt_ultima_atualizacao",insertable=false)
    //@org.hibernate.annotations.Generated(org.hibernate.annotations.GenerationTime.ALWAYS)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtUltimaAtualizacao;

    @Column(name = "fl_conferida")
    private boolean flConferida;

    @Column(name = "fl_erro_imagem")
    private boolean flErroImagem;

    @Column(name = "fl_resposta_em_branco")
    private boolean flRespostaEmBranco;

    @Column(name = "fl_em_branco_conferida")
    private Boolean flEmBrancoConferida;

    @Column(name = "nr_ordem")
    private Integer nrOrdem;

    @Basic(optional = false)
    @Lob
    @Column(name = "im_imagem_resposta")
    private byte[] imImagemResposta;
    @JoinColumn(name = "id_resposta", referencedColumnName = "id_resposta")
    @OneToOne(optional = false)
    private TbResposta idResposta;

    public TbRespostaImagem() {
    }

    public TbRespostaImagem(Long idRespostaImagem) {
        this.idRespostaImagem = idRespostaImagem;
    }

    public TbRespostaImagem(Long idRespostaImagem, Date dtImportacao, byte[] imImagemResposta) {
        this.idRespostaImagem = idRespostaImagem;
        this.dtImportacao = dtImportacao;
        this.imImagemResposta = imImagemResposta;
    }

    public Long getIdRespostaImagem() {
        return idRespostaImagem;
    }

    public void setIdRespostaImagem(Long idRespostaImagem) {
        this.idRespostaImagem = idRespostaImagem;
    }

    public Date getDtImportacao() {
        return dtImportacao;
    }

    public void setDtImportacao(Date dtImportacao) {
        this.dtImportacao = dtImportacao;
    }

    public byte[] getImImagemResposta() {
        return imImagemResposta;
    }

    public void setImImagemResposta(byte[] imImagemResposta) {
        this.imImagemResposta = imImagemResposta;
    }

    public TbResposta getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(TbResposta idResposta) {
        this.idResposta = idResposta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRespostaImagem != null ? idRespostaImagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbRespostaImagem)) {
            return false;
        }
        TbRespostaImagem other = (TbRespostaImagem) object;
        if ((this.idRespostaImagem == null && other.idRespostaImagem != null) || (this.idRespostaImagem != null && !this.idRespostaImagem.equals(other.idRespostaImagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbRespostaImagem[ idRespostaImagem=" + idRespostaImagem + " ]";
    }

    public boolean isFlConferida() {
        return flConferida;
    }

    public void setFlConferida(boolean flConferida) {
        this.flConferida = flConferida;
    }

    public boolean isFlErroImagem() {
        return flErroImagem;
    }

    public void setFlErroImagem(boolean flErroImagem) {
        this.flErroImagem = flErroImagem;
    }

    public boolean isFlRespostaEmBranco() {
        return flRespostaEmBranco;
    }

    public void setFlRespostaEmBranco(boolean flRespostaEmBranco) {
        this.flRespostaEmBranco = flRespostaEmBranco;
    }

    public Date getDtUltimaAtualizacao() {
        return dtUltimaAtualizacao;
    }

    public void setDtUltimaAtualizacao(Date dtUltimaAtualizacao) {
        this.dtUltimaAtualizacao = dtUltimaAtualizacao;
    }

    public boolean isFlEmBrancoConferida() {
        return flEmBrancoConferida;
    }

    public void setFlEmBrancoConferida(boolean flEmBrancoConferida) {
        this.flEmBrancoConferida = flEmBrancoConferida;
    }

    public Integer getNrOrdem() {
        return nrOrdem;
    }

    public void setNrOrdem(Integer nrOrdem) {
        this.nrOrdem = nrOrdem;
    }

}
