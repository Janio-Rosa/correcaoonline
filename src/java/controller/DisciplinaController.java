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
import model.TbDisciplina;
import service.DisciplinaService;
import service.impl.DisciplinaServiceImpl;

/**
 *
 * @author KAMYLLA
 */

@ManagedBean(name="Disciplina")
@SessionScoped
public class DisciplinaController extends BasicController {
    
    private TbDisciplina inserirDisciplina =new TbDisciplina();
    private DataModel gridDisciplinas;
    private List<TbDisciplina> listaDisciplinas = new ArrayList<TbDisciplina>();

    public DisciplinaController(){
        this.getListaTodasDisciplinas();
        this.consultaDisciplinas();
    }

    public List<TbDisciplina> getListaDisciplinas() {

        return listaDisciplinas;
    }
    
    public static DisciplinaController getInstance() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Object temp = session.getAttribute("Disciplina");
        if (temp instanceof DisciplinaController) {
            DisciplinaController dc = (DisciplinaController) temp;
            return dc;
        }
        return null;
    }

    public void setListaDisciplinas(List<TbDisciplina> listaDisciplinas) {
        this.listaDisciplinas = listaDisciplinas;
    }
    

    public TbDisciplina getInserirDisciplina() {
        return inserirDisciplina;
    }

    public void setInserirDisciplina(TbDisciplina inserirDisciplina) {
        this.inserirDisciplina = inserirDisciplina;
    }

    public DataModel getGridDisciplinas() {
        this.getListaTodasDisciplinas();
        return gridDisciplinas;
    }

    public void setGridDisciplinas(DataModel gridDisciplinas) {
        this.gridDisciplinas = gridDisciplinas;
    }

    public String insereDisciplina(){
        DisciplinaService ds = new DisciplinaServiceImpl();
        TbDisciplina disc = ds.inserir(this.getInserirDisciplina());
        this.setMensagem("Erro ao inserir disciplina.");
        if(disc!=null){
            this.setMensagem("Disciplina inserida com sucesso.");
        }
        this.inserirDisciplina=new TbDisciplina();
        return "/view/admin/cadastro/disciplinas.xhtml";
    }
    
     public String gravaAlteracao(){
        DisciplinaService ds = new DisciplinaServiceImpl();
        ds.atualizar(this.inserirDisciplina);
        this.getListaTodasDisciplinas();
        this.setMensagem("Disciplina alterada com sucesso.");
        this.inserirDisciplina = new TbDisciplina();
        return "/view/admin/cadastro/disciplinas.xhtml";
    }
     
     public String prepararAlterar(){
        TbDisciplina disciplina = (TbDisciplina) this.gridDisciplinas.getRowData();
        this.inserirDisciplina = disciplina;
        return "/view/admin/altera/disciplinas.xhtml";
    }
     
     
    public final void getListaTodasDisciplinas(){
        if(this.gridDisciplinas==null){
            DisciplinaService ds = new DisciplinaServiceImpl();
            this.gridDisciplinas = new ListDataModel(ds.pesquisarTodos());
        }
    }

    public String excluirDisciplina(){
        TbDisciplina selecionada = (TbDisciplina) this.gridDisciplinas.getRowData();
        TbDisciplina nova = new TbDisciplina();
        nova.setIdDisciplina(selecionada.getIdDisciplina());
        nova.setNmDisciplina(selecionada.getNmDisciplina());
        (new DisciplinaServiceImpl()).apagar(nova);
        return "/view/admin/cadastro/disciplinas.xhtml";
    }
    
    private void consultaDisciplinas(){
        DisciplinaService ds = new DisciplinaServiceImpl();
        this.listaDisciplinas = ds.pesquisarTodos();
    }
}
