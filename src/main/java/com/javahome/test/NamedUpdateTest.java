package com.javahome.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.javahome.model.PersonModel;

public class NamedUpdateTest {
	
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = HibernateUtil.getSession(factory);

		Transaction tx =session.beginTransaction();
		
		Query query = session.getNamedQuery("personUpdateQuery");
		query.setString("name", "Sujith1");
		query.setInteger("personId", 1);
		
		int rowCount=query.executeUpdate();
		
		System.out.println("row count--->"+rowCount);
		
		
		tx.commit();
		
		HibernateUtil.close(factory, session);
		
		
	}

}
