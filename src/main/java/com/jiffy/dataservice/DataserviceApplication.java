package com.jiffy.dataservice;

import com.jiffy.dataservice.entity.Customer;
import com.jiffy.dataservice.repository.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class DataserviceApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DataserviceApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(DataserviceApplication.class);

	@Bean
	public CommandLineRunner demo(CustomerRepo repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Shah", "Rukh"));
			repository.save(new Customer("Ben", "Kingsley"));
			repository.save(new Customer("Tom", "Cruise"));
			repository.save(new Customer("Bret", "Lee"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Lee").forEach(lee -> {
				log.info(lee.toString());
			});

			log.info("");
		};
	}

}
