package com.javahome.qbc.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.AliasToBeanResultTransformer;

import com.javahome.model.PersonModel;
import com.javahome.test.HibernateUtil;

public class SelectTest4 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = HibernateUtil.getSession(factory);

		Criteria criteria = session.createCriteria(PersonModel.class);// select
																		// *
		//criteria.createAlias("id", "id");
		//criteria.createAlias("pname", "pname");
		//criteria.createAlias("pemailId", "pemailId");// from
																		// Person

		Projection projection = Projections.property("id");

		Projection projection2 = Projections.property("pname");

		ProjectionList projectionList = Projections.projectionList();

		projectionList.add(projection,"id");
		projectionList.add(projection2,"pname");

		criteria.setProjection(projectionList);
		criteria.setResultTransformer(new AliasToBeanResultTransformer(PersonModel.class));
		/*
		 * List personModels = criteria.list();
		 * 
		 * for(Object ob :personModels){
		 * 
		 * Object[] arrObj=(Object[])ob;
		 * 
		 * for(Object obj:arrObj){
		 * 
		 * System.out.print(obj+"  "); }
		 * 
		 * System.out.println(); }
		 */

		List<PersonModel> personModels = criteria.list();

		for (PersonModel personModel : personModels) {

			System.out.println(personModel);
		}

		HibernateUtil.close(factory, session);

	}

}
