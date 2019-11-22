/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Janio
 */
public class Uteis {

    //TIPOS DE CORREÇÃO
    public static final int TIPO_CORRECAO_PRIMEIRA_CORRECAO=14;
    public static final int TIPO_CORRECAO_SEGUNDA_CORRECAO=15;
    public static final int TIPO_CORRECAO_DISCREPANCIA=16;
    public static final int TIPO_CORRECAO_RECORRECAO=17;
    public static final int TIPO_CORRECAO_TERCEIRA_CORRECAO=13;
    public static final int TIPO_CORRECAO_QUARTA_CORRECAO=12;

    //Tipos de questão: Discursiva/Redação
    public static final int TIPO_QUESTAO_RECACAO=22;
    public static final int TIPO_QUESTAO_DISCURSIVA=21;
    public static final int TIPO_QUESTAO_HABILIDADE_ESPECIFICA=23; //Questões de Habilidade Específica
    public static final int TIPO_QUESTAO_DOCENTE=24;//Questões de concursos de docente
    public static final int TIPO_QUESTAO_TEATRO_DANCA_MUSICA=25;//Questões de concursos de docente
    public static final int TIPO_QUESTAO_HABILIDADE_ESPECIFICA_TRADUCAO_ESTILO_REDACAO=26; //HE - Tradução - Questões de tradução corrigidas estilo redação

    public static final int GENERO_CATEGORIA_DISCURSIVA_ID=28;
    public static final int GENERO_CATEGORIA_HABILIDADE_ESPECIFICA_ID=30;

    public static final String GENERO_CATEGORIA_DISCURSIVA_NOME="Discursiva";
    
    public static final int CATEGORIA_CRITERIO_DISCURSIVA=39;

    public static final int PERFIL_ADMINISTRADOR=1;
    public static final int PERFIL_COORDENADOR_CORRECAO=2;
    public static final int PERFIL_COORDENADOR_BANCA=3;
    public static final int PERFIL_RELATORIO_CORRECAO_DETALHADA=15;
    public static final int PERFIL_TESTAR_CORRECAO=16;
    
    
    
    public static final int LIMITE_PROCURA_RESPOSTA=3;
    
    public static final int ID_DISCIPLINA_REDACAO=13;
    public static final int ID_DISCIPLINA_ARQUITETURA_URBANISMO=40;
    public static final int ID_DISCIPLINA_ARQUITETURA_URBANISMO_TRANSFERENCIA=71;
    public static final int ID_DISCIPLINA_DESIGN_INTERIORES=42;
    
    public static final int QUESTAO1=1;
    public static final int QUESTAO2=2;
    public static final int QUESTAO3=3;
    public static final int QUESTAO4=4;
    public static final int QUESTAO5=5;
    public static final int QUESTAO6=6;
    public static final int QUESTAO7=7;
    public static final int QUESTAO8=8;
    public static final int QUESTAO9=9;
    public static final int QUESTAO10=10;
    public static final int QUESTAO11=11;
    
    public static final double DISCREPANCIA_ARQUITETURA=15; //Discrepância de 30% de 50,00 que é o total possível
    public static final double DISCREPANCIA_DOCENTES=40; //Discrepância de 30% de 50,00 que é o total possível
    
    public static HttpSession getSession(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        return session;
    }

    public static ExternalContext getExternalContext(){
        ExternalContext extC = (ExternalContext) FacesContext.getCurrentInstance().getExternalContext();
        return extC;
    }
    
    public static void Redireciona(String target ){
        try {
            //FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, target);
            FacesContext.getCurrentInstance().getExternalContext().redirect(target);
        } catch (Exception ex) {
            Logger.getLogger(Uteis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static double arredonda(double valor,int quantCasasDecimais){
    
        double p = Math.pow(10, quantCasasDecimais);
        return Math.round(valor*p)/p;
    }
    
    public static int converteDoubleParaInt(double atual){
        String valorDouble=String.valueOf(atual);
        int retorno=0;
        try{
            retorno=Integer.valueOf(valorDouble);
        }catch(Exception ex){
            return 0;
        }
        return retorno;
    }
}
