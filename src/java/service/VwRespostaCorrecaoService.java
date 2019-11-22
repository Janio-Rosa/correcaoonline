/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.math.BigInteger;
import java.util.List;
import model.VwRespostaCorrecao;

/**
 *
 * @author Janio
 */
public interface VwRespostaCorrecaoService {

    public List<VwRespostaCorrecao> pesquisarTodos() ;
    public List<VwRespostaCorrecao> pesquisarTodosOrdenado(String[] atributoOrdenar) ;
    public int quantidadePorColaborador(long idColaborador,int idProcesso ) ;
    public List<VwRespostaCorrecao> listaCorrecoesPorCorretorDisciplinaProcesso(long idColaborador,int idProcesso, int idDisciplina  ) ;
    public List<VwRespostaCorrecao> listaCorrecoesPorPessoaDisciplinaProcesso(String nrCpf,int idProcesso, int idDisciplina  ) ;
    public List<VwRespostaCorrecao> pesquisarPorIdResposta(long idResposta) ;
    public VwRespostaCorrecao pesquisarPorIDLong(long id);
    public VwRespostaCorrecao pesquisarPorIdCorrecao(long idCorrecao) ;
    public VwRespostaCorrecao pesquisarPorIdResposta(long idResposta,long idColaborador);
}
