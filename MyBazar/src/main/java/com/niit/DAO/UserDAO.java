package com.niit.DAO;

import java.util.List;


import com.niit.model.User;

public interface UserDAO {
	public boolean addUser(User user);
	
	public boolean updateUser(User user);
	
	public boolean deleteUseer(User user);
	
	//To fetch user by id
	public User getUserByid(int user_id);
	public List<User> userCategory();

	public User getUserByEmail(String username);
	

}
