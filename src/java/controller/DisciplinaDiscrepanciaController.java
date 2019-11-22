/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.TbDisciplina;
import model.TbDisciplinaDiscrepancia;
import model.TbQuestao;
import model.TbUsuarioPerfil;
import model.VwDisciplinaDiscrepancia;
import service.DisciplinaDiscrepanciaService;
import service.VwDisciplinaDiscrepanciaService;
import service.impl.DisciplinaDiscrepanciaServiceImpl;
import service.impl.UsuarioPerfilServiceImpl;
import service.impl.VwDisciplinaDiscrepanciaServiceImpl;
import util.Uteis;



/**
 *
 * @author KAMYLLA
 */
@ManagedBean(name="DisciplinaDiscrepancia")
@SessionScoped

public class DisciplinaDiscrepanciaController extends BasicController{
    
    private TbDisciplinaDiscrepancia novaDisciplinaDiscrepancia;
    private DataModel gridDisciplinaDiscrepancia;
    private Integer idDisciplina, idQuestão;

    public DisciplinaDiscrepanciaController() {
        this.novaDisciplinaDiscrepancia = new TbDisciplinaDiscrepancia();
        this.consultaListaDisciplinaDiscrepancia();
    }
    
    public String inserirDisciplinaDiscrepancia(){
        DisciplinaDiscrepanciaService dds = new DisciplinaDiscrepanciaServiceImpl();
        this.novaDisciplinaDiscrepancia.setIdDisciplina(new TbDisciplina(this.idDisciplina));
        this.novaDisciplinaDiscrepancia.setIdQuestao(new TbQuestao(this.idQuestão));
        TbDisciplinaDiscrepancia discipDiscrepancia = dds.inserir(this.novaDisciplinaDiscrepancia);

        if(discipDiscrepancia != null){
            this.setMensagem("Cadastrado com sucesso!");
        }
        this.novaDisciplinaDiscrepancia = new TbDisciplinaDiscrepancia();
        this.consultaListaDisciplinaDiscrepancia();
        return "/view/admin/cadastro/disciplinaDiscrepancia.xhtml";
    }
    
     public String prepararAlterar(){
        TbDisciplinaDiscrepancia discDiscrepancia = (TbDisciplinaDiscrepancia) this.gridDisciplinaDiscrepancia.getRowData();
        this.idDisciplina = discDiscrepancia.getIdDisciplina().getIdDisciplina();
        this.idQuestão = discDiscrepancia.getIdQuestao().getIdQuestao();
        this.novaDisciplinaDiscrepancia = discDiscrepancia;
        return "/view/admin/altera/disciplinaDiscrepancia.xhtml";
    }
     
     public String gravaAlteracao(){
         DisciplinaDiscrepanciaService dds = new DisciplinaDiscrepanciaServiceImpl();
         this.novaDisciplinaDiscrepancia.setIdDisciplina(new TbDisciplina(this.idDisciplina));
         this.novaDisciplinaDiscrepancia.setIdQuestao(new TbQuestao(this.idQuestão));
         dds.atualizar(this.novaDisciplinaDiscrepancia);
         
        // this.getListaTodasDisciplinas();
         this.setMensagem("Alterada com sucesso.");
         this.novaDisciplinaDiscrepancia = new TbDisciplinaDiscrepancia();
         this.consultaListaDisciplinaDiscrepancia();
         return "/view/admin/cadastro/disciplinaDiscrepancia.xhtml";
    }
     
     
      public String ativaDesativaDiscrepancia() {
        this.setMensagem("");
        
            VwDisciplinaDiscrepancia selecionada = (VwDisciplinaDiscrepancia) this.gridDisciplinaDiscrepancia.getRowData();

            DisciplinaDiscrepanciaService dds = new DisciplinaDiscrepanciaServiceImpl();

            TbDisciplinaDiscrepancia discDiscrepancia = dds.pesquisarPorID(selecionada.getIdDisciplinaDiscrepancia());
            
            discDiscrepancia.setFlDiscrepanciaAtiva(selecionada.getFlDiscrepanciaAtiva());
            
            dds.atualizar(discDiscrepancia);
            this.consultaListaDisciplinaDiscrepancia();
         
        return"/view/admin/cadastro/disciplinaDiscrepancia.xhtml";
    }
     
    

    public TbDisciplinaDiscrepancia getNovaDisciplinaDiscrepancia() {
        return novaDisciplinaDiscrepancia;
    }

    public void setNovaDisciplinaDiscrepancia(TbDisciplinaDiscrepancia novaDisciplinaDiscrepancia) {
        this.novaDisciplinaDiscrepancia = novaDisciplinaDiscrepancia;
    }

    public DataModel getGridDisciplinaDiscrepancia() {
        return this.gridDisciplinaDiscrepancia;
    }

    public void setGridDisciplinaDiscrepancia(DataModel gridDisciplinaDiscrepancia) {
        this.gridDisciplinaDiscrepancia = gridDisciplinaDiscrepancia;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Integer getIdQuestão() {
        return idQuestão;
    }

    public void setIdQuestão(Integer idQuestão) {
        this.idQuestão = idQuestão;
    }

    private void consultaListaDisciplinaDiscrepancia(){
        VwDisciplinaDiscrepanciaService dds = new VwDisciplinaDiscrepanciaServiceImpl();
        UsuarioController uc = UsuarioController.getInstance();
        boolean bolAdministrador = false;
        
        if(uc!=null && uc.getUsuario()!=null){
            TbUsuarioPerfil up = (new UsuarioPerfilServiceImpl()).pesquisarPorIDUsuario(uc.getUsuario().getIdUsuario());
            bolAdministrador=(up.getTbPerfil() != null && up.getTbPerfil().getIdPerfil()!=null && up.getTbPerfil().getIdPerfil().intValue() == Uteis.PERFIL_ADMINISTRADOR);
        }

        if(uc!=null && uc.getUsuario().getIdDisciplina()!=null && uc.getUsuario().getIdDisciplina().getIdDisciplina().intValue()>0 && !bolAdministrador){
            this.gridDisciplinaDiscrepancia = new ListDataModel(dds.pesquisarPorDisciplina(uc.getUsuario().getIdDisciplina().getIdDisciplina().intValue()));
        }else{
            this.gridDisciplinaDiscrepancia = new ListDataModel(dds.pesquisarTodos());
        }    
    }
}
