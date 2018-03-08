package com.ZhangShuo.Action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ZhangShuo.Entity.Book;
import com.ZhangShuo.Entity.Order;
import com.ZhangShuo.Entity.Order_details;
import com.ZhangShuo.Entity.User;
import com.ZhangShuo.Interface.op_Something;
import com.ZhangShuo.Service.Mapper.orderServiceInterface;
import com.ZhangShuo.Service.Mapper.order_DetailsServiceInterface;
import com.ZhangShuo.Service.Mapper.userServiceInterface;


@Controller
@RequestMapping("/Admin")
public class adminOpOrderAction implements op_Something{
	@Autowired
	private orderServiceInterface orderservice;
	@Autowired
	private userServiceInterface userservice;
	@Autowired
	private User user;
	@Autowired
	private Order order;
	@Autowired
	private List<Order> orderlist;
	@Autowired
	private order_DetailsServiceInterface ods;
	private HashMap<Book, Integer> details;
	private static int reorderid = -1;
	@RequestMapping("/op_Order")
	public String showList(HttpServletRequest request,Model model) {
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		user = userservice.getUser(user_id);
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
		model.addAttribute("orderlist",orderlist);
		
		return "Admin/op_Order/orderlist";
	}
	@RequestMapping("/op_OrdershowUser")
	public String showUser(HttpServletRequest request,Model model) {
		model.addAttribute("userlist", userservice.getAllUser());
		return "Admin/op_Order/userlist";
	}
	@Override
	public String add(HttpServletRequest request, Model model) throws SQLException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		return null;
	}
	@RequestMapping("/deleteOrder")
	@Override
	public String delete(HttpServletRequest request, Model model) throws SQLException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		order = orderservice.getOneOrder(order_id);
		if(reorderid!=order.getProxy_id()) {
			if (orderservice.delete(order)) {
				model.addAttribute("msg", "删除成功");
				reorderid = order.getProxy_id();
			}
		} else {
			return op_Failed();
		}
		return showUser(request, model);
	}
	@RequestMapping("/updateOrder")
	@Override
	public String update(HttpServletRequest request, Model model) throws SQLException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String address = request.getParameter("address");
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		order = orderservice.getOneOrder(order_id);
		order.setAddress(address);
		if (orderservice.update(order)) {
			model.addAttribute("msg", "更新成功");
		} else {
			return op_Failed();
		}
		return showUser(request, model);
		
	}
	@RequestMapping("/ToupdateOrder")
	public String ToupdateUser(HttpServletRequest request, Model model) {
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		String address = request.getParameter("address");
		model.addAttribute("order_id", order_id);
		model.addAttribute("address", address);
		return "Admin/op_Order/updateOrder";
	}
	private String op_Failed() {
		return "Admin/failure";
	}
}
