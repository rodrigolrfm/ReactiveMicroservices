package com.middevs.reactor.client.app.config;

import com.middevs.reactor.client.app.handler.ProductoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routers(ProductoHandler productoHandler){

        return RouterFunctions.route(RequestPredicates.GET("api/client"), productoHandler::listar);
    }


}
