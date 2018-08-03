package com.niit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.CategoryDAO;
import com.niit.model.Category;

@Controller

public class CategoryController {
	@Autowired
	CategoryDAO categoryDAO;
	boolean f = false;
	
	
@RequestMapping(value="/category")
public String showCategory(Model m) {
	f=false;
	List<Category> listcategories =categoryDAO.listCategory();
	m.addAttribute("categorylist",listcategories);
	m.addAttribute("flag", f);
	return "Category";
}
@RequestMapping(value="/category/InsertCategory" ,method=RequestMethod.POST)
	public String insertCat(@RequestParam("categoryName")String categoryName,@RequestParam("categoryDesc")String categoryDesc,Model m)
	{f=false;
		Category category = new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		categoryDAO.addCategory(category);
		List<Category> listcategories =categoryDAO.listCategory();
		m.addAttribute("categorylist",listcategories);
		m.addAttribute("flag", f);
		return "redirect:/category";
	}
@RequestMapping(value="/category/deleteCategory/{categoryId}")
public String deleteCat(@PathVariable("categoryId")int categoryId,Model m)
{f=false;
	Category category = categoryDAO.getCategory(categoryId);
	categoryDAO.deleteCategory(category);
	List<Category> listcategories =categoryDAO.listCategory();
	m.addAttribute("categorylist",listcategories);
	m.addAttribute("flag", f);
	return "redirect:/category";
}
@RequestMapping(value="/category/editCategory/{categoryId}")
public String UpdateCat(@PathVariable("categoryId")int categoryId,Model m)
{f=true;
	Category category = categoryDAO.getCategory(categoryId);
	m.addAttribute("categoryData", category);
	m.addAttribute("flag", f);
	return "Category";
}
@RequestMapping(value="/category/updateCategory",method=RequestMethod.POST)
public String UpdateCat(@RequestParam("categoryId")int categoryId,@RequestParam("categoryName")String categoryName,@RequestParam("categoryDesc")String categoryDesc,Model m)
{
	f = false;
	Category category = categoryDAO.getCategory(categoryId);
	category.setCategoryName(categoryName);
	category.setCategoryDesc(categoryDesc);
	categoryDAO.updateCategory(category);
	List<Category> listcategories =categoryDAO.listCategory();
	m.addAttribute("categorylist",listcategories);
	m.addAttribute("flag", f);
	return "redirect:/category";
	
}

	

}
