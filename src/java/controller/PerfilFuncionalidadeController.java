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
import model.TbPerfil;
import model.TbPerfilFuncionalidade;
import model.TbPerfilFuncionalidadePK;
import model.VwPerfilFuncionalidade;
import service.PerfilFuncionalidadeService;
import service.VwPerfilFuncionalidadeService;
import service.impl.PerfilFuncionalidadeServiceImpl;
import service.impl.VwPerfilFuncionalidadeServiceImpl;

/**
 *
 * @author KAMYLLA
 */
@ManagedBean(name = "PerfilFuncionalidade")
@SessionScoped
public class PerfilFuncionalidadeController extends BasicController {

    private TbPerfilFuncionalidade inserirPerfilFuncionalidade = new TbPerfilFuncionalidade();
    private DataModel gridPerfilFuncionalidades;
    private int idPerfil, idFuncionalidade;
    private List<VwPerfilFuncionalidade> listaPerfilFuncionalidades = new ArrayList<VwPerfilFuncionalidade>();

    public PerfilFuncionalidadeController() {
        this.consultaListaPerfilFuncionalidades();
    }

    public TbPerfilFuncionalidade getInserirPerfilFuncionalidade() {
        return inserirPerfilFuncionalidade;
    }

    public void setInserirPerfilFuncionalidade(TbPerfilFuncionalidade inserirPerfilFuncionalidade) {
        this.inserirPerfilFuncionalidade = inserirPerfilFuncionalidade;
    }

    public DataModel getGridPerfilFuncionalidade() {
        return gridPerfilFuncionalidades;
    }

    public void setGridPerfilFuncionalidade(DataModel gridPerfilFuncionalidades) {
        this.gridPerfilFuncionalidades = gridPerfilFuncionalidades;
    }

    public int getIdFuncionalidade() {
        return idFuncionalidade;
    }

    public void setIdFuncionalidade(int idFuncionalidade) {
        this.idFuncionalidade = idFuncionalidade;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }
    

    public String inserePerfilFuncionalidade() {
        PerfilFuncionalidadeService ps = new PerfilFuncionalidadeServiceImpl();
        this.getInserirPerfilFuncionalidade().setTbPerfil(new TbPerfil(this.getIdPerfil()));
        this.getInserirPerfilFuncionalidade().setTbFuncionalidade(new TbFuncionalidade(this.getIdFuncionalidade()));
        this.getInserirPerfilFuncionalidade().setTbPerfilFuncionalidadePK(new TbPerfilFuncionalidadePK(this.getIdPerfil(), this.getIdFuncionalidade()));
        
        TbPerfilFuncionalidade perfilFunc = ps.pesquisarPorPerfilEFuncionalidade(this.idPerfil, this.idFuncionalidade);
        if(perfilFunc != null){
            this.setMensagem("Funcionalidade do Perfil já existente. ");
            return "/view/admin/cadastro/perfilFuncionalidade.xhtml";
        }
        
        TbPerfilFuncionalidade PerfilFuncionalidade = ps.inserir(this.getInserirPerfilFuncionalidade());
        this.setMensagem("Erro ao inserir Funcionalidade do Perfil.");
        
        if (PerfilFuncionalidade != null) {
            this.setMensagem("Funcionalidade do Perfil inserido com sucesso.");
        }
        this.inserirPerfilFuncionalidade = new TbPerfilFuncionalidade();
        this.consultaListaPerfilFuncionalidades();
        return "/view/admin/cadastro/perfilFuncionalidade.xhtml";
    }

    public List<VwPerfilFuncionalidade> getListaPerfilFuncionalidade() {
        this.consultaListaPerfilFuncionalidades();
        return listaPerfilFuncionalidades;
    }

    public void setListaPerfilFuncionalidade(List<VwPerfilFuncionalidade> PerfilFuncionalidade) {
        this.listaPerfilFuncionalidades = PerfilFuncionalidade;
    }

    public String prepararAlterar() {
        TbPerfilFuncionalidade genCategoria = (TbPerfilFuncionalidade) this.gridPerfilFuncionalidades.getRowData();
        this.inserirPerfilFuncionalidade = genCategoria;
        return "/view/admin/altera/perfilFuncionalidade.xhtml";
    }

    public String apagaPerfilFuncionalidade() {


        PerfilFuncionalidadeService ps = new PerfilFuncionalidadeServiceImpl();

        VwPerfilFuncionalidade selecionada = (VwPerfilFuncionalidade) this.gridPerfilFuncionalidades.getRowData();
        TbPerfilFuncionalidade nova = new TbPerfilFuncionalidade();

        if (selecionada != null) {
            int a=0;
            if(selecionada.getIdPerfil()!=null)a = selecionada.getIdPerfil().intValue();
            int b=0;
            if(selecionada.getIdFuncionalidade()!=null)b = selecionada.getIdFuncionalidade().intValue();
            
            nova = ps.pesquisarPorPerfilEFuncionalidade(a,b);
            if (nova != null) {
                ps.apagar(nova);
            }
        }
        this.consultaListaPerfilFuncionalidades();
        
        return "/view/admin/cadastro/perfilFuncionalidade.xhtml";
        
        
    }

    public String gravaAlteracao() {
        PerfilFuncionalidadeService ps = new PerfilFuncionalidadeServiceImpl();
        ps.atualizar(this.inserirPerfilFuncionalidade);
        this.consultaListaPerfilFuncionalidades();
        this.setMensagem("Perfil da Funcionalidade alterada com sucesso.");
        this.inserirPerfilFuncionalidade = new TbPerfilFuncionalidade();
        consultaListaPerfilFuncionalidades();
        return "/view/admin/cadastro/perfilFuncionalidade.xhtml";
    }

    private void consultaListaPerfilFuncionalidades() {
        VwPerfilFuncionalidadeService vpf = new VwPerfilFuncionalidadeServiceImpl();
        this.listaPerfilFuncionalidades = vpf.pesquisarTodosOrdenado();
        this.gridPerfilFuncionalidades = new ListDataModel(this.listaPerfilFuncionalidades);
    }
}
