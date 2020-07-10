






//deixar os validadores com span
//validador de cpf https://pt.stackoverflow.com/questions/295564/como-validar-cpf-com-m%C3%A1scara-em-javascript
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

cpfCheck = function (el) {
    document.getElementById('cpfResponse').innerHTML = is_cpf(el.value)? '<span style="color:green">válido</span>' : '<span style="color:red">inválido</span>';
    if(el.value=='') document.getElementById('cpfResponse').innerHTML = '';
}

//JavaScript Document https://fabiobmed.com.br/2012/07/16/excelente-codigo-para-mascara-e-validacao-de-cnpj-cpf-cep-data-e-telefone/
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

//valida o CNPJ digitado
function ValidarCNPJ(ObjCnpj){
        var cnpj = ObjCnpj.value;
        var valida = new Array(6,5,4,3,2,9,8,7,6,5,4,3,2);
        var dig1= new Number;
        var dig2= new Number;

        exp = /\.|\-|\//g
        cnpj = cnpj.toString().replace( exp, "" ); 
        var digito = new Number(eval(cnpj.charAt(12)+cnpj.charAt(13)));

        for(i = 0; i<valida.length; i++){
                dig1 += (i>0? (cnpj.charAt(i-1)*valida[i]):0);  
                dig2 += cnpj.charAt(i)*valida[i];       
        }
        dig1 = (((dig1%11)<2)? 0:(11-(dig1%11)));
        dig2 = (((dig2%11)<2)? 0:(11-(dig2%11)));

        if(((dig1*10)+dig2) != digito)  
                alert('CNPJ Invalido!');

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
