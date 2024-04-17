package com.educationmanagement.security.helper;


import com.educationmanagement.common.exception.ApplicationException;
import com.educationmanagement.common.user.model.UserDetails;
import com.educationmanagement.common.utils.GlobalConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Objects;


@Component
@RequiredArgsConstructor
@Slf4j
public class UserSecurityContext {
    public UserDetails getUserDetails(ServerWebExchange exchange) {
        UserDetails userDetails = exchange.getAttribute(GlobalConstants.AUTHORIZATION);
        if (Objects.isNull(userDetails)) {
            throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, "UserDetails are getting as null", null, null, null);
        }
        return userDetails;
    }
}

