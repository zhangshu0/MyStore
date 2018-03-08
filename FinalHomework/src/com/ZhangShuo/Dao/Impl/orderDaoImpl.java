package com.ZhangShuo.Dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ZhangShuo.Dao.Mapper.orderDaoInterface;
import com.ZhangShuo.Entity.Admin;
import com.ZhangShuo.Entity.Order;
import com.ZhangShuo.Entity.User;


@Repository
@Transactional
public class orderDaoImpl implements orderDaoInterface{
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private List<Order> orderlist;
	@Autowired
	private Order order;
	public boolean insertOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();
		try {	
			session.save(order);
			session.flush();
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return false;
		}	
		return true;
	}	
	public List<Order> getOrder(User user) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "from Order o where o.user = ?";
			Query query = session.createQuery(hql);
			query.setParameter(0, user);
			orderlist = (List<Order>)query.list();
			return orderlist;
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return null;
		}	
	}	
	public Order getOneOrder(int order_id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "from Order o where o.proxy_id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, order_id);
			order = (Order) query.uniqueResult();
			return order;
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return null;
		}	
	}	
	public boolean deleteOrderByUsers(User user) {	
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "delete from Order where users_id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, user.getId());
			query.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return false;
		}	
		return true;
	}
	public boolean delete(Order order) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(order);
			session.flush();

		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			return false;
		}
		return true;
	}
	public boolean deleteAllOrder(Admin admin) {	
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "delete from Order";
			Query query = session.createQuery(hql);
			query.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return false;
		}	
		return true;
	}
	public boolean update(Order order) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(order);
			session.flush();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			return false;
		}
		return true;
	}
}
