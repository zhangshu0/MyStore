package com.ZhangShuo.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name ="book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
		private int book_id;
	@Column(name = "book_name")
		private String book_name;
	@Column(name = "book_auth")
		private String book_auth;
	@Column(name = "book_price")
		private float book_price;
	@Column(name = "book_publisher")
		private String book_publisher;
	
	@ManyToOne
	@JoinColumn(name = "b_t")
		private Book_Type b_t;// types_id
		public Book_Type getB_t() {
		return b_t;
	}

	public void setB_t(Book_Type b_t) {
		this.b_t = b_t;
	}

		public String getBook_publisher() {
			return book_publisher;
		}

		public void setBook_publisher(String book_publisher) {
			this.book_publisher = book_publisher;
		}

		public Book() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Book(Book_Type bt) {
			super();
			this.b_t = bt;
			// TODO Auto-generated constructor stub
		}

		public String getBook_name() {
			return book_name;
		}

		public void setBook_name(String book_name) {
			this.book_name = book_name;
		}

		public String getBook_auth() {
			return book_auth;
		}

		public void setBook_auth(String book_auth) {
			this.book_auth = book_auth;
		}

		public float getBook_price() {
			return book_price;
		}

		public void setBook_price(float book_price) {
			this.book_price = book_price;
		}

		public int getBook_id() {
			return book_id;
		}

		public void setBook_id(int book_id) {
			this.book_id = book_id;
		}

	}
