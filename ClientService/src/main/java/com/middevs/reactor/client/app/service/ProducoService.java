package com.middevs.reactor.client.app.service;

import com.middevs.reactor.client.app.model.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProducoService {

    public Flux<Producto> findAll();

    public Mono<Producto> save(Producto producto);


}
