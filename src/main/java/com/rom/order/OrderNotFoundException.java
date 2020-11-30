package com.rom.order;

public class OrderNotFoundException extends RuntimeException {

	public OrderNotFoundException(String exception) {
		super(exception);
	}
}