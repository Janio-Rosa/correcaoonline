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
import model.TbGeneroCategoria;
import service.GeneroCategoriaService;
import service.impl.GeneroCategoriaServiceImpl;


/**
 *
 * @author Janio
 */
@ManagedBean(name="GeneroCategoria")
@SessionScoped
public class GeneroCategoriaController extends BasicController {
    
    private TbGeneroCategoria inserirGeneroCategoria = new TbGeneroCategoria();
    private DataModel gridGeneroCategoria;
    private int idGeneroCategoriaPai;
    private int idTipoQuestao;
    
    private List<TbGeneroCategoria> listaGeneroCategoria = new ArrayList<TbGeneroCategoria>();
   

    public GeneroCategoriaController(){
        this.consultaListaGeneroCategorias();
    }

    public TbGeneroCategoria getInserirGeneroCategoria() {
        return inserirGeneroCategoria;
    }

    public void setInserirGeneroCategoria(TbGeneroCategoria inserirGeneroCategoria) {
        this.inserirGeneroCategoria = inserirGeneroCategoria;
    }

    public DataModel getGridGeneroCategorias() {
        return gridGeneroCategoria;
    }

    public void setGridGeneroCategorias(DataModel gridGeneroCategorias) {
        this.gridGeneroCategoria = gridGeneroCategorias;
    }

    public int getIdGeneroCategoriaPai() {
        return idGeneroCategoriaPai;
    }

    public void setIdGeneroCategoriaPai(int idGeneroCategoria) {
        this.idGeneroCategoriaPai = idGeneroCategoria;
    }

    public int getIdTipoQuestao() {
        return idTipoQuestao;
    }

    public void setIdTipoQuestao(int idTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
    }
    
    

    
    public String insereGeneroCategoria(){
        GeneroCategoriaService gcs = new GeneroCategoriaServiceImpl();
        if(this.getIdGeneroCategoriaPai() == 0){
            this.getInserirGeneroCategoria().setIdGeneroCategoriaPai(null);
        }else{
            //this.getInserirGeneroCategoria().setIdGeneroCategoriaPai(new TbGeneroCategoria(this.getIdGeneroCategoriaPai()));
            this.getInserirGeneroCategoria().setIdGeneroCategoriaPai(this.getIdGeneroCategoriaPai());
        }
        this.inserirGeneroCategoria.setIdTipoQuestao(idTipoQuestao);
        TbGeneroCategoria catCriterio = gcs.inserir(this.getInserirGeneroCategoria());
        this.setMensagem("Erro ao inserir Gênero da Categoria.");
        if(catCriterio!=null){
            this.setMensagem("Gênero da Categoria inserido com sucesso.");
        }
        this.consultaListaGeneroCategorias();
        this.inserirGeneroCategoria =new TbGeneroCategoria();
        return "/view/admin/cadastro/generoCategoria.xhtml";
    }
     
    public List<TbGeneroCategoria> getListaGeneroCategoria() {
        this.consultaListaGeneroCategorias();
        return listaGeneroCategoria;
    }

    public void setListaGeneroCategoria(List<TbGeneroCategoria> generoCategoria) {
        this.listaGeneroCategoria = generoCategoria;
    }


    public String prepararAlterar(){
        this.setMensagem("");
        TbGeneroCategoria selecionada = (TbGeneroCategoria) this.gridGeneroCategoria.getRowData();
        //this.idGeneroCategoriaPai = selecionada.getIdGeneroCategoriaPai().getIdGeneroCategoria();
        this.idGeneroCategoriaPai = selecionada.getIdGeneroCategoriaPai();
        this.idTipoQuestao = selecionada.getIdTipoQuestao();
        this.inserirGeneroCategoria= selecionada;
        return "/view/admin/altera/generoCategoria.xhtml";
    }

    public String apaga(){

        GeneroCategoriaService gcs=new GeneroCategoriaServiceImpl();
        TbGeneroCategoria catCriterio = (TbGeneroCategoria) this.gridGeneroCategoria.getRowData();
        gcs.apagar(catCriterio);
        this.consultaListaGeneroCategorias();
        return "/view/admin/cadastro/generoCategoria.xhtml";
    }

    public String gravaAlteracao(){
        GeneroCategoriaService gcs=new GeneroCategoriaServiceImpl();
        //this.inserirGeneroCategoria.setIdGeneroCategoriaPai(new TbGeneroCategoria(this.idGeneroCategoriaPai));
        this.inserirGeneroCategoria.setIdGeneroCategoriaPai(this.idGeneroCategoriaPai);
        this.inserirGeneroCategoria.setIdTipoQuestao(this.idTipoQuestao);
        gcs.atualizar(this.inserirGeneroCategoria);
        this.consultaListaGeneroCategorias();
        this.setMensagem("GeneroCategoria alterado com sucesso.");
        this.inserirGeneroCategoria = new TbGeneroCategoria();
        return "/view/admin/cadastro/generoCategoria.xhtml";
    }
    
    private void consultaListaGeneroCategorias(){
        GeneroCategoriaService gcs=new GeneroCategoriaServiceImpl();
        this.listaGeneroCategoria = gcs.pesquisarTodos();
        this.gridGeneroCategoria = new ListDataModel(this.listaGeneroCategoria);
    }
}
