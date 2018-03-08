package com.ZhangShuo.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ZhangShuo.Entity.Admin;
import com.ZhangShuo.Service.Mapper.adminServiceInterface;

@Controller
@RequestMapping("/Admin")
public class adminLoginAction {
	@Autowired
	private Admin admin;
	@Autowired
	private adminServiceInterface adminservice;
	@RequestMapping("/adminlogin")
	public String checkUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		admin = adminservice.getAdmin(username, password);
		if (admin != null) {
			session.setAttribute("admin", admin);
			return "Admin/success";
			
		} else if(session.getAttribute("admin")!=null){
			return "Admin/success";
		}else {
			session.setAttribute("message", "用户名或密码错误");
            return "Admin/login";
		}

	}

}
