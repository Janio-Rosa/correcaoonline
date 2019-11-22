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
import model.TbTipoQuestao;
import service.TipoQuestaoService;
import service.impl.TipoQuestaoServiceImpl;

/**
 *
 * @author KAMYLLA
 */
@ManagedBean(name = "TipoQuestao")
@SessionScoped
public class TipoQuestaoController extends BasicController {

    private TbTipoQuestao inserirTipoQuestao = new TbTipoQuestao();
    private DataModel gridTipoQuestoes;
     private List<TbTipoQuestao> listaTipoQuestoes = new ArrayList<TbTipoQuestao>();

    public TipoQuestaoController() {
        this.getListaTodosTipoQuestoes();
    }

    public TbTipoQuestao getinserirTipoQuestao() {
        return inserirTipoQuestao;
    }

    public void setinserirTipoQuestao(TbTipoQuestao inserirTipoQuestao) {
        this.inserirTipoQuestao = inserirTipoQuestao;
    }

    public DataModel getGridTipoQuestoes() {
        this.getListaTodosTipoQuestoes();
        return gridTipoQuestoes;
    }

    public void setGridTipoQuestoes(DataModel gridTipoQuestoes) {
        this.gridTipoQuestoes = gridTipoQuestoes;
    }

    public TbTipoQuestao getInserirTipoQuestao() {
        return inserirTipoQuestao;
    }

    public void setInserirTipoQuestao(TbTipoQuestao inserirTipoQuestao) {
        this.inserirTipoQuestao = inserirTipoQuestao;
    }

    public List<TbTipoQuestao> getListaTipoQuestoes() {
        TipoQuestaoService tps = new TipoQuestaoServiceImpl();
        this.listaTipoQuestoes = tps.pesquisarTodos();
        return listaTipoQuestoes;
        
    }

    public void setListaTipoQuestoes(List<TbTipoQuestao> listaTipoQuestoes) {
        this.listaTipoQuestoes = listaTipoQuestoes;
    }
    

    public String insereTipoQuestao() {

        TipoQuestaoService cs = new TipoQuestaoServiceImpl();
        TbTipoQuestao cat = cs.inserir(this.getinserirTipoQuestao());
        this.setMensagem("Erro ao inserir Tipo da Questão.");
        if (cat != null) {
            this.setMensagem("Tipo da Questão inserida com sucesso.");
        }
        this.inserirTipoQuestao = new TbTipoQuestao();
        return "/view/admin/cadastro/tipoQuestao.xhtml";
    }

    public void getListaTodosTipoQuestoes() {
        TipoQuestaoService ds = new TipoQuestaoServiceImpl();
        this.gridTipoQuestoes = new ListDataModel(ds.pesquisarTodos());
         
    }

    public String excluirTipoQuestao() {
        TbTipoQuestao selecionada = (TbTipoQuestao) this.gridTipoQuestoes.getRowData();
        TbTipoQuestao nova = new TbTipoQuestao();
        nova.setIdTipoQuestao(selecionada.getIdTipoQuestao());
        nova.setNmTipoQuestao(selecionada.getNmTipoQuestao());
        (new TipoQuestaoServiceImpl()).apagar(nova);
        return "/view/admin/cadastro/tipoQuestao.xhtml";
    }

    public String prepararAlterar() {
        TbTipoQuestao TipoQuestao = (TbTipoQuestao) this.gridTipoQuestoes.getRowData();
        this.inserirTipoQuestao = TipoQuestao;
        return "/view/admin/altera/tipoQuestao.xhtml";
    }

    public String gravaAlteracao() {
        TipoQuestaoService cs = new TipoQuestaoServiceImpl();
        cs.atualizar(this.inserirTipoQuestao);
        this.getListaTodosTipoQuestoes();
        this.setMensagem("TipoQuestao alterada com sucesso.");
        this.inserirTipoQuestao = new TbTipoQuestao();
        return "/view/admin/cadastro/tipoQuestao.xhtml";
    }
    
  
}
