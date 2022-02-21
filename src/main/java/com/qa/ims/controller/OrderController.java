package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

/**
 * Takes in order details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	/**
	 * Reads all orders to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}
	
	/**
	 * Creates a order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter the customer ID for which the order will be assigned to");
		Long custID = utils.getLong();
		Order order = orderDAO.create(new Order(custID));
		LOGGER.info("Order created");
		return order;
	}

	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Would you like to ADD an item to an order or REMOVE an item from an order?");
		String option = utils.getOption();
		switch (option.toUpperCase()) {
		case "ADD":
			LOGGER.info("Please enter the ID of the order you want to add to");
			Long orderIdA = utils.getLong();
			LOGGER.info("Please enter the name of the item you want to add");
			String itemNameA = utils.getString();
			Order orderA = orderDAO.update(new Order(orderIdA, itemNameA));
			LOGGER.info("Item added");
			return orderA;
			
		case "REMOVE":
			LOGGER.info("To remove an item, first you must enter a valid Order ID");
			Long orderIdR = utils.getLong();
			LOGGER.info("Please enter an item name to delete that item from the order");
			String itemNameR = utils.getString();
			Order orderR = orderDAO.removeItem(new Order(orderIdR, itemNameR));
			LOGGER.info("Item removed");
			return orderR;
			
		default:
			return null;
		}	
	}
	


	/**
	 * Deletes an existing order by the id of the order
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long orderId = utils.getLong();
		LOGGER.info("Order deleted");
		return orderDAO.delete(orderId);
	}

	

}
