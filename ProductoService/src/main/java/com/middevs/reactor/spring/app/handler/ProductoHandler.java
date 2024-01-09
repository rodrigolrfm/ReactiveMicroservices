package com.middevs.reactor.spring.app.handler;

import com.middevs.reactor.spring.app.document.Producto;
import com.middevs.reactor.spring.app.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Date;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
public class ProductoHandler {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private Validator validator;

    public Mono<ServerResponse> listar(ServerRequest request){

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(productoService.findAll(),Producto.class);
    }

    public Mono<ServerResponse> crearProducto(ServerRequest request){
        
        Mono<Producto> producto = request.bodyToMono(Producto.class);

        return producto.flatMap(produc -> {
            Errors errors = new BeanPropertyBindingResult(produc, Producto.class.getName());
            validator.validate(produc, errors);

            if (errors.hasErrors()){
                return Flux.fromIterable(errors.getFieldErrors())
                        .map(fieldError -> "El campo " + fieldError.getField() + " " + fieldError.getDefaultMessage())
                        .collectList()
                        .flatMap(list -> ServerResponse.badRequest().body(fromObject(list)));
            } else {
                if(produc.getTiempoCreacion() ==null) {
                    produc.setTiempoCreacion(new Date());
                }
                return productoService.save(produc).flatMap(pdb -> ServerResponse
                        .created(URI.create("/api/v2/productos/".concat(pdb.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromObject(pdb)));
            }

        });
        
        
    }



}
