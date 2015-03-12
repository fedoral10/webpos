package com.soap.bcn;

import java.sql.Timestamp;

public class Dia {
	private Timestamp fecha;
	private Double valor;
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
}
