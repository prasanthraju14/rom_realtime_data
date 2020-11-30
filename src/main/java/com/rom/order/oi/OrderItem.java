package com.rom.order.oi;

public class OrderItem {
	private Long productId;
	private Double qty;
	private String fromLocation;
	private String toLocation;
	private String uom;
	private String uomType;
	
	public OrderItem() {
		super();
	}
	
	public OrderItem(Long prodId, Double qty, String fromLoc, String toLoc, String uom, String uomType) {
		super();
		this.productId = prodId;
		this.qty = qty;
		this.fromLocation = fromLoc;
		this.toLocation = toLoc;
		this.uom = uom;
		this.uomType = uomType;
	}
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getUomType() {
		return uomType;
	}

	public void setUomType(String uomType) {
		this.uomType = uomType;
	}
}
	