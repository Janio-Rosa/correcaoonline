/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Janio
 */
public class TbCorrecaoCriterioDigitacaoNota extends TbCorrecaoCriterio {
    
    //private int notaDigitada;
    private double notaDigitada;

    public TbCorrecaoCriterioDigitacaoNota(Long idCorrecaoCriterio, int nrLinha, double nrValor) {
        super(idCorrecaoCriterio, nrLinha, nrValor);
        this.setIdCriterio(new TbCriterio());
    }

    public TbCorrecaoCriterioDigitacaoNota(Long idCorrecaoCriterio) {
        super(idCorrecaoCriterio);
        this.setIdCriterio(new TbCriterio());
    }

    public TbCorrecaoCriterioDigitacaoNota() {
        this.setIdCriterio(new TbCriterio());
        this.notaDigitada = 0;
    }

    public double getNotaDigitada() {
        return notaDigitada;
    }

    public void setNotaDigitada(double notaDigitada) {
        this.notaDigitada = notaDigitada;
    }

}
