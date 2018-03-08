package com.ZhangShuo.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ZhangShuo.Entity.User;
import com.ZhangShuo.Service.Mapper.userServiceInterface;


@Controller
@RequestMapping("/User")
public class userChangePasswordAction {
	@Autowired
	private userServiceInterface userservice;
	
	@RequestMapping("/changePassword")
	public void changePassword(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		String password = request.getParameter("repassword");
		user.setPassword(password);
		if(userservice.update(user)) {
			request.setAttribute("registMessage", "密码修改成功");
			
		}else {
			request.setAttribute("registMessage", "密码修改失败");
		}
		request.getRequestDispatcher("booklist.action").forward(request, response);
	}
	
	
}
