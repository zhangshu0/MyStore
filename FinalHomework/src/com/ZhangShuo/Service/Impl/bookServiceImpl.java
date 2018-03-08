package com.ZhangShuo.Service.Impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ZhangShuo.Dao.Mapper.bookDaoInterface;
import com.ZhangShuo.Dao.Mapper.book_TypeDaoInterface;
import com.ZhangShuo.Entity.Book;
import com.ZhangShuo.Entity.Book_Type;
import com.ZhangShuo.Entity.Page;
import com.ZhangShuo.Service.Mapper.bookServiceInterface;


@Service
@Transactional
public class bookServiceImpl implements bookServiceInterface{
	@Autowired
	private bookDaoInterface bookDao;
	@Autowired
	private book_TypeDaoInterface book_typeDao;
	
	public List<Book> getAllBook() {
		List<Book> booklist = bookDao.getAllBook();
		return booklist;
	}
	public Book getBook(int b_id) {
		return bookDao.getBook(b_id);
	}
	public List<Book> getSomeBook(Page page) throws SQLException{
		List<Book> sublist = bookDao.getSomeBook(page);
		return sublist;
	}
	public int getCount() {
		return bookDao.getCount();
	}
	public boolean insert(Book book) {
		return bookDao.insert(book);
	}
	public boolean delete(Book book) {
		return bookDao.delete(book);
	}
	public boolean update(Book book) {
		return bookDao.update(book);
	}
	public String getName(Book_Type bt) {
		return book_typeDao.getName(bt);
	}
}
