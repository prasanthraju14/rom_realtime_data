package com.rom.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.rom.order.oi.OrderItem;

@Entity
@Table(name="Orders")
public class Order {
	@Id
	@GeneratedValue
	private Long id;
	private Date createdAt;

	@PrePersist
	  void createdAt() {
	    this.createdAt = new Date();
	  }
	
	@OneToMany(targetEntity=OrderItem.class)
	private List<OrderItem> orderItemList = new ArrayList<>();
	
	public Order() {
		super();
		this.createdAt();
	}
	
	public Order(Long id, List<OrderItem> orderItemList) {
		super();
		this.id = id;
		this.orderItemList = orderItemList;
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
