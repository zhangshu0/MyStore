package com.ZhangShuo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ZhangShuo.Dao.Mapper.orderDaoInterface;
import com.ZhangShuo.Entity.Admin;
import com.ZhangShuo.Entity.Order;
import com.ZhangShuo.Entity.User;
import com.ZhangShuo.Service.Mapper.orderServiceInterface;


@Service
@Transactional
public class orderServiceImpl implements orderServiceInterface{
	@Autowired
	private orderDaoInterface order_dao;

	public boolean insertOrder(Order order) {
		return order_dao.insertOrder(order);
	}
	public List<Order> getOrder(User user) {
		return order_dao.getOrder(user);
	}
	public Order getOneOrder(int order_id) {
		return order_dao.getOneOrder(order_id);
	}
	public boolean deleteOrderByUsers(User user) {	
		return order_dao.deleteOrderByUsers(user);
	}
	public boolean deleteAllOrder(Admin admin) {	
		return order_dao.deleteAllOrder(admin);
	}
	public boolean delete(Order order) {
		return order_dao.delete(order);
	}
	public boolean update(Order order) {
		return order_dao.update(order);
	}
}
