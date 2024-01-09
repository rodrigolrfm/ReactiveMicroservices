package com.middevs.reactor.spring.app.dao;


import com.middevs.reactor.spring.app.document.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ProductoDao extends ReactiveMongoRepository<Producto, String> {

    public Mono<Producto> findByNombre(String nombre);

}
