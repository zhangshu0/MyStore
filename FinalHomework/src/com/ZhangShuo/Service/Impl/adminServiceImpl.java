package com.ZhangShuo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ZhangShuo.Dao.Mapper.adminDaoInterface;
import com.ZhangShuo.Entity.Admin;
import com.ZhangShuo.Service.Mapper.adminServiceInterface;
@Service
@Transactional
public class adminServiceImpl implements adminServiceInterface{
	@Autowired
	private adminDaoInterface admindao;
	
	public List<Admin> getAllAdmin(){
		return admindao.getAllAdmin();
	}
	public Admin getAdmin(int admin_id) {
		return admindao.getAdmin(admin_id);
	}
	public Admin getAdmin(String username, String password){
		return admindao.getAdmin(username, password);
	}
}
