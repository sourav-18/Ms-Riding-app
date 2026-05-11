package com.ms.api_gateway.filters;

import com.ms.api_gateway.services.JwtService;
import io.jsonwebtoken.Claims;
import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class JwtValidationGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {

    @Autowired
    private JwtService jwtService;

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            String token = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
            if (token == null || !token.startsWith("Bearer ")) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
            token = token.replace("Bearer", "");
            if (token.isEmpty()) {
                return exchange.getResponse().setComplete();
            }
            Claims claims = jwtService.verifySignatureAdnExtractAllClaims(token);
            if(claims==null){
                exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
                return exchange.getResponse().setComplete();
            }
            ServerHttpRequest request = exchange.getRequest()
                    .mutate()
                    .header("user-id", claims.getSubject())
                    .build();
            return chain.filter(exchange.mutate().request(request).build());
        };
    }
}
