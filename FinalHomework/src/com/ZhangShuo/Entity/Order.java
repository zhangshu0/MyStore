package com.ZhangShuo.Entity;

import java.util.HashMap;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proxy_id")
	private int proxy_id;
	
	@OneToOne(targetEntity = User.class)
	@JoinColumn(name = "users_id")
	private User user;
	
	@Transient
	private HashMap<Book, Integer> map_details;

	@Column(name = "create_time")
	private String create_time;
	
	@Column(name = "address")
	private String address;

	@Column(name = "price")
	private float totalPrice;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProxy_id() {
		return proxy_id;
	}

	public void setProxy_id(int proxy_id) {
		this.proxy_id = proxy_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public HashMap<Book, Integer> getMap_details() {
		return map_details;
	}

	public void setMap_details(HashMap<Book, Integer> map_details) {
		this.map_details = map_details;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
