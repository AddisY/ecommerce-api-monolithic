package com.addisy.ecommerceapi.shipment.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

import com.addisy.ecommerceapi.payment.domain.OrderPayment;
import com.addisy.ecommerceapi.store.domian.CartItem;
import com.addisy.ecommerceapi.store.domian.User;
import com.addisy.ecommerceapi.shipment.domain.Shipment;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shopping_order")
public class Order implements Serializable{

	private static final long serialVersionUID = 2345L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal totalPrice;

	@OneToMany(mappedBy = "order", cascade=CascadeType.ALL)
	private List<CartItem> cartItemList;

	@OneToOne(cascade=CascadeType.ALL)
	private OrderPayment orderPayment;

	@OneToOne(cascade = CascadeType.ALL)
	private Shipment shipment;

	@ManyToOne
	@JsonIgnore
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}



	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}

	public OrderPayment getOrderPayment() {
		return orderPayment;
	}

	public void setOrderPayment(OrderPayment orderPayment) {
		this.orderPayment = orderPayment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}

