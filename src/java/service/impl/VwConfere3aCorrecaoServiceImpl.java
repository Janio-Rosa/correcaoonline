/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.VwConfere3aCorrecaoDAO;
import dao.impl.VwConfere3aCorrecaoDAOImpl;
import java.util.List;
import model.VwConfere3aCorrecao;
import service.VwConfere3aCorrecaoService;

/**
 *
 * @author janio
 */
public class VwConfere3aCorrecaoServiceImpl implements VwConfere3aCorrecaoService {

    @Override
    public VwConfere3aCorrecao pesquisarPorID(int id) {
        VwConfere3aCorrecaoDAO vc1cd = new VwConfere3aCorrecaoDAOImpl();
        return vc1cd.pesquisarPorID(id);
    }

    @Override
    public VwConfere3aCorrecao pesquisarPorIDLong(long id) {
        VwConfere3aCorrecaoDAO vc1cd = new VwConfere3aCorrecaoDAOImpl();
        return vc1cd.pesquisarPorIDLong(id);
    }

    @Override
    public List<VwConfere3aCorrecao> pesquisarPorDisciplinaQuestao(int idDisciplina, int nrQuestao) {
        VwConfere3aCorrecaoDAO vc1cd = new VwConfere3aCorrecaoDAOImpl();
        return vc1cd.pesquisarPorDisciplinaQuestao(idDisciplina, nrQuestao);
    }
    
}
