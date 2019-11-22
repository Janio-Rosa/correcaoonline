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
import model.TbCurso;
import service.CursoService;
import service.impl.CursoServiceImpl;

/**
 *
 * @author KAMYLLA
 */
@ManagedBean(name = "Curso")
@SessionScoped
public class CursoController extends BasicController {

    private TbCurso inserirCurso = new TbCurso();
    private DataModel gridCursos;
    private List<TbCurso> listaCursos = new ArrayList<TbCurso>();

    public CursoController() {
        this.consultaCursos();
    }

    public List<TbCurso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<TbCurso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public TbCurso getInserirCurso() {
        return inserirCurso;
    }

    public void setInserirCurso(TbCurso inserirCurso) {
        this.inserirCurso = inserirCurso;
    }

    public DataModel getGridCursos() {
        this.getListaTodosCursos();
        return gridCursos;
    }

    public void setGridCursos(DataModel gridCursos) {
        this.gridCursos = gridCursos;
    }

    public String insereCurso() {
        CursoService ds = new CursoServiceImpl();
        TbCurso disc = ds.inserir(this.getInserirCurso());
        this.setMensagem("Erro ao inserir Curso.");
        if (disc != null) {
            this.setMensagem("Curso inserido com sucesso.");
        }
        this.inserirCurso = new TbCurso();
        return "/view/admin/cadastro/curso.xhtml";
    }

    public String gravaAlteracao() {
        CursoService ds = new CursoServiceImpl();
        ds.atualizar(this.inserirCurso);
        this.getListaTodosCursos();
        this.setMensagem("Curso alterada com sucesso.");
        this.inserirCurso = new TbCurso();
        return "/view/admin/cadastro/curso.xhtml";
    }

    public String prepararAlterar() {
        TbCurso Curso = (TbCurso) this.gridCursos.getRowData();
        this.inserirCurso = Curso;
        return "/view/admin/altera/curso.xhtml";
    }

    public void getListaTodosCursos() {
        CursoService ds = new CursoServiceImpl();
        this.gridCursos = new ListDataModel(ds.pesquisarTodos());
    }

    public String excluirCurso() {
        TbCurso selecionada = (TbCurso) this.gridCursos.getRowData();
        TbCurso nova = new TbCurso();
        nova.setIdCurso(selecionada.getIdCurso());
        nova.setNmCurso(selecionada.getNmCurso());
        (new CursoServiceImpl()).apagar(nova);
        return "/view/admin/cadastro/curso.xhtml";
    }
    private void consultaCursos(){
        CursoService ds = new CursoServiceImpl();
        this.listaCursos = ds.pesquisarTodosOrdenado();
    }
}
