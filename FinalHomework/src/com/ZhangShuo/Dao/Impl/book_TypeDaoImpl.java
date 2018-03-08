package com.ZhangShuo.Dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ZhangShuo.Dao.Mapper.book_TypeDaoInterface;
import com.ZhangShuo.Entity.Book_Type;


@Repository
@Transactional 
public class book_TypeDaoImpl implements book_TypeDaoInterface{
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Book_Type book_type;
	public String getName(Book_Type bt) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Book_Type where types_id = ?");
		String type_name = (String) query.setParameter(0, bt.getTypes_id()).uniqueResult();
		session.close();
		return type_name;
	}
	public List<Book_Type> getAllBook_Type() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Book_Type");
		List<Book_Type> list = query.list();
		return list;
		
	}

	public Book_Type getBook_Type(int book_id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Book_Type where types_id=?";
		Query query = session.createQuery(hql).setParameter(0, book_id);
		book_type = (Book_Type)query.uniqueResult();
		return book_type;	
	}
	public int getCount() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from Book";
		Query query = session.createQuery(hql);
		Number num = (Number)query.uniqueResult();
		return num.intValue(); 
	}

	public boolean insert(Book_Type book_type) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(book_type);
			session.flush();
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return false;
		}	
		return true;
	}

	public boolean delete(Book_Type book_type) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(book_type);
			session.flush();
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return false;
		}	
		return true;
	}

	public boolean update(Book_Type book_type) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(book_type);
			session.flush();
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return false;
		}	
		return true;
}
}
