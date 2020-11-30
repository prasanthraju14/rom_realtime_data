package com.rom.order;

import java.net.URI;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rom.order.oi.OrderItem;

@Service
public class OrderService {
	final Logger log = LogManager.getLogger(OrderService.class);
	
	@Autowired(required = true)
	private OrderRepository orderRepository;

	public Iterable<Order> getOrders() {
		log.debug("OrderService.getOrders() Fetching List of Order");
		return orderRepository.findAll();
	}
	public Order getOrderById(Long id) {
		log.debug("OrderService.getOrderById() Fetching Order Details of " + id);
		
		try {
		Optional<Order> order = orderRepository.findById(id);
		if (!order.isPresent()) {
			throw new OrderNotFoundException("id = " + id);
		}
		return order.get();
		}
		catch(Exception e) {
			log.error(e.toString());
			return null;
		}
	}
	
	public ResponseEntity<Object> createOrder(Order order) {
		log.debug("OrderService.createOrder() Creating new order, order id = "+order.getId());

		Order savedOrder = orderRepository.save(order);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedOrder.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	public ResponseEntity<Object> createSampleData() {
		log.debug("OrderService.createSampleData() Creating Sample Data.");
		
		Order order = new Order();
		order.addOrderItem(new OrderItem
				(Long.valueOf(1), Double.valueOf(10), "Hyderabad", "Bangalore", "kg", "KG"));

		return createOrder(order);
	}
}