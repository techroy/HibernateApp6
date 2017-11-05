package com.javahome.qbc.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.javahome.model.PersonModel;
import com.javahome.test.HibernateUtil;

public class SelectTest1 {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = HibernateUtil.getSession(factory);
		
		Criteria criteria =session.createCriteria(PersonModel.class);
		
		criteria.setFirstResult(0);
		criteria.setMaxResults(2);
		
		List<PersonModel> personModels=criteria.list();
		
		for(PersonModel personModel:personModels){
			
			System.out.println(personModel);
		}
		
		HibernateUtil.close(factory, session);
	}

}
