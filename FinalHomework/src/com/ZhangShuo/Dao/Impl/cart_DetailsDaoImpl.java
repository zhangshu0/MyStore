package com.ZhangShuo.Dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ZhangShuo.Dao.Mapper.cart_DetailsDaoInterface;
import com.ZhangShuo.Entity.Admin;
import com.ZhangShuo.Entity.Book;
import com.ZhangShuo.Entity.Cart;
import com.ZhangShuo.Entity.Cart_details;

@Repository
@Transactional
public class cart_DetailsDaoImpl implements cart_DetailsDaoInterface{
	@Autowired
	private SessionFactory sessionFactory;

	public List<Cart_details> get_Cart_details(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "from Cart_details cd where cd.cart=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, cart);
			List<Cart_details> list = (List<Cart_details>) query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			return null;
		}
	}

	public boolean deleteCart_detailsByBook(Book book) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "delete from Cart_details where book_id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, book.getBook_id());
			query.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			return false;
		}
		return true;
	}

	public boolean deleteCart_detailsByCart(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "delete from Cart_details where cart_id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, cart.getProxy_id());
			query.executeUpdate();
		
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			return false;
		}
		return true;
	}

	public boolean insertCart_details(Cart_details cart_details) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(cart_details);
			
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			return false;
		}
		return true;
	}

	public boolean deleteAllCart_details(Admin admin) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "delete from Cart_details";
			Query query = session.createQuery(hql);
			query.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			return false;
		}
		return true;
	}
}
