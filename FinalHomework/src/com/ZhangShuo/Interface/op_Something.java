package com.ZhangShuo.Interface;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface op_Something {
	public String showList(HttpServletRequest request, Model model)throws SQLException, UnsupportedEncodingException;
	public String add(HttpServletRequest request, Model model)throws SQLException, UnsupportedEncodingException;
	public String delete(HttpServletRequest request, Model model)throws SQLException, UnsupportedEncodingException;
	public String update(HttpServletRequest request, Model model)throws SQLException, UnsupportedEncodingException;
}
