/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.TbCorrecao;
import model.VwRespostasComProblema;
import service.impl.CorrecaoServiceImpl;
import service.impl.VwRespostasComProblemaServiceImpl;

/**
 *
 * @author Janio
 */
@ManagedBean(name = "RespostaControllerBanca")
@SessionScoped
public class RespostaControllerBanca extends RespostaController {

    private TbCorrecao passouPeloCorretor = null;
    List<VwRespostasComProblema> listaImagensComErro = null;

    public RespostaControllerBanca() {
        this.setPaginaRetorno("/view/banca/altera/listaRespostasComErro.xhtml");
        this.getListaImagensComErro();
    }

    public List<VwRespostasComProblema> getListaImagensComErro() {
        this.setPaginaRetorno("/view/banca/altera/listaRespostasComErro.xhtml");
        UsuarioController uc = UsuarioController.getInstance();
        int idDisciplinaSelecionada=0;
        if (uc != null && uc.getUsuario() != null && uc.getUsuario().getIdDisciplina() != null && uc.getUsuario().getIdDisciplina().getIdDisciplina() != null && uc.getUsuario().getIdDisciplina().getIdDisciplina().intValue() > 0) {
            idDisciplinaSelecionada = uc.getUsuario().getIdDisciplina().getIdDisciplina().intValue();
        }
        this.listaImagensComErro = (new VwRespostasComProblemaServiceImpl()).pesquisarPorDisciplina(idDisciplinaSelecionada);
        return listaImagensComErro;
    }

    public String consultaResposta(long idResposta) {
        this.consultaRespostaEspecifica(idResposta);
        List<TbCorrecao> consulta = (new CorrecaoServiceImpl()).pesquisarPorResposta(idResposta);
        if (consulta != null && consulta.size() > 0) {
            this.setPassouPeloCorretor(consulta.get(0));
        }
        this.setPaginaRetorno("/view/banca/altera/confereResposta.xhtml");
        return "/view/banca/altera/confereResposta.xhtml";
    }

    public TbCorrecao getPassouPeloCorretor() {
        return passouPeloCorretor;
    }

    public void setPassouPeloCorretor(TbCorrecao passouPeloCorretor) {
        this.passouPeloCorretor = passouPeloCorretor;
    }

    public boolean isExistemImagensComErro() {
        return (this.listaImagensComErro !=null && listaImagensComErro.size()>0);
    }

}
