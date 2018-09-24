package com.sac.main;

import com.sac.common.dao.HibernateConfigurationFactory;
import com.sac.dao.UserDAO;
import com.sac.entity.User;

public class HibernateCRUDMain {

	public static void main(String[] args) {
		
		User user = new User();
		user.setFirstName("Virendar");
		user.setLastName("Sehwag");
		user.setEmailId("Virendar@Sehwag.com");
		user.setGender("Male");
		
		UserDAO userDAO = HibernateConfigurationFactory.getUserDAOInstance();
		int userID = userDAO.save(user);
		System.out.println("Saved User ID is " + userID);

	}

}
