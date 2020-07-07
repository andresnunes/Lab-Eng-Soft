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
