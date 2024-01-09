package com.middevs.reactor.spring.app.service;


import com.middevs.reactor.spring.app.dao.ProductoDao;
import com.middevs.reactor.spring.app.document.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoDao productoDao;

    @Override
    public Flux<Producto> findAll() {
        return productoDao.findAll();
    }

    @Override
    public Mono<Producto> findById(String id) {
        return productoDao.findById(id);
    }

    @Override
    public Mono<Producto> save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public Mono<Void> delete(Producto producto) {
        return productoDao.delete(producto);
    }

    @Override
    public Mono<Producto> findByNombre(String nombre) {
        return productoDao.findByNombre(nombre);
    }
}
