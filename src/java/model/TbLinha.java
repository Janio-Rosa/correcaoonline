/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Janio
 */
public class TbLinha {

    private int nrLinha;
    private TbCorrecaoCriterio correcaoLinhaAtual;
    private boolean bolPossuiMarcacao=false;

    public TbLinha() {
        this(0,null);
    }

    public TbLinha(int nrLinha) {
        this.nrLinha = nrLinha;
        this.correcaoLinhaAtual = null;
    }

    public TbLinha(int nrLinha, TbCorrecaoCriterio correcaoL) {
        this.nrLinha = nrLinha;
        this.correcaoLinhaAtual = correcaoL;
    }

    public TbCorrecaoCriterio getCorrecaoLinhaAtual() {
        return correcaoLinhaAtual;
    }

    public void setCorrecaoLinhaAtual(TbCorrecaoCriterio correcaoLinhaAtual) {
        this.correcaoLinhaAtual = correcaoLinhaAtual;
    }

    public int getNrLinha() {
        return nrLinha;
    }

    public void setNrLinha(int nrLinha) {
        this.nrLinha = nrLinha;
    }

    public boolean isBolPossuiMarcacao() {
        return bolPossuiMarcacao;
    }

    public void setBolPossuiMarcacao(boolean bolPossuiMarcacao) {
        this.bolPossuiMarcacao = bolPossuiMarcacao;
    }

    
}
