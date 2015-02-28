package com.interfaces.mb;

import javax.faces.bean.ManagedBean;

import com.datos.entidades.Articulo;
import com.datos.util.HibernateUtil;

@ManagedBean
public class ArticuloMB {
	private String codigoBarra;
	private String descripcion;
	private float costo;
	//int existenciaMinima
	private int puntoReorden;
	
	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public int getPuntoReorden() {
		return puntoReorden;
	}

	public void setPuntoReorden(int puntoReorden) {
		this.puntoReorden = puntoReorden;
	}

	public void guardarArticulo()
	{
		Articulo art = new Articulo();
		art.setCodigoBarra(codigoBarra);
		art.setDescripcion(descripcion);
		art.setCosto(costo);
		art.setPuntoReorden(puntoReorden);
		HibernateUtil.escribirEnDB(art);
	}
}
