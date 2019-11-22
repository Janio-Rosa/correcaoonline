/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;
import model.TbProcesso;
import service.ProcessoService;
import service.impl.ProcessoServiceImpl;


/**
 *
 * @author Janio
 */
@ManagedBean(name="ProcessoSeletivo")
@SessionScoped
public class ProcessoController extends BasicController {
    
    private TbProcesso inserirProcesso =new TbProcesso();
    private DataModel gridProcessos;
    private TbProcesso processoSelecionado=null;
    
    private List<TbProcesso> listaProc = new ArrayList<TbProcesso>();

    
    public ProcessoController(){
        this.consultaListaProcessos();
    }

    public TbProcesso getInserirProcesso() {
        return inserirProcesso;
    }

    public void setInserirProcesso(TbProcesso inserirProcesso) {
        this.inserirProcesso = inserirProcesso;
    }

    public DataModel getGridProcessos() {
        return gridProcessos;
    }

    public void setGridProcessos(DataModel gridProcessos) {
        this.gridProcessos = gridProcessos;
    }

    public String insereProcesso(){
        ProcessoService ps = new ProcessoServiceImpl();
        TbProcesso proc=ps.inserir(this.getInserirProcesso());
        System.out.println("Datas: de "+this.inserirProcesso.getDtValidadeInicial()+" ate "+this.inserirProcesso.getDtValidadeFinal());
        this.setMensagem("Erro ao inserir processo.");
        if(proc!=null){
            this.setMensagem("Processo inserido com sucesso.");
        }
        this.consultaListaProcessos();
        this.inserirProcesso = new TbProcesso();
        return "/view/admin/cadastro/processo.xhtml";
    }

    public List<TbProcesso> getListaProc() {
        this.consultaListaProcessos();
        return listaProc;
    }

    public void setListaProc(List<TbProcesso> listaProc) {
        this.listaProc = listaProc;
    }


    public String prepararAlterar(){
        TbProcesso processo = (TbProcesso) this.gridProcessos.getRowData();
        this.inserirProcesso=processo;
        return "/view/admin/altera/processo.xhtml";
    }

    
    public String prepararVer(){
        TbProcesso processo = (TbProcesso) this.gridProcessos.getRowData();
        this.processoSelecionado=processo;
        return "/view/banca/relatorio/definitivo/com/tela/da/view/rel_cor_feita.xhtml";
    }

    public String apaga(){

        ProcessoService ps=new ProcessoServiceImpl();
        TbProcesso processo = (TbProcesso) this.gridProcessos.getRowData();
        ps.apagar(processo);
        this.consultaListaProcessos();
        return "/view/admin/cadastro/processo.xhtml";
    }

    public String gravaAlteracao(){
        ProcessoService ps=new ProcessoServiceImpl();
        ps.atualizar(this.inserirProcesso);
        this.consultaListaProcessos();
        this.setMensagem("Processo alterado com sucesso.");
        this.inserirProcesso = new TbProcesso();
        return "/view/admin/cadastro/processo.xhtml";
    }
    
    private void consultaListaProcessos(){
        ProcessoService ps=new ProcessoServiceImpl();
        //this.listaProc =ps.pesquisarTodos();
        this.listaProc =ps.pesquisarTodosAtivos();
        this.gridProcessos = new ListDataModel(this.listaProc);
    }
    
    public static ProcessoController getInstance() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Object temp = session.getAttribute("ProcessoSeletivo");
        if (temp instanceof ProcessoController) {
            ProcessoController pc = (ProcessoController) temp;
            return pc;
        }
        return null;
    }

    public TbProcesso getProcessoSelecionado() {
        return processoSelecionado;
    }

    public void setProcessoSelecionado(TbProcesso processoSelecionado) {
        this.processoSelecionado = processoSelecionado;
    }

    
}
