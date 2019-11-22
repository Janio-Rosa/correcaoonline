/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TbResumoCorrecao;

/**
 *
 * @author administrator
 */
public interface ResumoCorrecaoDAO {

    public List<TbResumoCorrecao> pesquisarTodos() ;
    public List<TbResumoCorrecao> pesquisarTodosOrdenado(String[] ordena) ;
    public TbResumoCorrecao inserir(TbResumoCorrecao obj) ;
    public TbResumoCorrecao atualizar(TbResumoCorrecao obj) ;
    public TbResumoCorrecao pesquisarPorID(int id) ;
    public TbResumoCorrecao pesquisarPorIDLong(long id) ;
    public List<TbResumoCorrecao> pesquisarPorIdResposta(long idResposta);
    public TbResumoCorrecao pesquisarPorRespostaColaborador(long idResposta,long colaborador) ;
    public TbResumoCorrecao pesquisarPorRespostaTipoCorrecao(long idResposta, int tipo);
    public TbResumoCorrecao pesquisarPorRespostaColaborador(long idResposta, long colaborador,int tipoCorrecao);
}
