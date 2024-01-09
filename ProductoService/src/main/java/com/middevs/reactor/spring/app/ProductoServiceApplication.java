package com.middevs.reactor.spring.app;

import com.middevs.reactor.spring.app.dao.ProductoDao;
import com.middevs.reactor.spring.app.document.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import reactor.core.publisher.Flux;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductoServiceApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(ProductoServiceApplication.class);

	@Autowired
	private ProductoDao dao;

	public static void main(String[] args) {
		SpringApplication.run(ProductoServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Flux<Producto> productos = Flux.just( new Producto("zapato",13.4,"CH"),
				new Producto("polo",22.0,"tommy"));

		productos.flatMap( producto -> dao.save(producto))
				.subscribe(producto -> log.info(producto.toString()));

	}
}
