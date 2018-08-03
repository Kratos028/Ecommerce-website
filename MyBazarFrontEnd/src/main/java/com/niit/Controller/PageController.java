package com.niit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.DAO.ProductDAO;

@Controller
public class PageController {
	@Autowired
	ProductDAO productDAO;

		@RequestMapping(value="/login")
		public String showLoginPage()
		{
			return "Login";
		}
		@RequestMapping(value="/register")
		public String showRegisterPage()
		{
			return "Register";
		}
		@RequestMapping(value="/contactus")
		public String showContactUs()
		{
			return "ContactUs";
		}
		@RequestMapping(value="/aboutus")
		public String showAboutUs() {
			return "AboutUs";
		}
		@RequestMapping(value="/")
		public String showHomePage(Model m)
		{
			m.addAttribute("produclist",productDAO.listProdcut());
			return "index";
		}
		
}
