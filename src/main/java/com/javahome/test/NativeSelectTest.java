package com.javahome.test;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.javahome.model.PersonModel;

public class NativeSelectTest {

	public static void main(String[] args) {
		
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = HibernateUtil.getSession(factory);
		
		SQLQuery sqlQuery = session.createSQLQuery("select * from Person where pid>=? and pid<=?");
		sqlQuery.setInteger(0, 1);
		sqlQuery.setInteger(1, 2);
		
		sqlQuery.addEntity(PersonModel.class);
		
		//List list=sqlQuery.list();
		
		List<PersonModel>  list=sqlQuery.list();
		
		
		for(PersonModel personModel:list){
			
			System.out.println(personModel);
		}
		
		/*for(Object ob:list){
			
			Object[] arrObj = (Object[])ob;
			
			for(Object obj:arrObj){
				
				System.out.print(obj+" ");
			}
			
			System.out.println("----------");
			
		}
		*/
		HibernateUtil.close(factory, session);

	}

}
