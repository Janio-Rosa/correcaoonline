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
 * @author KAMYLLA
 */
@Entity
@Table(name = "vw_estatistica_correcao_consolidado_disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwEstatisticaCorrecaoConsolidadoDisciplina.findAll", query = "SELECT v FROM VwEstatisticaCorrecaoConsolidadoDisciplina v"),
    @NamedQuery(name = "VwEstatisticaCorrecaoConsolidadoDisciplina.findByIdDisciplina", query = "SELECT v FROM VwEstatisticaCorrecaoConsolidadoDisciplina v WHERE v.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "VwEstatisticaCorrecaoConsolidadoDisciplina.findByQtTotalCorrigido", query = "SELECT v FROM VwEstatisticaCorrecaoConsolidadoDisciplina v WHERE v.qtTotalCorrigido = :qtTotalCorrigido"),
    @NamedQuery(name = "VwEstatisticaCorrecaoConsolidadoDisciplina.findByQtPrimeiraCorrecao", query = "SELECT v FROM VwEstatisticaCorrecaoConsolidadoDisciplina v WHERE v.qtPrimeiraCorrecao = :qtPrimeiraCorrecao"),
    @NamedQuery(name = "VwEstatisticaCorrecaoConsolidadoDisciplina.findByQtSegundaCorrecao", query = "SELECT v FROM VwEstatisticaCorrecaoConsolidadoDisciplina v WHERE v.qtSegundaCorrecao = :qtSegundaCorrecao")})
public class VwEstatisticaCorrecaoConsolidadoDisciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_disciplina")
    @Id
    private Integer idDisciplina;
    @Column(name = "qt_total_corrigido")
    private BigInteger qtTotalCorrigido;
    @Column(name = "qt_primeira_correcao")
    private BigInteger qtPrimeiraCorrecao;
    @Column(name = "qt_segunda_correcao")
    private BigInteger qtSegundaCorrecao;

    public VwEstatisticaCorrecaoConsolidadoDisciplina() {
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public BigInteger getQtTotalCorrigido() {
        return qtTotalCorrigido;
    }

    public void setQtTotalCorrigido(BigInteger qtTotalCorrigido) {
        this.qtTotalCorrigido = qtTotalCorrigido;
    }

    public BigInteger getQtPrimeiraCorrecao() {
        return qtPrimeiraCorrecao;
    }

    public void setQtPrimeiraCorrecao(BigInteger qtPrimeiraCorrecao) {
        this.qtPrimeiraCorrecao = qtPrimeiraCorrecao;
    }

    public BigInteger getQtSegundaCorrecao() {
        return qtSegundaCorrecao;
    }

    public void setQtSegundaCorrecao(BigInteger qtSegundaCorrecao) {
        this.qtSegundaCorrecao = qtSegundaCorrecao;
    }
    
}
