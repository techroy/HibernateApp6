package com.javahome.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory getSessionFactory() {

		Configuration cfg = new Configuration();

		cfg = cfg.configure();

		SessionFactory sessionFactory = cfg.buildSessionFactory();

		return sessionFactory;

	}

	public static Session getSession(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();
		return session;
	}

	public static void close(SessionFactory sessionFactory, Session session) {
		session.close();
		sessionFactory.close();

	}

}
