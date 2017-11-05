package com.javahome.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.javahome.model.PersonModel;

public class SelectTest8 {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = HibernateUtil.getSession(factory);

		
		String hqlQuery="select pm from PersonModel as pm where pm.id=(select max(id) from PersonModel)";

		Query query= session.createQuery(hqlQuery);
		
		
		List<PersonModel> personModels=query.list();
		System.out.println(personModels.get(0));
		
		HibernateUtil.close(factory, session);
		
	}

}
