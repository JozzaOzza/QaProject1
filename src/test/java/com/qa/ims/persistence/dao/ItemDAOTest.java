package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {

	private final ItemDAO DAO = new ItemDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/IMS-testing.sql");
	}

	@Test
	public void testCreate() {
		final Item created = new Item(3L, "Jamie", 90.0);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L, "FIFA 22", 50D));
		expected.add(new Item(2L, "Rocket League", 25D));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Item(2L, "Rocket League", 25D), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Item(ID, "FIFA 22", 50D), DAO.read(ID));
	}
	
	@Test
	public void testReadFailure() {
		assertEquals(null, DAO.read(4L));
	}

	@Test
	public void testUpdate() {
		final Item updated = new Item(1L, "Rocket League", 30D);
		assertEquals(updated, DAO.update(updated));

	}
	
	@Test
	public void testUpdateFailure() {
		final Item updated = new Item(4L, "Rocket League", 30D);
		assertEquals(null, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1L, DAO.delete(1L));
	}
	
	@Test
	public void testDeleteFailure() {
		assertEquals(0, DAO.delete(4L));
	}
}