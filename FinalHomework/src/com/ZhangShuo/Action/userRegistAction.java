package com.ZhangShuo.Action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ZhangShuo.Entity.User;
import com.ZhangShuo.Service.Mapper.userServiceInterface;

@Controller
@Scope("prototype")
@RequestMapping("/User")
public class userRegistAction {
	@Autowired
	private User user;
	@Autowired
	private userServiceInterface userservice;
	@RequestMapping("/userlist")
	public void checkName(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        request.setCharacterEncoding("utf-8");  
        response.setContentType("text/html;charset=utf-8");  
          
        String username = request.getParameter("username");  
        List<User> userlist = userservice.getAllUser();
        for (int i = 0; i <userlist.size(); i++) {
        	 if(userlist.get(i).getUsername().equals(username)) {  
                 response.getWriter().print(true);  
                 return;
             }   
		}
            response.getWriter().print(false);   
    }
	@RequestMapping("/fileupload")
	public void fileupload(HttpServletRequest request,HttpServletResponse response,@RequestParam MultipartFile imagefile) throws IOException, ServletException {
		String realPath = request.getServletContext().getRealPath("/image");
		String originalFilename = "";
		String address = request.getParameter("address");
		if(address.equals("*可选填")) {
			address = "";
		}
			if(!"".equals(imagefile.getOriginalFilename())) {	
					originalFilename = imagefile.getOriginalFilename();
					imagefile.getOriginalFilename();
					byte[] bytes = imagefile.getBytes();
				    File file = new File(realPath+"\\"+originalFilename);
				    FileOutputStream fo = new FileOutputStream(file);
				    fo.write(bytes);
				    fo.flush();
				    fo.close();
					user.setUsername(request.getParameter("username"));
					user.setPassword(request.getParameter("password"));
					user.setAddress(address);
					user.setEmail(request.getParameter("mail"));
					user.setHead_portrait(realPath+"\\"+originalFilename);
					if(userservice.getUser(user.getUsername(), user.getPassword())==null) {
						 if (userservice.register(user)) {
							 request.getSession().setAttribute("user", user);
						}				
					}
				}
			request.getRequestDispatcher("booklist.action").forward(request, response);
	}
}
