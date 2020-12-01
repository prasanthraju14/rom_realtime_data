package com.rom.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;

import com.rom.order.oi.OrderItem;

@Entity
public class CustomerOrder {
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "ROMCO")
	@SequenceGenerator (name = "ROMCO", sequenceName = "CO_SEQ", allocationSize = 1)
	private Long id;
	private Date createdAt;

	@PrePersist
	  void createdAt() {
	    this.createdAt = new Date();
	  }
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = "id")
	private List<OrderItem> orderItemList = new ArrayList<>();
	
	public CustomerOrder() {
		super();
		this.createdAt();
	}
	
	public CustomerOrder(Long id, List<OrderItem> orderItemList) {
		super();
		this.id = id;
		this.orderItemList = orderItemList;
		this.createdAt();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	
	public void addOrderItem(OrderItem orderItem) {
		orderItemList.add(orderItem);
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
