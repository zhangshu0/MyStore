package com.ZhangShuo.Action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ZhangShuo.Entity.Book;
import com.ZhangShuo.Entity.Cart;
import com.ZhangShuo.Entity.Cart_details;
import com.ZhangShuo.Entity.User;
import com.ZhangShuo.Service.Mapper.cartServiceInterface;
import com.ZhangShuo.Service.Mapper.cart_DetailsServiceInterface;

@Controller
@Scope("prototype")
@RequestMapping("/User")
public class userOpSaveCartAction {
	@Autowired
	private cartServiceInterface cartservice;
	@Autowired
	private Cart cart;
	@Autowired
	private Cart_details cart_details;
	@Autowired
	private cart_DetailsServiceInterface cart_detailsservice;
	private HashMap<Book, Integer> details;// 商品业务逻辑类对象
	private static int size = -1;

	@RequestMapping("/saveCart")
	public String saveCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		cartservice.deleteCartByUsers(user);
		cart.setUser(user);
		cart.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		cartservice.insertCart(cart);
		details = (HashMap<Book, Integer>) session.getAttribute("details");
		if (!details.isEmpty() && size != details.size()) {
			Iterator it = details.keySet().iterator();
			while (it.hasNext()) {
				Book book = (Book) it.next();
				cart_details.setBook(book);
				cart_details.setCart(cart);
				cart_details.setNumber(details.get(book));
				cart_detailsservice.insertCart_details(cart_details);
			}
			size = details.size();
			return "User/savesuccess";
		} else {
			return "User/savesuccess";
		}
	}
}
