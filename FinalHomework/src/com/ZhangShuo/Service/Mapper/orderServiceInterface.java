package com.ZhangShuo.Service.Mapper;

import java.util.List;

import com.ZhangShuo.Entity.Admin;
import com.ZhangShuo.Entity.Order;
import com.ZhangShuo.Entity.User;

public interface orderServiceInterface {
	public boolean insertOrder(Order order) ;
	public List<Order> getOrder(User user) ;
	public Order getOneOrder(int order_id);
	public boolean deleteOrderByUsers(User user) ;
	public boolean deleteAllOrder(Admin admin);
	public boolean delete(Order order);
	public boolean update(Order order);
}
