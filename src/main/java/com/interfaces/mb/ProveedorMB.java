package com.interfaces.mb;

import javax.persistence.Basic;
import javax.persistence.Column;

import com.datos.entidades.Proveedor;
import com.datos.util.HibernateUtil;

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
