package com.ZhangShuo.Dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ZhangShuo.Dao.Mapper.userDaoInterface;
import com.ZhangShuo.Entity.Page;
import com.ZhangShuo.Entity.User;

@Repository
@Transactional
public class userDaoImpl implements userDaoInterface{
	@Autowired
	private SessionFactory sessionFactory;

	public List<User> getAllUser() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		return list;
	}

	public User getuser(int users_id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User u where u.id=?";
		Query query = session.createQuery(hql).setParameter(0, users_id);
		User user = (User) query.uniqueResult();
		return user;

	}

	public User getUser(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User user where user.username=? and user.password=?");
		query.setParameter(0, username);
		query.setParameter(1, password);
		return (User) query.uniqueResult();
	}

	public boolean insert(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(user);
			session.flush();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			return false;
		}
		return true;
	}

	public List<User> getSomeUser(Page page) throws SQLException {
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
			String sql = "from User order by id";
			session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			query.setFirstResult(begin);
			query.setMaxResults(end - begin + 1);
			List<User> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			return null;
		}
	}

	public int getCount() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from User";
		Query query = session.createQuery(hql);
		Number num = (Number) query.uniqueResult();
		return num.intValue();
	}

	public boolean delete(User user) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(user);
			session.flush();

		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			return false;
		}
		return true;
	}

	public boolean update(User user) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(user);
			session.flush();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			return false;
		}
		return true;
	}
}
