package com.sac.main;

import com.sac.common.dao.HibernateConfigurationFactory;
import com.sac.dao.UserDAO;
import com.sac.entity.User;

public class HibernateCRUDMain {

	public static void main(String[] args) {
		
		/**
		 * Create
		 */
		User user = new User();
		user.setFirstName("Virendar");
		user.setLastName("Sehwag");
		user.setEmailId("Virendar@Sehwag.com");
		user.setGender("Male");
		
		UserDAO userDAO = HibernateConfigurationFactory.getUserDAOInstance();
		 int userID = userDAO.save(user);
		System.out.println("Saved User ID is " + userID);
		
		
		/**
		 * Read
		 */
		//User getUser = (User) userDAO.get(1);
		//System.out.println("Retrieved User" + getUser);
		
		/**
		 * Update
		 */
		userDAO.update(4, "Virat@Kohli.com");
		
		/**
		 * Delete
		 */
		//userDAO.delete(0);
		
	}

}
