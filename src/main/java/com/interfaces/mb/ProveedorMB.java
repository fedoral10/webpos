package com.interfaces.mb;

import javax.faces.bean.ManagedBean;

import com.datos.entidades.Proveedor;
import com.datos.util.HibernateUtil;
@ManagedBean
public class ProveedorMB {
    
    private String razonSocial;
    
    private String primerNombre;
    
    private String segundoNombre;
    
    private String primerApellido;
    
    private String segundoApellido;
    
    private String telefono1;
    
    //private String telefono2;
    
    private String direccion;
    
    private String email;
    
    public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
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

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void guardarProveedor()
    {
    	Proveedor prov = new Proveedor();
    	prov.setRazonSocial(this.razonSocial);
    	prov.setPrimerNombre(this.primerNombre);
    	prov.setSegundoNombre(this.segundoNombre);
    	prov.setPrimerApellido(this.primerApellido);
    	prov.setSegundoApellido(this.segundoApellido);
    	prov.setTelefono1(this.telefono1);
    	prov.setDireccion(this.direccion);
    	prov.setEmail(this.email);
    	HibernateUtil.escribirEnDB(prov);
    }
}
