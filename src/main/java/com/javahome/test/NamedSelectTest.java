package com.javahome.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.javahome.model.PersonModel;

public class NamedSelectTest {
	
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = HibernateUtil.getSession(factory);

		Query query = session.getNamedQuery("personSelectQuery");
		query.setInteger(0,1);
		query.setInteger(1,2);
		
		
		List<PersonModel> personModels=query.list();
		
		for(PersonModel personModel:personModels){
			
			System.out.println(personModel);
		}
		
		HibernateUtil.close(factory, session);
		
		
	}

}
