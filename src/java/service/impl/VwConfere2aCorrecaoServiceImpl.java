/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwConfere2aCorrecaoDAO;
import dao.impl.VwConfere2aCorrecaoDAOImpl;
import java.util.List;
import model.VwConfere2aCorrecao;
import service.VwConfere2aCorrecaoService;

/**
 *
 * @author janio
 */
public class VwConfere2aCorrecaoServiceImpl implements VwConfere2aCorrecaoService {

    @Override
    public VwConfere2aCorrecao pesquisarPorID(int id) {
        VwConfere2aCorrecaoDAO vc1cd = new VwConfere2aCorrecaoDAOImpl();
        return vc1cd.pesquisarPorID(id);
    }

    @Override
    public VwConfere2aCorrecao pesquisarPorIDLong(long id) {
        VwConfere2aCorrecaoDAO vc1cd = new VwConfere2aCorrecaoDAOImpl();
        return vc1cd.pesquisarPorIDLong(id);
    }

    @Override
    public List<VwConfere2aCorrecao> pesquisarPorDisciplinaQuestao(int idDisciplina, int nrQuestao) {
        VwConfere2aCorrecaoDAO vc1cd = new VwConfere2aCorrecaoDAOImpl();
        return vc1cd.pesquisarPorDisciplinaQuestao(idDisciplina, nrQuestao);
    }
    
}
