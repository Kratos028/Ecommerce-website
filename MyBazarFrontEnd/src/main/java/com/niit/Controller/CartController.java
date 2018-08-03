package com.niit.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.CartDAO;
import com.niit.DAO.ProductDAO;
import com.niit.model.Cart;
import com.niit.model.Products;

@Controller
public class CartController {
	@Autowired
	ProductDAO productDAO;

	@Autowired
	CartDAO cartDAO;
	
	@RequestMapping("/Cart")
	public String showCart(Model m,HttpSession session)
	{
		String username = (String) session.getAttribute("username");
		List<Cart> cartitem = cartDAO.showCartItem(username);

		m.addAttribute("cartitems", cartitem);
		m.addAttribute("total", this.calculateTotalAmount(cartitem));
		return "Cart";
	}

	@RequestMapping("/addToCart/{product_id}")
	public String addCart(@RequestParam("quantity") int quantity, @PathVariable("product_id") int product_id, Model m,
			HttpSession session) {
		String name=SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println(name);
		if(name.equals("anonymousUser")) {
			return "redirect:/login";
		}
		
		Products products = productDAO.getProductById(product_id);
		String username = (String) session.getAttribute("username");

		Cart cart = new Cart();
		cart.setProductid(products.getProduct_id());
		cart.setProductName(products.getProduct_name());
		cart.setQuantity(quantity);
		cart.setPrice(products.getPrice());
		cart.setUsername(username);
		cart.setStatus("NA");
		cartDAO.addCart(cart);
		
		return "redirect:/Cart";
	}

	public int calculateTotalAmount(List<Cart> cartitem) {
		int total = 0;
		int count = 0;
		while (count < cartitem.size()) {
			Cart cart = cartitem.get(count);
			total = (int) (total + cart.getQuantity() * cart.getPrice());
			count++;
		}
		return total;
	}

	@RequestMapping("/updateCartItem/{cartItemid}")
	public String updateProduct(@RequestParam("quantity") int quantity, @PathVariable("cartItemid") int cartItemid,
			HttpSession session, Model m) {
		
		Cart cart = cartDAO.getItemByCart(cartItemid);
		cart.setQuantity(quantity);
		cartDAO.updateCart(cart);
		
		return "redirect:/Cart";
		
	}
	@RequestMapping("/deleteCartItem/{cartItemid}")
	public String DeleteProduct(@PathVariable("cartItemid") int cartItemid,
			HttpSession session, Model m) {
		
		Cart cart = cartDAO.getItemByCart(cartItemid);
		String username = (String) session.getAttribute("username");
		cartDAO.deleteCart(cart);
		List<Cart> cartItem =cartDAO.showCartItem(username);
		m.addAttribute("cartitem",cartItem);
		m.addAttribute("total",this.calculateTotalAmount(cartItem));
		return "redirect:/Cart";
		
	}
	@RequestMapping("/continueShopping")
	public String cont(Model m)
	{
		m.addAttribute("produclist", productDAO.listProdcut());
		return "ProductDisplay";
	}
	

}
