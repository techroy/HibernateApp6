package com.javahome.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.javahome.model.PersonModel;

public class SelectTest4 {

	public static void main(String[] args) {
		
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session =HibernateUtil.getSession(factory);
		
		//named parameter
		
		String hqlQuery="from PersonModel as pm where pm.pname like :name";
	
		Query query = session.createQuery(hqlQuery);
		
		query.setString("name","S%");
		
		List<PersonModel> personModels = query.list();
		
		for(PersonModel personModel:personModels){
			
			System.out.println(personModel);
		}
		
		
		HibernateUtil.close(factory, session);
		
		

	}

}
