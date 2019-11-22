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
import model.TbPerfil;
import service.PerfilService;
import service.impl.PerfilServiceImpl;


/**
 *
 * @author KAMYLLA
 */

@ManagedBean(name="Perfil")
@SessionScoped
public class PerfilController extends BasicController {
    
    private TbPerfil inserirPerfil = new TbPerfil();
    private DataModel gridPerfil;
    private int idPerfilPai;

    
    private List<TbPerfil> listaPerfil = new ArrayList<TbPerfil>();
   

    public PerfilController(){
        this.consultaListaPerfis();
    }

    public TbPerfil getInserirPerfil() {
        return inserirPerfil;
    }

    public void setInserirPerfil(TbPerfil inserirPerfil) {
        this.inserirPerfil = inserirPerfil;
    }

    public DataModel getGridPerfil() {
        return gridPerfil;
    }

    public void setGridPerfil(DataModel gridPerfils) {
        this.gridPerfil = gridPerfils;
    }

    public int getIdPerfilPai() {
        return idPerfilPai;
    }

    public void setIdPerfilPai(int idPerfilPai) {
        this.idPerfilPai = idPerfilPai;
    }
    
    
    public String inserePerfil(){
        PerfilService ps = new PerfilServiceImpl();
        TbPerfil perfil = ps.inserir(this.getInserirPerfil());
        this.setMensagem("Erro ao inserir Perfil.");
        if(perfil!=null){
            this.setMensagem("Perfil inserido com sucesso.");
        }
        this.consultaListaPerfis();
        this.inserirPerfil =new TbPerfil();
        return "/view/admin/cadastro/perfil.xhtml";
    }
     
    public List<TbPerfil> getListaPerfil() {
        this.consultaListaPerfis();
        return listaPerfil;
    }

    public void setListaPerfil(List<TbPerfil> Perfil) {
        this.listaPerfil = Perfil;
    }


    public String prepararAlterar(){
        TbPerfil selecionada = (TbPerfil) this.gridPerfil.getRowData();
        this.inserirPerfil= selecionada;
        return "/view/admin/altera/perfil.xhtml";
    }

    public String apaga(){

        PerfilService ps=new PerfilServiceImpl();
        TbPerfil perfil = (TbPerfil) this.gridPerfil.getRowData();
        ps.apagar(perfil);
        this.consultaListaPerfis();
        return "/view/admin/cadastro/perfil.xhtml";
    }

    public String gravaAlteracao(){
        PerfilService ps=new PerfilServiceImpl();
        ps.atualizar(this.inserirPerfil);
        this.consultaListaPerfis();
        this.setMensagem("Perfil alterado com sucesso.");
        this.inserirPerfil = new TbPerfil();
        return "/view/admin/cadastro/perfil.xhtml";
    }
    
    private void consultaListaPerfis(){
        PerfilService ps=new PerfilServiceImpl();
        this.listaPerfil = ps.pesquisarTodos();
        this.gridPerfil = new ListDataModel(this.listaPerfil);
    }
}
