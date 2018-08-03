package com.niit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.UserDAO;
import com.niit.model.User;

@Controller
public class RegisterController {
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/insertUser")
	public String registerUser(@RequestParam("email") String email, @RequestParam("firstname") String name,@RequestParam("passwd") String password,@RequestParam("PhoneNumber") String phone,Model m)
	{
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		user.setPhone_no(phone);
		user.setRole("USER_ROLE");
		user.setEnabled(true);
		userDAO.addUser(user);
		return "Login";
		
	}

}
