package com.ZhangShuo.Dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ZhangShuo.Dao.Mapper.order_DetailsDaoInterface;
import com.ZhangShuo.Entity.Admin;
import com.ZhangShuo.Entity.Book;
import com.ZhangShuo.Entity.Order;
import com.ZhangShuo.Entity.Order_details;

@Repository
@Transactional
public class order_DetailsDaoImpl implements order_DetailsDaoInterface{
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Order_details> get_Order_details(Order order) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "from Order_details od where od.order=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, order);
			List<Order_details> list = (List<Order_details>) query.list();	
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			return null;
		}
	}
	public boolean deleteOrder_detailsByBook(Book book) {	
		Session session = sessionFactory.getCurrentSession();
		try {			
			String hql = "delete from Order_details where book_id=?";	
			Query query = session.createQuery(hql);
			query.setParameter(0, book.getBook_id());
			query.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return false;
		}	
		return true;
	}
	public boolean deleteOrder_detailsByOrder(Order order) {	
		Session session = sessionFactory.getCurrentSession();
		try {			
			String hql = "delete from Order_details where order_id=?";	
			Query query = session.createQuery(hql);
			query.setParameter(0, order.getProxy_id());
			query.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return false;
		}
		return true;
	}
	public boolean insertOrder_details(Order_details order_details) {
		Session session = sessionFactory.getCurrentSession();
		try {		
			session.save(order_details);
			session.flush();
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return false;
		}	
		return true;
	}	
	public boolean deleteAllOrder_details(Admin admin) {	
		Session session = sessionFactory.getCurrentSession();
		try {			
			String hql = "delete from Order_details";	
			Query query = session.createQuery(hql);
			query.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return false;
		}	
		return true;
	}
}
