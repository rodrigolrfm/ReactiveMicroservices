package com.middevs.reactor.spring.app.service;

import com.middevs.reactor.spring.app.document.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {

    public Flux<Producto> findAll();

    public Mono<Producto> findById(String id);

    public Mono<Producto> save(Producto producto);

    public Mono<Void> delete(Producto producto);

    public Mono<Producto> findByNombre(String nombre);

}
