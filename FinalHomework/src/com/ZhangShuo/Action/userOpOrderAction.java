package com.ZhangShuo.Action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ZhangShuo.Entity.Book;
import com.ZhangShuo.Entity.Order;
import com.ZhangShuo.Entity.Order_details;
import com.ZhangShuo.Entity.User;
import com.ZhangShuo.Service.Mapper.orderServiceInterface;
import com.ZhangShuo.Service.Mapper.order_DetailsServiceInterface;

@Controller
//@Scope("prototype")
@RequestMapping("/User")
public class userOpOrderAction {
	@Autowired
	private orderServiceInterface orderservice;
	@Autowired
	private List<Order> orderlist;
	@Autowired
	private order_DetailsServiceInterface ods;
	@Autowired
	private Order order;
	@Autowired
	private Order_details order_details;
	private HashMap<Book, Integer> details;
	private int size = -1;
	private float totalprice=-1;

	public userOpOrderAction() {
		super();
		// TODO Auto-generated constructor stub
		details = new HashMap<Book, Integer>();
	}

	@RequestMapping("/CreateOrder")
	public String OrderConfirm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String address = user.getAddress();
		model.addAttribute("address", address);
		return "User/confirmOrder";
	}

	@RequestMapping("/showOrder")
	public String showOrder(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		orderlist = orderservice.getOrder(user);
		for (int i = 0; i < orderlist.size(); i++) {
			List<Order_details> list = ods.get_Order_details(orderlist.get(i));
			details = new HashMap<Book, Integer>();
			for (int j = 0; j < list.size(); j++) {
				Order_details od = list.get(j);
				Book book = od.getBook();
				int number = od.getNumber();
				details.put(book, number);
			}
			orderlist.get(i).setMap_details(details);
		}
		session.setAttribute("orderlist", orderlist);
		return "User/showOrder";
	}

	@RequestMapping("/saveOrder")
	private String saveOrder(HttpServletRequest request,Model model) {
		String address = request.getParameter("address");
		HttpSession session = request.getSession();
		if(address.equals("")) {
			session.setAttribute("message", "请输入合法收货地址");
			return OrderConfirm(request,model);
		}
		User user = (User) session.getAttribute("user");
		details = (HashMap<Book, Integer>) session.getAttribute("details");
		float price = Float.parseFloat(request.getParameter("totalPrice"));
		if (!details.isEmpty() && size != details.size()&&price!=totalprice) {
			order.setUser(user);
			order.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			order.setTotalPrice(price);
			order.setAddress(address);
			orderservice.insertOrder(order);
			Iterator it = details.keySet().iterator();
			while (it.hasNext()) {
				Book book = (Book) it.next();
				order_details.setBook(book);
				order_details.setOrder(order);
				order_details.setNumber(details.get(book));
				ods.insertOrder_details(order_details);
			}
				totalprice=Float.parseFloat(request.getParameter("totalPrice"));
				size = details.size();
				return showOrder(request);
			} else {
				return showOrder(request);
			}
		}
	
}
