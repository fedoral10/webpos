package com.datos.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.hibernate.tool.hbm2ddl.SchemaExport;

@ManagedBean
public class Esquema {

	public static void exportarEsquema()
	{
		SchemaExport sch = new SchemaExport(HibernateUtil.getConfiguration());
		try {
			crearBaseDatos(HibernateUtil.getSessionFactory().getCurrentSession());
			sch.create(true, false);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		
	}
	public static void crearBaseDatos(Session session)
	{
		session.doWork(
			    new Work() {
			        public void execute(Connection connection) throws SQLException 
			        { 
			            Statement st = connection.createStatement();
			            st.executeUpdate("CREATE DATABASE test");
			            st.close();
			        }
			    }
			);
	}
}
