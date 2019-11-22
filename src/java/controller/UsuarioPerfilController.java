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
import model.TbUsuario;
import model.TbUsuarioPerfil;
import model.TbUsuarioPerfilPK;
import model.VwUsuarioPerfil;
import model.VwUsuarioPessoa;
import service.UsuarioPerfilService;
import service.VwUsuarioPerfilService;
import service.impl.UsuarioPerfilServiceImpl;
import service.impl.VwUsuarioPerfilServiceImpl;
import service.impl.VwUsuarioPessoaServiceImpl;

/**
 *
 * @author KAMYLLA
 */

@ManagedBean(name="UsuarioPerfil")
@SessionScoped
public class UsuarioPerfilController extends BasicController {
    
    private TbUsuarioPerfil inserirUsuarioPerfil =new TbUsuarioPerfil();
    private DataModel gridUsuarioPerfil;
    private List<TbUsuarioPerfil> listaUsuarioPerfil = new ArrayList<TbUsuarioPerfil>();
    private int  idPerfil;
    private long idUsuario;
    private List<VwUsuarioPessoa> listaUsuarioPessoa=null;

    public UsuarioPerfilController(){
        this.getListaTodosUsuarioPerfil();
        this.consultaListaUsuarioPessoa();
    }

    public List<TbUsuarioPerfil> getListaUsuarioPerfil() {
        UsuarioPerfilService ups = new UsuarioPerfilServiceImpl();
        this.listaUsuarioPerfil = ups.pesquisarTodos();
        return listaUsuarioPerfil;
    }

    public void setListaUsuarioPerfil(List<TbUsuarioPerfil> listaUsuarioPerfil) {
        this.listaUsuarioPerfil = listaUsuarioPerfil;
    }
    

    public TbUsuarioPerfil getInserirUsuarioPerfil() {
        return inserirUsuarioPerfil;
    }

    public void setInserirUsuarioPerfil(TbUsuarioPerfil inserirUsuarioPerfil) {
        this.inserirUsuarioPerfil = inserirUsuarioPerfil;
    }

    public DataModel getGridUsuarioPerfil() {
        this.getListaTodosUsuarioPerfil();
        return gridUsuarioPerfil;
    }

    public void setGridUsuarioPerfil(DataModel gridUsuarioPerfil) {
        this.gridUsuarioPerfil = gridUsuarioPerfil;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPertfil) {
        this.idPerfil = idPertfil;
    }


    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    public String insereUsuarioPerfil(){
        UsuarioPerfilService ups = new UsuarioPerfilServiceImpl();
        TbUsuarioPerfilPK usuarioPerfilPK = new TbUsuarioPerfilPK(this.getIdUsuario(), this.getIdPerfil());
        this.getInserirUsuarioPerfil().setTbUsuarioPerfilPK(usuarioPerfilPK);
        this.getInserirUsuarioPerfil().setTbPerfil(new TbPerfil(this.getIdPerfil()));
        this.getInserirUsuarioPerfil().setTbUsuario(new TbUsuario(this.getIdUsuario()));
        
        TbUsuarioPerfil usuarioPerfil = ups.pesquisarPorPerfilEUsuario(this.idPerfil, this.idUsuario);
        if(usuarioPerfil != null){
            this.setMensagem("Perfil do Usuário já existente. ");
            return "/view/admin/cadastro/usuarioPerfil.xhtml";
        }
        
        TbUsuarioPerfil user = ups.inserir(this.getInserirUsuarioPerfil());
        this.setMensagem("Erro ao inserir Perfil do Usuário.");
        if(user!=null){
            this.setMensagem("Perfil do Usuário inserido com sucesso.");
        }
        this.inserirUsuarioPerfil=new TbUsuarioPerfil();
        return "/view/admin/cadastro/usuarioPerfil.xhtml";
    }
    
     public String gravaAlteracao(){
        UsuarioPerfilService ups = new UsuarioPerfilServiceImpl();
        ups.atualizar(this.inserirUsuarioPerfil);
        this.getListaTodosUsuarioPerfil();
        this.setMensagem("UsuarioPerfil alterada com sucesso.");
        this.inserirUsuarioPerfil = new TbUsuarioPerfil();
        return "/view/admin/cadastro/usuarioPerfil.xhtml";
    }
     
     public String prepararAlterar(){
        TbUsuarioPerfil UsuarioPerfil = (TbUsuarioPerfil) this.gridUsuarioPerfil.getRowData();
        this.inserirUsuarioPerfil = UsuarioPerfil;
        return "/view/admin/altera/usuarioPerfil.xhtml";
    }
     
     
    public final void getListaTodosUsuarioPerfil(){
        VwUsuarioPerfilService vups = new VwUsuarioPerfilServiceImpl();
        this.gridUsuarioPerfil = new ListDataModel(vups.pesquisarTodosOrdenado());
    }

    public String excluirUsuarioPerfil(){
        VwUsuarioPerfil selecionada = (VwUsuarioPerfil)this.gridUsuarioPerfil.getRowData();
        UsuarioPerfilService usp = new UsuarioPerfilServiceImpl();
        TbUsuarioPerfil nova = new TbUsuarioPerfil();
        
        if (selecionada != null) {
           nova = usp.pesquisarPorPerfilEUsuario(selecionada.getIdPerfil(), selecionada.getIdUsuario());
            if (nova != null) {
                usp.apagar(nova);
            }
            
        }
        this.getListaTodosUsuarioPerfil();
        return "/view/admin/cadastro/usuarioPerfil.xhtml";
    }

    public List<VwUsuarioPessoa> getListaUsuarioPessoa() {
        return listaUsuarioPessoa;
    }

    public void setListaUsuarioPessoa(List<VwUsuarioPessoa> listaUsuarioPessoa) {
        this.listaUsuarioPessoa = listaUsuarioPessoa;
    }

    private void consultaListaUsuarioPessoa(){
        this.listaUsuarioPessoa = (new VwUsuarioPessoaServiceImpl()).pesquisarTodosOrdenado();
    }
    
}
