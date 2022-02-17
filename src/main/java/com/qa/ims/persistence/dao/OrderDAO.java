package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order>{

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("o.orderId");
//		Long custId = resultSet.getLong("o.fkCustId");
		String surname = resultSet.getString("c.surname");
		String itemName = resultSet.getString("itemName");
		return new Order(orderId, surname, itemName);
	}
	
	
//	public Order modelFromResultSetCustomer(ResultSet resultSet) throws SQLException {
//		Long orderId = resultSet.getLong("orderId");
//		Long custId = resultSet.getLong("fkCustId");
//		String surname = resultSet.getString("surname");
//		return new Order(orderId, custId, surname);
//	}
	
//	public Order modelFromResultSetItem(ResultSet resultSet) throws SQLException {
//		Long orderId = resultSet.getLong("orderId");
//		Long custId = resultSet.getLong("fkCustId");
//		String itemList = resultSet.getString("itemList");
//		resultSet.
//		return new Order(orderId, custId);
//	}


	/**
	 * Reads all orders from the database
	 * 
	 * @return A list of orders
	 */
	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT o.orderId, c.surname, i.itemName\r\n"
						+ "FROM (((orders o \r\n"
						+ "JOIN customers c ON o.fkCustId = c.id )\r\n"
						+ "JOIN orderItems oi ON o.orderId = oi.fkOrderId)\r\n"
						+ "JOIN items i ON oi.fkItemId = i.itemId)\r\n"
						+ "ORDER BY orderId;");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY orderId DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	
	
	/**
	 * Creates a order in the database
	 * 
	 * @param order - takes in a order object. orderId will be ignored
	 */
	@Override
	
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(fkCustId) VALUES (?)");) {
			statement.setLong(1, order.getCustId());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
		
	}


	@Override
	public Order read(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE orderId = ?");) {
			statement.setLong(1, orderId);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a order in the database
	 * 
	 * @param order - takes in a order object, the orderId field will be used to
	 *                 update that order in the database                
	 * @return
	 */
	@Override
	public Order update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orderItems (fkOrderId, fkItemId) \r\n"
								+ "VALUES (?, 1);\r\n"
								+ "UPDATE orderItems\r\n"
								+ "SET fkItemId = (SELECT itemId FROM items WHERE itemName LIKE '?')\r\n"
								+ "WHERE fkOrderId = (SELECT fkOrderId FROM orderItems ORDER BY orderItemId DESC LIMIT 1) "
								+ "ORDER BY orderItemId DESC LIMIT 1;")) {
			statement.setLong(1, order.getOrderId());
			statement.setString(2, order.getItemName());
			statement.executeUpdate();
			return read(order.getOrderId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a order in the database
	 * 
	 * @param orderId - orderId of the order
	 */
	@Override
	public int delete(long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE orderId = ?;")) {
			statement.setLong(1, orderId);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}



}

