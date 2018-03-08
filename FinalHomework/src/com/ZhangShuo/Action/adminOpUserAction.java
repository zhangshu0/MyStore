package com.ZhangShuo.Action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ZhangShuo.Entity.User;
import com.ZhangShuo.Interface.op_Something;
import com.ZhangShuo.Service.Mapper.userServiceInterface;

@Controller
@RequestMapping("/Admin")
public class adminOpUserAction implements op_Something{
	@Autowired
	private userServiceInterface userservice;
	@Autowired
	private User user;
	@RequestMapping("/showUser")
	public String showList(HttpServletRequest request, Model model) {
		model.addAttribute("userlist", userservice.getAllUser());
		return "Admin/op_User/userlist";
	}  

	@Override
	public String add(HttpServletRequest request, Model model) throws SQLException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping("/deleteUser")
	public String delete(HttpServletRequest request, Model model) throws SQLException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		user = userservice.getUser(user_id);

		if (userservice.delete(user)) {
			model.addAttribute("msg", "删除成功");

		} else {
			return op_Failed();
		}
		return showList(request, model);
	}

	@Override
	@RequestMapping("/updateUser")
	public String update(HttpServletRequest request, Model model) throws SQLException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String head_portrait = request.getParameter("head_portrait");
		String address = request.getParameter("address");
		user.setAddress(address);
		user.setEmail(email);
		user.setHead_portrait(head_portrait);
		user.setId(user_id);
		user.setPassword(password);
		user.setUsername(username);
		if (userservice.update(user)) {
			model.addAttribute("msg", "更新成功");

		} else {
			return op_Failed();
		}
		return showList(request, model);
	}
	@RequestMapping("/ToupdateUser")
	public String ToupdateUser(HttpServletRequest request, Model model) {
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String head_portrait = request.getParameter("head_portrait");
		String address = request.getParameter("address");
		model.addAttribute("user_id", user_id);
		model.addAttribute("username", username);
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		model.addAttribute("head_portrait", head_portrait);
		model.addAttribute("address", address);
		return "Admin/op_User/updateUser";
	}
	private String op_Failed() {
		return "Admin/failure";
	}
}
