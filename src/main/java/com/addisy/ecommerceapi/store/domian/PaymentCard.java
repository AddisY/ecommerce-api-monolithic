package com.addisy.ecommerceapi.store.domian;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.addisy.ecommerceapi.payment.domain.OrderPayment;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PaymentCard implements Serializable {

	private static final long serialVersionUID = 87889L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String holderName;
	private String cardName;
	private String cardNumber;

	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;

	@OneToOne(cascade=CascadeType.ALL, mappedBy = "paymentCard")
	@JsonIgnore
	private OrderPayment orderPayment;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderPayment getOrderPayment() {
		return orderPayment;
	}

	public void setOrderPayment(OrderPayment orderPayment) {
		this.orderPayment = orderPayment;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
