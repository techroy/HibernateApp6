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

public class SelectTest5 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = HibernateUtil.getSession(factory);

		Criteria criteria = session.createCriteria(PersonModel.class);// select
																		// *
																		// Person

		Projection p1 = Projections.count("id");
		Projection p2 = Projections.sum("id");
		Projection p3 = Projections.max("id");
		
		
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(p1);
		projectionList.add(p2);
		projectionList.add(p3);

		criteria.setProjection(projectionList);

		
		List list = criteria.list();
		
		Object[] arr = (Object[])list.get(0);
		
		System.out.println("count---"+arr[0]);
		System.out.println("sum---"+arr[1]);
		System.out.println("max id---"+arr[2]);

		HibernateUtil.close(factory, session);

	}

}
