package com.bridgeit.hQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

import bean.Employee;

@SuppressWarnings("deprecation")
public class SingleRowSelectMain {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("resources/db.config.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();

		String hql = "from Employee where id=101";
		Query query = session.createQuery(hql);

		Employee emp = (Employee) query.uniqueResult();

		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp.getAddress());
		System.out.println(emp.getEmail());

		session.update(emp);
		session.close();
		sessionFactory.close();
	}
}
