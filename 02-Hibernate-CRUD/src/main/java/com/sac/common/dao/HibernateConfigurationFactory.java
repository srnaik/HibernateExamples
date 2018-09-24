package com.sac.common.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sac.dao.UserDAO;
import com.sac.dao.UserDAOImpl;

public class HibernateConfigurationFactory {
	
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	
	static {
		configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static UserDAO getUserDAOInstance() {
		return new UserDAOImpl();
	}

}
