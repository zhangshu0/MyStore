package com.ZhangShuo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ZhangShuo.Dao.Mapper.book_TypeDaoInterface;
import com.ZhangShuo.Entity.Book_Type;
import com.ZhangShuo.Service.Mapper.book_TypeServiceInterface;


@Service
@Transactional
public class book_TypeServiceImpl implements book_TypeServiceInterface{
	@Autowired
	private book_TypeDaoInterface book_typeDao;
	
	public List<Book_Type> getAllBook_Type() {
		List<Book_Type> list = book_typeDao.getAllBook_Type();
		return list;
	}
	public Book_Type getBook_Type(int b_id) {
		return book_typeDao.getBook_Type(b_id);
	}
	public boolean insert(Book_Type book) {
		return book_typeDao.insert(book);
	}
	public boolean delete(Book_Type book) {
		return book_typeDao.delete(book);
	}
	public boolean update(Book_Type book) {
		return book_typeDao.update(book);
	}
	public String getName(Book_Type bt) {
		return book_typeDao.getName(bt);
	}
}
