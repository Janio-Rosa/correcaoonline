/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.TbDisciplina;
import model.TbProcesso;
import service.impl.RespostaServiceImpl;

/**
 *
 * @author Janio
 */
@ManagedBean(name="RelatorioController")
@SessionScoped
public class RelatorioController extends BasicController {

    public int quantidadePrimeiraCorrecao;
    public int quantidadeSegundaCorrecao;
    public int quantidadeDiscrepancia;
    public int quantidadeDiscrepanciaCorrigida;
    public int totalACorrigir;
    public TbDisciplina disciplinaSelecionada;
    public List<TbDisciplina> listaDisciplinas;
    public TbProcesso processoSelecionado;
    public List<TbProcesso> listaProcessos;
    
    public RelatorioController() {
    }

    public int getQuantidadeDiscrepancia() {
        return (new RespostaServiceImpl()).quantidadeDiscrepancia(disciplinaSelecionada.getIdDisciplina().intValue(), this.getProcessoSelecionado().getIdProcesso().intValue()  );
    }

    public void setQuantidadeDiscrepancia(int quantidadeDiscrepancia) {
        this.quantidadeDiscrepancia = quantidadeDiscrepancia;
    }

    public int getQuantidadeDiscrepanciaCorrigida() {
        return (new RespostaServiceImpl()).quantidadeDiscrepanciaCorrigida(disciplinaSelecionada.getIdDisciplina().intValue(), this.getProcessoSelecionado().getIdProcesso().intValue()  );
    }

    public void setQuantidadeDiscrepanciaCorrigida(int quantidadeDiscrepanciaCorrigida) {
        this.quantidadeDiscrepanciaCorrigida = quantidadeDiscrepanciaCorrigida;
    }

    public int getQuantidadePrimeiraCorrecao() {
        return (new RespostaServiceImpl()).quantidadePrimeiraCorrecao(disciplinaSelecionada.getIdDisciplina().intValue(), this.getProcessoSelecionado().getIdProcesso().intValue()  );
    }

    public void setQuantidadePrimeiraCorrecao(int quantidadePrimeiraCorrecao) {
        this.quantidadePrimeiraCorrecao = quantidadePrimeiraCorrecao;
    }

    public int getQuantidadeSegundaCorrecao() {
        return (new RespostaServiceImpl()).quantidadeSegundaCorrecao(disciplinaSelecionada.getIdDisciplina().intValue(), this.getProcessoSelecionado().getIdProcesso().intValue()  );
    }

    public void setQuantidadeSegundaCorrecao(int quantidadeSegundaCorrecao) {
        this.quantidadeSegundaCorrecao = quantidadeSegundaCorrecao;
    }

    public String geraRelatorio(){
        ProcessoController pc = ProcessoController.getInstance();
        if(pc!=null){
            TbProcesso selecionado = pc.getProcessoSelecionado();
            

        }
        return "";
    }
    public int getTotalACorrigir() {
        //No futuro deverá ser usado outro parâmetro para obter a quantidade total de correções a serem feitas
        //por exemplo, quantidade total de respostas que NÃO estão em branco
        //return (new RespostaServiceImpl()).
        return (new RespostaServiceImpl()).quantidadeRespostasSemErro() ;
    }

    public void setTotalACorrigir(int totalACorrigir) {
        this.totalACorrigir = totalACorrigir;
    }

    public TbDisciplina getDisciplinaSelecionada() {
        return disciplinaSelecionada;
    }

    public void setDisciplinaSelecionada(TbDisciplina disciplinaSelecionada) {
        this.disciplinaSelecionada = disciplinaSelecionada;
    }

    public List<TbDisciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public void setListaDisciplinas(List<TbDisciplina> listaDisciplinas) {
        this.listaDisciplinas = listaDisciplinas;
    }

    public List<TbProcesso> getListaProcessos() {
        return listaProcessos;
    }

    public void setListaProcessos(List<TbProcesso> listaProcessos) {
        this.listaProcessos = listaProcessos;
    }

    public TbProcesso getProcessoSelecionado() {
        return processoSelecionado;
    }

    public void setProcessoSelecionado(TbProcesso processoSelecionado) {
        this.processoSelecionado = processoSelecionado;
    }

}
