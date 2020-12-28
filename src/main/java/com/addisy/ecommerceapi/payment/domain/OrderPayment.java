package com.addisy.ecommerceapi.payment.domain;

import java.io.Serializable;

import javax.persistence.*;

import com.addisy.ecommerceapi.shipment.domain.Order;
import com.addisy.ecommerceapi.store.domian.PaymentCard;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderPayment implements Serializable{
	private static final long serialVersionUID = 79151235145L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@OneToOne(cascade = CascadeType.ALL)
	private PaymentCard paymentCard;

	@OneToOne(mappedBy = "orderPayment")
	@JsonIgnore
	private Order order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PaymentCard getPaymentCard() {
		return paymentCard;
	}

	public void setPaymentCard(PaymentCard paymentCard) {
		this.paymentCard = paymentCard;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}



}

