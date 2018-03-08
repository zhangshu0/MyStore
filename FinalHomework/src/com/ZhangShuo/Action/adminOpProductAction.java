package com.ZhangShuo.Action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ZhangShuo.Entity.Book;
import com.ZhangShuo.Entity.Book_Type;
import com.ZhangShuo.Entity.Page;
import com.ZhangShuo.Interface.op_Something;
import com.ZhangShuo.Service.Mapper.bookServiceInterface;
import com.ZhangShuo.Service.Mapper.book_TypeServiceInterface;

@Controller
@RequestMapping("/Admin")
public class adminOpProductAction implements op_Something {
	@Autowired
	private bookServiceInterface bookservice;
	@Autowired
	private book_TypeServiceInterface book_typeservice;
	@Autowired
	private Page page;
	@Autowired
	private Book book;

	@RequestMapping("/showProduct")
	public String showList(HttpServletRequest request, Model model) throws SQLException, UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		if (request.getParameter("current_page") != null) {
			page.setCurrent_page(Integer.parseInt(request.getParameter("current_page")));
		} else {
			page.setCurrent_page(1);
		}
		request.getSession().setAttribute("bookTypelist", book_typeservice.getAllBook_Type());
		model.addAttribute("sublist", bookservice.getSomeBook(page));
		model.addAttribute("page", page);
		return "Admin/op_Product/booklist";
	}

	@RequestMapping("/addProduct")
	public String add(HttpServletRequest request, Model model) throws UnsupportedEncodingException, SQLException {
		int type_id = Integer.parseInt(request.getParameter("types_id"));
		String book_name = request.getParameter("book_name");
		String book_publisher = request.getParameter("book_publisher");
		String book_auth = request.getParameter("book_auth");
		float book_price = Float.parseFloat(request.getParameter("book_price"));
		Book_Type bt = book_typeservice.getBook_Type(type_id);
		book.setB_t(bt);
		book.setBook_auth(book_auth);
		book.setBook_name(book_name);
		book.setBook_price(book_price);
		book.setBook_publisher(book_publisher);
		if (bookservice.insert(book)) {
			model.addAttribute("msg", "添加成功");

		} else {
			return op_Failed();
		}
		return showList(request, model);
	}

	@RequestMapping("/deleteProduct")
	public String delete(HttpServletRequest request, Model model) throws SQLException, UnsupportedEncodingException {
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		Book book = bookservice.getBook(book_id);

		if (bookservice.delete(book)) {
			model.addAttribute("msg", "删除成功");

		} else {
			return op_Failed();
		}
		return showList(request, model);
	}

	@RequestMapping("/updateProduct")
	public String update(HttpServletRequest request, Model model) throws UnsupportedEncodingException, SQLException {
		int type_id = Integer.parseInt(request.getParameter("types_id"));
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		String book_name = request.getParameter("book_name");
		String book_publisher = request.getParameter("book_publisher");
		String book_auth = request.getParameter("book_auth");
		float book_price = Float.parseFloat(request.getParameter("book_price"));
		Book_Type bt = book_typeservice.getBook_Type(type_id);
		book.setB_t(bt);
		book.setBook_auth(book_auth);
		book.setBook_name(book_name);
		book.setBook_price(book_price);
		book.setBook_publisher(book_publisher);
		book.setBook_id(book_id);
		if (bookservice.update(book)) {
			model.addAttribute("msg", "更新成功");

		} else {
			return op_Failed();
		}
		return showList(request, model);
	}

	@RequestMapping("/ToupdateProduct")
	public String ToupdateProduct(HttpServletRequest request, Model model) {
		String book_id = request.getParameter("book_id");
		String book_name = request.getParameter("book_name");
		String book_publisher = request.getParameter("book_publisher");
		String book_auth = request.getParameter("book_auth");
		String book_price = request.getParameter("book_price");
		model.addAttribute("book_publisher", book_publisher);
		model.addAttribute("book_id", book_id);
		model.addAttribute("book_name", book_name);
		model.addAttribute("book_price", book_price);
		model.addAttribute("book_auth", book_auth);
		return "Admin/op_Product/updateProduct";
	}

	private String op_Failed() {
		return "Admin/failure";
	}
}
