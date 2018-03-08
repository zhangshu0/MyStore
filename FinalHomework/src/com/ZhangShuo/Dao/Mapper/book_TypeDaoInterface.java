package com.ZhangShuo.Dao.Mapper;

import java.util.List;

import com.ZhangShuo.Entity.Book_Type;

public interface book_TypeDaoInterface {
	public String getName(Book_Type bt);
	public List<Book_Type> getAllBook_Type();
	public Book_Type getBook_Type(int book_id);
	public int getCount();
	public boolean insert(Book_Type book_type);
	public boolean delete(Book_Type book_type);
	public boolean update(Book_Type book_type);
}
