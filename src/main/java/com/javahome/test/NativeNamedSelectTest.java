package com.javahome.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.javahome.model.PersonModel;

public class NativeNamedSelectTest {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = HibernateUtil.getSession(factory);

		Query query = session.getNamedQuery("personNativeSelectQuery");
		query.setInteger(0, 1);
		query.setInteger(1, 2);

		List<PersonModel> list = query.list();

	/*	for (Object ob : list) {

			Object[] arrObj = (Object[]) ob;

			for (Object obj : arrObj) {

				System.out.print(obj + " ");
			}

			System.out.println("----------");

		}
*/		
		
		for(PersonModel personModel:list){
			
			System.out.println(personModel);
		}
		HibernateUtil.close(factory, session);

	}

}
