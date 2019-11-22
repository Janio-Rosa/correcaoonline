/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.TbFuncao;
import service.FuncaoService;
import service.impl.FuncaoServiceImpl;



@ManagedBean(name="Funcao")
@SessionScoped
public class FuncaoController extends BasicController {
    
    private TbFuncao inserirFuncao =new TbFuncao();
    private DataModel gridFuncoes;
    
    private List<TbFuncao> listaFuncao = new ArrayList<TbFuncao>();

    
    public FuncaoController(){
        this.consultaListaFuncoes();
    }

    public TbFuncao getInserirFuncao() {
        return inserirFuncao;
    }

    public void setInserirFuncao(TbFuncao inserirFuncao) {
        this.inserirFuncao = inserirFuncao;
    }

    public DataModel getGridFuncoes() {
        return gridFuncoes;
    }

    public void setGridFuncoes(DataModel gridFuncoes) {
        this.gridFuncoes = gridFuncoes;
    }

    public String insereFuncao(){
        FuncaoService fs = new FuncaoServiceImpl();
        TbFuncao func = fs.inserir(this.getInserirFuncao());
        this.setMensagem("Erro ao inserir função.");
        if(func!=null){
            this.setMensagem("Funcao inserida com sucesso.");
        }
        this.inserirFuncao=new TbFuncao();
        this.consultaListaFuncoes();
        return "/view/admin/cadastro/funcao.xhtml";
    }


    public List<TbFuncao> getListaFuncao() {
        this.consultaListaFuncoes();
        return listaFuncao;
    }

    public void setListaFuncao(List<TbFuncao> listaFunc) {
        this.listaFuncao = listaFunc;
    }


    public String prepararAlterar(){
        TbFuncao funcao = (TbFuncao) this.gridFuncoes.getRowData();
        this.inserirFuncao = funcao;
        return "/view/admin/altera/funcao.xhtml";
    }

    public String apaga(){

        FuncaoService fs = new FuncaoServiceImpl();
        TbFuncao funcao = (TbFuncao) this.gridFuncoes.getRowData();
        fs.apagar(funcao);
        this.consultaListaFuncoes();
        return "/view/admin/cadastro/funcao.xhtml";
    }

    public String gravaAlteracao(){
        FuncaoService fs = new FuncaoServiceImpl();
        fs.atualizar(this.inserirFuncao);
        this.consultaListaFuncoes();
        this.setMensagem("Funcao alterada com sucesso.");
        this.inserirFuncao = new TbFuncao();
        return "/view/admin/cadastro/funcao.xhtml";
    }
    
    private void consultaListaFuncoes(){
        FuncaoService fs=new FuncaoServiceImpl();
        this.listaFuncao =fs.pesquisarTodos();
        this.gridFuncoes = new ListDataModel(this.listaFuncao);
    }
}
