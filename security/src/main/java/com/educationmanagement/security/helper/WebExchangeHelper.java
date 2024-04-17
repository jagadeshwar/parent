package com.educationmanagement.security.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebExchangeHelper {
    private final ObjectMapper objectMapper;


    public <T> Mono<Void> writeResponse(ServerWebExchange exchange, T object) {
        ServerHttpResponse httpResponse = exchange.getResponse();
        DataBufferFactory bufferFactory = httpResponse.bufferFactory();
        return httpResponse.writeWith(prepareResponse(object, bufferFactory));
    }

    <T> Mono<DataBuffer> prepareResponse(T object, DataBufferFactory bufferFactory) {
        return Mono.fromSupplier(() -> {
            try {
                return bufferFactory.wrap(objectMapper.writeValueAsBytes(object));
            } catch (Exception ex) {
                log.warn("Error writing response", ex);
                return bufferFactory.wrap(new byte[0]);
            }
        });
    }


}
