function validarCNPJ(cnpj) {

	try {
		cnpj = cnpj.replace(/[^\d]+/g, '');

		if (cnpj == '')
			return false;

		if (cnpj.length != 14)
			return false;

		// Elimina CNPJs invalidos conhecidos
		if (cnpj == "00000000000000" || cnpj == "11111111111111"
				|| cnpj == "22222222222222" || cnpj == "33333333333333"
				|| cnpj == "44444444444444" || cnpj == "55555555555555"
				|| cnpj == "66666666666666" || cnpj == "77777777777777"
				|| cnpj == "88888888888888" || cnpj == "99999999999999")
			return false;

		// Valida DVs
		tamanho = cnpj.length - 2
		numeros = cnpj.substring(0, tamanho);
		digitos = cnpj.substring(tamanho);
		soma = 0;
		pos = tamanho - 7;
		for (i = tamanho; i >= 1; i--) {
			soma += numeros.charAt(tamanho - i) * pos--;
			if (pos < 2)
				pos = 9;
		}
		resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
		if (resultado != digitos.charAt(0))
			return false;

		tamanho = tamanho + 1;
		numeros = cnpj.substring(0, tamanho);
		soma = 0;
		pos = tamanho - 7;
		for (i = tamanho; i >= 1; i--) {
			soma += numeros.charAt(tamanho - i) * pos--;
			if (pos < 2)
				pos = 9;
		}
		resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
		if (resultado != digitos.charAt(1))
			return false;

		return true;
	} catch (e) {

		return false;
	}

}

cnpjCheck = function(el) {
	document.getElementById('cnpjResponse').innerHTML = validarCNPJ(el.value) ? '<span style="color:blue">válido</span>'
			: '<span style="color:red">inválido</span>';
	if (el.value == '')
		document.getElementById('cnpjResponse').innerHTML = '';
}


function valideCPF(cpf) {

    try {
     var Soma;
     var Resto;
     var strCPF = cpf.replace("-", "").replace(".", "").replace(".", "")
     Soma = 0;
     


		// Elimina CPFs invalidos conhecidos
			   if (strCPF == "00000000000" || strCPF == "11111111111"
				|| strCPF == "22222222222" || strCPF == "33333333333"
				|| strCPF == "44444444444" || strCPF == "55555555555"
				|| strCPF == "66666666666" || strCPF == "77777777777"
				|| strCPF == "88888888888" || strCPF == "99999999999")
			return false;
     
     for (i = 1; i <= 9; i++) Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
     Resto = (Soma * 10) % 11;

     if ((Resto == 10) || (Resto == 11)) Resto = 0;
     if (Resto != parseInt(strCPF.substring(9, 10))) return false;

     Soma = 0;
     for (i = 1; i <= 10; i++) Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
     Resto = (Soma * 10) % 11;

     if ((Resto == 10) || (Resto == 11)) Resto = 0;
     if (Resto != parseInt(strCPF.substring(10, 11))) return false;

     return true;

 } catch (e) {

     return false;
 }
}

cpfCheck = function(el) {
	document.getElementById('cpfResponse').innerHTML = valideCPF(el.value) ? '<span style="color:blue">válido</span>'
			: '<span style="color:red">inválido</span>';
	if (el.value == '')
		document.getElementById('cpfResponse').innerHTML = '';
}















function txtBoxFormat(strField, sMask, evtKeyPress) {
	var i, nCount, sValue, fldLen, mskLen, bolMask, sCod, nTecla;

	if (document.all) { // Internet Explorer
		nTecla = evtKeyPress.keyCode;
	} else if (document.layers) { // Nestcape
		nTecla = evtKeyPress.which;
	} else if (document.getElementById) { // FireFox
		nTecla = evtKeyPress.which;
	}

	if (nTecla != 8) {

		sValue = document.getElementById(strField).value;

		// Limpa todos os caracteres de formatação que
		// já estiverem no campo.
		sValue = sValue.toString().replace("-", "");
		sValue = sValue.toString().replace("-", "");
		sValue = sValue.toString().replace(".", "");
		sValue = sValue.toString().replace(".", "");
		sValue = sValue.toString().replace("/", "");
		sValue = sValue.toString().replace("/", "");
		sValue = sValue.toString().replace("(", "");
		sValue = sValue.toString().replace("(", "");
		sValue = sValue.toString().replace(")", "");
		sValue = sValue.toString().replace(")", "");
		sValue = sValue.toString().replace(" ", "");
		sValue = sValue.toString().replace(" ", "");
		sValue = sValue.toString().replace(":", "");
		fldLen = sValue.length;
		mskLen = sMask.length;

		i = 0;
		nCount = 0;
		sCod = "";
		mskLen = fldLen;

		while (i <= mskLen) {
			bolMask = ((sMask.charAt(i) == "-") || (sMask.charAt(i) == ".") || (sMask
					.charAt(i) == "/"))
			bolMask = bolMask
					|| ((sMask.charAt(i) == "(") || (sMask.charAt(i) == ")") || (sMask
							.charAt(i) == " "))
			bolMask = bolMask || (sMask.charAt(i) == ":")

			if (bolMask) {
				sCod += sMask.charAt(i);
				mskLen++;
			} else {
				sCod += sValue.charAt(nCount);
				nCount++;
			}

			i++;
		}

		// objForm[strField].value = sCod;
		document.getElementById(strField).value = sCod;

		if (nTecla != 8) { // backspace
			if (sMask.charAt(i - 1) == "9") { // apenas números...
				return ((nTecla > 47) && (nTecla < 58));
			} // números de 0 a 9
			else { // qualquer caracter...
				return true;
			}
		} else {
			return true;
		}
	}
}
