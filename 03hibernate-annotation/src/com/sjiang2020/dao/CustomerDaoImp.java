package com.sjiang2020.dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sjiang2020.model.Customer;

public class CustomerDaoImp implements CustomerDao {

	Configuration configuration;
	SessionFactory sessionFactory;

	public CustomerDaoImp() {

		configuration = new Configuration();
		sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

	}

	@Override
	public void createCustomer() {

		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(new Customer("song", "jiang", 25));
			transaction.commit();
			session.close();
			sessionFactory.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}

	}

}
