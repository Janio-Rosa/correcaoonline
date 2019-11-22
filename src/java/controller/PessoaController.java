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
import model.TbPessoa;
import service.PessoaService;
import service.impl.PessoaServiceImpl;

/**
 *
 * @author KAMYLLA
 */

@ManagedBean(name="Pessoa")
@SessionScoped
public class PessoaController extends BasicController{
    
    private TbPessoa inserirPessoa =new TbPessoa();
    private DataModel gridPessoas;
    private List<TbPessoa> listaPessoas = new ArrayList<TbPessoa>();
  
    
     public PessoaController(){
        this.consultaListaPessoas();
    }

    public TbPessoa getInserirPessoa() {
        return inserirPessoa;
    }

    public void setInserirPessoa(TbPessoa inserirPessoa) {
        this.inserirPessoa = inserirPessoa;
    }

    public DataModel getGridPessoas() {
        return gridPessoas;
    }

    public void setGridPessoas(DataModel p) {
        this.gridPessoas = p;
    }

    public void inserePessoa(){
        PessoaService ps = new PessoaServiceImpl();
        TbPessoa pes = ps.inserir(this.getInserirPessoa());
        if(pes==null){
            this.setMensagem("Erro ao inserir.");
        }
        this.inserirPessoa = new TbPessoa();
      
    }

    public List<TbPessoa> getListaPessoas() {
        this.consultaListaPessoas();
        return listaPessoas;
    }

    public void setListaPessoas(List<TbPessoa> listaPessoas) {
        this.listaPessoas = listaPessoas;
    }


    public void prepararAlterar(){
        TbPessoa processo = (TbPessoa) this.gridPessoas.getRowData();
        this.inserirPessoa=processo;
        //return "/view/admin/altera/processo.xhtml";
    }

    public void apaga(){
        
        PessoaService ps=new PessoaServiceImpl();
        TbPessoa processo = (TbPessoa) this.gridPessoas.getRowData();
        ps.apagar(processo);
        this.consultaListaPessoas();
    }

    public void gravaAlteracao(){
        PessoaService ps=new PessoaServiceImpl();
        ps.atualizar(this.inserirPessoa);
        this.consultaListaPessoas();
        this.inserirPessoa = new TbPessoa();
   }
    
   private void consultaListaPessoas(){
        PessoaService ps = new PessoaServiceImpl();
        this.listaPessoas = ps.pesquisarTodosOrdenado();
   }
}
