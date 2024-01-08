package com.example.demo;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	MongoClient client = MongoClients.create("mongodb+srv://dilumi:dilumi@cluster0.e8cs4.mongodb.net/?retryWrites=true&w=majority\n" + "}");

	MongoDatabase db = client.getDatabase("Customerdb");

	MongoCollection col = db.getCollection("Customercollection");

	@Bean
	CommandLineRunner runner(CustomerRepository repository){
		return args -> {
			Customer customer = new Customer("Anne","Anne@gmail.com","female");
			repository.insert(customer);
		};

	}


}

