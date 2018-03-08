package com.ZhangShuo.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "cart_details")
public class Cart_details {
	@Id
	@Column(name = "proxy_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int proxy_id;
	
	@OneToOne(targetEntity = Book.class,optional=true)
	@JoinColumn(name = "book_id")
	private Book book;

	@Column(name = "number")
	private int number;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private Cart cart;

	public int getProxy_id() {
		return proxy_id;
	}

	public void setProxy_id(int proxy_id) {
		this.proxy_id = proxy_id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
