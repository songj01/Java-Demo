package com.sjiang2020.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sjiang2020.model.User;

public class UserDaoImp implements UserDao {

	private Configuration configuration;
	private SessionFactory sessionFactory;

	public UserDaoImp() {
		try {
			configuration = new Configuration();
			sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createUser() {
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(new User("cindy", "cindys password"));
			transaction.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}

	}

}
