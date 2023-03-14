package com.george.accounts.Accounts;

import com.george.accounts.entity.Customer;
import com.george.accounts.repository.AccountsRepository;
import com.george.accounts.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Optional;

@SpringBootTest
class AccountsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private AccountsRepository accountsRepository;

	@Autowired
	private CustomerRepository customerRepository;


	@Test
	public void testSample()
	{
		Customer customer = new Customer();
		customer.setCustomerId(2);
		customer.setName("George");
		customer.setEmail("Abhilash.george@gbst.com");
		customer.setCreateDt(new Date(2022,10,10).toLocalDate());
		customer.setMobileNumber("98175495");
		customerRepository.save(customer);
		Optional<Customer> customer1=customerRepository.findById(2L);
		System.out.println("Recieved"+customer1);


	}


}
