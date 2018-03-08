package com.ZhangShuo.Dao.Mapper;

import java.util.List;

import com.ZhangShuo.Entity.Admin;
import com.ZhangShuo.Entity.Order;
import com.ZhangShuo.Entity.User;

public interface orderDaoInterface {
	public boolean insertOrder(Order order);
	public List<Order> getOrder(User user);
	public Order getOneOrder(int order_id);
	public boolean deleteOrderByUsers(User user);
	public boolean delete(Order order);
	public boolean deleteAllOrder(Admin admin);
	public boolean update(Order order);
}
