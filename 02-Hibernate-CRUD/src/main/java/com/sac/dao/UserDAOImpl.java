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

}
