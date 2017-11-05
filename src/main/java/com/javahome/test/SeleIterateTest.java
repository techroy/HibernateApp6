package com.javahome.test;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.javahome.model.PersonModel;

public class SeleIterateTest {

	public static void main(String[] args) {
		
			SessionFactory factory = HibernateUtil.getSessionFactory();
			
			Session session =HibernateUtil.getSession(factory);
			
			String hqlQuery="from PersonModel";
			
			Query query = session.createQuery(hqlQuery);
			
			Iterator<PersonModel> personModels=query.iterate();
			
			
			System.out.println("-------------------------");
			
			while(personModels.hasNext()){
				
				PersonModel personModel = personModels.next();
				
				System.out.println(personModel);
			}
			
			HibernateUtil.close(factory, session);
		

	}

}
