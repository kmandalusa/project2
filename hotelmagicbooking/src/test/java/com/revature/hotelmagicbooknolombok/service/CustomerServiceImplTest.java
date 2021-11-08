package com.revature.hotelmagicbooknolombok.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.hotelmagicbooknolombok.HotelmagicbooknolombokApplicationTests;
import com.revature.hotelmagicbooknolombok.model.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerServiceImplTest extends HotelmagicbooknolombokApplicationTests {

	@Autowired
	private CustomerService customerService;

	@Test
	@DisplayName("Test for save method")
	@Order(1)
	public void testSave() {
		Customer customer = new Customer("loyed@gmail", "loyed", "Loyed", 5674563009l);
		customerService.save(customer);
		log.info("Test success");
	}

	@Test
	@DisplayName("Test for findByCustomerId method")
	@Order(2)
	public void testfindByCustomerId() {
		Customer customer1 = new Customer("krishna@gmail.com", "kris123", "Krishna", 4425647869l);
		Customer customer2 = customerService.findByCustomerId(customerService.save(customer1).getCustomerId());
		Assertions.assertEquals(customer2.getEmail(), "krishna@gmail.com");
		Assertions.assertEquals(customer2.getPassword(), "kris123");
		Assertions.assertEquals(customer2.getName(), "Krishna");
		Assertions.assertEquals(customer2.getMobile(), 4425647869l);

		log.info(customer2.toString());
	}

	@Test
	@DisplayName("Test for FindAll method")
	@Order(3)
	public void testFindAll() {

		customerService.save(new Customer("abc@gmail.com", "abc123", "abc", 4445556677l));
		customerService.save(new Customer("xyz@gmail.com", "xyz123", "xyz", 2003445677l));
		List<Customer> customers = customerService.findAll();

		Assertions.assertEquals(customers.size() >= 2, true);
		Assertions.assertEquals(customers.size() == 0, false);
	}
	
	@Test
	@DisplayName("Test for Delete method")
	@Order(4)
	public void testDelete() {
		Customer customer1 = customerService.save(new Customer("pqr@gmail.com", "pqr123", "pqr", 5667448000l));
		int id = customer1.getCustomerId();
		customerService.delete(id);
		Assertions.assertNull(customerService.findByCustomerId(id));
	}
}

