package com.niit.Controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.DAO.ProductDAO;
import com.niit.DAO.UserDAO;
import com.niit.model.User;

@Controller
public class UserController {
	@Autowired
	ProductDAO productDao;
	@Autowired
	UserDAO userDAO;

	@RequestMapping("/login_success")
	public String loginSuccess(Model m,HttpSession session)
	{
		String page="";
		boolean loggedin = false;
		SecurityContext securitycontext = SecurityContextHolder.getContext();
		Authentication auth = securitycontext.getAuthentication();
		String username = auth.getName();
		
		User user=userDAO.getUserByEmail(username);
		session.setAttribute("user", user);
		
		Collection<GrantedAuthority> roles = (Collection<GrantedAuthority>) auth.getAuthorities();
		for(GrantedAuthority role:roles)
		{
			System.out.println(roles.toString());
			session.setAttribute("role",role.getAuthority());
			if(role.getAuthority().equals("USER_ROLE"))
			{
				loggedin=true;
				page="index";
				m.addAttribute("productCategory", productDao.listProdcut());
				session.setAttribute("loggedin",loggedin);
				session.setAttribute("username", username);
			}
			else
			{
				loggedin=true;
				page="AdminHome";
				session.setAttribute("loggedin",loggedin);
				session.setAttribute("username", username);
			}
		}
		
		return  page;
	}
}
