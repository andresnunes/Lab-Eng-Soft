package modelo;

import java.time.LocalTime;

public class Torneio {
	private LocalTime data_inicio;
	private LocalTime data_final;
	private Clube clube;
	private Atleta vencedor;
	
	
	public LocalTime getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(LocalTime data_inicio) {
		this.data_inicio = data_inicio;
	}
	
	public LocalTime getData_final() {
		return data_final;
	}
	public void setData_final(LocalTime data_final) {
		this.data_final = data_final;
	}
	
	public Clube getClube() {
		return clube;
	}
	public void setClube(Clube clube) {
		this.clube = clube;
	}
	
	public Atleta getVencedor() {
		return vencedor;
	}
	public void setVencedor(Atleta vencedor) {
		this.vencedor = vencedor;
	}
}
