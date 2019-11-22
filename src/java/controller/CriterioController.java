/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;
import model.TbCategoriaCriterio;
import model.TbCorrecaoCriterio;
import model.TbCriterio;
import model.TbDisciplina;
import model.TbGeneroCategoria;
import model.TbQuestao;
import model.VwCategoriaCriterio;
import model.VwCriterioComCorrecaoCriterio;
import service.CriterioService;
import service.GeneroCategoriaService;
import service.VwCategoriaCriterioService;
import service.impl.CategoriaCriterioServiceImpl;
import service.impl.CorrecaoCriterioServiceImpl;
import service.impl.CriterioServiceImpl;
import service.impl.GeneroCategoriaServiceImpl;
import service.impl.VwCategoriaCriterioServiceImpl;
import service.impl.VwCriterioComCorrecaoCriterioServiceImpl;
import util.Uteis;

/**
 *
 * @author Janio
 */
@ManagedBean(name = "CriterioController")
@SessionScoped
public final class CriterioController extends BasicController {

    private List<VwCriterioComCorrecaoCriterio> listaCriterios = null;
    private List<VwCriterioComCorrecaoCriterio> listaCriteriosQ1 = null;
    private List<VwCriterioComCorrecaoCriterio> listaCriteriosQ2 = null;
    private List<VwCriterioComCorrecaoCriterio> listaCriteriosQ3 = null;
    private List<VwCriterioComCorrecaoCriterio> listaCriteriosQ4 = null;
    private List<TbCorrecaoCriterio> criteriosJacorrigidos = null;
    private List<TbCategoriaCriterio> listaCategoriaCriterios = null;
    private TbCategoriaCriterio categoriaSelecionada = new TbCategoriaCriterio();
    private TbCategoriaCriterio categoriaSelecionadaFiltro = new TbCategoriaCriterio();
    private TbDisciplina disciplinaSelecionadaFiltro = new TbDisciplina();
    private TbQuestao questaoSelecionadaFiltro = new TbQuestao();
    private List<TbGeneroCategoria> listaGeneros = new ArrayList<TbGeneroCategoria>();
    private List<TbCriterio> listaCriteriosErrosGraves = null;
    private TbGeneroCategoria generoSelecionado = new TbGeneroCategoria();
    private TbCriterio inserirCriterio = new TbCriterio();
    private DataModel gridCriterios;
    private int idCatCriterio;
    private int idDisciplina;
    private int idQuestao;
    private boolean flCritNegativo;

    public CriterioController() {
        this.verificaGeneroCorrecaoAtualERecarregaCriterios();
        this.consultaListaCriteriosDemaisQuestoes(false);
    }

    public static CriterioController getInstance() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Object temp = session.getAttribute("CriterioController");
        if (temp instanceof CriterioController) {
            CriterioController pc = (CriterioController) temp;
            return pc;
        }
        return null;
    }

    public void consultaListaCategoriaCriterios() {
        this.consultaListaCategoriaCriterios(false);
    }

    public void consultaListaCategoriaCriterios(boolean mudaCategoriaSelecionada) {
        if (this.generoSelecionado != null && this.generoSelecionado.getIdGeneroCategoria() != 0) {
            //System.out.println("Consultando categorias - Gênero selecionado: "+this.generoSelecionado);
            this.listaCategoriaCriterios = (new CategoriaCriterioServiceImpl()).pesquisarPorGeneros(this.generoSelecionado, false);
            //for(TbCategoriaCriterio atual : this.listaCategoriaCriterios){
                //System.out.println("Categoria selecionada: "+atual);
            //}
        }

        if (UsuarioController.getInstance() != null) {
            UsuarioController uc = UsuarioController.getInstance();
            if(uc!=null && uc.getColaboradorLogado()!=null && uc.getColaboradorLogado().getIdBanca()!=null && uc.getColaboradorLogado().getIdBanca().getIdDisciplina()!=null){
                if ((uc.getColaboradorLogado().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DISCURSIVA)
                        || (uc.getColaboradorLogado().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA)
                        || (uc.getColaboradorLogado().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE)
                        || (uc.getColaboradorLogado().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA)) {
                    this.categoriaSelecionada = (new CategoriaCriterioServiceImpl()).pesquisarPorID(Uteis.CATEGORIA_CRITERIO_DISCURSIVA);
                } else if (mudaCategoriaSelecionada) {
                    if (this.listaCategoriaCriterios!=null && this.listaCategoriaCriterios.size() > 0) {
                        this.categoriaSelecionada = this.listaCategoriaCriterios.get(0);
                    }
                }
            //}catch(Exception ex){

            }
        } else {
            if (this.listaCategoriaCriterios != null && mudaCategoriaSelecionada) {
                if (this.listaCategoriaCriterios.size() > 0) {
                    this.categoriaSelecionada = this.listaCategoriaCriterios.get(0);
                }
            }
        }
    }

    private void consultaListaCategoriaCriteriosErrosGraves() { //Consulta somente os critérios de penalização de erro grave
        List<TbCategoriaCriterio> listaCategoriaErroGrave = (new CategoriaCriterioServiceImpl()).pesquisarPorErroPenalizacao(true);
        List<TbCriterio> listaCriteriosPenalizacao = new ArrayList<TbCriterio>();
        if (listaCategoriaErroGrave != null) {
            for (TbCategoriaCriterio atual : listaCategoriaErroGrave) {
                List<TbCriterio> listaAtual = (new CriterioServiceImpl()).pesquisarPorCategoriaCriterio(atual.getIdCategoriaCriterio());
                if (listaAtual != null) {
                    listaCriteriosPenalizacao.addAll(listaAtual);
                }
            }
        }
        this.listaCriteriosErrosGraves = listaCriteriosPenalizacao;
    }

    public void consultaListaCriterios() {
        //this.consultaListaCategoriaCriterios(false);
        this.consultaListaCriterios(true);
    }

    public void consultaListaCriterios(boolean forcaRecargaCriterios) { //Consulta os criterios de correção
        //System.out.println("CATEGORIA SELECIONADA: " + this.getCategoriaSelecionada().getIdCategoriaCriterio());
        this.consultaListaCategoriaCriterios(false);
        if (this.listaCriterios == null || forcaRecargaCriterios) {
            this.listaCriterios = new ArrayList<VwCriterioComCorrecaoCriterio>();
            //List<VwCriterioComCorrecaoCriterio> consulta = (new  VwCriterioComCorrecaoCriterioServiceImpl()).pesquisarPorCategoriaCriterio(this.getCategoriaSelecionada().getIdCategoriaCriterio());
            //List<VwCriterioComCorrecaoCriterio> consulta = (new  VwCriterioComCorrecaoCriterioServiceImpl()).pesquisarPorCategoriaCriterioECorretor(this.getCategoriaSelecionada().getIdCategoriaCriterio(),CorrecaoController.getInstance().getColaborador().getIdColaborador().longValue());
            //List<TbCriterio> listaTemp = (new CriterioServiceImpl()).pesquisarPorCategoriaCriterio(this.getCategoriaSelecionada().getIdCategoriaCriterio());

            //List<VwCriterioComCorrecaoCriterio> consulta = (new  VwCriterioComCorrecaoCriterioServiceImpl()).pesquisarPorCategoriaCriterioECorretor(this.getCategoriaSelecionada().getIdCategoriaCriterio(),UsuarioController.getInstance().getColaboradorLogado().getIdColaborador().longValue());

            //Critérios com correção - pesquisa as correções de cada critério
            CorrecaoController cc = CorrecaoController.getInstance();
            List<VwCriterioComCorrecaoCriterio> corrigidos = null;
            this.setCriteriosJacorrigidos(null);
            if (cc != null && cc.getCorrecaoAtual() != null) {

                //corrigidos = (new VwCriterioComCorrecaoCriterioServiceImpl()).pesquisarPorCategoriaCriterioECorretorECorrecao(this.getCategoriaSelecionada().getIdCategoriaCriterio(), UsuarioController.getInstance().getColaboradorLogado().getIdColaborador().longValue(), cc.getCorrecaoAtual().getIdCorrecao().longValue());
                corrigidos = (new VwCriterioComCorrecaoCriterioServiceImpl()).pesquisarPorCategoriaCriterioECorretorECorrecao(this.getCategoriaSelecionada().getIdCategoriaCriterio(), CorrecaoController.getInstance().getColaborador().getIdColaborador().longValue(), cc.getCorrecaoAtual().getIdCorrecao().longValue());

                //this.setCriteriosJacorrigidos((new VwCriterioComCorrecaoCriterioServiceImpl()).pesquisarPorCorrecao(cc.getCorrecaoAtual().getIdCorrecao().longValue()) );
                this.setCriteriosJacorrigidos((new CorrecaoCriterioServiceImpl()).pesquisarPorCorrecao(cc.getCorrecaoAtual().getIdCorrecao().longValue()));
            }

            //Critérios cadastrados - não necessariamente todos os critérios cadastrados tiveram correção
            //BUSCA DE CRITÉRIOS - ALTERADO POR JÂNIO EM 22/05/2012 / Acréscimo do número da questão na busca de critérios. Pois os critérios serão definidos por questão.
            //List<TbCriterio> listaTemp = (new CriterioServiceImpl()).pesquisarPorCategoriaCriterioEDisciplina(this.getCategoriaSelecionada().getIdCategoriaCriterio(), UsuarioController.getInstance().getColaboradorLogado().getIdBanca().getIdDisciplina().getIdDisciplina().intValue());
            List<TbCriterio> listaTemp = (new CriterioServiceImpl()).pesquisarPorCategoriaCriterioEDisciplinaEQuestao(this.getCategoriaSelecionada().getIdCategoriaCriterio(), UsuarioController.getInstance().getColaboradorLogado().getIdBanca().getIdDisciplina().getIdDisciplina().intValue(), UsuarioController.getInstance().getColaboradorLogado().getIdQuestao().getIdQuestao().intValue());


            for (TbCriterio atual : listaTemp) {
                VwCriterioComCorrecaoCriterio adiciona = new VwCriterioComCorrecaoCriterio();
                adiciona.setIdCorrecao(BigInteger.ZERO);
                if (corrigidos != null) {
                    if (!cc.getCandidatoAtual().getFlDiscrepancia() || cc.getCorrecaoAtual().getIdTipoCorrecao().getIdTipoCorrecao().intValue() == Uteis.TIPO_CORRECAO_DISCREPANCIA) {
                        for (VwCriterioComCorrecaoCriterio temp : corrigidos) {
                            if (atual.getIdCriterio().intValue() == temp.getIdCriterio().intValue()) {
                                adiciona.setIdCorrecao(temp.getIdCorrecao());
                                adiciona.setNrNota(temp.getNrNota().doubleValue());
                                adiciona.setNrValor(temp.getNrValor().doubleValue());
                                adiciona.setNrLinha(temp.getNrLinha().intValue());
                                adiciona.setDsJustificativa(temp.getDsJustificativa());
                            }
                        }
                    }
                }
                adiciona.setFlCriterioNegativo(atual.getFlCriterioNegativo());
                adiciona.setIdCategoriaCriterio(atual.getIdCategoriaCriterio());
                adiciona.setIdCriterio(atual.getIdCriterio());
                adiciona.setIdDisciplina(atual.getIdDisciplina().getIdDisciplina());
                adiciona.setNmCriterio(atual.getNmCriterio());
                adiciona.setDsCriterio(atual.getDsCriterio());
                adiciona.setNrValorMaximo(atual.getNrValorMaximo());

                this.listaCriterios.add(adiciona);

            }

        }
        UsuarioController uc = UsuarioController.getInstance();
        if (uc != null) {
            if (uc.getColaboradorLogado().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA) {
                this.consultaListaCriteriosDemaisQuestoes(true);
            }
        }

    }

    public void ativaDesativaCriterio() {
        this.setMensagem("");
        if (this.gridCriterios.isRowAvailable()) {
            VwCategoriaCriterio selecionada = (VwCategoriaCriterio) this.gridCriterios.getRowData();

            CriterioService cs = new CriterioServiceImpl();

            TbCriterio criAtual = cs.pesquisarPorID(selecionada.getIdCriterio().intValue());

            criAtual.setFlAtivo(selecionada.getFlAtivo());

            cs.atualizar(criAtual);

            this.setMensagem("Critério " + (criAtual.getFlAtivo() ? "ativado" : "desativado") + " com sucesso.");
        }
    }

    public List<TbCategoriaCriterio> getListaCategoriaCriterios() {
        //this.consultaListaCategoriaCriterios();
        return listaCategoriaCriterios;
    }

    public void setListaCategoriaCriterios(List<TbCategoriaCriterio> listaCategoriaCriterios) {
        this.listaCategoriaCriterios = listaCategoriaCriterios;
    }

    public List<VwCriterioComCorrecaoCriterio> getListaCriterios() {
        return listaCriterios;
    }

    public void setListaCriterios(List<VwCriterioComCorrecaoCriterio> listaCriterios) {
        this.listaCriterios = listaCriterios;
    }

    public TbCategoriaCriterio getCategoriaSelecionadaFiltro() {
        return categoriaSelecionadaFiltro;
    }

    public void setCategoriaSelecionadaFiltro(TbCategoriaCriterio categoriaSelecionadaFiltro) {
        this.categoriaSelecionadaFiltro = categoriaSelecionadaFiltro;
    }

    public TbCategoriaCriterio getCategoriaSelecionada() {
        return categoriaSelecionada;
    }

    public void setCategoriaSelecionada(TbCategoriaCriterio categoriaSelecionada) {
        this.categoriaSelecionada = categoriaSelecionada;
    }

    public boolean isFlCritNegativo() {
        return flCritNegativo;
    }

    public void setFlCritNegativo(boolean flCritNegativo) {
        this.flCritNegativo = flCritNegativo;
    }

    public String selecionaCategoriaCriterio() {
        CorrecaoController.getInstance().setMensNotaCriterio("");
        this.consultaListaCriterios(true);
        return "/view/corretor/redacao/corretor.xhtml";
    }

    public String selecionaCategoriaCriterio(int idCategoria, String nmCategoria) {
        //System.out.println("CATEGORIA SELECIONADA id: " + idCategoria + " nome: " + nmCategoria);
        CorrecaoController.getInstance().setMensNotaCriterio("");
        this.getCategoriaSelecionada().setIdCategoriaCriterio(idCategoria);
        this.getCategoriaSelecionada().setNmCategoriaCriterio(nmCategoria);
        this.consultaListaCriterios(true);
        return "/view/corretor/redacao/corretor.xhtml";
    }

    public String insereCriterio() {
        CriterioService cs = new CriterioServiceImpl();
        this.getInserirCriterio().setIdCategoriaCriterio(this.getIdCatCriterio());
        this.getInserirCriterio().setIdDisciplina(new TbDisciplina(this.getIdDisciplina()));
        this.getInserirCriterio().setIdQuestao(new TbQuestao(this.getIdQuestao()));
        TbCriterio crit = cs.inserir(this.getInserirCriterio());

        this.setMensagem("Erro ao inserir Critério.");
        if (crit != null) {
            this.setMensagem("Critério inserido com sucesso.");
        }
        //this.getListaTodosCriterios();
        this.getListaTodosCriteriosPorFiltro();
        this.inserirCriterio = new TbCriterio();
        return "/view/admin/cadastro/criterio.xhtml";
    }

    public void getListaTodosCriterios() {
        //CriterioService cs = new CriterioServiceImpl();
        VwCategoriaCriterioService vccs = new VwCategoriaCriterioServiceImpl();
        this.gridCriterios = new ListDataModel(vccs.pesquisarTodosOrdenado());
    }

    /**
     * Esse metodo está errado, tenho pegar um criterio pra depois excluir
     * @return 
     */
    public String excluirCriterio() {
        VwCategoriaCriterio selecionada = (VwCategoriaCriterio) this.gridCriterios.getRowData();
        TbCriterio nova = new TbCriterio();
        CriterioService cs = new CriterioServiceImpl();
        nova.setIdCriterio(selecionada.getIdCriterio());
        nova.setNmCriterio(selecionada.getNmCriterio());
        nova.setIdDisciplina(new TbDisciplina(selecionada.getIdDisciplina()));
        cs.apagar(nova);
        this.getListaTodosCriterios();
        return "/view/admin/cadastro/criterio.xhtml";
    }

    public String prepararAlterar() {
        this.setMensagem("");
        CriterioService cs = new CriterioServiceImpl();
        VwCategoriaCriterio selecionada = (VwCategoriaCriterio) this.gridCriterios.getRowData();
        this.idCatCriterio = selecionada.getIdCategoriaCriterio();
        this.idDisciplina = selecionada.getIdDisciplina();
        this.idQuestao = selecionada.getIdQuestao();
        this.inserirCriterio = cs.pesquisarPorID(selecionada.getIdCriterio());
        return "/view/admin/altera/criterio.xhtml";
    }

    public String gravaAlteracao() {
        CriterioService cs = new CriterioServiceImpl();
        this.inserirCriterio.setIdDisciplina(new TbDisciplina(this.idDisciplina));
        this.inserirCriterio.setIdCategoriaCriterio(this.idCatCriterio);
        this.inserirCriterio.setIdQuestao(new TbQuestao(this.getIdQuestao()));
        cs.atualizar(this.inserirCriterio);
        this.setMensagem("Critério alterado com sucesso.");
        this.inserirCriterio = new TbCriterio();
        //this.getListaTodosCriterios();
        this.getListaTodosCriteriosPorFiltro();
        return "/view/admin/cadastro/criterio.xhtml";
    }

    public DataModel getGridCriterios() {
        if (this.gridCriterios == null) {
            this.getListaTodosCriterios();
        }
        return gridCriterios;
    }

    public void setGridCriterios(DataModel gridCriterios) {
        this.gridCriterios = gridCriterios;
    }

    public TbCriterio getInserirCriterio() {
        return inserirCriterio;
    }

    public void setInserirCriterio(TbCriterio inserirCriterio) {
        this.inserirCriterio = inserirCriterio;
    }

    public int getIdCatCriterio() {
        return idCatCriterio;
    }

    public void setIdCatCriterio(int idCatCriterio) {
        this.idCatCriterio = idCatCriterio;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNomeCriterioNaMemoriaById(int idCriterio) {
        for (VwCriterioComCorrecaoCriterio atual : this.listaCriterios) {
            if (atual.getIdCriterio().intValue() == idCriterio) {
                return atual.getNmCriterio();
            }
        }

        return "";
    }

    public TbCriterio getCriterioNaMemoriaById(int idCriterio) {
        for (VwCriterioComCorrecaoCriterio atual : this.listaCriterios) {
            if (atual.getIdCriterio().intValue() == idCriterio) {
                TbCriterio retorno = new TbCriterio();
                retorno.setIdCategoriaCriterio(atual.getIdCategoriaCriterio());
                retorno.setFlCriterioNegativo(atual.getFlCriterioNegativo());
                retorno.setIdCriterio(atual.getIdCriterio());
                retorno.setIdDisciplina(new TbDisciplina(atual.getIdDisciplina()));
                retorno.setNmCriterio(atual.getNmCriterio());
                retorno.setDsCriterio(atual.getDsCriterio());
                retorno.setNrValorMaximo(atual.getNrValorMaximo());
                return retorno;
            }
        }

        return null;
    }

    public TbCriterio getCriterioNaMemoriaByIdArquitetura(int idCriterio) {
        TbCriterio retorno = null;
        for (VwCriterioComCorrecaoCriterio atual : this.listaCriterios) {
            if (atual.getIdCriterio().intValue() == idCriterio) {
                retorno = new TbCriterio();
                retorno.setIdCategoriaCriterio(atual.getIdCategoriaCriterio());
                retorno.setFlCriterioNegativo(atual.getFlCriterioNegativo());
                retorno.setIdCriterio(atual.getIdCriterio());
                retorno.setIdDisciplina(new TbDisciplina(atual.getIdDisciplina()));
                retorno.setNmCriterio(atual.getNmCriterio());
                retorno.setDsCriterio(atual.getDsCriterio());
                retorno.setNrValorMaximo(atual.getNrValorMaximo());
                return retorno;
            }
        }
        if (retorno == null) {
            for (VwCriterioComCorrecaoCriterio atual : this.listaCriteriosQ1) {
                if (atual.getIdCriterio().intValue() == idCriterio) {
                    retorno = new TbCriterio();
                    retorno.setIdCategoriaCriterio(atual.getIdCategoriaCriterio());
                    retorno.setFlCriterioNegativo(atual.getFlCriterioNegativo());
                    retorno.setIdCriterio(atual.getIdCriterio());
                    retorno.setIdDisciplina(new TbDisciplina(atual.getIdDisciplina()));
                    retorno.setNmCriterio(atual.getNmCriterio());
                    retorno.setDsCriterio(atual.getDsCriterio());
                    retorno.setNrValorMaximo(atual.getNrValorMaximo());
                    return retorno;
                }
            }
        }
        if (retorno == null) {
            for (VwCriterioComCorrecaoCriterio atual : this.listaCriteriosQ2) {
                if (atual.getIdCriterio().intValue() == idCriterio) {
                    retorno = new TbCriterio();
                    retorno.setIdCategoriaCriterio(atual.getIdCategoriaCriterio());
                    retorno.setFlCriterioNegativo(atual.getFlCriterioNegativo());
                    retorno.setIdCriterio(atual.getIdCriterio());
                    retorno.setIdDisciplina(new TbDisciplina(atual.getIdDisciplina()));
                    retorno.setNmCriterio(atual.getNmCriterio());
                    retorno.setDsCriterio(atual.getDsCriterio());
                    retorno.setNrValorMaximo(atual.getNrValorMaximo());
                    return retorno;
                }
            }
        }
        if (retorno == null) {
            for (VwCriterioComCorrecaoCriterio atual : this.listaCriteriosQ3) {
                if (atual.getIdCriterio().intValue() == idCriterio) {
                    retorno = new TbCriterio();
                    retorno.setIdCategoriaCriterio(atual.getIdCategoriaCriterio());
                    retorno.setFlCriterioNegativo(atual.getFlCriterioNegativo());
                    retorno.setIdCriterio(atual.getIdCriterio());
                    retorno.setIdDisciplina(new TbDisciplina(atual.getIdDisciplina()));
                    retorno.setNmCriterio(atual.getNmCriterio());
                    retorno.setDsCriterio(atual.getDsCriterio());
                    retorno.setNrValorMaximo(atual.getNrValorMaximo());
                    return retorno;
                }
            }
        }
        if (retorno == null) {
            for (VwCriterioComCorrecaoCriterio atual : this.listaCriteriosQ4) {
                if (atual.getIdCriterio().intValue() == idCriterio) {
                    retorno = new TbCriterio();
                    retorno.setIdCategoriaCriterio(atual.getIdCategoriaCriterio());
                    retorno.setFlCriterioNegativo(atual.getFlCriterioNegativo());
                    retorno.setIdCriterio(atual.getIdCriterio());
                    retorno.setIdDisciplina(new TbDisciplina(atual.getIdDisciplina()));
                    retorno.setNmCriterio(atual.getNmCriterio());
                    retorno.setDsCriterio(atual.getDsCriterio());
                    retorno.setNrValorMaximo(atual.getNrValorMaximo());
                    return retorno;
                }
            }
        }
        return null;
    }

    public void selecionouCategoria() {
        this.getListaTodosCriteriosPorFiltro();
    }

    public void selecionouDisciplina() {
        this.getListaTodosCriteriosPorFiltro();
    }

    public void selecionouQuestao() {
        this.getListaTodosCriteriosPorFiltro();
    }

    public void getListaTodosCriteriosPorFiltro() {
        VwCategoriaCriterioService vcc = new VwCategoriaCriterioServiceImpl();
        List<VwCategoriaCriterio> vwcc = null;
        int questao = (questaoSelecionadaFiltro == null || questaoSelecionadaFiltro.getIdQuestao() == null) ? 0 : questaoSelecionadaFiltro.getIdQuestao();
        int disciplina = (this.getDisciplinaSelecionadaFiltro() == null || this.getDisciplinaSelecionadaFiltro().getIdDisciplina() == null) ? 0 : this.getDisciplinaSelecionadaFiltro().getIdDisciplina().intValue();
        int categoria = (this.getCategoriaSelecionadaFiltro() == null) ? 0 : this.getCategoriaSelecionadaFiltro().getIdCategoriaCriterio();
        //System.out.println("Disciplina: "+disciplina+" Questão: "+questao+" Categoria: "+categoria);
        vwcc = vcc.pesquisarPorQuestaoDisciplinaCategoria(questao, disciplina, categoria);
        this.gridCriterios = new ListDataModel(vwcc);
    }

    public List<TbCriterio> getListaCriteriosErrosGraves() {
        return listaCriteriosErrosGraves;
    }

    public void setListaCriteriosErrosGraves(List<TbCriterio> listaCriteriosErrosGraves) {
        this.listaCriteriosErrosGraves = listaCriteriosErrosGraves;
    }

    public List<TbGeneroCategoria> getListaGeneros() {
        return listaGeneros;
    }

    public void setListaGeneros(List<TbGeneroCategoria> listaGeneros) {
        this.listaGeneros = listaGeneros;
    }

    private void consultaGeneros() {
        if (this.listaGeneros != null) {
            GeneroCategoriaService gcs = new GeneroCategoriaServiceImpl();
            this.listaGeneros = gcs.pesquisarTodosSemGeral();
            //this.listaGeneros=gcs.pesquisarTodosSemGeralPorTipoQuestao(UsuarioController.getInstance().getColaboradorLogado().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao());
            //System.out.println("Tipo de questão: "+UsuarioController.getInstance().getColaboradorLogado().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao());
            if (this.listaGeneros != null) {
                //this.setGeneroSelecionado(this.listaGeneros.get(0));
            }
        }
    }

    public String atualizaGenero() {
        GeneroCategoriaService gcs = new GeneroCategoriaServiceImpl();
        int idGeneroSelecionado = this.getGeneroSelecionado().getIdGeneroCategoria();
        this.setGeneroSelecionado(gcs.pesquisarPorID(idGeneroSelecionado));

        this.consultaListaCategoriaCriterios(true);
        this.consultaListaCriterios();
        //System.out.println("Genero selecionado: "+this.getGeneroSelecionado().getIdGeneroCategoria() );
        if (CorrecaoController.getInstance() != null) {
            CorrecaoController.getInstance().setMensNotaCriterio("Genero selecionado: " + this.getGeneroSelecionado().getNmGeneroCategoria());
        }

        //Altera o objeto gênero, para que o nome também se atualize, conforme o gênero selecionado (sem isto, só o ID muda conforme a seleção do combobox)

        //this.consultaListaCategoriaCriteriosErrosGraves();
        return "/view/corretor/redacao/corretor.xhtml";
    }

    public TbGeneroCategoria getGeneroSelecionado() {
        return generoSelecionado;
    }

    public void setGeneroSelecionado(TbGeneroCategoria generoSelecionado) {
        this.generoSelecionado = generoSelecionado;
    }

    public String preparaCadastrarCriterio() {
        this.inserirCriterio = new TbCriterio();
        return "/view/admin/cadastro/criterio.xhtml";
    }

    private void consultaGeneroECategoriaECriterios(boolean consultarGenero) {
        if (consultarGenero) {
            this.consultaGeneros();
            if (this.listaGeneros != null) {
                if (UsuarioController.getInstance() != null) {
                    //Modificado por Jânio em 12/11/2012 para adicionar o tratamento à questões de Habilidade Específica
                    //System.out.println("Seleção de gênero - Tipo questão: "+UsuarioController.getInstance().getColaboradorLogado().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao());
                    if (UsuarioController.getInstance().getColaboradorLogado().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA
                            || UsuarioController.getInstance().getColaboradorLogado().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA_TRADUCAO_ESTILO_REDACAO 
                            || UsuarioController.getInstance().getColaboradorLogado().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA) {
                        this.setGeneroSelecionado((new GeneroCategoriaServiceImpl()).pesquisarPorID(Uteis.GENERO_CATEGORIA_HABILIDADE_ESPECIFICA_ID));
                    } else {
                        //this.setGeneroSelecionado(this.listaGeneros.get(0));
                        if (UsuarioController.getInstance().getColaboradorLogado().getIdBanca().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_RECACAO){
                            this.setGeneroSelecionado(new TbGeneroCategoria());
                        }else{
                            this.setGeneroSelecionado(this.listaGeneros.get(0));
                        }
                        
                    }
                } else {
                    this.setGeneroSelecionado(this.listaGeneros.get(0));
                }
            }
        }
        this.consultaListaCategoriaCriterios(true); //Consulta categoria
        this.consultaListaCategoriaCriteriosErrosGraves(); //Consulta categorias de erros graves
        this.getListaTodosCriterios(); //Consulta critérios disponíveis
        this.consultaListaCriterios(true); //Consulta critérios referentes à correção atual
    }

    private void consultaGeneroECategoriaECriterios() {
        this.consultaGeneroECategoriaECriterios(true);
    }

    public boolean verificaGeneroCorrecaoAtualERecarregaCriterios() { //Se o gênero da resposta atual for DISCURSIVA, então procura somente pelo gênero da discursiva.
        this.listaCriterios = null;
        CorrecaoController cc = CorrecaoController.getInstance();
        if (cc != null && cc.getCandidatoAtual() != null) {
            if (cc.getCandidatoAtual().getIdDisciplina() != null && cc.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao() != null) {
                //Na discursiva só existe um gênero.
                if ((cc.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DISCURSIVA)
                        || (cc.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_HABILIDADE_ESPECIFICA)
                        || (cc.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_DOCENTE)
                        || (cc.getCandidatoAtual().getIdDisciplina().getIdTipoQuestao().getIdTipoQuestao() == Uteis.TIPO_QUESTAO_TEATRO_DANCA_MUSICA)) {
                    this.generoSelecionado = new TbGeneroCategoria(Uteis.GENERO_CATEGORIA_DISCURSIVA_ID);
                    this.generoSelecionado.setNmGeneroCategoria(Uteis.GENERO_CATEGORIA_DISCURSIVA_NOME);
                    this.listaGeneros = new ArrayList<TbGeneroCategoria>();
                    this.listaGeneros.add(generoSelecionado);
                    this.consultaGeneroECategoriaECriterios(false);
                } else { //Na redação existem vários gêneros, então carrega todos e escolhe o primeiro como padrão. Assim o primeiro gênero aparece primeiro, selecionado
                    this.consultaGeneroECategoriaECriterios();
                }
            }
        }
        return true;
    }

    public List<TbCorrecaoCriterio> getCriteriosJacorrigidos() {
        return criteriosJacorrigidos;
    }

    public void setCriteriosJacorrigidos(List<TbCorrecaoCriterio> criteriosJacorrigidos) {
        this.criteriosJacorrigidos = criteriosJacorrigidos;
    }

    public int getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(int idQuestao) {
        this.idQuestao = idQuestao;
    }

    public TbDisciplina getDisciplinaSelecionadaFiltro() {
        return disciplinaSelecionadaFiltro;
    }

    public void setDisciplinaSelecionadaFiltro(TbDisciplina disciplinaSelecionadaFiltro) {
        this.disciplinaSelecionadaFiltro = disciplinaSelecionadaFiltro;
    }

    public TbQuestao getQuestaoSelecionadaFiltro() {
        return questaoSelecionadaFiltro;
    }

    public void setQuestaoSelecionadaFiltro(TbQuestao questaoSelecionadaFiltro) {
        this.questaoSelecionadaFiltro = questaoSelecionadaFiltro;
    }

    public List<VwCriterioComCorrecaoCriterio> getListaCriteriosQ1() {
        return listaCriteriosQ1;
    }

    public List<VwCriterioComCorrecaoCriterio> getListaCriteriosQ2() {
        return listaCriteriosQ2;
    }

    public List<VwCriterioComCorrecaoCriterio> getListaCriteriosQ3() {
        return listaCriteriosQ3;
    }

    public List<VwCriterioComCorrecaoCriterio> getListaCriteriosQ4() {
        return listaCriteriosQ4;
    }

    public void consultaListaCriteriosDemaisQuestoes(boolean forcaRecargaCriterios) {
        this.consultaListaCategoriaCriterios(false);
        int idConsultaDisciplina=0;
        UsuarioController uc= UsuarioController.getInstance();
        if (this.listaCriteriosQ1 == null || forcaRecargaCriterios) {
            this.listaCriteriosQ1 = new ArrayList<VwCriterioComCorrecaoCriterio>();
            List<TbCriterio> listaTemp = null;
            if(uc!=null && uc.getColaboradorLogado()!=null && uc.getColaboradorLogado().getIdBanca() !=null && uc.getColaboradorLogado().getIdBanca().getIdDisciplina()!=null ){
                idConsultaDisciplina=UsuarioController.getInstance().getColaboradorLogado().getIdBanca().getIdDisciplina().getIdDisciplina().intValue();
            }
            listaTemp = (new CriterioServiceImpl()).pesquisarPorCategoriaCriterioEDisciplinaEQuestao(this.getCategoriaSelecionada().getIdCategoriaCriterio(), idConsultaDisciplina, Uteis.QUESTAO1);
            if(listaTemp!=null && listaTemp.size()>0) {
                for (TbCriterio atual : listaTemp) {
                    VwCriterioComCorrecaoCriterio adiciona = new VwCriterioComCorrecaoCriterio();
                    adiciona.setIdCorrecao(BigInteger.ZERO);
                    adiciona.setFlCriterioNegativo(atual.getFlCriterioNegativo());
                    adiciona.setIdCategoriaCriterio(atual.getIdCategoriaCriterio());
                    adiciona.setIdCriterio(atual.getIdCriterio());
                    adiciona.setIdDisciplina(atual.getIdDisciplina().getIdDisciplina());
                    adiciona.setNmCriterio(atual.getNmCriterio());
                    adiciona.setDsCriterio(atual.getDsCriterio());
                    adiciona.setNrValorMaximo(atual.getNrValorMaximo());

                    this.listaCriteriosQ1.add(adiciona);

                }
            }
        }
        if (this.listaCriteriosQ2 == null || forcaRecargaCriterios) {
            this.listaCriteriosQ2 = new ArrayList<VwCriterioComCorrecaoCriterio>();
            if( idConsultaDisciplina==0 && uc!=null && uc.getColaboradorLogado()!=null && uc.getColaboradorLogado().getIdBanca() !=null && uc.getColaboradorLogado().getIdBanca().getIdDisciplina()!=null ){
                idConsultaDisciplina=UsuarioController.getInstance().getColaboradorLogado().getIdBanca().getIdDisciplina().getIdDisciplina().intValue();
            }
            List<TbCriterio> listaTemp = (new CriterioServiceImpl()).pesquisarPorCategoriaCriterioEDisciplinaEQuestao(this.getCategoriaSelecionada().getIdCategoriaCriterio(), idConsultaDisciplina, Uteis.QUESTAO2);
            for (TbCriterio atual : listaTemp) {
                VwCriterioComCorrecaoCriterio adiciona = new VwCriterioComCorrecaoCriterio();
                adiciona.setIdCorrecao(BigInteger.ZERO);
                adiciona.setFlCriterioNegativo(atual.getFlCriterioNegativo());
                adiciona.setIdCategoriaCriterio(atual.getIdCategoriaCriterio());
                adiciona.setIdCriterio(atual.getIdCriterio());
                adiciona.setIdDisciplina(atual.getIdDisciplina().getIdDisciplina());
                adiciona.setNmCriterio(atual.getNmCriterio());
                adiciona.setDsCriterio(atual.getDsCriterio());
                adiciona.setNrValorMaximo(atual.getNrValorMaximo());

                this.listaCriteriosQ2.add(adiciona);

            }

        }
        if (this.listaCriteriosQ3 == null || forcaRecargaCriterios) {
            this.listaCriteriosQ3 = new ArrayList<VwCriterioComCorrecaoCriterio>();
            if( idConsultaDisciplina==0 && uc!=null && uc.getColaboradorLogado()!=null && uc.getColaboradorLogado().getIdBanca() !=null && uc.getColaboradorLogado().getIdBanca().getIdDisciplina()!=null ){
                idConsultaDisciplina=UsuarioController.getInstance().getColaboradorLogado().getIdBanca().getIdDisciplina().getIdDisciplina().intValue();
            }
            List<TbCriterio> listaTemp = (new CriterioServiceImpl()).pesquisarPorCategoriaCriterioEDisciplinaEQuestao(this.getCategoriaSelecionada().getIdCategoriaCriterio(), idConsultaDisciplina, Uteis.QUESTAO3);
            for (TbCriterio atual : listaTemp) {
                VwCriterioComCorrecaoCriterio adiciona = new VwCriterioComCorrecaoCriterio();
                adiciona.setIdCorrecao(BigInteger.ZERO);
                adiciona.setFlCriterioNegativo(atual.getFlCriterioNegativo());
                adiciona.setIdCategoriaCriterio(atual.getIdCategoriaCriterio());
                adiciona.setIdCriterio(atual.getIdCriterio());
                adiciona.setIdDisciplina(atual.getIdDisciplina().getIdDisciplina());
                adiciona.setNmCriterio(atual.getNmCriterio());
                adiciona.setDsCriterio(atual.getDsCriterio());
                adiciona.setNrValorMaximo(atual.getNrValorMaximo());

                this.listaCriteriosQ3.add(adiciona);

            }

        }
        if (this.listaCriteriosQ4 == null || forcaRecargaCriterios) {
            this.listaCriteriosQ4 = new ArrayList<VwCriterioComCorrecaoCriterio>();
            if( idConsultaDisciplina==0 && uc!=null && uc.getColaboradorLogado()!=null && uc.getColaboradorLogado().getIdBanca() !=null && uc.getColaboradorLogado().getIdBanca().getIdDisciplina()!=null ){
                idConsultaDisciplina=UsuarioController.getInstance().getColaboradorLogado().getIdBanca().getIdDisciplina().getIdDisciplina().intValue();
            }
            List<TbCriterio> listaTemp = (new CriterioServiceImpl()).pesquisarPorCategoriaCriterioEDisciplinaEQuestao(this.getCategoriaSelecionada().getIdCategoriaCriterio(), idConsultaDisciplina, Uteis.QUESTAO4);
            for (TbCriterio atual : listaTemp) {
                VwCriterioComCorrecaoCriterio adiciona = new VwCriterioComCorrecaoCriterio();
                adiciona.setIdCorrecao(BigInteger.ZERO);
                adiciona.setFlCriterioNegativo(atual.getFlCriterioNegativo());
                adiciona.setIdCategoriaCriterio(atual.getIdCategoriaCriterio());
                adiciona.setIdCriterio(atual.getIdCriterio());
                adiciona.setIdDisciplina(atual.getIdDisciplina().getIdDisciplina());
                adiciona.setNmCriterio(atual.getNmCriterio());
                adiciona.setDsCriterio(atual.getDsCriterio());
                adiciona.setNrValorMaximo(atual.getNrValorMaximo());

                this.listaCriteriosQ4.add(adiciona);

            }

        }

    }
}
