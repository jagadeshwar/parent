package com.educationmanagement.security.filter;

import com.educationmanagement.common.utils.GlobalConstants;
import com.educationmanagement.security.config.AuthConfig;
import com.educationmanagement.security.helper.WebExchangeHelper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;


@Component
@AllArgsConstructor
@Profile("!test")
@Slf4j
public class SecurityFilter implements WebFilter {

    private final SecurityTokenValidator securityTokenValidator;

    private final AuthConfig authConfig;

    @Autowired
    private WebExchangeHelper webExchangeHelper;

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain chain) {
        if (!authConfig.isAuthEnabled()) {
            return chain.filter(serverWebExchange);
        }
        return parseAuthToken(serverWebExchange).flatMap(token -> securityTokenValidator
                .validateAndParseToken(token).flatMap(userDetails -> {
                serverWebExchange.getAttributes().put(GlobalConstants.AUTHORIZATION, userDetails);
            return Mono.empty();
        }).onErrorResume(e -> {
            log.error("Error while validating token", e);
            return Mono.error(e);
        })).then(chain.filter(serverWebExchange));

    }


    private Mono<String> parseAuthToken(ServerWebExchange serverWebExchange) {
        ServerHttpRequest request = serverWebExchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        List<String> authorizationHeaders = headers.get("Authorization");
        if (CollectionUtils.isEmpty(authorizationHeaders)) {
            return Mono.error(new SecurityException("Authorization header is missing"));
        }
        String authorizationHeader = authorizationHeaders.get(0);
        if (StringUtils.isBlank(authorizationHeader)) {
            return Mono.error(new SecurityException("Authorization header is empty"));
        }
        return Mono.just(authorizationHeader);
    }


}
