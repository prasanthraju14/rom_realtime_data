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

	public Iterable<CustomerOrder> getOrders() {
		log.debug("OrderService.getOrders() Fetching List of CustomerOrder");
		return orderRepository.findAll();
	}

	public CustomerOrder getOrderById(Long id) {
		log.debug("OrderService.getOrderById() Fetching CustomerOrder Details of " + id);

			Optional<CustomerOrder> order = orderRepository.findById(id);
			if (!order.isPresent()) {
				throw new OrderNotFoundException("id = " + id);
			}
			return order.get();
	}

	public ResponseEntity<Object> createOrder(CustomerOrder order) {
		log.debug("OrderService.createOrder() Creating new order, order id = " + order.getId());

		CustomerOrder savedOrder = orderRepository.save(order);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedOrder.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	public ResponseEntity<Object> createSampleData() {
		log.debug("OrderService.createSampleData() Creating Sample Data.");

		CustomerOrder order = new CustomerOrder();
		order.addOrderItem(
				new OrderItem(Long.valueOf(10001), Double.valueOf(10), "Hyderabad", "Bangalore", "kg", "KG"));
		order.addOrderItem(
				new OrderItem(Long.valueOf(10002), Double.valueOf(12345787), "Delhi", "Agara", "Piece", "No"));
		order.addOrderItem(
				new OrderItem(Long.valueOf(10005), Double.valueOf(9876876), "Mangalore", "Vijayawada", "Dozen", "DZ"));
		return createOrder(order);
	}
}