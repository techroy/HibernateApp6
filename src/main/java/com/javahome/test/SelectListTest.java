package com.javahome.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.javahome.model.PersonModel;

public class SelectListTest {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		
		cfg = cfg.configure();
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		String hqlQuery="from PersonModel";
		
		Query query = session.createQuery(hqlQuery);
		
		List<PersonModel> personModels = query.list();
		
		for(PersonModel personModel:personModels){
			
			System.out.println(personModel);
		}
		
		
		session.close();
		factory.close();
		

	}

}
