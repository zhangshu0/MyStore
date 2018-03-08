package com.ZhangShuo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "book_type")
public class Book_Type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "types_id")	
	private int types_id;
	@Column(name = "types_name")
	private String types_name;

	public Book_Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTypes_id() {
		return types_id;
	}

	public void setTypes_id(int types_id) {
		this.types_id = types_id;
	}

	public String getTypes_name() {
		return types_name;
	}

	public void setTypes_name(String types_name) {
		this.types_name = types_name;
	}
}
