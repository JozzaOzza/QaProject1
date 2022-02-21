package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO DAO = new OrderDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/IMS-testing.sql");
	}

	@Test
	public void testCreate() {
		final Order created = new Order(3L, null, null);
		assertEquals(created, DAO.create(new Order(1L)));
	}

	@Test
	public void testCreateFailure() {
		assertEquals(null, DAO.create(new Order(4L)));
	}
	
	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, "Shelton", 25D));
		expected.add(new Order(2L, "O'connor", 50D));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Order(2L, null, null), DAO.readLatest());
	}
	
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Order(ID, null, null), DAO.read(ID));
	}
	
	@Test
	public void testReadFailure() {
		assertEquals(null, DAO.read(4L));
	}

	@Test
	public void testUpdate() {
		final Order updated = new Order(1L, "Rocket League", 30D);
		assertEquals(updated, DAO.update(new Order(1L, "Rocket League")));

	}
	
	@Test
	public void testUpdateFailure() {
		final Order updated = null;
		assertEquals(updated, DAO.update(new Order(4L, "Rocket League")));

	}

	@Test
	public void testDelete() {
		assertEquals(1L, DAO.delete(1L));
	}
	
	@Test
	public void testDeleteFailure() {
		assertEquals(0, DAO.delete(4L));
	}
	
	@Test
	public void testRemove() {
		assertEquals(new Order(1L, null, null), DAO.removeItem(new Order(1L, "Rocket League")));
	}
	
	@Test
	public void testRemoveFailure() {
		assertEquals(null, DAO.removeItem(new Order(4L, "Modern Warfare")));
	}
}
