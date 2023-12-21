package com.example.fdchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FdChallengeApplication {

//	private static final Logger log = LoggerFactory.getLogger(FdChallengeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FdChallengeApplication.class);
	}
}
/*
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new CustomerDTO("Jack", "Bauer@email", "123456"));
			repository.save(new CustomerDTO("Chloe", "O'Brian@email", "654321"));
			repository.save(new CustomerDTO("Kim", "Bauer@email", "posakjhd"));
			repository.save(new CustomerDTO("David", "Palmer@email", "sdc3524"));
			repository.save(new CustomerDTO("Michelle", "Dessler@email", "dsgfdheu"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
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
			repository.findByName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");
		};
	}
*/