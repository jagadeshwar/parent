package com.educationmanagement.security.filter;

import com.auth0.jwk.Jwk;
import com.auth0.jwk.UrlJwkProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.educationmanagement.common.exception.ApplicationException;
import com.educationmanagement.common.user.model.UserDetails;
import com.educationmanagement.security.config.AuthConfig;
import com.educationmanagement.security.helper.JWTHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.security.interfaces.RSAPublicKey;


@Component
@RequiredArgsConstructor
@Slf4j
public class SecurityTokenValidator {

  private final UrlJwkProvider urlJwkProvider;

  private final AuthConfig authConfig;

  private final JWTHelper jwtHelper;

  public Mono<UserDetails> validateAndParseToken(String token) {
    return validateAuthRequest(token)
            .then(Mono.defer(() -> Mono.just(parseToken(token))));
  }

  public UserDetails parseToken(String token) {
    try {
      return jwtHelper.parseAuthToken(token);
    } catch (Exception e) {
      throw new ApplicationException(HttpStatus.UNAUTHORIZED, "invalid token", null, null, null);
    }
  }

  private Mono<Void> validateAuthRequest(String token) {
    token = StringUtils.removeStart(token, "Bearer ");
    try {
      if(authConfig.isAuthEnabled()){
        DecodedJWT jwt = JWT.decode(token);
        String kid = jwt.getKeyId();
        Jwk jwk = urlJwkProvider.get(kid);
        Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) jwk.getPublicKey(), null);
        algorithm.verify(jwt);
        JWTVerifier verifier = JWT.require(algorithm).build();
        verifier.verify(token);
      }
    } catch (TokenExpiredException e) {
      return Mono.error(
          new ApplicationException(
              HttpStatus.UNAUTHORIZED, "Security token has expired on " + e.getExpiredOn(),null, null, null));
    } catch (SignatureVerificationException e) {
      return Mono.error(new ApplicationException(
          HttpStatus.UNAUTHORIZED, "Invalid security token: " + e, null, null, null));
    } catch (JWTVerificationException e) {
      return Mono.error(
          new ApplicationException(
              HttpStatus.UNAUTHORIZED, "JWT security token validation failed: " + e, null, null, null));
    } catch (Exception e) {
      return Mono.error(new ApplicationException(
          HttpStatus.UNAUTHORIZED, "Security token validation failed: " + e, null, null, null));
    }
    return Mono.empty();
  }


}
