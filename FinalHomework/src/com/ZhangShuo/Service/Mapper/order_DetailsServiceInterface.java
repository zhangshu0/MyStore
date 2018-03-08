package com.ZhangShuo.Service.Mapper;

import java.util.List;

import com.ZhangShuo.Entity.Admin;
import com.ZhangShuo.Entity.Book;
import com.ZhangShuo.Entity.Order;
import com.ZhangShuo.Entity.Order_details;

public interface order_DetailsServiceInterface {
	public List<Order_details> get_Order_details(Order order) ;
	public boolean deleteOrder_detailsByBook(Book book) ;
	public boolean deleteOrder_detailsByOrder(Order order) ;
	public boolean insertOrder_details(Order_details order_details);
	public boolean deleteAllOrder_details(Admin admin);
}
