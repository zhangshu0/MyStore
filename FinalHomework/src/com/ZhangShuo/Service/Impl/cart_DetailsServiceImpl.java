package com.ZhangShuo.Service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ZhangShuo.Dao.Mapper.cart_DetailsDaoInterface;
import com.ZhangShuo.Entity.Admin;
import com.ZhangShuo.Entity.Book;
import com.ZhangShuo.Entity.Cart;
import com.ZhangShuo.Entity.Cart_details;
import com.ZhangShuo.Service.Mapper.cart_DetailsServiceInterface;

@Service
@Transactional
public class cart_DetailsServiceImpl implements cart_DetailsServiceInterface{
	@Autowired
	private cart_DetailsDaoInterface cart_details_dao;
	
	public List<Cart_details> get_Cart_details(Cart cart) {
		return cart_details_dao.get_Cart_details(cart);
	}
	public boolean deleteCart_detailsByBook(Book book) {
		return cart_details_dao.deleteCart_detailsByBook(book);
	}
	public boolean deleteCart_detailsByCart(Cart cart) {	
		return cart_details_dao.deleteCart_detailsByCart(cart);
	}
	public boolean insertCart_details(Cart_details cart_details) {
		return cart_details_dao.insertCart_details(cart_details);
	}
	public boolean deleteAllCart_details(Admin admin) {	
		return cart_details_dao.deleteAllCart_details(admin);
	}
}
