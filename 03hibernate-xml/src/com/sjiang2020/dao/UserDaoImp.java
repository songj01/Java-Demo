package com.sjiang2020.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}

	}

	@Override
	public List<User> findAll() {

		Session session = null;
		try {
			session = sessionFactory.openSession();
			List<User> list = session.createQuery("from User").list();

			if (list != null) {
				for (User user : list) {
					System.out.println(user);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public User findById(int id) {

      Session session = null;
      
    try {
    	
    	session = sessionFactory.openSession();
    	Query query = session.createQuery("select * from User where id = ?");
    	query.setInteger(1, 2);
    	
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		session.close();
	}
     
		return null;
	}

}
