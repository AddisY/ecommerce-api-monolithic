package com.addisy.ecommerceapi.store.domian;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import com.addisy.ecommerceapi.shipment.domain.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CartItem implements Serializable{

	private static final long serialVersionUID = -189412481L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int quantity;
	private BigDecimal subtotal;

	@OneToOne
	private Item item;

	@ManyToOne
	@JoinColumn(name="shopping_cart_id")
	@JsonIgnore
	private ShoppingCart shoppingCart;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	@JsonIgnore
	private Order order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}

