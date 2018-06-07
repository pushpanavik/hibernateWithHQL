package com.bridgeit.hQL;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bean.Employee;

@SuppressWarnings("deprecation")
public class HqlWithSelectAll {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("resources/db.config.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();

		String hql = "from Employee ";

		Query q = session.createQuery(hql);
		List<Employee> list = q.list();

		for (Employee o : list) {
			System.out.println(" ****************Employee Details ****************");
			System.out.println(o.getId()+ "  " +o.getName()+ " " +o.getAddress() + " " +o.getEmail());
			
		}

		session.close();
		sessionFactory.close();
	}

}
