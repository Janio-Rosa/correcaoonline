/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.CategoriaCriterioDAO;
import dao.VwCriterioComCorrecaoCriterioDAO;
import dao.impl.CategoriaCriterioDAOImpl;
import dao.impl.VwCriterioComCorrecaoCriterioDAOImpl;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.TbCategoriaCriterio;
import model.TbCategoriaCriterioComPerda;
import model.VwCriterioComCorrecaoCriterio;
import service.VwCriterioComCorrecaoCriterioService;

/**
 *
 * @author Janio
 */
public class VwCriterioComCorrecaoCriterioServiceImpl  implements VwCriterioComCorrecaoCriterioService {

    @Override
    public List<VwCriterioComCorrecaoCriterio> pesquisarTodos() {
        VwCriterioComCorrecaoCriterioDAO rnd = new VwCriterioComCorrecaoCriterioDAOImpl();
        return rnd.pesquisarTodos();
    }

    @Override
    public VwCriterioComCorrecaoCriterio pesquisarPorID(int id) {
        VwCriterioComCorrecaoCriterioDAO rnd = new VwCriterioComCorrecaoCriterioDAOImpl();
        return rnd.pesquisarPorID(id);
    }

    @Override
    public List<VwCriterioComCorrecaoCriterio> pesquisarTodosOrdenado() {
        VwCriterioComCorrecaoCriterioDAO rnd = new VwCriterioComCorrecaoCriterioDAOImpl();
        String[] criterios = {"idCriterio"};
        return rnd.pesquisarTodosOrdenado(criterios);
    }

    @Override
    public List<VwCriterioComCorrecaoCriterio> pesquisarPorCorrecao(long idCorrecao) {
        VwCriterioComCorrecaoCriterioDAO rnd = new VwCriterioComCorrecaoCriterioDAOImpl();
        return rnd.pesquisarPorCorrecao(idCorrecao);
    }
    
    @Override
    public List<VwCriterioComCorrecaoCriterio> pesquisarPorCategoriaCriterio(int categoria){
        VwCriterioComCorrecaoCriterioDAO rnd = new VwCriterioComCorrecaoCriterioDAOImpl();
        return rnd.pesquisarPorCategoriaCriterio(categoria);
    }

    @Override
    public List<VwCriterioComCorrecaoCriterio> pesquisarPorCategoriaCriterioECorretor(int categoria,long corretor){
        VwCriterioComCorrecaoCriterioDAO rnd = new VwCriterioComCorrecaoCriterioDAOImpl();
        return rnd.pesquisarPorCategoriaCriterioECorretor(categoria,BigInteger.valueOf(corretor) );
    }
    
    @Override
    public VwCriterioComCorrecaoCriterio pesquisarPorCorrecaoCriterio(long idCorrecao, int idCriterio) {
        VwCriterioComCorrecaoCriterioDAO rnd = new VwCriterioComCorrecaoCriterioDAOImpl();
        List<VwCriterioComCorrecaoCriterio> retorno = rnd.pesquisarPorCorrecaoCriterio(idCorrecao, idCriterio);
        if(retorno==null || retorno.isEmpty())return null;
        return retorno.get(0);
    }

    @Override
    public List<VwCriterioComCorrecaoCriterio> pesquisarPorCategoriaCriterioECorretorECorrecao(int categoria, long corretor, long idCorrecao) {
        VwCriterioComCorrecaoCriterioDAO rnd = new VwCriterioComCorrecaoCriterioDAOImpl();
        return rnd.pesquisarPorCategoriaCriterioECorretorECorrecao(categoria,BigInteger.valueOf(corretor),idCorrecao );
    }

    @Override
    public List<TbCategoriaCriterioComPerda> pesquisarCategoriasPorCorrecao(long idCorrecao) {
        VwCriterioComCorrecaoCriterioDAO rnd = new VwCriterioComCorrecaoCriterioDAOImpl();
        List lista = rnd.pesquisarCategoriasPorCorrecao( idCorrecao );
        
        List<TbCategoriaCriterioComPerda> retorno = new ArrayList<TbCategoriaCriterioComPerda> ();
        
        if(lista!=null && lista.size()>0){
            Iterator iterando = lista.iterator();
            while(iterando.hasNext()){
                Object[] obj = (Object[]) iterando.next();

                CategoriaCriterioDAO ccd = new CategoriaCriterioDAOImpl();

                TbCategoriaCriterio temp=ccd.pesquisarPorID(((Integer)obj[0]).intValue());
                TbCategoriaCriterioComPerda atual = new TbCategoriaCriterioComPerda();
                atual.setIdCategoriaCriterio(temp.getIdCategoriaCriterio());atual.setNmCategoriaCriterio(temp.getNmCategoriaCriterio());atual.setNrValorMaximo(temp.getNrValorMaximo());

                //atual.setNrValorMaximo(Double.valueOf(converte) );
                atual.setNrPerdaTotal( ((Double)obj[1]).doubleValue() );

                retorno.add(atual);
            }
        }
        
        return retorno;
    }

    @Override
    public List<VwCriterioComCorrecaoCriterio> pesquisarCriteriosPorCorrecao(long idCorrecao) {
        VwCriterioComCorrecaoCriterioDAO rnd = new VwCriterioComCorrecaoCriterioDAOImpl();
        return  rnd.pesquisarCriteriosPorCorrecao(idCorrecao);
    }
    
}
