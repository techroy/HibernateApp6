package com.javahome.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SelectTest2 {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session =HibernateUtil.getSession(factory);
		
		String hqlQuery="select pname from PersonModel";
		
		Query query = session.createQuery(hqlQuery);
		
		List list = query.list();
		
		System.out.println("-----------");
		
		for(Object ob:list){
			
			System.out.println(ob);
		}

		HibernateUtil.close(factory, session);
	}

}
