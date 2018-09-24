package com.sac.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sac.common.dao.HibernateConfigurationFactory;
import com.sac.entity.User;

public class UserDAOImpl implements UserDAO {

	@SuppressWarnings("unused")
	@Override
	public int save(User user) {
		Integer userId = null;
		Session session = HibernateConfigurationFactory.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			transaction.begin();
			userId = (Integer) session.save(user);
			transaction.commit();
		}catch(HibernateException e) {
			if(transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return userId;
	}

	@Override
	public Object get(int userID) {
		Session session = HibernateConfigurationFactory.getSessionFactory().openSession();
		Transaction transaction = null;
		User user = null;
		try {
			transaction = session.beginTransaction();
			transaction.begin();
			 user = session.get(User.class, userID);
			transaction.commit();
		}catch(HibernateException e) {
			if(transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return user;
	}

	@Override
	public void update(Integer userId, String emailId) {
		Session session = HibernateConfigurationFactory.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			transaction.begin();
			User user = session.get(User.class, userId);
			user.setEmailId(emailId);
			session.update(user);
			transaction.commit();
		}catch(HibernateException e) {
			if(transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}

	@Override
	public void delete(int userID) {
		Session session = HibernateConfigurationFactory.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			transaction.begin();
			User user = session.get(User.class, userID);
			session.delete(user);
			transaction.commit();
		}catch(HibernateException e) {
			if(transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}

}
