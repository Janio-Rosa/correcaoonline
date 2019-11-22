/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.TbFuncionalidade;

/**
 *
 * @author Janio
 */
@ManagedBean(name="Navegacao")
@SessionScoped
public class NavegacaoController extends BasicController {

    private TbFuncionalidade funcionalidade=new TbFuncionalidade();

    public NavegacaoController(){
    
    }

    public String navegarPara(){
        //Pendente - segurança: Validar acesso posteriormente

        return this.getFuncionalidade().getNmPaginaSistema();
    }

    public TbFuncionalidade getFuncionalidade() {
        return funcionalidade;
    }

    public void setFuncionalidade(TbFuncionalidade funcionalidade) {
        this.funcionalidade = funcionalidade;
    }

}
