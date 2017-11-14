package com.javahome.qbc.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.javahome.model.PersonModel;
import com.javahome.test.HibernateUtil;

public class SelectTest2 {
	
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session = HibernateUtil.getSession(factory);
		
		Criteria criteria = session.createCriteria(PersonModel.class);//select * from Person
		
		Criterion betweenCriterion = Restrictions.between("id", 1, 3);//where cond
		
		Criterion eqCriterion = Restrictions.eq("pname","Sam1");
		
		
		Criterion andCond = Restrictions.and(betweenCriterion, eqCriterion);
		
		criteria.add(andCond);
		
		
		List<PersonModel> personModels = criteria.list();
		
		
		for(PersonModel personModel:personModels){
			
			System.out.println(personModel);
		}
		
		HibernateUtil.close(factory, session);
		
		
		
	}

}
