function mostrar(id, idbtn, id2, idbtn2) {
	if (document.getElementById(id).style.display == 'block') {
		document.getElementById(id).style.display = 'none';
		document.getElementById(idbtn).style.display = 'none';
		document.getElementById(id2).style.display = 'block';
		document.getElementById(idbtn2).style.display = 'block';
	} else {
		document.getElementById(id2).style.display = 'none';
		document.getElementById(idbtn2).style.display = 'none';
		document.getElementById(id).style.display = 'block';
		document.getElementById(idbtn).style.display = 'block';
	}
}

function is_cpf(c) {

	if ((c = c.replace(/[^\d]/g, "")).length != 11)
		return false

	if (c == "00000000000")
		return false;

	var r;
	var s = 0;

	for (i = 1; i <= 9; i++)
		s = s + parseInt(c[i - 1]) * (11 - i);

	r = (s * 10) % 11;

	if ((r == 10) || (r == 11))
		r = 0;

	if (r != parseInt(c[9]))
		return false;

	s = 0;

	for (i = 1; i <= 10; i++)
		s = s + parseInt(c[i - 1]) * (12 - i);

	r = (s * 10) % 11;

	if ((r == 10) || (r == 11))
		r = 0;

	if (r != parseInt(c[10]))
		return false;

	return true;
}

function fMasc(objeto, mascara) {
	obj = objeto
	masc = mascara
	setTimeout("fMascEx()", 1)
}

function fMascEx() {
	obj.value = masc(obj.value)
}

function mCPF(cpf) {
	cpf = cpf.replace(/\D/g, "")
	cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2")
	cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2")
	cpf = cpf.replace(/(\d{3})(\d{1,2})$/, "$1-$2")
	return cpf
}

//JavaScript Document
//adiciona mascara de cnpj
function MascaraCNPJ(cnpj){
      if(mascaraInteiro(cnpj)==false){
              event.returnValue = false;
      }       
      return formataCampo(cnpj, '00.000.000/0000-00', event);
}
//valida numero inteiro com mascara
function mascaraInteiro(){
      if (event.keyCode < 48 || event.keyCode > 57){
              event.returnValue = false;
              return false;
      }
      return true;
}


//formata de forma generica os campos
function formataCampo(campo, Mascara, evento) { 
      var boleanoMascara; 

      var Digitato = evento.keyCode;
      exp = /\-|\.|\/|\(|\)| /g
      campoSoNumeros = campo.value.toString().replace( exp, "" ); 

      var posicaoCampo = 0;    
      var NovoValorCampo="";
      var TamanhoMascara = campoSoNumeros.length;; 

      if (Digitato != 8) { // backspace 
              for(i=0; i<= TamanhoMascara; i++) { 
                      boleanoMascara  = ((Mascara.charAt(i) == "-") || (Mascara.charAt(i) == ".")
                                                              || (Mascara.charAt(i) == "/")) 
                      boleanoMascara  = boleanoMascara || ((Mascara.charAt(i) == "(") 
                                                              || (Mascara.charAt(i) == ")") || (Mascara.charAt(i) == " ")) 
                      if (boleanoMascara) { 
                              NovoValorCampo += Mascara.charAt(i); 
                                TamanhoMascara++;
                      }else { 
                              NovoValorCampo += campoSoNumeros.charAt(posicaoCampo); 
                              posicaoCampo++; 
                        }              
                }      
              campo.value = NovoValorCampo;
                return true; 
      }else { 
              return true; 
      }
}
//fabiobmed.com.br/2012/07/16/excelente-codigo-para-mascara-e-validacao-de-cnpj-cpf-cep-data-e-telefone/
//verificar validade de cpf https://pt.stackoverflow.com/questions/295564/como-validar-cpf-com-m%C3%A1scara-em-javascript
