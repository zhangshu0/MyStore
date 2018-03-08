package com.ZhangShuo.Action;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ZhangShuo.Entity.Book;
import com.ZhangShuo.Entity.Cart;
import com.ZhangShuo.Entity.User;
import com.ZhangShuo.Service.Mapper.cartServiceInterface;
import com.ZhangShuo.Service.Mapper.userServiceInterface;

@Controller
@Scope("prototype")
@RequestMapping("/User")
public class userLoginAction {
	@Autowired
	private User user;
	@Autowired
	private userServiceInterface userservice;
	@Autowired
	private cartServiceInterface cartservice;
	@Autowired
	private Cart cart;
	@RequestMapping("/userlogin")
	public void checkUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		user = userservice.getUser(username, password);

		if (user != null) {
			request.getSession().setAttribute("user", user);
			cart = cartservice.getCart(user);
			request.getSession().setAttribute("cart", cart);
			request.getRequestDispatcher("booklist.action").forward(request, response);
			
		} else {
			request.getSession().setAttribute("registMessage", "用户名或密码错误");
			response.sendRedirect("login.jsp");
		}

	}
	@RequestMapping("/quitlogin")
	public void quitLogin(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("cart");
		request.getSession().removeAttribute("details");
		request.getRequestDispatcher("booklist.action").forward(request, response);
	}

}
