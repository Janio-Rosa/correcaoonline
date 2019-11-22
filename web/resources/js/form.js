/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function focaProximo(ev,obj){
    var keycode
    if(ev.keyCode){
        keycode=ev.keyCode;
    }else{
        keycode=ev.which;
    }
    if(keycode==13){
        document.getElementById(obj).focus();
        return false;
    }
}

function imprimir(){

	if(window.print)
		window.print();
	else
		alert("Seu browser não tem suporte para impressão");

}

function HabilitaCombo(objVerifica,valorHabilitar,objHabilitar){
    var combo = document.getElementById(objHabilitar);
    if(objVerifica.value==valorHabilitar){
        combo.disabled=false;
    }else{
        combo.disabled=true;
    }
}

function soNumero(evt){
    
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57))
    return false;

    return true;
}

function soNumeroHE(evt){
    
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if (charCode > 31 && (charCode < 46 || charCode > 57))
    return false;

    return true;
}

function semEnter(evt){
    
    var charCode = (evt.which) ? evt.which : event.keyCode;

    if(charCode==13)return false;

    return true;
}
