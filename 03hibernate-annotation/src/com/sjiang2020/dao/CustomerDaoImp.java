package com.sjiang2020.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.sjiang2020.config.HibernateAnnotationUtil;
import com.sjiang2020.model.Customer;

public class CustomerDaoImp implements CustomerDao {

	SessionFactory sessionFactory;

	public CustomerDaoImp() {
		sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		if(sessionFactory == null) {
			System.out.println("sessionFactory get failed!");
		}
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

		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}

	}

	@Override
	public List<Customer> findAll() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			String sql = "from Customer";
			Query query = session.createQuery(sql);
			List<Customer> list = query.list();
			if (list != null) {
				for (Customer customer : list) {
					System.out.println(customer.toString());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Customer findById(int id) {
		
		Session session = null;
		Customer customer = null;
		try {
			session = sessionFactory.openSession();
			
			String sql = "from Customer where id = ?1";
			Query query = session.createQuery(sql);
			customer = (Customer) query.setInteger(1, id).list().get(0);
			System.out.println(customer);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return customer;
	}

}
