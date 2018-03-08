package com.ZhangShuo.Service.Impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ZhangShuo.Dao.Mapper.userDaoInterface;
import com.ZhangShuo.Entity.Page;
import com.ZhangShuo.Entity.User;
import com.ZhangShuo.Service.Mapper.userServiceInterface;

@Service
@Transactional
public class userServiceImpl implements userServiceInterface{
	@Autowired
	private userDaoInterface userDao;

	public List<User> getAllUser() {
		List<User> list = userDao.getAllUser();
		return list;
	}
	public User getUser(String username, String password) {	
		return userDao.getUser(username, password);
	}
	public User getUser(int users_id) {
		return userDao.getuser(users_id);
	}
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return userDao.insert(user);
	}
	public List<User> getSomeUser(Page page) throws SQLException {
		return userDao.getSomeUser(page);
	}
	public int getCount() {
		return userDao.getCount();
	}
	public boolean delete(User user) {
		return userDao.delete(user);
	}
	public boolean update(User user) {
		return userDao.update(user);
	}
}
