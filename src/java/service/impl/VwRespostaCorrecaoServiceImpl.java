/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwRepostaCorrecaoDAO;
import dao.impl.VwRepostaCorrecaoDAOImpl;
import java.math.BigInteger;
import java.util.List;
import model.VwRespostaCorrecao;
import service.VwRespostaCorrecaoService;

/**
 *
 * @author Janio
 */
public class VwRespostaCorrecaoServiceImpl implements VwRespostaCorrecaoService {

    @Override
    public List<VwRespostaCorrecao> pesquisarTodos() {
        VwRepostaCorrecaoDAO vrcd = new VwRepostaCorrecaoDAOImpl();
        return vrcd.pesquisarTodos();
    }

    @Override
    public List<VwRespostaCorrecao> pesquisarTodosOrdenado(String[] atributoOrdenar) {
        VwRepostaCorrecaoDAO vrcd = new VwRepostaCorrecaoDAOImpl();
        String[] criterios = {"idCorrecao"};
        return vrcd.pesquisarTodosOrdenado(criterios);
    }

    @Override
    public int quantidadePorColaborador(long idColaborador, int idProcesso) {
        VwRepostaCorrecaoDAO vrcd = new VwRepostaCorrecaoDAOImpl();
        return vrcd.quantidadePorColaborador(idColaborador, idProcesso);
    }

    @Override
    public List<VwRespostaCorrecao> listaCorrecoesPorCorretorDisciplinaProcesso(long idColaborador, int idProcesso, int idDisciplina) {
        VwRepostaCorrecaoDAO vrcd = new VwRepostaCorrecaoDAOImpl();
        return vrcd.listaCorrecoesPorCorretorDisciplinaProcesso(idColaborador, idProcesso, idDisciplina);
    }
    
    @Override
    public List<VwRespostaCorrecao> pesquisarPorIdResposta(long idResposta) {
        VwRepostaCorrecaoDAO vrcd = new VwRepostaCorrecaoDAOImpl();
        return vrcd.pesquisarPorIdResposta(idResposta);
        
    }
    
    @Override
    public VwRespostaCorrecao pesquisarPorIDLong(long id) {
        VwRepostaCorrecaoDAO rnd = new VwRepostaCorrecaoDAOImpl();
        return rnd.pesquisarPorIDLong(id);
    }
    
    @Override
    public VwRespostaCorrecao pesquisarPorIdCorrecao(long idCorrecao) {
        VwRepostaCorrecaoDAO rnd = new VwRepostaCorrecaoDAOImpl();
        return rnd.pesquisarPorIdCorrecao(idCorrecao);
    }

    @Override
    public VwRespostaCorrecao pesquisarPorIdResposta(long idResposta, long idColaborador) {
        VwRepostaCorrecaoDAO vrcd = new VwRepostaCorrecaoDAOImpl();
        return vrcd.pesquisarPorIdResposta(idResposta,idColaborador);
    }

    @Override
    public List<VwRespostaCorrecao> listaCorrecoesPorPessoaDisciplinaProcesso(String nrCpf, int idProcesso, int idDisciplina) {
        
        VwRepostaCorrecaoDAO vrcd = new VwRepostaCorrecaoDAOImpl();
        return vrcd.listaCorrecoesPorPessoaDisciplinaProcesso(nrCpf, idProcesso, idDisciplina);
    }
    
}
