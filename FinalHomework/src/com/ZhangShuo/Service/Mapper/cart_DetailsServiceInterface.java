package com.ZhangShuo.Service.Mapper;

import java.util.List;

import com.ZhangShuo.Entity.Admin;
import com.ZhangShuo.Entity.Book;
import com.ZhangShuo.Entity.Cart;
import com.ZhangShuo.Entity.Cart_details;

public interface cart_DetailsServiceInterface {

	public List<Cart_details> get_Cart_details(Cart cart) ;
	public boolean deleteCart_detailsByBook(Book book) ;
	public boolean deleteCart_detailsByCart(Cart cart) ;
	public boolean insertCart_details(Cart_details cart_details) ;
	public boolean deleteAllCart_details(Admin admin);
}
