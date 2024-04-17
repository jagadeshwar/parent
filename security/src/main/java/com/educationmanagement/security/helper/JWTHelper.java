package com.educationmanagement.security.helper;

import com.educationmanagement.common.exception.ApplicationException;
import com.educationmanagement.common.user.model.UserDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.Base64;

@Component
public class JWTHelper {

    public static final String BEARER_PREFIX = "Bearer ";

    public UserDetails parseToken(String token) {
        String[] parts = token.split("\\.");
        try {
            if (parts.length >= 2) {
                String payload = decodeBase64(parts[1]);
                return new ObjectMapper().readValue(payload, UserDetails.class);
            } else {
                throw new ParseException("JWT format is invalid", 500);
            }
        } catch (Exception e) {
            throw new ApplicationException(HttpStatus.UNAUTHORIZED, "invalid token", null, null, null);
        }
    }

    public String decodeBase64(String base64EncodedString) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64EncodedString.getBytes());
        return new String(decodedBytes);
    }

    public UserDetails parseAuthToken(String token) {
        String jwt = cleanJwtToken(token);
        return parseToken(jwt);
    }

    public String cleanJwtToken(String token) {
        if (StringUtils.hasText(token) && token.startsWith(BEARER_PREFIX)) {
            return token.substring(BEARER_PREFIX.length());
        }
        throw new ApplicationException(HttpStatus.UNAUTHORIZED, "token not valid", null, null, null);
    }
}
