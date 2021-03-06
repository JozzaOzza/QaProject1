package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.DBUtils;

public class CustomerDAOTest {

	private final CustomerDAO DAO = new CustomerDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/IMS-testing.sql");
	}

	@Test
	public void testCreate() {
		final Customer created = new Customer(3L, "Jamie", "Orr");
		assertEquals(created, DAO.create(created));
	}
	

	@Test
	public void testReadAll() {
		List<Customer> expected = new ArrayList<>();
		expected.add(new Customer(2L, "Lane", "O'connor"));
		expected.add(new Customer(1L, "Lucian", "Shelton"));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Customer(2L, "Lane", "O'connor"), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Customer(ID, "Lucian", "Shelton"), DAO.read(ID));
	}
	
	@Test
	public void testReadFailure() {
		assertEquals(null, DAO.read(4L));
	}

	@Test
	public void testUpdate() {
		final Customer updated = new Customer(1L, "Bobby", "Orr");
		assertEquals(updated, DAO.update(updated));

	}
	
	@Test
	public void testUpdateFailure() {
		final Customer updated = new Customer(4L, "Bobby", "Orr");
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
