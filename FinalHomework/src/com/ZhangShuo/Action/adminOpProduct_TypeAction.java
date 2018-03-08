package com.ZhangShuo.Action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ZhangShuo.Entity.Book_Type;
import com.ZhangShuo.Interface.op_Something;
import com.ZhangShuo.Service.Mapper.book_TypeServiceInterface;

@Controller
@RequestMapping("/Admin")
public class adminOpProduct_TypeAction implements op_Something {
	@Autowired
	private book_TypeServiceInterface book_typeservice;
	@Autowired
	private Book_Type book_type;

	@RequestMapping("/showProduct_Type")
	public String showList(HttpServletRequest request, Model model) throws SQLException, UnsupportedEncodingException {
		model.addAttribute("Type_sublist", book_typeservice.getAllBook_Type());
		return "Admin/op_Product/book_Typelist";
	}

	@RequestMapping("/addProduct_Type")
	public String add(HttpServletRequest request, Model model) throws UnsupportedEncodingException, SQLException {
		String types_name = request.getParameter("types_name");
		book_type.setTypes_name(types_name);

		if (book_typeservice.insert(book_type)) {
			model.addAttribute("msg", "添加成功");

		} else {
			return op_Failed();
		}
		return showList(request, model);
	}

	@RequestMapping("/deleteProduct_Type")
	public String delete(HttpServletRequest request, Model model) throws SQLException, UnsupportedEncodingException {
		int types_id = Integer.parseInt(request.getParameter("types_id"));

		if (book_typeservice.delete(book_typeservice.getBook_Type(types_id))) {
			model.addAttribute("msg", "删除成功");

		} else {
			return op_Failed();
		}
		return showList(request, model);
	}

	@RequestMapping("/updateProduct_Type")
	public String update(HttpServletRequest request, Model model) throws UnsupportedEncodingException, SQLException {
		int types_id = Integer.parseInt(request.getParameter("types_id"));
		String types_name = request.getParameter("types_name");

		book_type.setTypes_id(types_id);
		book_type.setTypes_name(types_name);
		if (book_typeservice.update(book_type)) {
			model.addAttribute("msg", "更新成功");

		} else {
			return op_Failed();
		}
		return showList(request, model);

	}

	@RequestMapping("/ToupdateProduct_Type")
	public String ToupdateProduct(HttpServletRequest request, Model model) {
		String types_id = request.getParameter("types_id");
		String types_name = request.getParameter("types_name");
		model.addAttribute("types_id", types_id);
		model.addAttribute("types_name", types_name);
		return "Admin/op_Product/updateProduct_Type";
	}

	private String op_Failed() {
		return "Admin/failure";
	}
}
