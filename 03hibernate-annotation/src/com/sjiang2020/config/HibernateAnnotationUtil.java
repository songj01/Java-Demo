package com.sjiang2020.config;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.TransactionScoped;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sjiang2020.model.Customer;

public class HibernateAnnotationUtil {

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			try {
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
				Map<String, String> settings = new HashMap<>();
				settings.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
				settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/javaproject?serverTimezone=UTC");
				settings.put("hibernate.connection.username", "root");
				settings.put("hibernate.connection.password", "1023");

				settings.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
				settings.put("hibernate.show_sql", "true");
				settings.put("hibernate.format_sql", "true");
				settings.put("hibernate.hbm2ddl.auto", "update");

				settings.put("hibernate.minPoolSize", "5");
				settings.put("hibernate.maxPoolSize", "20");
				settings.put("hibernate.maxIdleTime", "30000");

				registry = registryBuilder.applySettings(settings).build();

				MetadataSources sources = new MetadataSources(registry).addAnnotatedClass(Customer.class);

				Metadata metadata = sources.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				System.out.println("SessionFactory create failed!!");
				if(registry !=null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}

		return sessionFactory;

	}

}
