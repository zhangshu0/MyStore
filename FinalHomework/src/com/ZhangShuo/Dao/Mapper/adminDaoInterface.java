package com.ZhangShuo.Dao.Mapper;

import java.util.List;

import com.ZhangShuo.Entity.Admin;

public interface adminDaoInterface {
	public List<Admin> getAllAdmin();
	public Admin getAdmin(int admin_id);
	public Admin getAdmin(String username, String password);
}
