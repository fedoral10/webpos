package com.interfaces.mb;

//import javax.faces.bean.ManagedBean;

import org.hibernate.Session;

import com.datos.entidades.Client;
import com.datos.util.HibernateUtil;

//@ManagedBean
public class ClientMB {
	private String Nombre;

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public void guardarClient()
	{
		/*Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		Client c = new Client(this.Nombre);
		s.save(c);
		s.getTransaction().commit();
		s.close();*/
		
	}
	public void nada()
	{
		
		System.out.println("FUCK THIS SHIT!");
	}
}
