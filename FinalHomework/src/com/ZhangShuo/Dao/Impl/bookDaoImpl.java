package com.ZhangShuo.Dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ZhangShuo.Dao.Mapper.bookDaoInterface;
import com.ZhangShuo.Entity.Book;
import com.ZhangShuo.Entity.Page;



@Repository
@Transactional
public class bookDaoImpl implements bookDaoInterface{
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Book book;
	public List<Book> getAllBook() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Book");
		List<Book> list = query.list();
		return list;
		
	}

	public Book getBook(int book_id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Book where book_id=?";
		Query query = session.createQuery(hql).setParameter(0, book_id);
		book = (Book)query.uniqueResult();
		return book;
		
	}
	public List<Book> getSomeBook(Page page) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		page.setColumn_count(getCount());
		page.setPage_count();
		int begin;
		int end = 1;
		if (page.getPage_count() == 0 || page.getPage_count() == 1) {
			begin = 1;
			end = page.getColumn_count();
		} else if (page.getCurrent_page() == page.getPage_count()) {
			begin = (page.getPage_count() - 1) * page.getColumn_page() + 1;
			end = page.getColumn_count();
		} else {
			begin = (page.getCurrent_page() - 1) * page.getColumn_page() + 1;
			end = begin + page.getColumn_page() - 1;
		}
		try {
			String sql = "from Book order by book_id";
			session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			query.setFirstResult(begin);
			query.setMaxResults(end-begin+1);
			List<Book> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			return null;
		}	
	}

	public int getCount() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from Book";
		Query query = session.createQuery(hql);
		Number num = (Number)query.uniqueResult();
		return num.intValue(); 
	}

	public boolean insert(Book book) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(book);
			session.flush();
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return false;
		}	
		return true;
	}

	public boolean delete(Book book) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(book);
			session.flush();
			
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return false;
		}	
		return true;
	}

	public boolean update(Book book) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(book);
			session.flush();
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();	
			return false;
		}	
		return true;
}
}