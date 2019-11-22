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
import model.TbCategoriaCriterio;
import model.TbGeneroCategoria;
import service.CategoriaCriterioService;
import service.impl.CategoriaCriterioServiceImpl;
import service.impl.GeneroCategoriaServiceImpl;


/**
 *
 * @author Janio
 */
@ManagedBean(name="CategoriaCriterio")
@SessionScoped
public class CategoriaCriterioController extends BasicController {
    
    private TbCategoriaCriterio inserirCategoriaCriterio = new TbCategoriaCriterio();
    private DataModel gridCategoriaCriterios;
    
    private List<TbCategoriaCriterio> listaCatCriterio = new ArrayList<TbCategoriaCriterio>();
   //private List<VwCategoriaCriterio> listaVwCatCriterio = new ArrayList<VwCategoriaCriterio>();
    //private int idGeneroCategoria=0;
    private TbGeneroCategoria generoSelecionado=new TbGeneroCategoria();
    private int idCategoriaCriterioPai;
    private int idGeneroCategoria;
   

    
    public CategoriaCriterioController(){
        this.consultaListaCategoriaCriterios();
    }

    public TbCategoriaCriterio getInserirCategoriaCriterio() {
        return inserirCategoriaCriterio;
    }

    public void setInserirCategoriaCriterio(TbCategoriaCriterio inserirCategoriaCriterio) {
        this.inserirCategoriaCriterio = inserirCategoriaCriterio;
    }

    public DataModel getGridCategoriaCriterios() {
        return gridCategoriaCriterios;
    }

    public void setGridCategoriaCriterios(DataModel gridCategoriaCriterios) {
        this.gridCategoriaCriterios = gridCategoriaCriterios;
    }

    public int getIdCategoriaCriterioPai() {
        return idCategoriaCriterioPai;
    }

    public void setIdCategoriaCriterioPai(int idCategoriaCriterioPai) {
        this.idCategoriaCriterioPai = idCategoriaCriterioPai;
    }

    public int getIdGeneroCategoria() {
        return idGeneroCategoria;
    }

    public void setIdGeneroCategoria(int idGeneroCategoria) {
        this.idGeneroCategoria = idGeneroCategoria;
    }
    
    
    
    
    public String insereCategoriaCriterio(){
  
        CategoriaCriterioService ccs = new CategoriaCriterioServiceImpl();
        TbCategoriaCriterio inserir = new TbCategoriaCriterio();
        if(this.idCategoriaCriterioPai==0){
            inserir.setIdCategoriaCriterioPai(null);
        }else{
            inserir.setIdCategoriaCriterioPai(new TbCategoriaCriterio(this.idCategoriaCriterioPai));
        }
        inserir.setFlErroPenalizacaoGeral(this.inserirCategoriaCriterio.getFlErroPenalizacaoGeral());
        //System.out.println("GÊNERO SELECIONADO: "+this.getGeneroSelecionado().getIdGeneroCategoria());
        inserir.setIdGeneroCategoria( (new GeneroCategoriaServiceImpl()).pesquisarPorID(this.getGeneroSelecionado().getIdGeneroCategoria()));
        inserir.setNmCategoriaCriterio(this.inserirCategoriaCriterio.getNmCategoriaCriterio() );
        inserir.setNrValorMaximo(this.inserirCategoriaCriterio.getNrValorMaximo()  );
        

        TbCategoriaCriterio catCriterio = ccs.inserir(inserir);
        
        this.setMensagem("Erro ao inserir Categoria do Critério.");
        if(catCriterio!=null){
            this.setMensagem("Categoria do Critério inserida com sucesso.");
        }
        this.consultaListaCategoriaCriterios();
        this.inserirCategoriaCriterio =new TbCategoriaCriterio();
        this.generoSelecionado=new TbGeneroCategoria();
        this.idCategoriaCriterioPai=0;
        return "/view/admin/cadastro/categoriaCriterio.xhtml";
    }
        
    
    
     
    public List<TbCategoriaCriterio> getListaCatCriterio() {
        this.consultaListaCategoriaCriterios();
        return listaCatCriterio;
    }

    public void setListaCatCriterio(List<TbCategoriaCriterio> CatCriterio) {
        this.listaCatCriterio = CatCriterio;
    }


    public String prepararAlterar(){
        this.setMensagem("");
        CategoriaCriterioService ccs = new CategoriaCriterioServiceImpl();
        TbCategoriaCriterio selecionada = (TbCategoriaCriterio) this.gridCategoriaCriterios.getRowData();
        this.inserirCategoriaCriterio= ccs.pesquisarPorID(selecionada.getIdCategoriaCriterio());
        this.idGeneroCategoria = inserirCategoriaCriterio.getIdGeneroCategoria().getIdGeneroCategoria();
        //this.idCategoriaCriterioPai = inserirCategoriaCriterio.getIdCategoriaCriterioPai().getIdCategoriaCriterio();
        return "/view/admin/altera/categoriaCriterio.xhtml";
    }

    public String apaga(){

        CategoriaCriterioService ccs=new CategoriaCriterioServiceImpl();
        TbCategoriaCriterio catCriterio = (TbCategoriaCriterio) this.gridCategoriaCriterios.getRowData();
        ccs.apagar(catCriterio);
        this.consultaListaCategoriaCriterios();
        return "/view/admin/cadastro/categoriaCriterio.xhtml";
    }

    public String gravaAlteracao(){
        CategoriaCriterioService ccs=new CategoriaCriterioServiceImpl();
        ccs.atualizar(this.inserirCategoriaCriterio);
        this.consultaListaCategoriaCriterios();
        this.setMensagem("Categoria do Critério alterada com sucesso.");
        this.inserirCategoriaCriterio = new TbCategoriaCriterio();
        return "/view/admin/cadastro/categoriaCriterio.xhtml";
    }
    
    private void consultaListaCategoriaCriterios(){
        CategoriaCriterioService ccs=new CategoriaCriterioServiceImpl();
        this.listaCatCriterio = ccs.pesquisarTodos();
        this.gridCategoriaCriterios = new ListDataModel(this.listaCatCriterio);
    }

    public TbGeneroCategoria getGeneroSelecionado() {
        return generoSelecionado;
    }

    public void setGeneroSelecionado(TbGeneroCategoria generoSelecionado) {
        this.generoSelecionado = generoSelecionado;
    }
    
    
}
