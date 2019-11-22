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
import model.TbBanca;
import model.TbCurso;
import model.TbDisciplina;
import model.TbProcesso;
import model.VwBancaDisciplinaCurso;
import service.BancaService;
import service.VwBancaDisciplinaCursoService;
import service.impl.BancaServiceImpl;
import service.impl.VwBancaDisciplinaCursoServiceImpl;



@ManagedBean(name="Banca")
@SessionScoped
public class BancaController extends BasicController {
    
    private TbBanca inserirBanca =new TbBanca();
    private DataModel gridBancas;
    private int idProcesso, idDisciplina, idCurso;
    
    private int idCursoFiltro=0;
    private int idDisciplinaFiltro=0;
    
    //private List<TbBanca> listaBancas = new ArrayList<TbBanca>();
    private List<VwBancaDisciplinaCurso> listaBancas = new ArrayList<VwBancaDisciplinaCurso>();

    
    public BancaController(){
        this.consultaListaBancas();
    }

    public TbBanca getInserirBanca() {
        return inserirBanca;
    }

    public void setInserirBanca(TbBanca inserirBanca) {
        this.inserirBanca = inserirBanca;
    }

    public DataModel getGridBancas() {
        return gridBancas;
    }

    public void setGridBancas(DataModel gridBancas) {
        this.gridBancas = gridBancas;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(int idProcesso) {
        this.idProcesso = idProcesso;
    }

    public String insereBanca(){
        BancaService bs = new BancaServiceImpl();
        this.getInserirBanca().setIdCurso(new TbCurso(this.getIdCurso()));
        this.getInserirBanca().setIdDisciplina(new TbDisciplina(this.getIdDisciplina()) );
        this.getInserirBanca().setIdProcesso(new TbProcesso(this.getIdProcesso()));
        TbBanca func = bs.inserir(this.getInserirBanca());
        this.setMensagem("Erro ao inserir banca.");
        if(func!=null){
            this.setMensagem("Banca inserida com sucesso.");
        }
        this.inserirBanca=new TbBanca();
        this.consultaListaBancas();
        return "/view/admin/cadastro/banca.xhtml";
    }


    public List<VwBancaDisciplinaCurso> getListaBanca() {
        //this.consultaListaBancas();
        return listaBancas;
    }

    public void setListaBanca(List<VwBancaDisciplinaCurso> listaFunc) {
        this.listaBancas = listaFunc;
    }


    public String prepararAlterar(){
        this.setMensagem("");
        VwBancaDisciplinaCurso temp = (VwBancaDisciplinaCurso) this.gridBancas.getRowData();
        TbBanca selecionada = (new BancaServiceImpl()).pesquisarPorID(temp.getIdBanca().intValue());
        this.idCurso = selecionada.getIdCurso().getIdCurso();
        this.idDisciplina = selecionada.getIdDisciplina().getIdDisciplina();
        this.idProcesso = selecionada.getIdProcesso().getIdProcesso();
        this.inserirBanca = selecionada;
        return "/view/admin/altera/banca.xhtml";
    }

    public String apaga(){

        BancaService bs = new BancaServiceImpl();
        VwBancaDisciplinaCurso selecionada = (VwBancaDisciplinaCurso) this.gridBancas.getRowData();
        TbBanca banca = bs.pesquisarPorID(selecionada.getIdBanca().intValue());
        bs.apagar(banca);
        this.consultaListaBancas();
        return "/view/admin/cadastro/banca.xhtml";
    }

    public String gravaAlteracao(){
        BancaService bs = new BancaServiceImpl();
        this.inserirBanca.setIdCurso(new TbCurso(this.idCurso));
        this.inserirBanca.setIdDisciplina(new TbDisciplina(this.idDisciplina));
        this.inserirBanca.setIdProcesso(new TbProcesso(this.idProcesso));
        bs.atualizar(this.inserirBanca);
        this.consultaListaBancas();
        this.setMensagem("Banca alterada com sucesso.");
        this.inserirBanca = new TbBanca();
        return "/view/admin/cadastro/banca.xhtml";
    }
    
    private void consultaListaBancas(){
        //BancaService bs=new BancaServiceImpl();
        VwBancaDisciplinaCursoService bs = new VwBancaDisciplinaCursoServiceImpl();
        
        //this.listaBancas =bs.pesquisarTodos();
        this.listaBancas =bs.pesquisarTodosOrdenado();
        this.gridBancas = new ListDataModel(this.listaBancas);
    }
    
    
    public void selecionouDisciplina(){
        this.getListaTodosPorFiltro() ;
    }
    
    /*public void getListaTodasBancasPorDisciplina(){
        BancaService bs = new BancaServiceImpl();
        List<TbBanca> bancaList = null;
           if(this.getDisciplinaSelecionadaFiltro()!= null && this.getDisciplinaSelecionadaFiltro().getIdDisciplina() != 0){
               bancaList = bs.pesquisarPorDisciplina(this.getDisciplinaSelecionadaFiltro().getIdDisciplina());
           }else{
               bancaList = bs.pesquisarTodosOrdenado();
           }
          
            this.gridBancas = new ListDataModel(bancaList);        
    }*/
    
    public void selecionouCurso(){
        this.getListaTodosPorFiltro() ;
    }
    
   /* public void getListaTodasBancasPorCurso(){
        BancaService bs = new BancaServiceImpl();
        List<TbBanca> bancaList = null;
           if(this.getCursoSelecionadoFiltro()!= null && this.getCursoSelecionadoFiltro().getIdCurso() != 0){
               bancaList = bs.pesquisarPorCurso(this.getCursoSelecionadoFiltro().getIdCurso());
           }else{
               bancaList = bs.pesquisarTodosOrdenado();
           }
          
            this.gridBancas = new ListDataModel(bancaList);        
    }*/
    
    public void getListaTodosPorFiltro() {
        VwBancaDisciplinaCursoService bs = new VwBancaDisciplinaCursoServiceImpl();
        List<VwBancaDisciplinaCurso> bancaList = null;
        bancaList = bs.pesquisarPorDisciplinaCurso(this.idDisciplinaFiltro, this.idCursoFiltro);
        this.gridBancas = new ListDataModel(bancaList);
    }

    public int getIdCursoFiltro() {
        return idCursoFiltro;
    }

    public void setIdCursoFiltro(int idCursoFiltro) {
        this.idCursoFiltro = idCursoFiltro;
    }

    public int getIdDisciplinaFiltro() {
        return idDisciplinaFiltro;
    }

    public void setIdDisciplinaFiltro(int idDisciplinaFiltro) {
        this.idDisciplinaFiltro = idDisciplinaFiltro;
    }

    public void selecionaBancaPorProcesso(){

        ColaboradorController cc = ColaboradorController.getInstance();
        
        VwBancaDisciplinaCursoService bs = new VwBancaDisciplinaCursoServiceImpl();
        
        if(cc!=null && cc.getIdProcesso()>0){
            //System.out.println("Here1"+cc.getIdProcesso());
            this.listaBancas =bs.pesquisarTodosOrdenadoPorProcesso(cc.getIdProcesso());
            for(VwBancaDisciplinaCurso atual:listaBancas){
                System.out.println(atual.getNmProcesso()+" - "+atual.getNmBanca());
            }
        }else{
            //System.out.println("Here2");
            this.listaBancas =bs.pesquisarTodosOrdenado();
        }
        this.gridBancas = new ListDataModel(this.listaBancas);
        
    }
    
}

    

