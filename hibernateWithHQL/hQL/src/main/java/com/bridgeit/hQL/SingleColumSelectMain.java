package com.bridgeit.hQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.Query;

@SuppressWarnings("deprecation")
public class SingleColumSelectMain {
public static void main(String[] args) {
	Configuration cfg = new Configuration().configure("resources/db.config.xml");

	SessionFactory sessionFactory = cfg.buildSessionFactory();
	Session session = sessionFactory.openSession();
	
	String hql="select name from Employee ";
	Query q=session.createQuery(hql);
	List<String> list=q.list();
	for(String l: list)
	{
		System.out.println(" Employee Name::"  +l );
	}
	
	session.close();
	sessionFactory.close();
}
}
