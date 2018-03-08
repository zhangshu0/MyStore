package com.ZhangShuo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ZhangShuo.Dao.Mapper.cartDaoInterface;
import com.ZhangShuo.Entity.Admin;
import com.ZhangShuo.Entity.Cart;
import com.ZhangShuo.Entity.Cart_details;
import com.ZhangShuo.Entity.User;
import com.ZhangShuo.Service.Mapper.cartServiceInterface;

@Service
@Transactional
public class cartServiceImpl implements cartServiceInterface{
	@Autowired
	private cartDaoInterface cartdao;

	public boolean insertCart(Cart cart) {
		return cartdao.insertCart(cart);
	}

	public Cart getCart(User user) {
		return cartdao.getCart(user);
	}

	public Cart getCart(Cart_details cd) {
		return cartdao.getCart(cd);
	}

	public boolean deleteCartByUsers(User user) {
		return cartdao.deleteCartByUsers(user);
	}

	public boolean deleteAllCart_details(Admin admin) {
		return cartdao.deleteAllCart_details(admin);
	}

	public boolean update(Cart cart) {
		// TODO Auto-generated method stub
		return cartdao.update(cart);
	}
}
