package com.middevs.reactor.client.app.service;


import com.middevs.reactor.client.app.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceImpl implements ProducoService{

    @Autowired
    private WebClient webClient;


    @Override
    public Flux<Producto> findAll() {
        return webClient.get().accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMapMany(response -> response.bodyToFlux(Producto.class));
    }

    @Override
    public Mono<Producto> save(Producto producto) {
        return webClient.post().accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(producto))
                .retrieve()
                .bodyToMono(Producto.class);
    }
}
