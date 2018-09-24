package com.sac.dao;

import com.sac.entity.User;

public interface UserDAO {
	
	public int save(User user);
	public Object get(int userID);
	public void update(Integer empId, String emailId);
	public void delete(int userID);
}
