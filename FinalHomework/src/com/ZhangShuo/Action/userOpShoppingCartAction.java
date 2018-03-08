package com.ZhangShuo.Action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
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
import com.ZhangShuo.Service.Mapper.bookServiceInterface;
import com.ZhangShuo.Service.Mapper.cartServiceInterface;
import com.ZhangShuo.Service.Mapper.cart_DetailsServiceInterface;

@Controller
@Scope("prototype")
@RequestMapping("/User")
public class userOpShoppingCartAction {
	private String action;// 表示购物车动作：add,show,delete
	private HashMap<Book, Integer> details;// 商品业务逻辑类对象
	@Autowired
	private cartServiceInterface cartservice;
	@Autowired
	private cart_DetailsServiceInterface cds;// 操作购物车类的对象
	@Autowired
	private Cart cart;
	@Autowired
	private bookServiceInterface bookservice;
	private String reaction = "";
	private String rebookid = "";

	public userOpShoppingCartAction() {
		super();
		// TODO Auto-generated constructor stub
		
	}

	@RequestMapping("/Cart")
	public String add(HttpServletRequest request) throws ServletException, IOException, SQLException {
		synchronized (this) {
			request.setCharacterEncoding("utf-8");
			return JudgeRequestType(request);
		}
	}

	public String JudgeRequestType(HttpServletRequest request) {
		if (request.getParameter("action") != null) {
			if (request.getParameter("action").equals("show")) {
				return showCart(request);
			} else if (reaction.equals(request.getParameter("action"))
					&& rebookid.equals(request.getParameter("book_id"))) {
				return showCart(request);
			} else if (request.getParameter("action").equals("deleteAll")) {
				if (deleteAll(request)) {
					return showCart(request);
				}
			} else {
				this.action = request.getParameter("action");
				reaction = action;
				rebookid = request.getParameter("book_id");
				// 添加商品进购物车
				if (action.equals("add")) {
					if (request.getSession().getAttribute("user") == null) {
						request.getSession().setAttribute("registMessage", "请先登录");
						return "User/login";
					} else if (addToCart(request)) {
						return showCart(request);
					}
				} else if (action.equals("delete")) {
					if (deleteFromCart(request)) {
						return showCart(request);
					}
				}
			}
		}
		return action;
	}

	private boolean deleteAll(HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			details = (HashMap<Book, Integer>) request.getSession().getAttribute("details");
			Iterator it = details.keySet().iterator();
			while (it.hasNext()) {
				Book book = (Book) it.next();
				it.remove();
			}
			request.getSession().setAttribute("details", details);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			return false;
		}
	}

	// 添加商品进购物车的方法
	private boolean addToCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		Book book = bookservice.getBook(book_id);
		int book_number = Integer.parseInt(request.getParameter("number"));
		details = (HashMap<Book, Integer>) session.getAttribute("details");
		if (details == null) {
			details = new HashMap<Book, Integer>();
			cart = cartservice.getCart(user);
			List<Cart_details> cd = cds.get_Cart_details(cart);
			for (int j = 0; j < cd.size(); j++) {
				Book book1 = cds.get_Cart_details(cart).get(j).getBook();
				int number1 = cds.get_Cart_details(cart).get(j).getNumber();
				details.put(book1, number1);
			}
			details.put(book, book_number);
		} else {
			details = (HashMap<Book, Integer>) session.getAttribute("details");
			if (ifContains(details, book_id)) {
					Iterator it = details.keySet().iterator();
					while (it.hasNext()) {
						Book b = (Book) it.next();
						if (b.getBook_id() == book_id) {
							details.put(b, details.get(b) + 1);
						}
					}
				} else {
					details.put(book, book_number);
				}
		}
		session.setAttribute("details", details);		
		return true;
	}

	// 从购物车中删除商品
	private boolean deleteFromCart(HttpServletRequest request) {
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		details = (HashMap<Book, Integer>) request.getSession().getAttribute("details");
		if (details != null) {
			Iterator it = details.keySet().iterator();
			while (it.hasNext()) {
				Book book = (Book) it.next();
				if (book.getBook_id() == book_id) {
					it.remove();
				}
			}
			request.getSession().setAttribute("details", details);
			return true;
		} else {
			return false;
		}
	}

	private String showCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String a = request.getParameter("action");
		User user = (User) session.getAttribute("user");
		details = (HashMap<Book, Integer>) session.getAttribute("details");
		if(details==null&&user==null) {
			details = new HashMap<Book, Integer>();
		}else if(details==null&&user!=null){
			details = new HashMap<Book, Integer>();
		}
		if (details.isEmpty()&&user!=null&&a.equals("show")) {
			cart = cartservice.getCart(user);
			List<Cart_details> list = cds.get_Cart_details(cart);
			for (int j = 0; j < list.size(); j++) {
				Cart_details cd = list.get(j);
				Book book = cd.getBook();
				int number = cd.getNumber();
				details.put(book, number);
			}
		}
		session.setAttribute("details", details);
		return "User/cart";
	}

	private boolean ifContains(HashMap<Book, Integer> details, int book_id) {
		Iterator it = details.keySet().iterator();
		while (it.hasNext()) {
			Book b = (Book) it.next();
			if (b.getBook_id() == book_id) {
				return true;
			}
		}
		return false;
	}
}
