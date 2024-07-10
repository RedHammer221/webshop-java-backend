package de.oncoding.webshop;

import de.oncoding.webshop.controller.ProductController;
import de.oncoding.webshop.repository.ProductRepository;
import de.oncoding.webshop.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebshopApplication.class, args);
	}

}
