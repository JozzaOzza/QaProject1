package com.qa.ims.persistence.domain;

import java.util.ArrayList;

public class Order {

	private Long orderId;
	private Customer customer;
	private ArrayList<Item> itemList;
	
	public Order(Customer customer, ArrayList<Item> itemList) {
		this.setCustomer(customer);
		this.setItemList(itemList);
	
	}

	public Order(Long orderId, Customer customer, ArrayList<Item> itemList) {
		this.setOrderId(orderId);
		this.setCustomer(customer);
		this.setItemList(itemList);
	
	}
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList<Item> itemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "order ID:" + orderId + " customer ID:" + customer.getId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer.getId() == null) ? 0 : customer.getId().hashCode());
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
		if (getCustomer() == null) {
			if (other.getCustomer() != null)
				return false;
		} else if (!getCustomer().equals(other.getCustomer()))
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
