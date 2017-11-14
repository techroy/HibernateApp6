package com.javahome.qbc.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.javahome.model.PersonModel;
import com.javahome.test.HibernateUtil;

public class SelectTest3 {
	
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session = HibernateUtil.getSession(factory);
		
		Criteria criteria = session.createCriteria(PersonModel.class);//select * from Person
		
		
		Criterion likeCond = Restrictions.like("pname","S%");
		
		Criterion eqCond = Restrictions.eq("id",1);
		
		Criterion orCond = Restrictions.or(likeCond, eqCond);
		
		Criterion likeCriterion2 = Restrictions.like("pemailId", "a%");
		
		Criterion andCriterion = Restrictions.and(orCond, likeCriterion2);
		
		criteria.add(andCriterion);
		
		List<PersonModel> personModels = criteria.list();
		
		
		for(PersonModel personModel:personModels){
			
			System.out.println(personModel);
		}
		
		HibernateUtil.close(factory, session);
		
		
		
	}

}
