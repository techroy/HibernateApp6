package com.javahome.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UpdateTest1 {

	public static void main(String[] args) {
		
		
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = HibernateUtil.getSession(factory);

		
		String hqlQuery="update PersonModel set pname=:name where id=:personId";
		
		Query query = session.createQuery(hqlQuery);
		
		
		query.setString("name","adam1");
		query.setInteger("personId", 3);
		
		Transaction tx =session.beginTransaction();
		
		int rowCount = query.executeUpdate();
		
		tx.commit();
		System.out.println(rowCount);
		
		HibernateUtil.close(factory, session);


	}

}
