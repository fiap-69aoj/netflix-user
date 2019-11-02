package com.netflix.netflixuser.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 31/10/2019 13:35
 */
public class TokenAuthenticationService {

    static final String SECRET = "FIAP_69AOJ_MY_SECRETS";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            final Claims jwtClaims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();

            if (jwtClaims.getSubject() != null) {
                final String roles = jwtClaims.get("roles", String.class);
                final List<SimpleGrantedAuthority> autoritiesRoles = Stream.of(roles.split(","))
                        .map(r -> new SimpleGrantedAuthority(r)).collect(Collectors.toList());
                return new UsernamePasswordAuthenticationToken(jwtClaims.getSubject(), null, autoritiesRoles);
            }
        }
        return null;
    }

}
