package com.rom.simulator;

import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rom.order.CustomerOrder;
import com.rom.order.oi.OrderItem;

@Service
public class ROMSimulatorService {
	final Logger log = LogManager.getLogger(ROMSimulatorService.class);

	@Value("${myapp.rom.createorder.endpoint}")
	private String createOrderEndPoint;

	public void simulate(Long times) {
		log.debug("ROMSimulatorService.simulate() No. of orders to be simulated : " + times);
		
		for(int i=0;i<times;++i) {
			simulateCreateOrder(i);
		}
	}
	
	private void simulateCreateOrder(int index) {
		log.debug("ROMSimulatorService.simulateCreateOrder() create order : " + index);

		CustomerOrder order = new CustomerOrder();
		order.addOrderItem(new OrderItem(Long.valueOf(10001), Double.valueOf(10), "Hyderabad", "Bangalore", "kg", "KG"));
		order.addOrderItem(new OrderItem(Long.valueOf(10002), Double.valueOf(12345787), "Delhi", "Agra", "Piece", "No"));
		order.addOrderItem(new OrderItem(Long.valueOf(10005), Double.valueOf(9876876), "Mangalore", "Vijayawada", "Dozen", "DZ"));

		String urlString = createOrderEndPoint;
		String endpoint = "";
		try {
			URL url = new URL(urlString);
			endpoint = url.toString();

			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpPost request = new HttpPost(endpoint);
			StringEntity params = new StringEntity(mapToJson(order));
			request.addHeader("content-type", "application/json");
			request.setEntity(params);
			HttpResponse response = httpClient.execute(request);
		} catch (Exception e) {
			log.error("ROMSimulatorService.simulateCreateOrder()" + e.getMessage());
		}
	}

	private static final String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}
}
