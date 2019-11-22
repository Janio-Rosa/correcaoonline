/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;

/**
 *
 * @author Janio
 */
public class BasicController implements Serializable {
    
    private String mensagem="";

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isExibirMensagem(){
        return !this.mensagem.equalsIgnoreCase("");
    }
    
}
