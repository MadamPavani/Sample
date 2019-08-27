package com.sample.jersey.JerseyDemo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sample.jersey.employee.Employee;

@Path("emp")
public class TestEmployee {
	
	  @GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public Employee getIt() {
		  Configuration cfg = new Configuration();
		  cfg.configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
		  SessionFactory factory = cfg.buildSessionFactory();
		  Session s = factory.openSession();
		 /* Employee emp = new Employee();
		  emp.setId(1);
		  emp.setName("Pavani");
		  emp.setAddress("Guntur");*/
		  Transaction tx = s.beginTransaction();
		  s.get(Employee.class, 1);
		  tx.commit();
	        return (Employee) s;
	  }

}
