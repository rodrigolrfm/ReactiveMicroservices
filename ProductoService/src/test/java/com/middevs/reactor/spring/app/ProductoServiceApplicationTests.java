package com.middevs.reactor.spring.app;

import com.middevs.reactor.spring.app.document.Producto;
import com.middevs.reactor.spring.app.service.ProductoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductoServiceApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	
	@Test
	public void listarTest(){

		webTestClient.get().uri("/api/v2/productos")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(Producto.class);

	}

}
