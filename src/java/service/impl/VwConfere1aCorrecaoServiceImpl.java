/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwConfere1aCorrecaoDAO;
import dao.impl.VwConfere1aCorrecaoDAOImpl;
import java.util.List;
import model.VwConfere1aCorrecao;
import service.VwConfere1aCorrecaoService;

/**
 *
 * @author janio
 */
public class VwConfere1aCorrecaoServiceImpl implements VwConfere1aCorrecaoService {

    @Override
    public VwConfere1aCorrecao pesquisarPorID(int id) {
        VwConfere1aCorrecaoDAO vc1cd = new VwConfere1aCorrecaoDAOImpl();
        return vc1cd.pesquisarPorID(id);
    }

    @Override
    public VwConfere1aCorrecao pesquisarPorIDLong(long id) {
        VwConfere1aCorrecaoDAO vc1cd = new VwConfere1aCorrecaoDAOImpl();
        return vc1cd.pesquisarPorIDLong(id);
    }

    @Override
    public List<VwConfere1aCorrecao> pesquisarPorDisciplinaQuestao(int idDisciplina, int nrQuestao) {
        VwConfere1aCorrecaoDAO vc1cd = new VwConfere1aCorrecaoDAOImpl();
        return vc1cd.pesquisarPorDisciplinaQuestao(idDisciplina, nrQuestao);
    }
    
}
