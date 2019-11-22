/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.TbQuestao;
import service.QuestaoService;
import service.impl.QuestaoServiceImpl;

/**
 *
 * @author KAMYLLA
 */

@ManagedBean(name="QuestaoController")
@SessionScoped

public class QuestaoController extends BasicController{
    
    private List<TbQuestao> listaQuestoes = new ArrayList<TbQuestao>();

    public QuestaoController() {
        this.getListaQuestoes();
    }
    
   
    public List<TbQuestao> getListaQuestoes() {
        QuestaoService qs = new QuestaoServiceImpl();
        this.listaQuestoes = qs.pesquisarTodos();
        return listaQuestoes;
    }

    public void setListaQuestoes(List<TbQuestao> listaQuestoes) {
        this.listaQuestoes = listaQuestoes;
    }
    
    

}


