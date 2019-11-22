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
import model.TbEmpresa;
import service.EmpresaService;
import service.impl.EmpresaServiceImpl;

/**
 *
 * @author KAMYLLA
 */
@ManagedBean(name="Empresa")
@SessionScoped
public class EmpresaController extends BasicController{
    
    private TbEmpresa inserirEmpresa;
    //private DataModel gridEmpresas;
    private List<TbEmpresa> listaEmpresas = new ArrayList<TbEmpresa>();
    private DataModel gridEmpresas;
  
    
     public EmpresaController(){
         inserirEmpresa = new TbEmpresa();
       this.getListaTodasEmpresas();
         carregaListasDefault();
    }

    public List<TbEmpresa> getListaEmpresas() {
        if(this.listaEmpresas==null)carregaListaEmpresas();
        return listaEmpresas;
    }

    public void setListaEmpresas(List<TbEmpresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    public DataModel getGridEmpresas() {
         this.getListaEmpresas();
         return gridEmpresas;
    }

    public void setGridEmpresas(DataModel gridEmpresas) {
        this.gridEmpresas = gridEmpresas;
    }

    public TbEmpresa getInserirEmpresa() {
        return inserirEmpresa;
    }

    public void setInserirEmpresa(TbEmpresa inserirEmpresa) {
        this.inserirEmpresa = inserirEmpresa;
    }
    
    
    private void carregaListasDefault(){
        carregaListaEmpresas();
    }
    
     public void getListaTodasEmpresas(){
        EmpresaService es = new EmpresaServiceImpl();
        this.gridEmpresas = new ListDataModel(es.pesquisarTodos());
    }
     
    private void carregaListaEmpresas(){
        EmpresaService es = new EmpresaServiceImpl();
        this.listaEmpresas= es.pesquisarTodos();
    }
    
    public String insereEmpresa(){
        EmpresaService es = new EmpresaServiceImpl();
        TbEmpresa emp = es.inserir(this.getInserirEmpresa());
        this.setMensagem("Erro ao inserir empresa.");
        if(emp!=null){
            this.getListaTodasEmpresas();
            this.setMensagem("Empresa inserida com sucesso.");
        }
        this.inserirEmpresa=new TbEmpresa();
        return "/view/admin/cadastro/empresa.xhtml";
    }
    
     public String gravaAlteracao(){
        EmpresaService es = new EmpresaServiceImpl();
        es.atualizar(this.inserirEmpresa);
        this.getListaTodasEmpresas();
        this.setMensagem("Empresa alterada com sucesso.");
        this.inserirEmpresa = new TbEmpresa();
        return "/view/admin/cadastro/empresa.xhtml";
    }
     
     public String prepararAlterar(){
        TbEmpresa empresa = (TbEmpresa) this.gridEmpresas.getRowData();
        this.inserirEmpresa = empresa;
        return "/view/admin/altera/empresa.xhtml";
    }
     
     
  
    public String excluirEmpresa(){
       
        EmpresaService es = new EmpresaServiceImpl();
        TbEmpresa empresa = (TbEmpresa) this.gridEmpresas.getRowData();
        es.apagar(empresa);
        this.getListaTodasEmpresas();
        return "/view/admin/cadastro/empresa.xhtml";
        
    }
}
