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
import model.TbFuncionalidade;
import service.FuncionalidadeService;
import service.impl.FuncionalidadeServiceImpl;


/**
 *
 * @author KAMYLLA
 */

@ManagedBean(name="Funcionalidade")
@SessionScoped
public class FuncionalidadeController extends BasicController {
    
    private TbFuncionalidade inserirFuncionalidade = new TbFuncionalidade();
    private DataModel gridFuncionalidades;
    private int idFuncionalidadeMae;
    private boolean isTitulo;

    
    private List<TbFuncionalidade> listaFuncionalidades = new ArrayList<TbFuncionalidade>();
   

    public FuncionalidadeController(){
        this.consultaListaFuncionalidades();
    }

    public TbFuncionalidade getInserirFuncionalidade() {
        return inserirFuncionalidade;
    }

    public void setInserirFuncionalidade(TbFuncionalidade inserirFuncionalidade) {
        this.inserirFuncionalidade = inserirFuncionalidade;
    }

    public DataModel getGridFuncionalidade() {
        return gridFuncionalidades;
    }

    public void setGridFuncionalidade(DataModel gridFuncionalidades) {
        this.gridFuncionalidades = gridFuncionalidades;
    }

    public int getIdFuncionalidadeMae() {
        return idFuncionalidadeMae;
    }

    public void setIdFuncionalidadeMae(int idFuncionalidadePai) {
        this.idFuncionalidadeMae = idFuncionalidadePai;
    }

    public boolean isIsTitulo() {
        return isTitulo;
    }

    public void setIsTitulo(boolean isTitulo) {
        this.isTitulo = isTitulo;
    }
    
    
    
    
    public String insereFuncionalidade(){
        FuncionalidadeService ps = new FuncionalidadeServiceImpl();
        this.getInserirFuncionalidade().setIdFuncionalidade(this.getIdFuncionalidadeMae());
        TbFuncionalidade Funcionalidade = ps.inserir(this.getInserirFuncionalidade());
        this.setMensagem("Erro ao inserir funcionalidade.");
        if(Funcionalidade!=null){
            this.setMensagem("Funcionalidade inserida com sucesso.");
        }
        this.consultaListaFuncionalidades();
        this.inserirFuncionalidade =new TbFuncionalidade();
        return "/view/admin/cadastro/funcionalidade.xhtml";
    }
     
    public List<TbFuncionalidade> getListaFuncionalidade() {
        this.consultaListaFuncionalidades();
        return listaFuncionalidades;
    }

    public void setListaFuncionalidade(List<TbFuncionalidade> Funcionalidade) {
        this.listaFuncionalidades = Funcionalidade;
    }


    public String prepararAlterar(){
        TbFuncionalidade genCategoria = (TbFuncionalidade) this.gridFuncionalidades.getRowData();
        this.inserirFuncionalidade=genCategoria;
        return "/view/admin/altera/funcionalidade.xhtml";
    }

    public String apaga(){

        FuncionalidadeService ps=new FuncionalidadeServiceImpl();
        TbFuncionalidade Funcionalidade = (TbFuncionalidade) this.gridFuncionalidades.getRowData();
        ps.apagar(Funcionalidade);
        this.consultaListaFuncionalidades();
        return "/view/admin/cadastro/funcionalidade.xhtml";
    }

    public String gravaAlteracao(){
        FuncionalidadeService ps=new FuncionalidadeServiceImpl();
        ps.atualizar(this.inserirFuncionalidade);
        this.consultaListaFuncionalidades();
        this.setMensagem("Funcionalidade alterada com sucesso.");
        this.inserirFuncionalidade = new TbFuncionalidade();
        return "/view/admin/cadastro/funcionalidade.xhtml";
    }
    
    private void consultaListaFuncionalidades(){
        FuncionalidadeService ps=new FuncionalidadeServiceImpl();
        this.listaFuncionalidades = ps.pesquisarTodos();
        this.gridFuncionalidades = new ListDataModel(this.listaFuncionalidades);
    }
}
