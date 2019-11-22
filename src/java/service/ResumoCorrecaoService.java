/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TbResumoCorrecao;

/**
 *
 * @author administrator
 */
public interface ResumoCorrecaoService {

    public List<TbResumoCorrecao> pesquisarTodos() ;
    public List<TbResumoCorrecao> pesquisarTodosOrdenado() ;
    public TbResumoCorrecao inserir(TbResumoCorrecao obj) ;
    public TbResumoCorrecao atualizar(TbResumoCorrecao obj) ;
    public TbResumoCorrecao pesquisarPorID(int id) ;
    public TbResumoCorrecao pesquisarPorIDLong(long id) ;
    public List<TbResumoCorrecao> pesquisarPorIdResposta(long idResposta);
    public TbResumoCorrecao pesquisarPorRespostaColaborador(long idResposta,long colaborador) ;
    public TbResumoCorrecao pesquisarPorRespostaTipoCorrecao(long idResposta, int tipo);
    public TbResumoCorrecao pesquisarPorRespostaColaborador(long idResposta, long colaborador,int tipoCorrecao);    
}
