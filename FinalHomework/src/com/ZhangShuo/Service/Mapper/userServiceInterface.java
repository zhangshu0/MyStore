package com.ZhangShuo.Service.Mapper;

import java.sql.SQLException;
import java.util.List;

import com.ZhangShuo.Entity.Page;
import com.ZhangShuo.Entity.User;

public interface userServiceInterface {
	public List<User> getAllUser();
	public User getUser(String username, String password) ;
	public User getUser(int users_id);
	public boolean register(User user) ;
	public List<User> getSomeUser(Page page) throws SQLException ;
	public int getCount() ;
	public boolean delete(User user);
	public boolean update(User user) ;
}
