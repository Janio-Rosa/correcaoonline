/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function mascaraTelefone(o){
    v=o.value;
    v=v.replace(/\D/g,"") 					//Remove tudo o que não é dígito
    v=v.replace(/^(\d{2})(\d)/g,"($1)$2") 	//Coloca parênteses em volta dos dois primeiros dígitos
    v=v.replace(/(\d{4})(\d)/,"$1-$2") 		//Coloca hífen entre o quarto e o quinto dígito consecutivo
    o.value=v;
}
function mascaraNumero(o){
    v=o.value;
    v=v.replace(/\D/g,"") 					//Remove tudo o que não é dígito
    o.value=v;
}
function mascaraCep(o){
    v=o.value;
    v=v.replace(/\D/g,"") 					//Remove tudo o que não é dígito
    v=v.replace(/^(\d{5})(\d)/g,"$1-$2") 	//Coloca hífem entre o quinto e o sexto dígito consecutivo
    o.value=v;
}
function mascaraCpf(o){
    v=o.value;
    v=v.replace(/\D/g,"") 					//Remove tudo o que não é dígito
    v=v.replace(/^(\d{3})(\d)/g,"$1.$2") 	//Coloca um ponto entre o terçeiro e o quarto dígito consecutivo
    v=v.replace(/(\d{3})(\d)/,"$1.$2") 		//Coloca um ponto entre o terçeiro e o quarto dígito consecutivo
    v=v.replace(/(\d{3})(\d)/,"$1-$2") 		//Coloca um hífem entre o terçeiro e o quarto dígito consecutivo
    o.value=v;
}
function mascaraRg(o){
    v=o.value;
    v=v.replace(/\D/g,"")
    v=v.replace(/(\d{1,3})(\d{3})(\d{3})(\d{3})(\d{3})/,"$1.$2.$3.$4.$5")
    v=v.replace(/(\d{1,3})(\d{3})(\d{3})(\d{3})/,"$1.$2.$3.$4")
    v=v.replace(/(\d{1,3})(\d{3})(\d{3})/,"$1.$2.$3")
    v=v.replace(/(\d{1,3})(\d{3})/,"$1.$2")
    v=v.replace(/(\d{1,3})/,"$1")
    o.value=v;
}

function apagaLabel(objeto){
    document.getElementById(objeto).innerHTML='Sessão atualizada.';
    setTimeout("limpaLabel('"+objeto+"')",1500);
}
function limpaLabel(objeto){
    if(document.getElementById(objeto).value){
        document.getElementById(objeto).value='';
    }else{
        document.getElementById(objeto).innerHTML='';
    }
}
function tempoSessao(objeto){
    var atual = document.getElementById('lblTempoRestanteSessao').innerHTML;
    var novo = parseInt(atual)-1;
    if(novo<=0){
        document.getElementById('lblTempoRestanteSessao').innerHTML='Sessão expirada. Refazer Login';
    }else{
        document.getElementById('lblTempoRestanteSessao').innerHTML=novo;
        setTimeout("tempoSessao();",1000);
    }
}

function destacaImagem(posicao){
    var esquerda = measureLeft (document.getElementById('imgRespostaQuestaoEmCorrecao') )+28;
    var obj=document.getElementById('pnlDestacarImagem1');
    var obj2=document.getElementById('pnlDestacarImagem2');
    obj.style.width='730px';
    obj.style.heigth='2px';
    obj.style.position='absolute';
    obj.style.left=esquerda+'px';
    var topo=199+posicao;
    obj.style.top= topo+'px';
    
    obj2.style.width='730px';
    obj2.style.heigth='2px';
    obj2.style.position='absolute';
    obj2.style.left=esquerda+'px';
    topo=219+posicao;
    obj2.style.top= topo+'px';
    
}

function measureLeft(oElement){
    var iLeft = oElement.offsetLeft;
    var oParent = oElement.offsetParent;
    while(oParent.nodeName != 'BODY'){
        iLeft += oParent.offsetLeft;
        oParent = oParent.offsetParent;
    }
    return iLeft;
}

function apagaTextoEspecifico(nome){
    var obj = document.getElementById('lblMensagemErro');
    obj.innerHTML='';
}

function apagaTextoGenerico(nome){
    var obj=null;
    var lista = document.getElementsByTagName('label');
    for(var k=0;k<lista.length;k++){
        var atual=lista[k];
        if(atual.id !=''){
            //if(atual.id.toString().toLowerCase() == nome.toString().toLowerCase()){
            if(atual.id.toString().toLowerCase().indexOf(nome.toString().toLowerCase(), 0)!=-1){
                obj=atual;
                break;
            }
        }
    }
    obj.innerHTML='';
}

setTimeout("tempoSessao();",1000);
setTimeout("apagaTextoGenerico('lblMensagemErro');", 2000);