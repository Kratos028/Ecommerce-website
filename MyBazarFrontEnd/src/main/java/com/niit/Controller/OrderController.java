package com.niit.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.CartDAO;
import com.niit.DAO.OrderDetailDAO;
import com.niit.model.Cart;
import com.niit.model.OrderDetail;

@Controller
public class OrderController {
	@Autowired 
	CartDAO cartDAO;
	
	@Autowired
	OrderDetailDAO OrderDAO;
	
	@RequestMapping("/checkout")
	public String checkout(Model m,HttpSession session)
	{
		String username = (String) session.getAttribute("username");
		List<Cart> cartItem =cartDAO.showCartItem(username);
		m.addAttribute("cartitem",cartItem);
		m.addAttribute("total",this.calculateTotalAmount(cartItem));
		return "Order";
		
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
	@RequestMapping("/payment")
	public String paymentpage(Model m,HttpSession session)
	{
		String username = (String) session.getAttribute("username");
		List<Cart> cartItem =cartDAO.showCartItem(username);
		m.addAttribute("cartitem",cartItem);
		m.addAttribute("total",this.calculateTotalAmount(cartItem));
		return "Payment";
	}
	@RequestMapping(value="/paymentprocess",method=RequestMethod.POST)
	public String process(@RequestParam("payment")String modepayment,Model m,HttpSession session)
	{
		String username = (String) session.getAttribute("username");
		List<Cart> cartItem =cartDAO.showCartItem(username);
		m.addAttribute("cartitems",cartItem);
		int totalpur = this.calculateTotalAmount(cartItem);
		m.addAttribute("total",totalpur);
		
		

		OrderDetail order = new OrderDetail();
		order.setModepayment(modepayment);
		order.setUsername(username);
		order.setTotalPurchase(totalpur);
		order.setOrderDate(new java.util.Date());
		OrderDAO.insertOrder(order);
		OrderDAO.updateOrder(username);
		
		m.addAttribute("orderDetail",order);
		return "Receipt";
	}
}
