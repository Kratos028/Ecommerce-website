package com.niit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.SupplierDAO;
import com.niit.model.Products;
import com.niit.model.Supplier;

@Controller
public class SupplierController {
	@Autowired
	SupplierDAO supplierDAO;
	boolean f = false;

	@RequestMapping(value = "/suppliermanage")
	public String showSupplier(Model m) {
		f = false;
		List<Supplier> listSupplier = supplierDAO.supplierCategories();
		m.addAttribute("supplierlist", listSupplier);
		m.addAttribute("flag", f);
		return "Supplier";
	}

	@RequestMapping(value = "/insertSupplier", method = RequestMethod.POST)
	public String insertSup(@RequestParam("suppliername") String name,
			@RequestParam("supplierDesc") String supplierDesc, @RequestParam("supplieraddress") String address,
			Model m) {
		f = false;
		Supplier sup = new Supplier();
		sup.setDealer_Name(name);
		sup.setDealer_desc(supplierDesc);
		sup.setDealer_address(address);
		supplierDAO.addSupplier(sup);
		List<Supplier> listSupplier = supplierDAO.supplierCategories();
		m.addAttribute("supplierlist", listSupplier);
		m.addAttribute("flag", f);

		return "redirect:/suppliermanage";
	}

	@RequestMapping("/deleteSupplier/{sup_id}")
	public String deleteSup(@PathVariable("sup_id") int sup_id, Model m) {
		f = false;
		Supplier sup = supplierDAO.getSupplierById(sup_id);
		supplierDAO.deleteSupplier(sup);
		List<Supplier> listSupplier = supplierDAO.supplierCategories();
		m.addAttribute("supplierlist", listSupplier);
		m.addAttribute("flag", f);
		return "redirect:/suppliermanage";

	}

	@RequestMapping("/editSupplier/{sup_id}")
	public String editSup(@PathVariable("sup_id") int sup_id,Model m)
	{
		f=true;
		Supplier sup=supplierDAO.getSupplierById(sup_id);
	
		m.addAttribute("supplierlist", sup);
		m.addAttribute("flag", f);
		return "Supplier";
	}

	@RequestMapping(value="/updateSupplier",method=RequestMethod.POST)
	public String updateSup(@RequestParam("sup_id")int sup_id,@RequestParam("suppliername")String name,@RequestParam("supplierDesc") String supplierDesc,@RequestParam("supplieraddress") String address,Model m)
	{
		f=false;
		Supplier sup = supplierDAO.getSupplierById(sup_id);
		sup.setDealer_Name(name);
		sup.setDealer_desc(supplierDesc);
		sup.setDealer_address(address);
		supplierDAO.updateSupplier(sup);
		List<Supplier> listSupplier = supplierDAO.supplierCategories();
		m.addAttribute("supplierlist", listSupplier);
		m.addAttribute("flag", f);
		return "redirect:/suppliermanage";
		
		
	}
	

}
