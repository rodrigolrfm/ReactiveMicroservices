package com.middevs.reactor.spring.app.config;


import com.middevs.reactor.spring.app.handler.ProductoHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterFunctionConfig {

    public RouterFunction<ServerResponse> routes(ProductoHandler productoHandler){

        return RouterFunctions.route(GET("/api/v2/productos").or(GET("/api/v3/productos")),productoHandler::listar)
                .andRoute(POST("/api/v2/productos"), productoHandler::crearProducto);

    }


}
