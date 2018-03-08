package com.ZhangShuo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ZhangShuo.Dao.Mapper.order_DetailsDaoInterface;
import com.ZhangShuo.Entity.Admin;
import com.ZhangShuo.Entity.Book;
import com.ZhangShuo.Entity.Order;
import com.ZhangShuo.Entity.Order_details;
import com.ZhangShuo.Service.Mapper.order_DetailsServiceInterface;

@Service
@Transactional
public class order_DetailsServiceImpl  implements order_DetailsServiceInterface{
	@Autowired
	private order_DetailsDaoInterface order_details_dao;
	
	public List<Order_details> get_Order_details(Order order) {
		return order_details_dao.get_Order_details(order);
	}
	public boolean deleteOrder_detailsByBook(Book book) {	
		return order_details_dao.deleteOrder_detailsByBook(book);
	}
	public boolean deleteOrder_detailsByOrder(Order order) {
		return order_details_dao.deleteOrder_detailsByOrder(order);
	}
	public boolean insertOrder_details(Order_details order_details) {
		return order_details_dao.insertOrder_details(order_details);
	}
	public boolean deleteAllOrder_details(Admin admin) {	
		return order_details_dao.deleteAllOrder_details(admin);
	}
}
