package com.qa.ims.persistence.domain;

import java.util.ArrayList;

public class Order {

	private Long orderId;
	private Long custId;
	private ArrayList<Item> itemList;
		
	public Order(Long custId) { // , ArrayList<Item> itemList
		this.setCustId(custId);
	
	}
	
	public Order(Long custId, ArrayList<Item> itemList) { // , ArrayList<Item> itemList
		this.setCustId(custId);
		this.setItemList(itemList);
	
	}
	
	public Order(ArrayList<Item> itemList) { // , ArrayList<Item> itemList
		this.setItemList(itemList);
	
	}

	public Order(Long orderId, Long custId) { // String itemName
		this.setOrderId(orderId);
		this.setCustId(custId);
	
	}

	public Order(Long orderId, Long custId, ArrayList<Item> itemList) { // String itemName
		this.setOrderId(orderId);
		this.setCustId(custId);
		this.setItemList(itemList);

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

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "order ID: " + orderId + " customer ID: " + custId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((itemList == null) ? 0 : itemList.hashCode());

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
		if (itemList == null) {
			if (other.itemList != null)
				return false;
		} else if (!itemList.equals(other.itemList))
			return false;
		return true;
	}

}
