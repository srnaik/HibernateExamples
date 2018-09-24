package com.sac.Hibernate_Save;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sac.entity.User;

public class UserSaveMain {

	private static Configuration configuration;
	
	static {
		configuration = new Configuration().configure();
	}
	
	public static void main(String[] args) {
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try {
			User user = new User();
			user.setFirstName("Sourav");
			user.setLastName("Ganguly");
			user.setEmailId("Sourav@Ganguly.com");
			user.setGender("Male");
			transaction = session.beginTransaction();
			transaction.begin();
			Integer userId = (Integer)session.save(user);
			transaction.commit();
			System.out.println("Saved User ID is " + userId);
		}catch(HibernateException ex){
			if(transaction != null)
				transaction.rollback();
		}finally {
		session.close();	
		}
		
		
	}

}
