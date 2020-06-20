package br.com.torneio.gerenciador.model;

public enum TipoPartida {
	Classificatoria("Classificatoria"),
	Eliminatoria("Eliminatoria");
	
	private final String tipo;
	
	TipoPartida(String tipo){
		this.tipo = tipo;
	}
}
