/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.CategoriaCriterioDAO;
import dao.impl.CategoriaCriterioDAOImpl;
import java.util.ArrayList;
import java.util.List;
import model.TbCategoriaCriterio;
import model.TbGeneroCategoria;
import service.CategoriaCriterioService;
import service.CriterioService;
import service.GeneroCategoriaService;

/**
 *
 * @author Janio
 */
public class CategoriaCriterioServiceImpl implements CategoriaCriterioService {

    @Override
    public List<TbCategoriaCriterio> pesquisarTodos() {
        CategoriaCriterioDAO rnd = new CategoriaCriterioDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public TbCategoriaCriterio inserir(TbCategoriaCriterio retornoNis) {
        CategoriaCriterioDAO rnd = new CategoriaCriterioDAOImpl();
        return rnd.inserir(retornoNis);
    }

    @Override
    public TbCategoriaCriterio atualizar(TbCategoriaCriterio retornoNis) {
        CategoriaCriterioDAO rnd = new CategoriaCriterioDAOImpl();
        return rnd.atualizar(retornoNis);
    }

    @Override
    public boolean apagar(TbCategoriaCriterio retornoNis) {
        CategoriaCriterioDAO rnd = new CategoriaCriterioDAOImpl();
        return rnd.apagar(retornoNis);
    }

    @Override
    public TbCategoriaCriterio pesquisarPorID(int id) {
        CategoriaCriterioDAO rnd = new CategoriaCriterioDAOImpl();
        return rnd.pesquisarPorID(id);
    }

    @Override
    public List<TbCategoriaCriterio> pesquisarTodosOrdenado() {
        CategoriaCriterioDAO rnd = new CategoriaCriterioDAOImpl();
        String[] criterios = {"nmCategoriaCriterio"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }

    @Override
    public List<TbCategoriaCriterio> pesquisarPorErroPenalizacao(boolean ehErroPenalizacao) {
        CategoriaCriterioDAO rnd = new CategoriaCriterioDAOImpl();
        return rnd.pesquisarPorErroPenalizacao(ehErroPenalizacao);
    }

    @Override
    public List<TbCategoriaCriterio> pesquisarPorGeneros(TbGeneroCategoria genero, boolean ehErroPenalizacao) {
        GeneroCategoriaService gcs = new GeneroCategoriaServiceImpl();
        List<TbGeneroCategoria> generos = new ArrayList<TbGeneroCategoria>();
        TbGeneroCategoria pai = null;
        //Hibernate tricks - carregar objeto primeiro pelo ID, antes de usá-lo
        if (genero != null && genero.getIdGeneroCategoriaPai() != null) {
            //int idPai = genero.getIdGeneroCategoriaPai().getIdGeneroCategoria();
            int idPai = genero.getIdGeneroCategoriaPai();
            if (idPai != 0) {
                pai = new TbGeneroCategoria(idPai);
                generos.add(pai);
            }
        }

        generos.add(genero);

        for(TbGeneroCategoria atual: generos){
            System.out.println("Generos a procurar: " + atual);
        }
        CategoriaCriterioDAO rnd = new CategoriaCriterioDAOImpl();
        return rnd.pesquisarPorGeneros(generos, ehErroPenalizacao);
    }
/*
    @Override
    public List<TbCategoriaCriterio> pesquisarPorGeneros(TbGeneroCategoria genero, boolean ehErroPenalizacao) {
        GeneroCategoriaService gcs = new GeneroCategoriaServiceImpl();
        List<TbGeneroCategoria> generos = new ArrayList<TbGeneroCategoria>();
        TbGeneroCategoria pai = null;
        TbGeneroCategoria atual = (new GeneroCategoriaServiceImpl()).pesquisarPorID(genero.getIdGeneroCategoria());
        //Hibernate tricks - carregar objeto primeiro pelo ID, antes de usá-lo
        if (genero != null && genero.getIdGeneroCategoriaPai() != null) {
            //int idPai = genero.getIdGeneroCategoriaPai().getIdGeneroCategoria();
            int idPai = genero.getIdGeneroCategoriaPai();
            if (idPai != 0) {
                //pai = new TbGeneroCategoria(idPai);
                pai = (new GeneroCategoriaServiceImpl()).pesquisarPorID(idPai);
                generos.add(pai);
            }
        }

        generos.add(genero);

        //System.out.println("Generos a procurar: " + genero.getIdGeneroCategoria() + " _ " + (pai!=null ? pai.getIdGeneroCategoria() : "")+ " - Generos: "+generos.toString());
        CategoriaCriterioDAO rnd = new CategoriaCriterioDAOImpl();
        List<TbCategoriaCriterio> retorno = null;
        retorno = rnd.pesquisarPorGenero(genero, ehErroPenalizacao);
        if(pai!=null && retorno!=null)
            retorno.addAll( rnd.pesquisarPorGenero(pai, ehErroPenalizacao));
        
        //return rnd.pesquisarPorGeneros(generos, ehErroPenalizacao);
        return retorno;
    }
   */    
    @Override
    public List<TbCategoriaCriterio> pesquisarPorGenero(TbGeneroCategoria genero, boolean ehErroPenalizacao) {
        CategoriaCriterioDAO rnd = new CategoriaCriterioDAOImpl();
        return rnd.pesquisarPorGenero(genero, ehErroPenalizacao);
    }
    
    @Override
    public List<TbCategoriaCriterio> pesquisarPorGenerosSemCatVazias(TbGeneroCategoria genero, boolean ehErroPenalizacao) {
        List<TbGeneroCategoria> generos = new ArrayList<TbGeneroCategoria>();
        TbGeneroCategoria pai = null;
        //Hibernate tricks - carregar objeto primeiro pelo ID, antes de usá-lo
        if (genero != null && genero.getIdGeneroCategoriaPai() != null) {
            //int idPai = genero.getIdGeneroCategoriaPai().getIdGeneroCategoria();
            int idPai = genero.getIdGeneroCategoriaPai();
            if (idPai != 0) {
                pai = new TbGeneroCategoria(idPai);
                generos.add(pai);
            }
        }

        generos.add(genero);

        //System.out.println("Generos a procurar: " + genero.getIdGeneroCategoria() + " _ " + (pai!=null ? pai.getIdGeneroCategoria() : "")+ " - Generos: "+generos.toString());
        CategoriaCriterioDAO rnd = new CategoriaCriterioDAOImpl();
        List<TbCategoriaCriterio>  consulta = rnd.pesquisarPorGeneros(generos, ehErroPenalizacao);
        List<TbCategoriaCriterio>  retorno=new ArrayList<TbCategoriaCriterio>();
        for(TbCategoriaCriterio atual : consulta){
            CriterioService cs = new CriterioServiceImpl();
            if(cs.pesquisarPorCategoriaCriterio(atual.getIdCategoriaCriterio())!=null) {
                retorno.add(atual);
            }
        }
        
        return retorno;
    }
    
}
