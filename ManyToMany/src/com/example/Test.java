package com.example;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class Test {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction txt = session.beginTransaction();

		User u1 = new User();
		u1.setName("X");

		User u2 = new User();
		u2.setName("Y");

		List<User> users = new ArrayList<User>();
		users.add(u1);
		users.add(u2);

		Product p = new Product();
		p.setName("Car");
		p.setPrice(89989898);
		p.setUsers(users);

		User u11 = new User();
		u11.setName("X1");

		User u12 = new User();
		u12.setName("Y1");

		List<User> users1 = new ArrayList<User>();
		users1.add(u11);
		users1.add(u12);

		Product p1 = new Product();
		p1.setName("Car1");
		p1.setPrice(8998989);
		p1.setUsers(users1);
		
		
		session.persist(p);
		session.persist(p1);

		txt.commit();
		System.out.println("success");
		/*
		 * Product p = session.get(Product.class, 1); List<User> users =
		 * p.getUsers(); for (User u : users) { System.out.println(u.getName());
		 * }
		 */

		/*
		 * NativeQuery nt = session.createNativeQuery("select * from tt_tt");
		 * List<Object[]> list = nt.getResultList();
		 * 
		 * for (int i = 0; i < list.size(); i++) { Object o[] = list.get(i);
		 * System.out.println(o[0] + "\t" + o[1]); }
		 */
	}
}
