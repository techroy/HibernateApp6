package com.javahome.test;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.javahome.model.PersonModel;

public class SelectTest3 {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session =HibernateUtil.getSession(factory);
		
		String hqlQuery="from PersonModel as pm where pm.id>=? and pm.id<=?";
		
		Query query = session.createQuery(hqlQuery);
		
		query.setInteger(0,1);
		query.setInteger(1,2);
		
		Iterator<PersonModel> iterator = query.iterate();
		
		System.out.println("------------");
		
		while(iterator.hasNext()){
			
			System.out.println(iterator.next());
		}
		
		HibernateUtil.close(factory, session);

	}

}
