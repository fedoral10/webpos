package com.interfaces.mb;

import java.util.Collection;

import javax.faces.bean.ManagedBean;

import com.datos.entidades.Cliente;
import com.datos.entidades.Factura;
import com.datos.util.HibernateUtil;

@ManagedBean
public class ClienteMB {
	private Long idCliente;
    
    private String primerNombre;
    
    private String segundoNombre;
    
    private String primerApellido;
    
    private String segundoApellido;
    
    private String direccion;
    
    private String telefono1;
    
    private String telefono2;
    
    private String email;
    
    private Boolean activo;
    
    private Collection<Factura> facturaCollection;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Collection<Factura> getFacturaCollection() {
		return facturaCollection;
	}

	public void setFacturaCollection(Collection<Factura> facturaCollection) {
		this.facturaCollection = facturaCollection;
	}
	
	public void guardarCliente()
	{
		Cliente cli = new Cliente();
		cli.setPrimerNombre(this.primerNombre);
		cli.setSegundoApellido(this.segundoApellido);
		cli.setSegundoNombre(this.segundoNombre);
		cli.setPrimerApellido(this.primerApellido);
		cli.setDireccion(this.direccion);
		cli.setTelefono1(this.telefono1);
		cli.setTelefono2(this.telefono2);
		cli.setEmail(this.email);
		cli.setActivo(true);
		HibernateUtil.escribirEnDB(cli);
	}
}
