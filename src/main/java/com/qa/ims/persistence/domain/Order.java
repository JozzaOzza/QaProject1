package com.qa.ims.persistence.domain;

public class Order {

	private Long orderId;
	private Long custId;
	private String itemName;
	private String surname;
	private Double orderCost;
		
	public Order(Long orderId) { // , ArrayList<Item> itemList
		this.setOrderId(orderId);
	
	}
	
//	public Order(Long custId, ArrayList<Item> itemList) { // , ArrayList<Item> itemList
//		this.setCustId(custId);
//		this.setItemList(itemList);
//	
//	}
//	
//	public Order(ArrayList<Item> itemList) { // , ArrayList<Item> itemList
//		this.setItemList(itemList);
//	
//	}

	public Order(Long orderId, String surname, Double orderCost) { // String itemName
		this.setOrderId(orderId);
//		this.setCustId(custId);
		this.setSurname(surname);
//		this.setItemName(itemName);
		this.setOrderCost(orderCost);
	
	}

	public Order(Long orderId, String itemName) { // String itemName
		this.setOrderId(orderId);
		this.setItemName(itemName);

	}
	
	public Order(Long orderId, Long custId) { // String itemName
		this.setOrderId(orderId);
		this.setCustId(custId);

	}
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Double getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(Double orderCost) {
		this.orderCost = orderCost;
	}

	@Override
	public String toString() {
		return "Order ID: " + orderId + "  Surname: " + surname + "  Order cost: " + orderCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((orderCost == null) ? 0 : orderCost.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (getCustId() == null) {
			if (other.getCustId() != null)
				return false;
		} else if (!getCustId().equals(other.getCustId()))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (orderCost == null) {
			if (other.orderCost != null)
				return false;
		} else if (!orderCost.equals(other.orderCost))
			return false;
		return true;
	}

}
