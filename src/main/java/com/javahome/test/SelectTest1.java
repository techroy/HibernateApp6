package com.javahome.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SelectTest1 {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session =HibernateUtil.getSession(factory);
		
		String hqlQuery="select id,pname from PersonModel";
		
		Query query = session.createQuery(hqlQuery);
		
		List list = query.list();
		
		for(Object ob:list){
			
			
			Object[] arr=(Object[])ob;
			
			for(Object obj:arr){
				
				System.out.print(obj+"  ");
			}
			System.out.println();
			
		}
	

	}

}
