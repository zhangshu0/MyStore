package com.ZhangShuo.Dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ZhangShuo.Dao.Mapper.adminDaoInterface;
import com.ZhangShuo.Entity.Admin;

@Repository
@Transactional 
public class adminDaoImpl implements adminDaoInterface{
	@Autowired
	private SessionFactory sessionFactory;
	public List<Admin> getAllAdmin(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Admin");
		List<Admin> list = query.list();
		return list;
	}
	public Admin getAdmin(int admin_id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Admin a where a.admin_id=?";
		Query query = session.createQuery(hql).setParameter(0, admin_id);
		Admin admin = (Admin)query.uniqueResult();
		return admin;
	}
	public Admin getAdmin(String username, String password){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Admin admin where admin.username=? and admin.password=?");
		query.setParameter(0, username);
		query.setParameter(1, password);	  
		return (Admin) query.uniqueResult();
	}
}
