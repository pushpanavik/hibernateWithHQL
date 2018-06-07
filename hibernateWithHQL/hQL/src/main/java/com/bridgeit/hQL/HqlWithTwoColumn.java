package com.bridgeit.hQL;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HqlWithTwoColumn {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("resources/db.config.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();

		String hql = "select name,address from Employee ";
		@SuppressWarnings("unchecked")
		Query<Object> q = session.createQuery(hql);
		List<Object> list = q.list();

		for (Object o : list) {
			Object obj[] = (Object[]) o;
			System.out.println(obj[0] + " " + obj[1]);
		}

		session.close();
		sessionFactory.close();

	}

}
