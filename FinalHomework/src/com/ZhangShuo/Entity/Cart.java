package com.ZhangShuo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proxy_id")
	private int proxy_id;
	
	@OneToOne(targetEntity = User.class ,cascade=CascadeType.ALL)
	@JoinColumn(name = "users_id")
	private User user;

	@Column(name = "create_time")
	private String create_time;

	@Transient
	private List<Cart_details> cart_details_list;

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

	public List<Cart_details> getCart_details_list() {
		return cart_details_list;
	}

	public void setCart_details_list(List<Cart_details> cart_details_list) {
		this.cart_details_list = cart_details_list;
	}

}
