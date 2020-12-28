package com.addisy.ecommerceapi.shipment.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.addisy.ecommerceapi.payment.domain.OrderShippingAddress;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Shipment implements Serializable{

	private static final long serialVersionUID = 2345L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date departureDate;
	private Date arrivalDate;
	private String shippingStatus;

	@OneToOne(cascade=CascadeType.ALL)
	private OrderShippingAddress OrderShippingAddress;

	@OneToOne
	@JsonIgnore
	private Order order;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}


	public OrderShippingAddress getOrderShippingAddress() {
		return OrderShippingAddress;
	}

	public void setOrderShippingAddress(OrderShippingAddress OrderShippingAddress) {
		this.OrderShippingAddress = OrderShippingAddress;
	}


	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
