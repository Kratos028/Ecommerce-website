package com.niit.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.DAO.ProductDAO;
import com.niit.model.Products;


@Controller
public class ProductController {
	@Autowired
	ProductDAO productDAO;
	boolean f = false;

	@RequestMapping(value="/manageproducts")
	public String showProduct(Model m)
	{	f=false;
		List<Products> listproducts = productDAO.listProdcut();
		m.addAttribute("productCategory", listproducts);
		m.addAttribute("flag", f);
		return "Product";
	}
	@RequestMapping(value="/insertProdcuts",method=RequestMethod.POST)
	public String insertCategory(@RequestParam("productname")String product_name ,@RequestParam("productDesc")String description ,@RequestParam("productprice")double price,
			@RequestParam("productstock")int stock ,@RequestParam("productcategory")String product_category ,@RequestParam("productsupplier")int supplierId,@RequestParam("productcatid")int categoryId,@RequestParam("file")MultipartFile file, Model m)
	{
			f=false;
			Products product = new Products();
			product.setProduct_name(product_name);
			product.setDescription(description);
			product.setProduct_category(product_category);
			product.setPrice(price);
			product.setStock(stock);
			product.setCategoryId(categoryId);
			product.setSupplierId(supplierId);
			String path="C:\\Users\\Vaibhav Singh\\eclipse-workspace\\MyBazarFrontEnd\\src\\main\\webapp\\resources\\images\\";
			path=path+product.getCode()+".jpg";
			File file1 = new File(path);
			if(!file.isEmpty())
			{
				try
				{
					byte[] buffer = file.getBytes();
					FileOutputStream fos = new FileOutputStream(file1);
					BufferedOutputStream bs = new BufferedOutputStream(fos);
					bs.write(buffer);
					bs.close();
		
				}
				catch(Exception e)
				{
					System.out.println(e.getStackTrace());
				}
			}
			else
			{
				m.addAttribute("Error", "There is some error");
			}
			
			productDAO.addProduct(product);
			List<Products> listproducts = productDAO.listProdcut();
			m.addAttribute("productCategory", listproducts);
			m.addAttribute("flag", f);
			return "redirect:/manageproducts";
	}
	@RequestMapping("/deleteProducts/{product_id}")
	public String DeleteProduct(@PathVariable("product_id")int product_id,Model m)
	{
		f=false;
		Products product = productDAO.getProductById(product_id);
		productDAO.deleteProduct(product);
		List<Products> listproducts = productDAO.listProdcut();
		m.addAttribute("productCategory", listproducts);
		m.addAttribute("flag", f);
		return "redirect:/manageproducts";
	}
	@RequestMapping("/editProducts/{product_id}")
	public String editProduct(@PathVariable("product_id")int product_id,Model m)
	{	
		f=true;
		Products product = productDAO.getProductById(product_id);
		m.addAttribute("productCateogry", product);
		m.addAttribute("flag",f);
		
		return "Product";
	}
	@RequestMapping(value="/updateProduct",method=RequestMethod.POST)
	public String UpdateProduct(@RequestParam("product_id")int product_id,@RequestParam("productname")String product_name ,@RequestParam("productDesc")String description ,@RequestParam("productprice")double price,
			@RequestParam("productstock")int stock ,@RequestParam("productcategory")String product_category ,@RequestParam("productsupplier")int supplierId,@RequestParam("productcatid")int categoryId,Model m)
	{
		f=false;
		Products product = productDAO.getProductById(product_id);
		
		product.setProduct_name(product_name);
		product.setDescription(description);
		product.setProduct_category(product_category);
		product.setPrice(price);
		product.setStock(stock);
		product.setCategoryId(categoryId);
		product.setSupplierId(supplierId);
		productDAO.updateProduct(product);
		List<Products> listproducts = productDAO.listProdcut();
		m.addAttribute("productCategory", listproducts);
		m.addAttribute("flag", f);
		return "redirect:/manageproducts";
	}
	@RequestMapping("/productDisplay")
	public String displayProduct(Model m)
	{
		m.addAttribute("produclist",productDAO.listProdcut());
		return "ProductDisplay";
	}
	@RequestMapping("/totalproductinfo/{product_id}")
	public String totalProducts(@PathVariable("product_id")int product_id,Model m)
	{
		Products product = productDAO.getProductById(product_id);
		m.addAttribute("product",product);
		
		
		return "TotalProductDisplay";
	}
}
	
	

