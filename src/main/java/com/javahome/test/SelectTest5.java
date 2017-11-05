package com.javahome.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SelectTest5 {

	public static void main(String[] args) {

		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session =HibernateUtil.getSession(factory);
		
		String hqlQuery="select count(id) from PersonModel";
		
		Query query = session.createQuery(hqlQuery);
		
		List<Object> list=query.list();
		
		System.out.println("count==="+list.get(0));
		
		HibernateUtil.close(factory, session);
		

	}

}
