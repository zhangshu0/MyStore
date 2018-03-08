package com.ZhangShuo.Service.Mapper;

import java.util.List;

import com.ZhangShuo.Entity.Book_Type;

public interface book_TypeServiceInterface {
	public List<Book_Type> getAllBook_Type();
	public Book_Type getBook_Type(int b_id);
	public boolean insert(Book_Type book) ;
	public boolean delete(Book_Type book);
	public boolean update(Book_Type book) ;
	public String getName(Book_Type bt) ;
}
