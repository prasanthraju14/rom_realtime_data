package com.rom.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("rom")
@CrossOrigin(origins = "*")
public class OrderController {
	private Logger log = LogManager.getLogger(OrderController.class);

	@Autowired(required = true)
	private OrderService orderService;
	
    @RequestMapping("/")
    String home() {
        return "Hello, this is ROM RESTful services - From Order Controller!! - 8:31 pm 21 Feb 2021 (Sunday) IST";
    }

	@GetMapping("/orders/{id}")
	public CustomerOrder getOrder(@PathVariable Long id) {
		log.debug("OrderController.getOrder() Fetching CustomerOrder Details of " + id);
		return orderService.getOrderById(id);
	}
	
	@GetMapping("/orders")
	public Iterable<CustomerOrder> getOrders() {
		log.debug("OrderController.getOrder() Fetching list of orders");
		return orderService.getOrders();
	}
	
	@PostMapping("/createOrder")
	public ResponseEntity<Object> createOrder(@RequestBody CustomerOrder order) {
		log.debug("OrderController.getOrder() Fetching CustomerOrder Details of " + order.getId());
		return orderService.createOrder(order);
	}
	
	@PostMapping("/createSampleData")
	public ResponseEntity<Object> createSampleData() {
		log.debug("OrderController.createSampleData() Creating sample data.");
		return orderService.createSampleData();
	}
}