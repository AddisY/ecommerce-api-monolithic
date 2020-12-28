package com.addisy.ecommerceapi.payment.domain;

import java.io.Serializable;

import javax.persistence.*;

import com.addisy.ecommerceapi.store.domian.UserShippingAddress;

@Entity
public class OrderShippingAddress implements Serializable{

	private static final long serialVersionUID = 387419L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	private UserShippingAddress userShippingAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserShippingAddress getUserShippingAddress() {
		return userShippingAddress;
	}

	public void setUserShippingAddress(UserShippingAddress userShippingAddress) {
		this.userShippingAddress = userShippingAddress;
	}


}

