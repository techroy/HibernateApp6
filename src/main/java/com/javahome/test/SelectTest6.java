package com.javahome.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SelectTest6 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = HibernateUtil.getSession(factory);

		String hqlQuery = "select count(id),sum(id),min(id) from PersonModel";

		Query query = session.createQuery(hqlQuery);

		List list = query.list();

		Object[] arr = null;
		if (list != null && !list.isEmpty()) {
			arr = (Object[]) list.get(0);
		}

		for (Object obj : arr) {
				
			System.out.print(obj+" ");
		}

	}

}
