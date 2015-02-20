package com.datos.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;


public class HibernateUtil
{
     private static SessionFactory sessionFactory;
     private static Configuration config;
    
     static {
		 //Configuration configuration = new Configuration().configure();
		 /*config = new Configuration().configure();
		 StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		 serviceRegistryBuilder.applySettings(config.getProperties());
		
		 ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		 sessionFactory = config.buildSessionFactory(serviceRegistry);*/
		 
    	 config = new Configuration().configure();
		 StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
		 applySettings(config.getProperties());
		 sessionFactory = config.buildSessionFactory(builder.build());
     }
     
     public static Configuration getConfiguration()
     {
    	 return config;
     }
     
     public static SessionFactory getSessionFactory() {  	 
          return sessionFactory;
     }
     
     public static void escribirEnDB(Object clase)
     {
    	Session s = HibernateUtil.getSessionFactory().openSession();
 		s.beginTransaction();
 		s.save(clase);
 		s.getTransaction().commit();
 		s.close();
     }
}
