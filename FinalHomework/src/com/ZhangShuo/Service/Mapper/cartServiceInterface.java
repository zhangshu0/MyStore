package com.ZhangShuo.Service.Mapper;

import com.ZhangShuo.Entity.Admin;
import com.ZhangShuo.Entity.Cart;
import com.ZhangShuo.Entity.Cart_details;
import com.ZhangShuo.Entity.User;

public interface cartServiceInterface {
	public boolean insertCart(Cart cart) ;
	public Cart getCart(User user) ;

	public Cart getCart(Cart_details cd);

	public boolean deleteCartByUsers(User user) ;

	public boolean deleteAllCart_details(Admin admin);

	public boolean update(Cart cart) ;
}
