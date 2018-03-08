package com.ZhangShuo.Service.Mapper;

import java.sql.SQLException;
import java.util.List;

import com.ZhangShuo.Entity.Book;
import com.ZhangShuo.Entity.Book_Type;
import com.ZhangShuo.Entity.Page;

public interface bookServiceInterface {
	public List<Book> getAllBook() ;
	public Book getBook(int b_id);
	public List<Book> getSomeBook(Page page) throws SQLException;
	public int getCount();
	public boolean insert(Book book);
	public boolean delete(Book book);
	public boolean update(Book book);
	public String getName(Book_Type bt);
}
