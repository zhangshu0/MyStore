package com.ZhangShuo.Action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ZhangShuo.Entity.Page;
import com.ZhangShuo.Service.Mapper.bookServiceInterface;


@Controller
@Scope("prototype")
@RequestMapping("/User")
public class userOpBookListAction {
	@Autowired
	private bookServiceInterface bookservice;
	@Autowired
	private Page page;
	@RequestMapping("/booklist")
	public String showBookList(HttpServletRequest request, Model model)  
            throws ServletException, IOException, SQLException {  
        request.setCharacterEncoding("utf-8");
        if(request.getParameter("current_page")!=null) {
			page.setCurrent_page(Integer.parseInt(request.getParameter("current_page")));
		}else{
			page.setCurrent_page(1);
		}     
        model.addAttribute("sublist", bookservice.getSomeBook(page));
        model.addAttribute("page", page);
        return "User/booklist";
    }
	@RequestMapping("/addCart")
	public String addCart(HttpServletRequest request,Model model,@RequestParam int book_id){
		if(request.getSession().getAttribute("user")!=null) {
			 model.addAttribute("book_id", book_id);
	    	 return "User/showShoppingCart";
		}else {
			request.getSession().setAttribute("registMessage","请先登录");
			return "User/booklist";
		}
    	  
    }
}
