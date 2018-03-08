package com.ZhangShuo.Dao.Mapper;

import java.sql.SQLException;
import java.util.List;

import com.ZhangShuo.Entity.Page;
import com.ZhangShuo.Entity.User;

public interface userDaoInterface {
	public List<User> getAllUser();
	public User getuser(int users_id);
	public User getUser(String username, String password);
	public List<User> getSomeUser(Page page) throws SQLException;
	public int getCount();
	public boolean insert(User user);
	public boolean delete(User user);
	public boolean update(User user);
}
