package com.ZhangShuo.Dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ZhangShuo.Dao.Mapper.cartDaoInterface;
import com.ZhangShuo.Entity.Admin;
import com.ZhangShuo.Entity.Cart;
import com.ZhangShuo.Entity.Cart_details;
import com.ZhangShuo.Entity.User;

@Repository
@Transactional
public class cartDaoImpl implements cartDaoInterface{
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Cart cart;
	public boolean insertCart(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		try {	
			session.save(cart);
			
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return false;
		}	
		return true;
	}	

	public Cart getCart(User user) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "from Cart c where c.user=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, user);
			cart = (Cart)query.uniqueResult();
			return cart;
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return null;
		}	
	}	
	public Cart getCart(Cart_details cd) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "from Cart where proxy_id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, cd.getCart().getProxy_id());
			cart = (Cart) query.uniqueResult();
			return cart;
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return null;
		}	
	}	
	public boolean deleteCartByUsers(User user) {	
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "delete from Cart c where c.user=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, user);
			query.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return false;
		}	
		return true;
	}
	public boolean deleteAllCart_details(Admin admin) {	
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "delete from Cart";
			Query query = session.createQuery(hql);
			query.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return false;
		}	
		return true;
	}

	public boolean update(Cart cart) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {	
			session.update(cart);
			
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return false;
		}	
		return true;
	}
}
