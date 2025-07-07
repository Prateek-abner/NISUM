package com.example.demo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "mySecretKey1234567890abcdef1234567890abcdef";

    public UserDetails validateToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        String username = claims.getSubject();
        return new User(username, "", Collections.emptyList());
    }
}
