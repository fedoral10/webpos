package com.soap.bcn;

public class Dia {
	private String Fecha;
	private Double valor;
	private int Ano;
	private int Mes;
	private int Dia;
	/*<Fecha>2015-03-01</Fecha>
	<Valor>26.8125</Valor>
	<Ano>2015</Ano>
	<Mes>3</Mes>
	<Dia>1</Dia>*/
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public int getAno() {
		return Ano;
	}
	public void setAno(int ano) {
		Ano = ano;
	}
	public int getMes() {
		return Mes;
	}
	public void setMes(int mes) {
		Mes = mes;
	}
	public int getDia() {
		return Dia;
	}
	public void setDia(int dia) {
		Dia = dia;
	}
	
}
