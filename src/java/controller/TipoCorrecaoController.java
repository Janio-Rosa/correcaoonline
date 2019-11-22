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
import model.TbTipoCorrecao;
import service.TipoCorrecaoService;
import service.impl.TipoCorrecaoServiceImpl;


/**
 *
 * @author Janio
 */
@ManagedBean(name="TipoCorrecao")
@SessionScoped
public class TipoCorrecaoController extends BasicController {
    
    private TbTipoCorrecao inserirTipoCorrecao = new TbTipoCorrecao();
    private DataModel gridTipoCorrecoes;
    
    private List<TbTipoCorrecao> listaTipoCorrecao = new ArrayList<TbTipoCorrecao>();

    
    public TipoCorrecaoController(){
        this.consultaListaTipoCorrecoes();
    }

    public TbTipoCorrecao getInserirTipoCorrecao() {
        return inserirTipoCorrecao;
    }

    public void setInserirTipoCorrecao(TbTipoCorrecao inserirTipoCorrecao) {
        this.inserirTipoCorrecao = inserirTipoCorrecao;
    }

    public DataModel getGridTipoCorrecoes() {
        return gridTipoCorrecoes;
    }

    public void setGridTipoCorrecoes(DataModel gridTipoCorrecoes) {
        this.gridTipoCorrecoes = gridTipoCorrecoes;
    }

     public String insereTipoCorrecao(){
        TipoCorrecaoService tcs = new TipoCorrecaoServiceImpl();
        TbTipoCorrecao tipoCorrecao = tcs.inserir(this.getInserirTipoCorrecao());
        this.setMensagem("Erro ao inserir tipo de correção.");
        if(tipoCorrecao != null){
            this.setMensagem("Tipo de correção inserida com sucesso.");
        }
        this.consultaListaTipoCorrecoes();
        this.inserirTipoCorrecao =new TbTipoCorrecao();
        return "/view/admin/cadastro/tipoCorrecao.xhtml";
    }
     
    public List<TbTipoCorrecao> getListaTipoCorrecao() {
        this.consultaListaTipoCorrecoes();
        return listaTipoCorrecao;
    }

    public void setListaTipoCorrecao(List<TbTipoCorrecao> listaTipoCorrecao) {
        this.listaTipoCorrecao = listaTipoCorrecao;
    }


    public String prepararAlterar(){
        TbTipoCorrecao tipoCorrecao = (TbTipoCorrecao) this.gridTipoCorrecoes.getRowData();
        this.inserirTipoCorrecao=tipoCorrecao;
        return "/view/admin/altera/tipoCorrecao.xhtml";
    }

    public String apaga(){

        TipoCorrecaoService tcs=new TipoCorrecaoServiceImpl();
        TbTipoCorrecao tipoCorrecao = (TbTipoCorrecao) this.gridTipoCorrecoes.getRowData();
        tcs.apagar(tipoCorrecao);
        this.consultaListaTipoCorrecoes();
        return "/view/admin/cadastro/tipoCorrecao.xhtml";
    }

    public String gravaAlteracao(){
        TipoCorrecaoService tcs=new TipoCorrecaoServiceImpl();
        tcs.atualizar(this.inserirTipoCorrecao);
        this.consultaListaTipoCorrecoes();
        this.setMensagem("Tipo de Correcao alterada com sucesso.");
        this.inserirTipoCorrecao = new TbTipoCorrecao();
        return "/view/admin/cadastro/tipoCorrecao.xhtml";
    }
    
    private void consultaListaTipoCorrecoes(){
        TipoCorrecaoService tcs=new TipoCorrecaoServiceImpl();
        this.listaTipoCorrecao = tcs.pesquisarTodos();
        this.gridTipoCorrecoes = new ListDataModel(this.listaTipoCorrecao);
    }
}
